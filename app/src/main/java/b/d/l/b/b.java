package b.d.l.b;

import androidx.annotation.NonNull;
import com.tplink.libtpimagedownloadmedia.loader.f;
import com.tplink.libtpimagedownloadmedia.loader.g;

/* compiled from: ImageDownloadInfo.java */
/* loaded from: classes3.dex */
public class b {
    @NonNull
    private g a;

    /* renamed from: b  reason: collision with root package name */
    private f f527b;

    /* renamed from: c  reason: collision with root package name */
    private int f528c = 0;

    public b(@NonNull g gVar, f fVar) {
        this.a = gVar;
        this.f527b = fVar;
    }

    public void a() {
        this.f528c++;
    }

    public f b() {
        return this.f527b;
    }

    public int c() {
        return this.f528c;
    }

    @NonNull
    public g d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        return d().equals(((b) obj).d());
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
