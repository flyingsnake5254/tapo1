package com.tplink.iot.widget.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes3.dex */
public class TPSmartRefreshLayout extends SmartRefreshLayout {
    public TPSmartRefreshLayout(Context context) {
        super(context);
        T();
    }

    private void T() {
        D(0.6f);
        I(3.0f);
        H(3.0f);
        J(1.5f);
        J(1.5f);
    }

    public TPSmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        T();
    }
}
