package com.airbnb.lottie.u;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.s.c.h;
import java.io.IOException;

/* compiled from: PathKeyframeParser.java */
/* loaded from: classes.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(JsonReader jsonReader, d dVar) throws IOException {
        return new h(dVar, q.b(jsonReader, dVar, com.airbnb.lottie.v.h.e(), x.a, jsonReader.w() == JsonReader.Token.BEGIN_OBJECT));
    }
}
