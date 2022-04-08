package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.g;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* compiled from: LogRequest.java */
@AutoValue
/* loaded from: classes.dex */
public abstract class l {

    /* compiled from: LogRequest.java */
    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class a {
        @NonNull
        public abstract l a();

        @NonNull
        public abstract a b(@Nullable ClientInfo clientInfo);

        @NonNull
        public abstract a c(@Nullable List<k> list);

        @NonNull
        abstract a d(@Nullable Integer num);

        @NonNull
        abstract a e(@Nullable String str);

        @NonNull
        public abstract a f(@Nullable QosTier qosTier);

        @NonNull
        public abstract a g(long j);

        @NonNull
        public abstract a h(long j);

        @NonNull
        public a i(int i) {
            return d(Integer.valueOf(i));
        }

        @NonNull
        public a j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static a a() {
        return new g.b();
    }

    @Nullable
    public abstract ClientInfo b();

    @Nullable
    @Encodable.Field(name = "logEvent")
    public abstract List<k> c();

    @Nullable
    public abstract Integer d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract QosTier f();

    public abstract long g();

    public abstract long h();
}
