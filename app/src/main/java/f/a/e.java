package f.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;

/* compiled from: SkinCompatManager.java */
/* loaded from: classes4.dex */
public class e extends f.a.g.a {
    private static volatile e a;

    /* compiled from: SkinCompatManager.java */
    /* loaded from: classes4.dex */
    public interface a {
        Drawable a(Context context, String str, int i);

        String b(Context context, String str, int i);

        ColorStateList c(Context context, String str, int i);

        ColorStateList d(Context context, String str, int i);
    }

    public static e a() {
        return a;
    }
}
