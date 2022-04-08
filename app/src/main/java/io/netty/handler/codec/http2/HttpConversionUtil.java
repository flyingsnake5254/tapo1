package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.UnsupportedValueConverter;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.DefaultHttpRequest;
import io.netty.handler.codec.http.DefaultHttpResponse;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes3.dex */
public final class HttpConversionUtil {
    private static final CharSequenceMap<AsciiString> HTTP_TO_HTTP2_HEADER_BLACKLIST;
    public static final String OUT_OF_MESSAGE_SEQUENCE_PATH = "";
    public static final HttpMethod OUT_OF_MESSAGE_SEQUENCE_METHOD = HttpMethod.OPTIONS;
    public static final HttpResponseStatus OUT_OF_MESSAGE_SEQUENCE_RETURN_CODE = HttpResponseStatus.OK;
    private static final AsciiString EMPTY_REQUEST_PATH = AsciiString.cached(MqttTopic.TOPIC_LEVEL_SEPARATOR);

    /* loaded from: classes3.dex */
    public enum ExtensionHeaderNames {
        STREAM_ID("x-http2-stream-id"),
        SCHEME("x-http2-scheme"),
        PATH("x-http2-path"),
        STREAM_PROMISE_ID("x-http2-stream-promise-id"),
        STREAM_DEPENDENCY_ID("x-http2-stream-dependency-id"),
        STREAM_WEIGHT("x-http2-stream-weight");
        
        private final AsciiString text;

        ExtensionHeaderNames(String str) {
            this.text = AsciiString.cached(str);
        }

        public AsciiString text() {
            return this.text;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Http2ToHttpHeaderTranslator {
        private static final CharSequenceMap<AsciiString> REQUEST_HEADER_TRANSLATIONS;
        private static final CharSequenceMap<AsciiString> RESPONSE_HEADER_TRANSLATIONS;
        private final HttpHeaders output;
        private final int streamId;
        private final CharSequenceMap<AsciiString> translations;

        static {
            CharSequenceMap<AsciiString> charSequenceMap = new CharSequenceMap<>();
            REQUEST_HEADER_TRANSLATIONS = charSequenceMap;
            CharSequenceMap<AsciiString> charSequenceMap2 = new CharSequenceMap<>();
            RESPONSE_HEADER_TRANSLATIONS = charSequenceMap2;
            charSequenceMap2.add((CharSequenceMap<AsciiString>) Http2Headers.PseudoHeaderName.AUTHORITY.value(), HttpHeaderNames.HOST);
            charSequenceMap2.add((CharSequenceMap<AsciiString>) Http2Headers.PseudoHeaderName.SCHEME.value(), ExtensionHeaderNames.SCHEME.text());
            charSequenceMap.add(charSequenceMap2);
            charSequenceMap2.add((CharSequenceMap<AsciiString>) Http2Headers.PseudoHeaderName.PATH.value(), ExtensionHeaderNames.PATH.text());
        }

        Http2ToHttpHeaderTranslator(int i, HttpHeaders httpHeaders, boolean z) {
            this.streamId = i;
            this.output = httpHeaders;
            this.translations = z ? REQUEST_HEADER_TRANSLATIONS : RESPONSE_HEADER_TRANSLATIONS;
        }

        public void translateHeaders(Iterable<Map.Entry<CharSequence, CharSequence>> iterable) throws Http2Exception {
            StringBuilder sb = null;
            for (Map.Entry<CharSequence, CharSequence> entry : iterable) {
                CharSequence key = entry.getKey();
                CharSequence value = entry.getValue();
                AsciiString asciiString = this.translations.get(key);
                if (asciiString != null) {
                    this.output.add(asciiString, AsciiString.of(value));
                } else if (Http2Headers.PseudoHeaderName.isPseudoHeader(key)) {
                    continue;
                } else if (key.length() == 0 || key.charAt(0) == ':') {
                    throw Http2Exception.streamError(this.streamId, Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 header '%s' encountered in translation to HTTP/1.x", key);
                } else if (HttpHeaderNames.COOKIE.equals(key)) {
                    if (sb == null) {
                        sb = InternalThreadLocalMap.get().stringBuilder();
                    } else if (sb.length() > 0) {
                        sb.append("; ");
                    }
                    sb.append(value);
                } else {
                    this.output.add(key, value);
                }
            }
            if (sb != null) {
                this.output.add(HttpHeaderNames.COOKIE, sb.toString());
            }
        }
    }

    static {
        CharSequenceMap<AsciiString> charSequenceMap = new CharSequenceMap<>();
        HTTP_TO_HTTP2_HEADER_BLACKLIST = charSequenceMap;
        AsciiString asciiString = HttpHeaderNames.CONNECTION;
        AsciiString asciiString2 = AsciiString.EMPTY_STRING;
        charSequenceMap.add((CharSequenceMap<AsciiString>) asciiString, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.KEEP_ALIVE, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.PROXY_CONNECTION, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.TRANSFER_ENCODING, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.HOST, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) HttpHeaderNames.UPGRADE, asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) ExtensionHeaderNames.STREAM_ID.text(), asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) ExtensionHeaderNames.SCHEME.text(), asciiString2);
        charSequenceMap.add((CharSequenceMap<AsciiString>) ExtensionHeaderNames.PATH.text(), asciiString2);
    }

    private HttpConversionUtil() {
    }

    public static void addHttp2ToHttpHeaders(int i, Http2Headers http2Headers, FullHttpMessage fullHttpMessage, boolean z) throws Http2Exception {
        addHttp2ToHttpHeaders(i, http2Headers, z ? fullHttpMessage.trailingHeaders() : fullHttpMessage.headers(), fullHttpMessage.protocolVersion(), z, fullHttpMessage instanceof HttpRequest);
    }

    public static HttpResponseStatus parseStatus(CharSequence charSequence) throws Http2Exception {
        try {
            HttpResponseStatus parseLine = HttpResponseStatus.parseLine(charSequence);
            if (parseLine != HttpResponseStatus.SWITCHING_PROTOCOLS) {
                return parseLine;
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 status code '%d'", Integer.valueOf(parseLine.code()));
        } catch (Http2Exception e2) {
            throw e2;
        } catch (Throwable th) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, th, "Unrecognized HTTP status code '%s' encountered in translation to HTTP/1.x", charSequence);
        }
    }

    static void setHttp2Authority(String str, Http2Headers http2Headers) {
        if (str == null) {
            return;
        }
        if (str.isEmpty()) {
            http2Headers.authority(AsciiString.EMPTY_STRING);
            return;
        }
        int indexOf = str.indexOf(64) + 1;
        int length = str.length() - indexOf;
        if (length != 0) {
            http2Headers.authority(new AsciiString(str, indexOf, length));
            return;
        }
        throw new IllegalArgumentException("authority: " + str);
    }

    private static void setHttp2Scheme(HttpHeaders httpHeaders, URI uri, Http2Headers http2Headers) {
        String scheme = uri.getScheme();
        if (scheme != null) {
            http2Headers.scheme(new AsciiString(scheme));
            return;
        }
        String str = httpHeaders.get(ExtensionHeaderNames.SCHEME.text());
        if (str != null) {
            http2Headers.scheme(AsciiString.of(str));
            return;
        }
        int port = uri.getPort();
        HttpScheme httpScheme = HttpScheme.HTTPS;
        if (port == httpScheme.port()) {
            http2Headers.scheme(httpScheme.name());
            return;
        }
        int port2 = uri.getPort();
        HttpScheme httpScheme2 = HttpScheme.HTTP;
        if (port2 == httpScheme2.port()) {
            http2Headers.scheme(httpScheme2.name());
            return;
        }
        throw new IllegalArgumentException(":scheme must be specified. see https://tools.ietf.org/html/rfc7540#section-8.1.2.3");
    }

    public static FullHttpRequest toFullHttpRequest(int i, Http2Headers http2Headers, ByteBufAllocator byteBufAllocator, boolean z) throws Http2Exception {
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.valueOf(((CharSequence) ObjectUtil.checkNotNull(http2Headers.method(), "method header cannot be null in conversion to HTTP/1.x")).toString()), ((CharSequence) ObjectUtil.checkNotNull(http2Headers.path(), "path header cannot be null in conversion to HTTP/1.x")).toString(), byteBufAllocator.buffer(), z);
        try {
            addHttp2ToHttpHeaders(i, http2Headers, defaultFullHttpRequest, false);
            return defaultFullHttpRequest;
        } catch (Http2Exception e2) {
            defaultFullHttpRequest.release();
            throw e2;
        } catch (Throwable th) {
            defaultFullHttpRequest.release();
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static FullHttpResponse toFullHttpResponse(int i, Http2Headers http2Headers, ByteBufAllocator byteBufAllocator, boolean z) throws Http2Exception {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, parseStatus(http2Headers.status()), byteBufAllocator.buffer(), z);
        try {
            addHttp2ToHttpHeaders(i, http2Headers, defaultFullHttpResponse, false);
            return defaultFullHttpResponse;
        } catch (Http2Exception e2) {
            defaultFullHttpResponse.release();
            throw e2;
        } catch (Throwable th) {
            defaultFullHttpResponse.release();
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static Http2Headers toHttp2Headers(HttpMessage httpMessage, boolean z) {
        HttpHeaders headers = httpMessage.headers();
        DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers(z, headers.size());
        if (httpMessage instanceof HttpRequest) {
            HttpRequest httpRequest = (HttpRequest) httpMessage;
            URI create = URI.create(httpRequest.uri());
            defaultHttp2Headers.path(toHttp2Path(create));
            defaultHttp2Headers.method(httpRequest.method().asciiName());
            setHttp2Scheme(headers, create, defaultHttp2Headers);
            if (!HttpUtil.isOriginForm(create) && !HttpUtil.isAsteriskForm(create)) {
                String asString = headers.getAsString(HttpHeaderNames.HOST);
                if (asString == null || asString.isEmpty()) {
                    asString = create.getAuthority();
                }
                setHttp2Authority(asString, defaultHttp2Headers);
            }
        } else if (httpMessage instanceof HttpResponse) {
            defaultHttp2Headers.status(((HttpResponse) httpMessage).status().codeAsText());
        }
        toHttp2Headers(headers, defaultHttp2Headers);
        return defaultHttp2Headers;
    }

    private static void toHttp2HeadersFilterTE(Map.Entry<CharSequence, CharSequence> entry, Http2Headers http2Headers) {
        if (AsciiString.indexOf(entry.getValue(), StringUtil.COMMA, 0) == -1) {
            CharSequence trim = AsciiString.trim(entry.getValue());
            AsciiString asciiString = HttpHeaderValues.TRAILERS;
            if (AsciiString.contentEqualsIgnoreCase(trim, asciiString)) {
                http2Headers.add((Http2Headers) HttpHeaderNames.TE, asciiString);
                return;
            }
            return;
        }
        for (CharSequence charSequence : StringUtil.unescapeCsvFields(entry.getValue())) {
            CharSequence trim2 = AsciiString.trim(charSequence);
            AsciiString asciiString2 = HttpHeaderValues.TRAILERS;
            if (AsciiString.contentEqualsIgnoreCase(trim2, asciiString2)) {
                http2Headers.add((Http2Headers) HttpHeaderNames.TE, asciiString2);
                return;
            }
        }
    }

    private static AsciiString toHttp2Path(URI uri) {
        StringBuilder sb = new StringBuilder(StringUtil.length(uri.getRawPath()) + StringUtil.length(uri.getRawQuery()) + StringUtil.length(uri.getRawFragment()) + 2);
        if (!StringUtil.isNullOrEmpty(uri.getRawPath())) {
            sb.append(uri.getRawPath());
        }
        if (!StringUtil.isNullOrEmpty(uri.getRawQuery())) {
            sb.append('?');
            sb.append(uri.getRawQuery());
        }
        if (!StringUtil.isNullOrEmpty(uri.getRawFragment())) {
            sb.append('#');
            sb.append(uri.getRawFragment());
        }
        String sb2 = sb.toString();
        return sb2.isEmpty() ? EMPTY_REQUEST_PATH : new AsciiString(sb2);
    }

    public static HttpRequest toHttpRequest(int i, Http2Headers http2Headers, boolean z) throws Http2Exception {
        DefaultHttpRequest defaultHttpRequest = new DefaultHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.valueOf(((CharSequence) ObjectUtil.checkNotNull(http2Headers.method(), "method header cannot be null in conversion to HTTP/1.x")).toString()), ((CharSequence) ObjectUtil.checkNotNull(http2Headers.path(), "path header cannot be null in conversion to HTTP/1.x")).toString(), z);
        try {
            addHttp2ToHttpHeaders(i, http2Headers, defaultHttpRequest.headers(), defaultHttpRequest.protocolVersion(), false, true);
            return defaultHttpRequest;
        } catch (Http2Exception e2) {
            throw e2;
        } catch (Throwable th) {
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static HttpResponse toHttpResponse(int i, Http2Headers http2Headers, boolean z) throws Http2Exception {
        DefaultHttpResponse defaultHttpResponse = new DefaultHttpResponse(HttpVersion.HTTP_1_1, parseStatus(http2Headers.status()), z);
        try {
            addHttp2ToHttpHeaders(i, http2Headers, defaultHttpResponse.headers(), defaultHttpResponse.protocolVersion(), false, true);
            return defaultHttpResponse;
        } catch (Http2Exception e2) {
            throw e2;
        } catch (Throwable th) {
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    private static CharSequenceMap<AsciiString> toLowercaseMap(Iterator<? extends CharSequence> it, int i) {
        AsciiString asciiString;
        CharSequenceMap<AsciiString> charSequenceMap = new CharSequenceMap<>(true, UnsupportedValueConverter.instance(), i);
        while (it.hasNext()) {
            AsciiString lowerCase = AsciiString.of((CharSequence) it.next()).toLowerCase();
            try {
                int forEachByte = lowerCase.forEachByte(ByteProcessor.FIND_COMMA);
                if (forEachByte != -1) {
                    int i2 = 0;
                    do {
                        AsciiString trim = lowerCase.subSequence(i2, forEachByte, false).trim();
                        asciiString = AsciiString.EMPTY_STRING;
                        charSequenceMap.add((CharSequenceMap<AsciiString>) trim, asciiString);
                        i2 = forEachByte + 1;
                        if (i2 >= lowerCase.length()) {
                            break;
                        }
                        forEachByte = lowerCase.forEachByte(i2, lowerCase.length() - i2, ByteProcessor.FIND_COMMA);
                    } while (forEachByte != -1);
                    charSequenceMap.add((CharSequenceMap<AsciiString>) lowerCase.subSequence(i2, lowerCase.length(), false).trim(), asciiString);
                } else {
                    charSequenceMap.add((CharSequenceMap<AsciiString>) lowerCase.trim(), AsciiString.EMPTY_STRING);
                }
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        return charSequenceMap;
    }

    public static void addHttp2ToHttpHeaders(int i, Http2Headers http2Headers, HttpHeaders httpHeaders, HttpVersion httpVersion, boolean z, boolean z2) throws Http2Exception {
        try {
            new Http2ToHttpHeaderTranslator(i, httpHeaders, z2).translateHeaders(http2Headers);
            httpHeaders.remove(HttpHeaderNames.TRANSFER_ENCODING);
            httpHeaders.remove(HttpHeaderNames.TRAILER);
            if (!z) {
                httpHeaders.setInt(ExtensionHeaderNames.STREAM_ID.text(), i);
                HttpUtil.setKeepAlive(httpHeaders, httpVersion, true);
            }
        } catch (Http2Exception e2) {
            throw e2;
        } catch (Throwable th) {
            throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, th, "HTTP/2 to HTTP/1.x headers conversion error", new Object[0]);
        }
    }

    public static Http2Headers toHttp2Headers(HttpHeaders httpHeaders, boolean z) {
        if (httpHeaders.isEmpty()) {
            return EmptyHttp2Headers.INSTANCE;
        }
        DefaultHttp2Headers defaultHttp2Headers = new DefaultHttp2Headers(z, httpHeaders.size());
        toHttp2Headers(httpHeaders, defaultHttp2Headers);
        return defaultHttp2Headers;
    }

    public static void toHttp2Headers(HttpHeaders httpHeaders, Http2Headers http2Headers) {
        AsciiString asciiString;
        Iterator<Map.Entry<CharSequence, CharSequence>> iteratorCharSequence = httpHeaders.iteratorCharSequence();
        CharSequenceMap<AsciiString> lowercaseMap = toLowercaseMap(httpHeaders.valueCharSequenceIterator(HttpHeaderNames.CONNECTION), 8);
        while (iteratorCharSequence.hasNext()) {
            Map.Entry<CharSequence, CharSequence> next = iteratorCharSequence.next();
            AsciiString lowerCase = AsciiString.of(next.getKey()).toLowerCase();
            if (!HTTP_TO_HTTP2_HEADER_BLACKLIST.contains(lowerCase) && !lowercaseMap.contains(lowerCase)) {
                if (lowerCase.contentEqualsIgnoreCase(HttpHeaderNames.TE)) {
                    toHttp2HeadersFilterTE(next, http2Headers);
                } else {
                    AsciiString asciiString2 = HttpHeaderNames.COOKIE;
                    if (lowerCase.contentEqualsIgnoreCase(asciiString2)) {
                        AsciiString of = AsciiString.of(next.getValue());
                        try {
                            int forEachByte = of.forEachByte(ByteProcessor.FIND_SEMI_COLON);
                            if (forEachByte != -1) {
                                int i = 0;
                                do {
                                    asciiString = HttpHeaderNames.COOKIE;
                                    http2Headers.add((Http2Headers) asciiString, of.subSequence(i, forEachByte, false));
                                    i = forEachByte + 2;
                                    if (i >= of.length()) {
                                        break;
                                    }
                                    forEachByte = of.forEachByte(i, of.length() - i, ByteProcessor.FIND_SEMI_COLON);
                                } while (forEachByte != -1);
                                if (i < of.length()) {
                                    http2Headers.add((Http2Headers) asciiString, of.subSequence(i, of.length(), false));
                                } else {
                                    throw new IllegalArgumentException("cookie value is of unexpected format: " + ((Object) of));
                                }
                            } else {
                                http2Headers.add((Http2Headers) asciiString2, of);
                            }
                        } catch (Exception e2) {
                            throw new IllegalStateException(e2);
                        }
                    } else {
                        http2Headers.add((Http2Headers) lowerCase, (AsciiString) next.getValue());
                    }
                }
            }
        }
    }
}
