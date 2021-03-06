package com.ve.music.ui.page.audio;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import com.lxj.xpopup.XPopup;
import com.ve.lib.utils.StatusBarUtil;
import com.ve.lib_api.model.song.AudioBean;
import com.ve.lib_audio.mediaplayer.core.AudioController;
import com.ve.lib_audio.mediaplayer.core.CustomMediaPlayer;
import com.ve.lib_audio.mediaplayer.core.PlayMode;
import com.ve.lib_audio.mediaplayer.events.AudioBufferUpdateEvent;
import com.ve.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.ve.lib_audio.mediaplayer.events.AudioPauseEvent;
import com.ve.lib_audio.mediaplayer.events.AudioPlayModeEvent;
import com.ve.lib_audio.mediaplayer.events.AudioProgressEvent;
import com.ve.lib_audio.mediaplayer.events.AudioStartEvent;
import com.ve.lib_audio.mediaplayer.view.IndictorView;
import com.ve.lib_common_ui.lrc.LrcView;
import com.ve.lib_common_ui.utils.SharePreferenceUtil;
import com.ve.lib_network.ApiEngine;
import com.ve.lib_network.ApiService;
import com.ve.music.R;
import com.ve.music.data.config.TypeEnum;
import com.ve.music.util.TimeUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;


public class MusicPlayerActivity extends AppCompatActivity {

    private static final String TAG = "MusicPlayerActivity";
    private RelativeLayout mBgView;
    private TextView mInfoView;
    private TextView mAuthorView;

    private ImageView mFavouriteView;
    private ImageView mCommectView;

    private SeekBar mProgressView;
    private TextView mStartTimeView;
    private TextView mTotalTimeView;
    private TextView mCommentNum;

    private ImageView mPlayModeView;
    private ImageView mPlayView;
    private ImageView mNextView;
    private ImageView mPreViousView;
    private ImageView mNeddleiew;
    private IndictorView mIndictorView;

    private LinearLayout mLlOpreationView;

    private LrcView lrcView;
    private Animator mFavAnimator;
    private ObjectAnimator mNeddlePlayAnimator;
    private ObjectAnimator mNeddlePauseAnimator;

    /**
     * data
     */
    private AudioBean mAudioBean; //????????????????????????
    private PlayMode mPlayMode;//??????????????????
    private List<String> likeList = new ArrayList<>(); //?????????????????????ID??????

    /**
     * ????????????service
     */
    private ApiService apiService;

    //??????????????????Activity
    public static void start(Activity context) {
        Intent intent = new Intent(context, MusicPlayerActivity.class);
        //context???Activity??????
        ActivityCompat.startActivity(context, intent,
                ActivityOptionsCompat.makeSceneTransitionAnimation(context).toBundle());

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.INSTANCE.setColor(this, Color.TRANSPARENT);
        setContentView(R.layout.activity_music_service_layout);
        //?????????????????? ????????????????????????
        getWindow().setEnterTransition(
                TransitionInflater.from(this).inflateTransition(R.transition.transition_bottom2top));
        EventBus.getDefault().register(this);
        apiService = ApiEngine.getInstance().getApiService();
        initData();
        initView();
        initAnimator();
    }

    private void initAnimator() {

        //???????????? ??????
        mNeddlePlayAnimator = ObjectAnimator.ofFloat(mNeddleiew, "rotation", -25, 0);
        mNeddlePlayAnimator.setDuration(200);
        mNeddlePlayAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mNeddlePlayAnimator.setRepeatCount(0);
        mNeddlePlayAnimator.setInterpolator(new LinearInterpolator());
        //?????????????????? ??????
        mNeddlePauseAnimator = ObjectAnimator.ofFloat(mNeddleiew, "rotation", 0, -25);
        mNeddlePauseAnimator.setDuration(200);
        mNeddlePauseAnimator.setRepeatMode(ValueAnimator.REVERSE);
        mNeddlePauseAnimator.setRepeatCount(0);
        mNeddlePauseAnimator.setInterpolator(new LinearInterpolator());
    }

    private void initView() {
        mBgView = findViewById(R.id.root_layout);
        mCommentNum = findViewById(R.id.tv_comment_num);
        //??????
        lrcView = findViewById(R.id.lrc_view);
        lrcView.setOnSingerClickListener(() -> {
            //??????????????????
            lrcView.setVisibility(View.GONE);
            mNeddleiew.setVisibility(View.VISIBLE);
            mIndictorView.setVisibility(View.VISIBLE);
            mLlOpreationView.setVisibility(View.VISIBLE);
        });

        //???????????????
        lrcView.setDraggable(true, time -> {
            AudioController.getInstance().seekTo(time);
            return true;
        });
        mLlOpreationView = findViewById(R.id.operation_view);
        //???????????????
        //ImageLoaderManager.getInstance().displayImageForViewGroup(mBgView, mAudioBean.getAlbumPic(), 100);
        //????????????
        findViewById(R.id.back_view).setOnClickListener(v -> onBackPressed());

        //??????
        findViewById(R.id.share_view).setOnClickListener(v -> shareMusic(mAudioBean.getUrl(), mAudioBean.getName()));
        //?????????????????? Dialog
        findViewById(R.id.show_list_view).setOnClickListener(v -> new XPopup.Builder(MusicPlayerActivity.this)
                .asCustom(new MusicListDialog(MusicPlayerActivity.this))
                .show());
        //????????????
        mInfoView = findViewById(R.id.album_view);
        mInfoView.setText(mAudioBean.getName());
        //???????????????????????????
        mInfoView.requestFocus();
        //????????????
        mAuthorView = findViewById(R.id.author_view);
        mAuthorView.setText(mAudioBean.getAuthor());
        //??????
        mNeddleiew = findViewById(R.id.needle);
        //??????????????????????????????
        mNeddleiew.bringToFront();
        //??????
        mCommectView = findViewById(R.id.iv_comment);
        //mCommectView.setOnClickListener(v -> CommentActivity.startActivity(MusicPlayerActivity.this, mAudioBean.getId(), TypeEnum.SONG_ID, mAudioBean.getAlbumPic(), mAudioBean.getAuthor(), mAudioBean.getName()));
        //????????????
        mFavouriteView = findViewById(R.id.favourite_view);
        //????????????????????? ?????????false
        mFavouriteView.setTag(false);
        //????????????
        mFavouriteView.setOnClickListener(v -> changeFavouriteStatus());
        //?????????????????????
        loadFavouriteStatus();
        mStartTimeView = findViewById(R.id.start_time_view);
        mTotalTimeView = findViewById(R.id.total_time_view);
        mTotalTimeView.setText(mAudioBean.getTotalTime());
        mProgressView = findViewById(R.id.progress_view);
        mProgressView.setProgress(0);
        //seekBar ?????????
        mProgressView.setEnabled(true);
        mProgressView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //???????????????
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //??????????????????
                AudioController.getInstance().seekTo(seekBar.getProgress());

            }
        });
        mPlayModeView = findViewById(R.id.play_mode_view);
        mPlayModeView.setOnClickListener(v -> {
            //?????????????????? LOOP --> RANDOM --> REPEAT --> LOOP
            switch (mPlayMode) {
                case LOOP:
                    AudioController.getInstance().setPlayMode(PlayMode.RANDOM);
                    break;
                case RANDOM:
                    AudioController.getInstance().setPlayMode(PlayMode.REPEAT);
                    break;
                case REPEAT:
                    AudioController.getInstance().setPlayMode(PlayMode.LOOP);
                    break;
                default:
                    break;
            }
        });

        mPreViousView = findViewById(R.id.previous_view);
        mPreViousView.setOnClickListener(v -> AudioController.getInstance().previous());
        mPlayView = findViewById(R.id.play_view);
        mPlayView.setOnClickListener(v -> AudioController.getInstance().playOrPause());
        mNextView = findViewById(R.id.next_view);
        mNextView.setOnClickListener(v -> AudioController.getInstance().next());
        mIndictorView = findViewById(R.id.indictor_view);
        mIndictorView.setListaner(new IndictorView.OnIndicatorViewStatusChangeListener() {
            @Override
            public void onDrag() {
                //????????????????????????????????? ???????????????????????????
                showPauseAnimator();
            }

            @Override
            public void onIdle() {
                //???????????????
                showPlayAnimator();
            }

            @Override
            public void onSingleTouch(MotionEvent event) {

                //??????????????????
                lrcView.setVisibility(View.VISIBLE);
                mIndictorView.setVisibility(View.GONE);
                mNeddleiew.setVisibility(View.GONE);
                mLlOpreationView.setVisibility(View.GONE);
            }
        });
        //ViewPager?????????????????????

        //?????????????????????
        updatePlayModeView();
        //????????????????????????????????????
        updateStateView();
    }

    private void updateStateView() {
        //????????????Activity??? ??????????????????
        if (AudioController.getInstance().isStartState()) {
            mPlayView.setImageResource(R.mipmap.audio_aj6);
            mNeddleiew.setRotation(0);
        } else {
            mPlayView.setImageResource(R.mipmap.audio_aj7);
            mNeddleiew.setRotation(-25);
        }
    }

    private void updatePlayModeView() {
        switch (mPlayMode) {
            case LOOP:
                mPlayModeView.setImageResource(R.mipmap.ic_player_loop);
                break;
            case RANDOM:
                mPlayModeView.setImageResource(R.mipmap.ic_player_random);
                break;
            case REPEAT:
                mPlayModeView.setImageResource(R.mipmap.ic_player_once);
                break;
            default:
                break;
        }
    }

    //?????????????????????
    void loadFavouriteStatus() {
        Disposable subscribe = apiService.getLikeList(SharePreferenceUtil.getInstance(getBaseContext()).getUserId())
                .compose(ApiEngine.getInstance().applySchedulers())
                .subscribe(likeListBean -> {
                    likeList = likeListBean.getIds();
                    boolean likeMusic = false;
                    for (String id : likeList) {
                        if (mAudioBean.getId().equals(id)) {
                            likeMusic = true;
                            break;
                        }
                    }
                    //????????????
                    mFavouriteView.setImageResource(likeMusic ? R.mipmap.audio_aeh : R.mipmap.audio_aef);
                    //?????????????????????
                    mFavouriteView.setTag(likeMusic);
                });
    }

    //??????????????????????????????
    private void changeFavouriteStatus() {
        final boolean liked = (boolean) mFavouriteView.getTag();
        Disposable subscribe = apiService.likeMusic(mAudioBean.getId(), !liked)
                .compose(ApiEngine.getInstance().applySchedulers())
                .subscribe(likeMusicBean -> {
                    if (likeMusicBean.getCode() == 200) {
                        mFavouriteView.setImageResource(liked ? R.mipmap.audio_aef : R.mipmap.audio_aeh);
                        mFavouriteView.setTag(!liked);
                        if (mFavAnimator != null) {
                            mFavAnimator.end();
                        }
                        //??????	SCALE_X???SCALE_Y   1.0 -> 1.2 -> 1.0 ??????
                        PropertyValuesHolder animX =
                                PropertyValuesHolder.ofFloat(View.SCALE_X.getName(), 1.0f, 1.2f, 1.0f);
                        PropertyValuesHolder animY =
                                PropertyValuesHolder.ofFloat(View.SCALE_Y.getName(), 1.0f, 1.2f, 1.0f);
                        //????????????
                        mFavAnimator = ObjectAnimator.ofPropertyValuesHolder(mFavouriteView, animX, animY);
                        //?????????????????????
                        mFavAnimator.setInterpolator(new AccelerateInterpolator());
                        mFavAnimator.setDuration(300);
                        mFavAnimator.start();
                    }
                });
    }

    private void initData() {
        mAudioBean = AudioController.getInstance().getNowPlaying();
        mPlayMode = AudioController.getInstance().getPlayMode();
        //????????????
        Disposable subscribe = apiService.getLyric(mAudioBean.getId())
                .compose(ApiEngine.getInstance().applySchedulers())
                .subscribe(lyricBean -> lrcView.loadLrc(lyricBean.getLrc().getLyric(), lyricBean.getTlyric().getLyric()));

        //??????????????????
        Disposable subscribecomment = apiService.getMusicComment(mAudioBean.getId())
                .compose(ApiEngine.getInstance().applySchedulers())
                .subscribe(bean -> mCommentNum.setText(bean.getTotal() > 1000 ? "999+" : String.valueOf(bean.getTotal())));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioPlayModeEvent(AudioPlayModeEvent event) {
        mPlayMode = AudioController.getInstance().getPlayMode();
        updatePlayModeView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioStartEvent(AudioStartEvent event) {
        showPlayView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioPauseEvent(AudioPauseEvent event) {
        showPauseView();
    }

    //?????????????????? next pre
    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioLoadEvent(AudioLoadEvent event) {
        //??????notifacation???load??????
        mAudioBean = event.mAudioBean;
        //ImageLoaderManager.getInstance().displayImageForViewGroup(mBgView, mAudioBean.getAlbumPic(), 100);
        mInfoView.setText(mAudioBean.getAlbumInfo());
        mAuthorView.setText(mAudioBean.getAuthor());
        mStartTimeView.setText("00:00");
        mTotalTimeView.setText(mAudioBean.getTotalTime());
        //?????????????????????????????????
        loadFavouriteStatus();
        mProgressView.setProgress(0);
        lrcView.updateTime(0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioProgressEvent(AudioProgressEvent event) {
        int totalTime = event.maxLength;
        int currentTime = event.progress;
        //??????????????????
        mProgressView.setProgress(currentTime);
        //??????????????????
        mProgressView.setMax(totalTime);
        mStartTimeView.setText(TimeUtil.formatTime(currentTime));
        //????????????????????????
        lrcView.updateTime(currentTime);
        //????????????
        if (event.mStatus == CustomMediaPlayer.Status.PAUSED) {
            //showPauseView();
        } else {
            //showPlayView();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioBufferUpdateEvent(AudioBufferUpdateEvent event) {
        mProgressView.setSecondaryProgress(event.progress);
    }

    private void showPlayView() {
        mPlayView.setImageResource(R.mipmap.audio_aj6);
        showPlayAnimator();
    }


    private void showPauseView() {
        mPlayView.setImageResource(R.mipmap.audio_aj7);
        showPauseAnimator();
    }


    private void showPlayAnimator() {
        //??????????????????mNeddleiew.getRotation() : -25.0
        if (mNeddleiew.getRotation() == -25.0) {
            if (mNeddlePlayAnimator.isPaused()) {
                mNeddlePlayAnimator.resume();
            } else {
                mNeddlePlayAnimator.start();
            }
        } else {
            Log.e(TAG, "showPlayAnimator() ?????????????????????");
        }
    }

    private void showPauseAnimator() {
        //??????????????????mNeddleiew.getRotation() : 0
        if (mNeddleiew.getRotation() == 0) {
            mNeddlePauseAnimator.start();
        } else {
            Log.e(TAG, "showPauseAnimator() ?????????????????????");
        }
    }


    private void shareMusic(String url, String name) {
//		final ShareContentData data = ShareContentData.Builder()
//				.shareType(5)
//				.shareTitle(name)
//				.shareText("???????????????")
//				.shareTileUrl(url)
//				.shareSite("netease")
//				.shareSiteUrl("http://www.imooc.com")
//				.build();
//
//		ShareDialog dialog = new ShareDialog(this, false, data);
//		dialog.show();
    }

}
