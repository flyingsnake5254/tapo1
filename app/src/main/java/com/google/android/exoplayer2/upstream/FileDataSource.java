package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public final class FileDataSource extends h {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RandomAccessFile f3798f;
    @Nullable
    private Uri g;
    private long h;
    private boolean i;

    /* loaded from: classes.dex */
    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super(exc, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }

        public FileDataSourceException(Throwable th, int i) {
            super(th, i);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i) {
            super(str, th, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile s(Uri uri) throws FileDataSourceException {
        int i = PlaybackException.ERROR_CODE_IO_NO_PERMISSION;
        try {
            return new RandomAccessFile((String) g.e(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e2, 1004);
            }
            if (o0.a < 21 || !a.b(e2.getCause())) {
                i = PlaybackException.ERROR_CODE_IO_FILE_NOT_FOUND;
            }
            throw new FileDataSourceException(e2, i);
        } catch (SecurityException e3) {
            throw new FileDataSourceException(e3, (int) PlaybackException.ERROR_CODE_IO_NO_PERMISSION);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException(e4, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() throws FileDataSourceException {
        this.g = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f3798f;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e2) {
                throw new FileDataSourceException(e2, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
            }
        } finally {
            this.f3798f = null;
            if (this.i) {
                this.i = false;
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
    public long j(n nVar) throws FileDataSourceException {
        Uri uri = nVar.a;
        this.g = uri;
        q(nVar);
        RandomAccessFile s = s(uri);
        this.f3798f = s;
        try {
            s.seek(nVar.g);
            long j = nVar.h;
            if (j == -1) {
                j = this.f3798f.length() - nVar.g;
            }
            this.h = j;
            if (j >= 0) {
                this.i = true;
                r(nVar);
                return this.h;
            }
            throw new FileDataSourceException(null, null, 2008);
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.i
    public int read(byte[] bArr, int i, int i2) throws FileDataSourceException {
        if (i2 == 0) {
            return 0;
        }
        if (this.h == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) o0.i(this.f3798f)).read(bArr, i, (int) Math.min(this.h, i2));
            if (read > 0) {
                this.h -= read;
                o(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException(e2, (int) PlaybackException.ERROR_CODE_IO_UNSPECIFIED);
        }
    }
}
