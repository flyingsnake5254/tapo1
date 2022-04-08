package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum ImageFlipOptionSwitch {
    ON("center"),
    OFF("off");
    
    public static final Companion Companion = new Companion(null);
    private final String raw;

    /* compiled from: TypeWrapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final ImageFlipOptionSwitch fromString(String raw) {
            ImageFlipOptionSwitch[] values;
            j.e(raw, "raw");
            for (ImageFlipOptionSwitch imageFlipOptionSwitch : ImageFlipOptionSwitch.values()) {
                if (j.a(imageFlipOptionSwitch.raw, raw)) {
                    return imageFlipOptionSwitch;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    ImageFlipOptionSwitch(String str) {
        this.raw = str;
    }

    public static final ImageFlipOptionSwitch fromString(String str) {
        return Companion.fromString(str);
    }
}
