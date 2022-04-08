package kotlin.jvm.internal;

/* compiled from: PackageReference.kt */
/* loaded from: classes4.dex */
public final class l implements c {

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f16348c;

    /* renamed from: d  reason: collision with root package name */
    private final String f16349d;

    public l(Class<?> jClass, String moduleName) {
        j.e(jClass, "jClass");
        j.e(moduleName, "moduleName");
        this.f16348c = jClass;
        this.f16349d = moduleName;
    }

    @Override // kotlin.jvm.internal.c
    public Class<?> a() {
        return this.f16348c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof l) && j.a(a(), ((l) obj).a());
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString() + " (Kotlin reflection is not available)";
    }
}
