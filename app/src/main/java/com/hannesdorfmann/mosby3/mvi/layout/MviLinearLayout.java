package com.hannesdorfmann.mosby3.mvi.layout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.hannesdorfmann.mosby3.h;
import com.hannesdorfmann.mosby3.i;
import com.hannesdorfmann.mosby3.j;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;

/* loaded from: classes2.dex */
public abstract class MviLinearLayout<V extends b, P extends d<V, ?>> extends LinearLayout implements b, i<V, P> {

    /* renamed from: c  reason: collision with root package name */
    private boolean f5085c = false;

    /* renamed from: d  reason: collision with root package name */
    protected h<V, P> f5086d;

    public MviLinearLayout(Context context) {
        super(context);
    }

    @NonNull
    protected h<V, P> getMvpDelegate() {
        if (this.f5086d == null) {
            this.f5086d = new j(this, this, true);
        }
        return this.f5086d;
    }

    @Override // com.hannesdorfmann.mosby3.f
    public V getMvpView() {
        return this;
    }

    @Override // com.hannesdorfmann.mosby3.i
    public final void n0(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getMvpDelegate().onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMvpDelegate().onDetachedFromWindow();
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onRestoreInstanceState(Parcelable parcelable) {
        getMvpDelegate().onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected Parcelable onSaveInstanceState() {
        return getMvpDelegate().onSaveInstanceState();
    }

    @Override // com.hannesdorfmann.mosby3.i
    public final Parcelable r() {
        return super.onSaveInstanceState();
    }

    @Override // com.hannesdorfmann.mosby3.f
    public void setRestoringViewState(boolean z) {
        this.f5085c = z;
    }

    public MviLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MviLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
