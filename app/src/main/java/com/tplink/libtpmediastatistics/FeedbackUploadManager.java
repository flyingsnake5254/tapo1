package com.tplink.libtpmediastatistics;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.d.p.d;
import io.reactivex.e0.c;
import io.reactivex.g0.j;
import io.reactivex.l0.a;
import io.reactivex.q;
import io.reactivex.t;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class FeedbackUploadManager {
    private static final String TAG = "FeedbackUploadManager";
    private static final int TIME_SEC = 200;
    private String clientType;
    private boolean debug;
    private ExecutorService executorService;
    private LinkedBlockingQueue<String> feedbackQueue;
    private String host;
    private c payloadUploadDisposable;
    private int port;
    private String token;

    /* loaded from: classes3.dex */
    private static class SingletonHolder {
        private static final FeedbackUploadManager INSTANCE = new FeedbackUploadManager();

        private SingletonHolder() {
        }
    }

    public static FeedbackUploadManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$initSSLClient$0 */
    public /* synthetic */ t a(Long l) throws Exception {
        if (this.feedbackQueue.isEmpty()) {
            return q.f0(Boolean.FALSE);
        }
        return uploadPayload(this.feedbackQueue.take());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$uploadPayload$1(String str) throws Exception {
        return !TextUtils.isEmpty(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$uploadPayload$2 */
    public /* synthetic */ t b(String str) throws Exception {
        uploadAsync(str);
        return q.f0(Boolean.TRUE);
    }

    private void uploadAsync(String str) {
        Throwable th;
        IOException e2;
        SSLClient sSLClient;
        SSLClient sSLClient2 = null;
        try {
            try {
                sSLClient = new SSLClient(this.host, this.port);
            } catch (IOException e3) {
                e2 = e3;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            sSLClient.setClientType(this.clientType);
            sSLClient.setLoginToken(this.token);
            if (!sSLClient.isSocketAvailable()) {
                sSLClient.renewSocket();
            }
            sSLClient.connect();
            sSLClient.sendPayload(str);
            int respondCode = sSLClient.getRespondCode();
            d.a(TAG, "code " + respondCode);
            if (respondCode == 200) {
                Map<String, String> respondHeader = sSLClient.getRespondHeader();
                if (this.debug) {
                    for (Map.Entry<String, String> entry : respondHeader.entrySet()) {
                        d.a(TAG, "key " + entry.getKey() + " value " + entry.getValue());
                    }
                }
                String str2 = new String(sSLClient.getRaw());
                d.a(TAG, "result " + str2);
            }
            sSLClient.disconnect();
        } catch (IOException e4) {
            e2 = e4;
            sSLClient2 = sSLClient;
            e2.printStackTrace();
            d.a(TAG, "e " + e2.toString());
            if (sSLClient2 != null) {
                sSLClient2.disconnect();
            }
        } catch (Throwable th3) {
            th = th3;
            sSLClient2 = sSLClient;
            if (sSLClient2 != null) {
                sSLClient2.disconnect();
            }
            throw th;
        }
    }

    private q<Boolean> uploadPayload(String str) {
        return q.f0(str).L(a.f12665c).N(new j() { // from class: com.tplink.libtpmediastatistics.c
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return FeedbackUploadManager.this.b((String) obj);
            }
        }).L0(a.b(this.executorService));
    }

    public void destroy() {
        c cVar = this.payloadUploadDisposable;
        if (cVar != null) {
            cVar.dispose();
            this.payloadUploadDisposable = null;
        }
        this.feedbackQueue.clear();
    }

    public void initSSLClient(String str, int i, String str2, String str3) {
        this.host = str;
        this.port = i;
        this.clientType = str2;
        this.token = str3;
        if (this.payloadUploadDisposable == null) {
            this.payloadUploadDisposable = q.c0(200L, TimeUnit.MILLISECONDS).N(new j() { // from class: com.tplink.libtpmediastatistics.b
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return FeedbackUploadManager.this.a((Long) obj);
                }
            }).L0(a.c()).F0();
        }
    }

    public void offerFeedbackPayload(String str) {
        this.feedbackQueue.offer(str);
    }

    private FeedbackUploadManager() {
        this.debug = false;
        this.feedbackQueue = new LinkedBlockingQueue<>();
        this.executorService = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.tplink.libtpmediastatistics.FeedbackUploadManager.1
            private final AtomicInteger count = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(@NonNull Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("pool-FeedbackUpload.executorService-" + this.count.incrementAndGet());
                return thread;
            }
        });
    }
}
