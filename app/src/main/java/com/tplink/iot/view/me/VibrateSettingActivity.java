package com.tplink.iot.view.me;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.base.BaseActivity;
import java.util.HashMap;
import kotlin.jvm.internal.j;

/* compiled from: VibrateSettingActivity.kt */
/* loaded from: classes2.dex */
public final class VibrateSettingActivity extends BaseActivity {
    private HashMap y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VibrateSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public static final a a = new a();

        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton buttonView, boolean z) {
            j.d(buttonView, "buttonView");
            if (buttonView.isPressed()) {
                u0.c(z);
            }
        }
    }

    private final void f1() {
        b1(R.string.drawer_vibrate_feedback);
        int i = com.tplink.iot.a.vibrate_switch;
        SwitchCompat vibrate_switch = (SwitchCompat) e1(i);
        j.d(vibrate_switch, "vibrate_switch");
        vibrate_switch.setChecked(u0.b());
        ((SwitchCompat) e1(i)).setOnCheckedChangeListener(a.a);
    }

    public View e1(int i) {
        if (this.y == null) {
            this.y = new HashMap();
        }
        View view = (View) this.y.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.y.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_vibrate_setting);
        f1();
    }
}
