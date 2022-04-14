package com.ve.lib_audio.mediaplayer.events;

import com.ve.lib_audio.mediaplayer.core.PlayMode;

/**
 * 播放模式切换事件
 */
public class AudioPlayModeEvent {

    public PlayMode mPlayMode;

    public AudioPlayModeEvent(PlayMode playMode) {
        this.mPlayMode = playMode;
    }
}
