package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.internal.j;

/* compiled from: SpannedString.kt */
/* loaded from: classes.dex */
public final class SpannedStringKt {
    public static final /* synthetic */ <T> T[] getSpans(Spanned getSpans, int i, int i2) {
        j.f(getSpans, "$this$getSpans");
        j.j(4, ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) getSpans.getSpans(i, i2, Object.class);
        j.b(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ Object[] getSpans$default(Spanned getSpans, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = getSpans.length();
        }
        j.f(getSpans, "$this$getSpans");
        j.j(4, ExifInterface.GPS_DIRECTION_TRUE);
        Object[] spans = getSpans.getSpans(i, i2, Object.class);
        j.b(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    public static final Spanned toSpanned(CharSequence toSpanned) {
        j.f(toSpanned, "$this$toSpanned");
        SpannedString valueOf = SpannedString.valueOf(toSpanned);
        j.b(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
