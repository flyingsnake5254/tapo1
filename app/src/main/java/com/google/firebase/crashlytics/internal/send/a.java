package com.google.firebase.crashlytics.internal.send;

import com.google.android.datatransport.d;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.nio.charset.Charset;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements d {
    public static final /* synthetic */ a a = new a();

    private /* synthetic */ a() {
    }

    @Override // com.google.android.datatransport.d
    public final Object apply(Object obj) {
        byte[] bytes;
        bytes = DataTransportCrashlyticsReportSender.TRANSFORM.reportToJson((CrashlyticsReport) obj).getBytes(Charset.forName("UTF-8"));
        return bytes;
    }
}
