package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.util.i;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ImageReader.java */
/* loaded from: classes.dex */
interface q {

    /* compiled from: ImageReader.java */
    /* loaded from: classes.dex */
    public static final class a implements q {
        private final k a;

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.engine.z.b f1649b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f1650c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(InputStream inputStream, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.b bVar) {
            this.f1649b = (com.bumptech.glide.load.engine.z.b) i.d(bVar);
            this.f1650c = (List) i.d(list);
            this.a = new k(inputStream, bVar);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.a.a(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        public void b() {
            this.a.c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        public int c() throws IOException {
            return com.bumptech.glide.load.b.b(this.f1650c, this.a.a(), this.f1649b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.b.e(this.f1650c, this.a.a(), this.f1649b);
        }
    }

    /* compiled from: ImageReader.java */
    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class b implements q {
        private final com.bumptech.glide.load.engine.z.b a;

        /* renamed from: b  reason: collision with root package name */
        private final List<ImageHeaderParser> f1651b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f1652c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.z.b bVar) {
            this.a = (com.bumptech.glide.load.engine.z.b) i.d(bVar);
            this.f1651b = (List) i.d(list);
            this.f1652c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f1652c.a().getFileDescriptor(), null, options);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        public void b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        public int c() throws IOException {
            return com.bumptech.glide.load.b.a(this.f1651b, this.f1652c, this.a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.q
        public ImageHeaderParser.ImageType d() throws IOException {
            return com.bumptech.glide.load.b.d(this.f1651b, this.f1652c, this.a);
        }
    }

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    int c() throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
