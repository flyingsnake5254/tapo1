package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.AttrRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.v.h;
import com.github.mikephil.charting.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: c  reason: collision with root package name */
    private static final String f878c = LottieAnimationView.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private static final h<Throwable> f879d = new a();
    @Nullable
    private m<d> O3;
    @Nullable
    private d P3;
    private boolean p0;
    private String p1;
    @RawRes
    private int p2;
    @Nullable
    private h<Throwable> x;

    /* renamed from: f  reason: collision with root package name */
    private final h<d> f880f = new b();
    private final h<Throwable> q = new c();
    @DrawableRes
    private int y = 0;
    private final f z = new f();
    private boolean p3 = false;
    private boolean H3 = false;
    private boolean I3 = false;
    private boolean J3 = false;
    private boolean K3 = true;
    private RenderMode L3 = RenderMode.AUTOMATIC;
    private Set<j> M3 = new HashSet();
    private int N3 = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        String f881c;

        /* renamed from: d  reason: collision with root package name */
        int f882d;

        /* renamed from: f  reason: collision with root package name */
        float f883f;
        boolean q;
        String x;
        int y;
        int z;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f881c);
            parcel.writeFloat(this.f883f);
            parcel.writeInt(this.q ? 1 : 0);
            parcel.writeString(this.x);
            parcel.writeInt(this.y);
            parcel.writeInt(this.z);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f881c = parcel.readString();
            this.f883f = parcel.readFloat();
            this.q = parcel.readInt() != 1 ? false : true;
            this.x = parcel.readString();
            this.y = parcel.readInt();
            this.z = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements h<Throwable> {
        a() {
        }

        /* renamed from: b */
        public void a(Throwable th) {
            if (h.k(th)) {
                com.airbnb.lottie.v.d.d("Unable to load composition.", th);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* loaded from: classes.dex */
    class b implements h<d> {
        b() {
        }

        /* renamed from: b */
        public void a(d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    /* loaded from: classes.dex */
    class c implements h<Throwable> {
        c() {
        }

        /* renamed from: b */
        public void a(Throwable th) {
            if (LottieAnimationView.this.y != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.y);
            }
            (LottieAnimationView.this.x == null ? LottieAnimationView.f879d : LottieAnimationView.this.x).a(th);
        }
    }

    /* loaded from: classes.dex */
    class d extends com.airbnb.lottie.w.c<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.airbnb.lottie.w.e f884d;

        d(com.airbnb.lottie.w.e eVar) {
            this.f884d = eVar;
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // com.airbnb.lottie.w.c
        public T a(com.airbnb.lottie.w.b<T> bVar) {
            return this.f884d.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class e {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        l(null, o.lottieAnimationViewStyle);
    }

    private void h() {
        m<d> mVar = this.O3;
        if (mVar != null) {
            mVar.k(this.f880f);
            this.O3.j(this.q);
        }
    }

    private void i() {
        this.P3 = null;
        this.z.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if (r3 != false) goto L_0x003d;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            r5 = this;
            int[] r0 = com.airbnb.lottie.LottieAnimationView.e.a
            com.airbnb.lottie.RenderMode r1 = r5.L3
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r1 = 2
            r2 = 1
            if (r0 == r2) goto L_0x003d
            if (r0 == r1) goto L_0x0013
            r3 = 3
            if (r0 == r3) goto L_0x0015
        L_0x0013:
            r1 = 1
            goto L_0x003d
        L_0x0015:
            com.airbnb.lottie.d r0 = r5.P3
            r3 = 0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.p()
            if (r0 == 0) goto L_0x0027
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 >= r4) goto L_0x0027
            goto L_0x003b
        L_0x0027:
            com.airbnb.lottie.d r0 = r5.P3
            if (r0 == 0) goto L_0x0033
            int r0 = r0.l()
            r4 = 4
            if (r0 <= r4) goto L_0x0033
            goto L_0x003b
        L_0x0033:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r0 >= r4) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r3 = 1
        L_0x003b:
            if (r3 == 0) goto L_0x0013
        L_0x003d:
            int r0 = r5.getLayerType()
            if (r1 == r0) goto L_0x0047
            r0 = 0
            r5.setLayerType(r1, r0)
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.LottieAnimationView.k():void");
    }

    private void l(@Nullable AttributeSet attributeSet, @AttrRes int i) {
        String string;
        boolean z = false;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.LottieAnimationView, i, 0);
        if (!isInEditMode()) {
            this.K3 = obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_cacheComposition, true);
            int i2 = p.LottieAnimationView_lottie_rawRes;
            boolean hasValue = obtainStyledAttributes.hasValue(i2);
            int i3 = p.LottieAnimationView_lottie_fileName;
            boolean hasValue2 = obtainStyledAttributes.hasValue(i3);
            int i4 = p.LottieAnimationView_lottie_url;
            boolean hasValue3 = obtainStyledAttributes.hasValue(i4);
            if (!hasValue || !hasValue2) {
                if (hasValue) {
                    int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        setAnimation(resourceId);
                    }
                } else if (hasValue2) {
                    String string2 = obtainStyledAttributes.getString(i3);
                    if (string2 != null) {
                        setAnimation(string2);
                    }
                } else if (hasValue3 && (string = obtainStyledAttributes.getString(i4)) != null) {
                    setAnimationFromUrl(string);
                }
                setFallbackResource(obtainStyledAttributes.getResourceId(p.LottieAnimationView_lottie_fallbackRes, 0));
            } else {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_autoPlay, false)) {
            this.I3 = true;
            this.J3 = true;
        }
        if (obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_loop, false)) {
            this.z.a0(-1);
        }
        int i5 = p.LottieAnimationView_lottie_repeatMode;
        if (obtainStyledAttributes.hasValue(i5)) {
            setRepeatMode(obtainStyledAttributes.getInt(i5, 1));
        }
        int i6 = p.LottieAnimationView_lottie_repeatCount;
        if (obtainStyledAttributes.hasValue(i6)) {
            setRepeatCount(obtainStyledAttributes.getInt(i6, -1));
        }
        int i7 = p.LottieAnimationView_lottie_speed;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSpeed(obtainStyledAttributes.getFloat(i7, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(p.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(p.LottieAnimationView_lottie_progress, 0.0f));
        j(obtainStyledAttributes.getBoolean(p.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        int i8 = p.LottieAnimationView_lottie_colorFilter;
        if (obtainStyledAttributes.hasValue(i8)) {
            e(new com.airbnb.lottie.model.d("**"), k.C, new com.airbnb.lottie.w.c(new q(obtainStyledAttributes.getColor(i8, 0))));
        }
        int i9 = p.LottieAnimationView_lottie_scale;
        if (obtainStyledAttributes.hasValue(i9)) {
            this.z.d0(obtainStyledAttributes.getFloat(i9, 1.0f));
        }
        int i10 = p.LottieAnimationView_lottie_renderMode;
        if (obtainStyledAttributes.hasValue(i10)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i11 = obtainStyledAttributes.getInt(i10, renderMode.ordinal());
            if (i11 >= RenderMode.values().length) {
                i11 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i11]);
        }
        if (getScaleType() != null) {
            this.z.e0(getScaleType());
        }
        obtainStyledAttributes.recycle();
        f fVar = this.z;
        if (h.f(getContext()) != 0.0f) {
            z = true;
        }
        fVar.g0(Boolean.valueOf(z));
        k();
        this.p0 = true;
    }

    private void setCompositionTask(m<d> mVar) {
        i();
        h();
        this.O3 = mVar.f(this.f880f).e(this.q);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        c.a("buildDrawingCache");
        this.N3++;
        super.buildDrawingCache(z);
        if (this.N3 == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.N3--;
        c.b("buildDrawingCache");
    }

    public boolean d(@NonNull j jVar) {
        d dVar = this.P3;
        if (dVar != null) {
            jVar.a(dVar);
        }
        return this.M3.add(jVar);
    }

    public <T> void e(com.airbnb.lottie.model.d dVar, T t, com.airbnb.lottie.w.c<T> cVar) {
        this.z.c(dVar, t, cVar);
    }

    public <T> void f(com.airbnb.lottie.model.d dVar, T t, com.airbnb.lottie.w.e<T> eVar) {
        this.z.c(dVar, t, new d(eVar));
    }

    @MainThread
    public void g() {
        this.I3 = false;
        this.H3 = false;
        this.p3 = false;
        this.z.e();
        k();
    }

    @Nullable
    public d getComposition() {
        return this.P3;
    }

    public long getDuration() {
        d dVar = this.P3;
        if (dVar != null) {
            return dVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.z.p();
    }

    @Nullable
    public String getImageAssetsFolder() {
        return this.z.s();
    }

    public float getMaxFrame() {
        return this.z.t();
    }

    public float getMinFrame() {
        return this.z.v();
    }

    @Nullable
    public n getPerformanceTracker() {
        return this.z.w();
    }

    @FloatRange(from = Utils.DOUBLE_EPSILON, to = 1.0d)
    public float getProgress() {
        return this.z.x();
    }

    public int getRepeatCount() {
        return this.z.y();
    }

    public int getRepeatMode() {
        return this.z.z();
    }

    public float getScale() {
        return this.z.A();
    }

    public float getSpeed() {
        return this.z.B();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.z;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j(boolean z) {
        this.z.j(z);
    }

    public boolean m() {
        return this.z.E();
    }

    @MainThread
    public void n() {
        this.J3 = false;
        this.I3 = false;
        this.H3 = false;
        this.p3 = false;
        this.z.G();
        k();
    }

    @MainThread
    public void o() {
        if (isShown()) {
            this.z.H();
            k();
            return;
        }
        this.p3 = true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.J3 || this.I3) {
            o();
            this.J3 = false;
            this.I3 = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m()) {
            g();
            this.I3 = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f881c;
        this.p1 = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.p1);
        }
        int i = savedState.f882d;
        this.p2 = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(savedState.f883f);
        if (savedState.q) {
            o();
        }
        this.z.P(savedState.x);
        setRepeatMode(savedState.y);
        setRepeatCount(savedState.z);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f881c = this.p1;
        savedState.f882d = this.p2;
        savedState.f883f = this.z.x();
        savedState.q = this.z.E() || (!ViewCompat.isAttachedToWindow(this) && this.I3);
        savedState.x = this.z.s();
        savedState.y = this.z.z();
        savedState.z = this.z.y();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        if (this.p0) {
            if (isShown()) {
                if (this.H3) {
                    q();
                } else if (this.p3) {
                    o();
                }
                this.H3 = false;
                this.p3 = false;
            } else if (m()) {
                n();
                this.H3 = true;
            }
        }
    }

    public List<com.airbnb.lottie.model.d> p(com.airbnb.lottie.model.d dVar) {
        return this.z.I(dVar);
    }

    @MainThread
    public void q() {
        if (isShown()) {
            this.z.J();
            k();
            return;
        }
        this.p3 = false;
        this.H3 = true;
    }

    public void r(InputStream inputStream, @Nullable String str) {
        setCompositionTask(e.h(inputStream, str));
    }

    public void s(String str, @Nullable String str2) {
        r(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(@RawRes int i) {
        this.p2 = i;
        this.p1 = null;
        setCompositionTask(this.K3 ? e.m(getContext(), i) : e.n(getContext(), i, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        s(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.K3 ? e.q(getContext(), str) : e.r(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.z.K(z);
    }

    public void setCacheComposition(boolean z) {
        this.K3 = z;
    }

    public void setComposition(@NonNull d dVar) {
        if (c.a) {
            String str = f878c;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.z.setCallback(this);
        this.P3 = dVar;
        boolean L = this.z.L(dVar);
        k();
        if (getDrawable() != this.z || L) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (j jVar : this.M3) {
                jVar.a(dVar);
            }
        }
    }

    public void setFailureListener(@Nullable h<Throwable> hVar) {
        this.x = hVar;
    }

    public void setFallbackResource(@DrawableRes int i) {
        this.y = i;
    }

    public void setFontAssetDelegate(a aVar) {
        this.z.M(aVar);
    }

    public void setFrame(int i) {
        this.z.N(i);
    }

    public void setImageAssetDelegate(b bVar) {
        this.z.O(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.z.P(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        h();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        h();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        h();
        super.setImageResource(i);
    }

    public void setMaxFrame(int i) {
        this.z.Q(i);
    }

    public void setMaxProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.z.S(f2);
    }

    public void setMinAndMaxFrame(String str) {
        this.z.U(str);
    }

    public void setMinFrame(int i) {
        this.z.V(i);
    }

    public void setMinProgress(float f2) {
        this.z.X(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.z.Y(z);
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.z.Z(f2);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.L3 = renderMode;
        k();
    }

    public void setRepeatCount(int i) {
        this.z.a0(i);
    }

    public void setRepeatMode(int i) {
        this.z.b0(i);
    }

    public void setSafeMode(boolean z) {
        this.z.c0(z);
    }

    public void setScale(float f2) {
        this.z.d0(f2);
        if (getDrawable() == this.z) {
            setImageDrawable(null);
            setImageDrawable(this.z);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        f fVar = this.z;
        if (fVar != null) {
            fVar.e0(scaleType);
        }
    }

    public void setSpeed(float f2) {
        this.z.f0(f2);
    }

    public void setTextDelegate(r rVar) {
        this.z.h0(rVar);
    }

    public void setMaxFrame(String str) {
        this.z.R(str);
    }

    public void setMinFrame(String str) {
        this.z.W(str);
    }

    public void setAnimation(String str) {
        this.p1 = str;
        this.p2 = 0;
        setCompositionTask(this.K3 ? e.d(getContext(), str) : e.e(getContext(), str, null));
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(attributeSet, o.lottieAnimationViewStyle);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        l(attributeSet, i);
    }
}
