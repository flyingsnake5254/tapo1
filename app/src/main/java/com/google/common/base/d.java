package com.google.common.base;

/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public abstract class d implements o<Character> {

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    static abstract class a extends d {
        a() {
        }

        @Override // com.google.common.base.o
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return d.super.b(ch);
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    private static final class b extends a {

        /* renamed from: c  reason: collision with root package name */
        private final char f4119c;

        /* renamed from: d  reason: collision with root package name */
        private final char f4120d;

        b(char c2, char c3) {
            n.d(c3 >= c2);
            this.f4119c = c2;
            this.f4120d = c3;
        }

        @Override // com.google.common.base.d
        public boolean f(char c2) {
            return this.f4119c <= c2 && c2 <= this.f4120d;
        }

        public String toString() {
            return "CharMatcher.inRange('" + d.h(this.f4119c) + "', '" + d.h(this.f4120d) + "')";
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    private static final class c extends a {

        /* renamed from: c  reason: collision with root package name */
        private final char f4121c;

        c(char c2) {
            this.f4121c = c2;
        }

        @Override // com.google.common.base.d
        public boolean f(char c2) {
            return c2 == this.f4121c;
        }

        public String toString() {
            return "CharMatcher.is('" + d.h(this.f4121c) + "')";
        }
    }

    /* compiled from: CharMatcher.java */
    /* renamed from: com.google.common.base.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static abstract class AbstractC0151d extends a {

        /* renamed from: c  reason: collision with root package name */
        private final String f4122c;

        AbstractC0151d(String str) {
            this.f4122c = (String) n.o(str);
        }

        public final String toString() {
            return this.f4122c;
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    private static final class e extends AbstractC0151d {

        /* renamed from: d  reason: collision with root package name */
        static final e f4123d = new e();

        private e() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.d
        public int d(CharSequence charSequence, int i) {
            n.r(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.d
        public boolean f(char c2) {
            return false;
        }
    }

    protected d() {
    }

    public static d c(char c2, char c3) {
        return new b(c2, c3);
    }

    public static d e(char c2) {
        return new c(c2);
    }

    public static d g() {
        return e.f4123d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(char c2) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public boolean b(Character ch) {
        return f(ch.charValue());
    }

    public int d(CharSequence charSequence, int i) {
        int length = charSequence.length();
        n.r(i, length);
        while (i < length) {
            if (f(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean f(char c2);
}
