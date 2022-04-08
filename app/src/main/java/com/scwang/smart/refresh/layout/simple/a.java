package com.scwang.smart.refresh.layout.simple;

import android.graphics.PointF;
import android.view.View;
import com.scwang.smart.refresh.layout.c.i;
import com.scwang.smart.refresh.layout.d.b;

/* compiled from: SimpleBoundaryDecider.java */
/* loaded from: classes2.dex */
public class a implements i {
    public PointF a;

    /* renamed from: b  reason: collision with root package name */
    public i f5233b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5234c = true;

    @Override // com.scwang.smart.refresh.layout.c.i
    public boolean a(View view) {
        i iVar = this.f5233b;
        if (iVar != null) {
            return iVar.a(view);
        }
        return b.b(view, this.a);
    }

    @Override // com.scwang.smart.refresh.layout.c.i
    public boolean b(View view) {
        i iVar = this.f5233b;
        if (iVar != null) {
            return iVar.b(view);
        }
        return b.a(view, this.a, this.f5234c);
    }
}
