package com.tplink.iot.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.b;

/* loaded from: classes3.dex */
public class OrderTextView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f11577c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11578d;

    public OrderTextView(Context context) {
        this(context, null);
    }

    public void setContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f11578d.setText(str);
        } else {
            this.f11578d.setText("");
        }
    }

    public OrderTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrderTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.layout_order_textview, (ViewGroup) this, true);
        setOrientation(0);
        this.f11577c = (TextView) findViewById(R.id.tv_order);
        this.f11578d = (TextView) findViewById(R.id.item_content);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.OrderTextView, i, 0);
        if (obtainStyledAttributes != null) {
            this.f11577c.setText(obtainStyledAttributes.getInteger(0, 1) + ".");
            setContent(obtainStyledAttributes.getString(1));
            obtainStyledAttributes.recycle();
        }
    }
}
