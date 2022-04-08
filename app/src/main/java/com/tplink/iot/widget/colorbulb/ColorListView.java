package com.tplink.iot.widget.colorbulb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.g.b;

/* loaded from: classes3.dex */
public class ColorListView extends LinearLayout implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f11737c;

    /* renamed from: d  reason: collision with root package name */
    private List<ColorPointView> f11738d;

    /* renamed from: f  reason: collision with root package name */
    private a f11739f;
    private LinearLayout.LayoutParams q;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i, int i2);
    }

    public ColorListView(Context context) {
        this(context, null);
    }

    private void a() {
        this.f11738d = new ArrayList();
        this.f11737c = new ArrayList();
        this.q = new LinearLayout.LayoutParams(-2, -2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view instanceof ColorPointView) {
            int intValue = ((Integer) view.getTag()).intValue();
            ColorPointView colorPointView = (ColorPointView) view;
            if (intValue >= 0 && intValue < this.f11738d.size() && this.f11739f != null && intValue < this.f11737c.size()) {
                this.f11739f.a(intValue, this.f11737c.get(intValue).intValue());
            }
        }
    }

    public void setColorPresets(List<Integer> list) {
        removeAllViews();
        this.f11737c.clear();
        this.f11738d.clear();
        if (list != null && !list.isEmpty()) {
            this.f11737c.addAll(list);
            int i = 0;
            while (i < list.size()) {
                ColorPointView colorPointView = new ColorPointView(getContext(), b.a(getContext(), 48.0d), getResources().getColor(R.color.common_iot_main_blue), list.get(i).intValue());
                colorPointView.setOnClickListener(this);
                colorPointView.setTag(Integer.valueOf(i));
                this.q.rightMargin = i == 0 ? 0 : b.a(getContext(), 10.0d);
                this.f11738d.add(colorPointView);
                addView(colorPointView, this.q);
                i++;
            }
        }
    }

    public void setOnColorListCheckedListener(a aVar) {
        this.f11739f = aVar;
    }

    public ColorListView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColorListView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
