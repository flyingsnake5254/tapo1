package com.tplink.iot.view.smart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import b.d.b.f.b;
import com.google.android.material.tabs.TabLayout;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.v;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.smart.actionsetup.ActionDetailActivity;
import com.tplink.iot.view.smart.myactions.ShortcutResortActivity;
import com.tplink.iot.view.smart.myactions.SmartActionFragment;
import com.tplink.iot.view.smart.template.SmartTemplateFragment;
import com.tplink.iot.viewmodel.smart.ActionSetupViewModel;
import com.tplink.libtpmediastatistics.SSLClient;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SmartFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private View q;
    private View x;
    private ViewPager y;
    private ArrayList<BaseFragment> z = new ArrayList<>();
    private ArrayList<String> p0 = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends FragmentPagerAdapter {
        a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            return (Fragment) SmartFragment.this.z.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @Nullable
        public CharSequence getPageTitle(int i) {
            return (CharSequence) SmartFragment.this.p0.get(i);
        }
    }

    private void J0() {
        View findViewById = this.q.findViewById(R.id.smart_resort_shortcut);
        this.x = findViewById;
        findViewById.setOnClickListener(this);
        this.q.findViewById(R.id.smart_add_action).setOnClickListener(this);
        this.y = (ViewPager) this.q.findViewById(R.id.smart_content);
        this.z.add(L0());
        this.z.add(K0());
        this.p0.add(getString(R.string.smart_template_tab_title));
        this.p0.add(getString(R.string.smart_list_tab_title));
        this.y.setAdapter(new a(getChildFragmentManager()));
        this.y.addOnPageChangeListener(this);
        ((TabLayout) this.q.findViewById(R.id.smart_tab)).setupWithViewPager(this.y);
        int i = 1;
        if (o.h0().X() != 1 || !N0()) {
            i = 0;
        }
        this.y.setCurrentItem(i);
    }

    private BaseFragment K0() {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(O0(this.y.getId(), 1L));
        SmartActionFragment smartActionFragment = findFragmentByTag instanceof SmartActionFragment ? (SmartActionFragment) findFragmentByTag : null;
        return smartActionFragment == null ? new SmartActionFragment() : smartActionFragment;
    }

    private BaseFragment L0() {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag(O0(this.y.getId(), 0L));
        SmartTemplateFragment smartTemplateFragment = findFragmentByTag instanceof SmartTemplateFragment ? (SmartTemplateFragment) findFragmentByTag : null;
        return smartTemplateFragment == null ? new SmartTemplateFragment() : smartTemplateFragment;
    }

    private boolean N0() {
        return !s.b(((SmartRepository) b.a(b.d.s.a.a.f(), SmartRepository.class)).P().getValue());
    }

    private String O0(int i, long j) {
        return "android:switcher:" + i + SSLClient.COLON + j;
    }

    public void P0() {
        this.y.setCurrentItem(1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.smart_add_action) {
            v.c();
            if (((ActionSetupViewModel) ViewModelProviders.of(this).get(ActionSetupViewModel.class)).o0()) {
                s0.p(getActivity(), getString(R.string.smart_action_add_limit_tip, 64));
                return;
            }
            o.h0().k("new_smart_info", null);
            ActionDetailActivity.F1(getContext(), -1, 1);
        } else if (id == R.id.smart_resort_shortcut) {
            o.h0().k("new_smart_info", null);
            C0(ShortcutResortActivity.class);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.q = layoutInflater.inflate(R.layout.fragment_smart, viewGroup, false);
        d.J(getActivity(), this.q.findViewById(R.id.smart_header));
        setHasOptionsMenu(true);
        J0();
        b.d.n.f.b.l().f("tapo_pageid_smart");
        return this.q;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        ViewPager viewPager = this.y;
        if (viewPager == null || z || viewPager.getCurrentItem() != 1) {
            o.h0().k("new_smart_info", null);
        } else {
            ((SmartActionFragment) this.z.get(1)).g1();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.x.setVisibility(i == 0 ? 4 : 0);
        o.h0().u0(i);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ViewPager viewPager = this.y;
        if (viewPager != null && viewPager.getCurrentItem() == 1) {
            ((SmartActionFragment) this.z.get(1)).g1();
        }
    }
}
