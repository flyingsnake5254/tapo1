package androidx.lifecycle;

import kotlin.jvm.internal.j;
import kotlinx.coroutines.d0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.v1;

/* compiled from: ViewModel.kt */
/* loaded from: classes.dex */
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final d0 getViewModelScope(ViewModel viewModelScope) {
        j.f(viewModelScope, "$this$viewModelScope");
        d0 d0Var = (d0) viewModelScope.getTag(JOB_KEY);
        if (d0Var != null) {
            return d0Var;
        }
        Object tagIfAbsent = viewModelScope.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(v1.b(null, 1, null).plus(n0.b().u())));
        j.b(tagIfAbsent, "setTagIfAbsent(JOB_KEY,\n…patchers.Main.immediate))");
        return (d0) tagIfAbsent;
    }
}
