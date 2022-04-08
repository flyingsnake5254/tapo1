package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes4.dex */
public final class p0 implements y0 {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16522c;

    public p0(boolean z) {
        this.f16522c = z;
    }

    @Override // kotlinx.coroutines.y0
    public n1 d() {
        return null;
    }

    @Override // kotlinx.coroutines.y0
    public boolean isActive() {
        return this.f16522c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
