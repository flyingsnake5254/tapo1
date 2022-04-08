package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.jvm.internal.j;

/* compiled from: Html.kt */
/* loaded from: classes.dex */
public final class HtmlKt {
    public static final Spanned parseAsHtml(String parseAsHtml, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        j.f(parseAsHtml, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(parseAsHtml, i, imageGetter, tagHandler);
        j.b(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String parseAsHtml, int i, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            imageGetter = null;
        }
        if ((i2 & 4) != 0) {
            tagHandler = null;
        }
        j.f(parseAsHtml, "$this$parseAsHtml");
        Spanned fromHtml = HtmlCompat.fromHtml(parseAsHtml, i, imageGetter, tagHandler);
        j.b(fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    public static final String toHtml(Spanned toHtml, int i) {
        j.f(toHtml, "$this$toHtml");
        String html = HtmlCompat.toHtml(toHtml, i);
        j.b(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned toHtml, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        j.f(toHtml, "$this$toHtml");
        String html = HtmlCompat.toHtml(toHtml, i);
        j.b(html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
