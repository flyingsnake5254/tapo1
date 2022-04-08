package com.airbnb.lottie.model;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* loaded from: classes.dex */
public class d {
    public static final d a = new d("COMPOSITION");

    /* renamed from: b  reason: collision with root package name */
    private final List<String> f1014b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private e f1015c;

    public d(String... strArr) {
        this.f1014b = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f1014b;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d a(String str) {
        d dVar = new d(this);
        dVar.f1014b.add(str);
        return dVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i) {
        if (i >= this.f1014b.size()) {
            return false;
        }
        boolean z = i == this.f1014b.size() - 1;
        String str2 = this.f1014b.get(i);
        if (!str2.equals("**")) {
            return (z || (i == this.f1014b.size() + (-2) && b())) && (str2.equals(str) || str2.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD));
        }
        if (!z && this.f1014b.get(i + 1).equals(str)) {
            return i == this.f1014b.size() + (-2) || (i == this.f1014b.size() + (-3) && b());
        }
        if (z) {
            return true;
        }
        int i2 = i + 1;
        if (i2 < this.f1014b.size() - 1) {
            return false;
        }
        return this.f1014b.get(i2).equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e d() {
        return this.f1015c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int e(String str, int i) {
        if (f(str)) {
            return 0;
        }
        if (!this.f1014b.get(i).equals("**")) {
            return 1;
        }
        return (i != this.f1014b.size() - 1 && this.f1014b.get(i + 1).equals(str)) ? 2 : 0;
    }

    public String g() {
        return this.f1014b.toString();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean h(String str, int i) {
        if (f(str)) {
            return true;
        }
        if (i >= this.f1014b.size()) {
            return false;
        }
        return this.f1014b.get(i).equals(str) || this.f1014b.get(i).equals("**") || this.f1014b.get(i).equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i(String str, int i) {
        return "__container".equals(str) || i < this.f1014b.size() - 1 || this.f1014b.get(i).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public d j(e eVar) {
        d dVar = new d(this);
        dVar.f1015c = eVar;
        return dVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f1014b);
        sb.append(",resolved=");
        sb.append(this.f1015c != null);
        sb.append('}');
        return sb.toString();
    }

    private d(d dVar) {
        this.f1014b = new ArrayList(dVar.f1014b);
        this.f1015c = dVar.f1015c;
    }
}
