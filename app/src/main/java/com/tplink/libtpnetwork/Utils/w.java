package com.tplink.libtpnetwork.Utils;

import b.d.w.c.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: TapoLocaleHelper.java */
/* loaded from: classes3.dex */
public class w {
    private static final String a = "w";

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f14097b = Arrays.asList("ar_SA", "bg_BG", "cs_CZ", "da_DK", "de_DE", "el_GR", "en_US", "es_ES", "es_MX", "fi_FI", "fr_FR", "he_IL", "hu_HU", "it_IT", "ja_JP", "ko_KR", "ms_MY", "nb_NO", "nl_NL", "pl_PL", "pt_BR", "pt_PT", "ro_RO", "ru_RU", "sk_SK", "sv_SE", "th_TH", "tr_TR", "uk_UA", "vi_VN", "zh_TW");

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f14098c = Arrays.asList("en_US", "da_DK", "de_DE", "ru_RU", "fr_FR", "zh_TW", "fi_FI", "ko_KR", "nl_NL", "nb_NO", "pt_BR", "pt_PT", "ja_JP", "sv_SE", "es_ES", "it_IT");

    public static String a(Locale locale) {
        String str = "en_US";
        if (locale == null) {
            return str;
        }
        String str2 = locale.getLanguage() + "_" + locale.getCountry();
        String language = locale.getLanguage();
        a.c(a, "matchCloudEmailLocale, formatLocale = " + str2);
        List<String> list = f14097b;
        int indexOf = list.indexOf(str2);
        if (indexOf >= 0 && indexOf < list.size()) {
            str = list.get(indexOf);
        } else if (language != null) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                String substring = next.substring(0, 2);
                if (!"pt".equalsIgnoreCase(language)) {
                    if (!"es".equalsIgnoreCase(language)) {
                        if (substring.equalsIgnoreCase(language)) {
                            str = next;
                            break;
                        }
                    } else {
                        str = "es_ES";
                        break;
                    }
                } else {
                    str = "pt_PT";
                    break;
                }
            }
        }
        a.c(a, "matchCloudEmailLocale, after match, targetLocale = " + str);
        return str;
    }
}
