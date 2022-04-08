package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.j;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes.dex */
class a implements l {
    private final Set<m> a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f1690b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f1691c;

    @Override // com.bumptech.glide.manager.l
    public void a(@NonNull m mVar) {
        this.a.remove(mVar);
    }

    @Override // com.bumptech.glide.manager.l
    public void b(@NonNull m mVar) {
        this.a.add(mVar);
        if (this.f1691c) {
            mVar.onDestroy();
        } else if (this.f1690b) {
            mVar.onStart();
        } else {
            mVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f1691c = true;
        for (m mVar : j.j(this.a)) {
            mVar.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f1690b = true;
        for (m mVar : j.j(this.a)) {
            mVar.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f1690b = false;
        for (m mVar : j.j(this.a)) {
            mVar.onStop();
        }
    }
}
