package androidx.core.location;

import android.location.Location;
import kotlin.jvm.internal.j;

/* compiled from: Location.kt */
/* loaded from: classes.dex */
public final class LocationKt {
    public static final double component1(Location component1) {
        j.f(component1, "$this$component1");
        return component1.getLatitude();
    }

    public static final double component2(Location component2) {
        j.f(component2, "$this$component2");
        return component2.getLongitude();
    }
}
