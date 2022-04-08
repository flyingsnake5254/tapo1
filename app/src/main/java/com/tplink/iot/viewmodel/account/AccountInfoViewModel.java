package com.tplink.iot.viewmodel.account;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tplink.cloud.bean.webservice.result.AccountAvatarResult;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.p;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.o;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.io.File;
import java.io.IOException;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes2.dex */
public class AccountInfoViewModel extends AndroidViewModel {

    /* renamed from: d  reason: collision with root package name */
    private String f9813d = null;

    /* renamed from: e  reason: collision with root package name */
    private MediatorLiveData<TCAccountBean> f9814e = new MediatorLiveData<>();

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<Boolean> f9815f = new MutableLiveData<>();
    private MutableLiveData<h> g = new MutableLiveData<>();
    private MutableLiveData<Boolean> h = new MutableLiveData<>();
    private o a = o.h0();

    /* renamed from: b  reason: collision with root package name */
    private TCAccountRepository f9811b = (TCAccountRepository) b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class);

    /* renamed from: c  reason: collision with root package name */
    private TPIoTClientManager f9812c = (TPIoTClientManager) b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);

    /* loaded from: classes2.dex */
    class a implements Observer<TCAccountBean> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable TCAccountBean tCAccountBean) {
            if (tCAccountBean != null) {
                AccountInfoViewModel.this.f9813d = tCAccountBean.getCloudUserName();
            }
            AccountInfoViewModel.this.f9814e.setValue(tCAccountBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements io.reactivex.g0.g<AccountAvatarResult> {
        b() {
        }

        /* renamed from: a */
        public void accept(AccountAvatarResult accountAvatarResult) throws Exception {
            AccountInfoViewModel.this.g.postValue(new h(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements io.reactivex.g0.g<Throwable> {
        c() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            AccountInfoViewModel.this.g.postValue(new h(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements j<byte[], t<AccountAvatarResult>> {
        d() {
        }

        /* renamed from: a */
        public t<AccountAvatarResult> apply(byte[] bArr) throws Exception {
            return AccountInfoViewModel.this.f9811b.b0("image/png", bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements j<Uri, byte[]> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Matrix f9819c;

        e(Matrix matrix) {
            this.f9819c = matrix;
        }

        /* renamed from: a */
        public byte[] apply(Uri uri) throws Exception {
            Bitmap m = AccountInfoViewModel.this.m(uri, this.f9819c);
            AccountInfoViewModel.this.g.postValue(new h(-1, m));
            return AccountInfoViewModel.this.n(m);
        }
    }

    /* loaded from: classes2.dex */
    class f implements io.reactivex.g0.a {
        f() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            b.d.c.a.e.l().d("");
            b.d.c.a.e.l().a("");
            b.d.n.f.b.l().clear();
            p.c();
            AccountInfoViewModel.this.h.postValue(Boolean.TRUE);
        }
    }

    /* loaded from: classes2.dex */
    class g implements io.reactivex.g0.g<io.reactivex.e0.c> {
        g() {
        }

        /* renamed from: a */
        public void accept(io.reactivex.e0.c cVar) throws Exception {
            AccountInfoViewModel.this.h.setValue(null);
        }
    }

    public AccountInfoViewModel(@NonNull Application application) {
        super(application);
        this.f9814e.addSource(this.f9811b.r(), new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap m(Uri uri, Matrix matrix) throws IOException {
        Bitmap bitmap;
        Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(getApplication().getContentResolver(), uri);
        int width = bitmap2.getWidth();
        int height = bitmap2.getHeight();
        int i = width > height ? height : width;
        if (matrix != null) {
            bitmap = Bitmap.createBitmap(bitmap2, (width - i) / 2, (height - i) / 2, i, i, matrix, true);
        } else {
            bitmap = Bitmap.createBitmap(bitmap2, (width - i) / 2, (height - i) / 2, i, i);
        }
        bitmap2.isRecycled();
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d2 -> B:57:0x00d9). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] n(android.graphics.Bitmap r15) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tplink.iot.viewmodel.account.AccountInfoViewModel.n(android.graphics.Bitmap):byte[]");
    }

    private void o(MutableLiveData<Boolean> mutableLiveData) {
        if (this.f9811b.y()) {
            mutableLiveData.setValue(Boolean.TRUE);
        } else {
            mutableLiveData.setValue(null);
        }
    }

    private int v(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e2) {
            b.d.w.c.a.d(e2.toString());
            return 0;
        }
    }

    public void A(File file) {
        if (file == null) {
            this.g.setValue(new h(1));
            return;
        }
        int v = v(file.getAbsolutePath());
        Matrix matrix = new Matrix();
        matrix.postRotate(v);
        z(Uri.fromFile(file), matrix);
    }

    public LiveData<TCAccountBean> p() {
        return this.f9814e;
    }

    public LiveData<h> r() {
        return this.g;
    }

    public LiveData<Boolean> s() {
        return this.f9815f;
    }

    public String t() {
        String f2 = this.a.f(this.f9813d, "");
        if (!f2.isEmpty()) {
            if (new File(getApplication().getCacheDir().getAbsolutePath() + "/image_cache/" + f2).exists()) {
                return f2;
            }
        }
        return "";
    }

    public LiveData<Boolean> u() {
        return this.h;
    }

    public void w() {
        this.f9812c.d3().C(io.reactivex.l0.a.c()).l(new g()).h(new f()).y();
    }

    public void x() {
        o(this.f9815f);
    }

    public void y(String str) {
        String f2 = this.a.f(this.f9813d, "");
        String substring = str.substring(str.lastIndexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR) + 1);
        if (!f2.equals(substring)) {
            if (!f2.isEmpty()) {
                File file = new File(getApplication().getCacheDir().getAbsolutePath() + "/image_cache/" + f2);
                if (file.exists()) {
                    file.delete();
                }
            }
            this.a.k(this.f9813d, substring);
        }
    }

    public void z(Uri uri, Matrix matrix) {
        if (!this.f9811b.y()) {
            this.g.setValue(null);
        } else {
            q.f0(uri).g0(new e(matrix)).N(new d()).L0(io.reactivex.l0.a.c()).H0(new b(), new c());
        }
    }

    /* loaded from: classes2.dex */
    public class h {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private Bitmap f9822b;

        public h(int i, Bitmap bitmap) {
            this.a = i;
            this.f9822b = bitmap;
        }

        public int a() {
            return this.a;
        }

        public Bitmap b() {
            return this.f9822b;
        }

        public h(int i) {
            this.a = i;
        }
    }
}
