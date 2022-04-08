package androidx.lifecycle;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.j;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider get) {
        j.f(get, "$this$get");
        j.j(4, "VM");
        VM vm = (VM) get.get(ViewModel.class);
        j.b(vm, "get(VM::class.java)");
        return vm;
    }
}
