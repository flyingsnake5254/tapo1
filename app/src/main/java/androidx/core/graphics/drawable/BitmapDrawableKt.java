package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import kotlin.jvm.internal.j;

/* compiled from: BitmapDrawable.kt */
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    public static final BitmapDrawable toDrawable(Bitmap toDrawable, Resources resources) {
        j.f(toDrawable, "$this$toDrawable");
        j.f(resources, "resources");
        return new BitmapDrawable(resources, toDrawable);
    }
}
