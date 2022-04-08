package com.airbnb.lottie.network;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.util.Pair;
import com.airbnb.lottie.d;
import com.airbnb.lottie.e;
import com.airbnb.lottie.l;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.ZipInputStream;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class b {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1045b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final a f1046c;

    private b(Context context, String str, @Nullable String str2) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f1045b = str;
        if (str2 == null) {
            this.f1046c = null;
        } else {
            this.f1046c = new a(applicationContext);
        }
    }

    @Nullable
    @WorkerThread
    private d a() {
        Pair<FileExtension, InputStream> a;
        l<d> lVar;
        a aVar = this.f1046c;
        if (aVar == null || (a = aVar.a(this.f1045b)) == null) {
            return null;
        }
        FileExtension fileExtension = a.first;
        InputStream inputStream = a.second;
        if (fileExtension == FileExtension.ZIP) {
            lVar = e.s(new ZipInputStream(inputStream), this.f1045b);
        } else {
            lVar = e.i(inputStream, this.f1045b);
        }
        if (lVar.b() != null) {
            return lVar.b();
        }
        return null;
    }

    @WorkerThread
    private l<d> b() {
        try {
            return c();
        } catch (IOException e2) {
            return new l<>(e2);
        }
    }

    @WorkerThread
    private l<d> c() throws IOException {
        com.airbnb.lottie.v.d.a("Fetching " + this.f1045b);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f1045b).openConnection();
        httpURLConnection.setRequestMethod(SSLClient.HTTP_GET);
        try {
            httpURLConnection.connect();
            if (httpURLConnection.getErrorStream() == null && httpURLConnection.getResponseCode() == 200) {
                l<d> g = g(httpURLConnection);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(g.b() != null);
                com.airbnb.lottie.v.d.a(sb.toString());
                return g;
            }
            String f2 = f(httpURLConnection);
            return new l<>(new IllegalArgumentException("Unable to fetch " + this.f1045b + ". Failed with " + httpURLConnection.getResponseCode() + "\n" + f2));
        } catch (Exception e2) {
            return new l<>(e2);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static l<d> e(Context context, String str, @Nullable String str2) {
        return new b(context, str, str2).d();
    }

    private String f(HttpURLConnection httpURLConnection) throws IOException {
        httpURLConnection.getResponseCode();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                throw th;
            }
        }
        bufferedReader.close();
        return sb.toString();
    }

    @Nullable
    private l<d> g(HttpURLConnection httpURLConnection) throws IOException {
        l<d> lVar;
        FileExtension fileExtension;
        String contentType = httpURLConnection.getContentType();
        if (contentType == null) {
            contentType = HttpHeaders.Values.APPLICATION_JSON;
        }
        if (contentType.contains("application/zip")) {
            com.airbnb.lottie.v.d.a("Handling zip response.");
            fileExtension = FileExtension.ZIP;
            a aVar = this.f1046c;
            if (aVar == null) {
                lVar = e.s(new ZipInputStream(httpURLConnection.getInputStream()), null);
            } else {
                lVar = e.s(new ZipInputStream(new FileInputStream(aVar.f(this.f1045b, httpURLConnection.getInputStream(), fileExtension))), this.f1045b);
            }
        } else {
            com.airbnb.lottie.v.d.a("Received json response.");
            fileExtension = FileExtension.JSON;
            a aVar2 = this.f1046c;
            if (aVar2 == null) {
                lVar = e.i(httpURLConnection.getInputStream(), null);
            } else {
                lVar = e.i(new FileInputStream(new File(aVar2.f(this.f1045b, httpURLConnection.getInputStream(), fileExtension).getAbsolutePath())), this.f1045b);
            }
        }
        if (!(this.f1046c == null || lVar.b() == null)) {
            this.f1046c.e(this.f1045b, fileExtension);
        }
        return lVar;
    }

    @WorkerThread
    public l<d> d() {
        d a = a();
        if (a != null) {
            return new l<>(a);
        }
        com.airbnb.lottie.v.d.a("Animation for " + this.f1045b + " not found in cache. Fetching from network.");
        return b();
    }
}
