package androidx.navigation;

import androidx.lifecycle.ViewModelProvider;
import kotlin.f;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.j;

/* compiled from: NavGraphViewModelLazy.kt */
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements a<ViewModelProvider.Factory> {
    final /* synthetic */ f $backStackEntry;
    final /* synthetic */ j $backStackEntry$metadata;
    final /* synthetic */ a $factoryProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(a aVar, f fVar, j jVar) {
        super(0);
        this.$factoryProducer = aVar;
        this.$backStackEntry = fVar;
        this.$backStackEntry$metadata = jVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.b.a
    public final ViewModelProvider.Factory invoke() {
        ViewModelProvider.Factory factory;
        a aVar = this.$factoryProducer;
        if (aVar != null && (factory = (ViewModelProvider.Factory) aVar.invoke()) != null) {
            return factory;
        }
        NavBackStackEntry backStackEntry = (NavBackStackEntry) this.$backStackEntry.getValue();
        kotlin.jvm.internal.j.b(backStackEntry, "backStackEntry");
        ViewModelProvider.Factory defaultViewModelProviderFactory = backStackEntry.getDefaultViewModelProviderFactory();
        kotlin.jvm.internal.j.b(defaultViewModelProviderFactory, "backStackEntry.defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
