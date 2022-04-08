package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;

/* loaded from: classes2.dex */
public abstract class FragmentRateUsDialogBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageButton f7053c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageButton f7054d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageButton f7055f;
    @NonNull
    public final TextView p0;
    @Bindable
    protected ObservableInt p1;
    @Bindable
    protected g p2;
    @NonNull
    public final ImageButton q;
    @NonNull
    public final ImageButton x;
    @NonNull
    public final ImageButton y;
    @NonNull
    public final LinearLayout z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRateUsDialogBinding(Object obj, View view, int i, ImageButton imageButton, ImageButton imageButton2, ImageButton imageButton3, ImageButton imageButton4, ImageButton imageButton5, ImageButton imageButton6, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.f7053c = imageButton;
        this.f7054d = imageButton2;
        this.f7055f = imageButton3;
        this.q = imageButton4;
        this.x = imageButton5;
        this.y = imageButton6;
        this.z = linearLayout;
        this.p0 = textView;
    }
}
