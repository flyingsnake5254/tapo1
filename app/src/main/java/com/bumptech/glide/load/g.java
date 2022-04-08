package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.u;
import java.io.IOException;

/* compiled from: ResourceDecoder.java */
/* loaded from: classes.dex */
public interface g<T, Z> {
    boolean a(@NonNull T t, @NonNull f fVar) throws IOException;

    @Nullable
    u<Z> b(@NonNull T t, int i, int i2, @NonNull f fVar) throws IOException;
}
