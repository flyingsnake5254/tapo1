package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

/* compiled from: TypedArray.kt */
/* loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(TypedArray typedArray, @StyleableRes int i) {
        if (!typedArray.hasValue(i)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(TypedArray getBooleanOrThrow, @StyleableRes int i) {
        j.f(getBooleanOrThrow, "$this$getBooleanOrThrow");
        checkAttribute(getBooleanOrThrow, i);
        return getBooleanOrThrow.getBoolean(i, false);
    }

    @ColorInt
    public static final int getColorOrThrow(TypedArray getColorOrThrow, @StyleableRes int i) {
        j.f(getColorOrThrow, "$this$getColorOrThrow");
        checkAttribute(getColorOrThrow, i);
        return getColorOrThrow.getColor(i, 0);
    }

    public static final ColorStateList getColorStateListOrThrow(TypedArray getColorStateListOrThrow, @StyleableRes int i) {
        j.f(getColorStateListOrThrow, "$this$getColorStateListOrThrow");
        checkAttribute(getColorStateListOrThrow, i);
        ColorStateList colorStateList = getColorStateListOrThrow.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(TypedArray getDimensionOrThrow, @StyleableRes int i) {
        j.f(getDimensionOrThrow, "$this$getDimensionOrThrow");
        checkAttribute(getDimensionOrThrow, i);
        return getDimensionOrThrow.getDimension(i, 0.0f);
    }

    @Dimension
    public static final int getDimensionPixelOffsetOrThrow(TypedArray getDimensionPixelOffsetOrThrow, @StyleableRes int i) {
        j.f(getDimensionPixelOffsetOrThrow, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(getDimensionPixelOffsetOrThrow, i);
        return getDimensionPixelOffsetOrThrow.getDimensionPixelOffset(i, 0);
    }

    @Dimension
    public static final int getDimensionPixelSizeOrThrow(TypedArray getDimensionPixelSizeOrThrow, @StyleableRes int i) {
        j.f(getDimensionPixelSizeOrThrow, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(getDimensionPixelSizeOrThrow, i);
        return getDimensionPixelSizeOrThrow.getDimensionPixelSize(i, 0);
    }

    public static final Drawable getDrawableOrThrow(TypedArray getDrawableOrThrow, @StyleableRes int i) {
        j.f(getDrawableOrThrow, "$this$getDrawableOrThrow");
        checkAttribute(getDrawableOrThrow, i);
        Drawable drawable = getDrawableOrThrow.getDrawable(i);
        if (drawable == null) {
            j.n();
        }
        return drawable;
    }

    public static final float getFloatOrThrow(TypedArray getFloatOrThrow, @StyleableRes int i) {
        j.f(getFloatOrThrow, "$this$getFloatOrThrow");
        checkAttribute(getFloatOrThrow, i);
        return getFloatOrThrow.getFloat(i, 0.0f);
    }

    @RequiresApi(26)
    public static final Typeface getFontOrThrow(TypedArray getFontOrThrow, @StyleableRes int i) {
        j.f(getFontOrThrow, "$this$getFontOrThrow");
        checkAttribute(getFontOrThrow, i);
        Typeface font = getFontOrThrow.getFont(i);
        if (font == null) {
            j.n();
        }
        return font;
    }

    public static final int getIntOrThrow(TypedArray getIntOrThrow, @StyleableRes int i) {
        j.f(getIntOrThrow, "$this$getIntOrThrow");
        checkAttribute(getIntOrThrow, i);
        return getIntOrThrow.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(TypedArray getIntegerOrThrow, @StyleableRes int i) {
        j.f(getIntegerOrThrow, "$this$getIntegerOrThrow");
        checkAttribute(getIntegerOrThrow, i);
        return getIntegerOrThrow.getInteger(i, 0);
    }

    @AnyRes
    public static final int getResourceIdOrThrow(TypedArray getResourceIdOrThrow, @StyleableRes int i) {
        j.f(getResourceIdOrThrow, "$this$getResourceIdOrThrow");
        checkAttribute(getResourceIdOrThrow, i);
        return getResourceIdOrThrow.getResourceId(i, 0);
    }

    public static final String getStringOrThrow(TypedArray getStringOrThrow, @StyleableRes int i) {
        j.f(getStringOrThrow, "$this$getStringOrThrow");
        checkAttribute(getStringOrThrow, i);
        String string = getStringOrThrow.getString(i);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    public static final CharSequence[] getTextArrayOrThrow(TypedArray getTextArrayOrThrow, @StyleableRes int i) {
        j.f(getTextArrayOrThrow, "$this$getTextArrayOrThrow");
        checkAttribute(getTextArrayOrThrow, i);
        CharSequence[] textArray = getTextArrayOrThrow.getTextArray(i);
        j.b(textArray, "getTextArray(index)");
        return textArray;
    }

    public static final CharSequence getTextOrThrow(TypedArray getTextOrThrow, @StyleableRes int i) {
        j.f(getTextOrThrow, "$this$getTextOrThrow");
        checkAttribute(getTextOrThrow, i);
        CharSequence text = getTextOrThrow.getText(i);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(TypedArray use, l<? super TypedArray, ? extends R> block) {
        j.f(use, "$this$use");
        j.f(block, "block");
        R r = (R) block.invoke(use);
        use.recycle();
        return r;
    }
}
