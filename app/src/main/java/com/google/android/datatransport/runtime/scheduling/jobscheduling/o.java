package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Objects;
import java.util.Set;

/* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
/* loaded from: classes.dex */
final class o extends SchedulerConfig.b {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final long f1982b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f1983c;

    /* compiled from: AutoValue_SchedulerConfig_ConfigValue.java */
    /* loaded from: classes.dex */
    static final class b extends SchedulerConfig.b.a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private Long f1984b;

        /* renamed from: c  reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f1985c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b a() {
            String str = "";
            if (this.a == null) {
                str = str + " delta";
            }
            if (this.f1984b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f1985c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new o(this.a.longValue(), this.f1984b.longValue(), this.f1985c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a b(long j) {
            this.a = Long.valueOf(j);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a c(Set<SchedulerConfig.Flag> set) {
            Objects.requireNonNull(set, "Null flags");
            this.f1985c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b.a
        public SchedulerConfig.b.a d(long j) {
            this.f1984b = Long.valueOf(j);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long b() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    Set<SchedulerConfig.Flag> c() {
        return this.f1983c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.b
    long d() {
        return this.f1982b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.b)) {
            return false;
        }
        SchedulerConfig.b bVar = (SchedulerConfig.b) obj;
        return this.a == bVar.b() && this.f1982b == bVar.d() && this.f1983c.equals(bVar.c());
    }

    public int hashCode() {
        long j = this.a;
        long j2 = this.f1982b;
        return this.f1983c.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.a + ", maxAllowedDelay=" + this.f1982b + ", flags=" + this.f1983c + "}";
    }

    private o(long j, long j2, Set<SchedulerConfig.Flag> set) {
        this.a = j;
        this.f1982b = j2;
        this.f1983c = set;
    }
}
