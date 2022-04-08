package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.TypeCastException;
import kotlin.f;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;
import kotlin.reflect.c;

/* compiled from: NavArgsLazy.kt */
/* loaded from: classes.dex */
public final class NavArgsLazy<Args extends NavArgs> implements f<Args> {
    private final a<Bundle> argumentProducer;
    private Args cached;
    private final c<Args> navArgsClass;

    public NavArgsLazy(c<Args> navArgsClass, a<Bundle> argumentProducer) {
        j.f(navArgsClass, "navArgsClass");
        j.f(argumentProducer, "argumentProducer");
        this.navArgsClass = navArgsClass;
        this.argumentProducer = argumentProducer;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // kotlin.f
    public Args getValue() {
        Args args = this.cached;
        if (args != null) {
            return args;
        }
        Bundle invoke = this.argumentProducer.invoke();
        Method method = NavArgsLazyKt.getMethodMap().get(this.navArgsClass);
        if (method == null) {
            Class a = kotlin.jvm.a.a(this.navArgsClass);
            Class<Bundle>[] methodSignature = NavArgsLazyKt.getMethodSignature();
            method = a.getMethod("fromBundle", (Class[]) Arrays.copyOf(methodSignature, methodSignature.length));
            NavArgsLazyKt.getMethodMap().put(this.navArgsClass, method);
            j.b(method, "navArgsClass.java.getMet…hod\n                    }");
        }
        Object invoke2 = method.invoke(null, invoke);
        if (invoke2 != null) {
            Args args2 = (Args) ((NavArgs) invoke2);
            this.cached = args2;
            return args2;
        }
        throw new TypeCastException("null cannot be cast to non-null type Args");
    }
}
