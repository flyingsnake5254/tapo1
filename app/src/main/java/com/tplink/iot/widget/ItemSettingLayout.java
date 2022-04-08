package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.b;

/* loaded from: classes3.dex */
public class ItemSettingLayout extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f11552c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11553d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11554f;
    private ImageView q;
    private ImageView x;

    public ItemSettingLayout(Context context) {
        this(context, null);
    }

    public TextView getItemInfoTextView() {
        return this.f11553d;
    }

    public TextView getItemRightTextView() {
        return this.f11554f;
    }

    public void setItemInfo(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f11553d.setVisibility(0);
            this.f11553d.setText(charSequence);
            return;
        }
        this.f11553d.setVisibility(8);
        this.f11553d.setText("");
    }

    public void setItemInfoColor(int i) {
        this.f11553d.setTextColor(i);
    }

    public void setItemTitleHint(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f11552c.setText(str);
        } else {
            this.f11552c.setText("");
        }
    }

    public void setNotificationVisible(boolean z) {
        this.x.setVisibility(z ? 0 : 8);
    }

    public void setRightArrowVisible(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public ItemSettingLayout(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ItemSettingLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.view_item_setting_title_layout, (ViewGroup) this, true);
        this.f11552c = (TextView) findViewById(R.id.item_title_hint);
        this.f11553d = (TextView) findViewById(R.id.item_info);
        this.f11554f = (TextView) findViewById(R.id.tv_right_annotation);
        this.q = (ImageView) findViewById(R.id.right_arrow);
        this.x = (ImageView) findViewById(R.id.iv_notification);
        this.f11554f.setVisibility(8);
        int i2 = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ItemSettingLayout, i, 0);
        if (obtainStyledAttributes != null) {
            String string = obtainStyledAttributes.getString(3);
            String string2 = obtainStyledAttributes.getString(2);
            boolean z = obtainStyledAttributes.getBoolean(1, false);
            boolean z2 = obtainStyledAttributes.getBoolean(0, true);
            setItemTitleHint(string);
            setItemInfo(string2);
            setRightArrowVisible(z);
            findViewById(R.id.bottom_divider).setVisibility(!z2 ? 4 : i2);
            obtainStyledAttributes.recycle();
        }
    }
}
