package com.tplink.iot.Utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.e0;
import com.tplink.iot.widget.PointTextView;

/* compiled from: SpanUtils.java */
/* loaded from: classes2.dex */
public class d0 {

    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    static class a extends ClickableSpan {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f5294c;

        a(g gVar) {
            this.f5294c = gVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            g gVar = this.f5294c;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    static class b extends ClickableSpan {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f5295c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5296d;

        b(g gVar, int i) {
            this.f5295c = gVar;
            this.f5296d = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            g gVar = this.f5295c;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f5296d);
            textPaint.setUnderlineText(true);
        }
    }

    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    static class c extends ClickableSpan {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f5297c;

        c(g gVar) {
            this.f5297c = gVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            g gVar = this.f5297c;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    static class d implements e0.f {
        final /* synthetic */ g a;

        d(g gVar) {
            this.a = gVar;
        }

        @Override // com.tplink.iot.Utils.e0.f
        public void a(View view) {
            g gVar = this.a;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // com.tplink.iot.Utils.e0.f
        public void b(View view) {
            g gVar = this.a;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    public static class e implements e0.f {
        final /* synthetic */ g a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f5298b;

        e(g gVar, f fVar) {
            this.a = gVar;
            this.f5298b = fVar;
        }

        @Override // com.tplink.iot.Utils.e0.f
        public void a(View view) {
            f fVar = this.f5298b;
            if (fVar != null) {
                fVar.a();
            }
        }

        @Override // com.tplink.iot.Utils.e0.f
        public void b(View view) {
            g gVar = this.a;
            if (gVar != null) {
                gVar.a();
            }
        }
    }

    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    /* compiled from: SpanUtils.java */
    /* loaded from: classes2.dex */
    public interface g {
        void a();
    }

    public static void a(TextView textView, String str, String str2, int i) {
        if (textView != null) {
            int indexOf = str.indexOf(str2);
            int indexOf2 = str.indexOf(str2) + str2.length();
            SpannableString spannableString = new SpannableString(str);
            if (indexOf >= 0 && indexOf < indexOf2) {
                spannableString.setSpan(new ForegroundColorSpan(i), indexOf, indexOf2, 33);
            }
            textView.setText(spannableString);
        }
    }

    public static void b(PointTextView pointTextView, String str, String str2, int i) {
        if (pointTextView != null) {
            int indexOf = str.indexOf(str2);
            int indexOf2 = str.indexOf(str2) + str2.length();
            SpannableString spannableString = new SpannableString(str);
            if (indexOf >= 0 && indexOf < indexOf2) {
                spannableString.setSpan(new ForegroundColorSpan(i), indexOf, indexOf2, 33);
            }
            pointTextView.setContent(spannableString);
        }
    }

    public static void c(TextView textView, String str, String str2, int i, g gVar) {
        if (textView != null) {
            int indexOf = str.indexOf(str2);
            int indexOf2 = str.indexOf(str2) + str2.length();
            if (indexOf == -1) {
                indexOf = 0;
                indexOf2 = str.length();
            }
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new c(gVar), indexOf, indexOf2, 33);
            spannableString.setSpan(new ForegroundColorSpan(i), indexOf, indexOf2, 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void d(Context context, TextView textView, int i, String str, g gVar) {
        if (textView != null) {
            textView.setText(e0.d().b(context, i, str, true, ContextCompat.getColor(context, R.color.common_iot_purple), ContextCompat.getColor(context, R.color.common_iot_purple), new d(gVar)));
            textView.setClickable(true);
            textView.setMovementMethod(e0.d().e());
        }
    }

    public static void e(TextView textView, String str, String str2, int i, g gVar) {
        if (textView != null) {
            int i2 = 0;
            String format = String.format(str, str2);
            SpannableString spannableString = new SpannableString(format);
            int indexOf = format.indexOf(str2);
            int indexOf2 = format.indexOf(str2) + str2.length();
            if (indexOf == -1) {
                indexOf2 = format.length();
            } else {
                i2 = indexOf;
            }
            spannableString.setSpan(new a(gVar), i2, indexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), i2, indexOf2, 33);
            spannableString.setSpan(new ForegroundColorSpan(i), i2, indexOf2, 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static void f(Context context, TextView textView, int i, String str, String str2, int i2, int i3, g gVar, f fVar) {
        if (textView != null) {
            textView.setText(e0.d().c(context, i, str, str2, true, i2, i3, new e(gVar, fVar)));
            textView.setClickable(true);
            textView.setMovementMethod(e0.d().e());
        }
    }

    public static void g(Context context, TextView textView, int i, String str, String str2, g gVar, f fVar) {
        if (context != null && textView != null) {
            f(context, textView, i, str, str2, ContextCompat.getColor(context, R.color.privacy_policy_dialog_link_text_color), ContextCompat.getColor(context, R.color.common_tplink_teal_pressed), gVar, fVar);
        }
    }

    public static void h(TextView textView, String str, int i, g gVar) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new b(gVar, i), 0, str.length(), 33);
            textView.setHighlightColor(0);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
