package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.v.g;

/* compiled from: CharCategory.kt */
/* loaded from: classes4.dex */
public enum CharCategory {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");
    
    public static final b Companion = new b(null);
    private static final f categoryMap$delegate;
    private final String code;
    private final int value;

    /* compiled from: CharCategory.kt */
    /* loaded from: classes4.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<Map<Integer, ? extends CharCategory>> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f16375c = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Map<Integer, CharCategory> invoke() {
            int a;
            int b2;
            CharCategory[] values = CharCategory.values();
            a = d0.a(values.length);
            b2 = g.b(a, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
            for (CharCategory charCategory : values) {
                linkedHashMap.put(Integer.valueOf(charCategory.getValue()), charCategory);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: CharCategory.kt */
    /* loaded from: classes4.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        f b2;
        b2 = i.b(a.f16375c);
        categoryMap$delegate = b2;
    }

    CharCategory(int i, String str) {
        this.value = i;
        this.code = str;
    }

    public final boolean contains(char c2) {
        return Character.getType(c2) == this.value;
    }

    public final String getCode() {
        return this.code;
    }

    public final int getValue() {
        return this.value;
    }
}
