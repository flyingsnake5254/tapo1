package com.tplink.iot.widget.cameralive;

import androidx.databinding.BindingAdapter;
import io.reactivex.m0.d;

/* compiled from: VideoSurfaceViewLayoutBindingAdapter.java */
/* loaded from: classes3.dex */
public class y {
    @BindingAdapter({"deviceIdMD5"})
    public static void a(VideoSurfaceViewLayout videoSurfaceViewLayout, String str) {
        videoSurfaceViewLayout.setDeviceIdMD5(str);
    }

    @BindingAdapter({"fullScreen"})
    public static void b(VideoSurfaceViewLayout videoSurfaceViewLayout, boolean z) {
        videoSurfaceViewLayout.setFullScreen(z);
    }

    @BindingAdapter({"highQuality"})
    public static void c(VideoSurfaceViewLayout videoSurfaceViewLayout, boolean z) {
        videoSurfaceViewLayout.setIsHQ(z);
    }

    @BindingAdapter({"isFocused"})
    public static void d(VideoSurfaceViewLayout videoSurfaceViewLayout, boolean z) {
        videoSurfaceViewLayout.setIsFocused(z);
    }

    @BindingAdapter({"rearrangeMode"})
    public static void e(VideoSurfaceViewLayout videoSurfaceViewLayout, boolean z) {
        videoSurfaceViewLayout.k0(z);
    }

    @BindingAdapter({"relayEventSubject"})
    public static void f(VideoSurfaceViewLayout videoSurfaceViewLayout, d<Integer> dVar) {
        videoSurfaceViewLayout.setRelayEventSubject(dVar);
    }

    @BindingAdapter({"videoResolution"})
    public static void g(VideoSurfaceViewLayout videoSurfaceViewLayout, String str) {
        videoSurfaceViewLayout.setVideoResolution(str);
    }
}
