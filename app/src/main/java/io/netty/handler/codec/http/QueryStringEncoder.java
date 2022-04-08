package io.netty.handler.codec.http;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class QueryStringEncoder {
    private static final char[] CHAR_MAP = "0123456789ABCDEF".toCharArray();
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private final Charset charset;
    private boolean hasParams;
    private final StringBuilder uriBuilder;

    public QueryStringEncoder(String str) {
        this(str, HttpConstants.DEFAULT_CHARSET);
    }

    private void appendEncoded(int i) {
        StringBuilder sb = this.uriBuilder;
        sb.append('%');
        sb.append(forDigit(i >> 4));
        sb.append(forDigit(i));
    }

    private static boolean dontNeedEncoding(char c2) {
        return (c2 >= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z') || ((c2 >= '0' && c2 <= '9') || c2 == '-' || c2 == '_' || c2 == '.' || c2 == '*');
    }

    private void encodeComponent(CharSequence charSequence) {
        if (this.charset == null) {
            encodeUtf8Component(charSequence);
        } else {
            encodeNonUtf8Component(charSequence);
        }
    }

    private void encodeNonUtf8Component(CharSequence charSequence) {
        int length = charSequence.length();
        char[] cArr = null;
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (dontNeedEncoding(charAt)) {
                this.uriBuilder.append(charAt);
                i++;
            } else {
                if (cArr == null) {
                    cArr = new char[charSequence.length() - i];
                }
                int i2 = 0;
                do {
                    cArr[i2] = charAt;
                    i2++;
                    i++;
                    if (i >= charSequence.length()) {
                        break;
                    }
                    charAt = charSequence.charAt(i);
                } while (!dontNeedEncoding(charAt));
                for (byte b2 : new String(cArr, 0, i2).getBytes(this.charset)) {
                    appendEncoded(b2);
                }
            }
        }
    }

    private void encodeUtf8Component(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!dontNeedEncoding(charSequence.charAt(i))) {
                encodeUtf8Component(charSequence, i, length);
                return;
            }
        }
        this.uriBuilder.append(charSequence);
    }

    private void encodeUtf8ComponentSlow(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                if (dontNeedEncoding(charAt)) {
                    this.uriBuilder.append(charAt);
                } else {
                    appendEncoded(charAt);
                }
            } else if (charAt < 2048) {
                appendEncoded((charAt >> 6) | 192);
                appendEncoded((charAt & '?') | 128);
            } else if (!StringUtil.isSurrogate(charAt)) {
                appendEncoded((charAt >> '\f') | 224);
                appendEncoded(((charAt >> 6) & 63) | 128);
                appendEncoded((charAt & '?') | 128);
            } else if (!Character.isHighSurrogate(charAt)) {
                appendEncoded(63);
            } else {
                i++;
                if (i == charSequence.length()) {
                    appendEncoded(63);
                    return;
                }
                writeUtf8Surrogate(charAt, charSequence.charAt(i));
            }
            i++;
        }
    }

    private static char forDigit(int i) {
        return CHAR_MAP[i & 15];
    }

    private void writeUtf8Surrogate(char c2, char c3) {
        if (!Character.isLowSurrogate(c3)) {
            appendEncoded(63);
            if (Character.isHighSurrogate(c3)) {
                c3 = '?';
            }
            appendEncoded(c3);
            return;
        }
        int codePoint = Character.toCodePoint(c2, c3);
        appendEncoded((codePoint >> 18) | 240);
        appendEncoded(((codePoint >> 12) & 63) | 128);
        appendEncoded(((codePoint >> 6) & 63) | 128);
        appendEncoded((codePoint & 63) | 128);
    }

    public void addParam(String str, String str2) {
        ObjectUtil.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (this.hasParams) {
            this.uriBuilder.append('&');
        } else {
            this.uriBuilder.append('?');
            this.hasParams = true;
        }
        encodeComponent(str);
        if (str2 != null) {
            this.uriBuilder.append('=');
            encodeComponent(str2);
        }
    }

    public String toString() {
        return this.uriBuilder.toString();
    }

    public URI toUri() throws URISyntaxException {
        return new URI(toString());
    }

    public QueryStringEncoder(String str, Charset charset) {
        ObjectUtil.checkNotNull(charset, "charset");
        this.uriBuilder = new StringBuilder(str);
        this.charset = CharsetUtil.UTF_8.equals(charset) ? null : charset;
    }

    private void encodeUtf8Component(CharSequence charSequence, int i, int i2) {
        if (i > 0) {
            this.uriBuilder.append(charSequence, 0, i);
        }
        encodeUtf8ComponentSlow(charSequence, i, i2);
    }
}
