package com.tplink.iot.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.j;

/* compiled from: CameraLiveConfigManager.kt */
/* loaded from: classes2.dex */
public final class i {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(' ');
        }
        String sb2 = sb.toString();
        j.d(sb2, "stringBuilder.toString()");
        return sb2;
    }
}
