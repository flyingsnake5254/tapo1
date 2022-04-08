package com.airbnb.lottie.u;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.c;
import com.airbnb.lottie.model.i.f;
import com.airbnb.lottie.model.i.g;
import com.airbnb.lottie.model.i.j;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.v.h;
import com.airbnb.lottie.w.a;
import java.io.IOException;
import java.util.List;

/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public class d {
    @Nullable
    private static <T> List<a<T>> a(JsonReader jsonReader, float f2, com.airbnb.lottie.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, f2, j0Var);
    }

    @Nullable
    private static <T> List<a<T>> b(JsonReader jsonReader, com.airbnb.lottie.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, j0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.i.a c(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.i.a(b(jsonReader, dVar, f.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j d(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new j(b(jsonReader, dVar, h.a));
    }

    public static b e(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return f(jsonReader, dVar, true);
    }

    public static b f(JsonReader jsonReader, com.airbnb.lottie.d dVar, boolean z) throws IOException {
        return new b(a(jsonReader, z ? h.e() : 1.0f, dVar, i.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c g(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i) throws IOException {
        return new c(b(jsonReader, dVar, new l(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.i.d h(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.i.d(b(jsonReader, dVar, o.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f i(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new f(a(jsonReader, h.e(), dVar, y.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g j(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new g(b(jsonReader, dVar, c0.a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.airbnb.lottie.model.i.h k(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new com.airbnb.lottie.model.i.h(a(jsonReader, h.e(), dVar, d0.a));
    }
}
