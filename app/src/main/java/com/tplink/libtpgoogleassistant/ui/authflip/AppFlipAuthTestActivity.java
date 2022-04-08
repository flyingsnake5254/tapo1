package com.tplink.libtpgoogleassistant.ui.authflip;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import b.d.k.b;

/* loaded from: classes3.dex */
public class AppFlipAuthTestActivity extends AppCompatActivity {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements b.d.k.e.a {
        a() {
        }

        @Override // b.d.k.e.a
        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent();
                intent.putExtra("AUTHORIZATION_CODE", str);
                AppFlipAuthTestActivity.this.setResult(-1, intent);
            } else {
                Intent intent2 = new Intent();
                intent2.putExtra("ERROR_TYPE", 1);
                intent2.putExtra("ERROR_CODE", 1);
                intent2.putExtra("ERROR_DESCRIPTION", "Invalid Request");
                AppFlipAuthTestActivity.this.setResult(-2, intent2);
            }
            AppFlipAuthTestActivity.this.finish();
        }
    }

    private void P0(b.d.k.e.a aVar) {
        aVar.a("authCodeXXXXXX");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q0 */
    public /* synthetic */ void R0(View view) {
        P0(new a());
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(b.activity_app_flip_auth_test);
        if (!b.d.k.f.a.c(getApplicationContext(), getCallingActivity(), getIntent())) {
            finish();
        } else {
            findViewById(b.d.k.a.btn).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.libtpgoogleassistant.ui.authflip.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AppFlipAuthTestActivity.this.R0(view);
                }
            });
        }
    }
}
