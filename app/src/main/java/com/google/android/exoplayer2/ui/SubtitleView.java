package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.k;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class SubtitleView extends FrameLayout implements k {

    /* renamed from: c  reason: collision with root package name */
    private List<c> f3717c;

    /* renamed from: d  reason: collision with root package name */
    private f0 f3718d;

    /* renamed from: f  reason: collision with root package name */
    private int f3719f;
    private int p0;
    private a p1;
    private View p2;
    private float q;
    private float x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void a(List<c> list, f0 f0Var, float f2, int i, float f3);
    }

    public SubtitleView(Context context) {
        this(context, null);
    }

    private c a(c cVar) {
        c.b a2 = cVar.a();
        if (!this.y) {
            x0.c(a2);
        } else if (!this.z) {
            x0.d(a2);
        }
        return a2.a();
    }

    private void c(int i, float f2) {
        this.f3719f = i;
        this.q = f2;
        f();
    }

    private void f() {
        this.p1.a(getCuesWithStylingPreferencesApplied(), this.f3718d, this.q, this.f3719f, this.x);
    }

    private List<c> getCuesWithStylingPreferencesApplied() {
        if (this.y && this.z) {
            return this.f3717c;
        }
        ArrayList arrayList = new ArrayList(this.f3717c.size());
        for (int i = 0; i < this.f3717c.size(); i++) {
            arrayList.add(a(this.f3717c.get(i)));
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (o0.a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private f0 getUserCaptionStyle() {
        if (o0.a < 19 || isInEditMode()) {
            return f0.a;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return f0.a;
        }
        return f0.a(captioningManager.getUserStyle());
    }

    private <T extends View & a> void setView(T t) {
        removeView(this.p2);
        View view = this.p2;
        if (view instanceof WebViewSubtitleOutput) {
            ((WebViewSubtitleOutput) view).g();
        }
        this.p2 = t;
        this.p1 = t;
        addView(t);
    }

    @Override // com.google.android.exoplayer2.text.k
    public void B(List<c> list) {
        setCues(list);
    }

    public void b(float f2, boolean z) {
        c(z ? 1 : 0, f2);
    }

    public void d() {
        setStyle(getUserCaptionStyle());
    }

    public void e() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    public void setApplyEmbeddedFontSizes(boolean z) {
        this.z = z;
        f();
    }

    public void setApplyEmbeddedStyles(boolean z) {
        this.y = z;
        f();
    }

    public void setBottomPaddingFraction(float f2) {
        this.x = f2;
        f();
    }

    public void setCues(@Nullable List<c> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f3717c = list;
        f();
    }

    public void setFractionalTextSize(float f2) {
        b(f2, false);
    }

    public void setStyle(f0 f0Var) {
        this.f3718d = f0Var;
        f();
    }

    public void setViewType(int i) {
        if (this.p0 != i) {
            if (i == 1) {
                setView(new CanvasSubtitleOutput(getContext()));
            } else if (i == 2) {
                setView(new WebViewSubtitleOutput(getContext()));
            } else {
                throw new IllegalArgumentException();
            }
            this.p0 = i;
        }
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3717c = Collections.emptyList();
        this.f3718d = f0.a;
        this.f3719f = 0;
        this.q = 0.0533f;
        this.x = 0.08f;
        this.y = true;
        this.z = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
        this.p1 = canvasSubtitleOutput;
        this.p2 = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.p0 = 1;
    }
}
