package com.tplink.iot.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.memories.MemoriesFilterViewModel;

/* loaded from: classes2.dex */
public abstract class ActivityMemoriesFilterBinding extends ViewDataBinding {
    @NonNull
    public final View H3;
    @NonNull
    public final TextView I3;
    @NonNull
    public final TextView J3;
    @NonNull
    public final RadioButton K3;
    @NonNull
    public final RelativeLayout L3;
    @NonNull
    public final TextView M3;
    @NonNull
    public final CheckBox N3;
    @NonNull
    public final RelativeLayout O3;
    @Bindable
    protected g P3;
    @Bindable
    protected MemoriesFilterViewModel Q3;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final Button f6615c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CheckBox f6616d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final RelativeLayout f6617f;
    @NonNull
    public final RecyclerView p0;
    @NonNull
    public final TextView p1;
    @NonNull
    public final CheckBox p2;
    @NonNull
    public final RelativeLayout p3;
    @NonNull
    public final TextView q;
    @NonNull
    public final RadioButton x;
    @NonNull
    public final RelativeLayout y;
    @NonNull
    public final TextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityMemoriesFilterBinding(Object obj, View view, int i, Button button, CheckBox checkBox, RelativeLayout relativeLayout, TextView textView, RadioButton radioButton, RelativeLayout relativeLayout2, TextView textView2, RecyclerView recyclerView, TextView textView3, CheckBox checkBox2, RelativeLayout relativeLayout3, View view2, TextView textView4, TextView textView5, RadioButton radioButton2, RelativeLayout relativeLayout4, TextView textView6, CheckBox checkBox3, RelativeLayout relativeLayout5) {
        super(obj, view, i);
        this.f6615c = button;
        this.f6616d = checkBox;
        this.f6617f = relativeLayout;
        this.q = textView;
        this.x = radioButton;
        this.y = relativeLayout2;
        this.z = textView2;
        this.p0 = recyclerView;
        this.p1 = textView3;
        this.p2 = checkBox2;
        this.p3 = relativeLayout3;
        this.H3 = view2;
        this.I3 = textView4;
        this.J3 = textView5;
        this.K3 = radioButton2;
        this.L3 = relativeLayout4;
        this.M3 = textView6;
        this.N3 = checkBox3;
        this.O3 = relativeLayout5;
    }

    public abstract void h(@Nullable MemoriesFilterViewModel memoriesFilterViewModel);

    public abstract void i(@Nullable g gVar);
}
