package com.tplink.libtpcontrols.treerecyclerview;

/* compiled from: TreeNode.java */
/* loaded from: classes3.dex */
public class a<T> {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private T f12462b;

    /* renamed from: c  reason: collision with root package name */
    private int f12463c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f12464d;

    public String a() {
        return this.a;
    }

    public int b() {
        return this.f12463c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f12463c != aVar.f12463c || this.f12464d != aVar.f12464d) {
            return false;
        }
        String str = this.a;
        if (str == null ? aVar.a == null : str.equals(aVar.a)) {
            return this.f12462b.equals(aVar.f12462b);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        return ((((((str != null ? str.hashCode() : 0) * 31) + this.f12462b.hashCode()) * 31) + this.f12463c) * 31) + (this.f12464d ? 1 : 0);
    }
}
