package com.tplink.iot.view.about;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import com.andexert.library.RippleView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.core.AppContext;
import com.tplink.iot.view.about.AboutFragment;
import com.tplink.libtpnetwork.Utils.a0;
import com.tplink.libtpnetwork.Utils.o;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AboutFragment extends BaseFragment implements RippleView.b {
    private View q = null;
    private ScrollView x = null;
    private TextView y = null;
    private BaseActivity z = null;
    private int p0 = 0;

    /* loaded from: classes2.dex */
    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            AboutFragment.this.X0();
            AboutFragment.this.q.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AboutFragment.this.B0();
        }
    }

    /* loaded from: classes2.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AboutFragment.K0(AboutFragment.this);
            int unused = AboutFragment.this.p0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float d2 = b.d.w.f.a.d(AboutFragment.this.z) * ((Float) valueAnimator.getAnimatedValue()).floatValue();
            AboutFragment.this.x.setTranslationX(d2);
            AboutFragment.this.y.setTranslationX(d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b(String str) {
            FragmentActivity activity = AboutFragment.this.getActivity();
            s0.C(activity, "Tapo Log has been save in this folder: " + str, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ void d() {
            s0.q(AboutFragment.this.getActivity(), AboutFragment.this.getString(R.string.common_operation_failed), null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: e */
        public /* synthetic */ void f() {
            s0.q(AboutFragment.this.getActivity(), AboutFragment.this.getString(R.string.common_operation_failed), null);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final String W0 = AboutFragment.this.W0(b.d.w.c.c.e.d(AboutFragment.this.getContext()).c().get(), "TPLINK", "Tapo");
                if (!TextUtils.isEmpty(W0)) {
                    AboutFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.about.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            AboutFragment.e.this.b(W0);
                        }
                    });
                } else {
                    AboutFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.about.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            AboutFragment.e.this.d();
                        }
                    });
                }
            } catch (Throwable unused) {
                AboutFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.about.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AboutFragment.e.this.f();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f implements TPMaterialDialogV2.d {
        f() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            AboutFragment.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + AboutFragment.this.getContext().getPackageName())), 126);
        }
    }

    static /* synthetic */ int K0(AboutFragment aboutFragment) {
        int i = aboutFragment.p0;
        aboutFragment.p0 = i + 1;
        return i;
    }

    private void Q0() {
        this.q.startAnimation(R0());
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new d());
        ofFloat.setDuration(350L);
        ofFloat.start();
    }

    private Animation R0() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setFillAfter(true);
        return alphaAnimation;
    }

    @Nullable
    private File S0(String str, String str2) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return new File(file, String.format("%s_%s.txt", str2, new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS", Locale.US).format(new Date(System.currentTimeMillis()))));
        }
        return null;
    }

    private void T0() {
        s0.l(getActivity());
        new Thread(new e()).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public /* synthetic */ void V0(View view) {
        C0(TapoDebugActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String W0(String str, String str2, String str3) throws FileNotFoundException {
        File file;
        if (Build.VERSION.SDK_INT >= 29) {
            file = AppContext.f6185c.getExternalFilesDir("");
        } else {
            file = Environment.getExternalStorageDirectory();
        }
        if (file != null) {
            String str4 = file.getAbsolutePath() + File.separatorChar + str2.toUpperCase() + File.separatorChar + str3.toUpperCase();
            File S0 = S0(str4, str3);
            if (S0 != null) {
                new PrintStream(new FileOutputStream(S0)).println(str);
                return str4;
            }
            throw new FileNotFoundException("Folder " + str4 + " doesn't exit.");
        }
        throw new FileNotFoundException("dest path doesn't exit.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.q, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    private void Y0() {
        new TPMaterialDialogV2.Builder(getContext()).setTitle(R.string.login_deny_storage_permission_title).setMessage(R.string.login_deny_storage_permission_message).p(R.string.action_settings, new f()).l(R.string.common_cancel, R.color.common_iot_light_black, null).show();
    }

    @Override // com.tplink.iot.base.BaseFragment
    public boolean G0(Intent intent) {
        if (intent != null) {
            if (intent.getIntExtra("auto_reconnect_result", 0) != 0) {
                B0();
            } else if (intent.getBooleanExtra("gateway_non_qualified", false)) {
                B0();
            }
        }
        return super.G0(intent);
    }

    @Override // com.andexert.library.RippleView.b
    public void j0(RippleView rippleView) {
        switch (rippleView.getId()) {
            case R.id.licenses /* 2131363225 */:
                C0(LicensesActivity.class);
                getActivity().overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
                return;
            case R.id.privacy_policy /* 2131363705 */:
                Intent intent = new Intent(getActivity(), AboutWebActivity.class);
                intent.putExtra("toolbar_title", getString(R.string.about_item_title_privacy));
                intent.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#privacy-policy");
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
                return;
            case R.id.privacy_setting /* 2131363706 */:
                C0(PrivacySettingActivity.class);
                getActivity().overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
                return;
            case R.id.terms_of_service /* 2131364171 */:
                Intent intent2 = new Intent(getActivity(), AboutWebActivity.class);
                intent2.putExtra("toolbar_title", getString(R.string.about_item_title_terms));
                intent2.putExtra("url", "https://www.tapo.com/app/privacy/?utm_source=tapo&utm_medium=app#terms-of-use");
                startActivity(intent2);
                getActivity().overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
                return;
            default:
                return;
        }
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        this.z = (BaseActivity) getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menu.clear();
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_about, viewGroup, false);
        this.q = inflate;
        this.x = (ScrollView) inflate.findViewById(R.id.about_content);
        this.y = (TextView) this.q.findViewById(R.id.about_copyright);
        ((TextView) this.q.findViewById(R.id.app_version)).setText(String.format(getString(R.string.about_app_version), t0.d(getContext())));
        ((RippleView) this.q.findViewById(R.id.terms_of_service)).setOnRippleCompleteListener(this);
        ((RippleView) this.q.findViewById(R.id.privacy_policy)).setOnRippleCompleteListener(this);
        ((RippleView) this.q.findViewById(R.id.licenses)).setOnRippleCompleteListener(this);
        ((RippleView) this.q.findViewById(R.id.privacy_setting)).setOnRippleCompleteListener(this);
        this.q.getViewTreeObserver().addOnPreDrawListener(new a());
        Toolbar toolbar = (Toolbar) this.q.findViewById(R.id.toolbar);
        ((BaseActivity) getActivity()).setSupportActionBar(toolbar);
        ((TextView) this.q.findViewById(R.id.toolbar_title)).setText(R.string.common_about);
        toolbar.setNavigationOnClickListener(new b());
        this.q.findViewById(R.id.conceal_log).setOnClickListener(new c());
        this.y.setText(getString(R.string.about_copyright, "2022"));
        if (a0.j()) {
            this.q.findViewById(R.id.cv_debug_page).setVisibility(0);
            ((TextView) this.q.findViewById(R.id.tv_debug_page)).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.about.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AboutFragment.this.V0(view);
                }
            });
        }
        return this.q;
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        Q0();
        super.onDestroyView();
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        B0();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StatusBarUtils.a(getActivity());
    }

    @Override // androidx.fragment.app.Fragment, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z;
        if (i != 125) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            return;
        }
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = true;
                break;
            } else if (iArr[i2] != 0) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            T0();
        } else {
            Y0();
        }
        o.h0().h("is_first", false);
    }

    @Override // com.tplink.iot.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        StatusBarUtils.o(getActivity(), this.q, getResources().getColor(R.color.common_colorPrimaryDark));
    }
}
