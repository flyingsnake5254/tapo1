package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.q;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes.dex */
public final class VideoDecoderGLSurfaceView extends GLSurfaceView implements s {

    /* renamed from: c  reason: collision with root package name */
    private final a f3976c;

    /* loaded from: classes.dex */
    private static final class a implements GLSurfaceView.Renderer {

        /* renamed from: c  reason: collision with root package name */
        private static final float[] f3977c = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};

        /* renamed from: d  reason: collision with root package name */
        private static final float[] f3978d = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};

        /* renamed from: f  reason: collision with root package name */
        private static final float[] f3979f = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        private static final String[] q = {"y_tex", "u_tex", "v_tex"};
        private static final FloatBuffer x = q.f(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        private int I3;
        private int J3;
        private r K3;
        private final GLSurfaceView y;
        private final int[] z = new int[3];
        private final int[] p0 = new int[3];
        private final int[] p1 = new int[3];
        private final int[] p2 = new int[3];
        private final AtomicReference<r> p3 = new AtomicReference<>();
        private final FloatBuffer[] H3 = new FloatBuffer[3];

        public a(GLSurfaceView gLSurfaceView) {
            this.y = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.p1;
                this.p2[i] = -1;
                iArr[i] = -1;
            }
        }

        private void b() {
            GLES20.glGenTextures(3, this.z, 0);
            for (int i = 0; i < 3; i++) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.I3, q[i]), i);
                GLES20.glActiveTexture(33984 + i);
                GLES20.glBindTexture(3553, this.z[i]);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
            }
            q.b();
        }

        public void a(r rVar) {
            r andSet = this.p3.getAndSet(rVar);
            if (andSet != null) {
                andSet.n();
            }
            this.y.requestRender();
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            r andSet = this.p3.getAndSet(null);
            if (!(andSet == null && this.K3 == null)) {
                if (andSet != null) {
                    r rVar = this.K3;
                    if (rVar != null) {
                        rVar.n();
                    }
                    this.K3 = andSet;
                }
                r rVar2 = (r) g.e(this.K3);
                float[] fArr = f3978d;
                int i = rVar2.p0;
                if (i == 1) {
                    fArr = f3977c;
                } else if (i == 3) {
                    fArr = f3979f;
                }
                GLES20.glUniformMatrix3fv(this.J3, 1, false, fArr, 0);
                int[] iArr = (int[]) g.e(rVar2.z);
                ByteBuffer[] byteBufferArr = (ByteBuffer[]) g.e(rVar2.y);
                int i2 = 0;
                while (i2 < 3) {
                    int i3 = i2 == 0 ? rVar2.x : (rVar2.x + 1) / 2;
                    GLES20.glActiveTexture(33984 + i2);
                    GLES20.glBindTexture(3553, this.z[i2]);
                    GLES20.glPixelStorei(3317, 1);
                    GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i3, 0, 6409, 5121, byteBufferArr[i2]);
                    i2++;
                }
                int i4 = (r3[0] + 1) / 2;
                int[] iArr2 = {rVar2.q, i4, i4};
                for (int i5 = 0; i5 < 3; i5++) {
                    if (this.p1[i5] != iArr2[i5] || this.p2[i5] != iArr[i5]) {
                        g.g(iArr[i5] != 0);
                        float f2 = iArr2[i5] / iArr[i5];
                        this.H3[i5] = q.f(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f2, 0.0f, f2, 1.0f});
                        GLES20.glVertexAttribPointer(this.p0[i5], 2, 5126, false, 0, (Buffer) this.H3[i5]);
                        this.p1[i5] = iArr2[i5];
                        this.p2[i5] = iArr[i5];
                    }
                }
                GLES20.glClear(16384);
                GLES20.glDrawArrays(5, 0, 4);
                q.b();
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            int c2 = q.c("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.I3 = c2;
            GLES20.glUseProgram(c2);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.I3, "in_pos");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, (Buffer) x);
            this.p0[0] = GLES20.glGetAttribLocation(this.I3, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.p0[0]);
            this.p0[1] = GLES20.glGetAttribLocation(this.I3, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.p0[1]);
            this.p0[2] = GLES20.glGetAttribLocation(this.I3, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.p0[2]);
            q.b();
            this.J3 = GLES20.glGetUniformLocation(this.I3, "mColorConversion");
            q.b();
            b();
            q.b();
        }
    }

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, null);
    }

    @Deprecated
    public s getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    public void setOutputBuffer(r rVar) {
        this.f3976c.a(rVar);
    }

    public VideoDecoderGLSurfaceView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f3976c = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }
}
