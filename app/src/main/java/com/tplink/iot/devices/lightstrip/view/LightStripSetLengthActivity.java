package com.tplink.iot.devices.lightstrip.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.textfield.TextInputEditText;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ActivityLightStripSetLengthBinding;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import io.reactivex.g0.g;
import java.util.Arrays;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

/* compiled from: LightStripSetLengthActivity.kt */
/* loaded from: classes2.dex */
public final class LightStripSetLengthActivity extends IoTMVVMBaseActivity<ActivityLightStripSetLengthBinding> {
    private final kotlin.f p0;
    private boolean p1;
    private int p2;
    private MenuItem p3;

    /* compiled from: TextView.kt */
    /* loaded from: classes2.dex */
    public static final class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            LightStripSetLengthActivity.this.u1();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* compiled from: LightStripSetLengthActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements kotlin.jvm.b.a<LightStripSettingsViewModel> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final LightStripSettingsViewModel invoke() {
            LightStripSetLengthActivity lightStripSetLengthActivity = LightStripSetLengthActivity.this;
            ViewModel viewModel = new ViewModelProvider(lightStripSetLengthActivity, new IoTViewModelFactory(lightStripSetLengthActivity, lightStripSetLengthActivity.g1())).get(LightStripSettingsViewModel.class);
            j.d(viewModel, "ViewModelProvider(this, …).get<VM>(VM::class.java)");
            return (LightStripSettingsViewModel) ((AndroidViewModel) viewModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripSetLengthActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements g<io.reactivex.e0.c> {
        c() {
        }

        /* renamed from: a */
        public final void accept(io.reactivex.e0.c cVar) {
            com.tplink.iot.Utils.extension.e.m(LightStripSetLengthActivity.this, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripSetLengthActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements io.reactivex.g0.a {
        d() {
        }

        @Override // io.reactivex.g0.a
        public final void run() {
            com.tplink.iot.Utils.extension.e.a();
            LightStripSetLengthActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LightStripSetLengthActivity.kt */
    /* loaded from: classes2.dex */
    public static final class e<T> implements g<Throwable> {
        e() {
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            com.tplink.iot.Utils.extension.e.e(LightStripSetLengthActivity.this, null, 1, null);
        }
    }

    /* compiled from: LightStripSetLengthActivity.kt */
    /* loaded from: classes2.dex */
    static final class f<T> implements Observer<Integer> {
        f() {
        }

        /* renamed from: a */
        public final void onChanged(Integer num) {
            if (num != null && !LightStripSetLengthActivity.this.p1) {
                LightStripSetLengthActivity.this.p2 = num.intValue();
                LightStripSetLengthActivity.this.A1(num.intValue());
                LightStripSetLengthActivity.this.p1 = true;
            }
        }
    }

    public LightStripSetLengthActivity() {
        kotlin.f b2;
        b2 = i.b(new b());
        this.p0 = b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1(int i) {
        f1().f6596c.setText(v1(t1(i)));
    }

    private final float t1(int i) {
        return i * 0.1f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u1() {
        Float w1 = w1();
        boolean z = false;
        if (w1 == null) {
            MenuItem menuItem = this.p3;
            if (menuItem != null) {
                menuItem.setEnabled(false);
                return;
            }
            return;
        }
        int y1 = y1(w1.floatValue());
        MenuItem menuItem2 = this.p3;
        if (menuItem2 != null) {
            if (!(y1 == this.p2 || y1 == 0)) {
                z = true;
            }
            menuItem2.setEnabled(z);
        }
    }

    private final String v1(float f2) {
        String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
        j.d(format, "java.lang.String.format(this, *args)");
        return format;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0019, code lost:
        r0 = kotlin.text.v.v(r1, io.netty.util.internal.StringUtil.COMMA, '.', false, 4, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Float w1() {
        /*
            r7 = this;
            androidx.databinding.ViewDataBinding r0 = r7.f1()
            com.tplink.iot.databinding.ActivityLightStripSetLengthBinding r0 = (com.tplink.iot.databinding.ActivityLightStripSetLengthBinding) r0
            com.google.android.material.textfield.TextInputEditText r0 = r0.f6596c
            java.lang.String r1 = "mBinding.etStripLength"
            kotlin.jvm.internal.j.d(r0, r1)
            android.text.Editable r0 = r0.getText()
            if (r0 == 0) goto L_0x002b
            java.lang.String r1 = r0.toString()
            if (r1 == 0) goto L_0x002b
            r2 = 44
            r3 = 46
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r0 = kotlin.text.m.v(r1, r2, r3, r4, r5, r6)
            if (r0 == 0) goto L_0x002b
            java.lang.Float r0 = kotlin.text.m.j(r0)
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.devices.lightstrip.view.LightStripSetLengthActivity.w1():java.lang.Float");
    }

    private final LightStripSettingsViewModel x1() {
        return (LightStripSettingsViewModel) this.p0.getValue();
    }

    private final int y1(float f2) {
        int b2;
        b2 = kotlin.s.c.b(f2 / 0.1f);
        return b2;
    }

    private final void z1() {
        Float w1 = w1();
        if (w1 == null) {
            com.tplink.iot.Utils.extension.e.e(this, null, 1, null);
            return;
        }
        int y1 = y1(w1.floatValue());
        if (y1 > 50) {
            String string = getString(R.string.light_strip_max_length_hint, new Object[]{Float.valueOf(t1(50))});
            j.d(string, "getString(R.string.light…pUtils.MAXIMUM_SEGMENTS))");
            com.tplink.iot.Utils.extension.e.o(this, string, null, 2, null);
        } else if (y1 <= 0) {
            com.tplink.iot.Utils.extension.e.q(this, null, 1, null);
        } else {
            x1().J(y1).r(io.reactivex.d0.b.a.a()).l(new c()).i(new d()).j(new e()).y();
        }
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    @LayoutRes
    public int e1() {
        return R.layout.activity_light_strip_set_length;
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void j1() {
        b1(R.string.light_strip_length);
        TextView tvStripLengthHint = f1().f6598f;
        j.d(tvStripLengthHint, "tvStripLengthHint");
        tvStripLengthHint.setText(getString(R.string.light_strip_length_hint_V2, new Object[]{Float.valueOf(t1(50))}));
        A1(50);
        TextInputEditText textInputEditText = f1().f6596c;
        textInputEditText.setPadding(0, textInputEditText.getPaddingTop(), 0, textInputEditText.getPaddingBottom());
        textInputEditText.setFilters(new com.tplink.iot.g.b.c.a[]{new com.tplink.iot.g.b.c.a(2, 1)});
        textInputEditText.addTextChangedListener(new a());
    }

    @Override // com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity
    public void m1() {
        x1().C().observe(this, new f());
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_save, menu);
        this.p3 = menu != null ? menu.findItem(R.id.common_save) : null;
        u1();
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() != R.id.common_save) {
            return super.onOptionsItemSelected(item);
        }
        z1();
        return true;
    }
}
