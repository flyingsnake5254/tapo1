package com.tplink.libtpappcommonmedia.bean.demux;

/* loaded from: classes3.dex */
public class DemuxResultBean {
    private AudioPacket audioPacket;
    private VideoPacket videoPacket;

    public AudioPacket getAudioPacket() {
        return this.audioPacket;
    }

    public VideoPacket getVideoPacket() {
        return this.videoPacket;
    }

    public void setAudioPacket(AudioPacket audioPacket) {
        this.audioPacket = audioPacket;
    }

    public void setVideoPacket(VideoPacket videoPacket) {
        this.videoPacket = videoPacket;
    }
}
