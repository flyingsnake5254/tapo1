package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class d implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ d a = new d();

    private /* synthetic */ d() {
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public final Object parse(JsonReader jsonReader) {
        CrashlyticsReport.FilesPayload.File parseFile;
        parseFile = CrashlyticsReportJsonTransform.parseFile(jsonReader);
        return parseFile;
    }
}
