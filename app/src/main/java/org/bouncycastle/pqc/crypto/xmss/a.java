package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;
import org.bouncycastle.pqc.crypto.xmss.d;
import org.bouncycastle.pqc.crypto.xmss.f;
import org.bouncycastle.pqc.crypto.xmss.g;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private XMSSNode f17445c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17446d;

    /* renamed from: f  reason: collision with root package name */
    private int f17447f;
    private int q;
    private boolean x = false;
    private boolean y = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(int i) {
        this.f17446d = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        if (!this.x || this.y) {
            return Integer.MAX_VALUE;
        }
        return this.f17447f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.q;
    }

    public XMSSNode d() {
        return this.f17445c.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(int i) {
        this.f17445c = null;
        this.f17447f = this.f17446d;
        this.q = i;
        this.x = true;
        this.y = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(XMSSNode xMSSNode) {
        this.f17445c = xMSSNode;
        int height = xMSSNode.getHeight();
        this.f17447f = height;
        if (height == this.f17446d) {
            this.y = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(Stack<XMSSNode> stack, h hVar, byte[] bArr, byte[] bArr2, g gVar) {
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        if (this.y || !this.x) {
            throw new IllegalStateException("finished or not initialized");
        }
        g gVar2 = (g) new g.b().g(gVar.b()).h(gVar.c()).p(this.q).n(gVar.e()).o(gVar.f()).f(gVar.a()).l();
        d dVar = (d) new d.b().g(gVar2.b()).h(gVar2.c()).n(this.q).k();
        hVar.h(hVar.g(bArr2, gVar2), bArr);
        XMSSNode a = p.a(hVar, hVar.e(gVar2), (f) new f.b().g(gVar2.b()).h(gVar2.c()).n(this.q).l());
        while (!stack.isEmpty() && stack.peek().getHeight() == a.getHeight() && stack.peek().getHeight() != this.f17446d) {
            d dVar2 = (d) new d.b().g(dVar.b()).h(dVar.c()).m(dVar.e()).n((dVar.f() - 1) / 2).f(dVar.a()).k();
            XMSSNode b2 = p.b(hVar, stack.pop(), a, dVar2);
            a = new XMSSNode(b2.getHeight() + 1, b2.getValue());
            dVar = (d) new d.b().g(dVar2.b()).h(dVar2.c()).m(dVar2.e() + 1).n(dVar2.f()).f(dVar2.a()).k();
        }
        XMSSNode xMSSNode = this.f17445c;
        if (xMSSNode == null) {
            this.f17445c = a;
        } else if (xMSSNode.getHeight() == a.getHeight()) {
            d dVar3 = (d) new d.b().g(dVar.b()).h(dVar.c()).m(dVar.e()).n((dVar.f() - 1) / 2).f(dVar.a()).k();
            a = new XMSSNode(this.f17445c.getHeight() + 1, p.b(hVar, this.f17445c, a, dVar3).getValue());
            this.f17445c = a;
            d dVar4 = (d) new d.b().g(dVar3.b()).h(dVar3.c()).m(dVar3.e() + 1).n(dVar3.f()).f(dVar3.a()).k();
        } else {
            stack.push(a);
        }
        if (this.f17445c.getHeight() == this.f17446d) {
            this.y = true;
            return;
        }
        this.f17447f = a.getHeight();
        this.q++;
    }
}
