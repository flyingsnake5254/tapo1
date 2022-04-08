package com.tplink.iot.view.ipcamera.play;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.jvm.internal.j;
import kotlin.p;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.c;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.a.d;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.e;

/* compiled from: OperationShellFragment.kt */
/* loaded from: classes2.dex */
public final class OperationShellFragment extends BaseFragment {
    private VideoPlayViewModel p1;
    private HashMap p2;
    private MagicIndicator q;
    private ViewPager x;
    private FragmentPagerAdapter z;
    private final ArrayList<Fragment> y = new ArrayList<>();
    private final ArrayList<String> p0 = new ArrayList<>();

    /* compiled from: OperationShellFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a extends net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a {

        /* compiled from: OperationShellFragment.kt */
        /* renamed from: com.tplink.iot.view.ipcamera.play.OperationShellFragment$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        static final class View$OnClickListenerC0225a implements View.OnClickListener {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f8918d;

            View$OnClickListenerC0225a(int i) {
                this.f8918d = i;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OperationShellFragment.L0(OperationShellFragment.this).setCurrentItem(this.f8918d);
            }
        }

        a() {
        }

        @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
        public int a() {
            return OperationShellFragment.this.y.size();
        }

        @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
        public c b(Context context) {
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(OperationShellFragment.this.getContext());
            linePagerIndicator.setMode(2);
            linePagerIndicator.setColors(Integer.valueOf(Color.parseColor("#FF66B3FF")));
            linePagerIndicator.setLineWidth(b.d.w.f.a.a(linePagerIndicator.getContext(), 20.0f));
            linePagerIndicator.setRoundRadius(b.d.w.f.a.a(linePagerIndicator.getContext(), 0.5f));
            return linePagerIndicator;
        }

        @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.a.a
        public d c(Context context, int i) {
            ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
            colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#66666666"));
            colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#FF66B3FF"));
            colorTransitionPagerTitleView.setText((CharSequence) OperationShellFragment.this.p0.get(i));
            colorTransitionPagerTitleView.setTextSize(15.0f);
            colorTransitionPagerTitleView.setOnClickListener(new View$OnClickListenerC0225a(i));
            return colorTransitionPagerTitleView;
        }
    }

    /* compiled from: OperationShellFragment.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            OperationShellFragment.K0(OperationShellFragment.this).y("VideoPlay.VideoControlPanelFragment");
        }
    }

    public static final /* synthetic */ VideoPlayViewModel K0(OperationShellFragment operationShellFragment) {
        VideoPlayViewModel videoPlayViewModel = operationShellFragment.p1;
        if (videoPlayViewModel == null) {
            j.t("videoPlayViewModel");
        }
        return videoPlayViewModel;
    }

    public static final /* synthetic */ ViewPager L0(OperationShellFragment operationShellFragment) {
        ViewPager viewPager = operationShellFragment.x;
        if (viewPager == null) {
            j.t("viewPager");
        }
        return viewPager;
    }

    private final void N0(Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("first_operation_fragment_tag");
            if (string != null) {
                int hashCode = string.hashCode();
                if (hashCode != -989769983) {
                    if (hashCode != -662580069) {
                        if (hashCode == 723559217 && string.equals("VideoPlay.CloudTerraceControlFragment")) {
                            this.p0.add(getString(R.string.cloud_terrace_control_pan));
                            ArrayList<Fragment> arrayList = this.y;
                            CloudTerraceControlFragment cloudTerraceControlFragment = new CloudTerraceControlFragment();
                            Bundle bundle2 = new Bundle();
                            bundle2.putBoolean("cloud_terrace_feature_visible", true);
                            p pVar = p.a;
                            cloudTerraceControlFragment.setArguments(bundle2);
                            arrayList.add(cloudTerraceControlFragment);
                        }
                    } else if (string.equals("VideoPlay.TalkFragment")) {
                        this.p0.add(getString(R.string.video_control_talk));
                        this.y.add(new TalkFragment());
                    }
                } else if (string.equals("VideoPlay.VoiceCallFragment")) {
                    this.p0.add(getString(R.string.video_control_voice_call));
                    this.y.add(new VoiceCallFragment());
                }
            }
            String string2 = bundle.getString("second_operation_fragment_tag");
            if (string2 != null) {
                int hashCode2 = string2.hashCode();
                if (hashCode2 != 723559217) {
                    if (hashCode2 == 768612715 && string2.equals("VideoPlay.CloudTerracePresetFragment")) {
                        this.p0.add(getString(R.string.cloud_terrace_control_mark));
                        this.y.add(new CloudTerracePresetFragment());
                    }
                } else if (string2.equals("VideoPlay.CloudTerraceControlFragment")) {
                    this.p0.add(getString(R.string.cloud_terrace_control_pan));
                    this.y.add(new CloudTerraceControlFragment());
                }
            }
        }
    }

    public void H0() {
        HashMap hashMap = this.p2;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        j.e(inflater, "inflater");
        N0(getArguments());
        boolean z = false;
        View rootView = inflater.inflate(R.layout.fragment_operation_shell, viewGroup, false);
        ArrayList<Fragment> arrayList = this.y;
        ArrayList<String> arrayList2 = this.p0;
        FragmentManager childFragmentManager = getChildFragmentManager();
        j.d(childFragmentManager, "childFragmentManager");
        this.z = new g4(arrayList, arrayList2, childFragmentManager);
        j.d(rootView, "rootView");
        ViewPager viewPager = (ViewPager) rootView.findViewById(com.tplink.iot.a.view_pager);
        j.d(viewPager, "rootView.view_pager");
        this.x = viewPager;
        if (viewPager == null) {
            j.t("viewPager");
        }
        FragmentPagerAdapter fragmentPagerAdapter = this.z;
        if (fragmentPagerAdapter == null) {
            j.t("adapter");
        }
        viewPager.setAdapter(fragmentPagerAdapter);
        MagicIndicator magicIndicator = (MagicIndicator) rootView.findViewById(com.tplink.iot.a.magic_indicator);
        j.d(magicIndicator, "rootView.magic_indicator");
        this.q = magicIndicator;
        CommonNavigator commonNavigator = new CommonNavigator(getContext());
        commonNavigator.setAdapter(new a());
        MagicIndicator magicIndicator2 = this.q;
        if (magicIndicator2 == null) {
            j.t("magicIndicator");
        }
        magicIndicator2.setNavigator(commonNavigator);
        if (this.p0.size() > 1) {
            z = true;
        }
        commonNavigator.setAdjustMode(z);
        MagicIndicator magicIndicator3 = this.q;
        if (magicIndicator3 == null) {
            j.t("magicIndicator");
        }
        ViewPager viewPager2 = this.x;
        if (viewPager2 == null) {
            j.t("viewPager");
        }
        e.a(magicIndicator3, viewPager2);
        FragmentActivity activity = getActivity();
        j.c(activity);
        ViewModel viewModel = ViewModelProviders.of(activity).get(VideoPlayViewModel.class);
        j.d(viewModel, "ViewModelProviders.of(ac…layViewModel::class.java)");
        this.p1 = (VideoPlayViewModel) viewModel;
        ((ImageView) rootView.findViewById(com.tplink.iot.a.back_tv)).setOnClickListener(new b());
        return rootView;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        H0();
    }
}
