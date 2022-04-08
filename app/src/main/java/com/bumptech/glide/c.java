package com.bumptech.glide;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.d;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.engine.a0.h;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.z.b;
import com.bumptech.glide.load.engine.z.e;
import com.bumptech.glide.load.j.a;
import com.bumptech.glide.load.j.b;
import com.bumptech.glide.load.j.d;
import com.bumptech.glide.load.j.e;
import com.bumptech.glide.load.j.f;
import com.bumptech.glide.load.j.k;
import com.bumptech.glide.load.j.s;
import com.bumptech.glide.load.j.t;
import com.bumptech.glide.load.j.u;
import com.bumptech.glide.load.j.v;
import com.bumptech.glide.load.j.w;
import com.bumptech.glide.load.j.x;
import com.bumptech.glide.load.j.y.a;
import com.bumptech.glide.load.j.y.b;
import com.bumptech.glide.load.j.y.c;
import com.bumptech.glide.load.j.y.d;
import com.bumptech.glide.load.j.y.e;
import com.bumptech.glide.load.k.d.a;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.a0;
import com.bumptech.glide.load.resource.bitmap.n;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.x;
import com.bumptech.glide.load.resource.bitmap.z;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.i;
import com.bumptech.glide.manager.d;
import com.bumptech.glide.manager.p;
import com.bumptech.glide.request.f;
import com.bumptech.glide.request.g;
import com.bumptech.glide.util.j;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Glide.java */
/* loaded from: classes.dex */
public class c implements ComponentCallbacks2 {
    @GuardedBy("Glide.class")

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f1282c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile boolean f1283d;
    private final a H3;

    /* renamed from: f  reason: collision with root package name */
    private final k f1284f;
    private final b p0;
    private final p p1;
    private final d p2;
    private final e q;
    private final h x;
    private final e y;
    private final Registry z;
    @GuardedBy("managers")
    private final List<i> p3 = new ArrayList();
    private MemoryCategory I3 = MemoryCategory.NORMAL;

    /* compiled from: Glide.java */
    /* loaded from: classes.dex */
    public interface a {
        @NonNull
        g build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull k kVar, @NonNull h hVar, @NonNull e eVar, @NonNull b bVar, @NonNull p pVar, @NonNull d dVar, int i, @NonNull a aVar, @NonNull Map<Class<?>, j<?, ?>> map, @NonNull List<f<Object>> list, f fVar) {
        com.bumptech.glide.load.resource.bitmap.h hVar2;
        com.bumptech.glide.load.g gVar;
        this.f1284f = kVar;
        this.q = eVar;
        this.p0 = bVar;
        this.x = hVar;
        this.p1 = pVar;
        this.p2 = dVar;
        this.H3 = aVar;
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.z = registry;
        registry.o(new DefaultImageHeaderParser());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 27) {
            registry.o(new n());
        }
        List<ImageHeaderParser> g = registry.g();
        com.bumptech.glide.load.resource.gif.a aVar2 = new com.bumptech.glide.load.resource.gif.a(context, g, eVar, bVar);
        com.bumptech.glide.load.g<ParcelFileDescriptor, Bitmap> h = a0.h(eVar);
        com.bumptech.glide.load.resource.bitmap.k kVar2 = new com.bumptech.glide.load.resource.bitmap.k(registry.g(), resources.getDisplayMetrics(), eVar, bVar);
        if (!fVar.a(d.c.class) || i2 < 28) {
            com.bumptech.glide.load.resource.bitmap.g gVar2 = new com.bumptech.glide.load.resource.bitmap.g(kVar2);
            gVar = new x(kVar2, bVar);
            hVar2 = gVar2;
        } else {
            gVar = new r();
            hVar2 = new com.bumptech.glide.load.resource.bitmap.h();
        }
        com.bumptech.glide.load.k.e.d dVar2 = new com.bumptech.glide.load.k.e.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        com.bumptech.glide.load.resource.bitmap.c cVar2 = new com.bumptech.glide.load.resource.bitmap.c(bVar);
        com.bumptech.glide.load.k.g.a aVar4 = new com.bumptech.glide.load.k.g.a();
        com.bumptech.glide.load.k.g.d dVar4 = new com.bumptech.glide.load.k.g.d();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new com.bumptech.glide.load.j.c()).a(InputStream.class, new t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, hVar2).e("Bitmap", InputStream.class, Bitmap.class, gVar);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.t(kVar2));
        }
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, h).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, a0.c(eVar)).d(Bitmap.class, Bitmap.class, v.a.b()).e("Bitmap", Bitmap.class, Bitmap.class, new z()).b(Bitmap.class, cVar2).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, hVar2)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, gVar)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, h)).b(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(eVar, cVar2)).e("Gif", InputStream.class, GifDrawable.class, new i(g, aVar2, bVar)).e("Gif", ByteBuffer.class, GifDrawable.class, aVar2).b(GifDrawable.class, new com.bumptech.glide.load.resource.gif.c()).d(com.bumptech.glide.l.a.class, com.bumptech.glide.l.a.class, v.a.b()).e("Bitmap", com.bumptech.glide.l.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.g(eVar)).c(Uri.class, Drawable.class, dVar2).c(Uri.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.v(dVar2, eVar)).p(new a.C0061a()).d(File.class, ByteBuffer.class, new d.b()).d(File.class, InputStream.class, new f.e()).c(File.class, File.class, new com.bumptech.glide.load.k.f.a()).d(File.class, ParcelFileDescriptor.class, new f.b()).d(File.class, File.class, v.a.b()).p(new k.a(bVar));
        if (ParcelFileDescriptorRewinder.c()) {
            registry.p(new ParcelFileDescriptorRewinder.a());
        }
        Class cls = Integer.TYPE;
        registry.d(cls, InputStream.class, cVar).d(cls, ParcelFileDescriptor.class, bVar2).d(Integer.class, InputStream.class, cVar).d(Integer.class, ParcelFileDescriptor.class, bVar2).d(Integer.class, Uri.class, dVar3).d(cls, AssetFileDescriptor.class, aVar3).d(Integer.class, AssetFileDescriptor.class, aVar3).d(cls, Uri.class, dVar3).d(String.class, InputStream.class, new e.c()).d(Uri.class, InputStream.class, new e.c()).d(String.class, InputStream.class, new u.c()).d(String.class, ParcelFileDescriptor.class, new u.b()).d(String.class, AssetFileDescriptor.class, new u.a()).d(Uri.class, InputStream.class, new a.c(context.getAssets())).d(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).d(Uri.class, InputStream.class, new b.a(context)).d(Uri.class, InputStream.class, new c.a(context));
        if (i2 >= 29) {
            registry.d(Uri.class, InputStream.class, new d.c(context));
            registry.d(Uri.class, ParcelFileDescriptor.class, new d.b(context));
        }
        registry.d(Uri.class, InputStream.class, new w.d(contentResolver)).d(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).d(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).d(Uri.class, InputStream.class, new x.a()).d(URL.class, InputStream.class, new e.a()).d(Uri.class, File.class, new k.a(context)).d(com.bumptech.glide.load.j.g.class, InputStream.class, new a.C0057a()).d(byte[].class, ByteBuffer.class, new b.a()).d(byte[].class, InputStream.class, new b.d()).d(Uri.class, Uri.class, v.a.b()).d(Drawable.class, Drawable.class, v.a.b()).c(Drawable.class, Drawable.class, new com.bumptech.glide.load.k.e.e()).q(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.k.g.b(resources)).q(Bitmap.class, byte[].class, aVar4).q(Drawable.class, byte[].class, new com.bumptech.glide.load.k.g.c(eVar, aVar4, dVar4)).q(GifDrawable.class, byte[].class, dVar4);
        if (i2 >= 23) {
            com.bumptech.glide.load.g<ByteBuffer, Bitmap> d2 = a0.d(eVar);
            registry.c(ByteBuffer.class, Bitmap.class, d2);
            registry.c(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(resources, d2));
        }
        this.y = new e(context, bVar, registry, new com.bumptech.glide.request.k.g(), aVar, map, list, kVar, fVar, i);
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (!f1283d) {
            f1283d = true;
            m(context, generatedAppGlideModule);
            f1283d = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    @NonNull
    public static c c(@NonNull Context context) {
        if (f1282c == null) {
            GeneratedAppGlideModule d2 = d(context.getApplicationContext());
            synchronized (c.class) {
                if (f1282c == null) {
                    a(context, d2);
                }
            }
        }
        return f1282c;
    }

    @Nullable
    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e2) {
            q(e2);
            return null;
        } catch (InstantiationException e3) {
            q(e3);
            return null;
        } catch (NoSuchMethodException e4) {
            q(e4);
            return null;
        } catch (InvocationTargetException e5) {
            q(e5);
            return null;
        }
    }

    @NonNull
    private static p l(@Nullable Context context) {
        com.bumptech.glide.util.i.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    @GuardedBy("Glide.class")
    private static void m(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new d(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    private static void n(@NonNull Context context, @NonNull d dVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<com.bumptech.glide.m.b> emptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            emptyList = new com.bumptech.glide.m.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> d2 = generatedAppGlideModule.d();
            Iterator<com.bumptech.glide.m.b> it = emptyList.iterator();
            while (it.hasNext()) {
                com.bumptech.glide.m.b next = it.next();
                if (d2.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<com.bumptech.glide.m.b> it2 = emptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        dVar.d(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        for (com.bumptech.glide.m.b bVar : emptyList) {
            bVar.a(applicationContext, dVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, dVar);
        }
        c a2 = dVar.a(applicationContext);
        for (com.bumptech.glide.m.b bVar2 : emptyList) {
            try {
                bVar2.b(applicationContext, a2, a2.z);
            } catch (AbstractMethodError e2) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar2.getClass().getName(), e2);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, a2, a2.z);
        }
        applicationContext.registerComponentCallbacks(a2);
        f1282c = a2;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static i t(@NonNull Activity activity) {
        return l(activity).j(activity);
    }

    @NonNull
    public static i u(@NonNull Context context) {
        return l(context).l(context);
    }

    @NonNull
    public static i v(@NonNull View view) {
        return l(view.getContext()).m(view);
    }

    @NonNull
    public static i w(@NonNull Fragment fragment) {
        return l(fragment.getContext()).n(fragment);
    }

    @NonNull
    public static i x(@NonNull FragmentActivity fragmentActivity) {
        return l(fragmentActivity).o(fragmentActivity);
    }

    public void b() {
        j.b();
        this.x.b();
        this.q.b();
        this.p0.b();
    }

    @NonNull
    public com.bumptech.glide.load.engine.z.b e() {
        return this.p0;
    }

    @NonNull
    public com.bumptech.glide.load.engine.z.e f() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bumptech.glide.manager.d g() {
        return this.p2;
    }

    @NonNull
    public Context h() {
        return this.y.getBaseContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public e i() {
        return this.y;
    }

    @NonNull
    public Registry j() {
        return this.z;
    }

    @NonNull
    public p k() {
        return this.p1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(i iVar) {
        synchronized (this.p3) {
            if (!this.p3.contains(iVar)) {
                this.p3.add(iVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        r(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p(@NonNull com.bumptech.glide.request.k.j<?> jVar) {
        synchronized (this.p3) {
            for (i iVar : this.p3) {
                if (iVar.z(jVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i) {
        j.b();
        synchronized (this.p3) {
            for (i iVar : this.p3) {
                iVar.onTrimMemory(i);
            }
        }
        this.x.a(i);
        this.q.a(i);
        this.p0.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(i iVar) {
        synchronized (this.p3) {
            if (this.p3.contains(iVar)) {
                this.p3.remove(iVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }
}
