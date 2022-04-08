package com.tplink.libtpnetwork.IoTNetwork.y;

import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.q;

/* compiled from: IoTAbstractTransport.java */
/* loaded from: classes3.dex */
public abstract class a {
    protected boolean a;

    public boolean d() {
        return this.a;
    }

    public void e() {
    }

    public abstract <T> q<TPIoTResponse> f(TPIoTRequest<T> tPIoTRequest) throws IoTTransportException;

    public void g(boolean z) {
        this.a = z;
    }
}
