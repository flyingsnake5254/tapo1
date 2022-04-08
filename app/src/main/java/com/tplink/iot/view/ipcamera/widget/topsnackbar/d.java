package com.tplink.iot.view.ipcamera.widget.topsnackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import java.lang.ref.WeakReference;

/* compiled from: SnackbarManager.java */
/* loaded from: classes2.dex */
class d {
    private static d a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f9461b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Handler f9462c = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: d  reason: collision with root package name */
    private c f9463d;

    /* renamed from: e  reason: collision with root package name */
    private c f9464e;

    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            d.this.f((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public interface b {
        String content();

        void dismiss(int i);

        View getParentView();

        void show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SnackbarManager.java */
    /* loaded from: classes2.dex */
    public static class c {
        private final WeakReference<b> a;

        /* renamed from: b  reason: collision with root package name */
        private int f9466b;

        c(int i, b bVar) {
            this.a = new WeakReference<>(bVar);
            this.f9466b = i;
        }

        boolean d(b bVar) {
            return bVar != null && this.a.get() == bVar;
        }
    }

    private d() {
    }

    private boolean b(c cVar, int i) {
        b bVar = (b) cVar.a.get();
        if (bVar == null) {
            return false;
        }
        this.f9462c.removeCallbacksAndMessages(cVar);
        bVar.dismiss(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d e() {
        if (a == null) {
            a = new d();
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(c cVar) {
        synchronized (this.f9461b) {
            if (this.f9463d == cVar || this.f9464e == cVar) {
                b(cVar, 2);
            }
        }
    }

    private boolean g(b bVar) {
        c cVar = this.f9463d;
        if (cVar == null) {
            return false;
        }
        b bVar2 = (b) cVar.a.get();
        if (bVar == null && bVar2 == null) {
            return true;
        }
        if (!(bVar == null || bVar2 == null)) {
            String content = bVar.content();
            String content2 = bVar2.content();
            if (content == null && content2 == null) {
                return true;
            }
            if (!(content == null || content2 == null)) {
                return content.equals(content2);
            }
        }
        return false;
    }

    private boolean i(b bVar) {
        c cVar = this.f9463d;
        return cVar != null && cVar.d(bVar);
    }

    private boolean j(b bVar) {
        c cVar = this.f9464e;
        return cVar != null && cVar.d(bVar);
    }

    private boolean k(b bVar) {
        c cVar = this.f9463d;
        if (cVar == null) {
            return false;
        }
        b bVar2 = (b) cVar.a.get();
        if (bVar == null && bVar2 == null) {
            return true;
        }
        return (bVar == null || bVar2 == null || bVar.getParentView() != bVar2.getParentView()) ? false : true;
    }

    private void o(c cVar) {
        if (cVar.f9466b != -2) {
            int i = 2750;
            if (cVar.f9466b > 0) {
                i = cVar.f9466b;
            } else if (cVar.f9466b == -1) {
                i = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
            }
            this.f9462c.removeCallbacksAndMessages(cVar);
            Handler handler = this.f9462c;
            handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i);
        }
    }

    private void q() {
        c cVar = this.f9464e;
        if (cVar != null) {
            this.f9463d = cVar;
            this.f9464e = null;
            b bVar = (b) cVar.a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f9463d = null;
            }
        }
    }

    public void c(b bVar) {
        synchronized (this.f9461b) {
            if (i(bVar)) {
                this.f9462c.removeCallbacksAndMessages(this.f9463d);
            }
        }
    }

    public void d(b bVar, int i) {
        synchronized (this.f9461b) {
            if (i(bVar)) {
                b(this.f9463d, i);
            } else if (j(bVar)) {
                b(this.f9464e, i);
            }
        }
    }

    public boolean h(b bVar) {
        boolean z;
        synchronized (this.f9461b) {
            if (!i(bVar) && !j(bVar)) {
                z = false;
            }
            z = true;
        }
        return z;
    }

    public void l(b bVar) {
        synchronized (this.f9461b) {
            if (i(bVar)) {
                this.f9463d = null;
                if (this.f9464e != null) {
                    q();
                }
            }
        }
    }

    public void m(b bVar) {
        synchronized (this.f9461b) {
            if (i(bVar)) {
                o(this.f9463d);
            }
        }
    }

    public void n(b bVar) {
        synchronized (this.f9461b) {
            if (i(bVar)) {
                o(this.f9463d);
            }
        }
    }

    public void p(int i, b bVar) {
        synchronized (this.f9461b) {
            if (!i(bVar) && (!g(bVar) || !k(bVar))) {
                if (j(bVar)) {
                    this.f9464e.f9466b = i;
                } else {
                    this.f9464e = new c(i, bVar);
                }
                c cVar = this.f9463d;
                if (cVar == null || !b(cVar, 4)) {
                    this.f9463d = null;
                    q();
                }
                return;
            }
            this.f9463d.f9466b = i;
            this.f9462c.removeCallbacksAndMessages(this.f9463d);
            o(this.f9463d);
        }
    }
}
