package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RequestManagerFragment.java */
@Deprecated
/* loaded from: classes.dex */
public class o extends Fragment {

    /* renamed from: c  reason: collision with root package name */
    private final a f1695c;

    /* renamed from: d  reason: collision with root package name */
    private final q f1696d;

    /* renamed from: f  reason: collision with root package name */
    private final Set<o> f1697f;
    @Nullable
    private i q;
    @Nullable
    private o x;
    @Nullable
    private Fragment y;

    /* compiled from: RequestManagerFragment.java */
    /* loaded from: classes.dex */
    private class a implements q {
        a() {
        }

        @Override // com.bumptech.glide.manager.q
        @NonNull
        public Set<i> a() {
            Set<o> b2 = o.this.b();
            HashSet hashSet = new HashSet(b2.size());
            for (o oVar : b2) {
                if (oVar.e() != null) {
                    hashSet.add(oVar.e());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + o.this + "}";
        }
    }

    public o() {
        this(new a());
    }

    private void a(o oVar) {
        this.f1697f.add(oVar);
    }

    @Nullable
    @TargetApi(17)
    private Fragment d() {
        Fragment parentFragment = Build.VERSION.SDK_INT >= 17 ? getParentFragment() : null;
        return parentFragment != null ? parentFragment : this.y;
    }

    @TargetApi(17)
    private boolean g(@NonNull Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (true) {
            Fragment parentFragment2 = fragment.getParentFragment();
            if (parentFragment2 == null) {
                return false;
            }
            if (parentFragment2.equals(parentFragment)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void h(@NonNull Activity activity) {
        l();
        o q = c.c(activity).k().q(activity);
        this.x = q;
        if (!equals(q)) {
            this.x.a(this);
        }
    }

    private void i(o oVar) {
        this.f1697f.remove(oVar);
    }

    private void l() {
        o oVar = this.x;
        if (oVar != null) {
            oVar.i(this);
            this.x = null;
        }
    }

    @NonNull
    @TargetApi(17)
    Set<o> b() {
        if (equals(this.x)) {
            return Collections.unmodifiableSet(this.f1697f);
        }
        if (this.x == null || Build.VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (o oVar : this.x.b()) {
            if (g(oVar.getParentFragment())) {
                hashSet.add(oVar);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public a c() {
        return this.f1695c;
    }

    @Nullable
    public i e() {
        return this.q;
    }

    @NonNull
    public q f() {
        return this.f1696d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(@Nullable Fragment fragment) {
        this.y = fragment;
        if (fragment != null && fragment.getActivity() != null) {
            h(fragment.getActivity());
        }
    }

    public void k(@Nullable i iVar) {
        this.q = iVar;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            h(activity);
        } catch (IllegalStateException e2) {
            if (Log.isLoggable("RMFragment", 5)) {
                Log.w("RMFragment", "Unable to register fragment with root", e2);
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f1695c.c();
        l();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        l();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1695c.d();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1695c.e();
    }

    @Override // android.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + d() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    o(@NonNull a aVar) {
        this.f1696d = new a();
        this.f1697f = new HashSet();
        this.f1695c = aVar;
    }
}
