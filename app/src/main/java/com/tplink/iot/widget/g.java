package com.tplink.iot.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tplink.iot.R;
import com.tplink.iot.widget.j.a.a;

/* compiled from: PullToRefreshHeader.java */
/* loaded from: classes3.dex */
public class g extends a {
    private LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f11811b;

    /* renamed from: c  reason: collision with root package name */
    private Animation f11812c;

    @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.d
    public void a() {
        this.a.setVisibility(8);
        this.f11811b.setVisibility(0);
        this.f11811b.startAnimation(this.f11812c);
    }

    @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.d
    public void c(View view, int i) {
    }

    @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.d
    public void d() {
        ImageView imageView = this.f11811b;
        if (imageView != null) {
            imageView.clearAnimation();
            this.f11811b.setVisibility(8);
        }
    }

    @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.d
    public void g(View view) {
        if (this.f11811b.getVisibility() == 8) {
            this.a.setVisibility(0);
        }
    }

    @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.d
    public void k(View view, boolean z) {
    }

    @Override // com.tplink.iot.widget.springview.widget.PullToRefreshContainer.d
    public View m(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.layout_pull_to_refresh_header, viewGroup, true);
        this.a = (LinearLayout) inflate.findViewById(R.id.ll_pull_down_view);
        this.f11811b = (ImageView) inflate.findViewById(R.id.iv_home_loading);
        this.f11812c = AnimationUtils.loadAnimation(viewGroup.getContext(), R.anim.anim_common_roate);
        return inflate;
    }
}
