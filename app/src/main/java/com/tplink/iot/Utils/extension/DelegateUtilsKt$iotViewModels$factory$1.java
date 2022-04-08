package com.tplink.iot.Utils.extension;

import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;

/* compiled from: DelegateUtils.kt */
/* loaded from: classes2.dex */
public final class DelegateUtilsKt$iotViewModels$factory$1 extends Lambda implements a<IoTViewModelFactory> {
    final /* synthetic */ String $deviceIdMD5;
    final /* synthetic */ FragmentActivity $this_iotViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegateUtilsKt$iotViewModels$factory$1(FragmentActivity fragmentActivity, String str) {
        super(0);
        this.$this_iotViewModels = fragmentActivity;
        this.$deviceIdMD5 = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final IoTViewModelFactory invoke() {
        return new IoTViewModelFactory(this.$this_iotViewModels, this.$deviceIdMD5);
    }
}
