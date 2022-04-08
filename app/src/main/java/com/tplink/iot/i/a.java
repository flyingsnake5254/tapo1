package com.tplink.iot.i;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.List;

/* compiled from: FragmentBackListener.java */
/* loaded from: classes2.dex */
public interface a {

    /* compiled from: FragmentBackListener.java */
    /* renamed from: com.tplink.iot.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0212a {
        public static boolean a(Fragment fragment) {
            return c(fragment.getChildFragmentManager());
        }

        public static boolean b(FragmentActivity fragmentActivity) {
            return c(fragmentActivity.getSupportFragmentManager());
        }

        private static boolean c(FragmentManager fragmentManager) {
            List<Fragment> fragments = fragmentManager.getFragments();
            if (fragments == null) {
                return false;
            }
            for (int size = fragments.size() - 1; size >= 0; size--) {
                if (d(fragments.get(size))) {
                    return true;
                }
            }
            if (fragmentManager.getBackStackEntryCount() <= 0) {
                return false;
            }
            fragmentManager.popBackStack();
            return true;
        }

        private static boolean d(Fragment fragment) {
            return fragment != null && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof a) && ((a) fragment).d();
        }
    }

    boolean d();
}
