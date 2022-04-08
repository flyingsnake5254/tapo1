package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryPlayViewModel;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisLayout;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;

/* loaded from: classes2.dex */
public abstract class ActivitySummaryPlayBinding extends ViewDataBinding {
    @Nullable
    public final ImageView H3;
    @Nullable
    public final ImageView I3;
    @Nullable
    public final ImageView J3;
    @NonNull
    public final ImageView K3;
    @Nullable
    public final ImageView L3;
    @NonNull
    public final ImageView M3;
    @NonNull
    public final ImageView N3;
    @NonNull
    public final ImageView O3;
    @NonNull
    public final ConstraintLayout P3;
    @NonNull
    public final TextView Q3;
    @NonNull
    public final ImageView R3;
    @Nullable
    public final ImageView S3;
    @NonNull
    public final ImageView T3;
    @Nullable
    public final ConstraintLayout U3;
    @Nullable
    public final ConstraintLayout V3;
    @NonNull
    public final ConstraintLayout W3;
    @NonNull
    public final ScrollCalendar X3;
    @Nullable
    public final ConstraintLayout Y3;
    @Nullable
    public final LinearLayout Z3;
    @Nullable
    public final ConstraintLayout a4;
    @Nullable
    public final ConstraintLayout b4;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LottieAnimationView f6711c;
    @Nullable
    public final ConstraintLayout c4;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f6712d;
    @NonNull
    public final SummaryTimeAxisLayout d4;
    @NonNull
    public final PlayerView e4;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final TextView f6713f;
    @NonNull
    public final TextView f4;
    @NonNull
    public final TextView g4;
    @Nullable
    public final TextView h4;
    @NonNull
    public final TextView i4;
    @NonNull
    public final TextView j4;
    @NonNull
    public final WeekdayView k4;
    @Bindable
    protected SummaryPlayViewModel l4;
    @Bindable
    protected SummaryTimeAxisLayout.b m4;
    @NonNull
    public final TextView p0;
    @Nullable
    public final CardView p1;
    @Nullable
    public final ImageView p2;
    @Nullable
    public final ImageView p3;
    @Nullable
    public final ImageView q;
    @NonNull
    public final ImageView x;
    @Nullable
    public final ImageView y;
    @NonNull
    public final ImageView z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivitySummaryPlayBinding(Object obj, View view, int i, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, CardView cardView, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ConstraintLayout constraintLayout, TextView textView4, ImageView imageView15, ImageView imageView16, ImageView imageView17, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ScrollCalendar scrollCalendar, ConstraintLayout constraintLayout5, LinearLayout linearLayout, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, SummaryTimeAxisLayout summaryTimeAxisLayout, PlayerView playerView, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, WeekdayView weekdayView) {
        super(obj, view, i);
        this.f6711c = lottieAnimationView;
        this.f6712d = textView;
        this.f6713f = textView2;
        this.q = imageView;
        this.x = imageView2;
        this.y = imageView3;
        this.z = imageView4;
        this.p0 = textView3;
        this.p1 = cardView;
        this.p2 = imageView5;
        this.p3 = imageView6;
        this.H3 = imageView7;
        this.I3 = imageView8;
        this.J3 = imageView9;
        this.K3 = imageView10;
        this.L3 = imageView11;
        this.M3 = imageView12;
        this.N3 = imageView13;
        this.O3 = imageView14;
        this.P3 = constraintLayout;
        this.Q3 = textView4;
        this.R3 = imageView15;
        this.S3 = imageView16;
        this.T3 = imageView17;
        this.U3 = constraintLayout2;
        this.V3 = constraintLayout3;
        this.W3 = constraintLayout4;
        this.X3 = scrollCalendar;
        this.Y3 = constraintLayout5;
        this.Z3 = linearLayout;
        this.a4 = constraintLayout6;
        this.b4 = constraintLayout7;
        this.c4 = constraintLayout8;
        this.d4 = summaryTimeAxisLayout;
        this.e4 = playerView;
        this.f4 = textView5;
        this.g4 = textView6;
        this.h4 = textView7;
        this.i4 = textView8;
        this.j4 = textView9;
        this.k4 = weekdayView;
    }

    public abstract void h(@Nullable SummaryTimeAxisLayout.b bVar);

    public abstract void i(@Nullable SummaryPlayViewModel summaryPlayViewModel);
}
