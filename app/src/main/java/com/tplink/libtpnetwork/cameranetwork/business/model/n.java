package com.tplink.libtpnetwork.cameranetwork.business.model;

import com.tplink.libtpnetwork.cameranetwork.model.DetectionList;
import com.tplink.libtpnetwork.cameranetwork.model.SnapshotPlaybackItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PlaybackSnapshotRecord.java */
/* loaded from: classes3.dex */
public class n {
    private DetectionList a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14152b;

    /* renamed from: c  reason: collision with root package name */
    private int f14153c;

    /* renamed from: d  reason: collision with root package name */
    private long f14154d;

    public n() {
        this.a = new DetectionList(Boolean.FALSE, new ArrayList());
        this.f14152b = false;
    }

    public DetectionList a() {
        return this.a;
    }

    public long b() {
        return this.f14154d;
    }

    public int c() {
        return this.f14153c;
    }

    public boolean d() {
        return this.f14152b;
    }

    public n(List<SnapshotPlaybackItem> list, boolean z, boolean z2, int i, long j) {
        this.a = new DetectionList(Boolean.valueOf(z), list);
        this.f14152b = z2;
        this.f14153c = i;
        this.f14154d = j;
    }
}
