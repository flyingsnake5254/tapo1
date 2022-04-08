package com.google.mlkit.common.sdkinternal;

import java.util.ArrayDeque;
import java.util.Deque;

/* compiled from: com.google.mlkit:common@@16.0.0 */
/* loaded from: classes2.dex */
final class u extends ThreadLocal<Deque<Runnable>> {
    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Deque<Runnable> initialValue() {
        return new ArrayDeque();
    }
}
