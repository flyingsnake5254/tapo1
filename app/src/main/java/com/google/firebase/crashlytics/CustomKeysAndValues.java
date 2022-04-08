package com.google.firebase.crashlytics;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class CustomKeysAndValues {
    final Map<String, String> keysAndValues;

    /* loaded from: classes2.dex */
    public static class Builder {
        private Map<String, String> keysAndValues = new HashMap();

        @NonNull
        public CustomKeysAndValues build() {
            return new CustomKeysAndValues(this);
        }

        @NonNull
        public Builder putBoolean(@NonNull String str, boolean z) {
            this.keysAndValues.put(str, Boolean.toString(z));
            return this;
        }

        @NonNull
        public Builder putDouble(@NonNull String str, double d2) {
            this.keysAndValues.put(str, Double.toString(d2));
            return this;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f2) {
            this.keysAndValues.put(str, Float.toString(f2));
            return this;
        }

        @NonNull
        public Builder putInt(@NonNull String str, int i) {
            this.keysAndValues.put(str, Integer.toString(i));
            return this;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j) {
            this.keysAndValues.put(str, Long.toString(j));
            return this;
        }

        @NonNull
        public Builder putString(@NonNull String str, @NonNull String str2) {
            this.keysAndValues.put(str, str2);
            return this;
        }
    }

    CustomKeysAndValues(@NonNull Builder builder) {
        this.keysAndValues = builder.keysAndValues;
    }
}
