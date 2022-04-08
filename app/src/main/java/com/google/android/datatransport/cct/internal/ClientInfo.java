package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.e;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class ClientInfo {

    /* loaded from: classes.dex */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);
        
        private final int value;

        ClientType(int i) {
            this.value = i;
        }
    }

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        public abstract ClientInfo a();

        @NonNull
        public abstract a b(@Nullable a aVar);

        @NonNull
        public abstract a c(@Nullable ClientType clientType);
    }

    @NonNull
    public static a a() {
        return new e.b();
    }

    @Nullable
    public abstract a b();

    @Nullable
    public abstract ClientType c();
}
