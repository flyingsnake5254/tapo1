package com.tplink.iot.view.iotcommon;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.iotcommon.IoTDeviceLocationViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.TPBaseDeviceViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.familymanager.RoomBean;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class IoTSettingLocationCustomActivity extends BaseActivity implements FlowTagLayout.c {
    private boolean H3 = false;
    private CharSequence p0;
    private MenuItem p1;
    private String p2;
    private IoTDeviceLocationViewModel p3;
    private DrawableEditText y;
    private FlowTagLayout z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<i<RoomBean>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable i<RoomBean> iVar) {
            s0.g();
            if (iVar != null) {
                int b2 = iVar.b();
                if (b2 == 0) {
                    if (iVar.a() != null) {
                        Intent intent = new Intent();
                        intent.putExtra("extra_new_custom_room_id", iVar.a().getRoomId());
                        IoTSettingLocationCustomActivity.this.setResult(-1, intent);
                    }
                    IoTSettingLocationCustomActivity.this.finish();
                } else if (b2 != 15009) {
                    s0.n(IoTSettingLocationCustomActivity.this, R.string.operation_failed_try_again);
                } else {
                    IoTSettingLocationCustomActivity.this.p1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements TextWatcher {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (editable.toString().getBytes().length > 64) {
                editable.delete(IoTSettingLocationCustomActivity.this.p0.length() - 1, IoTSettingLocationCustomActivity.this.p0.length());
                IoTSettingLocationCustomActivity.this.y.setText(editable);
                IoTSettingLocationCustomActivity.this.y.setSelection(editable.length());
            }
            if (IoTSettingLocationCustomActivity.this.p1 != null) {
                IoTSettingLocationCustomActivity.this.p1.setEnabled(!TextUtils.isEmpty(editable));
            }
            if (!IoTSettingLocationCustomActivity.this.H3) {
                IoTSettingLocationCustomActivity.this.z.d();
            } else {
                IoTSettingLocationCustomActivity.this.H3 = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            IoTSettingLocationCustomActivity.this.p0 = charSequence;
        }
    }

    private void m1() {
        Intent intent = getIntent();
        if (intent != null) {
            this.p2 = intent.getStringExtra(ThingModelDefine.Event.UPLOAD_PARAMS_DEVICE_ID);
        }
    }

    private ArrayList<String> n1() {
        EnumDeviceNicknameType[] values;
        ArrayList<String> arrayList = new ArrayList<>();
        for (EnumDeviceNicknameType enumDeviceNicknameType : EnumDeviceNicknameType.values()) {
            if (enumDeviceNicknameType != EnumDeviceNicknameType.CUSTOM) {
                arrayList.add(EnumDeviceNicknameType.fromType(enumDeviceNicknameType));
            }
        }
        return arrayList;
    }

    private void o1() {
        b1(R.string.setting_location);
        FlowTagLayout flowTagLayout = (FlowTagLayout) findViewById(R.id.flow_tag_layout);
        this.z = flowTagLayout;
        flowTagLayout.c(n1(), this);
        DrawableEditText drawableEditText = (DrawableEditText) findViewById(R.id.edit_custom_location);
        this.y = drawableEditText;
        drawableEditText.f(new b());
        this.y.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1() {
        new TPMaterialDialogV2.Builder(this).j(getString(R.string.room_num_out_of_range, new Object[]{32})).o(R.string.action_got_it, R.color.common_iot_main_blue, null).g(8, 8).setCancelable(false).c(false).create().show();
    }

    private void q1() {
        this.p3.l().observe(this, new a());
    }

    @Override // com.tplink.iot.widget.FlowTagLayout.c
    public void G(String str) {
        this.H3 = true;
        l.m(this.y, str);
        d.I(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (o.a() != 0) {
            setContentView(R.layout.activity_bulb_setting_location_custom);
            m1();
            this.p3 = (IoTDeviceLocationViewModel) ViewModelProviders.of(this, new TPBaseDeviceViewModelFactory(this, b.d.w.h.a.g(this.p2))).get(IoTDeviceLocationViewModel.class);
            o1();
            q1();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        MenuItem findItem = menu.findItem(R.id.common_save);
        this.p1 = findItem;
        findItem.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        d.I(this);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.common_save) {
            String trim = this.y.getText().toString().trim();
            if (!TextUtils.isEmpty(this.p3.o(trim))) {
                s0.p(this, getString(R.string.same_name_home_exist));
            } else {
                s0.l(this);
                this.p3.j(trim);
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
