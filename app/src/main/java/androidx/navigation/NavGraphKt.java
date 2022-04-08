package androidx.navigation;

import androidx.annotation.IdRes;
import kotlin.jvm.internal.j;

/* compiled from: NavGraph.kt */
/* loaded from: classes.dex */
public final class NavGraphKt {
    public static final boolean contains(NavGraph contains, @IdRes int i) {
        j.f(contains, "$this$contains");
        return contains.findNode(i) != null;
    }

    public static final NavDestination get(NavGraph get, @IdRes int i) {
        j.f(get, "$this$get");
        NavDestination findNode = get.findNode(i);
        if (findNode != null) {
            return findNode;
        }
        throw new IllegalArgumentException("No destination for " + i + " was found in " + get);
    }

    public static final void minusAssign(NavGraph minusAssign, NavDestination node) {
        j.f(minusAssign, "$this$minusAssign");
        j.f(node, "node");
        minusAssign.remove(node);
    }

    public static final void plusAssign(NavGraph plusAssign, NavDestination node) {
        j.f(plusAssign, "$this$plusAssign");
        j.f(node, "node");
        plusAssign.addDestination(node);
    }

    public static final void plusAssign(NavGraph plusAssign, NavGraph other) {
        j.f(plusAssign, "$this$plusAssign");
        j.f(other, "other");
        plusAssign.addAll(other);
    }
}
