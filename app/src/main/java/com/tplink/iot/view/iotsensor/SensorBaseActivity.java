package com.tplink.iot.view.iotsensor;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: SensorBaseActivity.kt */
/* loaded from: classes2.dex */
public abstract class SensorBaseActivity<T extends ViewModel> extends BaseActivity {
    private String y = "";
    private final f z;

    /* compiled from: SensorBaseActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Class f8691d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Class cls) {
            super(0);
            this.f8691d = cls;
        }

        /* renamed from: a */
        public final T invoke() {
            SensorBaseActivity sensorBaseActivity = SensorBaseActivity.this;
            T t = (T) new ViewModelProvider(sensorBaseActivity, new IoTViewModelFactory(sensorBaseActivity, sensorBaseActivity.e1())).get(this.f8691d);
            j.d(t, "ViewModelProvider(this, …mDeviceIdMD5)).get(vmClz)");
            return t;
        }
    }

    public SensorBaseActivity(Class<T> vmClz) {
        f b2;
        j.e(vmClz, "vmClz");
        b2 = i.b(new a(vmClz));
        this.z = b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String e1() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T f1() {
        return (T) ((ViewModel) this.z.getValue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @CallSuper
    public void g1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.y = str;
    }

    public abstract void h1();

    public void i1() {
    }

    public abstract void j1();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g1();
        h1();
        j1();
        i1();
    }
}
