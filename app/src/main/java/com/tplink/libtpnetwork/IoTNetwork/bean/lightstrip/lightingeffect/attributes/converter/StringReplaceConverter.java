package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import com.tplink.libtpnetwork.Utils.b0;

/* loaded from: classes3.dex */
public final class StringReplaceConverter implements AttributeConverter<String> {
    private final String regex;
    private final String replacement;

    public StringReplaceConverter(String str, String str2) {
        this.regex = str;
        this.replacement = str2;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter.AttributeConverter
    public String convert(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (!b0.c(str) || !b0.c(this.regex) || !b0.c(this.replacement)) {
            return null;
        }
        return str.replaceAll(this.regex, this.replacement);
    }
}
