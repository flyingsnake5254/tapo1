package com.tplink.iot.view.login;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class CloudRegionChooseActivity_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private CloudRegionChooseActivity f9474b;

    @UiThread
    public CloudRegionChooseActivity_ViewBinding(CloudRegionChooseActivity cloudRegionChooseActivity, View view) {
        this.f9474b = cloudRegionChooseActivity;
        cloudRegionChooseActivity.mToolbar = (Toolbar) c.d(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        CloudRegionChooseActivity cloudRegionChooseActivity = this.f9474b;
        if (cloudRegionChooseActivity != null) {
            this.f9474b = null;
            cloudRegionChooseActivity.mToolbar = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
