package retrofit2.w.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.f;

/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: classes4.dex */
final class b<T> implements f<T, RequestBody> {
    private static final MediaType a = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f17678b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private final Gson f17679c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeAdapter<T> f17680d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f17679c = gson;
        this.f17680d = typeAdapter;
    }

    /* renamed from: a */
    public RequestBody convert(T t) throws IOException {
        Buffer buffer = new Buffer();
        com.google.gson.stream.b s = this.f17679c.s(new OutputStreamWriter(buffer.outputStream(), f17678b));
        this.f17680d.write(s, t);
        s.close();
        return RequestBody.create(a, buffer.readByteString());
    }
}
