package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.c;
import com.google.common.base.o;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public interface HttpDataSource extends l {
    public static final o<String> a = c.f3815c;

    /* loaded from: classes.dex */
    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, n nVar) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, nVar, PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED, 1);
        }
    }

    /* loaded from: classes.dex */
    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final n dataSpec;
        public final int type;

        @Deprecated
        public HttpDataSourceException(n nVar, int i) {
            this(nVar, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED, i);
        }

        private static int assignErrorCode(int i, int i2) {
            return (i == 2000 && i2 == 1) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : i;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, n nVar, int i) {
            int i2;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i2 = PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT;
            } else if (iOException instanceof InterruptedIOException) {
                i2 = 1004;
            } else {
                i2 = (message == null || !c.e(message).matches("cleartext.*not permitted.*")) ? PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_FAILED : PlaybackException.ERROR_CODE_IO_CLEARTEXT_NOT_PERMITTED;
            }
            if (i2 == 2007) {
                return new CleartextNotPermittedException(iOException, nVar);
            }
            return new HttpDataSourceException(iOException, nVar, i2, i);
        }

        public HttpDataSourceException(n nVar, int i, int i2) {
            super(assignErrorCode(i, i2));
            this.dataSpec = nVar;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, n nVar, int i) {
            this(str, nVar, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED, i);
        }

        public HttpDataSourceException(String str, n nVar, int i, int i2) {
            super(str, assignErrorCode(i, i2));
            this.dataSpec = nVar;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, n nVar, int i) {
            this(iOException, nVar, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED, i);
        }

        public HttpDataSourceException(IOException iOException, n nVar, int i, int i2) {
            super(iOException, assignErrorCode(i, i2));
            this.dataSpec = nVar;
            this.type = i2;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, n nVar, int i) {
            this(str, iOException, nVar, PlaybackException.ERROR_CODE_IO_UNSPECIFIED, i);
        }

        public HttpDataSourceException(String str, @Nullable IOException iOException, n nVar, int i, int i2) {
            super(str, iOException, assignErrorCode(i, i2));
            this.dataSpec = nVar;
            this.type = i2;
        }
    }

    /* loaded from: classes.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InvalidContentTypeException(java.lang.String r4, com.google.android.exoplayer2.upstream.n r5) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                java.lang.String r2 = "Invalid content type: "
                if (r1 == 0) goto L_0x0011
                java.lang.String r0 = r2.concat(r0)
                goto L_0x0016
            L_0x0011:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L_0x0016:
                r1 = 2003(0x7d3, float:2.807E-42)
                r2 = 1
                r3.<init>(r0, r5, r1, r2)
                r3.contentType = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException.<init>(java.lang.String, com.google.android.exoplayer2.upstream.n):void");
        }
    }

    /* loaded from: classes.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;
        @Nullable
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i, Map<String, List<String>> map, n nVar) {
            this(i, null, null, map, nVar, o0.f3937f);
        }

        @Deprecated
        public InvalidResponseCodeException(int i, @Nullable String str, Map<String, List<String>> map, n nVar) {
            this(i, str, null, map, nVar, o0.f3937f);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InvalidResponseCodeException(int r9, @androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.io.IOException r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12, com.google.android.exoplayer2.upstream.n r13, byte[] r14) {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 26
                r0.<init>(r1)
                java.lang.String r1 = "Response code: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r3 = r0.toString()
                r6 = 2004(0x7d4, float:2.808E-42)
                r7 = 1
                r2 = r8
                r4 = r11
                r5 = r13
                r2.<init>(r3, r4, r5, r6, r7)
                r8.responseCode = r9
                r8.responseMessage = r10
                r8.headerFields = r12
                r8.responseBody = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException.<init>(int, java.lang.String, java.io.IOException, java.util.Map, com.google.android.exoplayer2.upstream.n, byte[]):void");
        }
    }

    /* loaded from: classes.dex */
    public interface a extends l.a {
        @Override // com.google.android.exoplayer2.upstream.l.a
        HttpDataSource a();
    }

    /* loaded from: classes.dex */
    public static final class b {
        private final Map<String, String> a = new HashMap();
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f3799b;

        public synchronized Map<String, String> a() {
            if (this.f3799b == null) {
                this.f3799b = Collections.unmodifiableMap(new HashMap(this.a));
            }
            return this.f3799b;
        }
    }
}
