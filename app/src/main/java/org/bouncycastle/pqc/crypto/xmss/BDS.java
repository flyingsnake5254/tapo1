package org.bouncycastle.pqc.crypto.xmss;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.pqc.crypto.xmss.d;
import org.bouncycastle.pqc.crypto.xmss.f;
import org.bouncycastle.pqc.crypto.xmss.g;

/* loaded from: classes4.dex */
public final class BDS implements Serializable {
    private static final long serialVersionUID = 1;
    private List<XMSSNode> authenticationPath;
    private int index;
    private int k;
    private Map<Integer, XMSSNode> keep;
    private Map<Integer, LinkedList<XMSSNode>> retain;
    private XMSSNode root;
    private Stack<XMSSNode> stack;
    private final List<a> treeHashInstances;
    private final int treeHeight;
    private boolean used;
    private transient h wotsPlus;

    private BDS(BDS bds, byte[] bArr, byte[] bArr2, g gVar) {
        this.wotsPlus = bds.wotsPlus;
        this.treeHeight = bds.treeHeight;
        this.k = bds.k;
        this.root = bds.root;
        this.authenticationPath = new ArrayList(bds.authenticationPath);
        this.retain = bds.retain;
        this.stack = (Stack) bds.stack.clone();
        this.treeHashInstances = bds.treeHashInstances;
        this.keep = new TreeMap(bds.keep);
        this.index = bds.index;
        nextAuthenticationPath(bArr, bArr2, gVar);
        bds.used = true;
    }

    private BDS(h hVar, int i, int i2) {
        this.wotsPlus = hVar;
        this.treeHeight = i;
        this.k = i2;
        if (i2 <= i && i2 >= 2) {
            int i3 = i - i2;
            if (i3 % 2 == 0) {
                this.authenticationPath = new ArrayList();
                this.retain = new TreeMap();
                this.stack = new Stack<>();
                this.treeHashInstances = new ArrayList();
                for (int i4 = 0; i4 < i3; i4++) {
                    this.treeHashInstances.add(new a(i4));
                }
                this.keep = new TreeMap();
                this.index = 0;
                this.used = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDS(r rVar, int i) {
        this(rVar.f(), rVar.d(), rVar.e());
        this.index = i;
        this.used = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDS(r rVar, byte[] bArr, byte[] bArr2, g gVar) {
        this(rVar.f(), rVar.d(), rVar.e());
        initialize(bArr, bArr2, gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BDS(r rVar, byte[] bArr, byte[] bArr2, g gVar, int i) {
        this(rVar.f(), rVar.d(), rVar.e());
        initialize(bArr, bArr2, gVar);
        while (this.index < i) {
            nextAuthenticationPath(bArr, bArr2, gVar);
            this.used = false;
        }
    }

    private a getBDSTreeHashInstanceForUpdate() {
        a aVar = null;
        for (a aVar2 : this.treeHashInstances) {
            if (!aVar2.g() && aVar2.h() && (aVar == null || aVar2.a() < aVar.a() || (aVar2.a() == aVar.a() && aVar2.b() < aVar.b()))) {
                aVar = aVar2;
            }
        }
        return aVar;
    }

    private void initialize(byte[] bArr, byte[] bArr2, g gVar) {
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        f fVar = (f) new f.b().g(gVar.b()).h(gVar.c()).l();
        d dVar = (d) new d.b().g(gVar.b()).h(gVar.c()).k();
        for (int i = 0; i < (1 << this.treeHeight); i++) {
            gVar = (g) new g.b().g(gVar.b()).h(gVar.c()).p(i).n(gVar.e()).o(gVar.f()).f(gVar.a()).l();
            h hVar = this.wotsPlus;
            hVar.h(hVar.g(bArr2, gVar), bArr);
            k e2 = this.wotsPlus.e(gVar);
            fVar = (f) new f.b().g(fVar.b()).h(fVar.c()).n(i).o(fVar.f()).p(fVar.g()).f(fVar.a()).l();
            XMSSNode a = p.a(this.wotsPlus, e2, fVar);
            dVar = (d) new d.b().g(dVar.b()).h(dVar.c()).n(i).f(dVar.a()).k();
            while (!this.stack.isEmpty() && this.stack.peek().getHeight() == a.getHeight()) {
                int floor = (int) Math.floor(i / (1 << a.getHeight()));
                if (floor == 1) {
                    this.authenticationPath.add(a.clone());
                }
                if (floor == 3 && a.getHeight() < this.treeHeight - this.k) {
                    this.treeHashInstances.get(a.getHeight()).i(a.clone());
                }
                if (floor >= 3 && (floor & 1) == 1 && a.getHeight() >= this.treeHeight - this.k && a.getHeight() <= this.treeHeight - 2) {
                    if (this.retain.get(Integer.valueOf(a.getHeight())) == null) {
                        LinkedList<XMSSNode> linkedList = new LinkedList<>();
                        linkedList.add(a.clone());
                        this.retain.put(Integer.valueOf(a.getHeight()), linkedList);
                    } else {
                        this.retain.get(Integer.valueOf(a.getHeight())).add(a.clone());
                    }
                }
                d dVar2 = (d) new d.b().g(dVar.b()).h(dVar.c()).m(dVar.e()).n((dVar.f() - 1) / 2).f(dVar.a()).k();
                XMSSNode b2 = p.b(this.wotsPlus, this.stack.pop(), a, dVar2);
                a = new XMSSNode(b2.getHeight() + 1, b2.getValue());
                dVar = (d) new d.b().g(dVar2.b()).h(dVar2.c()).m(dVar2.e() + 1).n(dVar2.f()).f(dVar2.a()).k();
            }
            this.stack.push(a);
        }
        this.root = this.stack.pop();
    }

    private void nextAuthenticationPath(byte[] bArr, byte[] bArr2, g gVar) {
        XMSSNode xMSSNode;
        List<XMSSNode> list;
        Objects.requireNonNull(gVar, "otsHashAddress == null");
        if (this.used) {
            throw new IllegalStateException("index already used");
        } else if (this.index <= (1 << this.treeHeight) - 2) {
            f fVar = (f) new f.b().g(gVar.b()).h(gVar.c()).l();
            d dVar = (d) new d.b().g(gVar.b()).h(gVar.c()).k();
            int b2 = u.b(this.index, this.treeHeight);
            if (((this.index >> (b2 + 1)) & 1) == 0 && b2 < this.treeHeight - 1) {
                this.keep.put(Integer.valueOf(b2), this.authenticationPath.get(b2).clone());
            }
            if (b2 == 0) {
                gVar = (g) new g.b().g(gVar.b()).h(gVar.c()).p(this.index).n(gVar.e()).o(gVar.f()).f(gVar.a()).l();
                h hVar = this.wotsPlus;
                hVar.h(hVar.g(bArr2, gVar), bArr);
                this.authenticationPath.set(0, p.a(this.wotsPlus, this.wotsPlus.e(gVar), (f) new f.b().g(fVar.b()).h(fVar.c()).n(this.index).o(fVar.f()).p(fVar.g()).f(fVar.a()).l()));
            } else {
                int i = b2 - 1;
                XMSSNode b3 = p.b(this.wotsPlus, this.authenticationPath.get(i), this.keep.get(Integer.valueOf(i)), (d) new d.b().g(dVar.b()).h(dVar.c()).m(i).n(this.index >> b2).f(dVar.a()).k());
                this.authenticationPath.set(b2, new XMSSNode(b3.getHeight() + 1, b3.getValue()));
                this.keep.remove(Integer.valueOf(i));
                for (int i2 = 0; i2 < b2; i2++) {
                    if (i2 < this.treeHeight - this.k) {
                        list = this.authenticationPath;
                        xMSSNode = this.treeHashInstances.get(i2).d();
                    } else {
                        list = this.authenticationPath;
                        xMSSNode = this.retain.get(Integer.valueOf(i2)).removeFirst();
                    }
                    list.set(i2, xMSSNode);
                }
                int min = Math.min(b2, this.treeHeight - this.k);
                for (int i3 = 0; i3 < min; i3++) {
                    int i4 = this.index + 1 + ((1 << i3) * 3);
                    if (i4 < (1 << this.treeHeight)) {
                        this.treeHashInstances.get(i3).f(i4);
                    }
                }
            }
            for (int i5 = 0; i5 < ((this.treeHeight - this.k) >> 1); i5++) {
                a bDSTreeHashInstanceForUpdate = getBDSTreeHashInstanceForUpdate();
                if (bDSTreeHashInstanceForUpdate != null) {
                    bDSTreeHashInstanceForUpdate.j(this.stack, this.wotsPlus, bArr, bArr2, gVar);
                }
            }
            this.index++;
        } else {
            throw new IllegalStateException("index out of bounds");
        }
    }

    protected List<XMSSNode> getAuthenticationPath() {
        ArrayList arrayList = new ArrayList();
        for (XMSSNode xMSSNode : this.authenticationPath) {
            arrayList.add(xMSSNode.clone());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getIndex() {
        return this.index;
    }

    public BDS getNextState(byte[] bArr, byte[] bArr2, g gVar) {
        return new BDS(this, bArr, bArr2, gVar);
    }

    protected XMSSNode getRoot() {
        return this.root.clone();
    }

    protected int getTreeHeight() {
        return this.treeHeight;
    }

    boolean isUsed() {
        return this.used;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setXMSS(r rVar) {
        if (this.treeHeight == rVar.d()) {
            this.wotsPlus = rVar.f();
            return;
        }
        throw new IllegalStateException("wrong height");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void validate() {
        if (this.authenticationPath == null) {
            throw new IllegalStateException("authenticationPath == null");
        } else if (this.retain == null) {
            throw new IllegalStateException("retain == null");
        } else if (this.stack == null) {
            throw new IllegalStateException("stack == null");
        } else if (this.treeHashInstances == null) {
            throw new IllegalStateException("treeHashInstances == null");
        } else if (this.keep == null) {
            throw new IllegalStateException("keep == null");
        } else if (!u.l(this.treeHeight, this.index)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }
}
