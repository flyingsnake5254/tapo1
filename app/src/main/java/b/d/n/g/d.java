package b.d.n.g;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import b.d.n.i.e;
import b.d.n.i.h;
import b.d.n.j.f;
import com.bumptech.glide.load.engine.j;
import com.tplink.libtpinappmessaging.model.IAMException;
import io.reactivex.v;
import java.io.File;
import java.lang.ref.WeakReference;

/* compiled from: IAMDisplayImp.java */
/* loaded from: classes3.dex */
public class d implements e {
    private static final String a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private h f590b;

    /* renamed from: c  reason: collision with root package name */
    private Application f591c;

    /* renamed from: d  reason: collision with root package name */
    private LayoutInflater f592d;

    /* renamed from: e  reason: collision with root package name */
    private CountDownTimer f593e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Activity> f594f;
    private boolean g;
    private View h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IAMDisplayImp.java */
    /* loaded from: classes3.dex */
    public class a implements v<com.tplink.libtpinappmessaging.model.c> {
        a() {
        }

        /* renamed from: a */
        public void onNext(com.tplink.libtpinappmessaging.model.c cVar) {
            if (cVar instanceof com.tplink.libtpinappmessaging.model.e) {
                d.this.k(cVar);
            }
        }

        @Override // io.reactivex.v
        public void onComplete() {
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IAMDisplayImp.java */
    /* loaded from: classes3.dex */
    public class b implements v<com.tplink.libtpinappmessaging.model.c> {
        b() {
        }

        /* renamed from: a */
        public void onNext(com.tplink.libtpinappmessaging.model.c cVar) {
            d.this.j(cVar);
        }

        @Override // io.reactivex.v
        public void onComplete() {
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
            if (th instanceof IAMException) {
                IAMException iAMException = (IAMException) th;
                int errorCode = iAMException.getErrorCode();
                b.d.n.j.e.a(d.a + "Splash onError \n[msg]:" + iAMException.getMessage());
                if ((errorCode == -2 || errorCode == -3 || errorCode == -1) && d.this.f590b != null) {
                    d.this.f590b.onFinish();
                    d.this.f590b = null;
                }
            }
        }

        @Override // io.reactivex.v
        public void onSubscribe(io.reactivex.e0.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IAMDisplayImp.java */
    /* loaded from: classes3.dex */
    public class c extends CountDownTimer {
        final /* synthetic */ View a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(long j, long j2, View view) {
            super(j, j2);
            this.a = view;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (d.this.f590b != null) {
                if (!d.this.g) {
                    this.a.setVisibility(8);
                }
                d.this.f590b.onFinish();
                d.this.f590b = null;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }
    }

    public d(Application application, boolean z) {
        this.g = false;
        this.f591c = application;
        this.g = z;
        this.f592d = (LayoutInflater) application.getSystemService("layout_inflater");
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final com.tplink.libtpinappmessaging.model.c cVar) {
        if (this.f594f.get() != null) {
            b.d.n.j.d.c().e(cVar.c(), cVar.b(), cVar.a());
            Window window = this.f594f.get().getWindow();
            if (window != null) {
                View findViewById = window.getDecorView().findViewById(16908290);
                if (findViewById instanceof ViewGroup) {
                    final View inflate = this.f592d.inflate(b.d.n.b.layout_splash, (ViewGroup) null);
                    this.h = inflate;
                    ((ViewGroup) findViewById).addView(inflate);
                    inflate.setVisibility(0);
                    inflate.setAlpha(0.0f);
                    inflate.animate().alpha(1.0f).setDuration(300L).start();
                    ImageView imageView = (ImageView) inflate.findViewById(b.d.n.a.iv_splash);
                    TextView textView = (TextView) inflate.findViewById(b.d.n.a.tv_count);
                    if (cVar instanceof com.tplink.libtpinappmessaging.model.d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a);
                        sb.append(" rev \n[SplashMessage]:");
                        com.tplink.libtpinappmessaging.model.d dVar = (com.tplink.libtpinappmessaging.model.d) cVar;
                        sb.append(dVar.g());
                        b.d.n.j.e.b(sb.toString());
                        com.bumptech.glide.c.v(imageView).q(new File(dVar.g())).e0(true).f(j.f1459b).x0(imageView);
                        this.f593e = new c(5000L, 1000L, inflate).start();
                        textView.setOnClickListener(new View.OnClickListener() { // from class: b.d.n.g.a
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                d.this.n(inflate, view);
                            }
                        });
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: b.d.n.g.b
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                d.this.p(cVar, inflate, view);
                            }
                        });
                        return;
                    }
                    return;
                }
                l();
                return;
            }
            l();
            return;
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(com.tplink.libtpinappmessaging.model.c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(" rev \n[WebMessage]:");
        com.tplink.libtpinappmessaging.model.e eVar = (com.tplink.libtpinappmessaging.model.e) cVar;
        sb.append(eVar.g());
        b.d.n.j.e.b(sb.toString());
        Activity activity = b.d.n.j.a.b().c().get();
        if (activity != null && !activity.isDestroyed()) {
            new e(activity, eVar.g()).show();
            b.d.n.j.d.c().e(cVar.c(), cVar.b(), cVar.a());
        }
    }

    private void l() {
        h hVar = this.f590b;
        if (hVar != null) {
            hVar.onFinish();
            this.f590b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(View view, View view2) {
        if (this.f590b != null) {
            this.f593e.cancel();
            view.setVisibility(8);
            this.f590b.onFinish();
            this.f590b = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void p(com.tplink.libtpinappmessaging.model.c cVar, View view, View view2) {
        if (!TextUtils.isEmpty(((com.tplink.libtpinappmessaging.model.d) cVar).h())) {
            b.d.n.j.d.c().d(cVar.c(), cVar.b(), cVar.a());
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            com.tplink.libtpinappmessaging.model.d dVar = (com.tplink.libtpinappmessaging.model.d) cVar;
            intent.setData(Uri.parse(dVar.h()));
            intent.addFlags(268435456);
            if (intent.resolveActivity(this.f591c.getPackageManager()) != null) {
                if (this.f590b != null) {
                    this.f593e.cancel();
                    view.setVisibility(8);
                    this.f590b.onFinish();
                    this.f590b = null;
                }
                b.d.n.j.e.b(a + " jump url:" + dVar.h());
                this.f591c.startActivity(intent);
            }
        }
    }

    private void q() {
        f.a().l0(io.reactivex.l0.a.b(b.d.n.h.c.a())).C(c.f589c).y0(new a());
    }

    private void r() {
        f.b().l0(io.reactivex.l0.a.b(b.d.n.h.c.a())).y0(new b());
    }

    @Override // b.d.n.i.e
    public void b() {
        View view;
        if (this.g && (view = this.h) != null) {
            view.setVisibility(8);
        }
    }

    @Override // b.d.n.i.e
    public void c(h hVar) {
        this.f590b = hVar;
        r();
    }

    @Override // b.d.n.i.e
    public void d(Activity activity) {
        this.f594f = new WeakReference<>(activity);
    }
}
