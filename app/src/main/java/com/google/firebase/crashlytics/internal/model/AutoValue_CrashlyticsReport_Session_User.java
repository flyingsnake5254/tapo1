package com.google.firebase.crashlytics.internal.model;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_User extends CrashlyticsReport.Session.User {
    private final String identifier;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Builder extends CrashlyticsReport.Session.User.Builder {
        private String identifier;

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User build() {
            String str = "";
            if (this.identifier == null) {
                str = str + " identifier";
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_User(this.identifier);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder
        public CrashlyticsReport.Session.User.Builder setIdentifier(String str) {
            Objects.requireNonNull(str, "Null identifier");
            this.identifier = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CrashlyticsReport.Session.User) {
            return this.identifier.equals(((CrashlyticsReport.Session.User) obj).getIdentifier());
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User
    @NonNull
    public String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.identifier + "}";
    }

    private AutoValue_CrashlyticsReport_Session_User(String str) {
        this.identifier = str;
    }
}
