package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.tplink.libtpmediastatistics.SSLClient;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes.dex */
public final class RawResourceDataSource extends h {

    /* renamed from: f  reason: collision with root package name */
    private final Resources f3810f;
    private final String g;
    @Nullable
    private Uri h;
    @Nullable
    private AssetFileDescriptor i;
    @Nullable
    private InputStream j;
    private long k;
    private boolean l;

    /* loaded from: classes.dex */
    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, null, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th) {
            super(th, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f3810f = context.getResources();
        this.g = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i) {
        StringBuilder sb = new StringBuilder(26);
        sb.append("rawresource:///");
        sb.append(i);
        return Uri.parse(sb.toString());
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() throws RawResourceDataSourceException {
        this.h = null;
        try {
            try {
                InputStream inputStream = this.j;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.j = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.i;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.i = null;
                        if (this.l) {
                            this.l = false;
                            p();
                        }
                    }
                } catch (IOException e2) {
                    throw new RawResourceDataSourceException(null, e2, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
                }
            } catch (IOException e3) {
                throw new RawResourceDataSourceException(null, e3, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        } catch (Throwable th) {
            this.j = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.i;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.i = null;
                    if (this.l) {
                        this.l = false;
                        p();
                    }
                    throw th;
                } catch (IOException e4) {
                    throw new RawResourceDataSourceException(null, e4, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
                }
            } finally {
                this.i = null;
                if (this.l) {
                    this.l = false;
                    p();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    @Nullable
    public Uri getUri() {
        return this.h;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long j(n nVar) throws RawResourceDataSourceException {
        int parseInt;
        Uri uri = nVar.a;
        this.h = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) g.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                parseInt = Integer.parseInt((String) g.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", null, 1004);
            }
        } else if (TextUtils.equals("android.resource", uri.getScheme())) {
            String str = (String) g.e(uri.getPath());
            if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                str = str.substring(1);
            }
            String host = uri.getHost();
            String valueOf = String.valueOf(TextUtils.isEmpty(host) ? "" : String.valueOf(host).concat(SSLClient.COLON));
            String valueOf2 = String.valueOf(str);
            parseInt = this.f3810f.getIdentifier(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), "raw", this.g);
            if (parseInt == 0) {
                throw new RawResourceDataSourceException("Resource not found.", null, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
            }
        } else {
            throw new RawResourceDataSourceException("URI must either use scheme rawresource or android.resource", null, 1004);
        }
        q(nVar);
        try {
            AssetFileDescriptor openRawResourceFd = this.f3810f.openRawResourceFd(parseInt);
            this.i = openRawResourceFd;
            if (openRawResourceFd != null) {
                long length = openRawResourceFd.getLength();
                FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
                this.j = fileInputStream;
                int i = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
                if (i != 0) {
                    try {
                        if (nVar.g > length) {
                            throw new RawResourceDataSourceException(null, null, 2008);
                        }
                    } catch (RawResourceDataSourceException e2) {
                        throw e2;
                    } catch (IOException e3) {
                        throw new RawResourceDataSourceException(null, e3, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
                    }
                }
                long startOffset = openRawResourceFd.getStartOffset();
                long skip = fileInputStream.skip(nVar.g + startOffset) - startOffset;
                if (skip == nVar.g) {
                    if (i == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        if (channel.size() == 0) {
                            this.k = -1L;
                        } else {
                            long size = channel.size() - channel.position();
                            this.k = size;
                            if (size < 0) {
                                throw new RawResourceDataSourceException(null, null, 2008);
                            }
                        }
                    } else {
                        long j = length - skip;
                        this.k = j;
                        if (j < 0) {
                            throw new DataSourceException(2008);
                        }
                    }
                    long j2 = nVar.h;
                    if (j2 != -1) {
                        long j3 = this.k;
                        if (j3 != -1) {
                            j2 = Math.min(j3, j2);
                        }
                        this.k = j2;
                    }
                    this.l = true;
                    r(nVar);
                    long j4 = nVar.h;
                    return j4 != -1 ? j4 : this.k;
                }
                throw new RawResourceDataSourceException(null, null, 2008);
            } else {
                String valueOf3 = String.valueOf(uri);
                StringBuilder sb = new StringBuilder(valueOf3.length() + 24);
                sb.append("Resource is compressed: ");
                sb.append(valueOf3);
                throw new RawResourceDataSourceException(sb.toString(), null, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        } catch (Resources.NotFoundException e4) {
            throw new RawResourceDataSourceException(null, e4, PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) throws RawResourceDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.k;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException(null, e2, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        }
        int read = ((InputStream) o0.i(this.j)).read(bArr, i, i2);
        if (read != -1) {
            long j2 = this.k;
            if (j2 != -1) {
                this.k = j2 - read;
            }
            o(read);
            return read;
        } else if (this.k == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }
    }
}
