package io.netty.handler.codec.http2;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.netty.util.internal.ObjectUtil;

/* loaded from: classes3.dex */
class HpackHeaderField {
    static final int HEADER_ENTRY_OVERHEAD = 32;
    final CharSequence name;
    final CharSequence value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HpackHeaderField(CharSequence charSequence, CharSequence charSequence2) {
        this.name = (CharSequence) ObjectUtil.checkNotNull(charSequence, AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.value = (CharSequence) ObjectUtil.checkNotNull(charSequence2, "value");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long sizeOf(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence.length() + charSequence2.length() + 32;
    }

    public final boolean equalsForTest(HpackHeaderField hpackHeaderField) {
        return HpackUtil.equalsVariableTime(this.name, hpackHeaderField.name) && HpackUtil.equalsVariableTime(this.value, hpackHeaderField.value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int size() {
        return this.name.length() + this.value.length() + 32;
    }

    public String toString() {
        return ((Object) this.name) + ": " + ((Object) this.value);
    }
}
