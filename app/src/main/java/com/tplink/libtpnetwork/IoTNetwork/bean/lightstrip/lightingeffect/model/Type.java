package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;

/* loaded from: classes3.dex */
public enum Type {
    RANDOM,
    SEQUENCE,
    STATIC,
    PULSE;

    /* loaded from: classes3.dex */
    public static final class TypeDeserializer implements h<Type> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.h
        public Type deserialize(i iVar, java.lang.reflect.Type type, g gVar) throws JsonParseException {
            try {
                return Type.valueOf(iVar.e().toUpperCase());
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }
}
