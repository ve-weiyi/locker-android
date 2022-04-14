package com.ve.lib_audio.mediaplayer.events;

import com.ve.lib_api.model.song.AudioBean;

public class AudioLoadEvent {
    public AudioBean mAudioBean;

    public AudioLoadEvent(AudioBean audioBean) {
        this.mAudioBean = audioBean;
    }
}
