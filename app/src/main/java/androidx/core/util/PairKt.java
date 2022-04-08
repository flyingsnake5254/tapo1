package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;
import kotlin.jvm.internal.j;

/* compiled from: Pair.kt */
/* loaded from: classes.dex */
public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> component1) {
        j.f(component1, "$this$component1");
        return (F) component1.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> component2) {
        j.f(component2, "$this$component2");
        return (S) component2.second;
    }

    public static final <F, S> Pair<F, S> toAndroidPair(kotlin.Pair<? extends F, ? extends S> toAndroidPair) {
        j.f(toAndroidPair, "$this$toAndroidPair");
        return new Pair<>(toAndroidPair.getFirst(), toAndroidPair.getSecond());
    }

    public static final <F, S> kotlin.Pair<F, S> toKotlinPair(Pair<F, S> toKotlinPair) {
        j.f(toKotlinPair, "$this$toKotlinPair");
        return new kotlin.Pair<>(toKotlinPair.first, toKotlinPair.second);
    }
}
