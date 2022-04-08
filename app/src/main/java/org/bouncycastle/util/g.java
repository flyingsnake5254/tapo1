package org.bouncycastle.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;

/* loaded from: classes4.dex */
public class g {
    private static final ThreadLocal a = new ThreadLocal();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a implements PrivilegedAction {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            Map map = (Map) g.a.get();
            return map != null ? map.get(this.a) : System.getProperty(this.a);
        }
    }

    private static String b(String str) {
        return (String) AccessController.doPrivileged(new a(str));
    }

    public static boolean c(String str) {
        try {
            String b2 = b(str);
            if (b2 != null) {
                return "true".equals(i.f(b2));
            }
        } catch (AccessControlException unused) {
        }
        return false;
    }
}
