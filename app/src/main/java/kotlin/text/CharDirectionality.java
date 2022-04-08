package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.f;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.v.g;

/* compiled from: CharDirectionality.kt */
/* loaded from: classes4.dex */
public enum CharDirectionality {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);
    
    public static final b Companion = new b(null);
    private static final f directionalityMap$delegate;
    private final int value;

    /* compiled from: CharDirectionality.kt */
    /* loaded from: classes4.dex */
    static final class a extends Lambda implements kotlin.jvm.b.a<Map<Integer, ? extends CharDirectionality>> {

        /* renamed from: c  reason: collision with root package name */
        public static final a f16376c = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Map<Integer, CharDirectionality> invoke() {
            int a;
            int b2;
            CharDirectionality[] values = CharDirectionality.values();
            a = d0.a(values.length);
            b2 = g.b(a, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
            for (CharDirectionality charDirectionality : values) {
                linkedHashMap.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
            }
            return linkedHashMap;
        }
    }

    /* compiled from: CharDirectionality.kt */
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
        b2 = i.b(a.f16376c);
        directionalityMap$delegate = b2;
    }

    CharDirectionality(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
