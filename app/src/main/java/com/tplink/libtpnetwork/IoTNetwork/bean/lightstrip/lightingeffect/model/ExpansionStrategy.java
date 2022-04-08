package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public enum ExpansionStrategy {
    REPEAT,
    STRETCH;

    /* loaded from: classes3.dex */
    public static final class ExpansionStrategyDeserializer implements h<ExpansionStrategy> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.h
        public ExpansionStrategy deserialize(i iVar, Type type, g gVar) throws JsonParseException {
            try {
                return ExpansionStrategy.valueOf(iVar.e().toUpperCase());
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }
}
