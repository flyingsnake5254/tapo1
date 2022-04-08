package com.tplink.iot.Utils;

import android.content.Context;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/* compiled from: SpannableStringInstance.java */
/* loaded from: classes2.dex */
public class e0 {

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    class a extends h {
        final /* synthetic */ f y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i, int i2, boolean z, f fVar) {
            super(i, i2, z);
            this.y = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.y.b(view);
        }
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    class b extends h {
        final /* synthetic */ f y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i, int i2, boolean z, f fVar) {
            super(i, i2, z);
            this.y = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.y.b(view);
        }
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    class c extends h {
        final /* synthetic */ f y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(int i, int i2, boolean z, f fVar) {
            super(i, i2, z);
            this.y = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.y.a(view);
        }
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    class d extends h {
        final /* synthetic */ f y;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(int i, int i2, boolean z, f fVar) {
            super(i, i2, z);
            this.y = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            this.y.b(view);
        }
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    public class e extends LinkMovementMethod {
        private h a;

        public e() {
        }

        public h a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int x = ((int) motionEvent.getX()) - textView.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - textView.getTotalPaddingTop();
            int scrollX = x + textView.getScrollX();
            Layout layout = textView.getLayout();
            int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y + textView.getScrollY()), scrollX);
            h[] hVarArr = (h[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, h.class);
            if (hVarArr.length > 0) {
                return hVarArr[0];
            }
            return null;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                h a = a(textView, spannable, motionEvent);
                this.a = a;
                if (a != null) {
                    a.a(true);
                    Selection.setSelection(spannable, spannable.getSpanStart(this.a), spannable.getSpanEnd(this.a));
                }
            } else if (motionEvent.getAction() == 2) {
                h a2 = a(textView, spannable, motionEvent);
                h hVar = this.a;
                if (!(hVar == null || a2 == hVar)) {
                    hVar.a(false);
                    this.a = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                h hVar2 = this.a;
                if (hVar2 != null) {
                    hVar2.a(false);
                    super.onTouchEvent(textView, spannable, motionEvent);
                }
                this.a = null;
                Selection.removeSelection(spannable);
            }
            return true;
        }
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    public interface f {
        void a(View view);

        void b(View view);
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    private static class g {
        private static final e0 a = new e0();
    }

    /* compiled from: SpannableStringInstance.java */
    /* loaded from: classes2.dex */
    public abstract class h extends ClickableSpan {

        /* renamed from: c  reason: collision with root package name */
        private boolean f5302c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5303d;

        /* renamed from: f  reason: collision with root package name */
        private int f5304f;
        private int q;

        public h(int i, int i2, boolean z) {
            this.f5304f = i;
            this.q = i2;
            this.f5303d = z;
        }

        public void a(boolean z) {
            this.f5302c = z;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f5302c ? this.q : this.f5304f);
            textPaint.setUnderlineText(this.f5303d);
        }
    }

    public static e0 d() {
        return g.a;
    }

    public SpannableString a(Context context, int i, String str, String str2, boolean z, int i2, int i3, f fVar) {
        int indexOf = context.getString(i, "deco_m6_divider-span-symbol").indexOf("deco_m6_divider-span-symbol");
        int length = str.length() + indexOf;
        SpannableString spannableString = new SpannableString(context.getString(i, str));
        if (!TextUtils.isEmpty(str2)) {
            spannableString.setSpan(new TypefaceSpan(str2), indexOf, length, 33);
        }
        if (fVar != null) {
            spannableString.setSpan(new d(i2, i3, z, fVar), indexOf, length, 33);
        } else if (z) {
            spannableString.setSpan(new UnderlineSpan(), indexOf, length, 33);
        }
        return spannableString;
    }

    public SpannableString b(Context context, int i, String str, boolean z, int i2, int i3, f fVar) {
        int indexOf = context.getString(i, "deco_m6_divider-span-symbol").indexOf("deco_m6_divider-span-symbol");
        int length = str.length() + indexOf;
        SpannableString spannableString = new SpannableString(context.getString(i, str));
        if (fVar != null) {
            spannableString.setSpan(new a(i2, i3, z, fVar), indexOf, length, 33);
        } else if (z) {
            spannableString.setSpan(new UnderlineSpan(), indexOf, length, 33);
        }
        return spannableString;
    }

    public SpannableString c(Context context, int i, String str, String str2, boolean z, int i2, int i3, f fVar) {
        String string = context.getString(i, str, str2);
        int indexOf = string.indexOf(str);
        int length = str.length() + indexOf;
        int indexOf2 = string.indexOf(str2);
        int length2 = str2.length() + indexOf2;
        SpannableString spannableString = new SpannableString(string);
        if (fVar != null) {
            spannableString.setSpan(new b(i2, i3, z, fVar), indexOf, length, 33);
            spannableString.setSpan(new c(i2, i3, z, fVar), indexOf2, length2, 33);
        } else if (z) {
            spannableString.setSpan(new UnderlineSpan(), indexOf, length, 33);
            spannableString.setSpan(new UnderlineSpan(), indexOf2, length2, 33);
        }
        return spannableString;
    }

    public LinkMovementMethod e() {
        return new e();
    }
}
