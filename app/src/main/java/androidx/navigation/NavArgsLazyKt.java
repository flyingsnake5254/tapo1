package androidx.navigation;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;
import kotlin.reflect.c;

/* compiled from: NavArgsLazy.kt */
/* loaded from: classes.dex */
public final class NavArgsLazyKt {
    private static final Class<Bundle>[] methodSignature = {Bundle.class};
    private static final ArrayMap<c<? extends NavArgs>, Method> methodMap = new ArrayMap<>();

    public static final ArrayMap<c<? extends NavArgs>, Method> getMethodMap() {
        return methodMap;
    }

    public static final Class<Bundle>[] getMethodSignature() {
        return methodSignature;
    }
}
