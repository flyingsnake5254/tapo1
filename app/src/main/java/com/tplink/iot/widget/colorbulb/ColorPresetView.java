package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes3.dex */
public class ColorPresetView extends LinearLayout implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private List<LightStateBean> f11753c;

    /* renamed from: d  reason: collision with root package name */
    private ColorPointView f11754d;

    /* renamed from: f  reason: collision with root package name */
    private List<ColorPointView> f11755f;
    private a q;
    private LinearLayout.LayoutParams x;
    private int y;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, LightStateBean lightStateBean);

        void b();

        void c(int i, int i2, LightStateBean lightStateBean);

        void d();
    }

    public ColorPresetView(Context context) {
        this(context, null);
    }

    private void c(Context context) {
        this.f11755f = new ArrayList();
        this.f11753c = new ArrayList();
        this.x = new LinearLayout.LayoutParams(-2, -2);
    }

    public void a() {
        ColorPointView colorPointView = this.f11754d;
        if (colorPointView != null) {
            colorPointView.setSelectedStatus(false);
        }
        for (int i = 0; i < this.f11755f.size(); i++) {
            this.f11755f.get(i).setSelectedStatus(false);
        }
    }

    public void b() {
        if (getChildCount() > 2) {
            View childAt = getChildAt(2);
            if (childAt instanceof ColorPointView) {
                childAt.callOnClick();
            }
        }
    }

    public void d() {
        a();
        this.f11754d.setSelectedStatus(true);
        this.y = -1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof ColorPointView) {
            int intValue = ((Integer) view.getTag()).intValue();
            ColorPointView colorPointView = (ColorPointView) view;
            boolean b2 = colorPointView.b();
            if (intValue == -1) {
                a aVar = this.q;
                if (aVar == null) {
                    return;
                }
                if (b2) {
                    aVar.b();
                } else {
                    aVar.d();
                }
            } else if (intValue >= 0 && intValue < this.f11755f.size()) {
                a();
                colorPointView.setSelectedStatus(true);
                this.y = intValue;
                a aVar2 = this.q;
                if (aVar2 == null) {
                    return;
                }
                if (b2) {
                    aVar2.c(intValue, colorPointView.getInnerCircleColor(), this.f11753c.get(intValue));
                } else {
                    aVar2.a(intValue, this.f11753c.get(intValue));
                }
            }
        }
    }

    public synchronized void setColorPresets(List<LightStateBean> list) {
        int i;
        ColorPointView colorPointView;
        removeAllViews();
        this.f11753c.clear();
        ColorPointView colorPointView2 = new ColorPointView(getContext(), b.a(getContext(), 44.0d), getResources().getColor(R.color.white), getResources().getColor(R.color.white));
        this.f11754d = colorPointView2;
        colorPointView2.setType(1);
        this.f11754d.setOnClickListener(this);
        this.f11754d.setTag(-1);
        addView(this.f11754d);
        if (list != null && !list.isEmpty()) {
            this.f11753c.addAll(list);
            for (int i2 = 0; i2 < list.size(); i2++) {
                LightStateBean lightStateBean = list.get(i2);
                if (lightStateBean.getColorTemp() == 0) {
                    colorPointView = new ColorPointView(getContext(), b.a(getContext(), 44.0d), getResources().getColor(R.color.white), getResources().getColor(R.color.white), i.d(lightStateBean));
                } else {
                    colorPointView = new ColorPointView(getContext(), b.a(getContext(), 44.0d), getResources().getColor(R.color.white), -1);
                }
                colorPointView.setType(2);
                colorPointView.setOnClickListener(this);
                colorPointView.setTag(Integer.valueOf(i2));
                this.x.leftMargin = b.a(getContext(), 10.0d);
                this.f11755f.add(colorPointView);
                addView(colorPointView, this.x);
            }
            int i3 = this.y;
            if (i3 != Integer.MAX_VALUE && (i = i3 + 1) >= 0 && i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt instanceof ColorPointView) {
                    ((ColorPointView) childAt).setSelectedStatus(true);
                }
            }
        }
    }

    public void setOnColorPresetCheckedListener(a aVar) {
        this.q = aVar;
    }

    public ColorPresetView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorPresetView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = Integer.MAX_VALUE;
        c(context);
    }
}
