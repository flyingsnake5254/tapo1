package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.tplink.libtpmediastatistics.SSLClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ClearKeyUtil.java */
/* loaded from: classes.dex */
final class r {
    public static byte[] a(byte[] bArr) {
        return o0.a >= 27 ? bArr : o0.e0(c(o0.B(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (o0.a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(o0.B(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(SSLClient.COMMA);
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(d(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(d(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return o0.e0(sb.toString());
        } catch (JSONException e2) {
            String valueOf = String.valueOf(o0.B(bArr));
            u.d("ClearKeyUtil", valueOf.length() != 0 ? "Failed to adjust response data: ".concat(valueOf) : new String("Failed to adjust response data: "), e2);
            return bArr;
        }
    }

    private static String c(String str) {
        return str.replace('+', '-').replace('/', '_');
    }

    private static String d(String str) {
        return str.replace('-', '+').replace('_', '/');
    }
}
