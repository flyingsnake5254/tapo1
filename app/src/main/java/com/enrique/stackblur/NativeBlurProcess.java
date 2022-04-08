package com.enrique.stackblur;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class NativeBlurProcess {
    static final ExecutorService EXECUTOR;
    static final int EXECUTOR_THREADS;

    /* loaded from: classes.dex */
    private static class NativeTask implements Callable<Void> {
        private final Bitmap _bitmapOut;
        private final int _coreIndex;
        private final int _radius;
        private final int _round;
        private final int _totalCores;

        public NativeTask(Bitmap bitmap, int i, int i2, int i3, int i4) {
            this._bitmapOut = bitmap;
            this._radius = i;
            this._totalCores = i2;
            this._coreIndex = i3;
            this._round = i4;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            NativeBlurProcess.functionToBlur(this._bitmapOut, this._radius, this._totalCores, this._coreIndex, this._round);
            return null;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        EXECUTOR_THREADS = availableProcessors;
        EXECUTOR = Executors.newFixedThreadPool(availableProcessors);
        System.loadLibrary("blur");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void functionToBlur(Bitmap bitmap, int i, int i2, int i3, int i4);

    public Bitmap blur(Bitmap bitmap, float f2) {
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        int i = EXECUTOR_THREADS;
        ArrayList arrayList = new ArrayList(i);
        ArrayList arrayList2 = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = (int) f2;
            arrayList.add(new NativeTask(copy, i3, i, i2, 1));
            arrayList2.add(new NativeTask(copy, i3, i, i2, 2));
        }
        try {
            ExecutorService executorService = EXECUTOR;
            executorService.invokeAll(arrayList);
            executorService.invokeAll(arrayList2);
        } catch (InterruptedException unused) {
        }
        return copy;
    }
}
