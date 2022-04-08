package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* compiled from: BatchedLogRequest.java */
@AutoValue
@Encodable
/* loaded from: classes.dex */
public abstract class j {
    @NonNull
    public static j a(@NonNull List<l> list) {
        return new d(list);
    }

    @NonNull
    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().configureWith(b.a).ignoreNullValues(true).build();
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<l> c();
}
