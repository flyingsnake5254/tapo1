package com.tplink.iot.cloud.bean.common;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.m;
import com.google.gson.n;
import com.google.gson.o;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class MapJsonAdapter implements o<Map<String, Object>>, h<Map<String, Object>> {
    private Object read(i iVar) {
        if (iVar.f()) {
            ArrayList arrayList = new ArrayList();
            Iterator<i> it = iVar.b().iterator();
            while (it.hasNext()) {
                arrayList.add(read(it.next()));
            }
            return arrayList;
        } else if (iVar.h()) {
            HashMap hashMap = new HashMap();
            k c2 = iVar.c();
            for (String str : c2.p()) {
                hashMap.put(str, read(c2.n(str)));
            }
            return hashMap;
        } else {
            if (iVar.i()) {
                m d2 = iVar.d();
                if (d2.q()) {
                    return d2.e();
                }
                if (d2.n()) {
                    return Boolean.valueOf(d2.j());
                }
                if (d2.p()) {
                    double doubleValue = d2.m().doubleValue();
                    if (doubleValue > 9.223372036854776E18d) {
                        return Double.valueOf(doubleValue);
                    }
                    long j = (long) doubleValue;
                    if (doubleValue == j) {
                        return Long.valueOf(j);
                    }
                    return Double.valueOf(doubleValue);
                }
            } else if (iVar.g()) {
            }
            return null;
        }
    }

    @Override // com.google.gson.h
    public Map<String, Object> deserialize(i iVar, Type type, g gVar) throws JsonParseException {
        if (!iVar.h()) {
            return (Map) gVar.b(iVar, type);
        }
        HashMap hashMap = new HashMap();
        k c2 = iVar.c();
        for (String str : c2.p()) {
            hashMap.put(str, read(c2.n(str)));
        }
        return hashMap;
    }

    public i serialize(Map<String, Object> map, Type type, n nVar) {
        return nVar.a(map, type);
    }
}
