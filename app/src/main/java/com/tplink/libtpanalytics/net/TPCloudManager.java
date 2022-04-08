package com.tplink.libtpanalytics.net;

import b.d.b.c.j;
import b.d.b.f.a;
import com.google.gson.Gson;
import com.google.gson.d;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.cloud.bean.webservice.params.DataCollectRequestParams;
import com.tplink.cloud.context.b;
import com.tplink.libtpanalytics.core.define.c;
import io.reactivex.q;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class TPCloudManager extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final Gson f11988c = new d().c().b();

    /* renamed from: d  reason: collision with root package name */
    private final j f11989d;

    /* renamed from: e  reason: collision with root package name */
    private c f11990e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicInteger f11991f = new AtomicInteger(0);
    private volatile boolean g = false;

    public TPCloudManager(b bVar) {
        super(bVar);
        this.f11989d = (j) bVar.d().R1(j.class);
    }

    public void d(c cVar) {
        if (!this.g) {
            this.f11990e = cVar;
            this.g = true;
        }
    }

    public q<CloudResult> e(DataCollectRequestParams dataCollectRequestParams) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis() / 1000);
        String str2 = "";
        sb.append(str2);
        String sb2 = sb.toString();
        String str3 = this.f11991f.getAndAdd(1) + str2;
        try {
            str = com.tplink.libtpanalytics.utils.l.c.e(f11988c.u(dataCollectRequestParams));
        } catch (Exception e2) {
            e2.printStackTrace();
            str = str2;
        }
        try {
            str2 = com.tplink.libtpanalytics.utils.l.b.a(str + "\n" + sb2 + "\n" + str3 + "\n/api/data/app/uploadBasicData", this.f11990e.l());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return this.f11989d.d1(this.f11990e.e(), "Id=" + str3 + ",TimeStamp=" + sb2 + ",AccessKey=" + this.f11990e.a() + ",Signature=" + str2, dataCollectRequestParams);
    }
}
