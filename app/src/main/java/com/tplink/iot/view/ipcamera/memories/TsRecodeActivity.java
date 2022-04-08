package com.tplink.iot.view.ipcamera.memories;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import b.d.y.a;
import com.tplink.iot.R;
import com.tplink.iot.base.BaseActivity;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.b.l;
import kotlin.p;

@Deprecated
/* loaded from: classes2.dex */
public class TsRecodeActivity extends BaseActivity {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public /* synthetic */ void f1() {
        Toast.makeText(this, "File not found!", 1).show();
    }

    private /* synthetic */ p g1() {
        runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.memories.n
            @Override // java.lang.Runnable
            public final void run() {
                TsRecodeActivity.this.f1();
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i1 */
    public /* synthetic */ void j1() {
        Toast.makeText(this, "Transcode successfully!", 1).show();
    }

    private /* synthetic */ p k1() {
        runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.memories.p
            @Override // java.lang.Runnable
            public final void run() {
                TsRecodeActivity.this.j1();
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public /* synthetic */ void n1() {
        Toast.makeText(this, "Fail!", 1).show();
    }

    private /* synthetic */ p o1(IOException iOException) {
        runOnUiThread(new Runnable() { // from class: com.tplink.iot.view.ipcamera.memories.q
            @Override // java.lang.Runnable
            public final void run() {
                TsRecodeActivity.this.n1();
            }
        });
        iOException.printStackTrace();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ p q1() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void s1(String str, String str2, View view) {
        new a().h(new File(str), new File(str2), 10, new kotlin.jvm.b.a() { // from class: com.tplink.iot.view.ipcamera.memories.o
            @Override // kotlin.jvm.b.a
            public final Object invoke() {
                TsRecodeActivity.this.h1();
                return null;
            }
        }, new kotlin.jvm.b.a() { // from class: com.tplink.iot.view.ipcamera.memories.m
            @Override // kotlin.jvm.b.a
            public final Object invoke() {
                TsRecodeActivity.this.l1();
                return null;
            }
        }, new l() { // from class: com.tplink.iot.view.ipcamera.memories.s
            @Override // kotlin.jvm.b.l
            public final Object invoke(Object obj) {
                TsRecodeActivity.this.p1((IOException) obj);
                return null;
            }
        }, r.f8761c);
    }

    public /* synthetic */ p h1() {
        g1();
        return null;
    }

    public /* synthetic */ p l1() {
        k1();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_ts_recode);
        final String str = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/segment-mp3.ts";
        final String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/result.mp4";
        findViewById(R.id.transcoder_start_tv).setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.memories.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TsRecodeActivity.this.s1(str, str2, view);
            }
        });
    }

    public /* synthetic */ p p1(IOException iOException) {
        o1(iOException);
        return null;
    }
}
