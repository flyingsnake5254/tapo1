package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final class VideoQualities {
    private final VideoQuality main;
    private final VideoQuality minor;

    public VideoQualities(VideoQuality videoQuality, VideoQuality videoQuality2) {
        this.main = videoQuality;
        this.minor = videoQuality2;
    }

    public static /* synthetic */ VideoQualities copy$default(VideoQualities videoQualities, VideoQuality videoQuality, VideoQuality videoQuality2, int i, Object obj) {
        if ((i & 1) != 0) {
            videoQuality = videoQualities.main;
        }
        if ((i & 2) != 0) {
            videoQuality2 = videoQualities.minor;
        }
        return videoQualities.copy(videoQuality, videoQuality2);
    }

    public final VideoQuality component1() {
        return this.main;
    }

    public final VideoQuality component2() {
        return this.minor;
    }

    public final VideoQualities copy(VideoQuality videoQuality, VideoQuality videoQuality2) {
        return new VideoQualities(videoQuality, videoQuality2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoQualities)) {
            return false;
        }
        VideoQualities videoQualities = (VideoQualities) obj;
        return j.a(this.main, videoQualities.main) && j.a(this.minor, videoQualities.minor);
    }

    public final VideoQuality getMain() {
        return this.main;
    }

    public final VideoQuality getMinor() {
        return this.minor;
    }

    public int hashCode() {
        VideoQuality videoQuality = this.main;
        int i = 0;
        int hashCode = (videoQuality != null ? videoQuality.hashCode() : 0) * 31;
        VideoQuality videoQuality2 = this.minor;
        if (videoQuality2 != null) {
            i = videoQuality2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "VideoQualities(main=" + this.main + ", minor=" + this.minor + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VideoQualities(com.tplink.libtpnetwork.cameranetwork.model.Wrappers r4) {
        /*
            r3 = this;
            java.lang.String r0 = "wrappers"
            kotlin.jvm.internal.j.e(r4, r0)
            com.tplink.libtpnetwork.cameranetwork.model.Module r0 = com.tplink.libtpnetwork.cameranetwork.model.Module.VIDEO
            com.tplink.libtpnetwork.cameranetwork.model.Section r1 = com.tplink.libtpnetwork.cameranetwork.model.Section.VIDEO_MAIN
            java.lang.Object r1 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0, r1)
            com.tplink.libtpnetwork.cameranetwork.model.VideoQuality r1 = (com.tplink.libtpnetwork.cameranetwork.model.VideoQuality) r1
            com.tplink.libtpnetwork.cameranetwork.model.Section r2 = com.tplink.libtpnetwork.cameranetwork.model.Section.VIDEO_MINOR
            java.lang.Object r4 = com.tplink.libtpnetwork.cameranetwork.model.Model.typeCast(r4, r0, r2)
            com.tplink.libtpnetwork.cameranetwork.model.VideoQuality r4 = (com.tplink.libtpnetwork.cameranetwork.model.VideoQuality) r4
            r3.<init>(r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.libtpnetwork.cameranetwork.model.VideoQualities.<init>(com.tplink.libtpnetwork.cameranetwork.model.Wrappers):void");
    }
}
