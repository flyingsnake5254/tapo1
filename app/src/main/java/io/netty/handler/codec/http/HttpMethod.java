package io.netty.handler.codec.http;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.util.AsciiString;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
public class HttpMethod implements Comparable<HttpMethod> {
    public static final HttpMethod CONNECT;
    public static final HttpMethod DELETE;
    public static final HttpMethod GET;
    public static final HttpMethod HEAD;
    public static final HttpMethod OPTIONS;
    public static final HttpMethod PATCH;
    public static final HttpMethod POST;
    public static final HttpMethod PUT;
    public static final HttpMethod TRACE;
    private static final EnumNameMap<HttpMethod> methodMap;
    private final AsciiString name;

    /* loaded from: classes3.dex */
    private static final class EnumNameMap<T> {
        private final Node<T>[] values;
        private final int valuesMask;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public static final class Node<T> {
            final String key;
            final T value;

            Node(String str, T t) {
                this.key = str;
                this.value = t;
            }
        }

        EnumNameMap(Node<T>... nodeArr) {
            Node<T>[] nodeArr2;
            this.values = new Node[MathUtil.findNextPositivePowerOfTwo(nodeArr.length)];
            this.valuesMask = nodeArr2.length - 1;
            for (Node<T> node : nodeArr) {
                int hashCode = hashCode(node.key) & this.valuesMask;
                Node<T>[] nodeArr3 = this.values;
                if (nodeArr3[hashCode] == null) {
                    nodeArr3[hashCode] = node;
                } else {
                    throw new IllegalArgumentException("index " + hashCode + " collision between values: [" + this.values[hashCode].key + ", " + node.key + ']');
                }
            }
        }

        private static int hashCode(String str) {
            return str.hashCode() >>> 6;
        }

        T get(String str) {
            Node<T> node = this.values[hashCode(str) & this.valuesMask];
            if (node == null || !node.key.equals(str)) {
                return null;
            }
            return node.value;
        }
    }

    static {
        HttpMethod httpMethod = new HttpMethod("OPTIONS");
        OPTIONS = httpMethod;
        HttpMethod httpMethod2 = new HttpMethod(SSLClient.HTTP_GET);
        GET = httpMethod2;
        HttpMethod httpMethod3 = new HttpMethod("HEAD");
        HEAD = httpMethod3;
        HttpMethod httpMethod4 = new HttpMethod(SSLClient.HTTP_POST);
        POST = httpMethod4;
        HttpMethod httpMethod5 = new HttpMethod(SSLClient.HTTP_PUT);
        PUT = httpMethod5;
        HttpMethod httpMethod6 = new HttpMethod("PATCH");
        PATCH = httpMethod6;
        HttpMethod httpMethod7 = new HttpMethod("DELETE");
        DELETE = httpMethod7;
        HttpMethod httpMethod8 = new HttpMethod("TRACE");
        TRACE = httpMethod8;
        HttpMethod httpMethod9 = new HttpMethod("CONNECT");
        CONNECT = httpMethod9;
        methodMap = new EnumNameMap<>(new EnumNameMap.Node(httpMethod.toString(), httpMethod), new EnumNameMap.Node(httpMethod2.toString(), httpMethod2), new EnumNameMap.Node(httpMethod3.toString(), httpMethod3), new EnumNameMap.Node(httpMethod4.toString(), httpMethod4), new EnumNameMap.Node(httpMethod5.toString(), httpMethod5), new EnumNameMap.Node(httpMethod6.toString(), httpMethod6), new EnumNameMap.Node(httpMethod7.toString(), httpMethod7), new EnumNameMap.Node(httpMethod8.toString(), httpMethod8), new EnumNameMap.Node(httpMethod9.toString(), httpMethod9));
    }

    public HttpMethod(String str) {
        String trim = ((String) ObjectUtil.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME)).trim();
        if (!trim.isEmpty()) {
            for (int i = 0; i < trim.length(); i++) {
                char charAt = trim.charAt(i);
                if (Character.isISOControl(charAt) || Character.isWhitespace(charAt)) {
                    throw new IllegalArgumentException("invalid character in name");
                }
            }
            this.name = AsciiString.cached(trim);
            return;
        }
        throw new IllegalArgumentException("empty name");
    }

    public static HttpMethod valueOf(String str) {
        HttpMethod httpMethod = methodMap.get(str);
        return httpMethod != null ? httpMethod : new HttpMethod(str);
    }

    public AsciiString asciiName() {
        return this.name;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpMethod)) {
            return false;
        }
        return name().equals(((HttpMethod) obj).name());
    }

    public int hashCode() {
        return name().hashCode();
    }

    public String name() {
        return this.name.toString();
    }

    public String toString() {
        return this.name.toString();
    }

    public int compareTo(HttpMethod httpMethod) {
        if (httpMethod == this) {
            return 0;
        }
        return name().compareTo(httpMethod.name());
    }
}
