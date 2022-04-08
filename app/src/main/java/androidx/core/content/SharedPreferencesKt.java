package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: SharedPreferences.kt */
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences edit, boolean z, l<? super SharedPreferences.Editor, p> action) {
        j.f(edit, "$this$edit");
        j.f(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        j.b(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences edit, boolean z, l action, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        j.f(edit, "$this$edit");
        j.f(action, "action");
        SharedPreferences.Editor editor = edit.edit();
        j.b(editor, "editor");
        action.invoke(editor);
        if (z) {
            editor.commit();
        } else {
            editor.apply();
        }
    }
}
