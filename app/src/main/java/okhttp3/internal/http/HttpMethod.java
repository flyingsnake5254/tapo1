package okhttp3.internal.http;

import com.tplink.libtpmediastatistics.SSLClient;

/* loaded from: classes4.dex */
public final class HttpMethod {
    private HttpMethod() {
    }

    public static boolean invalidatesCache(String str) {
        return str.equals(SSLClient.HTTP_POST) || str.equals("PATCH") || str.equals(SSLClient.HTTP_PUT) || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean permitsRequestBody(String str) {
        return !str.equals(SSLClient.HTTP_GET) && !str.equals("HEAD");
    }

    public static boolean redirectsToGet(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean redirectsWithBody(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean requiresRequestBody(String str) {
        return str.equals(SSLClient.HTTP_POST) || str.equals(SSLClient.HTTP_PUT) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
