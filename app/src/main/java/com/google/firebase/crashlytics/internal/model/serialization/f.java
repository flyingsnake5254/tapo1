package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.JsonReader;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class f implements CrashlyticsReportJsonTransform.ObjectParser {
    public static final /* synthetic */ f a = new f();

    private /* synthetic */ f() {
    }

    @Override // com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.ObjectParser
    public final Object parse(JsonReader jsonReader) {
        CrashlyticsReport.CustomAttribute parseCustomAttribute;
        parseCustomAttribute = CrashlyticsReportJsonTransform.parseCustomAttribute(jsonReader);
        return parseCustomAttribute;
    }
}
