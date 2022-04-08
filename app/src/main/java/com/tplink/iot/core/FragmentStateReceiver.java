package com.tplink.iot.core;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

/* compiled from: FragmentStateReceiver.kt */
/* loaded from: classes2.dex */
public final class FragmentStateReceiver extends FragmentManager.FragmentLifecycleCallbacks {

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f6189d = false;

    /* renamed from: e  reason: collision with root package name */
    public static final FragmentStateReceiver f6190e = new FragmentStateReceiver();
    private static WeakReference<Fragment> a = new WeakReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    private static final List<b> f6187b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private static final a f6188c = new a();

    /* compiled from: FragmentStateReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class a implements b {
        a() {
        }

        @Override // com.tplink.iot.core.FragmentStateReceiver.b
        public void a(Fragment fragment, Fragment fragment2) {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentStateObserver onFragmentSwitched: ");
            String str = null;
            sb.append(fragment != null ? m.b(fragment.getClass()).b() : null);
            sb.append(" -> ");
            if (fragment2 != null) {
                str = m.b(fragment2.getClass()).b();
            }
            sb.append(str);
            b.d.w.c.a.e("FragmentStateReceiver", sb.toString());
        }

        @Override // com.tplink.iot.core.FragmentStateReceiver.b
        public void b(Fragment fragment) {
            StringBuilder sb = new StringBuilder();
            sb.append("FragmentStateObserver onFragmentForeground: ");
            sb.append(fragment != null ? m.b(fragment.getClass()).b() : null);
            b.d.w.c.a.e("FragmentStateReceiver", sb.toString());
        }
    }

    /* compiled from: FragmentStateReceiver.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(Fragment fragment, Fragment fragment2);

        void b(Fragment fragment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentStateReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class f implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f6197c;

        f(View view) {
            this.f6197c = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.f6195c.a(this.f6197c);
        }
    }

    private FragmentStateReceiver() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean d(Fragment fragment) {
        return !fragment.isHidden() && fragment.getUserVisibleHint() && fragment.getView() != null;
    }

    private final void e(Fragment fragment, boolean z) {
        if (z || a.get() == null || fragment == null || !j.a(a.get(), fragment)) {
            for (b bVar : f6187b) {
                bVar.b(fragment);
                bVar.a(a.get(), fragment);
            }
            a = new WeakReference<>(fragment);
        }
    }

    static /* synthetic */ void f(FragmentStateReceiver fragmentStateReceiver, Fragment fragment, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        fragmentStateReceiver.e(fragment, z);
    }

    public static final void g() {
        h(f6188c);
    }

    public static final void h(b bVar) {
        if (bVar != null) {
            List<b> list = f6187b;
            if (!list.contains(bVar)) {
                list.add(bVar);
            }
        }
    }

    public static final void i(Activity activity) {
        j.e(activity, "activity");
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            fragmentActivity.getSupportFragmentManager().registerFragmentLifecycleCallbacks(f6190e, true);
            c.a.b(fragmentActivity);
            Window window = fragmentActivity.getWindow();
            j.d(window, "activity.window");
            View findViewById = window.getDecorView().findViewById(16908290);
            if (findViewById != null) {
                findViewById.post(new f(findViewById));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String str) {
        if (f6189d) {
            b.d.w.c.a.n("FragmentStateReceiver", str);
        }
    }

    public static final void k() {
        l(f6188c);
    }

    public static final void l(b bVar) {
        if (bVar != null) {
            f6187b.remove(bVar);
        }
    }

    public static final void m(Activity activity) {
        j.e(activity, "activity");
        if (activity instanceof FragmentActivity) {
            ((FragmentActivity) activity).getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(f6190e);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fm, Fragment f2, Bundle bundle) {
        j.e(fm, "fm");
        j.e(f2, "f");
        j("Fragment State: " + m.b(f2.getClass()).b() + " Created!!!!!!!!!");
        c.a.a(f2);
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager fm, Fragment f2) {
        j.e(fm, "fm");
        j.e(f2, "f");
        j("Fragment State: " + m.b(f2.getClass()).b() + " Destroyed!!!!!!!!!");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentPaused(FragmentManager fm, Fragment f2) {
        j.e(fm, "fm");
        j.e(f2, "f");
        j("Fragment State: " + m.b(f2.getClass()).b() + " Paused!!!!!!!!!");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentResumed(FragmentManager fm, Fragment f2) {
        boolean z;
        j.e(fm, "fm");
        j.e(f2, "f");
        j("Fragment State: " + m.b(f2.getClass()).b() + " Resumed!!!!!!!!!");
        Fragment fragment = f2;
        while (true) {
            if (fragment == null) {
                z = true;
                break;
            } else if (!d(fragment)) {
                z = false;
                break;
            } else {
                fragment = fragment.getParentFragment();
            }
        }
        if (z) {
            j("Fragment State: " + m.b(f2.getClass()).b() + " Resumed & VISIBLE & UserVisibleHint");
            e(f2, true);
        }
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentStarted(FragmentManager fm, Fragment f2) {
        j.e(fm, "fm");
        j.e(f2, "f");
        j("Fragment State: " + m.b(f2.getClass()).b() + " Started!!!!!!!!!");
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentViewCreated(FragmentManager fm, Fragment f2, View v, Bundle bundle) {
        j.e(fm, "fm");
        j.e(f2, "f");
        j.e(v, "v");
        d.f6192c.a(f2, v);
        e.f6195c.a(v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentStateReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class c implements FragmentManager.OnBackStackChangedListener {
        public static final a a = new a(null);

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<FragmentManager> f6191b;

        /* compiled from: FragmentStateReceiver.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public final void a(Fragment fragment) {
                j.e(fragment, "fragment");
                FragmentManager it = fragment.getChildFragmentManager();
                j.d(it, "it");
                it.addOnBackStackChangedListener(new c(it, null));
            }

            public final void b(FragmentActivity activity) {
                j.e(activity, "activity");
                FragmentManager it = activity.getSupportFragmentManager();
                j.d(it, "it");
                it.addOnBackStackChangedListener(new c(it, null));
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        private c(FragmentManager fragmentManager) {
            this.f6191b = new WeakReference<>(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
        public void onBackStackChanged() {
            Fragment fragment;
            boolean z;
            FragmentManager fragmentManager = this.f6191b.get();
            if (fragmentManager != null) {
                j.d(fragmentManager, "mFragmentManager.get() ?: return");
                FragmentStateReceiver.f6190e.j("onBackStackChanged: fragments number: " + fragmentManager.getFragments().size());
                List<Fragment> fragments = fragmentManager.getFragments();
                j.d(fragments, "fm.fragments");
                ListIterator<Fragment> listIterator = fragments.listIterator(fragments.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        fragment = null;
                        break;
                    }
                    fragment = listIterator.previous();
                    Fragment it = fragment;
                    j.d(it, "it");
                    if (it.getView() != null) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                Fragment fragment2 = fragment;
                if (fragment2 != null) {
                    FragmentStateReceiver fragmentStateReceiver = FragmentStateReceiver.f6190e;
                    fragmentStateReceiver.j("onBackStackChanged: " + m.b(fragment2.getClass()).b() + " isVisibleActually: " + fragmentStateReceiver.d(fragment2));
                    if ((true ^ j.a(fragment2, (Fragment) FragmentStateReceiver.a.get())) && fragmentStateReceiver.d(fragment2)) {
                        FragmentStateReceiver.f(fragmentStateReceiver, fragment2, false, 2, null);
                    }
                }
            }
        }

        public /* synthetic */ c(FragmentManager fragmentManager, kotlin.jvm.internal.f fVar) {
            this(fragmentManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentStateReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class e implements ViewPager.OnPageChangeListener {

        /* renamed from: c  reason: collision with root package name */
        public static final a f6195c = new a(null);

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<PagerAdapter> f6196d;

        /* compiled from: FragmentStateReceiver.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public final void a(View v) {
                PagerAdapter pagerAdapter;
                j.e(v, "v");
                if (v instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) v;
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        View childAt = viewGroup.getChildAt(i);
                        j.b(childAt, "getChildAt(index)");
                        if (childAt instanceof ViewPager) {
                            ViewPager viewPager = (ViewPager) childAt;
                            if (((viewPager.getAdapter() instanceof FragmentPagerAdapter) || (viewPager.getAdapter() instanceof FragmentStatePagerAdapter)) && (pagerAdapter = viewPager.getAdapter()) != null) {
                                j.d(pagerAdapter, "pagerAdapter");
                                viewPager.addOnPageChangeListener(new e(pagerAdapter, null));
                            }
                        }
                        e.f6195c.a(childAt);
                    }
                }
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        private e(PagerAdapter pagerAdapter) {
            this.f6196d = new WeakReference<>(pagerAdapter);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            FragmentStateReceiver fragmentStateReceiver = FragmentStateReceiver.f6190e;
            fragmentStateReceiver.j("ViewPager onPageSelected: " + i);
            PagerAdapter pagerAdapter = this.f6196d.get();
            if (pagerAdapter instanceof FragmentPagerAdapter) {
                FragmentStateReceiver.f(fragmentStateReceiver, ((FragmentPagerAdapter) pagerAdapter).getItem(i), false, 2, null);
            } else if (pagerAdapter instanceof FragmentStatePagerAdapter) {
                FragmentStateReceiver.f(fragmentStateReceiver, ((FragmentStatePagerAdapter) pagerAdapter).getItem(i), false, 2, null);
            }
        }

        public /* synthetic */ e(PagerAdapter pagerAdapter, kotlin.jvm.internal.f fVar) {
            this(pagerAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FragmentStateReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: c  reason: collision with root package name */
        public static final a f6192c = new a(null);

        /* renamed from: d  reason: collision with root package name */
        private final WeakReference<Fragment> f6193d;

        /* renamed from: f  reason: collision with root package name */
        private final WeakReference<View> f6194f;
        private final String q;
        private int x;

        /* compiled from: FragmentStateReceiver.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public final void a(Fragment f2, View v) {
                j.e(f2, "f");
                j.e(v, "v");
                v.getViewTreeObserver().addOnGlobalLayoutListener(new d(v, f2, null));
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        private d(View view, Fragment fragment) {
            this.f6193d = new WeakReference<>(fragment);
            this.f6194f = new WeakReference<>(view);
            String b2 = m.b(fragment.getClass()).b();
            this.q = b2 == null ? "A Fragment" : b2;
            this.x = view.getVisibility();
        }

        private final void a(Fragment fragment) {
            if (fragment != null) {
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                j.d(childFragmentManager, "f.childFragmentManager");
                List<Fragment> fragments = childFragmentManager.getFragments();
                j.d(fragments, "f.childFragmentManager.fragments");
                for (Fragment it : fragments) {
                    FragmentStateReceiver fragmentStateReceiver = FragmentStateReceiver.f6190e;
                    j.d(it, "it");
                    if (fragmentStateReceiver.d(it)) {
                        FragmentStateReceiver.f(fragmentStateReceiver, it, false, 2, null);
                        a(it);
                    }
                }
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            View it = this.f6194f.get();
            if (it != null) {
                j.d(it, "it");
                if (it.getVisibility() != this.x) {
                    int visibility = it.getVisibility();
                    this.x = visibility;
                    if (visibility == 0) {
                        FragmentStateReceiver.f(FragmentStateReceiver.f6190e, this.f6193d.get(), false, 2, null);
                        a(this.f6193d.get());
                    }
                    String str = this.x == 0 ? "SHOW" : "HIDE";
                    FragmentStateReceiver fragmentStateReceiver = FragmentStateReceiver.f6190e;
                    fragmentStateReceiver.j("Fragment State: " + this.q + ' ' + str + "!!!!!!!!");
                }
            }
        }

        public /* synthetic */ d(View view, Fragment fragment, kotlin.jvm.internal.f fVar) {
            this(view, fragment);
        }
    }
}
