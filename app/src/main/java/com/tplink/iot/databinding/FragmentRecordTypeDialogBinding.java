package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes2.dex */
public abstract class FragmentRecordTypeDialogBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f7057c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f7058d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final AppCompatRadioButton f7059f;
    @Bindable
    protected View.OnClickListener p0;
    @Bindable
    protected RadioGroup.OnCheckedChangeListener p1;
    @NonNull
    public final AppCompatRadioButton q;
    @NonNull
    public final Button x;
    @NonNull
    public final TextView y;
    @NonNull
    public final RadioGroup z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRecordTypeDialogBinding(Object obj, View view, int i, Button button, View view2, AppCompatRadioButton appCompatRadioButton, AppCompatRadioButton appCompatRadioButton2, Button button2, TextView textView, RadioGroup radioGroup) {
        super(obj, view, i);
        this.f7057c = button;
        this.f7058d = view2;
        this.f7059f = appCompatRadioButton;
        this.q = appCompatRadioButton2;
        this.x = button2;
        this.y = textView;
        this.z = radioGroup;
    }

    public abstract void h(@Nullable RadioGroup.OnCheckedChangeListener onCheckedChangeListener);

    public abstract void i(@Nullable View.OnClickListener onClickListener);
}
