package com.tplink.libtpanalytics.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class FragmentStateMonitor extends FragmentManager.FragmentLifecycleCallbacks {
    private static FragmentStateMonitor a;

    /* renamed from: b  reason: collision with root package name */
    private static final b f11992b = new a();

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<Fragment> f11993c = new WeakReference<>(null);

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<b> f11994d = new ArrayList<>();

    /* loaded from: classes3.dex */
    class a implements b {
        a() {
        }

        @Override // com.tplink.libtpanalytics.utils.FragmentStateMonitor.b
        public void a(Fragment fragment, Fragment fragment2) {
            String str = "";
            String simpleName = fragment != null ? fragment.getClass().getSimpleName() : str;
            if (fragment2 != null) {
                str = fragment2.getClass().getSimpleName();
            }
            i.c("last Fragment:" + simpleName + "  current Fragment:" + str);
        }

        @Override // com.tplink.libtpanalytics.utils.FragmentStateMonitor.b
        public void b(Fragment fragment) {
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Fragment fragment, Fragment fragment2);

        void b(Fragment fragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements FragmentManager.OnBackStackChangedListener {
        private WeakReference<FragmentManager> a;

        public c(FragmentManager fragmentManager) {
            this.a = new WeakReference<>(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public void onBackStackChanged() {
            if (this.a.get() != null) {
                FragmentManager fragmentManager = this.a.get();
                Fragment fragment = null;
                int size = fragmentManager.getFragments().size() - 1;
                while (true) {
                    if (size >= 0) {
                        if (fragmentManager.getFragments().get(size) != null && fragmentManager.getFragments().get(size).getView() != null) {
                            fragment = fragmentManager.getFragments().get(size);
                            break;
                        }
                        size--;
                    } else {
                        break;
                    }
                }
                if (fragment != null && fragment != FragmentStateMonitor.this.f11993c.get() && FragmentStateMonitor.this.i(fragment)) {
                    FragmentStateMonitor.this.l(fragment, false);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<Fragment> f11996c;

        /* renamed from: d  reason: collision with root package name */
        private WeakReference<View> f11997d;

        /* renamed from: f  reason: collision with root package name */
        private int f11998f;

        public d(View view, Fragment fragment) {
            this.f11996c = new WeakReference<>(fragment);
            this.f11997d = new WeakReference<>(view);
            this.f11998f = view.getVisibility();
        }

        private void a(Fragment fragment) {
            if (fragment != null) {
                for (Fragment fragment2 : fragment.getChildFragmentManager().getFragments()) {
                    if (FragmentStateMonitor.this.i(fragment2)) {
                        FragmentStateMonitor.this.l(fragment2, false);
                        a(fragment2);
                    }
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (this.f11997d.get() != null && this.f11997d.get().getVisibility() != this.f11998f) {
                int visibility = this.f11997d.get().getVisibility();
                this.f11998f = visibility;
                if (visibility == 0) {
                    FragmentStateMonitor.this.l(this.f11996c.get(), false);
                    a(this.f11996c.get());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e implements ViewPager.OnPageChangeListener {

        /* renamed from: c  reason: collision with root package name */
        private WeakReference<PagerAdapter> f11999c;

        public e(PagerAdapter pagerAdapter) {
            this.f11999c = new WeakReference<>(pagerAdapter);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            PagerAdapter pagerAdapter = this.f11999c.get();
            if (pagerAdapter != null && i < pagerAdapter.getCount()) {
                if (pagerAdapter instanceof FragmentPagerAdapter) {
                    FragmentStateMonitor.this.l(((FragmentPagerAdapter) pagerAdapter).getItem(i), false);
                } else if (pagerAdapter instanceof FragmentStatePagerAdapter) {
                    FragmentStateMonitor.this.l(((FragmentStatePagerAdapter) pagerAdapter).getItem(i), false);
                }
            }
        }
    }

    private void d(Fragment fragment, View view) {
        if (fragment != null && view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(new d(view, fragment));
        }
    }

    private void e(Fragment fragment) {
        if (fragment != null) {
            fragment.getChildFragmentManager().addOnBackStackChangedListener(new c(fragment.getChildFragmentManager()));
        }
    }

    private void f(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            fragmentActivity.getSupportFragmentManager().addOnBackStackChangedListener(new c(fragmentActivity.getSupportFragmentManager()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void j(View view) {
        if (view != null && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt != null) {
                    if (childAt instanceof ViewPager) {
                        ViewPager viewPager = (ViewPager) childAt;
                        if (((viewPager.getAdapter() instanceof FragmentPagerAdapter) || (viewPager.getAdapter() instanceof FragmentStatePagerAdapter)) && viewPager.getAdapter() != null) {
                            viewPager.addOnPageChangeListener(new e(viewPager.getAdapter()));
                        }
                    }
                    j(childAt);
                } else {
                    return;
                }
            }
        }
    }

    public static FragmentStateMonitor h() {
        if (a == null) {
            synchronized (FragmentStateMonitor.class) {
                if (a == null) {
                    a = new FragmentStateMonitor();
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(Fragment fragment) {
        return fragment != null && !fragment.isHidden() && fragment.getUserVisibleHint() && fragment.getView() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Fragment fragment, boolean z) {
        if (z || this.f11993c.get() == null || fragment == null || this.f11993c.get() != fragment) {
            Iterator<b> it = this.f11994d.iterator();
            while (it.hasNext()) {
                b next = it.next();
                next.b(fragment);
                next.a(this.f11993c.get(), fragment);
            }
            this.f11993c = new WeakReference<>(fragment);
        }
    }

    public void m(Activity activity) {
        final View findViewById;
        if (activity != null && (activity instanceof FragmentActivity)) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(this, true);
            f(fragmentActivity);
            if (activity.getWindow() != null && (findViewById = activity.getWindow().getDecorView().findViewById(16908290)) != null) {
                findViewById.post(new Runnable() { // from class: com.tplink.libtpanalytics.utils.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        FragmentStateMonitor.this.k(findViewById);
                    }
                });
            }
        }
    }

    public void n(b bVar) {
        if (bVar != null && !this.f11994d.contains(bVar)) {
            this.f11994d.add(bVar);
        }
    }

    public void o(Activity activity) {
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        e(fragment);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
        boolean z;
        Fragment fragment2 = fragment;
        while (true) {
            if (fragment2 == null) {
                z = true;
                break;
            } else if (!i(fragment2)) {
                z = false;
                break;
            } else {
                fragment2 = fragment2.getParentFragment();
            }
        }
        if (z) {
            l(fragment, false);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
        j(view);
        d(fragment, view);
    }

    public void p(b bVar) {
        if (bVar != null) {
            this.f11994d.remove(bVar);
        }
    }
}
