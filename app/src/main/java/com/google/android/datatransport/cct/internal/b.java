package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

/* compiled from: AutoBatchedLogRequestEncoder.java */
/* loaded from: classes.dex */
public final class b implements Configurator {
    public static final Configurator a = new b();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class a implements ObjectEncoder<a> {
        static final a a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f1798b = FieldDescriptor.of("sdkVersion");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f1799c = FieldDescriptor.of("model");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f1800d = FieldDescriptor.of("hardware");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f1801e = FieldDescriptor.of("device");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f1802f = FieldDescriptor.of("product");
        private static final FieldDescriptor g = FieldDescriptor.of("osBuild");
        private static final FieldDescriptor h = FieldDescriptor.of("manufacturer");
        private static final FieldDescriptor i = FieldDescriptor.of("fingerprint");
        private static final FieldDescriptor j = FieldDescriptor.of("locale");
        private static final FieldDescriptor k = FieldDescriptor.of("country");
        private static final FieldDescriptor l = FieldDescriptor.of("mccMnc");
        private static final FieldDescriptor m = FieldDescriptor.of("applicationBuild");

        private a() {
        }

        /* renamed from: a */
        public void encode(a aVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1798b, aVar.m());
            objectEncoderContext.add(f1799c, aVar.j());
            objectEncoderContext.add(f1800d, aVar.f());
            objectEncoderContext.add(f1801e, aVar.d());
            objectEncoderContext.add(f1802f, aVar.l());
            objectEncoderContext.add(g, aVar.k());
            objectEncoderContext.add(h, aVar.h());
            objectEncoderContext.add(i, aVar.e());
            objectEncoderContext.add(j, aVar.g());
            objectEncoderContext.add(k, aVar.c());
            objectEncoderContext.add(l, aVar.i());
            objectEncoderContext.add(m, aVar.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: com.google.android.datatransport.cct.internal.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0070b implements ObjectEncoder<j> {
        static final C0070b a = new C0070b();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f1803b = FieldDescriptor.of("logRequest");

        private C0070b() {
        }

        /* renamed from: a */
        public void encode(j jVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1803b, jVar.c());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class c implements ObjectEncoder<ClientInfo> {
        static final c a = new c();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f1804b = FieldDescriptor.of("clientType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f1805c = FieldDescriptor.of("androidClientInfo");

        private c() {
        }

        /* renamed from: a */
        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1804b, clientInfo.c());
            objectEncoderContext.add(f1805c, clientInfo.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class d implements ObjectEncoder<k> {
        static final d a = new d();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f1806b = FieldDescriptor.of("eventTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f1807c = FieldDescriptor.of("eventCode");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f1808d = FieldDescriptor.of("eventUptimeMs");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f1809e = FieldDescriptor.of("sourceExtension");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f1810f = FieldDescriptor.of("sourceExtensionJsonProto3");
        private static final FieldDescriptor g = FieldDescriptor.of("timezoneOffsetSeconds");
        private static final FieldDescriptor h = FieldDescriptor.of("networkConnectionInfo");

        private d() {
        }

        /* renamed from: a */
        public void encode(k kVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1806b, kVar.c());
            objectEncoderContext.add(f1807c, kVar.b());
            objectEncoderContext.add(f1808d, kVar.d());
            objectEncoderContext.add(f1809e, kVar.f());
            objectEncoderContext.add(f1810f, kVar.g());
            objectEncoderContext.add(g, kVar.h());
            objectEncoderContext.add(h, kVar.e());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class e implements ObjectEncoder<l> {
        static final e a = new e();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f1811b = FieldDescriptor.of("requestTimeMs");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f1812c = FieldDescriptor.of("requestUptimeMs");

        /* renamed from: d  reason: collision with root package name */
        private static final FieldDescriptor f1813d = FieldDescriptor.of("clientInfo");

        /* renamed from: e  reason: collision with root package name */
        private static final FieldDescriptor f1814e = FieldDescriptor.of("logSource");

        /* renamed from: f  reason: collision with root package name */
        private static final FieldDescriptor f1815f = FieldDescriptor.of("logSourceName");
        private static final FieldDescriptor g = FieldDescriptor.of("logEvent");
        private static final FieldDescriptor h = FieldDescriptor.of("qosTier");

        private e() {
        }

        /* renamed from: a */
        public void encode(l lVar, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1811b, lVar.g());
            objectEncoderContext.add(f1812c, lVar.h());
            objectEncoderContext.add(f1813d, lVar.b());
            objectEncoderContext.add(f1814e, lVar.d());
            objectEncoderContext.add(f1815f, lVar.e());
            objectEncoderContext.add(g, lVar.c());
            objectEncoderContext.add(h, lVar.f());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes.dex */
    private static final class f implements ObjectEncoder<NetworkConnectionInfo> {
        static final f a = new f();

        /* renamed from: b  reason: collision with root package name */
        private static final FieldDescriptor f1816b = FieldDescriptor.of("networkType");

        /* renamed from: c  reason: collision with root package name */
        private static final FieldDescriptor f1817c = FieldDescriptor.of("mobileSubtype");

        private f() {
        }

        /* renamed from: a */
        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(f1816b, networkConnectionInfo.c());
            objectEncoderContext.add(f1817c, networkConnectionInfo.b());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.config.Configurator
    public void configure(EncoderConfig<?> encoderConfig) {
        C0070b bVar = C0070b.a;
        encoderConfig.registerEncoder(j.class, bVar);
        encoderConfig.registerEncoder(d.class, bVar);
        e eVar = e.a;
        encoderConfig.registerEncoder(l.class, eVar);
        encoderConfig.registerEncoder(g.class, eVar);
        c cVar = c.a;
        encoderConfig.registerEncoder(ClientInfo.class, cVar);
        encoderConfig.registerEncoder(e.class, cVar);
        a aVar = a.a;
        encoderConfig.registerEncoder(a.class, aVar);
        encoderConfig.registerEncoder(c.class, aVar);
        d dVar = d.a;
        encoderConfig.registerEncoder(k.class, dVar);
        encoderConfig.registerEncoder(f.class, dVar);
        f fVar = f.a;
        encoderConfig.registerEncoder(NetworkConnectionInfo.class, fVar);
        encoderConfig.registerEncoder(i.class, fVar);
    }
}
