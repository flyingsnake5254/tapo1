package com.tplink.iot.view.feedback;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.b;
import butterknife.internal.c;
import com.tplink.iot.R;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;

/* loaded from: classes2.dex */
public class SelectFeedbackDeviceFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private SelectFeedbackDeviceFragment f8479b;

    /* renamed from: c  reason: collision with root package name */
    private View f8480c;

    /* loaded from: classes2.dex */
    class a extends b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ SelectFeedbackDeviceFragment f8481f;

        a(SelectFeedbackDeviceFragment selectFeedbackDeviceFragment) {
            this.f8481f = selectFeedbackDeviceFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8481f.feedback();
        }
    }

    @UiThread
    public SelectFeedbackDeviceFragment_ViewBinding(SelectFeedbackDeviceFragment selectFeedbackDeviceFragment, View view) {
        this.f8479b = selectFeedbackDeviceFragment;
        selectFeedbackDeviceFragment.mToolbar = (Toolbar) c.d(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
        selectFeedbackDeviceFragment.mToolbarTitle = (TextView) c.d(view, R.id.toolbar_title, "field 'mToolbarTitle'", TextView.class);
        selectFeedbackDeviceFragment.mSelectFeedbackDeviceRV = (RecyclerView) c.d(view, R.id.recycle_select_feedback_device_list, "field 'mSelectFeedbackDeviceRV'", RecyclerView.class);
        View c2 = c.c(view, R.id.btn_feedback_device, "field 'mFeedbackBtn' and method 'feedback'");
        selectFeedbackDeviceFragment.mFeedbackBtn = (TextView) c.b(c2, R.id.btn_feedback_device, "field 'mFeedbackBtn'", TextView.class);
        this.f8480c = c2;
        c2.setOnClickListener(new a(selectFeedbackDeviceFragment));
        selectFeedbackDeviceFragment.mTipsBar = (TipsBar) c.d(view, R.id.tips_bar, "field 'mTipsBar'", TipsBar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        SelectFeedbackDeviceFragment selectFeedbackDeviceFragment = this.f8479b;
        if (selectFeedbackDeviceFragment != null) {
            this.f8479b = null;
            selectFeedbackDeviceFragment.mToolbar = null;
            selectFeedbackDeviceFragment.mToolbarTitle = null;
            selectFeedbackDeviceFragment.mSelectFeedbackDeviceRV = null;
            selectFeedbackDeviceFragment.mFeedbackBtn = null;
            selectFeedbackDeviceFragment.mTipsBar = null;
            this.f8480c.setOnClickListener(null);
            this.f8480c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
