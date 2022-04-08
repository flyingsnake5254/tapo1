package com.tplink.iot.viewmodel.cloudvideo;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.tplink.iot.model.cloudvideo.CloudVideoItem;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.d0;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import io.reactivex.e0.c;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.v;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/* loaded from: classes2.dex */
public class VideoPlayerViewModel extends AndroidViewModel {
    public ALCameraDevice a;

    /* renamed from: b  reason: collision with root package name */
    private String f9924b = "";

    /* renamed from: c  reason: collision with root package name */
    private SingleLiveEvent<Boolean> f9925c = new SingleLiveEvent<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements v<Boolean> {
        a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            if (bool != null && bool.booleanValue()) {
                VideoPlayerViewModel.this.f9925c.postValue(Boolean.TRUE);
            }
        }

        @Override // io.reactivex.v
        public void onComplete() {
        }

        @Override // io.reactivex.v
        public void onError(Throwable th) {
        }

        @Override // io.reactivex.v
        public void onSubscribe(c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements s<Boolean> {
        final /* synthetic */ Bitmap a;

        b(Bitmap bitmap) {
            this.a = bitmap;
        }

        @Override // io.reactivex.s
        public void subscribe(r<Boolean> rVar) throws Exception {
            rVar.onNext(Boolean.valueOf(VideoPlayerViewModel.this.i(this.a)));
            rVar.onComplete();
        }
    }

    public VideoPlayerViewModel(@NonNull Application application) {
        super(application);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();
        sb.append(b.d.q.b.p.b.h());
        String str = File.separator;
        sb.append(str);
        sb.append("cloudvideo");
        sb.append(str);
        sb.append(valueOf);
        sb.append(".jpg");
        String sb2 = sb.toString();
        b.d.q.b.p.b.u(this.a, valueOf, sb2, -1);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(sb2));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            bitmap.recycle();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void p(ALCameraDevice aLCameraDevice) {
        if (aLCameraDevice != null && !d0.a(this.a, aLCameraDevice)) {
            this.a = aLCameraDevice;
        }
    }

    public void h(Bitmap bitmap) {
        if (bitmap != null) {
            q.m(new b(bitmap)).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).a(new a());
        }
    }

    public LiveData<Boolean> j() {
        return this.f9925c;
    }

    public CloudVideoItem k(String str, List<CloudVideoItem> list) {
        if (!(str == null || list == null)) {
            for (CloudVideoItem cloudVideoItem : list) {
                if (str.equals(cloudVideoItem.getCloudVideo().getUuid())) {
                    return cloudVideoItem;
                }
            }
        }
        return null;
    }

    public boolean l(long j) {
        return System.currentTimeMillis() > j;
    }

    public void m(String str, int i) {
        b.d.q.b.p.b.u(this.a, String.valueOf(System.currentTimeMillis()), str, i);
    }

    public void n(String str) {
        if (str == null) {
            str = "";
        }
        this.f9924b = str;
        p(TextUtils.isEmpty(str) ? null : TPIoTClientManager.K1(this.f9924b).getCameraDevice());
    }

    public void o(String str, ALCameraDevice aLCameraDevice) {
        if (str == null) {
            str = "";
        }
        this.f9924b = str;
        p(aLCameraDevice);
    }
}
