package com.hannesdorfmann.mosby3;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.BackstackAccessor;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hannesdorfmann.mosby3.k.b;
import com.hannesdorfmann.mosby3.mvi.d;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.Objects;
import java.util.UUID;

/* compiled from: FragmentMviDelegateImpl.java */
/* loaded from: classes2.dex */
public class e<V extends b, P extends d<V, ?>> implements d<V, P> {
    public static boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f5055b;

    /* renamed from: c  reason: collision with root package name */
    private f<V, P> f5056c;

    /* renamed from: d  reason: collision with root package name */
    private Fragment f5057d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5058e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5059f;
    private final boolean g;
    private P h;
    private boolean i;

    public e(@NonNull f<V, P> fVar, @NonNull Fragment fragment) {
        this(fVar, fragment, true, true);
    }

    private P g() {
        P D = this.f5056c.D();
        if (D != null) {
            if (this.f5059f || this.g) {
                Activity h = h();
                String uuid = UUID.randomUUID().toString();
                this.f5055b = uuid;
                g.g(h, uuid, D);
            }
            return D;
        }
        throw new NullPointerException("Presenter returned from createPresenter() is null. Fragment is " + this.f5057d);
    }

    @NonNull
    private Activity h() {
        FragmentActivity activity = this.f5057d.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new NullPointerException("Activity returned by Fragment.getActivity() is null. Fragment is " + this.f5057d);
    }

    private boolean i(boolean z, Activity activity, Fragment fragment) {
        if (activity.isChangingConfigurations()) {
            return this.f5059f;
        }
        if (activity.isFinishing()) {
            return false;
        }
        if (!z || !BackstackAccessor.isFragmentOnBackStack(fragment)) {
            return !fragment.isRemoving();
        }
        return true;
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void a(Activity activity) {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void b(Context context) {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void c(Fragment fragment) {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void d() {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void e(View view, @Nullable Bundle bundle) {
        this.f5058e = true;
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void f(Bundle bundle) {
        if (!this.f5058e) {
            throw new IllegalStateException("It seems that onCreateView() has never been called (or has returned null). This means that your fragment is headless (no UI). That is not allowed because it doesn't make sense to use Mosby with a Fragment without View.");
        }
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onCreate(@Nullable Bundle bundle) {
        if ((this.f5059f || this.g) && bundle != null) {
            this.f5055b = bundle.getString("com.hannesdorfmann.mosby3.fragment.mvi.id");
        }
        if (a) {
            Log.d("FragmentMviDelegateImpl", "MosbyView ID = " + this.f5055b + " for MvpView: " + this.f5056c.getMvpView());
        }
        if (this.f5055b == null) {
            this.h = g();
            this.i = false;
            if (a) {
                Log.d("FragmentMviDelegateImpl", "new Presenter instance created: " + this.h);
            }
        } else {
            P p = (P) ((d) g.f(h(), this.f5055b));
            this.h = p;
            if (p == null) {
                this.h = g();
                this.i = false;
                if (a) {
                    Log.d("FragmentMviDelegateImpl", "No Presenter instance found in cache, although MosbyView ID present. This was caused by process death, therefore new Presenter instance created: " + this.h);
                }
            } else {
                this.i = true;
                if (a) {
                    Log.d("FragmentMviDelegateImpl", "Presenter instance reused from internal cache: " + this.h);
                }
            }
        }
        if (this.h == null) {
            throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
        }
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onDestroy() {
        Activity h = h();
        boolean i = i(this.g, h, this.f5057d);
        if (!i) {
            this.h.destroy();
            String str = this.f5055b;
            if (str != null) {
                g.h(h, str);
            }
            if (a) {
                Log.d("FragmentMviDelegateImpl", "Presenter destroyed");
            }
        } else if (a) {
            Log.d("FragmentMviDelegateImpl", "Retaining presenter instance: " + Boolean.toString(i) + SSLClient.WHITE_SPACE + this.h);
        }
        this.h = null;
        this.f5056c = null;
        this.f5057d = null;
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onDestroyView() {
        this.f5058e = false;
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onPause() {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onResume() {
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onSaveInstanceState(Bundle bundle) {
        if ((this.f5059f || this.g) && bundle != null) {
            bundle.putString("com.hannesdorfmann.mosby3.fragment.mvi.id", this.f5055b);
            i(this.g, h(), this.f5057d);
            if (a) {
                Log.d("FragmentMviDelegateImpl", "Saving MosbyViewId into Bundle. ViewId: " + this.f5055b);
            }
        }
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onStart() {
        V mvpView = this.f5056c.getMvpView();
        if (mvpView == null) {
            throw new NullPointerException("MvpView returned from getMvpView() is null. Returned by " + this.f5057d);
        } else if (this.h != null) {
            if (this.i) {
                this.f5056c.setRestoringViewState(true);
            }
            this.h.a(mvpView);
            if (this.i) {
                this.f5056c.setRestoringViewState(false);
            }
            if (a) {
                Log.d("FragmentMviDelegateImpl", "MvpView attached to Presenter. MvpView: " + mvpView + "   Presenter: " + this.h);
            }
        } else {
            throw new IllegalStateException("Oops, Presenter is null. This seems to be a Mosby internal bug. Please report this issue here: https://github.com/sockeqwe/mosby/issues");
        }
    }

    @Override // com.hannesdorfmann.mosby3.d
    public void onStop() {
        this.h.b();
        this.i = true;
        if (a) {
            Log.d("FragmentMviDelegateImpl", "detached MvpView from Presenter. MvpView " + this.f5056c.getMvpView() + "   Presenter: " + this.h);
        }
    }

    public e(@NonNull f<V, P> fVar, @NonNull Fragment fragment, boolean z, boolean z2) {
        this.f5055b = null;
        this.f5058e = false;
        Objects.requireNonNull(fVar, "delegateCallback == null");
        Objects.requireNonNull(fragment, "fragment == null");
        if (z || !z2) {
            this.f5056c = fVar;
            this.f5057d = fragment;
            this.f5059f = z;
            this.g = z2;
            return;
        }
        throw new IllegalArgumentException("It is not possible to keep the presenter on backstack, but NOT keep presenter through screen orientation changes. Keep presenter on backstack also requires keep presenter through screen orientation changes to be enabled");
    }
}
