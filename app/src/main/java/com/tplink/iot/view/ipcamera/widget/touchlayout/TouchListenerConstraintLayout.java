package com.tplink.iot.view.ipcamera.widget.touchlayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes2.dex */
public class TouchListenerConstraintLayout extends ConstraintLayout {

    /* renamed from: c  reason: collision with root package name */
    private View.OnTouchListener f9468c;

    public TouchListenerConstraintLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View.OnTouchListener onTouchListener = this.f9468c;
        if (onTouchListener != null) {
            onTouchListener.onTouch(this, motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f9468c != null || super.onTouchEvent(motionEvent);
    }

    public void setDispatchEventListener(View.OnTouchListener onTouchListener) {
        this.f9468c = onTouchListener;
    }

    public TouchListenerConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchListenerConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
