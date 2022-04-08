package com.samskivert.mustache;

import com.samskivert.mustache.f;
import com.tplink.libtpmediastatistics.SSLClient;

/* compiled from: Escapers.java */
/* loaded from: classes2.dex */
public class c {
    public static final f.i a = a(new String[]{"&", "&amp;"}, new String[]{"'", "&#39;"}, new String[]{SSLClient.DOUBLE_QUOTATION, "&quot;"}, new String[]{"<", "&lt;"}, new String[]{">", "&gt;"}, new String[]{"`", "&#x60;"}, new String[]{SSLClient.EQUALS, "&#x3D;"});

    /* renamed from: b  reason: collision with root package name */
    public static final f.i f5136b = new a();

    /* compiled from: Escapers.java */
    /* loaded from: classes2.dex */
    static class a implements f.i {
        a() {
        }

        @Override // com.samskivert.mustache.f.i
        public String a(String str) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Escapers.java */
    /* loaded from: classes2.dex */
    public static class b implements f.i {
        final /* synthetic */ String[][] a;

        b(String[][] strArr) {
            this.a = strArr;
        }

        @Override // com.samskivert.mustache.f.i
        public String a(String str) {
            String[][] strArr;
            for (String[] strArr2 : this.a) {
                str = str.replace(strArr2[0], strArr2[1]);
            }
            return str;
        }
    }

    public static f.i a(String[]... strArr) {
        return new b(strArr);
    }
}
