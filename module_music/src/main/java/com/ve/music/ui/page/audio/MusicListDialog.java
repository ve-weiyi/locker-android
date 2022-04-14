package com.ve.music.ui.page.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BottomPopupView;
import com.ve.lib_api.model.song.AudioBean;
import com.ve.lib_audio.app.AudioHelper;
import com.ve.lib_audio.mediaplayer.core.AudioController;
import com.ve.lib_audio.mediaplayer.core.PlayMode;
import com.ve.lib_audio.mediaplayer.events.AudioLoadEvent;
import com.ve.lib_audio.mediaplayer.events.AudioPlayModeEvent;
import com.ve.lib_audio.mediaplayer.events.AudioRemoveEvent;
import com.ve.music.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

//歌曲播放列表Dialog
public class MusicListDialog extends BottomPopupView implements View.OnClickListener {

    private Context mContext;
    /*
     * view
     */
    private ImageView mTipView;
    private TextView mPlayModeView;
    private TextView mPlayNumView;
    private TextView mFavouriteView;
    private RecyclerView mRecyclerView;
    private MusicListAdapter mMusicListAdapter;
    private ImageView mDeleteView;
    /*
     * data
     */
    private ArrayList<AudioBean> mQueue; //播放队列
    private AudioBean mAudioBean; //当前正在播放歌曲
    private PlayMode mPlayMode;
    private StringBuilder tracks;

    MusicListDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        EventBus.getDefault().register(this);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.dialog_bottom_sheet;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        initData();
        initView();
    }

    @Override
    public int getAnimationDuration() {
        return 1000;
    }

    private void initData() {
        //当前播歌曲，用来初始化UI
        mQueue = AudioController.getInstance().getQueue();
        if (mQueue.size() != 0) {
            mAudioBean = AudioController.getInstance().getNowPlaying();
            mPlayMode = AudioController.getInstance().getPlayMode();
        }
        //获取trackId
        tracks = new StringBuilder();

        for (int i = 0; i < mQueue.size(); i++) {
            //最后一个参数不加逗号
            tracks.append(i == mQueue.size() - 1 ? mQueue.get(i).getId() : tracks.append(mQueue.get(i).getId()).append(","));
        }
    }

    @SuppressLint("SetTextI18n")
    private void initView() {

        mTipView = findViewById(R.id.mode_image_view);
        mDeleteView = findViewById(R.id.delete_view);
        mFavouriteView = findViewById(R.id.favourite_view);
        mPlayNumView = findViewById(R.id.num_text_view);
        mPlayModeView = findViewById(R.id.mode_text_view);

        mPlayNumView.setText("(" + mQueue.size() + ")");
        mFavouriteView.setOnClickListener(this);
        mDeleteView.setOnClickListener(this);
        mPlayModeView.setOnClickListener(this);
        //更新界面
        updatePlayModeView();
        //初始化recycler
        mRecyclerView = findViewById(R.id.recycler);

        mMusicListAdapter = new MusicListAdapter(mQueue, mAudioBean);
        //切换播放歌曲
        mMusicListAdapter.setOnItemClickListener((adapter, view, position) -> {
            AudioBean entity = (AudioBean) adapter.getItem(position);
            AudioHelper.addAudio(entity);
            dismiss();
        });
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setAdapter(mMusicListAdapter);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        //定位当前播放的音乐的位置
        int currentPosition = mQueue.indexOf(mAudioBean);
        //正在播放的音乐尽量处于中间的位置
        mRecyclerView.scrollToPosition(currentPosition - 3);
    }

    private void updatePlayModeView() {
        switch (mPlayMode) {
            case LOOP:
                mTipView.setImageResource(R.mipmap.loop);
                mPlayModeView.setText("列表循环");
                break;
            case RANDOM:
                mTipView.setImageResource(R.mipmap.random);
                mPlayModeView.setText("随机播放");
                break;
            case REPEAT:
                mTipView.setImageResource(R.mipmap.once);
                mPlayModeView.setText("单曲循环");
                break;
            default:
                break;
        }
    }

    private void updateList() {
        mMusicListAdapter.updateAdapter(mAudioBean);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioLoadEvent(AudioLoadEvent event) {
        mAudioBean = event.mAudioBean;
        //更新列表
        updateList();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioPlayModeEvent(AudioPlayModeEvent event) {
        mPlayMode = event.mPlayMode;
        //更新播放模式
        updatePlayModeView();
    }

    @SuppressLint("SetTextI18n")
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAudioRemoveEvent(AudioRemoveEvent event) {
        mQueue = AudioController.getInstance().getQueue();
        mPlayNumView.setText("(" + mQueue.size() + ")");
        mMusicListAdapter.setList(mQueue);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.favourite_view) {
            new XPopup.Builder(getContext())
                    .asCustom(new MusicCollectDialog(getContext(), tracks.toString()))
                    .show();
        } else if (id == R.id.delete_view) {//清空播放列表 TODO 确认对话框
            AudioController.getInstance().removeAudio();
            dismiss();
        } else if (id == R.id.mode_text_view) {//调用切换播放模式事件
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
        }
    }

    private static class MusicListAdapter extends BaseQuickAdapter<AudioBean, BaseViewHolder> {

        private AudioBean mCurrentBean;

        MusicListAdapter(@Nullable List<AudioBean> data, AudioBean currentBean) {
            super(R.layout.dialog_bottom_sheet_item, data);
            mCurrentBean = currentBean;
            addChildClickViewIds(R.id.item_delete);
            setOnItemChildClickListener((adapter, view, position) -> {
                if (view.getId() == R.id.item_delete) {
                    AudioBean item = (AudioBean) adapter.getItem(position);
                    AudioController.getInstance().removeAudio(item);
                    if (mCurrentBean == item) {
                        //如果是移除当前播放的音乐则切换到下一首
                        AudioController.getInstance().next();
                    }
                }
            });
        }

        @Override
        protected void convert(BaseViewHolder helper, final AudioBean item) {
            helper.setText(R.id.item_name, item.getName());
            helper.setText(R.id.item_author, "- " + item.getAuthor());
            if (item.getId().equals(mCurrentBean.getId())) {
                //当前为正在播放的音乐
                helper.setVisible(R.id.tip_view, true);
                helper.setTextColor(R.id.item_name, Color.RED);
                helper.setTextColor(R.id.item_author, Color.RED);
            } else {
                helper.setVisible(R.id.tip_view, false);
                helper.setTextColor(R.id.item_name, Color.parseColor("#333333"));
                helper.setTextColor(R.id.item_author, Color.parseColor("#999999"));
            }
        }

        void updateAdapter(AudioBean mAudioBean) {
            this.mCurrentBean = mAudioBean;
            notifyDataSetChanged();
        }
    }
}
