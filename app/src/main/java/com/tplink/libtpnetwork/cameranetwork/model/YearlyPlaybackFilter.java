package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.q.c;
import java.util.List;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class YearlyPlaybackFilter {
    private final List<Integer> channel;
    @c(FirebaseAnalytics.Param.END_DATE)
    private final String endDate;
    @c(FirebaseAnalytics.Param.START_DATE)
    private final String startDate;

    public YearlyPlaybackFilter(List<Integer> channel, String startDate, String endDate) {
        j.e(channel, "channel");
        j.e(startDate, "startDate");
        j.e(endDate, "endDate");
        this.channel = channel;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ YearlyPlaybackFilter copy$default(YearlyPlaybackFilter yearlyPlaybackFilter, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = yearlyPlaybackFilter.channel;
        }
        if ((i & 2) != 0) {
            str = yearlyPlaybackFilter.startDate;
        }
        if ((i & 4) != 0) {
            str2 = yearlyPlaybackFilter.endDate;
        }
        return yearlyPlaybackFilter.copy(list, str, str2);
    }

    public final List<Integer> component1() {
        return this.channel;
    }

    public final String component2() {
        return this.startDate;
    }

    public final String component3() {
        return this.endDate;
    }

    public final YearlyPlaybackFilter copy(List<Integer> channel, String startDate, String endDate) {
        j.e(channel, "channel");
        j.e(startDate, "startDate");
        j.e(endDate, "endDate");
        return new YearlyPlaybackFilter(channel, startDate, endDate);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof YearlyPlaybackFilter)) {
            return false;
        }
        YearlyPlaybackFilter yearlyPlaybackFilter = (YearlyPlaybackFilter) obj;
        return j.a(this.channel, yearlyPlaybackFilter.channel) && j.a(this.startDate, yearlyPlaybackFilter.startDate) && j.a(this.endDate, yearlyPlaybackFilter.endDate);
    }

    public final List<Integer> getChannel() {
        return this.channel;
    }

    public final String getEndDate() {
        return this.endDate;
    }

    public final String getStartDate() {
        return this.startDate;
    }

    public int hashCode() {
        List<Integer> list = this.channel;
        int i = 0;
        int hashCode = (list != null ? list.hashCode() : 0) * 31;
        String str = this.startDate;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.endDate;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "YearlyPlaybackFilter(channel=" + this.channel + ", startDate=" + this.startDate + ", endDate=" + this.endDate + ")";
    }

    public /* synthetic */ YearlyPlaybackFilter(List list, String str, String str2, int i, f fVar) {
        this((i & 1) != 0 ? m.b(0) : list, str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YearlyPlaybackFilter(String start, String end) {
        this(null, start, end, 1, null);
        j.e(start, "start");
        j.e(end, "end");
    }
}
