package kotlinx.coroutines.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.TypeCastException;
import kotlin.b;
import kotlin.collections.o;
import kotlin.collections.s;
import kotlin.jvm.internal.j;
import kotlin.text.v;
import kotlin.text.w;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* compiled from: FastServiceLoader.kt */
/* loaded from: classes4.dex */
public final class f {
    public static final f a = new f();

    private f() {
    }

    private final <S> S a(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Throwable, java.lang.Object, java.lang.String] */
    private final List<String> d(URL url) {
        boolean A;
        String m0;
        String r0;
        String m02;
        String url2 = url.toString();
        j.b(url2, "url.toString()");
        th = 0;
        A = v.A(url2, "jar", false, 2, th);
        if (A) {
            m0 = w.m0(url2, "jar:file:", th, 2, th);
            r0 = w.r0(m0, '!', th, 2, th);
            m02 = w.m0(url2, "!/", th, 2, th);
            JarFile jarFile = new JarFile(r0, false);
            try {
                List<String> e2 = a.e(new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(m02)), "UTF-8")));
                jarFile.close();
                return e2;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        jarFile.close();
                        throw th2;
                    } catch (Throwable th3) {
                        b.a(th, th3);
                        throw th;
                    }
                }
            }
        } else {
            try {
                return a.e(new BufferedReader(new InputStreamReader(url.openStream())));
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
    }

    private final List<String> e(BufferedReader bufferedReader) {
        List<String> S;
        String s0;
        CharSequence t0;
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                s0 = w.s0(readLine, MqttTopic.MULTI_LEVEL_WILDCARD, null, 2, null);
                if (s0 != null) {
                    t0 = w.t0(s0);
                    String obj = t0.toString();
                    boolean z2 = false;
                    int i = 0;
                    while (true) {
                        if (i >= obj.length()) {
                            z = true;
                            break;
                        }
                        char charAt = obj.charAt(i);
                        if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                            z = false;
                            break;
                        }
                        i++;
                    }
                    if (z) {
                        if (obj.length() > 0) {
                            z2 = true;
                        }
                        if (z2) {
                            linkedHashSet.add(obj);
                        }
                    } else {
                        throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
            } else {
                S = kotlin.collections.v.S(linkedHashSet);
                return S;
            }
        }
    }

    public final <S> List<S> b(Class<S> service, ClassLoader loader) {
        List<S> S;
        j.f(service, "service");
        j.f(loader, "loader");
        try {
            return c(service, loader);
        } catch (Throwable unused) {
            ServiceLoader load = ServiceLoader.load(service, loader);
            j.b(load, "ServiceLoader.load(service, loader)");
            S = kotlin.collections.v.S(load);
            return S;
        }
    }

    public final <S> List<S> c(Class<S> service, ClassLoader loader) {
        Set<String> V;
        int l;
        j.f(service, "service");
        j.f(loader, "loader");
        Enumeration<URL> urls = loader.getResources("META-INF/services/" + service.getName());
        j.b(urls, "urls");
        ArrayList<URL> list = Collections.list(urls);
        j.b(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL it : list) {
            f fVar = a;
            j.b(it, "it");
            s.p(arrayList, fVar.d(it));
        }
        V = kotlin.collections.v.V(arrayList);
        if (!V.isEmpty()) {
            l = o.l(V, 10);
            ArrayList arrayList2 = new ArrayList(l);
            for (String str : V) {
                arrayList2.add(a.a(str, loader, service));
            }
            return arrayList2;
        }
        throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
    }
}
