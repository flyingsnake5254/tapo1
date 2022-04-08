package uk.co.senab.photoview.f;

import android.util.Log;

/* compiled from: LoggerDefault.java */
/* loaded from: classes4.dex */
public class c implements b {
    @Override // uk.co.senab.photoview.f.b
    public int a(String str, String str2) {
        return Log.d(str, str2);
    }

    @Override // uk.co.senab.photoview.f.b
    public int b(String str, String str2) {
        return Log.i(str, str2);
    }
}
