package kotlinx.coroutines;

import kotlin.coroutines.f;

/* compiled from: CoroutineExceptionHandler.kt */
/* loaded from: classes4.dex */
public interface CoroutineExceptionHandler extends f.b {
    public static final a g = a.a;

    /* compiled from: CoroutineExceptionHandler.kt */
    /* loaded from: classes4.dex */
    public static final class a implements f.c<CoroutineExceptionHandler> {
        static final /* synthetic */ a a = new a();

        private a() {
        }
    }

    void handleException(f fVar, Throwable th);
}
