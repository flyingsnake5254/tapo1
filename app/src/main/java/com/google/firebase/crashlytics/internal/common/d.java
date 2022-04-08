package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ d f4792c = new d();

    private /* synthetic */ d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int compareTo;
        compareTo = ((CrashlyticsReport.CustomAttribute) obj).getKey().compareTo(((CrashlyticsReport.CustomAttribute) obj2).getKey());
        return compareTo;
    }
}
