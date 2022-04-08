package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.o;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@AutoValue
/* loaded from: classes.dex */
public abstract class SchedulerConfig {

    /* loaded from: classes.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* loaded from: classes.dex */
    public static class a {
        private com.google.android.datatransport.h.y.a a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Priority, b> f1959b = new HashMap();

        public a a(Priority priority, b bVar) {
            this.f1959b.put(priority, bVar);
            return this;
        }

        public SchedulerConfig b() {
            Objects.requireNonNull(this.a, "missing required property: clock");
            if (this.f1959b.keySet().size() >= Priority.values().length) {
                Map<Priority, b> map = this.f1959b;
                this.f1959b = new HashMap();
                return SchedulerConfig.d(this.a, map);
            }
            throw new IllegalStateException("Not all priorities have been configured");
        }

        public a c(com.google.android.datatransport.h.y.a aVar) {
            this.a = aVar;
            return this;
        }
    }

    @AutoValue
    /* loaded from: classes.dex */
    public static abstract class b {

        @AutoValue.Builder
        /* loaded from: classes.dex */
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j);

            public abstract a c(Set<Flag> set);

            public abstract a d(long j);
        }

        public static a a() {
            return new o.b().c(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<Flag> c();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long d();
    }

    private long a(int i, long j) {
        int i2;
        return (long) (Math.pow(3.0d, i - 1) * j * Math.max(1.0d, Math.log(10000.0d) / Math.log((j > 1 ? j : 2L) * i2)));
    }

    public static a b() {
        return new a();
    }

    static SchedulerConfig d(com.google.android.datatransport.h.y.a aVar, Map<Priority, b> map) {
        return new n(aVar, map);
    }

    public static SchedulerConfig f(com.google.android.datatransport.h.y.a aVar) {
        return b().a(Priority.DEFAULT, b.a().b(30000L).d(86400000L).a()).a(Priority.HIGHEST, b.a().b(1000L).d(86400000L).a()).a(Priority.VERY_LOW, b.a().b(86400000L).d(86400000L).c(i(Flag.NETWORK_UNMETERED, Flag.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    private void j(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, Priority priority, long j, int i) {
        builder.setMinimumLatency(g(priority, j, i));
        j(builder, h().get(priority).c());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract com.google.android.datatransport.h.y.a e();

    public long g(Priority priority, long j, int i) {
        long a2 = j - e().a();
        b bVar = h().get(priority);
        return Math.min(Math.max(a(i, bVar.b()), a2), bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<Priority, b> h();
}
