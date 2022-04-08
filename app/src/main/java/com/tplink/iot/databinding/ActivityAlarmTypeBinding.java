package com.tplink.iot.databinding;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.AlarmTypeViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityAlarmTypeBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f6491c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RadioGroup f6492d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RadioButton f6493f;
    @NonNull
    public final RadioButton q;
    @NonNull
    public final Toolbar x;
    @Bindable
    protected View.OnClickListener y;
    @Bindable
    protected AlarmTypeViewModel z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityAlarmTypeBinding(Object obj, View view, int i, RadioButton radioButton, RadioGroup radioGroup, RadioButton radioButton2, RadioButton radioButton3, Toolbar toolbar) {
        super(obj, view, i);
        this.f6491c = radioButton;
        this.f6492d = radioGroup;
        this.f6493f = radioButton2;
        this.q = radioButton3;
        this.x = toolbar;
    }

    public abstract void h(@Nullable View.OnClickListener onClickListener);

    public abstract void i(@Nullable AlarmTypeViewModel alarmTypeViewModel);
}
