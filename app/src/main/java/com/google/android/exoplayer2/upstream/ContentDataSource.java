package com.google.android.exoplayer2.upstream;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.o0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class ContentDataSource extends h {

    /* renamed from: f  reason: collision with root package name */
    private final ContentResolver f3797f;
    @Nullable
    private Uri g;
    @Nullable
    private AssetFileDescriptor h;
    @Nullable
    private FileInputStream i;
    private long j;
    private boolean k;

    /* loaded from: classes.dex */
    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i) {
            super(iOException, i);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f3797f = context.getContentResolver();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() throws ContentDataSourceException {
        this.g = null;
        try {
            try {
                FileInputStream fileInputStream = this.i;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.h = null;
                        if (this.k) {
                            this.k = false;
                            p();
                        }
                    }
                } catch (IOException e2) {
                    throw new ContentDataSourceException(e2, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
                }
            } catch (IOException e3) {
                throw new ContentDataSourceException(e3, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        } catch (Throwable th) {
            this.i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.h = null;
                    if (this.k) {
                        this.k = false;
                        p();
                    }
                    throw th;
                } catch (IOException e4) {
                    throw new ContentDataSourceException(e4, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
                }
            } finally {
                this.h = null;
                if (this.k) {
                    this.k = false;
                    p();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    @Nullable
    public Uri getUri() {
        return this.g;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long j(n nVar) throws ContentDataSourceException {
        int i = PlaybackException.ERROR_CODE_IO_UNSPECIFIED;
        try {
            Uri uri = nVar.a;
            this.g = uri;
            q(nVar);
            AssetFileDescriptor openAssetFileDescriptor = this.f3797f.openAssetFileDescriptor(uri, "r");
            this.h = openAssetFileDescriptor;
            if (openAssetFileDescriptor != null) {
                long length = openAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
                this.i = fileInputStream;
                int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
                if (i2 != 0 && nVar.g > length) {
                    throw new ContentDataSourceException(null, 2008);
                }
                long startOffset = openAssetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(nVar.g + startOffset) - startOffset;
                if (skip == nVar.g) {
                    if (i2 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.j = -1L;
                        } else {
                            long position = size - channel.position();
                            this.j = position;
                            if (position < 0) {
                                throw new ContentDataSourceException(null, 2008);
                            }
                        }
                    } else {
                        long j = length - skip;
                        this.j = j;
                        if (j < 0) {
                            throw new ContentDataSourceException(null, 2008);
                        }
                    }
                    long j2 = nVar.h;
                    if (j2 != -1) {
                        long j3 = this.j;
                        if (j3 != -1) {
                            j2 = Math.min(j3, j2);
                        }
                        this.j = j2;
                    }
                    this.k = true;
                    r(nVar);
                    long j4 = nVar.h;
                    return j4 != -1 ? j4 : this.j;
                }
                throw new ContentDataSourceException(null, 2008);
            }
            String valueOf = String.valueOf(uri);
            StringBuilder sb = new StringBuilder(valueOf.length() + 36);
            sb.append("Could not open file descriptor for: ");
            sb.append(valueOf);
            throw new ContentDataSourceException(new IOException(sb.toString()), PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        } catch (ContentDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            if (e3 instanceof FileNotFoundException) {
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new ContentDataSourceException(e3, i);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) throws ContentDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        long j = this.j;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        }
        int read = ((FileInputStream) o0.i(this.i)).read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.j;
        if (j2 != -1) {
            this.j = j2 - read;
        }
        o(read);
        return read;
    }
}
