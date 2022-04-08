package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.k;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.j;

/* compiled from: TypeAdapters.kt */
/* loaded from: classes3.dex */
final class TypeAdapter__TypeAdaptersKt$wrapperListDeserializer$1<T> implements h<Wrappers> {
    public static final TypeAdapter__TypeAdaptersKt$wrapperListDeserializer$1 INSTANCE = new TypeAdapter__TypeAdaptersKt$wrapperListDeserializer$1();

    TypeAdapter__TypeAdaptersKt$wrapperListDeserializer$1() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.h
    public final Wrappers deserialize(i json, Type type, g gVar) {
        T t;
        j.d(json, "json");
        k jsonObj = json.c();
        ArrayList arrayList = new ArrayList(0);
        Wrappers wrappers = new Wrappers(arrayList);
        if (jsonObj.p().contains(Module.DATA.getValue())) {
            return wrappers;
        }
        Set<Map.Entry<String, i>> entrySet = jsonObj.entrySet();
        j.d(entrySet, "jsonObj.entrySet()");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            Object value = ((Map.Entry) t).getValue();
            j.d(value, "it.value");
            if (((i) value).i()) {
                break;
            }
        }
        if (t != null) {
            Module module = Module.EMPTY;
            Section section = Section.EMPTY;
            j.d(jsonObj, "jsonObj");
            arrayList.add(new Wrapper(module, section, jsonObj));
            return new Wrappers(arrayList);
        }
        for (Map.Entry<String, i> entry : jsonObj.entrySet()) {
            String k = entry.getKey();
            i v = entry.getValue();
            j.d(v, "v");
            for (Map.Entry<String, i> entry2 : v.c().entrySet()) {
                String ki = entry2.getKey();
                i value2 = entry2.getValue();
                try {
                    j.d(k, "k");
                    j.d(ki, "ki");
                    Object b2 = gVar.b(value2, TypeDispatcher.INSTANCE.getRawType(k, ki));
                    j.d(b2, "context.deserialize(vi, …atcher.getRawType(k, ki))");
                    arrayList.add(new Wrapper(k, ki, b2));
                } catch (Exception unused) {
                    j.d(k, "k");
                    j.d(ki, "ki");
                    Object b3 = gVar.b(v, TypeDispatcher.INSTANCE.getRawType(k, ki));
                    j.d(b3, "context.deserialize(v, T…atcher.getRawType(k, ki))");
                    arrayList.add(new Wrapper(k, ki, b3));
                }
            }
        }
        return wrappers;
    }
}
