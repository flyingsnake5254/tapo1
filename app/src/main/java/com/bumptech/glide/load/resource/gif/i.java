package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class i implements g<InputStream, GifDrawable> {
    private final List<ImageHeaderParser> a;

    /* renamed from: b  reason: collision with root package name */
    private final g<ByteBuffer, GifDrawable> f1685b;

    /* renamed from: c  reason: collision with root package name */
    private final b f1686c;

    public i(List<ImageHeaderParser> list, g<ByteBuffer, GifDrawable> gVar, b bVar) {
        this.a = list;
        this.f1685b = gVar;
        this.f1686c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    /* renamed from: c */
    public u<GifDrawable> b(@NonNull InputStream inputStream, int i, int i2, @NonNull f fVar) throws IOException {
        byte[] e2 = e(inputStream);
        if (e2 == null) {
            return null;
        }
        return this.f1685b.b(ByteBuffer.wrap(e2), i, i2, fVar);
    }

    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull f fVar) throws IOException {
        return !((Boolean) fVar.c(h.f1684b)).booleanValue() && com.bumptech.glide.load.b.e(this.a, inputStream, this.f1686c) == ImageHeaderParser.ImageType.GIF;
    }
}
