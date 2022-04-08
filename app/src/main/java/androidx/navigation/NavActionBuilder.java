package androidx.navigation;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.collections.f0;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: NavDestinationBuilder.kt */
@NavDestinationDsl
/* loaded from: classes.dex */
public final class NavActionBuilder {
    private final Map<String, Object> defaultArguments = new LinkedHashMap();
    private int destinationId;
    private NavOptions navOptions;

    public final NavAction build$navigation_common_ktx_release() {
        Bundle bundle;
        List n;
        int i = this.destinationId;
        NavOptions navOptions = this.navOptions;
        if (this.defaultArguments.isEmpty()) {
            bundle = null;
        } else {
            n = f0.n(this.defaultArguments);
            Object[] array = n.toArray(new Pair[0]);
            if (array != null) {
                Pair[] pairArr = (Pair[]) array;
                bundle = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        return new NavAction(i, navOptions, bundle);
    }

    public final Map<String, Object> getDefaultArguments() {
        return this.defaultArguments;
    }

    public final int getDestinationId() {
        return this.destinationId;
    }

    public final void navOptions(l<? super NavOptionsBuilder, p> optionsBuilder) {
        j.f(optionsBuilder, "optionsBuilder");
        NavOptionsBuilder navOptionsBuilder = new NavOptionsBuilder();
        optionsBuilder.invoke(navOptionsBuilder);
        this.navOptions = navOptionsBuilder.build$navigation_common_ktx_release();
    }

    public final void setDestinationId(int i) {
        this.destinationId = i;
    }
}
