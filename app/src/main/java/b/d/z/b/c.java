package b.d.z.b;

import android.opengl.GLES20;
import b.d.p.d;
import com.google.android.exoplayer2.util.g;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* compiled from: GLProgram.java */
/* loaded from: classes3.dex */
public abstract class c {
    private static final String a = "c";

    /* renamed from: b  reason: collision with root package name */
    private static final float[] f856b = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    protected final int f857c;

    /* renamed from: d  reason: collision with root package name */
    protected final a f858d;

    /* renamed from: e  reason: collision with root package name */
    protected int f859e;

    /* renamed from: f  reason: collision with root package name */
    protected final int[] f860f;
    protected final FloatBuffer[] g;
    protected int h;
    protected int[] i;
    protected int[] j;
    protected int k;
    private boolean l = false;

    /* compiled from: GLProgram.java */
    /* loaded from: classes3.dex */
    public interface a {
        float[] a();
    }

    public c(int i, a aVar) {
        this.f857c = i;
        this.f858d = aVar;
        this.f860f = new int[i];
        this.g = new FloatBuffer[i];
        q();
    }

    private void a() {
        int c2 = f.c(l(), e());
        this.f859e = c2;
        GLES20.glUseProgram(c2);
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f859e, g());
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) j());
        for (int i = 0; i < this.f857c; i++) {
            this.f860f[i] = GLES20.glGetAttribLocation(this.f859e, h()[i]);
            GLES20.glEnableVertexAttribArray(this.f860f[i]);
            f.b();
        }
        this.h = GLES20.glGetUniformLocation(this.f859e, d());
        this.k = GLES20.glGetUniformLocation(this.f859e, f());
        f.b();
        r();
        f.b();
    }

    private void c(YUVBuffer yUVBuffer) {
        if (!(yUVBuffer.yuvStrides == null || yUVBuffer.yuvPlanes == null)) {
            GLES20.glUniformMatrix3fv(this.h, 1, false, f856b, 0);
            int[] iArr = (int[]) g.e(yUVBuffer.yuvStrides);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) g.e(yUVBuffer.yuvPlanes);
            for (int i = 0; i < this.f857c; i++) {
                int k = k(i, iArr);
                int i2 = yUVBuffer.height;
                if (i != 0) {
                    i2 = (i2 + 1) / 2;
                }
                GLES20.glActiveTexture(33984 + i);
                GLES20.glBindTexture(3553, o()[i]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, n()[i], k, i2, 0, n()[i], 5121, byteBufferArr[i]);
            }
            int[] m = m(yUVBuffer.width);
            for (int i3 = 0; i3 < this.f857c; i3++) {
                if (this.i[i3] != m[i3] || this.j[i3] != iArr[i3]) {
                    g.g(iArr[i3] != 0);
                    float f2 = m[i3] / iArr[i3];
                    this.g[i3] = f.e(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                    GLES20.glVertexAttribPointer(this.f860f[i3], 2, 5126, false, 0, (Buffer) this.g[i3]);
                    this.i[i3] = m[i3];
                    this.j[i3] = iArr[i3];
                }
            }
            GLES20.glUniformMatrix4fv(this.k, 1, false, this.f858d.a(), 0);
            GLES20.glClear(16384);
            GLES20.glDrawArrays(5, 0, 4);
            f.b();
        }
    }

    private void r() {
        GLES20.glGenTextures(this.f857c, o(), 0);
        for (int i = 0; i < this.f857c; i++) {
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.f859e, i()[i]), i);
            GLES20.glActiveTexture(33984 + i);
            GLES20.glBindTexture(3553, o()[i]);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
        }
        f.b();
    }

    public void b(YUVBuffer yUVBuffer) {
        if (this.l) {
            try {
                c(yUVBuffer);
            } catch (Exception e2) {
                String str = a;
                d.c(str, "drawTextures:" + e2.toString());
            }
        }
    }

    protected abstract String d();

    protected abstract String e();

    protected abstract String f();

    protected abstract String g();

    protected abstract String[] h();

    protected abstract String[] i();

    protected abstract FloatBuffer j();

    protected abstract int k(int i, int[] iArr);

    protected abstract String l();

    protected abstract int[] m(int i);

    protected abstract int[] n();

    protected abstract int[] o();

    public void p() {
        a();
        this.l = true;
    }

    public void q() {
        int i = this.f857c;
        this.i = new int[i];
        this.j = new int[i];
        for (int i2 = 0; i2 < this.f857c; i2++) {
            int[] iArr = this.i;
            this.j[i2] = -1;
            iArr[i2] = -1;
        }
    }
}
