package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.r;
import java.util.List;

/* loaded from: classes.dex */
public class ShapeStroke implements b {
    private final String a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final b f968b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f969c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.i.a f970d;

    /* renamed from: e  reason: collision with root package name */
    private final d f971e;

    /* renamed from: f  reason: collision with root package name */
    private final b f972f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;
    private final boolean j;

    /* loaded from: classes.dex */
    public enum LineCapType {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap toPaintCap() {
            int i = a.a[ordinal()];
            if (i == 1) {
                return Paint.Cap.BUTT;
            }
            if (i != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* loaded from: classes.dex */
    public enum LineJoinType {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join toPaintJoin() {
            int i = a.f973b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f973b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            f973b = iArr;
            try {
                iArr[LineJoinType.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f973b[LineJoinType.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f973b[LineJoinType.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            a = iArr2;
            try {
                iArr2[LineCapType.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LineCapType.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LineCapType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, @Nullable b bVar, List<b> list, com.airbnb.lottie.model.i.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType, float f2, boolean z) {
        this.a = str;
        this.f968b = bVar;
        this.f969c = list;
        this.f970d = aVar;
        this.f971e = dVar;
        this.f972f = bVar2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f2;
        this.j = z;
    }

    @Override // com.airbnb.lottie.model.content.b
    public c a(f fVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(fVar, aVar, this);
    }

    public LineCapType b() {
        return this.g;
    }

    public com.airbnb.lottie.model.i.a c() {
        return this.f970d;
    }

    public b d() {
        return this.f968b;
    }

    public LineJoinType e() {
        return this.h;
    }

    public List<b> f() {
        return this.f969c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public d i() {
        return this.f971e;
    }

    public b j() {
        return this.f972f;
    }

    public boolean k() {
        return this.j;
    }
}
