package com.tplink.libtpcontrols.horizontalscrollpage;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.libtpcontrols.horizontalscrollpage.PagingScrollHelper;
import com.tplink.libtpcontrols.r0;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.x0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TPPageRecycleSelector extends FrameLayout implements PagingScrollHelper.c {
    private a N3;

    /* renamed from: c  reason: collision with root package name */
    private Context f12298c = null;

    /* renamed from: d  reason: collision with root package name */
    private View f12299d = null;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView f12300f = null;
    private PageIndicatorView q = null;
    private PagingScrollHelper x = new PagingScrollHelper(2, 3);
    private RecyclerView.Adapter y = null;
    private HorizontalPageLayoutManager z = null;
    private float p0 = -1.0f;
    private float p1 = -1.0f;
    private boolean p2 = true;
    private int p3 = 0;
    private int H3 = -1;
    private int I3 = -1;
    private float J3 = 0.0f;
    private float K3 = 0.0f;
    private List<String> L3 = null;
    private List<?> M3 = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public TPPageRecycleSelector(Context context) {
        super(context);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f12298c = context;
        this.f12299d = LayoutInflater.from(context).inflate(t0.page_recycle_select_main, (ViewGroup) this, true);
        this.f12300f = (RecyclerView) findViewById(s0.recycleview);
        this.q = (PageIndicatorView) findViewById(s0.indicator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, x0.TPPageRecycleSelector);
        this.p0 = obtainStyledAttributes.getDimension(x0.TPPageRecycleSelector_page_selector_width, -1.0f);
        this.p1 = obtainStyledAttributes.getDimension(x0.TPPageRecycleSelector_page_selector_height, -1.0f);
        this.p2 = obtainStyledAttributes.getBoolean(x0.TPPageRecycleSelector_page_indicator_enable, true);
        int i = obtainStyledAttributes.getInt(x0.TPPageRecycleSelector_page_indicator_index, -1);
        this.p3 = i;
        if (i < 0) {
            this.p3 = 0;
        }
        this.H3 = obtainStyledAttributes.getResourceId(x0.TPPageRecycleSelector_page_indicator_invisible, r0.shape_circle_cyan_arc);
        this.I3 = obtainStyledAttributes.getResourceId(x0.TPPageRecycleSelector_page_indicator_online, r0.shape_circle_cyan);
        this.J3 = obtainStyledAttributes.getDimension(x0.TPPageRecycleSelector_page_indicator_size, -1.0f);
        this.K3 = obtainStyledAttributes.getDimension(x0.TPPageRecycleSelector_page_indicator_margin, -1.0f);
        if (this.p1 > 0.0f) {
            ViewGroup.LayoutParams layoutParams = this.f12300f.getLayoutParams();
            layoutParams.height = (int) this.p1;
            this.f12300f.setLayoutParams(layoutParams);
        }
        if (this.p0 > 0.0f) {
            ViewGroup.LayoutParams layoutParams2 = this.f12300f.getLayoutParams();
            layoutParams2.width = (int) this.p0;
            this.f12300f.setLayoutParams(layoutParams2);
        }
        HorizontalPageLayoutManager horizontalPageLayoutManager = new HorizontalPageLayoutManager(2, 3);
        this.z = horizontalPageLayoutManager;
        horizontalPageLayoutManager.d(d(getContext()));
        c();
        obtainStyledAttributes.recycle();
    }

    private void c() {
        if (this.L3 == null) {
            this.L3 = new ArrayList();
            for (int i = 1; i <= 16; i++) {
                List<String> list = this.L3;
                list.add("" + i);
            }
        }
        if (this.y == null) {
            this.y = new SimpleAdapter(this.f12298c, this.L3);
        }
        this.f12300f.setAdapter(this.y);
        this.x.x(d(this.f12298c));
        this.x.z(this.f12300f);
        this.x.y(this);
        if (this.p2) {
            this.q.setVisibility(0);
        } else {
            this.q.setVisibility(8);
        }
        float f2 = this.J3;
        if (f2 > 0.0f) {
            this.q.setIndicatorSize((int) f2);
        }
        float f3 = this.K3;
        if (f3 > 0.0f) {
            this.q.setIndicatorMargin((int) f3);
        }
        int i2 = this.H3;
        if (i2 > 0) {
            this.q.setInvisibleResource(i2);
        }
        int i3 = this.I3;
        if (i3 > 0) {
            this.q.setOnlineResource(i3);
        }
        int i4 = this.p3;
        if (i4 >= 0) {
            this.q.setIndexOfIndicator(i4);
        }
        this.x.w(this.q);
        this.f12300f.setLayoutManager(this.z);
        this.x.A();
    }

    @TargetApi(17)
    private boolean d(Context context) {
        return Build.VERSION.SDK_INT >= 17 && context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.tplink.libtpcontrols.horizontalscrollpage.PagingScrollHelper.c
    public void a(int i) {
        a aVar = this.N3;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setCustomHeight(float f2) {
        this.p1 = f2;
    }

    public void setCustomWidth(float f2) {
        this.p0 = f2;
    }

    public void setOnPageChangeListener(a aVar) {
        this.N3 = aVar;
    }

    public void setPageAdapter(RecyclerView.Adapter adapter) {
        this.y = adapter;
    }

    public void setPageData(List<?> list) {
        this.M3 = list;
    }

    public TPPageRecycleSelector(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }
}
