package b.c.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoggerPrinter.java */
/* loaded from: classes2.dex */
class h implements j {
    private final ThreadLocal<String> a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f34b = new ArrayList();

    @NonNull
    private String j(@NonNull String str, @Nullable Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    @Nullable
    private String k() {
        String str = this.a.get();
        if (str == null) {
            return null;
        }
        this.a.remove();
        return str;
    }

    private synchronized void m(int i, @Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        k.a(str);
        l(i, k(), j(str, objArr), th);
    }

    @Override // b.c.a.j
    public void a(@Nullable String str) {
        if (k.d(str)) {
            c("Empty/Null json content");
            return;
        }
        try {
            String trim = str.trim();
            if (trim.startsWith("{")) {
                c(new JSONObject(trim).toString(2));
            } else if (trim.startsWith("[")) {
                c(new JSONArray(trim).toString(2));
            } else {
                f("Invalid Json", new Object[0]);
            }
        } catch (JSONException unused) {
            f("Invalid Json", new Object[0]);
        }
    }

    @Override // b.c.a.j
    public void b(@NonNull String str, @Nullable Object... objArr) {
        m(4, null, str, objArr);
    }

    @Override // b.c.a.j
    public void c(@Nullable Object obj) {
        m(3, null, k.e(obj), new Object[0]);
    }

    @Override // b.c.a.j
    public j d(String str) {
        if (str != null) {
            this.a.set(str);
        }
        return this;
    }

    @Override // b.c.a.j
    public void e(@NonNull String str, @Nullable Object... objArr) {
        m(2, null, str, objArr);
    }

    @Override // b.c.a.j
    public void f(@NonNull String str, @Nullable Object... objArr) {
        i(null, str, objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.j
    public void g(@NonNull d dVar) {
        this.f34b.add(k.a(dVar));
    }

    @Override // b.c.a.j
    public void h(@NonNull String str, @Nullable Object... objArr) {
        m(5, null, str, objArr);
    }

    @Override // b.c.a.j
    public void i(@Nullable Throwable th, @NonNull String str, @Nullable Object... objArr) {
        m(6, th, str, objArr);
    }

    public synchronized void l(int i, @Nullable String str, @Nullable String str2, @Nullable Throwable th) {
        if (!(th == null || str2 == null)) {
            str2 = str2 + " : " + k.c(th);
        }
        if (th != null && str2 == null) {
            str2 = k.c(th);
        }
        if (k.d(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (d dVar : this.f34b) {
            if (dVar.b(i, str)) {
                dVar.a(i, str, str2);
            }
        }
    }
}
