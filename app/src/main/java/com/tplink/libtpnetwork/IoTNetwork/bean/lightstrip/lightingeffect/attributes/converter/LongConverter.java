package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

/* loaded from: classes3.dex */
public final class LongConverter implements AttributeConverter<Long> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter.AttributeConverter
    public Long convert(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return new Long(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            return Long.valueOf(Long.parseLong((String) obj));
        }
        return null;
    }
}
