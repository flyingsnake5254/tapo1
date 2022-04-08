package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.widget.springview.widget.PullToRefreshContainer;

/* loaded from: classes2.dex */
public abstract class ActivityCameraPreviewBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f6515c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f6516d;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ActivityCameraPreviewModePartBinding f6517f;
    @Bindable
    protected MutableLiveData<Boolean> p0;
    @Bindable
    protected MutableLiveData<Boolean> p1;
    @NonNull
    public final ActivityCameraPreviewCloudVideoServerBinding q;
    @NonNull
    public final RecyclerView x;
    @NonNull
    public final PullToRefreshContainer y;
    @Bindable
    protected MutableLiveData<Boolean> z;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCameraPreviewBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ActivityCameraPreviewModePartBinding activityCameraPreviewModePartBinding, ActivityCameraPreviewCloudVideoServerBinding activityCameraPreviewCloudVideoServerBinding, RecyclerView recyclerView, PullToRefreshContainer pullToRefreshContainer) {
        super(obj, view, i);
        this.f6515c = textView;
        this.f6516d = imageView;
        this.f6517f = activityCameraPreviewModePartBinding;
        this.q = activityCameraPreviewCloudVideoServerBinding;
        this.x = recyclerView;
        this.y = pullToRefreshContainer;
    }

    public abstract void h(@Nullable MutableLiveData<Boolean> mutableLiveData);

    public abstract void i(@Nullable MutableLiveData<Boolean> mutableLiveData);

    public abstract void l(@Nullable MutableLiveData<Boolean> mutableLiveData);
}
