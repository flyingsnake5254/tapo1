package com.google.mlkit.vision.barcode.internal;

import android.content.Context;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbl;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbv;
import com.google.android.gms.internal.mlkit_vision_barcode.zzbw;
import com.google.android.gms.internal.mlkit_vision_barcode.zzeg;
import com.google.android.gms.internal.mlkit_vision_barcode.zzem;
import com.google.android.gms.internal.mlkit_vision_barcode.zzga;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.j;
import com.google.mlkit.vision.barcode.a;
import com.google.mlkit.vision.barcode.b;
import com.google.mlkit.vision.common.internal.VisionImageMetadataParcel;
import com.google.mlkit.vision.common.internal.c;
import com.google.mlkit.vision.common.internal.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@16.1.0 */
/* loaded from: classes2.dex */
public final class g extends com.google.mlkit.common.sdkinternal.g<List<a>, b.b.a.a.a.a> {

    /* renamed from: d  reason: collision with root package name */
    private static final d f4998d = d.a();
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    private static boolean f4999e = true;

    /* renamed from: f  reason: collision with root package name */
    private final Context f5000f;
    private final b g;
    private final zzeg h;
    private final com.google.mlkit.vision.common.internal.a i = new com.google.mlkit.vision.common.internal.a();
    @Nullable
    private a j;
    @Nullable
    private BarcodeDetector k;

    public g(@NonNull j jVar, @NonNull b bVar) {
        Preconditions.checkNotNull(jVar, "MlKitContext can not be null");
        Preconditions.checkNotNull(bVar, "BarcodeScannerOptions can not be null");
        this.f5000f = jVar.b();
        this.g = bVar;
        this.h = (zzeg) jVar.a(zzeg.class);
    }

    private static synchronized Frame k(@NonNull b.b.a.a.a.a aVar) throws MlKitException {
        synchronized (g.class) {
            if (aVar.d() == -1) {
                return new Frame.Builder().setBitmap(aVar.b()).setRotation(aVar.g()).build();
            } else if (aVar.d() == 17) {
                return new Frame.Builder().setImageData(aVar.c(), aVar.h(), aVar.e(), 17).setRotation(com.google.mlkit.vision.common.internal.b.a(aVar.g())).build();
            } else if (aVar.d() == 842094169) {
                return new Frame.Builder().setImageData(c.d().b(aVar, false), aVar.h(), aVar.e(), 17).setRotation(com.google.mlkit.vision.common.internal.b.a(aVar.g())).build();
            } else if (Build.VERSION.SDK_INT < 19 || aVar.d() != 35) {
                return new Frame.Builder().setBitmap(c.d().c(aVar)).build();
            } else {
                return new Frame.Builder().setImageData(aVar.f()[0].getBuffer(), aVar.h(), aVar.e(), 17).setRotation(com.google.mlkit.vision.common.internal.b.a(aVar.g())).build();
            }
        }
    }

    @WorkerThread
    private final void l(final zzbv zzbvVar, long j, @NonNull final b.b.a.a.a.a aVar, @Nullable List<a> list) {
        final ArrayList arrayList = new ArrayList();
        final ArrayList arrayList2 = new ArrayList();
        if (list != null) {
            for (a aVar2 : list) {
                arrayList.add(aVar2.d());
                arrayList2.add(aVar2.e());
            }
        }
        final long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        this.h.zza(new zzeg.zza(this, elapsedRealtime, zzbvVar, arrayList, arrayList2, aVar) { // from class: com.google.mlkit.vision.barcode.internal.f
            private final g a;

            /* renamed from: b  reason: collision with root package name */
            private final long f4993b;

            /* renamed from: c  reason: collision with root package name */
            private final zzbv f4994c;

            /* renamed from: d  reason: collision with root package name */
            private final List f4995d;

            /* renamed from: e  reason: collision with root package name */
            private final List f4996e;

            /* renamed from: f  reason: collision with root package name */
            private final b.b.a.a.a.a f4997f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f4993b = elapsedRealtime;
                this.f4994c = zzbvVar;
                this.f4995d = arrayList;
                this.f4996e = arrayList2;
                this.f4997f = aVar;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeg.zza
            public final zzbl.zzad.zza zza() {
                return this.a.i(this.f4993b, this.f4994c, this.f4995d, this.f4996e, this.f4997f);
            }
        }, zzbw.ON_DEVICE_BARCODE_DETECT);
        zzbl.zzc.zzb.zza zza = zzbl.zzc.zzb.zza().zza(zzbvVar).zza(f4999e);
        d dVar = f4998d;
        zzeg.zzb iVar = new zzeg.zzb(this) { // from class: com.google.mlkit.vision.barcode.internal.i
            private final g a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzeg.zzb
            public final zzbl.zzad.zza zza(Object obj, int i, zzbl.zzab zzabVar) {
                return this.a.j((zzbl.zzc.zzb) obj, i, zzabVar);
            }
        };
        this.h.zza((zzbl.zzc.zzb) ((zzga) zza.zza(zzem.zza(dVar.b(aVar), dVar.c(aVar))).zza(this.g.c()).zza(arrayList).zzb(arrayList2).zzg()), elapsedRealtime, zzbw.AGGREGATED_ON_DEVICE_BARCODE_DETECTION, iVar);
    }

    @Nullable
    @VisibleForTesting
    private final a m() throws MlKitException {
        if (DynamiteModule.getLocalVersion(this.f5000f, ModuleDescriptor.MODULE_ID) <= 0) {
            return null;
        }
        try {
            return l.asInterface(DynamiteModule.load(this.f5000f, DynamiteModule.PREFER_LOCAL, ModuleDescriptor.MODULE_ID).instantiate("com.google.mlkit.vision.barcode.BarcodeScannerCreator")).newBarcodeScanner(new BarcodeScannerOptionsParcel(this.g.a()));
        } catch (RemoteException | DynamiteModule.LoadingException e2) {
            throw new MlKitException("Failed to load barcode scanner module.", 14, e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    /* renamed from: n */
    public final synchronized List<a> h(@NonNull b.b.a.a.a.a aVar) throws MlKitException {
        ArrayList arrayList;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.i.a(aVar);
        Frame k = k(aVar);
        arrayList = new ArrayList();
        if (this.j != null) {
            try {
                for (h hVar : (List) ObjectWrapper.unwrap(this.j.a(ObjectWrapper.wrap(k), new VisionImageMetadataParcel(k.getMetadata().getWidth(), k.getMetadata().getHeight(), 0, SystemClock.elapsedRealtime(), k.getMetadata().getRotation())))) {
                    arrayList.add(new a(hVar));
                }
            } catch (RemoteException e2) {
                throw new MlKitException("Failed to run barcode scanner.", 14, e2);
            }
        } else {
            BarcodeDetector barcodeDetector = this.k;
            if (barcodeDetector == null) {
                l(zzbv.UNKNOWN_ERROR, elapsedRealtime, aVar, null);
                throw new MlKitException("Model source is unavailable. Please load the model resource first.", 14);
            } else if (barcodeDetector.isOperational()) {
                SparseArray<Barcode> detect = this.k.detect(k);
                for (int i = 0; i < detect.size(); i++) {
                    arrayList.add(new a(new j(detect.get(detect.keyAt(i)))));
                }
            } else {
                l(zzbv.MODEL_NOT_DOWNLOADED, elapsedRealtime, aVar, null);
                throw new MlKitException("Waiting for the barcode scanning model to be downloaded. Please wait.", 14);
            }
        }
        l(zzbv.NO_ERROR, elapsedRealtime, aVar, arrayList);
        f4999e = false;
        return arrayList;
    }

    private final boolean o() {
        return this.j != null;
    }

    @Override // com.google.mlkit.common.sdkinternal.l
    @WorkerThread
    public final synchronized void b() throws MlKitException {
        if (this.j == null) {
            this.j = m();
        }
        a aVar = this.j;
        if (aVar != null) {
            try {
                aVar.a_();
            } catch (RemoteException e2) {
                throw new MlKitException("Failed to start barcode scanner pipeline.", 14, e2);
            }
        } else {
            if (this.k == null) {
                this.k = new BarcodeDetector.Builder(this.f5000f).setBarcodeFormats(this.g.a()).build();
            }
        }
    }

    @Override // com.google.mlkit.common.sdkinternal.l
    @WorkerThread
    public final synchronized void d() {
        a aVar = this.j;
        if (aVar != null) {
            try {
                aVar.zzb();
            } catch (RemoteException e2) {
                Log.e("BarcodeScannerTask", "Failed to stop barcode scanner pipeline.", e2);
            }
            this.j = null;
        }
        BarcodeDetector barcodeDetector = this.k;
        if (barcodeDetector != null) {
            barcodeDetector.release();
            this.k = null;
        }
        f4999e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbl.zzad.zza i(long j, zzbv zzbvVar, List list, List list2, b.b.a.a.a.a aVar) {
        return zzbl.zzad.zzb().zza(o()).zza(zzbl.zzao.zza().zza(zzbl.zzaf.zza().zza(j).zza(zzbvVar).zza(f4999e).zzb(true).zzc(true)).zza(this.g.c()).zza(list).zzb(list2).zza(zzem.zza(aVar.d(), f4998d.c(aVar))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbl.zzad.zza j(zzbl.zzc.zzb zzbVar, int i, zzbl.zzab zzabVar) {
        return zzbl.zzad.zzb().zza(o()).zza(zzbl.zzc.zza().zza(i).zza(zzbVar).zza(zzabVar));
    }
}
