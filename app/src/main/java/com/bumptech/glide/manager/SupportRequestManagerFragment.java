package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.c;
import com.bumptech.glide.i;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SupportRequestManagerFragment extends Fragment {

    /* renamed from: c  reason: collision with root package name */
    private final a f1687c;

    /* renamed from: d  reason: collision with root package name */
    private final q f1688d;

    /* renamed from: f  reason: collision with root package name */
    private final Set<SupportRequestManagerFragment> f1689f;
    @Nullable
    private SupportRequestManagerFragment q;
    @Nullable
    private i x;
    @Nullable
    private Fragment y;

    /* loaded from: classes.dex */
    private class a implements q {
        a() {
        }

        @Override // com.bumptech.glide.manager.q
        @NonNull
        public Set<i> a() {
            Set<SupportRequestManagerFragment> B0 = SupportRequestManagerFragment.this.B0();
            HashSet hashSet = new HashSet(B0.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : B0) {
                if (supportRequestManagerFragment.H0() != null) {
                    hashSet.add(supportRequestManagerFragment.H0());
                }
            }
            return hashSet;
        }

        public String toString() {
            return super.toString() + "{fragment=" + SupportRequestManagerFragment.this + "}";
        }
    }

    public SupportRequestManagerFragment() {
        this(new a());
    }

    private void A0(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f1689f.add(supportRequestManagerFragment);
    }

    @Nullable
    private Fragment G0() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null ? parentFragment : this.y;
    }

    @Nullable
    private static FragmentManager J0(@NonNull Fragment fragment) {
        while (fragment.getParentFragment() != null) {
            fragment = fragment.getParentFragment();
        }
        return fragment.getFragmentManager();
    }

    private boolean K0(@NonNull Fragment fragment) {
        Fragment G0 = G0();
        while (true) {
            Fragment parentFragment = fragment.getParentFragment();
            if (parentFragment == null) {
                return false;
            }
            if (parentFragment.equals(G0)) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
    }

    private void L0(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        Q0();
        SupportRequestManagerFragment s = c.c(context).k().s(fragmentManager);
        this.q = s;
        if (!equals(s)) {
            this.q.A0(this);
        }
    }

    private void N0(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.f1689f.remove(supportRequestManagerFragment);
    }

    private void Q0() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.q;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.N0(this);
            this.q = null;
        }
    }

    @NonNull
    Set<SupportRequestManagerFragment> B0() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.q;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (equals(supportRequestManagerFragment)) {
            return Collections.unmodifiableSet(this.f1689f);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.q.B0()) {
            if (K0(supportRequestManagerFragment2.G0())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public a C0() {
        return this.f1687c;
    }

    @Nullable
    public i H0() {
        return this.x;
    }

    @NonNull
    public q I0() {
        return this.f1688d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O0(@Nullable Fragment fragment) {
        FragmentManager J0;
        this.y = fragment;
        if (fragment != null && fragment.getContext() != null && (J0 = J0(fragment)) != null) {
            L0(fragment.getContext(), J0);
        }
    }

    public void P0(@Nullable i iVar) {
        this.x = iVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        FragmentManager J0 = J0(this);
        if (J0 != null) {
            try {
                L0(getContext(), J0);
            } catch (IllegalStateException e2) {
                if (Log.isLoggable("SupportRMFragment", 5)) {
                    Log.w("SupportRMFragment", "Unable to register fragment with root", e2);
                }
            }
        } else if (Log.isLoggable("SupportRMFragment", 5)) {
            Log.w("SupportRMFragment", "Unable to register fragment with root, ancestor detached");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f1687c.c();
        Q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.y = null;
        Q0();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f1687c.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f1687c.e();
    }

    @Override // androidx.fragment.app.Fragment
    public String toString() {
        return super.toString() + "{parent=" + G0() + "}";
    }

    @SuppressLint({"ValidFragment"})
    @VisibleForTesting
    public SupportRequestManagerFragment(@NonNull a aVar) {
        this.f1688d = new a();
        this.f1689f = new HashSet();
        this.f1687c = aVar;
    }
}
