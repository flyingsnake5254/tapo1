package com.tplink.iot.widget.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.a.d;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class SmartRefreshHeader extends SimpleComponent implements d {
    private LinearLayout q;
    private ImageView x;
    private Animation y;

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.PullDownToRefresh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.ReleaseToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.RefreshFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public SmartRefreshHeader(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.c.h
    public void h(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        LinearLayout linearLayout;
        ImageView imageView;
        int i = a.a[refreshState2.ordinal()];
        if (i == 1) {
            ImageView imageView2 = this.x;
            if (imageView2 != null && imageView2.getVisibility() == 8 && (linearLayout = this.q) != null) {
                linearLayout.setVisibility(0);
            }
        } else if (i == 2) {
            LinearLayout linearLayout2 = this.q;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            ImageView imageView3 = this.x;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
                this.x.startAnimation(this.y);
            }
        } else if (i == 3 && (imageView = this.x) != null) {
            imageView.clearAnimation();
            this.x.setVisibility(8);
        }
    }

    public SmartRefreshHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartRefreshHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_smart_refresh_header, this);
        this.q = (LinearLayout) inflate.findViewById(R.id.ll_pull_down_view);
        this.x = (ImageView) inflate.findViewById(R.id.iv_home_loading);
        this.y = AnimationUtils.loadAnimation(context, R.anim.anim_common_roate);
    }
}
