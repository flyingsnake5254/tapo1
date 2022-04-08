package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import b.d.w.c.a;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class DateConverter implements AttributeConverter<Date> {
    protected String format;
    protected Locale locale;

    public DateConverter(String str) {
        this.format = str;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter.AttributeConverter
    public Date convert(Object obj) {
        SimpleDateFormat simpleDateFormat;
        if (obj == null || !(obj instanceof String)) {
            return null;
        }
        if (this.locale == null) {
            simpleDateFormat = new SimpleDateFormat(this.format);
        } else {
            simpleDateFormat = new SimpleDateFormat(this.format, this.locale);
        }
        String str = (String) obj;
        try {
            return simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            a.g(e2, "parse exception on " + str + " with format : " + this.format, e2);
            return null;
        }
    }

    public DateConverter(String str, Locale locale) {
        this.format = str;
        this.locale = locale;
    }
}
