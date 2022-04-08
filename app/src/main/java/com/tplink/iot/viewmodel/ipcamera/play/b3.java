package com.tplink.iot.viewmodel.ipcamera.play;

import androidx.lifecycle.Observer;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

/* compiled from: CloudTerracePresetViewModel.kt */
/* loaded from: classes3.dex */
final class b3 implements Observer {
    private final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b3(l lVar) {
        this.a = lVar;
    }

    @Override // androidx.lifecycle.Observer
    public final /* synthetic */ void onChanged(Object obj) {
        j.d(this.a.invoke(obj), "invoke(...)");
    }
}
