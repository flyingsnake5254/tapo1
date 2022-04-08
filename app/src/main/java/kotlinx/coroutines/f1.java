package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public class f1 extends j1 implements q {

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16449d = p0();

    public f1(d1 d1Var) {
        super(true);
        O(d1Var);
    }

    private final boolean p0() {
        j1 j1Var;
        m mVar = this.parentHandle;
        if (!(mVar instanceof n)) {
            mVar = null;
        }
        n nVar = (n) mVar;
        if (!(nVar == null || (j1Var = (j1) nVar.q) == null)) {
            while (!j1Var.I()) {
                m mVar2 = j1Var.parentHandle;
                if (!(mVar2 instanceof n)) {
                    mVar2 = null;
                }
                n nVar2 = (n) mVar2;
                if (nVar2 != null) {
                    j1Var = (j1) nVar2.q;
                    if (j1Var == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.j1
    public boolean I() {
        return this.f16449d;
    }

    @Override // kotlinx.coroutines.j1
    public boolean J() {
        return true;
    }
}
