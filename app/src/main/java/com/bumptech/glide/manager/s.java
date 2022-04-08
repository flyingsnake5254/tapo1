package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.k.j;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: TargetTracker.java */
/* loaded from: classes.dex */
public final class s implements m {

    /* renamed from: c  reason: collision with root package name */
    private final Set<j<?>> f1703c = Collections.newSetFromMap(new WeakHashMap());

    public void g() {
        this.f1703c.clear();
    }

    @NonNull
    public List<j<?>> i() {
        return com.bumptech.glide.util.j.j(this.f1703c);
    }

    public void k(@NonNull j<?> jVar) {
        this.f1703c.add(jVar);
    }

    public void l(@NonNull j<?> jVar) {
        this.f1703c.remove(jVar);
    }

    @Override // com.bumptech.glide.manager.m
    public void onDestroy() {
        for (j jVar : com.bumptech.glide.util.j.j(this.f1703c)) {
            jVar.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.m
    public void onStart() {
        for (j jVar : com.bumptech.glide.util.j.j(this.f1703c)) {
            jVar.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.m
    public void onStop() {
        for (j jVar : com.bumptech.glide.util.j.j(this.f1703c)) {
            jVar.onStop();
        }
    }
}
