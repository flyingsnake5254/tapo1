package com.tplink.iot.view.ipcamera.preview;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.libtpnetwork.Utils.o;

/* loaded from: classes2.dex */
public class CameraPreferenceActivity extends BaseActivity {
    private void e1() {
        int i = 0;
        boolean c2 = o.h0().c("LIVE_ICON_VISIBLE", false);
        final View findViewById = findViewById(R.id.camera_live_tag);
        if (!c2) {
            i = 8;
        }
        findViewById.setVisibility(i);
        CheckBox checkBox = (CheckBox) findViewById(R.id.camera_live_tag_switch);
        checkBox.setChecked(c2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tplink.iot.view.ipcamera.preview.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraPreferenceActivity.g1(findViewById, compoundButton, z);
            }
        });
    }

    private void f1() {
        int i = 0;
        boolean c2 = o.h0().c("SPEED_ICON_VISIBLE", false);
        final View findViewById = findViewById(R.id.camera_speed_tag);
        if (!c2) {
            i = 8;
        }
        findViewById.setVisibility(i);
        CheckBox checkBox = (CheckBox) findViewById(R.id.camera_speed_tag_switch);
        checkBox.setChecked(c2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tplink.iot.view.ipcamera.preview.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                CameraPreferenceActivity.h1(findViewById, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g1(View view, CompoundButton compoundButton, boolean z) {
        o.h0().h("LIVE_ICON_VISIBLE", z);
        view.setVisibility(z ? 0 : 8);
        q.g(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void h1(View view, CompoundButton compoundButton, boolean z) {
        o.h0().h("SPEED_ICON_VISIBLE", z);
        view.setVisibility(z ? 0 : 8);
        q.h(z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_camera_preference);
        setTitle(R.string.drawer_camera_preference);
        e1();
        f1();
    }
}
