package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.f;

/* compiled from: OptionalConverterFactory.java */
@IgnoreJRERequirement
/* loaded from: classes4.dex */
final class l extends f.a {
    static final f.a a = new l();

    /* compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    static final class a<T> implements f<ResponseBody, Optional<T>> {
        final f<ResponseBody, T> a;

        a(f<ResponseBody, T> fVar) {
            this.a = fVar;
        }

        /* renamed from: a */
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.a.convert(responseBody));
        }
    }

    l() {
    }

    @Override // retrofit2.f.a
    @Nullable
    public f<ResponseBody, ?> d(Type type, Annotation[] annotationArr, r rVar) {
        if (f.a.b(type) != Optional.class) {
            return null;
        }
        return new a(rVar.i(f.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
