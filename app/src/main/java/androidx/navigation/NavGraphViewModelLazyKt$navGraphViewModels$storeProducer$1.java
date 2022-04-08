package androidx.navigation;

import androidx.lifecycle.ViewModelStore;
import kotlin.f;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.j;

/* compiled from: NavGraphViewModelLazy.kt */
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 extends Lambda implements a<ViewModelStore> {
    final /* synthetic */ f $backStackEntry;
    final /* synthetic */ j $backStackEntry$metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(f fVar, j jVar) {
        super(0);
        this.$backStackEntry = fVar;
        this.$backStackEntry$metadata = jVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelStore invoke() {
        NavBackStackEntry backStackEntry = (NavBackStackEntry) this.$backStackEntry.getValue();
        kotlin.jvm.internal.j.b(backStackEntry, "backStackEntry");
        ViewModelStore viewModelStore = backStackEntry.getViewModelStore();
        kotlin.jvm.internal.j.b(viewModelStore, "backStackEntry.viewModelStore");
        return viewModelStore;
    }
}
