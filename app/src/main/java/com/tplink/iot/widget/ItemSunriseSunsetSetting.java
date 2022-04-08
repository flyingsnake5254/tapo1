package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.libtpcontrols.materialnormalcompat.checkbox.TPCheckboxCompat;

/* loaded from: classes3.dex */
public class ItemSunriseSunsetSetting extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TPCheckboxCompat f11558c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11559d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11560f;
    private ImageView q;
    private String x;
    private int y;
    private b z;

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ItemSunriseSunsetSetting.this.z != null) {
                ItemSunriseSunsetSetting.this.z.onOffsetSettingClick(ItemSunriseSunsetSetting.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void onOffsetSettingClick(View view);
    }

    public ItemSunriseSunsetSetting(Context context) {
        this(context, null);
    }

    public boolean b() {
        return this.f11558c.isChecked();
    }

    public void setChecked(boolean z) {
        this.f11558c.setChecked(z);
        if (this.y != 1) {
            if (z) {
                this.f11560f.setVisibility(0);
                this.q.setVisibility(0);
                return;
            }
            this.f11560f.setVisibility(8);
            this.q.setVisibility(4);
        }
    }

    public void setItemTitle(int i) {
        this.f11559d.setText(i);
    }

    public void setItemType(int i) {
        this.y = i;
    }

    public void setOffset(String str) {
        this.f11560f.setText(str);
    }

    public void setOnOffsetSettingClickListener(b bVar) {
        this.z = bVar;
    }

    public ItemSunriseSunsetSetting(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemSunriseSunsetSetting(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.y = 0;
        LayoutInflater.from(context).inflate(R.layout.view_sunrise_sunset_setting, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tplink.iot.b.ItemSunriseSunsetSetting, i, 0);
        if (obtainStyledAttributes != null) {
            this.x = obtainStyledAttributes.getString(0);
            this.y = obtainStyledAttributes.getInt(1, 0);
            obtainStyledAttributes.recycle();
        }
        this.f11558c = (TPCheckboxCompat) findViewById(R.id.cb_check);
        this.f11559d = (TextView) findViewById(R.id.tv_title);
        this.f11560f = (TextView) findViewById(R.id.tv_offset);
        this.q = (ImageView) findViewById(R.id.iv_offset_setting);
        this.f11558c.setClickable(false);
        this.f11560f.setVisibility(8);
        this.q.setVisibility(4);
        String str = this.x;
        if (str != null) {
            this.f11559d.setText(str);
        }
        this.q.setOnClickListener(new a());
    }
}
