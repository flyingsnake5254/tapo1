package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key.java */
/* loaded from: classes.dex */
public interface c {
    public static final Charset a = Charset.forName("UTF-8");

    void b(@NonNull MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
