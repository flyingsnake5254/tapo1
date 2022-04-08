package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.widget.PointTextView;

/* loaded from: classes2.dex */
public abstract class FragmentSubgLedNotBlinkingHelpBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f7096c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final VariousImageViewLayout f7097d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f7098f;
    @NonNull
    public final PointTextView p0;
    @NonNull
    public final LinearLayout q;
    @NonNull
    public final TextView x;
    @NonNull
    public final PointTextView y;
    @NonNull
    public final PointTextView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentSubgLedNotBlinkingHelpBinding(Object obj, View view, int i, ImageView imageView, VariousImageViewLayout variousImageViewLayout, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, PointTextView pointTextView, PointTextView pointTextView2, PointTextView pointTextView3) {
        super(obj, view, i);
        this.f7096c = imageView;
        this.f7097d = variousImageViewLayout;
        this.f7098f = linearLayout;
        this.q = linearLayout2;
        this.x = textView;
        this.y = pointTextView;
        this.z = pointTextView2;
        this.p0 = pointTextView3;
    }
}
