package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* compiled from: AssetPathFetcher.java */
/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: c  reason: collision with root package name */
    private final String f1349c;

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f1350d;

    /* renamed from: f  reason: collision with root package name */
    private T f1351f;

    public b(AssetManager assetManager, String str) {
        this.f1350d = assetManager;
        this.f1349c = str;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        T t = this.f1351f;
        if (t != null) {
            try {
                c(t);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(T t) throws IOException;

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    @NonNull
    public DataSource d() {
        return DataSource.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void e(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T f2 = f(this.f1350d, this.f1349c);
            this.f1351f = f2;
            aVar.f(f2);
        } catch (IOException e2) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e2);
            }
            aVar.c(e2);
        }
    }

    protected abstract T f(AssetManager assetManager, String str) throws IOException;
}
