package com.tplink.iot.view.ipcamera.play.functionintroduce;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tplink.iot.R;
import com.tplink.iot.Utils.v0.e;
import com.tplink.iot.Utils.z0.h;
import com.tplink.iot.cloud.bean.cloudvideo.common.DeviceCloudProduct;
import com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment;
import com.tplink.iot.view.tapocare.TrialDialogActivity;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CameraFirstShowFunctionGuideDialog extends BaseBottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    public static final String f8955c = CameraFirstShowFunctionGuideDialog.class.getName();
    private d H3;
    private DeviceCloudProduct I3;
    private boolean J3 = true;
    private boolean K3 = false;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f8956d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f8957f;
    private LinearLayout p0;
    private LinearLayout p1;
    private Button p2;
    private String p3;
    private TextView q;
    private TextView x;
    private ViewPager2 y;
    private LinearLayout z;

    /* loaded from: classes2.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        final /* synthetic */ List a;

        a(List list) {
            this.a = list;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i) {
            super.onPageSelected(i);
            CameraFirstShowFunctionGuideDialog.this.Y0(i + 1);
            int i2 = 4;
            int i3 = 0;
            if (i == this.a.size() - 1) {
                CameraFirstShowFunctionGuideDialog.this.f8957f.setVisibility(0);
                if (CameraFirstShowFunctionGuideDialog.this.J3) {
                    CameraFirstShowFunctionGuideDialog.this.q.setVisibility(CameraFirstShowFunctionGuideDialog.this.W0());
                    TextView textView = CameraFirstShowFunctionGuideDialog.this.x;
                    if (CameraFirstShowFunctionGuideDialog.this.W0() != 8) {
                        i2 = 0;
                    }
                    textView.setVisibility(i2);
                    TextView textView2 = CameraFirstShowFunctionGuideDialog.this.f8957f;
                    if (CameraFirstShowFunctionGuideDialog.this.W0() != 8) {
                        i3 = 8;
                    }
                    textView2.setVisibility(i3);
                    CameraFirstShowFunctionGuideDialog.this.K3 = true;
                    return;
                }
                return;
            }
            CameraFirstShowFunctionGuideDialog.this.f8957f.setVisibility(8);
            CameraFirstShowFunctionGuideDialog.this.q.setVisibility(4);
            CameraFirstShowFunctionGuideDialog.this.x.setVisibility(4);
            CameraFirstShowFunctionGuideDialog.this.K3 = false;
        }
    }

    /* loaded from: classes2.dex */
    class b implements g<DeviceCloudProduct> {
        b() {
        }

        /* renamed from: a */
        public void accept(DeviceCloudProduct deviceCloudProduct) throws Exception {
            int i = 4;
            if (!CameraFirstShowFunctionGuideDialog.this.J3 || !CameraFirstShowFunctionGuideDialog.this.K3) {
                CameraFirstShowFunctionGuideDialog.this.q.setVisibility(4);
                CameraFirstShowFunctionGuideDialog.this.x.setVisibility(4);
                return;
            }
            CameraFirstShowFunctionGuideDialog.this.q.setVisibility(CameraFirstShowFunctionGuideDialog.this.W0());
            TextView textView = CameraFirstShowFunctionGuideDialog.this.x;
            int i2 = 0;
            if (CameraFirstShowFunctionGuideDialog.this.W0() != 8) {
                i = 0;
            }
            textView.setVisibility(i);
            TextView textView2 = CameraFirstShowFunctionGuideDialog.this.f8957f;
            if (CameraFirstShowFunctionGuideDialog.this.W0() != 8) {
                i2 = 8;
            }
            textView2.setVisibility(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements g<DeviceCloudProduct> {
        c() {
        }

        /* renamed from: a */
        public void accept(DeviceCloudProduct deviceCloudProduct) throws Exception {
            CameraFirstShowFunctionGuideDialog.this.I3 = deviceCloudProduct;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onFinish();
    }

    private String Q0(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? "" : "Tapo Care" : "Event Alerts" : "Activity Zones" : "Realtime Call";
    }

    private String R0(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "Tapo Care" : "Event Alerts" : "Activity Zones" : "Look Around" : "Realtime Call";
    }

    private String S0(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : "Tapo Care" : "Intruders Beware" : "Activity Zones" : "Person Detection" : "Event Alerts";
    }

    private String T0(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "Tapo Care" : "Activity Zones" : "Person Detection" : "Smart Night Vision Mode" : "Full Color Sight At Night" : "Event Alerts";
    }

    private int U0(DeviceModel deviceModel) {
        return com.tplink.iot.view.ipcamera.base.c.t(deviceModel) ? R.mipmap.smart_camera_outlook_c100 : (!com.tplink.iot.view.ipcamera.base.c.u(deviceModel) && com.tplink.iot.view.ipcamera.base.c.v(deviceModel)) ? R.mipmap.smart_camera_outlook_c310 : R.mipmap.smart_camera_outlook_c200;
    }

    private List<CameraIntroduceVideoPlayItemFragment> V0(DeviceModel deviceModel) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (com.tplink.iot.view.ipcamera.base.c.t(deviceModel)) {
            while (i < 4) {
                CameraIntroduceVideoPlayItemFragment cameraIntroduceVideoPlayItemFragment = new CameraIntroduceVideoPlayItemFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("CAMERA_CURRENT_MODEL", deviceModel);
                bundle.putString("CAMERA_DEVICEIDMD5", this.p3);
                bundle.putString("title", Q0(i));
                cameraIntroduceVideoPlayItemFragment.setArguments(bundle);
                arrayList.add(cameraIntroduceVideoPlayItemFragment);
                i++;
            }
        } else if (com.tplink.iot.view.ipcamera.base.c.u(deviceModel)) {
            while (i < 5) {
                CameraIntroduceVideoPlayItemFragment cameraIntroduceVideoPlayItemFragment2 = new CameraIntroduceVideoPlayItemFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putSerializable("CAMERA_CURRENT_MODEL", deviceModel);
                bundle2.putString("CAMERA_DEVICEIDMD5", this.p3);
                bundle2.putString("title", R0(i));
                cameraIntroduceVideoPlayItemFragment2.setArguments(bundle2);
                arrayList.add(cameraIntroduceVideoPlayItemFragment2);
                i++;
            }
        } else if (DeviceModel.CAMERA_C310 == deviceModel || DeviceModel.CAMERA_TC65 == deviceModel) {
            while (i < 5) {
                CameraIntroduceVideoPlayItemFragment cameraIntroduceVideoPlayItemFragment3 = new CameraIntroduceVideoPlayItemFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putSerializable("CAMERA_CURRENT_MODEL", deviceModel);
                bundle3.putString("CAMERA_DEVICEIDMD5", this.p3);
                bundle3.putString("title", S0(i));
                cameraIntroduceVideoPlayItemFragment3.setArguments(bundle3);
                arrayList.add(cameraIntroduceVideoPlayItemFragment3);
                i++;
            }
        } else if (deviceModel == DeviceModel.CAMERA_C320WS) {
            while (i < 6) {
                CameraIntroduceVideoPlayItemFragment cameraIntroduceVideoPlayItemFragment4 = new CameraIntroduceVideoPlayItemFragment();
                Bundle bundle4 = new Bundle();
                bundle4.putSerializable("CAMERA_CURRENT_MODEL", deviceModel);
                bundle4.putString("CAMERA_DEVICEIDMD5", this.p3);
                bundle4.putString("title", T0(i));
                cameraIntroduceVideoPlayItemFragment4.setArguments(bundle4);
                arrayList.add(cameraIntroduceVideoPlayItemFragment4);
                i++;
            }
        } else {
            while (i < 5) {
                CameraIntroduceVideoPlayItemFragment cameraIntroduceVideoPlayItemFragment5 = new CameraIntroduceVideoPlayItemFragment();
                Bundle bundle5 = new Bundle();
                bundle5.putSerializable("CAMERA_CURRENT_MODEL", deviceModel);
                bundle5.putString("CAMERA_DEVICEIDMD5", this.p3);
                bundle5.putString("title", R0(i));
                cameraIntroduceVideoPlayItemFragment5.setArguments(bundle5);
                arrayList.add(cameraIntroduceVideoPlayItemFragment5);
                i++;
            }
        }
        return arrayList;
    }

    public static CameraFirstShowFunctionGuideDialog X0(DeviceModel deviceModel, String str, d dVar) {
        CameraFirstShowFunctionGuideDialog cameraFirstShowFunctionGuideDialog = new CameraFirstShowFunctionGuideDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable("CAMERA_CURRENT_MODEL", deviceModel);
        bundle.putString("CAMERA_DEVICEIDMD5", str);
        cameraFirstShowFunctionGuideDialog.setArguments(bundle);
        cameraFirstShowFunctionGuideDialog.a1(dVar);
        return cameraFirstShowFunctionGuideDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(int i) {
        for (int i2 = 0; i2 < this.z.getChildCount(); i2++) {
            this.z.getChildAt(i2).setBackground(getContext().getDrawable(R.drawable.common_dot_grey));
        }
        this.z.getChildAt(i).setBackground(getContext().getDrawable(R.drawable.common_ring_blue));
    }

    private void Z0(List<CameraIntroduceVideoPlayItemFragment> list) {
        for (int i = 0; i < list.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i == 0) {
                layoutParams.setMargins(0, 0, 8, 0);
            } else {
                layoutParams.setMargins(8, 0, 8, 0);
            }
            imageView.setBackground(getContext().getDrawable(R.drawable.common_dot_grey));
            this.z.addView(imageView, layoutParams);
        }
    }

    @Override // com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment
    protected int A0() {
        return R.layout.dialog_camera_first_show_function_guide_sheet;
    }

    @Override // com.tplink.iot.devicecommon.view.bottomsheet.BaseBottomSheetDialogFragment
    protected void B0(View view) {
        DeviceModel deviceModel;
        setCancelable(false);
        TextView textView = (TextView) view.findViewById(R.id.exit_introduce);
        this.f8957f = textView;
        textView.setOnClickListener(this);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_start_trial_url);
        this.q = textView2;
        textView2.setText(String.format(getActivity().getString(R.string.tapo_care_cloud_stroage_trial_bt_V2), "30"));
        this.q.setOnClickListener(this);
        TextView textView3 = (TextView) view.findViewById(R.id.btn_exit);
        this.x = textView3;
        textView3.setOnClickListener(this);
        this.x.getPaint().setFlags(8);
        this.y = (ViewPager2) view.findViewById(R.id.function_view_pager);
        this.z = (LinearLayout) view.findViewById(R.id.position_dot);
        this.p1 = (LinearLayout) view.findViewById(R.id.function_introduce_parent);
        this.p0 = (LinearLayout) view.findViewById(R.id.function_welcome_parent);
        Button button = (Button) view.findViewById(R.id.btn_go);
        this.p2 = button;
        button.setOnClickListener(this);
        this.f8956d = (ImageView) view.findViewById(R.id.welcome_icon);
        Bundle arguments = getArguments();
        if (arguments != null) {
            deviceModel = (DeviceModel) arguments.getSerializable("CAMERA_CURRENT_MODEL");
            this.p3 = arguments.getString("CAMERA_DEVICEIDMD5");
        } else {
            deviceModel = null;
        }
        List<CameraIntroduceVideoPlayItemFragment> V0 = V0(deviceModel);
        if (!h.D(this.p3)) {
            V0.remove(V0.size() - 1);
            this.J3 = false;
        }
        this.f8956d.setImageResource(U0(deviceModel));
        Z0(V0);
        this.y.setAdapter(new CameraIntroduceVideoPlayPager2Adapter(getChildFragmentManager(), getLifecycle(), V0));
        View childAt = this.y.getChildAt(0);
        if (childAt != null && (childAt instanceof RecyclerView)) {
            childAt.setOverScrollMode(2);
        }
        this.y.registerOnPageChangeCallback(new a(V0));
    }

    @SuppressLint({"CheckResult"})
    public q<DeviceCloudProduct> P0(String str) {
        return h.i(str, false).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new c());
    }

    public int W0() {
        DeviceCloudProduct deviceCloudProduct = this.I3;
        return (deviceCloudProduct != null && deviceCloudProduct.getTrialQualified()) ? 0 : 8;
    }

    public void a1(d dVar) {
        this.H3 = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exit /* 2131362058 */:
            case R.id.exit_introduce /* 2131362562 */:
                C0();
                d dVar = this.H3;
                if (dVar != null) {
                    dVar.onFinish();
                    return;
                }
                return;
            case R.id.btn_go /* 2131362065 */:
                this.p0.setVisibility(8);
                this.p1.setVisibility(0);
                return;
            case R.id.tv_start_trial_url /* 2131364646 */:
                TrialDialogActivity.f1(getActivity(), e.k(h.j(this.p3)));
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"CheckResult"})
    public void onResume() {
        super.onResume();
        P0(this.p3).G0(new b());
    }
}
