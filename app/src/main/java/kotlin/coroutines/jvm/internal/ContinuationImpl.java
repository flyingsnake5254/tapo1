package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlin.jvm.internal.j;

/* compiled from: ContinuationImpl.kt */
/* loaded from: classes4.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final f _context;
    private transient c<Object> intercepted;

    public ContinuationImpl(c<Object> cVar, f fVar) {
        super(cVar);
        this._context = fVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, kotlin.coroutines.c
    public f getContext() {
        f fVar = this._context;
        j.c(fVar);
        return fVar;
    }

    public final c<Object> intercepted() {
        c<Object> cVar = this.intercepted;
        if (cVar == null) {
            d dVar = (d) getContext().get(d.f16330e);
            if (dVar == null || (cVar = dVar.interceptContinuation(this)) == null) {
                cVar = this;
            }
            this.intercepted = cVar;
        }
        return cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        c<?> cVar = this.intercepted;
        if (!(cVar == null || cVar == this)) {
            f.b bVar = getContext().get(d.f16330e);
            j.c(bVar);
            ((d) bVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = b.f16332c;
    }

    public ContinuationImpl(c<Object> cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }
}
