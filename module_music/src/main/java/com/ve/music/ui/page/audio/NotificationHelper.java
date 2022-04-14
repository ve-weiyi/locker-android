package com.ve.music.ui.page.audio;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.ImageView;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.ve.lib_api.model.song.AudioBean;
import com.ve.lib_audio.app.AudioHelper;
import com.ve.lib_audio.mediaplayer.core.AudioController;
import com.ve.lib_image_loader.app.ImageLoaderManager;
import com.ve.music.R;
import com.ve.music.service.MusicService;

public class NotificationHelper {

	public static final String CHANNEL_ID = "channel_id_audio";
	public static final String CHANNEL_NAME = "channel_name_audio";
	public static final int NOTIFICATION_ID = 0x111;

	//最终的Notification显示类
	private Notification mNotification;
	private RemoteViews mBigRemoteViews; // 大布局
	private RemoteViews mSmallRemoteViews; //小布局

	//TODO 取消通知
	private ImageView mCloseView;
	private NotificationManager mNotificationManager;
	private NotificationHelperListener mListener;
	private String packageName;
	//当前要播的歌曲Bean
	private AudioBean mAudioBean;

	public static NotificationHelper getInstance() {
		return SingletonHolder.instance;
	}

	public Notification getNotification() {
		return mNotification;
	}

	public NotificationManager getNotificationManager() {
		return mNotificationManager;
	}

	private static class SingletonHolder {
		private static NotificationHelper instance = new NotificationHelper();
	}


	public void init(NotificationHelperListener listener) {
		mNotificationManager = (NotificationManager) AudioHelper.getContext()
				.getSystemService(Context.NOTIFICATION_SERVICE);
		packageName = AudioHelper.getContext().getPackageName();
		mAudioBean = AudioController.getInstance().getNowPlaying();
		initNotification();
		mListener = listener;
		if (mListener != null) {
			mListener.onNotificationInit();
		}
	}

	private void initNotification() {
		initRemoteViews();

		//再构建Notification
		Intent intent = new Intent(AudioHelper.getContext(), MusicPlayerActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(AudioHelper.getContext(), 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		//适配安卓8.0的消息渠道
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			NotificationChannel channel =
					new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
			channel.enableLights(false);
			channel.enableVibration(false);
			mNotificationManager.createNotificationChannel(channel);
		}
		NotificationCompat.Builder builder =
				new NotificationCompat.Builder(AudioHelper.getContext(), CHANNEL_ID).setContentIntent(pendingIntent)
						.setSmallIcon(R.mipmap.ic_notification)
						.setCustomBigContentView(mBigRemoteViews) //大布局
						.setContent(mSmallRemoteViews); //正常布局，两个布局可以切换
		mNotification = builder.build();
		if (mAudioBean != null) {
			mNotificationManager.notify(NOTIFICATION_ID, mNotification);
			showLoadStatus(mAudioBean);
		}
	}

	private void initRemoteViews() {
		//大布局
		int layoutId = R.layout.notification_big_layout;
		mBigRemoteViews = new RemoteViews(packageName, layoutId);
		//mBigRemoteViews.setTextViewText(R.id.title_view, mAudioBean.getName());
		//mBigRemoteViews.setTextViewText(R.id.tip_view, mAudioBean.getAlbum());
		//判断是否已收藏
//		if (null != GreenDaoHelper.selectFavourite(mAudioBean)) {
//			mBigRemoteViews.setImageViewResource(R.id.favourite_view, R.mipmap.note_btn_loved);
//		} else {
//			mBigRemoteViews.setImageViewResource(R.id.favourite_view, R.mipmap.note_btn_love_white);
//		}
		//小布局
		int smalllayoutId = R.layout.notification_small_layout;
		mSmallRemoteViews = new RemoteViews(packageName, smalllayoutId);
		//mSmallRemoteViews.setTextViewText(R.id.title_view, mAudioBean.getName());
		//mSmallRemoteViews.setTextViewText(R.id.tip_view, mAudioBean.getAlbum());

		//点击播放按钮广播
		Intent playIntent = new Intent(MusicService.NotificationReceiver.ACTION_STATUS_BAR);
		playIntent.putExtra(MusicService.NotificationReceiver.EXTRA,
				MusicService.NotificationReceiver.EXTRA_PLAY);
		PendingIntent playPendingIntent =
				PendingIntent.getBroadcast(AudioHelper.getContext(), 1, playIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
		mBigRemoteViews.setOnClickPendingIntent(R.id.play_view, playPendingIntent);
		mBigRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_play_white);
		mSmallRemoteViews.setOnClickPendingIntent(R.id.play_view, playPendingIntent);
		mSmallRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_play_white);

		//点击上一首按钮广播
		Intent previousIntent = new Intent(MusicService.NotificationReceiver.ACTION_STATUS_BAR);
		previousIntent.putExtra(MusicService.NotificationReceiver.EXTRA,
				MusicService.NotificationReceiver.EXTRA_PRE);
		PendingIntent previousPendingIntent =
				PendingIntent.getBroadcast(AudioHelper.getContext(), 2, previousIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
		mBigRemoteViews.setOnClickPendingIntent(R.id.previous_view, previousPendingIntent);
		mBigRemoteViews.setImageViewResource(R.id.previous_view, R.mipmap.note_btn_pre_white);

		//点击下一首按钮广播
		Intent nextIntent = new Intent(MusicService.NotificationReceiver.ACTION_STATUS_BAR);
		nextIntent.putExtra(MusicService.NotificationReceiver.EXTRA,
				MusicService.NotificationReceiver.EXTRA_PRE);
		PendingIntent nextPendingIntent =
				PendingIntent.getBroadcast(AudioHelper.getContext(), 3, nextIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
		mBigRemoteViews.setOnClickPendingIntent(R.id.next_view, nextPendingIntent);
		mBigRemoteViews.setImageViewResource(R.id.next_view, R.mipmap.note_btn_next_white);
		mSmallRemoteViews.setOnClickPendingIntent(R.id.next_view, nextPendingIntent);
		mSmallRemoteViews.setImageViewResource(R.id.next_view, R.mipmap.note_btn_next_white);

		//点击收藏按钮广播
		Intent favouriteIntent = new Intent(MusicService.NotificationReceiver.ACTION_STATUS_BAR);
		favouriteIntent.putExtra(MusicService.NotificationReceiver.EXTRA,
				MusicService.NotificationReceiver.EXTRA_FAV);
		PendingIntent favouritePendingIntent =
				PendingIntent.getBroadcast(AudioHelper.getContext(), 4, favouriteIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
		mBigRemoteViews.setOnClickPendingIntent(R.id.favourite_view, favouritePendingIntent);
		//取消通知栏
		//取消通知栏显示
		Intent closeIntent = new Intent(MusicService.NotificationReceiver.ACTION_STATUS_BAR);
		closeIntent.putExtra(MusicService.NotificationReceiver.EXTRA,
				MusicService.NotificationReceiver.EXTRA_CANCLE);
		PendingIntent closePendingIntent =
				PendingIntent.getBroadcast(AudioHelper.getContext(), 5, closeIntent,
						PendingIntent.FLAG_UPDATE_CURRENT);
		mBigRemoteViews.setOnClickPendingIntent(R.id.close_view, closePendingIntent);
		mSmallRemoteViews.setOnClickPendingIntent(R.id.close_view, closePendingIntent);

	}

	public void showLoadStatus(AudioBean bean) {
		//防止空指针crash
		mAudioBean = bean;
		if (mBigRemoteViews != null && mAudioBean != null) {
			mBigRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_pause_white);
			mBigRemoteViews.setTextViewText(R.id.title_view, mAudioBean.getName());
			mBigRemoteViews.setTextViewText(R.id.tip_view, mAudioBean.getAlbum());
			ImageLoaderManager.getInstance()
					.displayImageForNotification(AudioHelper.getContext(), mBigRemoteViews, R.id.image_view,
							mNotification, NOTIFICATION_ID, mAudioBean.getAlbumPic());
			//更新收藏view
//			if (null != GreenDaoHelper.selectFavourite(mAudioBean)) {
//				mBigRemoteViews.setImageViewResource(R.id.favourite_view, R.mipmap.note_btn_loved);
//			} else {
//				mBigRemoteViews.setImageViewResource(R.id.favourite_view, R.mipmap.note_btn_love_white);
//			}

			//小布局也要更新
			mSmallRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_pause_white);
			mSmallRemoteViews.setTextViewText(R.id.title_view, mAudioBean.getName());
			mSmallRemoteViews.setTextViewText(R.id.tip_view, mAudioBean.getAlbum());
			ImageLoaderManager.getInstance()
					.displayImageForNotification(AudioHelper.getContext(), mSmallRemoteViews, R.id.image_view,
							mNotification, NOTIFICATION_ID, mAudioBean.getAlbumPic());

			mNotificationManager.notify(NOTIFICATION_ID, mNotification);
		}
	}

	public void showPlayStatus() {
		if (mBigRemoteViews != null) {
			mBigRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_pause_white);
			mSmallRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_pause_white);
			mNotificationManager.notify(NOTIFICATION_ID, mNotification);
		}
	}

	public void showPauseStatus() {
		if (mBigRemoteViews != null) {
			mBigRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_play_white);
			mSmallRemoteViews.setImageViewResource(R.id.play_view, R.mipmap.note_btn_play_white);
			mNotificationManager.notify(NOTIFICATION_ID, mNotification);
		}
	}

	public void changeFavouriteStatus(boolean isFavourite) {
		if (mBigRemoteViews != null) {
			mBigRemoteViews.setImageViewResource(R.id.favourite_view,
					isFavourite ? R.mipmap.note_btn_loved : R.mipmap.note_btn_love_white);
			mNotificationManager.notify(NOTIFICATION_ID, mNotification);
		}
	}


	public interface NotificationHelperListener {
		void onNotificationInit();
	}
}
