package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import java.util.Locale;

/* loaded from: classes3.dex */
public final class LocaleConverter implements AttributeConverter<Locale> {
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter.AttributeConverter
    public Locale convert(Object obj) {
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        String[] split = ((String) obj).replaceAll("-", "_").split("_");
        int length = split.length;
        if (length == 2) {
            return new Locale(split[0], split[1]);
        }
        if (length == 1) {
            return new Locale(split[0]);
        }
        return null;
    }
}
