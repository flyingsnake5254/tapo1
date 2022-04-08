package com.tplink.iot.view.feedback;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.c;
import com.tplink.iot.R;

/* loaded from: classes2.dex */
public class DeviceTypeListFragment_ViewBinding implements Unbinder {

    /* renamed from: b  reason: collision with root package name */
    private DeviceTypeListFragment f8466b;

    @UiThread
    public DeviceTypeListFragment_ViewBinding(DeviceTypeListFragment deviceTypeListFragment, View view) {
        this.f8466b = deviceTypeListFragment;
        deviceTypeListFragment.mToolbar = (Toolbar) c.d(view, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
        deviceTypeListFragment.mToolbarTitle = (TextView) c.d(view, R.id.toolbar_title, "field 'mToolbarTitle'", TextView.class);
        deviceTypeListFragment.mDeviceTypeListRecyclerView = (RecyclerView) c.d(view, R.id.recycle_device_type_list, "field 'mDeviceTypeListRecyclerView'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    @CallSuper
    public void a() {
        DeviceTypeListFragment deviceTypeListFragment = this.f8466b;
        if (deviceTypeListFragment != null) {
            this.f8466b = null;
            deviceTypeListFragment.mToolbar = null;
            deviceTypeListFragment.mToolbarTitle = null;
            deviceTypeListFragment.mDeviceTypeListRecyclerView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
