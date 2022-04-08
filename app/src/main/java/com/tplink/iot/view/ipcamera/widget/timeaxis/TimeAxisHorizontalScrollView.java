package com.tplink.iot.view.ipcamera.widget.timeaxis;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes2.dex */
public class TimeAxisHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: d  reason: collision with root package name */
    private a f9407d;

    /* renamed from: c  reason: collision with root package name */
    private b f9406c = null;

    /* renamed from: f  reason: collision with root package name */
    private int f9408f = 0;
    private int q = 0;
    private float x = 1.0f;
    private float y = -1.0f;
    private float z = -1.0f;
    private boolean p0 = false;
    private boolean p1 = false;
    private boolean p2 = true;

    /* loaded from: classes2.dex */
    public interface a {
        void a(float f2);

        void b(float f2);

        void c(float f2);

        void d(float f2);
    }

    /* loaded from: classes2.dex */
    protected interface b {
        void b();

        void c();

        void d(TimeAxisHorizontalScrollView timeAxisHorizontalScrollView, int i, int i2, int i3, int i4);

        void e();

        void f(float f2);

        void g();
    }

    public TimeAxisHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return super.canScrollHorizontally(i) && this.f9408f != 2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.p2) {
            for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
                if (parent instanceof ViewPager) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        b bVar = this.f9406c;
        if (bVar != null && this.f9408f != 2) {
            bVar.d(this, i, i2, i3, i4);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        a aVar;
        a aVar2;
        a aVar3;
        a aVar4;
        if (this.f9406c != null) {
            int action = motionEvent.getAction() & 255;
            if (action == 0) {
                a aVar5 = this.f9407d;
                if (aVar5 != null) {
                    aVar5.d(0.0f);
                    this.f9407d.b(0.0f);
                }
                this.q = 0;
                this.f9408f = 0;
                this.y = -1.0f;
                this.z = -1.0f;
            } else if (action == 1) {
                int i = this.f9408f;
                if (i == 3) {
                    if (this.p0) {
                        if (this.y >= 0.0f && (aVar2 = this.f9407d) != null) {
                            aVar2.a(motionEvent.getX() - this.y);
                        }
                        this.y = -1.0f;
                    }
                    if (this.p1) {
                        if (this.z >= 0.0f && (aVar = this.f9407d) != null) {
                            aVar.c(motionEvent.getX() - this.z);
                        }
                        this.z = -1.0f;
                    }
                } else if (i != 0) {
                    this.f9406c.b();
                }
                this.f9408f = 0;
            } else if (action != 2) {
                if (action == 5) {
                    float a2 = a(motionEvent);
                    this.x = a2;
                    if (a2 > 10.0f && this.f9408f != 2) {
                        this.f9408f = 2;
                        this.f9406c.e();
                    }
                }
            } else if (this.f9408f == 2) {
                float a3 = a(motionEvent);
                if (a3 > 10.0f) {
                    int i2 = this.q;
                    if (i2 < 2) {
                        this.q = i2 + 1;
                    } else {
                        this.q = 0;
                        this.f9406c.f((float) Math.pow(a3 / this.x, 1.0d));
                        this.x = a3;
                    }
                }
                return true;
            } else {
                if (this.p0) {
                    if (getScrollX() == 0 && this.y == -1.0f) {
                        this.y = motionEvent.getX();
                    }
                    if (this.y >= 0.0f && (aVar4 = this.f9407d) != null) {
                        this.f9408f = 3;
                        aVar4.d(motionEvent.getX() - this.y);
                    }
                }
                if (this.p1) {
                    ViewGroup viewGroup = (ViewGroup) getChildAt(0);
                    View view = null;
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        if (viewGroup.getChildAt(i3) instanceof TimeAxisScaleView) {
                            view = viewGroup.getChildAt(i3);
                        }
                    }
                    if (view != null && getScrollX() + getWidth() == view.getRight() && this.z == -1.0f) {
                        this.z = motionEvent.getX();
                    }
                    if (this.z >= 0.0f && (aVar3 = this.f9407d) != null) {
                        this.f9408f = 3;
                        aVar3.b(motionEvent.getX() - this.z);
                    }
                }
            }
        }
        if (this.f9408f == 2) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
        b bVar = this.f9406c;
        if (bVar != null && overScrollBy) {
            if (i > 0) {
                bVar.g();
            } else {
                bVar.c();
            }
        }
        return overScrollBy;
    }

    public void setCanLoadLeftMore(boolean z) {
        this.p0 = z;
    }

    public void setCanLoadRightMore(boolean z) {
        this.p1 = z;
    }

    public void setInterceptTouch(boolean z) {
        this.p2 = z;
    }

    public void setOnLoadingMoreListener(a aVar) {
        this.f9407d = aVar;
    }

    public void setScrollViewListener(b bVar) {
        this.f9406c = bVar;
    }

    public TimeAxisHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimeAxisHorizontalScrollView(Context context) {
        super(context);
    }
}
