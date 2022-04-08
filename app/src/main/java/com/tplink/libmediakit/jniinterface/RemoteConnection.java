package com.tplink.libmediakit.jniinterface;

/* loaded from: classes3.dex */
public class RemoteConnection {

    /* loaded from: classes3.dex */
    private static class b {
        private static final RemoteConnection a = new RemoteConnection();
    }

    static {
        System.loadLibrary("remote-connection-lib");
    }

    public static RemoteConnection d() {
        return b.a;
    }

    private native void initP2P();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Integer] */
    /* renamed from: j */
    public /* synthetic */ void k(b.d.p.e.a aVar, int i, String str) {
        aVar.a = Integer.valueOf(p2pConnectionBuild(i, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Integer] */
    /* renamed from: l */
    public /* synthetic */ void m(b.d.p.e.a aVar, String str) {
        aVar.a = Integer.valueOf(p2pConfigCreate(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Integer] */
    /* renamed from: n */
    public /* synthetic */ void o(b.d.p.e.a aVar, int i) {
        aVar.a = Integer.valueOf(p2pGetError(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Integer] */
    /* renamed from: p */
    public /* synthetic */ void q(b.d.p.e.a aVar) {
        aVar.a = Integer.valueOf(p2pNatTypeApp());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p2pBreakDestroy */
    public native void h(int i);

    private native int p2pConfigCreate(String str);

    private native int p2pConnectionBuild(int i, String str);

    private native int p2pGetError(int i);

    private native int p2pNatTypeApp();

    private native int p2pNatTypeDut(String str);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Integer] */
    /* renamed from: r */
    public /* synthetic */ void s(b.d.p.e.a aVar, String str) {
        aVar.a = Integer.valueOf(p2pNatTypeDut(str));
    }

    private void t(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable unused) {
        }
    }

    public void a(final int i) {
        t(new Runnable() { // from class: com.tplink.libmediakit.jniinterface.f
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConnection.this.i(i);
            }
        });
    }

    public int b(final int i, final String str) {
        final b.d.p.e.a aVar = new b.d.p.e.a(-1);
        t(new Runnable() { // from class: com.tplink.libmediakit.jniinterface.b
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConnection.this.k(aVar, i, str);
            }
        });
        return ((Integer) aVar.a).intValue();
    }

    public int c(final String str) {
        final b.d.p.e.a aVar = new b.d.p.e.a(-1);
        t(new Runnable() { // from class: com.tplink.libmediakit.jniinterface.c
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConnection.this.m(aVar, str);
            }
        });
        return ((Integer) aVar.a).intValue();
    }

    public int e(final int i) {
        final b.d.p.e.a aVar = new b.d.p.e.a(-1);
        t(new Runnable() { // from class: com.tplink.libmediakit.jniinterface.a
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConnection.this.o(aVar, i);
            }
        });
        return ((Integer) aVar.a).intValue();
    }

    public int f() {
        final b.d.p.e.a aVar = new b.d.p.e.a(-1);
        t(new Runnable() { // from class: com.tplink.libmediakit.jniinterface.e
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConnection.this.q(aVar);
            }
        });
        return ((Integer) aVar.a).intValue();
    }

    public int g(final String str) {
        final b.d.p.e.a aVar = new b.d.p.e.a(-1);
        t(new Runnable() { // from class: com.tplink.libmediakit.jniinterface.d
            @Override // java.lang.Runnable
            public final void run() {
                RemoteConnection.this.s(aVar, str);
            }
        });
        return ((Integer) aVar.a).intValue();
    }

    private RemoteConnection() {
        initP2P();
    }
}
