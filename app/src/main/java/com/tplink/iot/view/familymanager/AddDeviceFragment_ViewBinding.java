package com.tplink.iot.view.familymanager;

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
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

/* loaded from: classes2.dex */
public class AddDeviceFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private AddDeviceFragment f8433b;

    /* renamed from: c  reason: collision with root package name */
    private View f8434c;

    /* loaded from: classes2.dex */
    class a extends b {

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ AddDeviceFragment f8435f;

        a(AddDeviceFragment addDeviceFragment) {
            this.f8435f = addDeviceFragment;
        }

        @Override // butterknife.internal.b
        public void a(View view) {
            this.f8435f.addDevices();
        }
    }

    @UiThread
    public AddDeviceFragment_ViewBinding(AddDeviceFragment addDeviceFragment, View view) {
        this.f8433b = addDeviceFragment;
        addDeviceFragment.mToolbar = (Toolbar) c.d(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
        addDeviceFragment.mToolbarTitle = (TextView) c.d(view, R.id.toolbar_title, "field 'mToolbarTitle'", TextView.class);
        addDeviceFragment.mAddDeviceRecyclerView = (RecyclerView) c.d(view, R.id.recycle_add_device_list, "field 'mAddDeviceRecyclerView'", RecyclerView.class);
        View c2 = c.c(view, R.id.btn_add_device, "field 'mAddDeviceBtn' and method 'addDevices'");
        addDeviceFragment.mAddDeviceBtn = (TPRefreshableButton) c.b(c2, R.id.btn_add_device, "field 'mAddDeviceBtn'", TPRefreshableButton.class);
        this.f8434c = c2;
        c2.setOnClickListener(new a(addDeviceFragment));
        addDeviceFragment.mNoDeviceAddedTv = (TextView) c.d(view, R.id.tv_no_device_added, "field 'mNoDeviceAddedTv'", TextView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        AddDeviceFragment addDeviceFragment = this.f8433b;
        if (addDeviceFragment != null) {
            this.f8433b = null;
            addDeviceFragment.mToolbar = null;
            addDeviceFragment.mToolbarTitle = null;
            addDeviceFragment.mAddDeviceRecyclerView = null;
            addDeviceFragment.mAddDeviceBtn = null;
            addDeviceFragment.mNoDeviceAddedTv = null;
            this.f8434c.setOnClickListener(null);
            this.f8434c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
