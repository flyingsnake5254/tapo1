package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import com.google.gson.JsonParseException;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.i;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public enum Direction {
    FORWARD,
    BACKWARD,
    PINGPONG,
    RANDOM;

    /* loaded from: classes3.dex */
    public static final class DirectionDeserializer implements h<Direction> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.h
        public Direction deserialize(i iVar, Type type, g gVar) throws JsonParseException {
            try {
                return Direction.valueOf(iVar.e().toUpperCase());
            } catch (Exception e2) {
                throw new IllegalArgumentException(e2);
            }
        }
    }
}
