package com.tplink.libtpanalytics.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: LocaleUtils.java */
/* loaded from: classes3.dex */
public class e {
    private static final List<String> a = Arrays.asList("ar_SA", "bg_BG", "cs_CZ", "da_DK", "de_DE", "el_GR", "en_US", "es_ES", "es_MX", "fi_FI", "fr_FR", "he_IL", "hu_HU", "it_IT", "ja_JP", "ko_KR", "ms_MY", "nb_NO", "nl_NL", "pl_PL", "pt_BR", "pt_PT", "ro_RO", "ru_RU", "sk_SK", "sv_SE", "th_TH", "tr_TR", "uk_UA", "vi_VN", "zh_TW");

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f12009b = Arrays.asList("en_US", "da_DK", "de_DE", "ru_RU", "fr_FR", "zh_TW", "fi_FI", "ko_KR", "nl_NL", "nb_NO", "pt_BR", "pt_PT", "ja_JP", "sv_SE", "es_ES", "it_IT");

    public static String a(Locale locale) {
        if (locale == null) {
            return "en_US";
        }
        String str = locale.getLanguage() + "_" + locale.getCountry();
        String language = locale.getLanguage();
        List<String> list = a;
        int indexOf = list.indexOf(str);
        if (indexOf >= 0 && indexOf < list.size()) {
            return list.get(indexOf);
        }
        if (language == null) {
            return "en_US";
        }
        for (String str2 : list) {
            String substring = str2.substring(0, 2);
            if ("pt".equalsIgnoreCase(language)) {
                return "pt_PT";
            }
            if ("es".equalsIgnoreCase(language)) {
                return "es_ES";
            }
            if (substring.equalsIgnoreCase(language)) {
                return str2;
            }
        }
        return "en_US";
    }
}
