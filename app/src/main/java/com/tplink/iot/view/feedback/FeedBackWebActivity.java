package com.tplink.iot.view.feedback;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.tplink.iot.R;
import com.tplink.iot.Utils.StatusBarUtils;
import com.tplink.iot.Utils.TPMaterialDialog;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.widget.CameraLoadingView;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.business.repo.CommonCameraRepository;
import com.tplink.libtpnetwork.cameranetwork.business.repo.LdcDianoseSettingRepository;
import com.tplink.libtpnetwork.cameranetwork.model.CameraComponent;
import com.tplink.libtpnetwork.cameranetwork.model.ComponentType;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FeedBackWebActivity extends BaseActivity implements View.OnClickListener {
    private static File y;
    private String H3;
    public ValueCallback<Uri> K3;
    public ValueCallback<Uri[]> L3;
    private boolean M3;
    private CameraLoadingView N3;
    private WebView z = null;
    private ProgressBar p0 = null;
    private View p1 = null;
    private MenuItem p2 = null;
    public TPMaterialDialog p3 = null;
    private List<String> I3 = new ArrayList();
    private Map<String, String> J3 = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements DialogInterface.OnCancelListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            FeedBackWebActivity.this.O1();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedBackWebActivity.this.T1();
            FeedBackWebActivity.this.p3.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FeedBackWebActivity.this.S1();
            FeedBackWebActivity.this.p3.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements TPMaterialDialogV2.d {
        d() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            FeedBackWebActivity.this.startActivityForResult(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + FeedBackWebActivity.this.getPackageName())), 5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e implements TPMaterialDialogV2.d {
        e() {
        }

        @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
        public void onClick(View view) {
            FeedBackWebActivity.this.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + FeedBackWebActivity.this.getPackageName())));
        }
    }

    /* loaded from: classes2.dex */
    public class f {

        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FeedBackWebActivity.this.finish();
            }
        }

        /* loaded from: classes2.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FeedBackWebActivity.this.finish();
            }
        }

        public f() {
        }

        @JavascriptInterface
        public String getAppParameters() {
            return FeedBackWebActivity.this.H3;
        }

        @JavascriptInterface
        public String getDutEncryptLog(String str) {
            if (str == null) {
                return "";
            }
            String str2 = (String) FeedBackWebActivity.this.J3.get(com.tplink.libtpnetwork.cameranetwork.util.f.a(str));
            return str2 != null ? str2 : "";
        }

        @JavascriptInterface
        public void postMessage(String str) {
            if (str != null) {
                try {
                    String string = new JSONObject(str).getString("message");
                    if (string != null) {
                        char c2 = 65535;
                        int hashCode = string.hashCode();
                        if (hashCode != -1357520532) {
                            if (hashCode == 348678395 && string.equals("submitted")) {
                                c2 = 0;
                            }
                        } else if (string.equals("closed")) {
                            c2 = 1;
                        }
                        if (c2 == 0) {
                            ((BaseActivity) FeedBackWebActivity.this).f6070c.postDelayed(new a(), 500L);
                        } else if (c2 == 1) {
                            ((BaseActivity) FeedBackWebActivity.this).f6070c.postDelayed(new b(), 500L);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g extends WebChromeClient {
        private g() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i) {
            if (i == 100) {
                FeedBackWebActivity.this.p0.setVisibility(8);
            } else {
                FeedBackWebActivity.this.p0.setProgress(i);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            FeedBackWebActivity.this.c1(str);
            super.onReceivedTitle(webView, str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            FeedBackWebActivity.this.L1(valueCallback);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
            FeedBackWebActivity.this.K1(valueCallback);
        }

        /* synthetic */ g(FeedBackWebActivity feedBackWebActivity, a aVar) {
            this();
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            FeedBackWebActivity.this.K1(valueCallback);
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback) {
            FeedBackWebActivity.this.K1(valueCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class h extends WebViewClient {

        /* loaded from: classes2.dex */
        class a implements TPMaterialDialogV2.d {
            final /* synthetic */ String a;

            a(String str) {
                this.a = str;
            }

            @Override // com.tplink.iot.Utils.TPMaterialDialogV2.d
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.DIAL");
                intent.setData(Uri.parse(this.a));
                FeedBackWebActivity.this.startActivity(intent);
            }
        }

        private h() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (FeedBackWebActivity.this.p2 != null) {
                FeedBackWebActivity.this.p2.setVisible(FeedBackWebActivity.this.z != null && FeedBackWebActivity.this.z.canGoBack());
            }
            if (!FeedBackWebActivity.this.M3 && FeedBackWebActivity.this.p1 != null && FeedBackWebActivity.this.z != null) {
                FeedBackWebActivity.this.p1.setVisibility(8);
                FeedBackWebActivity.this.z.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            FeedBackWebActivity.this.M3 = true;
            if (!(FeedBackWebActivity.this.p1 == null || FeedBackWebActivity.this.z == null)) {
                FeedBackWebActivity.this.p1.setVisibility(0);
                FeedBackWebActivity.this.z.setVisibility(8);
            }
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        @RequiresApi(api = 21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith("tel:")) {
                new TPMaterialDialogV2.Builder(FeedBackWebActivity.this).k(str.substring(4), R.color.feedback_call_title_color).l(R.string.common_cancel, R.color.common_iot_light_black, null).o(R.string.feed_back_hotline_call, R.color.common_iot_main_blue, new a(str)).g(8, 8).create().show();
                return true;
            } else if (str.startsWith("mailto:")) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.setData(Uri.parse(str));
                FeedBackWebActivity.this.startActivity(intent);
                return true;
            } else {
                FeedBackWebActivity.this.p0.setProgress(0);
                FeedBackWebActivity.this.p0.setVisibility(0);
                return super.shouldOverrideUrlLoading(webView, str);
            }
        }

        /* synthetic */ h(FeedBackWebActivity feedBackWebActivity, a aVar) {
            this();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            FeedBackWebActivity.this.M3 = true;
            if (!(FeedBackWebActivity.this.p1 == null || FeedBackWebActivity.this.z == null)) {
                FeedBackWebActivity.this.p1.setVisibility(0);
                FeedBackWebActivity.this.z.setVisibility(8);
            }
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @TargetApi(23)
    private void A1() {
        ArrayList arrayList = new ArrayList();
        if (o.h0().m0()) {
            t1(arrayList, "android.permission.CAMERA");
            t1(arrayList, "android.permission.READ_EXTERNAL_STORAGE");
            if (com.tplink.iot.Utils.a1.b.c()) {
                t1(arrayList, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
        } else if (!t1(arrayList, "android.permission.CAMERA")) {
            Q1();
            O1();
            return;
        } else if (B1(arrayList)) {
            R1();
            O1();
            return;
        }
        if (!arrayList.isEmpty()) {
            requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 4);
        } else {
            M1();
        }
    }

    private boolean B1(List<String> list) {
        if (com.tplink.iot.Utils.a1.b.c()) {
            return !t1(list, "android.permission.READ_EXTERNAL_STORAGE") || !t1(list, "android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return !t1(list, "android.permission.READ_EXTERNAL_STORAGE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C1 */
    public /* synthetic */ t D1(LdcDianoseSettingRepository ldcDianoseSettingRepository, final ALCameraDevice aLCameraDevice, CameraComponent cameraComponent) throws Exception {
        if (cameraComponent.hasComponent(ComponentType.DIAGNOSE)) {
            return ldcDianoseSettingRepository.w().g0(new j() { // from class: com.tplink.iot.view.feedback.c
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return FeedBackWebActivity.this.H1(aLCameraDevice, (String) obj);
                }
            }).q0(Boolean.TRUE);
        }
        return q.f0(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E1 */
    public /* synthetic */ void F1() throws Exception {
        this.N3.a();
        this.z.setVisibility(0);
        J1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G1 */
    public /* synthetic */ Boolean H1(ALCameraDevice aLCameraDevice, String str) throws Exception {
        if (!TextUtils.isEmpty(aLCameraDevice.getMacAddress())) {
            this.J3.put(com.tplink.libtpnetwork.cameranetwork.util.f.a(aLCameraDevice.getMacAddress()), str);
        }
        return Boolean.TRUE;
    }

    private void J1() {
        if (t0.g(this)) {
            this.M3 = false;
            c1("");
            this.p0.setProgress(0);
            this.p0.setVisibility(0);
            this.p1.setVisibility(8);
            WebView webView = this.z;
            webView.loadUrl("https://www.tapo.com/app/#/feedback2?locale=" + com.tplink.iot.model.about.d.f());
            return;
        }
        this.M3 = true;
        this.p1.setVisibility(0);
        this.z.setVisibility(8);
        this.p0.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1(ValueCallback<Uri> valueCallback) {
        this.K3 = valueCallback;
        P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L1(ValueCallback<Uri[]> valueCallback) {
        this.L3 = valueCallback;
        P1();
    }

    private void M1() {
        Uri uri;
        File x1 = x1(this);
        if (x1 == null) {
            s0.p(this, getString(R.string.common_operation_failed));
            return;
        }
        File file = new File(x1, "tapo_feedback");
        if (!file.exists()) {
            file.mkdirs();
        }
        y = new File(file + File.separator + "img_" + String.valueOf(System.currentTimeMillis()) + ".png");
        if (Build.VERSION.SDK_INT < 21) {
            uri = Uri.fromFile(y);
        } else {
            uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", y);
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        startActivityForResult(intent, 2);
    }

    private void N1() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O1() {
        ValueCallback<Uri[]> valueCallback = this.L3;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.L3 = null;
        }
        ValueCallback<Uri> valueCallback2 = this.K3;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.K3 = null;
        }
    }

    private void P1() {
        if (this.p3 == null) {
            View inflate = getLayoutInflater().inflate(R.layout.layout_change_icon_dlg, (ViewGroup) null);
            TPMaterialDialog a2 = new TPMaterialDialog.Builder(this).d(inflate).setCancelable(true).c(false).create();
            this.p3 = a2;
            a2.setOnCancelListener(new a());
            View findViewById = inflate.findViewById(R.id.dlg_take_photo);
            View findViewById2 = inflate.findViewById(R.id.dlg_chose_album);
            findViewById.setOnClickListener(new b());
            findViewById2.setOnClickListener(new c());
        }
        this.p3.show();
    }

    private void Q1() {
        new TPMaterialDialogV2.Builder(this).setTitle(R.string.common_permissions).setMessage(R.string.login_deny_storage_permission_message).p(R.string.action_settings, new e()).g(8, 8).l(R.string.common_cancel, R.color.common_iot_light_black, null).show();
    }

    private void R1() {
        new TPMaterialDialogV2.Builder(this).setTitle(R.string.login_deny_storage_permission_title).setMessage(R.string.login_deny_storage_permission_message).p(R.string.action_settings, new d()).g(8, 8).l(R.string.common_cancel, R.color.common_iot_light_black, null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S1() {
        if (Build.VERSION.SDK_INT < 23) {
            N1();
        } else if (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 3);
        } else {
            N1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T1() {
        if (Build.VERSION.SDK_INT >= 23) {
            A1();
        } else {
            M1();
        }
    }

    @TargetApi(23)
    private boolean t1(List<String> list, String str) {
        if (checkSelfPermission(str) == 0) {
            return true;
        }
        list.add(str);
        return shouldShowRequestPermissionRationale(str);
    }

    private void u1() {
        if (this.z.canGoBack()) {
            this.z.goBack();
        } else {
            finish();
        }
    }

    private q<Boolean> v1(String str) {
        String g2 = b.d.w.h.a.g(str);
        BaseALIoTDevice I1 = TPIoTClientManager.I1(g2);
        if (!(I1 instanceof ALCameraDevice)) {
            return q.f0(Boolean.FALSE);
        }
        final ALCameraDevice aLCameraDevice = (ALCameraDevice) I1;
        if (aLCameraDevice.isRemoteOnly()) {
            return q.f0(Boolean.FALSE);
        }
        final LdcDianoseSettingRepository ldcDianoseSettingRepository = (LdcDianoseSettingRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(g2, LdcDianoseSettingRepository.class);
        return ((CommonCameraRepository) com.tplink.libtpnetwork.IoTNetwork.repository.kb.e.c(g2, CommonCameraRepository.class)).K0().N(new j() { // from class: com.tplink.iot.view.feedback.b
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FeedBackWebActivity.this.D1(ldcDianoseSettingRepository, aLCameraDevice, (CameraComponent) obj);
            }
        });
    }

    private void w1() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle extras = getIntent().getExtras();
            this.H3 = extras.getString("feed_back_faq_params", "");
            this.I3 = extras.getStringArrayList("feed_back_faq_devices");
        }
    }

    public static File x1(@NonNull Context context) {
        File file;
        if (Build.VERSION.SDK_INT >= 29) {
            file = context.getApplicationContext().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        } else if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        } else {
            file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    @SuppressLint({"JavascriptInterface"})
    private void y1() {
        c1("");
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.feedback_progressbar);
        this.p0 = progressBar;
        progressBar.setMax(100);
        this.p0.setVisibility(0);
        View findViewById = findViewById(R.id.feed_back_reflash_layout);
        this.p1 = findViewById;
        findViewById.setVisibility(8);
        this.p1.setOnClickListener(this);
        this.z = (WebView) findViewById(R.id.feed_back_webview);
        z1();
        this.z.setWebViewClient(new h(this, null));
        this.z.setWebChromeClient(new g(this, null));
        this.z.addJavascriptInterface(new f(), "uploadDeviceInfo");
        this.N3 = (CameraLoadingView) findViewById(R.id.live_loading_view);
    }

    private void z1() {
        this.z.getSettings().setJavaScriptEnabled(true);
        this.z.getSettings().setDefaultTextEncodingName("UTF-8");
        this.z.getSettings().setAllowFileAccess(true);
        this.z.getSettings().setAllowFileAccessFromFileURLs(true);
        this.z.getSettings().setAllowContentAccess(true);
        this.z.getSettings().setDomStorageEnabled(true);
        this.z.getSettings().setAppCacheEnabled(false);
        this.z.getSettings().setCacheMode(2);
        this.z.getSettings().setSupportZoom(false);
        this.z.getSettings().setBuiltInZoomControls(false);
    }

    public void I1() {
        this.N3.b();
        this.z.setVisibility(8);
        ArrayList arrayList = new ArrayList();
        for (String str : this.I3) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(v1(str));
            }
        }
        q.j0(arrayList).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).y(new io.reactivex.g0.a() { // from class: com.tplink.iot.view.feedback.a
            @Override // io.reactivex.g0.a
            public final void run() {
                FeedBackWebActivity.this.F1();
            }
        }).F0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        String b2;
        String str;
        if (i2 != -1) {
            O1();
        } else if (i == 1) {
            Uri data = intent == null ? null : intent.getData();
            if (!(data == null || !com.tplink.iot.d.a.a.equalsIgnoreCase("android4.4.4") || (b2 = d.b(this, data)) == null)) {
                if (!b2.startsWith("file://")) {
                    b2 = "file://" + b2;
                }
                data = Uri.parse(b2);
            }
            ValueCallback<Uri> valueCallback = this.K3;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(data);
            }
            ValueCallback<Uri[]> valueCallback2 = this.L3;
            if (valueCallback2 != null) {
                valueCallback2.onReceiveValue(new Uri[]{data});
            }
            this.K3 = null;
            this.L3 = null;
        } else if (i != 2) {
            O1();
        } else {
            try {
                str = MediaStore.Images.Media.insertImage(getContentResolver(), y.getAbsolutePath(), "", "");
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                str = null;
            }
            Uri parse = str != null ? Uri.parse(str) : null;
            if (com.tplink.iot.d.a.a.equalsIgnoreCase("android4.4.4")) {
                parse = Uri.fromFile(y);
            }
            ValueCallback<Uri> valueCallback3 = this.K3;
            if (valueCallback3 != null) {
                valueCallback3.onReceiveValue(parse);
            }
            ValueCallback<Uri[]> valueCallback4 = this.L3;
            if (valueCallback4 != null) {
                valueCallback4.onReceiveValue(new Uri[]{parse});
            }
            this.K3 = null;
            this.L3 = null;
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        u1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.feed_back_reflash_layout) {
            J1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (com.tplink.iot.core.o.a() != 0) {
            setContentView(R.layout.activity_feed_back_webview);
            w1();
            y1();
            List<String> list = this.I3;
            if (list == null || list.isEmpty()) {
                J1();
            } else {
                I1();
            }
            StatusBarUtils.n(this, ContextCompat.getColor(this, R.color.common_colorPrimaryDark));
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.common_close, menu);
        MenuItem findItem = menu.findItem(R.id.common_close);
        this.p2 = findItem;
        findItem.setVisible(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        WebView webView;
        super.onDestroy();
        if (com.tplink.iot.core.o.a() != 0 && (webView = this.z) != null) {
            webView.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            this.z.clearHistory();
            ((ViewGroup) this.z.getParent()).removeView(this.z);
            this.z.destroy();
            this.z = null;
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.common_close) {
            finish();
            return true;
        } else if (itemId != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            u1();
            return false;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = true;
        if (i == 3) {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (iArr[i2] != 0) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                N1();
                return;
            }
            R1();
            O1();
        } else if (i == 4) {
            boolean z3 = true;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if ("android.permission.CAMERA".equals(strArr[i3])) {
                    if (iArr[i3] != 0) {
                        z2 = false;
                    }
                } else if (("android.permission.READ_EXTERNAL_STORAGE".equals(strArr[i3]) || "android.permission.WRITE_EXTERNAL_STORAGE".equals(strArr[i3])) && iArr[i3] != 0) {
                    z3 = false;
                }
            }
            if (z2 && z3) {
                try {
                    M1();
                } catch (Exception e2) {
                    b.d.w.c.a.a("permission error --- " + e2.getMessage());
                }
            } else if (!z2) {
                Q1();
                O1();
            } else {
                R1();
                O1();
            }
            o.h0().B0();
        }
    }
}
