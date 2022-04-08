package com.tplink.libtpcontrols;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/* loaded from: classes3.dex */
public class StretchScrollView extends ScrollView {

    /* renamed from: c  reason: collision with root package name */
    private View f12047c;

    /* renamed from: d  reason: collision with root package name */
    private float f12048d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f12049f = false;
    private int q = 0;
    private int x = 0;
    private Handler y = new a();

    /* loaded from: classes3.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what && StretchScrollView.this.q != 0 && StretchScrollView.this.f12049f) {
                StretchScrollView.this.q -= StretchScrollView.this.x;
                if ((StretchScrollView.this.x < 0 && StretchScrollView.this.q > 0) || (StretchScrollView.this.x > 0 && StretchScrollView.this.q < 0)) {
                    StretchScrollView.this.q = 0;
                }
                StretchScrollView.this.f12047c.scrollTo(0, StretchScrollView.this.q);
                sendEmptyMessageDelayed(1, 20L);
            }
        }
    }

    public StretchScrollView(Context context) {
        super(context);
        g();
    }

    private void f(MotionEvent motionEvent) {
        int scrollY;
        int action = motionEvent.getAction();
        if (action == 1) {
            int scrollY2 = this.f12047c.getScrollY();
            this.q = scrollY2;
            if (scrollY2 != 0) {
                this.f12049f = true;
                this.x = (int) (scrollY2 / 10.0f);
                this.y.sendEmptyMessage(1);
            }
        } else if (action == 2) {
            float y = motionEvent.getY();
            int i = (int) (this.f12048d - y);
            this.f12048d = y;
            if (h() && (scrollY = this.f12047c.getScrollY()) < 400 && scrollY > -400) {
                this.f12047c.scrollBy(0, (int) (i * 0.4f));
                this.f12049f = false;
            }
        }
    }

    private void g() {
        setOverScrollMode(2);
    }

    private boolean h() {
        int measuredHeight = this.f12047c.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();
        return scrollY == 0 || scrollY == measuredHeight;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.f12047c = getChildAt(0);
        }
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f12048d = motionEvent.getY();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f12047c != null) {
            f(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public StretchScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g();
    }

    public StretchScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        g();
    }
}
