package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.e;
import com.tplink.iot.view.login.RetrieveAccountByEmailActivity;
import com.tplink.iot.view.wss.WssAmazonInstrWebActivity;
import net.lucode.hackware.magicindicator.g.b;

/* compiled from: AccountDialogUtils.java */
/* loaded from: classes2.dex */
public class e {

    /* compiled from: AccountDialogUtils.java */
    /* loaded from: classes2.dex */
    static class a implements TPMaterialDialogV2.c {
        final /* synthetic */ String a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f5299b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Activity f5300c;

        a(String str, String str2, Activity activity) {
            this.a = str;
            this.f5299b = str2;
            this.f5300c = activity;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void b(Activity activity, TPMaterialDialogV2 tPMaterialDialogV2) {
            WssAmazonInstrWebActivity.j1(activity, "https://www.tp-link.com/support/contact-technical-support/");
            if (tPMaterialDialogV2 != null && tPMaterialDialogV2.isShowing()) {
                tPMaterialDialogV2.dismiss();
            }
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.c
        public void a(final TPMaterialDialogV2 tPMaterialDialogV2, View view) {
            String str = this.a;
            String str2 = this.f5299b;
            int color = ContextCompat.getColor(this.f5300c, R.color.common_iot_purple);
            final Activity activity = this.f5300c;
            d0.c((TextView) view.findViewById(R.id.dialog_message_tv), str, str2, color, new d0.g() { // from class: com.tplink.iot.Utils.a
                @Override // com.tplink.iot.Utils.d0.g
                public final void a() {
                    e.a.b(activity, tPMaterialDialogV2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(Activity activity, String str, View view) {
        Intent intent = new Intent(activity, RetrieveAccountByEmailActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ResetAccountMail", str);
        }
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(AlertDialog alertDialog, View view) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public static void d(final Activity activity, int i, final String str) {
        if (activity != null) {
            new TPLongMaterialDialogV2.Builder(activity).g(activity.getString(R.string.account_login_error_lock_tips, new Object[]{Integer.valueOf(i)})).l(R.string.forget_password_question_mark, R.color.common_iot_main_blue, new TPLongMaterialDialogV2.d() { // from class: com.tplink.iot.Utils.d
                @Override // com.tplink.iot.Utils.TPLongMaterialDialogV2.d
                public final void onClick(View view) {
                    e.a(activity, str, view);
                }
            }).i(R.string.common_ok, R.color.common_iot_main_blue, null).d(0, 8).setCancelable(false).c(false).create().show();
        }
    }

    public static void e(Activity activity, int i, int i2, int i3) {
        if (activity != null) {
            new TPMaterialDialogV3.Builder(activity).p(activity.getString(R.string.account_login_error_remaining_count, new Object[]{Integer.valueOf(i)})).f(activity.getString(R.string.account_login_error_remaining_lock_tips, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)})).c(false).setCancelable(false).j(R.string.common_ok, R.color.common_iot_main_blue, null).create().show();
        }
    }

    public static void f(Activity activity) {
        if (activity != null) {
            String string = activity.getString(R.string.account_tech_support);
            new TPMaterialDialogV2.Builder(activity).setView(R.layout.layout_dialog_custom_message).x(new a(activity.getString(R.string.account_send_email_reach_limit, new Object[]{string}), string, activity)).g(8, 8).c(false).setCancelable(false).o(R.string.common_ok, R.color.common_iot_main_blue, null).create().show();
        }
    }

    public static void g(Activity activity) {
        if (activity != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity, R.style.TPDialog);
            View inflate = activity.getLayoutInflater().inflate(R.layout.dialog_two_step_verification_layout, (ViewGroup) null);
            final AlertDialog create = builder.setView(inflate).setCancelable(false).create();
            inflate.findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.Utils.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.b(AlertDialog.this, view);
                }
            });
            inflate.findViewById(R.id.btn_got_it).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.Utils.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.c(AlertDialog.this, view);
                }
            });
            Window window = create.getWindow();
            if (window != null) {
                window.setGravity(80);
                window.getDecorView().setPadding(0, b.a(activity, 50.0d), 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = -1;
                attributes.horizontalMargin = 0.0f;
                window.setAttributes(attributes);
                window.setWindowAnimations(R.style.AnimationBottomStyle);
            }
            create.show();
        }
    }
}
