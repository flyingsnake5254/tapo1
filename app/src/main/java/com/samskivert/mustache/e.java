package com.samskivert.mustache;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.text.Regex;
import kotlin.text.w;

/* compiled from: FunctionExpressionParser.kt */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final a f5138b = new a(null);
    private static final Regex a = new Regex(",(?![^()]*\\))");

    /* compiled from: FunctionExpressionParser.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    private final String d(String str, int i) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(0, i);
        j.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    private final List<String> e(String str) {
        CharSequence t0;
        List<String> split = a.split(str, 0);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            Objects.requireNonNull(str2, "null cannot be cast to non-null type kotlin.CharSequence");
            t0 = w.t0(str2);
            arrayList.add(t0.toString());
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = kotlin.text.w.Q(r9, ')', 0, false, 6, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "expressionStr"
            kotlin.jvm.internal.j.e(r9, r0)
            boolean r0 = r8.b(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            r3 = 41
            r4 = 0
            r5 = 0
            r6 = 6
            r7 = 0
            r2 = r9
            int r0 = kotlin.text.m.Q(r2, r3, r4, r5, r6, r7)
            int r2 = r9.length()
            r3 = 1
            int r2 = r2 - r3
            if (r0 != r2) goto L_0x0021
            return r1
        L_0x0021:
            int r0 = r0 + r3
            char r9 = r9.charAt(r0)
            r0 = 46
            if (r0 != r9) goto L_0x002b
            r1 = 1
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samskivert.mustache.e.a(java.lang.String):boolean");
    }

    public final boolean b(String expressionStr) {
        int L;
        int Q;
        j.e(expressionStr, "expressionStr");
        L = w.L(expressionStr, '(', 0, false, 6, null);
        Q = w.Q(expressionStr, ')', 0, false, 6, null);
        return (L == -1 || Q == -1) ? false : true;
    }

    public final d c(String expressionStr) {
        int L;
        int Q;
        j.e(expressionStr, "expressionStr");
        if (!b(expressionStr)) {
            return null;
        }
        L = w.L(expressionStr, '(', 0, false, 6, null);
        Q = w.Q(expressionStr, ')', 0, false, 6, null);
        String d2 = d(expressionStr, L);
        String substring = expressionStr.substring(L + 1, Q);
        j.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ArrayList arrayList = new ArrayList();
        for (String str : e(substring)) {
            if (b(str)) {
                d c2 = c(str);
                if (c2 != null) {
                    arrayList.add(c2);
                }
            } else {
                arrayList.add(str);
            }
        }
        return new d(d2, arrayList);
    }
}
