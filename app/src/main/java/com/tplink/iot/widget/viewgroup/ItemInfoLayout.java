package com.tplink.iot.widget.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tplink.iot.R;
import com.tplink.iot.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: ItemInfoLayout.kt */
/* loaded from: classes3.dex */
public final class ItemInfoLayout extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private final TextView f11876c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f11877d;

    /* renamed from: f  reason: collision with root package name */
    private final View f11878f;

    public ItemInfoLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    public ItemInfoLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ItemInfoLayout(Context context, AttributeSet attributeSet, int i, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void setDividerLineVisibility(boolean z) {
        this.f11878f.setVisibility(z ? 0 : 8);
    }

    public final void setInfoText(String str) {
        TextView textView = this.f11877d;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    public final void setTitleText(String str) {
        TextView textView = this.f11876c;
        if (str == null) {
            str = "";
        }
        textView.setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.e(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_item_info_layout, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.tv_title);
        j.d(findViewById, "rootView.findViewById(R.id.tv_title)");
        this.f11876c = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_info);
        j.d(findViewById2, "rootView.findViewById(R.id.tv_info)");
        this.f11877d = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.divider);
        j.d(findViewById3, "rootView.findViewById(R.id.divider)");
        this.f11878f = findViewById3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.ItemInfoLayout);
        setTitleText(obtainStyledAttributes.getString(2));
        setInfoText(obtainStyledAttributes.getString(1));
        setDividerLineVisibility(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    public final void setInfoText(@StringRes int i) {
        this.f11877d.setText(i);
    }

    public final void setTitleText(@StringRes int i) {
        this.f11876c.setText(i);
    }
}
