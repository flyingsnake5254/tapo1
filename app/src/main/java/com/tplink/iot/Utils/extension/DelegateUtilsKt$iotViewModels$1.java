package com.tplink.iot.Utils.extension;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: DelegateUtils.kt */
/* loaded from: classes2.dex */
public final class DelegateUtilsKt$iotViewModels$1 extends Lambda implements a<ViewModelStore> {
    final /* synthetic */ FragmentActivity $this_iotViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegateUtilsKt$iotViewModels$1(FragmentActivity fragmentActivity) {
        super(0);
        this.$this_iotViewModels = fragmentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = this.$this_iotViewModels.getViewModelStore();
        j.d(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
