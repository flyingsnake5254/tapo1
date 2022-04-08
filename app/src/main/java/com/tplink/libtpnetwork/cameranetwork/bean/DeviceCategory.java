package com.tplink.libtpnetwork.cameranetwork.bean;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import com.tplink.libtpcommonstream.stream.control.common.PreviewAudio;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public enum DeviceCategory {
    DEVICE_DEFAULT(0, PreviewAudio.AUDIO_DEFAULT),
    DEVICE_CAMERA(1401, "camera");
    
    private static Map<Integer, DeviceCategory> idToCategoryMap;
    private static Map<String, DeviceCategory> valueToCategoryMap;
    private Integer id;
    private String value;

    /* loaded from: classes3.dex */
    public static class Deserializer implements h<DeviceCategory> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.h
        public DeviceCategory deserialize(i iVar, Type type, g gVar) throws JsonParseException {
            return DeviceCategory.fromValue(iVar.e());
        }
    }

    /* loaded from: classes3.dex */
    public static class Serializer implements o<DeviceCategory> {
        public i serialize(DeviceCategory deviceCategory, Type type, n nVar) {
            return new m(deviceCategory.value());
        }
    }

    static {
        DeviceCategory[] values;
        DeviceCategory[] values2;
        HashMap hashMap = new HashMap();
        for (DeviceCategory deviceCategory : values()) {
            if (!hashMap.containsKey(deviceCategory.value())) {
                hashMap.put(deviceCategory.value(), deviceCategory);
            } else {
                throw new ExceptionInInitializerError(String.format("Device category value %s not unique", deviceCategory.value));
            }
        }
        valueToCategoryMap = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        for (DeviceCategory deviceCategory2 : values()) {
            if (!hashMap2.containsKey(deviceCategory2.getId())) {
                hashMap2.put(deviceCategory2.getId(), deviceCategory2);
            } else {
                throw new ExceptionInInitializerError(String.format("Device category value %d not unique", deviceCategory2.id));
            }
        }
        idToCategoryMap = Collections.unmodifiableMap(hashMap2);
        JsonUtils.f(DeviceCategory.class, Serializer.class);
    }

    DeviceCategory(Integer num, String str) {
        this.id = num;
        this.value = str;
    }

    public static DeviceCategory fromId(Integer num) {
        DeviceCategory deviceCategory = idToCategoryMap.get(num);
        if (deviceCategory != null) {
            return deviceCategory;
        }
        throw new RuntimeException(String.format("device category %d not defined", num));
    }

    public static DeviceCategory fromValue(String str) throws RuntimeException {
        DeviceCategory deviceCategory = valueToCategoryMap.get(str);
        if (deviceCategory != null) {
            return deviceCategory;
        }
        throw new RuntimeException(String.format("device category %s not defined", str));
    }

    public static List<Long> getDeviceCategoryIds(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            arrayList.add(Long.valueOf(fromValue(str).getId().intValue()));
        }
        return arrayList;
    }

    public static List<String> getDeviceCategoryValues(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        for (Long l : list) {
            arrayList.add(fromId(Integer.valueOf(l.intValue())).value());
        }
        return arrayList;
    }

    public Integer getId() {
        return this.id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return value();
    }

    public String value() {
        return this.value;
    }
}
