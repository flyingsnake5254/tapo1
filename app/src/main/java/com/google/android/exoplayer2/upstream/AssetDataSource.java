package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes.dex */
public final class AssetDataSource extends h {

    /* renamed from: f  reason: collision with root package name */
    private final AssetManager f3796f;
    @Nullable
    private Uri g;
    @Nullable
    private InputStream h;
    private long i;
    private boolean j;

    /* loaded from: classes.dex */
    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super(iOException, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }

        public AssetDataSourceException(@Nullable Throwable th, int i) {
            super(th, i);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f3796f = context.getAssets();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() throws AssetDataSourceException {
        this.g = null;
        try {
            try {
                InputStream inputStream = this.h;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        } finally {
            this.h = null;
            if (this.j) {
                this.j = false;
                p();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    @Nullable
    public Uri getUri() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long j(n nVar) throws AssetDataSourceException {
        try {
            Uri uri = nVar.a;
            this.g = uri;
            String str = (String) g.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
                str = str.substring(1);
            }
            q(nVar);
            InputStream open = this.f3796f.open(str, 1);
            this.h = open;
            if (open.skip(nVar.g) >= nVar.g) {
                long j = nVar.h;
                if (j != -1) {
                    this.i = j;
                } else {
                    long available = this.h.available();
                    this.i = available;
                    if (available == 2147483647L) {
                        this.i = -1L;
                    }
                }
                this.j = true;
                r(nVar);
                return this.i;
            }
            throw new AssetDataSourceException(null, 2008);
        } catch (AssetDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new AssetDataSourceException(e3, e3 instanceof FileNotFoundException ? PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND : PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) throws AssetDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.i;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        }
        int read = ((InputStream) o0.i(this.h)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.i;
        if (j2 != -1) {
            this.i = j2 - read;
        }
        o(read);
        return read;
    }
}
