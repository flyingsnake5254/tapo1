package org.bouncycastle.crypto;

/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes4.dex */
public abstract class PasswordConverter extends Enum<PasswordConverter> implements d {
    private static final /* synthetic */ PasswordConverter[] $VALUES;
    public static final PasswordConverter ASCII;
    public static final PasswordConverter PKCS12;
    public static final PasswordConverter UTF8;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes4.dex */
    static class a extends PasswordConverter {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // org.bouncycastle.crypto.PasswordConverter, org.bouncycastle.crypto.d
        public byte[] convert(char[] cArr) {
            return k.b(cArr);
        }

        @Override // org.bouncycastle.crypto.PasswordConverter, org.bouncycastle.crypto.d
        public String getType() {
            return "ASCII";
        }
    }

    static {
        a aVar = new a("ASCII", 0);
        ASCII = aVar;
        PasswordConverter bVar = new PasswordConverter("UTF8", 1) { // from class: org.bouncycastle.crypto.PasswordConverter.b
            @Override // org.bouncycastle.crypto.PasswordConverter, org.bouncycastle.crypto.d
            public byte[] convert(char[] cArr) {
                return k.c(cArr);
            }

            @Override // org.bouncycastle.crypto.PasswordConverter, org.bouncycastle.crypto.d
            public String getType() {
                return "UTF8";
            }
        };
        UTF8 = bVar;
        PasswordConverter cVar = new PasswordConverter("PKCS12", 2) { // from class: org.bouncycastle.crypto.PasswordConverter.c
            @Override // org.bouncycastle.crypto.PasswordConverter, org.bouncycastle.crypto.d
            public byte[] convert(char[] cArr) {
                return k.a(cArr);
            }

            @Override // org.bouncycastle.crypto.PasswordConverter, org.bouncycastle.crypto.d
            public String getType() {
                return "PKCS12";
            }
        };
        PKCS12 = cVar;
        $VALUES = new PasswordConverter[]{aVar, bVar, cVar};
    }

    private PasswordConverter(String str, int i) {
    }

    /* synthetic */ PasswordConverter(String str, int i, a aVar) {
        this(str, i);
    }

    public static PasswordConverter valueOf(String str) {
        return (PasswordConverter) Enum.valueOf(PasswordConverter.class, str);
    }

    public static PasswordConverter[] values() {
        return (PasswordConverter[]) $VALUES.clone();
    }

    @Override // org.bouncycastle.crypto.d
    public abstract /* synthetic */ byte[] convert(char[] cArr);

    @Override // org.bouncycastle.crypto.d
    public abstract /* synthetic */ String getType();
}
