package com.tplink.iot.view.cloudvideo;

import android.webkit.JavascriptInterface;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.about.AbsCommonWebActivity;
import com.tplink.iot.view.cloudvideo.TapoCareWebActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TapoCareWebActivity extends AbsCommonWebActivity {

    /* loaded from: classes2.dex */
    public class a {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void b() {
            TapoCareWebActivity.this.finish();
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("message");
                    if (string != null && "done".equals(string)) {
                        ((BaseActivity) TapoCareWebActivity.this).f6070c.postDelayed(new Runnable() { // from class: com.tplink.iot.view.cloudvideo.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                TapoCareWebActivity.a.this.b();
                            }
                        }, 500L);
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.tplink.iot.view.about.AbsCommonWebActivity
    public Object n1() {
        return new a();
    }

    @Override // com.tplink.iot.view.about.AbsCommonWebActivity
    public String o1() {
        return "backToApp";
    }
}
