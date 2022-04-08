package b.d.z.b;

import b.d.z.b.c;
import java.nio.FloatBuffer;

/* compiled from: GLProgramI420.java */
/* loaded from: classes3.dex */
public class d extends c {
    private static final String[] m = {"y_tex", "u_tex", "v_tex"};
    private static final String[] n = {"in_tc_y", "in_tc_u", "in_tc_v"};
    private static final FloatBuffer o = f.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
    private static final int[] p = {6409, 6409, 6409};
    protected final int[] q = new int[3];

    public d(c.a aVar) {
        super(3, aVar);
    }

    @Override // b.d.z.b.c
    protected String d() {
        return "mColorConversion";
    }

    @Override // b.d.z.b.c
    protected String e() {
        return "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).x - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).x - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).x - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n";
    }

    @Override // b.d.z.b.c
    protected String f() {
        return "uMVPMatrix";
    }

    @Override // b.d.z.b.c
    protected String g() {
        return "in_pos";
    }

    @Override // b.d.z.b.c
    protected String[] h() {
        return n;
    }

    @Override // b.d.z.b.c
    protected String[] i() {
        return m;
    }

    @Override // b.d.z.b.c
    protected FloatBuffer j() {
        return o;
    }

    @Override // b.d.z.b.c
    protected int k(int i, int[] iArr) {
        if (i < 0 || i >= this.f857c) {
            return 0;
        }
        return iArr[i];
    }

    @Override // b.d.z.b.c
    protected String l() {
        return "varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n";
    }

    @Override // b.d.z.b.c
    protected int[] m(int i) {
        int[] iArr = new int[this.f857c];
        for (int i2 = 0; i2 < this.f857c; i2++) {
            if (i2 == 0) {
                iArr[i2] = i;
            } else {
                iArr[i2] = (i + 1) / 2;
            }
        }
        return iArr;
    }

    @Override // b.d.z.b.c
    protected int[] n() {
        return p;
    }

    @Override // b.d.z.b.c
    protected int[] o() {
        return this.q;
    }
}
