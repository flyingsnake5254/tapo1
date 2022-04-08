package org.bouncycastle.jce.provider;

import java.security.Permission;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.bouncycastle.jcajce.provider.config.b;
import org.bouncycastle.jce.spec.d;

/* loaded from: classes4.dex */
class a implements b {
    private static Permission a = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "threadLocalEcImplicitlyCa");

    /* renamed from: b  reason: collision with root package name */
    private static Permission f17394b = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "ecImplicitlyCa");

    /* renamed from: c  reason: collision with root package name */
    private static Permission f17395c = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "threadLocalDhDefaultParams");

    /* renamed from: d  reason: collision with root package name */
    private static Permission f17396d = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "DhDefaultParams");

    /* renamed from: e  reason: collision with root package name */
    private static Permission f17397e = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "acceptableEcCurves");

    /* renamed from: f  reason: collision with root package name */
    private static Permission f17398f = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, "additionalEcParameters");
    private volatile d i;
    private volatile Object j;
    private ThreadLocal g = new ThreadLocal();
    private ThreadLocal h = new ThreadLocal();
    private volatile Set k = new HashSet();
    private volatile Map l = new HashMap();

    @Override // org.bouncycastle.jcajce.provider.config.b
    public Map a() {
        return Collections.unmodifiableMap(this.l);
    }

    @Override // org.bouncycastle.jcajce.provider.config.b
    public d b() {
        d dVar = (d) this.g.get();
        return dVar != null ? dVar : this.i;
    }

    @Override // org.bouncycastle.jcajce.provider.config.b
    public Set c() {
        return Collections.unmodifiableSet(this.k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str, Object obj) {
        ThreadLocal threadLocal;
        SecurityManager securityManager = System.getSecurityManager();
        if (str.equals("threadLocalEcImplicitlyCa")) {
            if (securityManager != null) {
                securityManager.checkPermission(a);
            }
            d h = ((obj instanceof d) || obj == null) ? (d) obj : org.bouncycastle.jcajce.provider.asymmetric.util.a.h((ECParameterSpec) obj, false);
            if (h == null) {
                threadLocal = this.g;
            } else {
                this.g.set(h);
                return;
            }
        } else if (str.equals("ecImplicitlyCa")) {
            if (securityManager != null) {
                securityManager.checkPermission(f17394b);
            }
            if ((obj instanceof d) || obj == null) {
                this.i = (d) obj;
                return;
            } else {
                this.i = org.bouncycastle.jcajce.provider.asymmetric.util.a.h((ECParameterSpec) obj, false);
                return;
            }
        } else if (str.equals("threadLocalDhDefaultParams")) {
            if (securityManager != null) {
                securityManager.checkPermission(f17395c);
            }
            if ((obj instanceof DHParameterSpec) || (obj instanceof DHParameterSpec[]) || obj == null) {
                threadLocal = this.h;
                if (obj != null) {
                    threadLocal.set(obj);
                    return;
                }
            } else {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
        } else if (str.equals("DhDefaultParams")) {
            if (securityManager != null) {
                securityManager.checkPermission(f17396d);
            }
            if ((obj instanceof DHParameterSpec) || (obj instanceof DHParameterSpec[]) || obj == null) {
                this.j = obj;
                return;
            }
            throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
        } else if (str.equals("acceptableEcCurves")) {
            if (securityManager != null) {
                securityManager.checkPermission(f17397e);
            }
            this.k = (Set) obj;
            return;
        } else if (str.equals("additionalEcParameters")) {
            if (securityManager != null) {
                securityManager.checkPermission(f17398f);
            }
            this.l = (Map) obj;
            return;
        } else {
            return;
        }
        threadLocal.remove();
    }
}
