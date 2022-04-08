package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.h.y.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Map;
import java.util.Objects;

/* compiled from: AutoValue_SchedulerConfig.java */
/* loaded from: classes.dex */
final class n extends SchedulerConfig {
    private final a a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.b> f1981b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, Map<Priority, SchedulerConfig.b> map) {
        Objects.requireNonNull(aVar, "Null clock");
        this.a = aVar;
        Objects.requireNonNull(map, "Null values");
        this.f1981b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    a e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        return this.a.equals(schedulerConfig.e()) && this.f1981b.equals(schedulerConfig.h());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map<Priority, SchedulerConfig.b> h() {
        return this.f1981b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f1981b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.f1981b + "}";
    }
}
