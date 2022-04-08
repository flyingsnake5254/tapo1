package com.tplink.iot.musicphonerhythm.jniInterface;

/* loaded from: classes2.dex */
public class MusicRhythmJni {
    static {
        System.loadLibrary("musicrhythm_process");
    }

    public static native float[] getAudioResult(float[] fArr, int i, int i2);

    public static native int init(int i);
}
