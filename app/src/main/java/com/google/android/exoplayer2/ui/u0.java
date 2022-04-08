package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.p.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: SpannedToHtmlConverter.java */
/* loaded from: classes.dex */
final class u0 {
    private static final Pattern a = Pattern.compile("(&#13;)?&#10;");

    /* compiled from: SpannedToHtmlConverter.java */
    /* loaded from: classes.dex */
    public static class b {
        public final String a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<String, String> f3762b;

        private b(String str, Map<String, String> map) {
            this.a = str;
            this.f3762b = map;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpannedToHtmlConverter.java */
    /* loaded from: classes.dex */
    public static final class c {
        private static final Comparator<c> a = e.f3738c;

        /* renamed from: b  reason: collision with root package name */
        private static final Comparator<c> f3763b = f.f3739c;

        /* renamed from: c  reason: collision with root package name */
        public final int f3764c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3765d;

        /* renamed from: e  reason: collision with root package name */
        public final String f3766e;

        /* renamed from: f  reason: collision with root package name */
        public final String f3767f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int c(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f3765d, cVar.f3765d);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar.f3766e.compareTo(cVar2.f3766e);
            return compareTo != 0 ? compareTo : cVar.f3767f.compareTo(cVar2.f3767f);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int d(c cVar, c cVar2) {
            int compare = Integer.compare(cVar2.f3764c, cVar.f3764c);
            if (compare != 0) {
                return compare;
            }
            int compareTo = cVar2.f3766e.compareTo(cVar.f3766e);
            return compareTo != 0 ? compareTo : cVar2.f3767f.compareTo(cVar.f3767f);
        }

        private c(int i, int i2, String str, String str2) {
            this.f3764c = i;
            this.f3765d = i2;
            this.f3766e = str;
            this.f3767f = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SpannedToHtmlConverter.java */
    /* loaded from: classes.dex */
    public static final class d {
        private final List<c> a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private final List<c> f3768b = new ArrayList();
    }

    public static b a(@Nullable CharSequence charSequence, float f2) {
        if (charSequence == null) {
            return new b("", ImmutableMap.of());
        }
        if (!(charSequence instanceof Spanned)) {
            return new b(b(charSequence), ImmutableMap.of());
        }
        Spanned spanned = (Spanned) charSequence;
        HashSet<Integer> hashSet = new HashSet();
        int i = 0;
        for (BackgroundColorSpan backgroundColorSpan : (BackgroundColorSpan[]) spanned.getSpans(0, spanned.length(), BackgroundColorSpan.class)) {
            hashSet.add(Integer.valueOf(backgroundColorSpan.getBackgroundColor()));
        }
        HashMap hashMap = new HashMap();
        for (Integer num : hashSet) {
            int intValue = num.intValue();
            StringBuilder sb = new StringBuilder(14);
            sb.append("bg_");
            sb.append(intValue);
            hashMap.put(h0.a(sb.toString()), o0.A("background-color:%s;", h0.b(intValue)));
        }
        SparseArray<d> c2 = c(spanned, f2);
        StringBuilder sb2 = new StringBuilder(spanned.length());
        int i2 = 0;
        while (i < c2.size()) {
            int keyAt = c2.keyAt(i);
            sb2.append(b(spanned.subSequence(i2, keyAt)));
            d dVar = c2.get(keyAt);
            Collections.sort(dVar.f3768b, c.f3763b);
            for (c cVar : dVar.f3768b) {
                sb2.append(cVar.f3767f);
            }
            Collections.sort(dVar.a, c.a);
            for (c cVar2 : dVar.a) {
                sb2.append(cVar2.f3766e);
            }
            i++;
            i2 = keyAt;
        }
        sb2.append(b(spanned.subSequence(i2, spanned.length())));
        return new b(sb2.toString(), hashMap);
    }

    private static String b(CharSequence charSequence) {
        return a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray<d> c(Spanned spanned, float f2) {
        Object[] spans;
        SparseArray<d> sparseArray = new SparseArray<>();
        for (Object obj : spanned.getSpans(0, spanned.length(), Object.class)) {
            String e2 = e(obj, f2);
            String d2 = d(obj);
            int spanStart = spanned.getSpanStart(obj);
            int spanEnd = spanned.getSpanEnd(obj);
            if (e2 != null) {
                g.e(d2);
                c cVar = new c(spanStart, spanEnd, e2, d2);
                f(sparseArray, spanStart).a.add(cVar);
                f(sparseArray, spanEnd).f3768b.add(cVar);
            }
        }
        return sparseArray;
    }

    @Nullable
    private static String d(Object obj) {
        if ((obj instanceof StrikethroughSpan) || (obj instanceof ForegroundColorSpan) || (obj instanceof BackgroundColorSpan) || (obj instanceof com.google.android.exoplayer2.text.p.a) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan) || (obj instanceof e)) {
            return "</span>";
        }
        if (!(obj instanceof TypefaceSpan)) {
            if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "</b>";
                }
                if (style == 2) {
                    return "</i>";
                }
                if (style == 3) {
                    return "</i></b>";
                }
            } else if (obj instanceof com.google.android.exoplayer2.text.p.c) {
                String b2 = b(((com.google.android.exoplayer2.text.p.c) obj).a);
                StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 16);
                sb.append("<rt>");
                sb.append(b2);
                sb.append("</rt></ruby>");
                return sb.toString();
            } else if (obj instanceof UnderlineSpan) {
                return "</u>";
            }
            return null;
        } else if (((TypefaceSpan) obj).getFamily() != null) {
            return "</span>";
        } else {
            return null;
        }
    }

    @Nullable
    private static String e(Object obj, float f2) {
        float f3;
        if (obj instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        if (obj instanceof ForegroundColorSpan) {
            return o0.A("<span style='color:%s;'>", h0.b(((ForegroundColorSpan) obj).getForegroundColor()));
        }
        if (obj instanceof BackgroundColorSpan) {
            return o0.A("<span class='bg_%s'>", Integer.valueOf(((BackgroundColorSpan) obj).getBackgroundColor()));
        }
        if (obj instanceof com.google.android.exoplayer2.text.p.a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (obj instanceof AbsoluteSizeSpan) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) obj;
            if (absoluteSizeSpan.getDip()) {
                f3 = absoluteSizeSpan.getSize();
            } else {
                f3 = absoluteSizeSpan.getSize() / f2;
            }
            return o0.A("<span style='font-size:%.2fpx;'>", Float.valueOf(f3));
        } else if (obj instanceof RelativeSizeSpan) {
            return o0.A("<span style='font-size:%.2f%%;'>", Float.valueOf(((RelativeSizeSpan) obj).getSizeChange() * 100.0f));
        } else {
            if (obj instanceof TypefaceSpan) {
                String family = ((TypefaceSpan) obj).getFamily();
                if (family != null) {
                    return o0.A("<span style='font-family:\"%s\";'>", family);
                }
                return null;
            } else if (obj instanceof StyleSpan) {
                int style = ((StyleSpan) obj).getStyle();
                if (style == 1) {
                    return "<b>";
                }
                if (style == 2) {
                    return "<i>";
                }
                if (style != 3) {
                    return null;
                }
                return "<b><i>";
            } else if (obj instanceof com.google.android.exoplayer2.text.p.c) {
                int i = ((com.google.android.exoplayer2.text.p.c) obj).f3516b;
                if (i == -1) {
                    return "<ruby style='ruby-position:unset;'>";
                }
                if (i == 1) {
                    return "<ruby style='ruby-position:over;'>";
                }
                if (i != 2) {
                    return null;
                }
                return "<ruby style='ruby-position:under;'>";
            } else if (obj instanceof UnderlineSpan) {
                return "<u>";
            } else {
                if (!(obj instanceof e)) {
                    return null;
                }
                e eVar = (e) obj;
                return o0.A("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", h(eVar.a, eVar.f3517b), g(eVar.f3518c));
            }
        }
    }

    private static d f(SparseArray<d> sparseArray, int i) {
        d dVar = sparseArray.get(i);
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d();
        sparseArray.put(i, dVar2);
        return dVar2;
    }

    private static String g(int i) {
        return i != 2 ? "over right" : "under left";
    }

    private static String h(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 == 1) {
            sb.append("filled ");
        } else if (i2 == 2) {
            sb.append("open ");
        }
        if (i == 0) {
            sb.append("none");
        } else if (i == 1) {
            sb.append("circle");
        } else if (i == 2) {
            sb.append("dot");
        } else if (i != 3) {
            sb.append("unset");
        } else {
            sb.append("sesame");
        }
        return sb.toString();
    }
}
