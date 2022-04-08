package b.d.d0.h2.a;

import b.d.d0.i2.b;
import com.tplink.iot.cloud.bean.thing.common.FirmwareDownloadState;
import javax.net.SocketFactory;

/* compiled from: TMPSSH2ClientParams.java */
/* loaded from: classes3.dex */
public class d extends c {

    /* renamed from: f  reason: collision with root package name */
    private String f296f;
    private int g;
    private int h;
    private SocketFactory i;
    private String j;
    private String k;
    private String l;
    private int m;

    @Override // b.d.d0.h2.a.c
    public b f() {
        if (b.d.w.h.b.d(this.f296f)) {
            return new b(FirmwareDownloadState.UPGRADE_STATE_DOWNLOAD_FAIL);
        }
        if (b.d.w.h.b.d(this.j)) {
            return new b(FirmwareDownloadState.UPGRADE_STATE_CHECK_FAIL);
        }
        if (b.d.w.h.b.d(this.k)) {
            return new b(FirmwareDownloadState.UPGRADE_STATE_TRANSFER_FAIL);
        }
        return new b();
    }

    public String l() {
        return this.k;
    }

    public SocketFactory m() {
        return this.i;
    }

    public int n() {
        return this.h;
    }

    public String o() {
        return this.f296f;
    }

    public int p() {
        return this.g;
    }

    public String q() {
        return this.l;
    }

    public int r() {
        return this.m;
    }

    public String s() {
        return this.j;
    }
}
