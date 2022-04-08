package com.tplink.iot.view.about;

import android.app.Activity;
import android.content.Intent;
import android.webkit.JavascriptInterface;
import androidx.core.view.PointerIconCompat;
import com.tplink.iot.R;
import com.tplink.iot.model.about.d;

/* loaded from: classes2.dex */
public class CommonWebActivity extends AbsCommonWebActivity {

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: com.tplink.iot.view.about.CommonWebActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0216a implements Runnable {
            RunnableC0216a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CommonWebActivity.this.finish();
            }
        }

        public a() {
        }

        @JavascriptInterface
        public void backToApp() {
            CommonWebActivity.this.finish();
        }

        @JavascriptInterface
        public String getAppParameters() {
            return d.d(CommonWebActivity.this);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        @android.webkit.JavascriptInterface
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void postMessage(java.lang.String r5) {
            /*
                r4 = this;
                if (r5 == 0) goto L_0x004b
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: JSONException -> 0x0047
                r0.<init>(r5)     // Catch: JSONException -> 0x0047
                java.lang.String r5 = "message"
                java.lang.String r5 = r0.getString(r5)     // Catch: JSONException -> 0x0047
                if (r5 == 0) goto L_0x004b
                r0 = -1
                int r1 = r5.hashCode()     // Catch: JSONException -> 0x0047
                r2 = -1357520532(0xffffffffaf15e16c, float:-1.3631557E-10)
                r3 = 1
                if (r1 == r2) goto L_0x002a
                r2 = 348678395(0x14c868fb, float:2.0236247E-26)
                if (r1 == r2) goto L_0x0020
                goto L_0x0033
            L_0x0020:
                java.lang.String r1 = "submitted"
                boolean r5 = r5.equals(r1)     // Catch: JSONException -> 0x0047
                if (r5 == 0) goto L_0x0033
                r0 = 0
                goto L_0x0033
            L_0x002a:
                java.lang.String r1 = "closed"
                boolean r5 = r5.equals(r1)     // Catch: JSONException -> 0x0047
                if (r5 == 0) goto L_0x0033
                r0 = 1
            L_0x0033:
                if (r0 == r3) goto L_0x0036
                goto L_0x004b
            L_0x0036:
                com.tplink.iot.view.about.CommonWebActivity r5 = com.tplink.iot.view.about.CommonWebActivity.this     // Catch: JSONException -> 0x0047
                com.tplink.iot.base.b r5 = com.tplink.iot.view.about.CommonWebActivity.r1(r5)     // Catch: JSONException -> 0x0047
                com.tplink.iot.view.about.CommonWebActivity$a$a r0 = new com.tplink.iot.view.about.CommonWebActivity$a$a     // Catch: JSONException -> 0x0047
                r0.<init>()     // Catch: JSONException -> 0x0047
                r1 = 500(0x1f4, double:2.47E-321)
                r5.postDelayed(r0, r1)     // Catch: JSONException -> 0x0047
                goto L_0x004b
            L_0x0047:
                r5 = move-exception
                r5.printStackTrace()
            L_0x004b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.view.about.CommonWebActivity.a.postMessage(java.lang.String):void");
        }
    }

    public static void s1(Activity activity, String str, String str2) {
        b.d.w.f.a.g(activity);
        Intent intent = new Intent(activity, CommonWebActivity.class);
        intent.putExtra("toolbar_title", str);
        intent.putExtra("url", str2);
        activity.startActivityForResult(intent, PointerIconCompat.TYPE_COPY);
        activity.overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
    }

    @Override // com.tplink.iot.view.about.AbsCommonWebActivity
    public Object n1() {
        return new a();
    }

    @Override // com.tplink.iot.view.about.AbsCommonWebActivity
    public String o1() {
        return "uploadDeviceInfo";
    }
}
