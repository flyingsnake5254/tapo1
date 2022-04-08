package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmSoundViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityAlarmSoundBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f6488c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RadioButton f6489d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RadioGroup f6490f;
    @NonNull
    public final Toolbar q;
    @Bindable
    protected AlarmSoundViewModel x;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAlarmSoundBinding(Object obj, View view, int i, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, Toolbar toolbar) {
        super(obj, view, i);
        this.f6488c = radioButton;
        this.f6489d = radioButton2;
        this.f6490f = radioGroup;
        this.q = toolbar;
    }

    public abstract void h(@Nullable AlarmSoundViewModel alarmSoundViewModel);
}
