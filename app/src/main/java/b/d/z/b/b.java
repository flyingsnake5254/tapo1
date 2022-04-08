package b.d.z.b;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: BaseGLRenderer.java */
/* loaded from: classes3.dex */
public abstract class b implements GLSurfaceView.Renderer {
    protected int O3;
    protected h P3;

    /* renamed from: c  reason: collision with root package name */
    protected g f853c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f854d;
    protected int p2;
    protected int p3;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f855f = false;
    protected String q = null;
    private float x = 1.0f;
    protected float y = 1.0f;
    protected float z = 1.0f;
    private float p0 = 0.0f;
    private float p1 = 0.0f;
    protected int H3 = 16;
    protected int I3 = 9;
    private boolean J3 = false;
    private boolean K3 = false;
    private final float[] L3 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private final float[] M3 = new float[16];
    private final float[] N3 = new float[16];

    private void j() {
        Matrix.setIdentityM(this.L3, 0);
        int i = this.p2;
        int i2 = this.I3;
        int i3 = i * i2;
        int i4 = this.p3;
        int i5 = this.H3;
        if (i3 >= i4 * i5) {
            this.y = (i4 * i5) / (i * i2);
            this.z = 1.0f;
        } else {
            this.y = 1.0f;
            this.z = (i * i2) / (i4 * i5);
        }
        if (this.J3 && Math.abs(this.p0) > g()) {
            this.p0 = this.p0 > 0.0f ? g() : -g();
        }
        if (this.K3 && Math.abs(this.p1) > d()) {
            this.p1 = this.p1 > 0.0f ? d() : -d();
        }
        Matrix.translateM(this.L3, 0, this.p0, this.p1, 0.0f);
        Matrix.scaleM(this.L3, 0, this.y, this.z, 1.0f);
        float[] fArr = this.L3;
        float f2 = this.x;
        Matrix.scaleM(fArr, 0, f2, f2, 0.0f);
    }

    protected abstract void b();

    public void c(String str) {
        this.f854d = true;
        this.q = str;
        b();
    }

    public float d() {
        float e2 = (this.x - 1.0f) - ((1.0f - e()) * this.x);
        if (e2 < 0.0f) {
            return 0.0f;
        }
        return e2;
    }

    public float e() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] f() {
        float[] fArr = new float[16];
        Matrix.multiplyMM(fArr, 0, this.N3, 0, this.L3, 0);
        Matrix.multiplyMM(fArr, 0, this.M3, 0, fArr, 0);
        return fArr;
    }

    public float g() {
        float h = (this.x - 1.0f) - ((1.0f - h()) * this.x);
        if (h < 0.0f) {
            return 0.0f;
        }
        return h;
    }

    public float h() {
        return this.y;
    }

    public void i() {
        k(1.0f);
    }

    public void k(float f2) {
        this.x = f2;
        this.p0 = 0.0f;
        this.p1 = 0.0f;
        j();
    }

    public void l(g gVar) {
        this.f853c = gVar;
    }

    public abstract void m(YUVBuffer yUVBuffer);

    public void n(h hVar) {
        this.P3 = hVar;
    }

    public void o(String str) {
        this.f855f = true;
        this.q = str;
        b();
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        if (!(this.p2 == i || this.p3 == i2)) {
            int i3 = this.I3;
            int i4 = i * i3;
            int i5 = this.H3;
            boolean z = true;
            this.J3 = i4 > i2 * i5;
            if (i3 * i >= i2 * i5) {
                z = false;
            }
            this.K3 = z;
        }
        this.p2 = i;
        this.p3 = i2;
        GLES20.glViewport(0, 0, i, i2);
        Matrix.frustumM(this.M3, 0, -1.0f, 1.0f, -1.0f, 1.0f, 80.0f, 90.0f);
        Matrix.setLookAtM(this.N3, 0, 0.0f, 0.0f, 80.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        j();
    }

    public void p(float f2, float f3) {
        this.p0 = f2;
        this.p1 = f3;
        j();
    }
}
