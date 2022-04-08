package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.u;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class b {

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    class a implements g {
        final /* synthetic */ InputStream a;

        a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* renamed from: com.bumptech.glide.load.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0043b implements g {
        final /* synthetic */ ByteBuffer a;

        C0043b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.a(this.a);
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    class c implements g {
        final /* synthetic */ ParcelFileDescriptorRewinder a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.z.b f1345b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.z.b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.f1345b = bVar;
        }

        @Override // com.bumptech.glide.load.b.g
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            Throwable th;
            u uVar = null;
            try {
                u uVar2 = new u(new FileInputStream(this.a.a().getFileDescriptor()), this.f1345b);
                try {
                    ImageHeaderParser.ImageType b2 = imageHeaderParser.b(uVar2);
                    try {
                        uVar2.close();
                    } catch (IOException unused) {
                    }
                    this.a.a();
                    return b2;
                } catch (Throwable th2) {
                    th = th2;
                    uVar = uVar2;
                    if (uVar != null) {
                        try {
                            uVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    class d implements f {
        final /* synthetic */ InputStream a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.z.b f1346b;

        d(InputStream inputStream, com.bumptech.glide.load.engine.z.b bVar) {
            this.a = inputStream;
            this.f1346b = bVar;
        }

        @Override // com.bumptech.glide.load.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.a, this.f1346b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    class e implements f {
        final /* synthetic */ ParcelFileDescriptorRewinder a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.load.engine.z.b f1347b;

        e(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.bumptech.glide.load.engine.z.b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.f1347b = bVar;
        }

        @Override // com.bumptech.glide.load.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            Throwable th;
            u uVar = null;
            try {
                u uVar2 = new u(new FileInputStream(this.a.a().getFileDescriptor()), this.f1347b);
                try {
                    int c2 = imageHeaderParser.c(uVar2, this.f1347b);
                    try {
                        uVar2.close();
                    } catch (IOException unused) {
                    }
                    this.a.a();
                    return c2;
                } catch (Throwable th2) {
                    th = th2;
                    uVar = uVar2;
                    if (uVar != null) {
                        try {
                            uVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public interface f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImageHeaderParserUtils.java */
    /* loaded from: classes.dex */
    public interface g {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        return c(list, new e(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new u(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return c(list, new d(inputStream, bVar));
    }

    private static int c(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int a2 = fVar.a(list.get(i));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType d(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        return g(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    @NonNull
    public static ImageHeaderParser.ImageType e(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.bumptech.glide.load.engine.z.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new u(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return g(list, new a(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType f(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return g(list, new C0043b(byteBuffer));
    }

    @NonNull
    private static ImageHeaderParser.ImageType g(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType a2 = gVar.a(list.get(i));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
