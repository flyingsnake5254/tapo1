package com.airbnb.lottie.s.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: MergePathsContent.java */
@TargetApi(19)
/* loaded from: classes.dex */
public class l implements m, j {

    /* renamed from: d  reason: collision with root package name */
    private final String f1082d;

    /* renamed from: f  reason: collision with root package name */
    private final MergePaths f1084f;
    private final Path a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Path f1080b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f1081c = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final List<m> f1083e = new ArrayList();

    /* compiled from: MergePathsContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[MergePaths.MergePathsMode.values().length];
            a = iArr;
            try {
                iArr[MergePaths.MergePathsMode.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[MergePaths.MergePathsMode.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[MergePaths.MergePathsMode.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[MergePaths.MergePathsMode.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[MergePaths.MergePathsMode.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(MergePaths mergePaths) {
        if (Build.VERSION.SDK_INT >= 19) {
            this.f1082d = mergePaths.c();
            this.f1084f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    private void a() {
        for (int i = 0; i < this.f1083e.size(); i++) {
            this.f1081c.addPath(this.f1083e.get(i).getPath());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.f1080b.reset();
        this.a.reset();
        for (int size = this.f1083e.size() - 1; size >= 1; size--) {
            m mVar = this.f1083e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List<m> i = dVar.i();
                for (int size2 = i.size() - 1; size2 >= 0; size2--) {
                    Path path = i.get(size2).getPath();
                    path.transform(dVar.j());
                    this.f1080b.addPath(path);
                }
            } else {
                this.f1080b.addPath(mVar.getPath());
            }
        }
        m mVar2 = this.f1083e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List<m> i2 = dVar2.i();
            for (int i3 = 0; i3 < i2.size(); i3++) {
                Path path2 = i2.get(i3).getPath();
                path2.transform(dVar2.j());
                this.a.addPath(path2);
            }
        } else {
            this.a.set(mVar2.getPath());
        }
        this.f1081c.op(this.a, this.f1080b, op);
    }

    @Override // com.airbnb.lottie.s.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < this.f1083e.size(); i++) {
            this.f1083e.get(i).b(list, list2);
        }
    }

    @Override // com.airbnb.lottie.s.b.j
    public void f(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c previous = listIterator.previous();
            if (previous instanceof m) {
                this.f1083e.add((m) previous);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.s.b.m
    public Path getPath() {
        this.f1081c.reset();
        if (this.f1084f.d()) {
            return this.f1081c;
        }
        int i = a.a[this.f1084f.b().ordinal()];
        if (i == 1) {
            a();
        } else if (i == 2) {
            c(Path.Op.UNION);
        } else if (i == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            c(Path.Op.INTERSECT);
        } else if (i == 5) {
            c(Path.Op.XOR);
        }
        return this.f1081c;
    }
}
