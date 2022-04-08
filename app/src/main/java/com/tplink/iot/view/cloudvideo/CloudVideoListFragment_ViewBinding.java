package com.tplink.iot.view.cloudvideo;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

/* loaded from: classes2.dex */
public class CloudVideoListFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private CloudVideoListFragment f8358b;

    /* renamed from: c  reason: collision with root package name */
    private View f8359c;

    /* renamed from: d  reason: collision with root package name */
    private View f8360d;

    /* renamed from: e  reason: collision with root package name */
    private View f8361e;

    /* renamed from: f  reason: collision with root package name */
    private View f8362f;
    private View g;
    private View h;
    private View i;
    private View j;

    /* loaded from: classes2.dex */
    class a extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8363f;

        a(CloudVideoListFragment cloudVideoListFragment) {
            this.f8363f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8363f.hideDateSelector();
        }
    }

    /* loaded from: classes2.dex */
    class b extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8364f;

        b(CloudVideoListFragment cloudVideoListFragment) {
            this.f8364f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8364f.dateMoveForward();
        }
    }

    /* loaded from: classes2.dex */
    class c extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8365f;

        c(CloudVideoListFragment cloudVideoListFragment) {
            this.f8365f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8365f.hideDateSelector();
        }
    }

    /* loaded from: classes2.dex */
    class d extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8366f;

        d(CloudVideoListFragment cloudVideoListFragment) {
            this.f8366f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8366f.dateCurDate();
        }
    }

    /* loaded from: classes2.dex */
    class e extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8367f;

        e(CloudVideoListFragment cloudVideoListFragment) {
            this.f8367f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8367f.dateToday();
        }
    }

    /* loaded from: classes2.dex */
    class f extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8368f;

        f(CloudVideoListFragment cloudVideoListFragment) {
            this.f8368f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8368f.enterSelectMode();
        }
    }

    /* loaded from: classes2.dex */
    class g extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8369f;

        g(CloudVideoListFragment cloudVideoListFragment) {
            this.f8369f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8369f.gotoDailySummary();
        }
    }

    /* loaded from: classes2.dex */
    class h extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ CloudVideoListFragment f8370f;

        h(CloudVideoListFragment cloudVideoListFragment) {
            this.f8370f = cloudVideoListFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8370f.dateMoveBackward();
        }
    }

    @UiThread
    public CloudVideoListFragment_ViewBinding(CloudVideoListFragment cloudVideoListFragment, View view) {
        this.f8358b = cloudVideoListFragment;
        cloudVideoListFragment.mToolbar = (Toolbar) butterknife.internal.c.d(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
        cloudVideoListFragment.mCloudVideoRv = (RecyclerView) butterknife.internal.c.d(view, R.id.recycle_cloud_video_list, "field 'mCloudVideoRv'", RecyclerView.class);
        cloudVideoListFragment.mCloudVideoListEmptyView = butterknife.internal.c.c(view, R.id.layout_cloud_video_list_empty, "field 'mCloudVideoListEmptyView'");
        cloudVideoListFragment.mCloudVideoPlayView = butterknife.internal.c.c(view, R.id.cloud_video_play_layout, "field 'mCloudVideoPlayView'");
        cloudVideoListFragment.mDateSelectWidget = (LinearLayout) butterknife.internal.c.d(view, R.id.ll_date_select_widget, "field 'mDateSelectWidget'", LinearLayout.class);
        View c2 = butterknife.internal.c.c(view, R.id.shadow_view, "field 'mShadowView' and method 'hideDateSelector'");
        cloudVideoListFragment.mShadowView = c2;
        this.f8359c = c2;
        c2.setOnClickListener(new a(cloudVideoListFragment));
        View c3 = butterknife.internal.c.c(view, R.id.date_move_forward, "field 'mNextMonthIv' and method 'dateMoveForward'");
        cloudVideoListFragment.mNextMonthIv = (ImageView) butterknife.internal.c.b(c3, R.id.date_move_forward, "field 'mNextMonthIv'", ImageView.class);
        this.f8360d = c3;
        c3.setOnClickListener(new b(cloudVideoListFragment));
        cloudVideoListFragment.mScrollCalendar = (ScrollCalendar) butterknife.internal.c.d(view, R.id.scroll_calendar, "field 'mScrollCalendar'", ScrollCalendar.class);
        View c4 = butterknife.internal.c.c(view, R.id.date_index_back, "field 'mDataIndexBackIv' and method 'hideDateSelector'");
        cloudVideoListFragment.mDataIndexBackIv = (ImageView) butterknife.internal.c.b(c4, R.id.date_index_back, "field 'mDataIndexBackIv'", ImageView.class);
        this.f8361e = c4;
        c4.setOnClickListener(new c(cloudVideoListFragment));
        View c5 = butterknife.internal.c.c(view, R.id.date_cur_date, "field 'mDataCurDateTv' and method 'dateCurDate'");
        cloudVideoListFragment.mDataCurDateTv = (TextView) butterknife.internal.c.b(c5, R.id.date_cur_date, "field 'mDataCurDateTv'", TextView.class);
        this.f8362f = c5;
        c5.setOnClickListener(new d(cloudVideoListFragment));
        View c6 = butterknife.internal.c.c(view, R.id.date_today, "field 'mDateToday' and method 'dateToday'");
        cloudVideoListFragment.mDateToday = (TextView) butterknife.internal.c.b(c6, R.id.date_today, "field 'mDateToday'", TextView.class);
        this.g = c6;
        c6.setOnClickListener(new e(cloudVideoListFragment));
        cloudVideoListFragment.mDateSelectorView = butterknife.internal.c.c(view, R.id.cloud_video_date_selector, "field 'mDateSelectorView'");
        View c7 = butterknife.internal.c.c(view, R.id.iv_edit, "field 'mEditBtn' and method 'enterSelectMode'");
        cloudVideoListFragment.mEditBtn = (ImageView) butterknife.internal.c.b(c7, R.id.iv_edit, "field 'mEditBtn'", ImageView.class);
        this.h = c7;
        c7.setOnClickListener(new f(cloudVideoListFragment));
        cloudVideoListFragment.mSelectDateTopBar = butterknife.internal.c.c(view, R.id.select_date_top_bar, "field 'mSelectDateTopBar'");
        cloudVideoListFragment.mRefreshLayout = (TPSmartRefreshLayout) butterknife.internal.c.d(view, R.id.cloud_video_list_refresh_container, "field 'mRefreshLayout'", TPSmartRefreshLayout.class);
        View c8 = butterknife.internal.c.c(view, R.id.btn_into_daily_summary, "field 'mBtnIntoDailySummary' and method 'gotoDailySummary'");
        cloudVideoListFragment.mBtnIntoDailySummary = c8;
        this.i = c8;
        c8.setOnClickListener(new g(cloudVideoListFragment));
        cloudVideoListFragment.mDailySummaryIntoInfo = (TextView) butterknife.internal.c.d(view, R.id.tv_daily_summary_into_info, "field 'mDailySummaryIntoInfo'", TextView.class);
        cloudVideoListFragment.mNewDailySummaryPoint = (ImageView) butterknife.internal.c.d(view, R.id.iv_new_daily_summary_red_point, "field 'mNewDailySummaryPoint'", ImageView.class);
        View c9 = butterknife.internal.c.c(view, R.id.date_move_backward, "method 'dateMoveBackward'");
        this.j = c9;
        c9.setOnClickListener(new h(cloudVideoListFragment));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        CloudVideoListFragment cloudVideoListFragment = this.f8358b;
        if (cloudVideoListFragment != null) {
            this.f8358b = null;
            cloudVideoListFragment.mToolbar = null;
            cloudVideoListFragment.mCloudVideoRv = null;
            cloudVideoListFragment.mCloudVideoListEmptyView = null;
            cloudVideoListFragment.mCloudVideoPlayView = null;
            cloudVideoListFragment.mDateSelectWidget = null;
            cloudVideoListFragment.mShadowView = null;
            cloudVideoListFragment.mNextMonthIv = null;
            cloudVideoListFragment.mScrollCalendar = null;
            cloudVideoListFragment.mDataIndexBackIv = null;
            cloudVideoListFragment.mDataCurDateTv = null;
            cloudVideoListFragment.mDateToday = null;
            cloudVideoListFragment.mDateSelectorView = null;
            cloudVideoListFragment.mEditBtn = null;
            cloudVideoListFragment.mSelectDateTopBar = null;
            cloudVideoListFragment.mRefreshLayout = null;
            cloudVideoListFragment.mBtnIntoDailySummary = null;
            cloudVideoListFragment.mDailySummaryIntoInfo = null;
            cloudVideoListFragment.mNewDailySummaryPoint = null;
            this.f8359c.setOnClickListener(null);
            this.f8359c = null;
            this.f8360d.setOnClickListener(null);
            this.f8360d = null;
            this.f8361e.setOnClickListener(null);
            this.f8361e = null;
            this.f8362f.setOnClickListener(null);
            this.f8362f = null;
            this.g.setOnClickListener(null);
            this.g = null;
            this.h.setOnClickListener(null);
            this.h = null;
            this.i.setOnClickListener(null);
            this.i = null;
            this.j.setOnClickListener(null);
            this.j = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
