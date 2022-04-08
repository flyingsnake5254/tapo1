package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;

/* compiled from: Model.kt */
/* loaded from: classes3.dex */
public final class DailyPlaybackFilter {
    private final int channel;
    private final String date;
    @c("end_index")
    private final int endIndex;
    private final int id;
    @c("start_index")
    private final int startIndex;

    public DailyPlaybackFilter(int i, int i2, int i3, int i4, String date) {
        j.e(date, "date");
        this.id = i;
        this.channel = i2;
        this.startIndex = i3;
        this.endIndex = i4;
        this.date = date;
    }

    public static /* synthetic */ DailyPlaybackFilter copy$default(DailyPlaybackFilter dailyPlaybackFilter, int i, int i2, int i3, int i4, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = dailyPlaybackFilter.id;
        }
        if ((i5 & 2) != 0) {
            i2 = dailyPlaybackFilter.channel;
        }
        if ((i5 & 4) != 0) {
            i3 = dailyPlaybackFilter.startIndex;
        }
        if ((i5 & 8) != 0) {
            i4 = dailyPlaybackFilter.endIndex;
        }
        if ((i5 & 16) != 0) {
            str = dailyPlaybackFilter.date;
        }
        return dailyPlaybackFilter.copy(i, i2, i3, i4, str);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.channel;
    }

    public final int component3() {
        return this.startIndex;
    }

    public final int component4() {
        return this.endIndex;
    }

    public final String component5() {
        return this.date;
    }

    public final DailyPlaybackFilter copy(int i, int i2, int i3, int i4, String date) {
        j.e(date, "date");
        return new DailyPlaybackFilter(i, i2, i3, i4, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DailyPlaybackFilter)) {
            return false;
        }
        DailyPlaybackFilter dailyPlaybackFilter = (DailyPlaybackFilter) obj;
        return this.id == dailyPlaybackFilter.id && this.channel == dailyPlaybackFilter.channel && this.startIndex == dailyPlaybackFilter.startIndex && this.endIndex == dailyPlaybackFilter.endIndex && j.a(this.date, dailyPlaybackFilter.date);
    }

    public final int getChannel() {
        return this.channel;
    }

    public final String getDate() {
        return this.date;
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final int getId() {
        return this.id;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public int hashCode() {
        int i = ((((((this.id * 31) + this.channel) * 31) + this.startIndex) * 31) + this.endIndex) * 31;
        String str = this.date;
        return i + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "DailyPlaybackFilter(id=" + this.id + ", channel=" + this.channel + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", date=" + this.date + ")";
    }

    public /* synthetic */ DailyPlaybackFilter(int i, int i2, int i3, int i4, String str, int i5, f fVar) {
        this(i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? 99 : i4, str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyPlaybackFilter(int i, String date) {
        this(i, 0, 0, 0, date, 14, null);
        j.e(date, "date");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DailyPlaybackFilter(int i, String date, int i2, int i3) {
        this(i, 0, i2, i3, date, 2, null);
        j.e(date, "date");
    }
}
