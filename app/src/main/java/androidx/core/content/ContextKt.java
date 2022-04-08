package androidx.core.content;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleRes;
import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Context.kt */
/* loaded from: classes.dex */
public final class ContextKt {
    public static final /* synthetic */ <T> T getSystemService(Context getSystemService) {
        j.f(getSystemService, "$this$getSystemService");
        j.j(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) ContextCompat.getSystemService(getSystemService, Object.class);
    }

    public static final void withStyledAttributes(Context withStyledAttributes, AttributeSet attributeSet, int[] attrs, @AttrRes int i, @StyleRes int i2, l<? super TypedArray, p> block) {
        j.f(withStyledAttributes, "$this$withStyledAttributes");
        j.f(attrs, "attrs");
        j.f(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i, i2);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(Context withStyledAttributes, AttributeSet attributeSet, int[] attrs, int i, int i2, l block, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        j.f(withStyledAttributes, "$this$withStyledAttributes");
        j.f(attrs, "attrs");
        j.f(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i, i2);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(Context withStyledAttributes, @StyleRes int i, int[] attrs, l<? super TypedArray, p> block) {
        j.f(withStyledAttributes, "$this$withStyledAttributes");
        j.f(attrs, "attrs");
        j.f(block, "block");
        TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(i, attrs);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
