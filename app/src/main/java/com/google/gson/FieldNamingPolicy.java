package com.google.gson;

import com.tplink.libtpmediastatistics.SSLClient;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes2.dex */
public abstract class FieldNamingPolicy extends Enum<FieldNamingPolicy> implements c {
    private static final /* synthetic */ FieldNamingPolicy[] $VALUES;
    public static final FieldNamingPolicy IDENTITY;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes2.dex */
    final class a extends FieldNamingPolicy {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.gson.FieldNamingPolicy, com.google.gson.c
        public String translateName(Field field) {
            return field.getName();
        }
    }

    static {
        a aVar = new a("IDENTITY", 0);
        IDENTITY = aVar;
        FieldNamingPolicy bVar = new FieldNamingPolicy("UPPER_CAMEL_CASE", 1) { // from class: com.google.gson.FieldNamingPolicy.b
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.upperCaseFirstLetter(field.getName());
            }
        };
        UPPER_CAMEL_CASE = bVar;
        FieldNamingPolicy cVar = new FieldNamingPolicy("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: com.google.gson.FieldNamingPolicy.c
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(field.getName(), SSLClient.WHITE_SPACE));
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = cVar;
        FieldNamingPolicy dVar = new FieldNamingPolicy("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: com.google.gson.FieldNamingPolicy.d
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.separateCamelCase(field.getName(), "_").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = dVar;
        FieldNamingPolicy eVar = new FieldNamingPolicy("LOWER_CASE_WITH_DASHES", 4) { // from class: com.google.gson.FieldNamingPolicy.e
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.separateCamelCase(field.getName(), "-").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = eVar;
        FieldNamingPolicy fVar = new FieldNamingPolicy("LOWER_CASE_WITH_DOTS", 5) { // from class: com.google.gson.FieldNamingPolicy.f
            @Override // com.google.gson.FieldNamingPolicy, com.google.gson.c
            public String translateName(Field field) {
                return FieldNamingPolicy.separateCamelCase(field.getName(), ".").toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = fVar;
        $VALUES = new FieldNamingPolicy[]{aVar, bVar, cVar, dVar, eVar, fVar};
    }

    private FieldNamingPolicy(String str, int i) {
    }

    static String separateCamelCase(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    static String upperCaseFirstLetter(String str) {
        int length = str.length() - 1;
        int i = 0;
        while (!Character.isLetter(str.charAt(i)) && i < length) {
            i++;
        }
        char charAt = str.charAt(i);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i) + upperCase + str.substring(i + 1);
    }

    public static FieldNamingPolicy valueOf(String str) {
        return (FieldNamingPolicy) Enum.valueOf(FieldNamingPolicy.class, str);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[]) $VALUES.clone();
    }

    @Override // com.google.gson.c
    public abstract /* synthetic */ String translateName(Field field);

    /* synthetic */ FieldNamingPolicy(String str, int i, a aVar) {
        this(str, i);
    }
}
