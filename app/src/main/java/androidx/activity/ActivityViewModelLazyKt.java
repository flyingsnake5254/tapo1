package androidx.activity;

import androidx.annotation.MainThread;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import kotlin.f;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> f<VM> viewModels(ComponentActivity viewModels, a<? extends ViewModelProvider.Factory> aVar) {
        j.f(viewModels, "$this$viewModels");
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        j.j(4, "VM");
        return new ViewModelLazy(m.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(viewModels), aVar);
    }

    public static /* synthetic */ f viewModels$default(ComponentActivity viewModels, a aVar, int i, Object obj) {
        if ((i & 1) != 0) {
            aVar = null;
        }
        j.f(viewModels, "$this$viewModels");
        if (aVar == null) {
            aVar = new ActivityViewModelLazyKt$viewModels$factoryPromise$1(viewModels);
        }
        j.j(4, "VM");
        return new ViewModelLazy(m.b(ViewModel.class), new ActivityViewModelLazyKt$viewModels$1(viewModels), aVar);
    }
}
