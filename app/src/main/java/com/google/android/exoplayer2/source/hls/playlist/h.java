package com.google.android.exoplayer2.source.hls.playlist;

import com.google.android.exoplayer2.offline.e;
import java.util.Collections;
import java.util.List;

/* compiled from: HlsPlaylist.java */
/* loaded from: classes.dex */
public abstract class h implements e<h> {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f3314b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f3315c;

    /* JADX INFO: Access modifiers changed from: protected */
    public h(String str, List<String> list, boolean z) {
        this.a = str;
        this.f3314b = Collections.unmodifiableList(list);
        this.f3315c = z;
    }
}
