package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.i;
import com.tplink.iot.view.colorbulb.EditAutoDialog;
import com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DesiredStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes3.dex */
public class SmartColorBulbPresetStatusView extends LinearLayout implements View.OnClickListener, EditAutoDialog.a, EditColorBulbPresetDialog.b {
    private EditAutoDialog H3;
    private String I3;
    private DesiredStatesBean J3;
    private boolean K3;
    private a L3;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11770c;

    /* renamed from: d  reason: collision with root package name */
    private ColorPointView f11771d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11772f;
    private List<LightStateBean> p0;
    private LinearLayout.LayoutParams p1;
    private FragmentManager p2;
    private EditColorBulbPresetDialog p3;
    private TextView q;
    private View x;
    private ColorPointView y;
    private View z;

    /* loaded from: classes3.dex */
    public interface a {
        void d();

        void p();
    }

    public SmartColorBulbPresetStatusView(Context context) {
        this(context, null);
    }

    private void a() {
        this.y.setSelectedStatus(false);
        int childCount = this.f11770c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f11770c.getChildAt(i);
            if (childAt instanceof ColorPointView) {
                ((ColorPointView) childAt).setSelectedStatus(false);
            }
        }
    }

    private void b() {
        if (this.J3 == null) {
            DesiredStatesBean desiredStatesBean = new DesiredStatesBean();
            this.J3 = desiredStatesBean;
            desiredStatesBean.setBrightness(100);
            this.J3.setColorTemp(2700);
            this.J3.setOn(true);
        }
    }

    private boolean c(LightStateBean lightStateBean) {
        DesiredStatesBean desiredStatesBean = this.J3;
        return desiredStatesBean != null && lightStateBean != null && !desiredStatesBean.isAuto() && lightStateBean.getColorTemp() == this.J3.getColorTemp() && lightStateBean.getBrightness() == this.J3.getBrightness() && lightStateBean.getHue() == this.J3.getHue() && lightStateBean.getSaturation() == this.J3.getSaturation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void e(View view) {
        if (this.J3.isAuto()) {
            i();
        } else {
            j(new LightStateBean(this.J3.getHue(), this.J3.getSaturation(), this.J3.getColorTemp(), this.J3.getBrightness()));
        }
    }

    private void i() {
        FragmentManager fragmentManager = this.p2;
        if (fragmentManager != null && fragmentManager.findFragmentByTag("EditAutoDialog") == null) {
            EditAutoDialog G0 = EditAutoDialog.G0(this.I3);
            this.H3 = G0;
            G0.show(this.p2, "EditAutoDialog");
            this.H3.I0(this);
        }
    }

    private void j(LightStateBean lightStateBean) {
        FragmentManager fragmentManager = this.p2;
        if (fragmentManager != null && fragmentManager.findFragmentByTag("EditColorBulbPresetDialog") == null) {
            EditColorBulbPresetDialog H0 = EditColorBulbPresetDialog.H0(lightStateBean, getContext().getString(R.string.light_setting));
            this.p3 = H0;
            H0.J0(this);
            this.p3.show(this.p2, "EditColorBulbPresetDialog");
        }
    }

    private void l(DesiredStatesBean desiredStatesBean) {
        b();
        if (desiredStatesBean != null && desiredStatesBean.isOn()) {
            this.J3.setOn(true);
            this.J3.setColorTemp(desiredStatesBean.getColorTemp());
            this.J3.setHue(desiredStatesBean.getHue());
            this.J3.setSaturation(desiredStatesBean.getSaturation());
            this.J3.setBrightness(desiredStatesBean.getBrightness());
            this.J3.setAuto(desiredStatesBean.isAuto());
            this.J3.setAutoMode(desiredStatesBean.getAutoMode());
            a aVar = this.L3;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    private void m(String str) {
        b();
        k(str);
        this.J3.setAuto(true);
        this.J3.setAutoMode(str);
        this.J3.setColorTemp(0);
        this.J3.setHue(0);
        this.J3.setSaturation(0);
        this.J3.setBrightness(0);
        a aVar = this.L3;
        if (aVar != null) {
            aVar.p();
        }
    }

    private void n(LightStateBean lightStateBean) {
        b();
        if (lightStateBean != null) {
            this.J3.setAuto(false);
            this.J3.setAutoMode(null);
            this.J3.setColorTemp(lightStateBean.getColorTemp());
            this.J3.setHue(lightStateBean.getHue());
            this.J3.setSaturation(lightStateBean.getSaturation());
            this.J3.setBrightness(lightStateBean.getBrightness());
            a aVar = this.L3;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    private void o() {
        if (this.J3.isAuto()) {
            this.f11772f.setVisibility(0);
            this.x.setVisibility(8);
            this.f11772f.setText(TextUtils.equals(this.I3, AutoLightBean.MODE_LIGHT_TRACK) ? R.string.light_track : R.string.light_compensate);
            return;
        }
        this.f11772f.setVisibility(8);
        this.x.setVisibility(0);
        this.q.setVisibility(0);
        this.f11771d.setInnerCircleColor(this.J3.getColorTemp() == 0 ? Color.HSVToColor(new float[]{(float) (this.J3.getHue() * 1.0d), (float) ((this.J3.getSaturation() * 1.0d) / 100.0d), 1.0f}) : -1);
        this.q.setText(this.J3.getBrightness() + "%" + i.e(this.J3.getColorTemp()));
    }

    private void setInnerDesiredStateForPreset(DesiredStatesBean desiredStatesBean) {
        a();
        if (desiredStatesBean.isAuto()) {
            this.y.setSelectedStatus(true);
            k(desiredStatesBean.getAutoMode());
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= this.p0.size()) {
                i = 0;
                break;
            }
            LightStateBean lightStateBean = this.p0.get(i);
            if (desiredStatesBean.getColorTemp() == lightStateBean.getColorTemp() && desiredStatesBean.getHue() == lightStateBean.getHue() && desiredStatesBean.getSaturation() == lightStateBean.getSaturation() && desiredStatesBean.getBrightness() == lightStateBean.getBrightness()) {
                z = true;
                break;
            }
            i++;
        }
        if (z && i < this.f11770c.getChildCount()) {
            View childAt = this.f11770c.getChildAt(i);
            if (childAt instanceof ColorPointView) {
                ((ColorPointView) childAt).setSelectedStatus(true);
            }
        }
    }

    @Override // com.tplink.iot.view.colorbulb.EditAutoDialog.a
    public void J0(String str) {
        m(str);
        setInnerDesiredStateForPreset(this.J3);
        o();
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void U(LightStateBean lightStateBean) {
    }

    public void f() {
        a();
        this.y.setSelectedStatus(true);
        m(this.I3);
        o();
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void g(int i, LightStateBean lightStateBean) {
    }

    public DesiredStatesBean getDesireStates() {
        DesiredStatesBean desiredStatesBean = new DesiredStatesBean();
        if (this.J3.isAuto()) {
            desiredStatesBean.setAuto(true);
            desiredStatesBean.setAutoMode(this.I3);
        } else {
            b();
            DesiredStatesBean desiredStatesBean2 = this.J3;
            if (desiredStatesBean2 != null) {
                desiredStatesBean.setColorTemp(desiredStatesBean2.getColorTemp());
                desiredStatesBean.setHue(this.J3.getHue());
                desiredStatesBean.setSaturation(this.J3.getSaturation());
                desiredStatesBean.setBrightness(this.J3.getBrightness());
            }
        }
        desiredStatesBean.setOn(true);
        return desiredStatesBean;
    }

    @Override // com.tplink.iot.view.colorbulb.EditColorBulbPresetDialog.b
    public void h(LightStateBean lightStateBean) {
        n(lightStateBean);
        setInnerDesiredStateForPreset(this.J3);
        o();
    }

    public void k(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.I3 = str;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.item_auto) {
            a aVar = this.L3;
            if (aVar != null) {
                aVar.d();
            }
        } else if (view instanceof ColorPointView) {
            a();
            ((ColorPointView) view).setSelectedStatus(true);
            if (view.getId() == R.id.item_auto) {
                m(this.I3);
                o();
                return;
            }
            int intValue = ((Integer) view.getTag()).intValue();
            if (intValue >= 0 && intValue < this.p0.size()) {
                n(this.p0.get(intValue));
                o();
            }
        }
    }

    public void setDesiredStates(DesiredStatesBean desiredStatesBean) {
        l(desiredStatesBean);
        setInnerDesiredStateForPreset(this.J3);
        o();
    }

    public void setEnable(boolean z) {
        if (this.K3 != z) {
            this.K3 = z;
            this.y.setEnabled(z);
            for (int i = 0; i < this.f11770c.getChildCount(); i++) {
                View childAt = this.f11770c.getChildAt(i);
                if (childAt instanceof ColorPointView) {
                    childAt.setEnabled(z);
                }
            }
            this.z.setEnabled(z);
        }
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.p2 = fragmentManager;
    }

    public void setOnPresetStatusListener(a aVar) {
        this.L3 = aVar;
    }

    public void setPresetList(List<LightStateBean> list) {
        this.f11770c.removeAllViews();
        this.p0.clear();
        if (!(list == null || list.isEmpty())) {
            this.p0.addAll(list);
            boolean z = false;
            for (int i = 0; i < list.size(); i++) {
                LightStateBean lightStateBean = list.get(i);
                ColorPointView colorPointView = new ColorPointView(getContext(), b.a(getContext(), 48.0d), getResources().getColor(R.color.common_iot_main_blue), i.c(lightStateBean.getColorTemp(), lightStateBean.getHue(), lightStateBean.getSaturation()));
                if (!z && c(lightStateBean)) {
                    colorPointView.setSelectedStatus(true);
                    z = true;
                }
                colorPointView.setOnClickListener(this);
                colorPointView.setTag(Integer.valueOf(i));
                colorPointView.setEnabled(this.K3);
                this.p1.leftMargin = b.a(getContext(), 10.0d);
                this.f11770c.addView(colorPointView, this.p1);
            }
        }
    }

    public SmartColorBulbPresetStatusView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartColorBulbPresetStatusView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.p0 = new ArrayList();
        this.I3 = AutoLightBean.MODE_LIGHT_TRACK;
        this.K3 = true;
        LayoutInflater.from(context).inflate(R.layout.view_smart_color_bulb_preset_status, (ViewGroup) this, true);
        this.y = (ColorPointView) findViewById(R.id.item_auto);
        this.f11770c = (LinearLayout) findViewById(R.id.ll_presets);
        this.f11772f = (TextView) findViewById(R.id.tv_auto_mode);
        this.f11771d = (ColorPointView) findViewById(R.id.color_point_view);
        this.q = (TextView) findViewById(R.id.tv_brightness);
        this.x = findViewById(R.id.ll_bulb_status_info);
        this.z = findViewById(R.id.rl_status);
        this.p1 = new LinearLayout.LayoutParams(-2, -2);
        this.y.setOnClickListener(this);
        b();
        this.z.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.widget.colorbulb.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmartColorBulbPresetStatusView.this.e(view);
            }
        });
    }
}
