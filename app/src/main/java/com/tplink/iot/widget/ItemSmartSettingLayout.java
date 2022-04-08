package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.b;

/* loaded from: classes3.dex */
public class ItemSmartSettingLayout extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f11555c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11556d;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f11557f;
    private ImageView q;
    private View x;

    public ItemSmartSettingLayout(Context context) {
        this(context, null);
    }

    public void setBottomDividerVisible(boolean z) {
        this.x.setVisibility(z ? 0 : 4);
    }

    public void setItemEnable(boolean z) {
        findViewById(R.id.rl_smart_settings).setAlpha(z ? 1.0f : 0.4f);
        findViewById(R.id.rl_smart_settings).setEnabled(z);
    }

    public void setItemIcon(@DrawableRes int i) {
        this.q.setImageResource(i);
    }

    public void setItemIconVisible(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void setItemInfo(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f11556d.setVisibility(0);
            this.f11556d.setText(charSequence);
            return;
        }
        this.f11556d.setVisibility(8);
        this.f11556d.setText("");
    }

    public void setItemTitle(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f11555c.setText(str);
        } else {
            this.f11555c.setText("");
        }
    }

    public void setRightArrowVisible(boolean z) {
        this.f11557f.setVisibility(z ? 0 : 8);
    }

    public ItemSmartSettingLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemSmartSettingLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.view_item_smart_setting_layout, (ViewGroup) this, true);
        this.f11555c = (TextView) findViewById(R.id.item_title_hint);
        this.f11556d = (TextView) findViewById(R.id.item_info);
        this.q = (ImageView) findViewById(R.id.iv_setting_item_icon);
        this.f11557f = (ImageView) findViewById(R.id.iv_item_right_icon);
        this.x = findViewById(R.id.bottom_divider);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ItemSmartSettingLayout, i, 0);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(4);
            String string2 = obtainStyledAttributes.getString(5);
            boolean z = obtainStyledAttributes.getBoolean(2, true);
            boolean z2 = obtainStyledAttributes.getBoolean(3, true);
            boolean z3 = obtainStyledAttributes.getBoolean(0, false);
            setItemTitle(string);
            setItemInfo(string2);
            setItemIconVisible(z);
            setRightArrowVisible(z2);
            setBottomDividerVisible(z3);
            obtainStyledAttributes.recycle();
        }
    }
}
