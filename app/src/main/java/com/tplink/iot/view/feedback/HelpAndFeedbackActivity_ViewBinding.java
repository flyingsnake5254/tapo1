package com.tplink.iot.view.feedback;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.R;
import com.tplink.iot.widget.viewgroup.AutoScrolledWebView;

/* loaded from: classes2.dex */
public class HelpAndFeedbackActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private HelpAndFeedbackActivity f8474b;

    /* renamed from: c  reason: collision with root package name */
    private View f8475c;

    /* renamed from: d  reason: collision with root package name */
    private View f8476d;

    /* loaded from: classes2.dex */
    class a extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ HelpAndFeedbackActivity f8477f;

        a(HelpAndFeedbackActivity helpAndFeedbackActivity) {
            this.f8477f = helpAndFeedbackActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8477f.refreshLayout();
        }
    }

    /* loaded from: classes2.dex */
    class b extends butterknife.internal.b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ HelpAndFeedbackActivity f8478f;

        b(HelpAndFeedbackActivity helpAndFeedbackActivity) {
            this.f8478f = helpAndFeedbackActivity;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8478f.gotoSelectFeedbackDeviceActivity();
        }
    }

    @UiThread
    public HelpAndFeedbackActivity_ViewBinding(HelpAndFeedbackActivity helpAndFeedbackActivity, View view) {
        this.f8474b = helpAndFeedbackActivity;
        helpAndFeedbackActivity.mLoadingProgress = (ProgressBar) c.d(view, R.id.feedback_progressbar, "field 'mLoadingProgress'", ProgressBar.class);
        View c2 = c.c(view, R.id.feed_back_reflash_layout, "field 'mRefreshLayout' and method 'refreshLayout'");
        helpAndFeedbackActivity.mRefreshLayout = c2;
        this.f8475c = c2;
        c2.setOnClickListener(new a(helpAndFeedbackActivity));
        helpAndFeedbackActivity.mFeedbackWebView = (AutoScrolledWebView) c.d(view, R.id.feed_back_webview, "field 'mFeedbackWebView'", AutoScrolledWebView.class);
        View c3 = c.c(view, R.id.btn_feedback, "field 'mFeedback' and method 'gotoSelectFeedbackDeviceActivity'");
        helpAndFeedbackActivity.mFeedback = (TextView) c.b(c3, R.id.btn_feedback, "field 'mFeedback'", TextView.class);
        this.f8476d = c3;
        c3.setOnClickListener(new b(helpAndFeedbackActivity));
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        HelpAndFeedbackActivity helpAndFeedbackActivity = this.f8474b;
        if (helpAndFeedbackActivity != null) {
            this.f8474b = null;
            helpAndFeedbackActivity.mLoadingProgress = null;
            helpAndFeedbackActivity.mRefreshLayout = null;
            helpAndFeedbackActivity.mFeedbackWebView = null;
            helpAndFeedbackActivity.mFeedback = null;
            this.f8475c.setOnClickListener(null);
            this.f8475c = null;
            this.f8476d.setOnClickListener(null);
            this.f8476d = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
