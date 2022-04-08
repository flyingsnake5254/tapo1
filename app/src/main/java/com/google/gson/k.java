package com.google.gson;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;
import java.util.Set;

/* compiled from: JsonObject.java */
/* loaded from: classes2.dex */
public final class k extends i {
    private final LinkedTreeMap<String, i> a = new LinkedTreeMap<>();

    public Set<Map.Entry<String, i>> entrySet() {
        return this.a.entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof k) && ((k) obj).a.equals(this.a));
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public void j(String str, i iVar) {
        LinkedTreeMap<String, i> linkedTreeMap = this.a;
        if (iVar == null) {
            iVar = j.a;
        }
        linkedTreeMap.put(str, iVar);
    }

    public void k(String str, Boolean bool) {
        j(str, bool == null ? j.a : new m(bool));
    }

    public void l(String str, Number number) {
        j(str, number == null ? j.a : new m(number));
    }

    public void m(String str, String str2) {
        j(str, str2 == null ? j.a : new m(str2));
    }

    public i n(String str) {
        return this.a.get(str);
    }

    public boolean o(String str) {
        return this.a.containsKey(str);
    }

    public Set<String> p() {
        return this.a.keySet();
    }
}
