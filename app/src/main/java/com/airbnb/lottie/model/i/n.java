package com.airbnb.lottie.model.i;

import com.airbnb.lottie.w.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue.java */
/* loaded from: classes.dex */
abstract class n<V, O> implements m<V, O> {
    final List<a<V>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(V v) {
        this(Collections.singletonList(new a(v)));
    }

    @Override // com.airbnb.lottie.model.i.m
    public List<a<V>> b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.model.i.m
    public boolean c() {
        return this.a.isEmpty() || (this.a.size() == 1 && this.a.get(0).h());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.a.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(this.a.toArray()));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(List<a<V>> list) {
        this.a = list;
    }
}
