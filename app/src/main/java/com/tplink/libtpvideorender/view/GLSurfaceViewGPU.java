package com.tplink.libtpvideorender.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.ViewGroup;
import b.d.p.d;
import b.d.z.b.b;
import com.tplink.libmediakit.media.display.renderer.YUVBuffer;

/* loaded from: classes3.dex */
public class GLSurfaceViewGPU extends GLSurfaceView {

    /* renamed from: c  reason: collision with root package name */
    private final String f15143c = GLSurfaceViewGPU.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    protected b f15144d;

    /* renamed from: f  reason: collision with root package name */
    protected String f15145f;

    public GLSurfaceViewGPU(Context context) {
        super(context);
    }

    public void a(ViewGroup viewGroup) {
        viewGroup.removeView(this);
    }

    public void b() {
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setFormat(-3);
    }

    public void setDeviceIdMD5(String str) {
        this.f15145f = str;
    }

    public void setGlRenderer(b bVar) {
        if (this.f15144d == null) {
            this.f15144d = bVar;
            setEGLContextClientVersion(2);
            getHolder().removeCallback(this);
            setRenderer(bVar);
            setPreserveEGLContextOnPause(true);
            setRenderMode(0);
            d.a(this.f15143c, "GLSurfaceViewGPU 调用 setRenderer()");
        }
    }

    public void setOutputBuffer(YUVBuffer yUVBuffer) {
        this.f15144d.m(yUVBuffer);
        requestRender();
    }

    public GLSurfaceViewGPU(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
