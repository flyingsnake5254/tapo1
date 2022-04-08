package com.google.firebase.crashlytics.internal.send;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.datatransport.b;
import com.google.android.datatransport.cct.c;
import com.google.android.datatransport.d;
import com.google.android.datatransport.e;
import com.google.android.datatransport.f;
import com.google.android.datatransport.g;
import com.google.android.datatransport.h.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportWithSessionId;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* loaded from: classes2.dex */
public class DataTransportCrashlyticsReportSender {
    private static final String CRASHLYTICS_TRANSPORT_NAME = "FIREBASE_CRASHLYTICS_REPORT";
    private final e<CrashlyticsReport> transport;
    private final d<CrashlyticsReport, byte[]> transportTransform;
    private static final CrashlyticsReportJsonTransform TRANSFORM = new CrashlyticsReportJsonTransform();
    private static final String CRASHLYTICS_ENDPOINT = mergeStrings("hts/cahyiseot-agolai.o/1frlglgc/aclg", "tp:/rsltcrprsp.ogepscmv/ieo/eaybtho");
    private static final String CRASHLYTICS_API_KEY = mergeStrings("AzSBpY4F0rHiHFdinTvM", "IayrSTFL9eJ69YeSUO2");
    private static final d<CrashlyticsReport, byte[]> DEFAULT_TRANSFORM = a.a;

    DataTransportCrashlyticsReportSender(e<CrashlyticsReport> eVar, d<CrashlyticsReport, byte[]> dVar) {
        this.transport = eVar;
        this.transportTransform = dVar;
    }

    public static DataTransportCrashlyticsReportSender create(Context context) {
        r.f(context);
        f g = r.c().g(new c(CRASHLYTICS_ENDPOINT, CRASHLYTICS_API_KEY));
        b b2 = b.b("json");
        d<CrashlyticsReport, byte[]> dVar = DEFAULT_TRANSFORM;
        return new DataTransportCrashlyticsReportSender(g.b(CRASHLYTICS_TRANSPORT_NAME, CrashlyticsReport.class, b2, dVar), dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$sendReport$1(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId, Exception exc) {
        if (exc != null) {
            taskCompletionSource.trySetException(exc);
        } else {
            taskCompletionSource.trySetResult(crashlyticsReportWithSessionId);
        }
    }

    private static String mergeStrings(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str.length() + str2.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    @NonNull
    public Task<CrashlyticsReportWithSessionId> sendReport(@NonNull final CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        CrashlyticsReport report = crashlyticsReportWithSessionId.getReport();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.transport.a(com.google.android.datatransport.c.f(report), new g() { // from class: com.google.firebase.crashlytics.internal.send.b
            @Override // com.google.android.datatransport.g
            public final void a(Exception exc) {
                DataTransportCrashlyticsReportSender.lambda$sendReport$1(TaskCompletionSource.this, crashlyticsReportWithSessionId, exc);
            }
        });
        return taskCompletionSource.getTask();
    }
}
