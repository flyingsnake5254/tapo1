package kotlin.text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.m;
import kotlin.collections.s;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.sequences.g;

/* compiled from: Regex.kt */
/* loaded from: classes4.dex */
public final class Regex implements Serializable {
    public static final a Companion = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Regex.kt */
    /* loaded from: classes4.dex */
    private static final class b implements Serializable {

        /* renamed from: c  reason: collision with root package name */
        public static final a f16377c = new a(null);

        /* renamed from: d  reason: collision with root package name */
        private final String f16378d;

        /* renamed from: f  reason: collision with root package name */
        private final int f16379f;

        /* compiled from: Regex.kt */
        /* loaded from: classes4.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }
        }

        public b(String pattern, int i) {
            j.e(pattern, "pattern");
            this.f16378d = pattern;
            this.f16379f = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    /* loaded from: classes4.dex */
    public static final class c extends Lambda implements kotlin.jvm.b.a<i> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ CharSequence f16381d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f16382f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence, int i) {
            super(0);
            this.f16381d = charSequence;
            this.f16382f = i;
        }

        /* renamed from: a */
        public final i invoke() {
            return Regex.this.find(this.f16381d, this.f16382f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Regex.kt */
    /* loaded from: classes4.dex */
    public static final /* synthetic */ class d extends FunctionReferenceImpl implements l<i, i> {

        /* renamed from: c  reason: collision with root package name */
        public static final d f16383c = new d();

        d() {
            super(1, i.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        /* renamed from: a */
        public final i invoke(i p1) {
            j.e(p1, "p1");
            return p1.next();
        }
    }

    public Regex(Pattern nativePattern) {
        j.e(nativePattern, "nativePattern");
        this.nativePattern = nativePattern;
    }

    public static /* synthetic */ i find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public static /* synthetic */ kotlin.sequences.f findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        j.d(pattern, "nativePattern.pattern()");
        return new b(pattern, this.nativePattern.flags());
    }

    public final boolean containsMatchIn(CharSequence input) {
        j.e(input, "input");
        return this.nativePattern.matcher(input).find();
    }

    public final i find(CharSequence input, int i) {
        i f2;
        j.e(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        j.d(matcher, "nativePattern.matcher(input)");
        f2 = k.f(matcher, i, input);
        return f2;
    }

    public final kotlin.sequences.f<i> findAll(CharSequence input, int i) {
        j.e(input, "input");
        if (i >= 0 && i <= input.length()) {
            return g.c(new c(input, i), d.f16383c);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i + ", input length: " + input.length());
    }

    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set != null) {
            return set;
        }
        int flags = this.nativePattern.flags();
        EnumSet allOf = EnumSet.allOf(RegexOption.class);
        s.s(allOf, new Regex$fromInt$$inlined$apply$lambda$1(flags));
        Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
        j.d(unmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this._options = unmodifiableSet;
        return unmodifiableSet;
    }

    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        j.d(pattern, "nativePattern.pattern()");
        return pattern;
    }

    public final i matchEntire(CharSequence input) {
        i g;
        j.e(input, "input");
        Matcher matcher = this.nativePattern.matcher(input);
        j.d(matcher, "nativePattern.matcher(input)");
        g = k.g(matcher, input);
        return g;
    }

    public final boolean matches(CharSequence input) {
        j.e(input, "input");
        return this.nativePattern.matcher(input).matches();
    }

    public final String replace(CharSequence input, String replacement) {
        j.e(input, "input");
        j.e(replacement, "replacement");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        j.d(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        j.e(input, "input");
        j.e(replacement, "replacement");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        j.d(replaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return replaceFirst;
    }

    public final List<String> split(CharSequence input, int i) {
        List<String> b2;
        j.e(input, "input");
        int i2 = 0;
        if (i >= 0) {
            Matcher matcher = this.nativePattern.matcher(input);
            if (!matcher.find() || i == 1) {
                b2 = m.b(input.toString());
                return b2;
            }
            int i3 = 10;
            if (i > 0) {
                i3 = kotlin.v.g.d(i, 10);
            }
            ArrayList arrayList = new ArrayList(i3);
            int i4 = i - 1;
            do {
                arrayList.add(input.subSequence(i2, matcher.start()).toString());
                i2 = matcher.end();
                if (i4 >= 0 && arrayList.size() == i4) {
                    break;
                }
            } while (matcher.find());
            arrayList.add(input.subSequence(i2, input.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        j.d(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.j.e(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.j.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    public final String replace(CharSequence input, l<? super i, ? extends CharSequence> transform) {
        j.e(input, "input");
        j.e(transform, "transform");
        int i = 0;
        i find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            j.c(find$default);
            sb.append(input, i, find$default.a().getStart().intValue());
            sb.append((CharSequence) transform.invoke(find$default));
            i = find$default.a().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(input, i, length);
        }
        String sb2 = sb.toString();
        j.d(sb2, "sb.toString()");
        return sb2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.j.e(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = r3.getValue()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.j.d(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2, java.util.Set<? extends kotlin.text.RegexOption> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.j.e(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.j.e(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.Companion
            int r3 = kotlin.text.k.e(r3)
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.jvm.internal.j.d(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }
}
