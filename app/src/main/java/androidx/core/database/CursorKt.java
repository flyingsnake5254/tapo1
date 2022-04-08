package androidx.core.database;

import android.database.Cursor;
import kotlin.jvm.internal.j;

/* compiled from: Cursor.kt */
/* loaded from: classes.dex */
public final class CursorKt {
    public static final byte[] getBlobOrNull(Cursor getBlobOrNull, int i) {
        j.f(getBlobOrNull, "$this$getBlobOrNull");
        if (getBlobOrNull.isNull(i)) {
            return null;
        }
        return getBlobOrNull.getBlob(i);
    }

    public static final Double getDoubleOrNull(Cursor getDoubleOrNull, int i) {
        j.f(getDoubleOrNull, "$this$getDoubleOrNull");
        if (getDoubleOrNull.isNull(i)) {
            return null;
        }
        return Double.valueOf(getDoubleOrNull.getDouble(i));
    }

    public static final Float getFloatOrNull(Cursor getFloatOrNull, int i) {
        j.f(getFloatOrNull, "$this$getFloatOrNull");
        if (getFloatOrNull.isNull(i)) {
            return null;
        }
        return Float.valueOf(getFloatOrNull.getFloat(i));
    }

    public static final Integer getIntOrNull(Cursor getIntOrNull, int i) {
        j.f(getIntOrNull, "$this$getIntOrNull");
        if (getIntOrNull.isNull(i)) {
            return null;
        }
        return Integer.valueOf(getIntOrNull.getInt(i));
    }

    public static final Long getLongOrNull(Cursor getLongOrNull, int i) {
        j.f(getLongOrNull, "$this$getLongOrNull");
        if (getLongOrNull.isNull(i)) {
            return null;
        }
        return Long.valueOf(getLongOrNull.getLong(i));
    }

    public static final Short getShortOrNull(Cursor getShortOrNull, int i) {
        j.f(getShortOrNull, "$this$getShortOrNull");
        if (getShortOrNull.isNull(i)) {
            return null;
        }
        return Short.valueOf(getShortOrNull.getShort(i));
    }

    public static final String getStringOrNull(Cursor getStringOrNull, int i) {
        j.f(getStringOrNull, "$this$getStringOrNull");
        if (getStringOrNull.isNull(i)) {
            return null;
        }
        return getStringOrNull.getString(i);
    }
}
