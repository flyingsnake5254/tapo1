package com.tplink.libtpnetwork.cameranetwork.model;

import com.tplink.libtpcommonstream.stream.control.notification.ChannelStreamStatus;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: TypeWrapper.kt */
/* loaded from: classes3.dex */
public enum SdCardStatus {
    NORMAL("normal"),
    UNFORMATTED("unformatted"),
    ABNORMAL("abnormal"),
    FORMATTING("formatting"),
    OFFLINE(ChannelStreamStatus.PlaybackStreamStatus.OFFLINE),
    INSUFFICIENT("insufficient"),
    FULL("full");
    
    public static final Companion Companion = new Companion(null);
    private final String raw;

    /* compiled from: TypeWrapper.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public final SdCardStatus fromString(String raw) {
            SdCardStatus[] values;
            j.e(raw, "raw");
            for (SdCardStatus sdCardStatus : SdCardStatus.values()) {
                if (j.a(sdCardStatus.getRaw(), raw)) {
                    return sdCardStatus;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    SdCardStatus(String str) {
        this.raw = str;
    }

    public static final SdCardStatus fromString(String str) {
        return Companion.fromString(str);
    }

    public final String getRaw() {
        return this.raw;
    }
}
