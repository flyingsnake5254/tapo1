package com.tplink.iot.devicecommon.view;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.base.BaseActivity;
import kotlin.jvm.internal.j;

/* compiled from: IoTMVVMBaseActivity.kt */
/* loaded from: classes2.dex */
public abstract class IoTMVVMBaseActivity<VDB extends ViewDataBinding> extends BaseActivity {
    protected VDB y;
    private String z = "";

    private final void i1() {
        VDB vdb = (VDB) DataBindingUtil.setContentView(this, e1());
        j.d(vdb, "DataBindingUtil.setConte…View(this, getLayoutId())");
        this.y = vdb;
        if (vdb == null) {
            j.t("mBinding");
        }
        vdb.setLifecycleOwner(this);
        l1();
    }

    @LayoutRes
    public abstract int e1();

    /* JADX INFO: Access modifiers changed from: protected */
    public final VDB f1() {
        VDB vdb = this.y;
        if (vdb == null) {
            j.t("mBinding");
        }
        return vdb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String g1() {
        return this.z;
    }

    @CallSuper
    public void h1() {
        String str;
        Intent intent = getIntent();
        if (intent == null || (str = intent.getStringExtra("device_id_md5")) == null) {
            str = "";
        }
        this.z = str;
    }

    public abstract void j1();

    public void k1() {
    }

    public void l1() {
    }

    public void m1() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        h1();
        i1();
        j1();
        m1();
        k1();
    }
}
