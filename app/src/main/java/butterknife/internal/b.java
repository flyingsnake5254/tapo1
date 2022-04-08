package butterknife.internal;

import android.view.View;

/* compiled from: DebouncingOnClickListener.java */
/* loaded from: classes.dex */
public abstract class b implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    static boolean f864c = true;

    /* renamed from: d  reason: collision with root package name */
    private static final Runnable f865d = a.f863c;

    public abstract void a(View view);

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (f864c) {
            f864c = false;
            view.post(f865d);
            a(view);
        }
    }
}
