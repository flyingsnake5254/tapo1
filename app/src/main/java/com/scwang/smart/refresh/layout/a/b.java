package com.scwang.smart.refresh.layout.a;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.c.i;

/* compiled from: RefreshContent.java */
/* loaded from: classes2.dex */
public interface b {
    void c(MotionEvent motionEvent);

    void d(i iVar);

    void e(e eVar, View view, View view2);

    void f(boolean z);

    ValueAnimator.AnimatorUpdateListener g(int i);

    @NonNull
    View getView();

    @NonNull
    View h();

    boolean i();

    void j(int i, int i2, int i3);

    boolean k();
}
