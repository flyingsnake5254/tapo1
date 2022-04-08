package com.tplink.iot.view.notification;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.notification.TriggeredDeviceTypeListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.notification.MessagePushViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceTriggeredAllActivity extends BaseActivity implements TriggeredDeviceTypeListAdapter.c {
    private RecyclerView p0;
    private TriggeredDeviceTypeListAdapter p1;
    private MessagePushViewModel y;
    private TextView z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<BaseALIoTDevice>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<BaseALIoTDevice> list) {
            if (list == null || list.size() == 0) {
                DeviceTriggeredAllActivity.this.p0.setVisibility(8);
                DeviceTriggeredAllActivity.this.z.setVisibility(0);
                return;
            }
            DeviceTriggeredAllActivity.this.z.setVisibility(8);
            DeviceTriggeredAllActivity.this.p0.setVisibility(0);
            DeviceTriggeredAllActivity.this.p1.s(list);
        }
    }

    private void h1() {
        b1(R.string.notification_device_status);
        this.z = (TextView) findViewById(R.id.tv_no_device);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.p0 = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TriggeredDeviceTypeListAdapter triggeredDeviceTypeListAdapter = new TriggeredDeviceTypeListAdapter(this);
        this.p1 = triggeredDeviceTypeListAdapter;
        this.p0.setAdapter(triggeredDeviceTypeListAdapter);
        this.p1.t(this);
    }

    private void i1() {
        this.y.g().observe(this, new a());
    }

    @Override // com.tplink.iot.adapter.notification.TriggeredDeviceTypeListAdapter.c
    public void C0(int i, String str) {
        Intent intent = new Intent(this, TriggeredDeviceTypeActivity.class);
        intent.putExtra("device_type", i);
        intent.putExtra("device_type_name", str);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_device_triggered_all);
        this.y = (MessagePushViewModel) ViewModelProviders.of(this).get(MessagePushViewModel.class);
        h1();
        i1();
    }
}
