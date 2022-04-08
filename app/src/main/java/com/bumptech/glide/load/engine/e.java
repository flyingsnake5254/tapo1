package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.a0.a;
import com.bumptech.glide.load.f;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
class e<DataType> implements a.b {
    private final com.bumptech.glide.load.a<DataType> a;

    /* renamed from: b  reason: collision with root package name */
    private final DataType f1432b;

    /* renamed from: c  reason: collision with root package name */
    private final f f1433c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.bumptech.glide.load.a<DataType> aVar, DataType datatype, f fVar) {
        this.a = aVar;
        this.f1432b = datatype;
        this.f1433c = fVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.b
    public boolean a(@NonNull File file) {
        return this.a.a(this.f1432b, file, this.f1433c);
    }
}
