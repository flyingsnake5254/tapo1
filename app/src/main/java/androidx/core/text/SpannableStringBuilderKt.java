package androidx.core.text;

import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.ColorInt;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SpannableStringBuilder.kt */
/* loaded from: classes.dex */
public final class SpannableStringBuilderKt {
    public static final SpannableStringBuilder backgroundColor(SpannableStringBuilder backgroundColor, @ColorInt int i, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(backgroundColor, "$this$backgroundColor");
        j.f(builderAction, "builderAction");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(i);
        int length = backgroundColor.length();
        builderAction.invoke(backgroundColor);
        backgroundColor.setSpan(backgroundColorSpan, length, backgroundColor.length(), 17);
        return backgroundColor;
    }

    public static final SpannableStringBuilder bold(SpannableStringBuilder bold, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(bold, "$this$bold");
        j.f(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(1);
        int length = bold.length();
        builderAction.invoke(bold);
        bold.setSpan(styleSpan, length, bold.length(), 17);
        return bold;
    }

    public static final SpannedString buildSpannedString(l<? super SpannableStringBuilder, p> builderAction) {
        j.f(builderAction, "builderAction");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        builderAction.invoke(spannableStringBuilder);
        return new SpannedString(spannableStringBuilder);
    }

    public static final SpannableStringBuilder color(SpannableStringBuilder color, @ColorInt int i, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(color, "$this$color");
        j.f(builderAction, "builderAction");
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i);
        int length = color.length();
        builderAction.invoke(color);
        color.setSpan(foregroundColorSpan, length, color.length(), 17);
        return color;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder inSpans, Object[] spans, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(inSpans, "$this$inSpans");
        j.f(spans, "spans");
        j.f(builderAction, "builderAction");
        int length = inSpans.length();
        builderAction.invoke(inSpans);
        for (Object obj : spans) {
            inSpans.setSpan(obj, length, inSpans.length(), 17);
        }
        return inSpans;
    }

    public static final SpannableStringBuilder italic(SpannableStringBuilder italic, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(italic, "$this$italic");
        j.f(builderAction, "builderAction");
        StyleSpan styleSpan = new StyleSpan(2);
        int length = italic.length();
        builderAction.invoke(italic);
        italic.setSpan(styleSpan, length, italic.length(), 17);
        return italic;
    }

    public static final SpannableStringBuilder scale(SpannableStringBuilder scale, float f2, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(scale, "$this$scale");
        j.f(builderAction, "builderAction");
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(f2);
        int length = scale.length();
        builderAction.invoke(scale);
        scale.setSpan(relativeSizeSpan, length, scale.length(), 17);
        return scale;
    }

    public static final SpannableStringBuilder strikeThrough(SpannableStringBuilder strikeThrough, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(strikeThrough, "$this$strikeThrough");
        j.f(builderAction, "builderAction");
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        int length = strikeThrough.length();
        builderAction.invoke(strikeThrough);
        strikeThrough.setSpan(strikethroughSpan, length, strikeThrough.length(), 17);
        return strikeThrough;
    }

    public static final SpannableStringBuilder subscript(SpannableStringBuilder subscript, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(subscript, "$this$subscript");
        j.f(builderAction, "builderAction");
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        int length = subscript.length();
        builderAction.invoke(subscript);
        subscript.setSpan(subscriptSpan, length, subscript.length(), 17);
        return subscript;
    }

    public static final SpannableStringBuilder superscript(SpannableStringBuilder superscript, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(superscript, "$this$superscript");
        j.f(builderAction, "builderAction");
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        int length = superscript.length();
        builderAction.invoke(superscript);
        superscript.setSpan(superscriptSpan, length, superscript.length(), 17);
        return superscript;
    }

    public static final SpannableStringBuilder underline(SpannableStringBuilder underline, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(underline, "$this$underline");
        j.f(builderAction, "builderAction");
        UnderlineSpan underlineSpan = new UnderlineSpan();
        int length = underline.length();
        builderAction.invoke(underline);
        underline.setSpan(underlineSpan, length, underline.length(), 17);
        return underline;
    }

    public static final SpannableStringBuilder inSpans(SpannableStringBuilder inSpans, Object span, l<? super SpannableStringBuilder, p> builderAction) {
        j.f(inSpans, "$this$inSpans");
        j.f(span, "span");
        j.f(builderAction, "builderAction");
        int length = inSpans.length();
        builderAction.invoke(inSpans);
        inSpans.setSpan(span, length, inSpans.length(), 17);
        return inSpans;
    }
}
