package retrofit2;

import com.tplink.libtpmediastatistics.SSLClient;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient q<?> response;

    public HttpException(q<?> qVar) {
        super(getMessage(qVar));
        this.code = qVar.b();
        this.message = qVar.f();
        this.response = qVar;
    }

    private static String getMessage(q<?> qVar) {
        v.b(qVar, "response == null");
        return "HTTP " + qVar.b() + SSLClient.WHITE_SPACE + qVar.f();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Nullable
    public q<?> response() {
        return this.response;
    }
}
