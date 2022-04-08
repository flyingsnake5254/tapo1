package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter.AttributeConverter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class AttributesDefinition {
    protected List<String> allAttributesNames = new ArrayList();
    protected List<String> principalAttributesNames = new ArrayList();
    protected List<String> otherAttributesNames = new ArrayList();
    protected Map<String, AttributeConverter<? extends Object>> attributesConverters = new HashMap();

    protected void addAttribute(String str, AttributeConverter<? extends Object> attributeConverter) {
        addAttribute(str, attributeConverter, true);
    }

    public Object convert(String str, Object obj) {
        AttributeConverter<? extends Object> attributeConverter = this.attributesConverters.get(str);
        return (attributeConverter == null || obj == null) ? obj : attributeConverter.convert(obj);
    }

    public List<String> getAllAttributes() {
        return this.allAttributesNames;
    }

    public List<String> getOtherAttributes() {
        return this.otherAttributesNames;
    }

    public List<String> getPrincipalAttributes() {
        return this.principalAttributesNames;
    }

    protected void addAttribute(String str, AttributeConverter<? extends Object> attributeConverter, boolean z) {
        this.allAttributesNames.add(str);
        this.attributesConverters.put(str, attributeConverter);
        if (z) {
            this.principalAttributesNames.add(str);
        } else {
            this.otherAttributesNames.add(str);
        }
    }
}
