package retrofit2;

import java.lang.annotation.Annotation;

/* compiled from: SkipCallbackExecutorImpl.java */
/* loaded from: classes4.dex */
final class u implements t {
    private static final t a = new u();

    u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Annotation[] a(Annotation[] annotationArr) {
        if (v.m(annotationArr, t.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[annotationArr.length + 1];
        annotationArr2[0] = a;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    @Override // java.lang.annotation.Annotation
    public Class<? extends Annotation> annotationType() {
        return t.class;
    }

    @Override // java.lang.annotation.Annotation
    public boolean equals(Object obj) {
        return obj instanceof t;
    }

    @Override // java.lang.annotation.Annotation
    public int hashCode() {
        return 0;
    }

    @Override // java.lang.annotation.Annotation
    public String toString() {
        return "@" + t.class.getName() + "()";
    }
}
