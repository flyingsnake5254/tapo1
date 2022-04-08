package com.tplink.iot.Utils.extension;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelStore;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: DelegateUtils.kt */
/* loaded from: classes2.dex */
public final class DelegateUtilsKt$activityIoTViewModels$1 extends Lambda implements a<ViewModelStore> {
    final /* synthetic */ Fragment $this_activityIoTViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegateUtilsKt$activityIoTViewModels$1(Fragment fragment) {
        super(0);
        this.$this_activityIoTViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        FragmentActivity requireActivity = this.$this_activityIoTViewModels.requireActivity();
        j.d(requireActivity, "requireActivity()");
        ViewModelStore viewModelStore = requireActivity.getViewModelStore();
        j.d(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
