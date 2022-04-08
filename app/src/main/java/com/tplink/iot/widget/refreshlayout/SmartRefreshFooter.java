package com.tplink.iot.widget.refreshlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.scwang.smart.refresh.layout.a.c;
import com.scwang.smart.refresh.layout.a.f;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.scwang.smart.refresh.layout.simple.SimpleComponent;
import com.tplink.iot.R;

/* loaded from: classes3.dex */
public class SmartRefreshFooter extends SimpleComponent implements c {
    private ImageView q;
    private Animation x;

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            a = iArr;
            try {
                iArr[RefreshState.PullUpToLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RefreshState.Loading.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RefreshState.LoadFinish.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public SmartRefreshFooter(Context context) {
        this(context, null);
    }

    @Override // com.scwang.smart.refresh.layout.simple.SimpleComponent, com.scwang.smart.refresh.layout.c.h
    public void h(@NonNull f fVar, @NonNull RefreshState refreshState, @NonNull RefreshState refreshState2) {
        ImageView imageView;
        int i = a.a[refreshState2.ordinal()];
        if (i == 1) {
            ImageView imageView2 = this.q;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else if (i == 2) {
            ImageView imageView3 = this.q;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
                this.q.startAnimation(this.x);
            }
        } else if (i == 3 && (imageView = this.q) != null) {
            imageView.clearAnimation();
            this.q.setVisibility(8);
        }
    }

    public SmartRefreshFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartRefreshFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.q = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_smart_refresh_footer, this).findViewById(R.id.iv_loading);
        this.x = AnimationUtils.loadAnimation(context, R.anim.anim_common_roate);
    }
}
