package com.google.android.datatransport.cct;

import androidx.annotation.Keep;
import com.google.android.datatransport.runtime.backends.d;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.l;

@Keep
/* loaded from: classes.dex */
public class CctBackendFactory implements d {
    @Override // com.google.android.datatransport.runtime.backends.d
    public l create(g gVar) {
        return new d(gVar.b(), gVar.e(), gVar.d());
    }
}
