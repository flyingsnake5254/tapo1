package b.d.i.a.b.c;

import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.response.GetDownloadResponse;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class l implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ l f486c = new l();

    private /* synthetic */ l() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return (GetDownloadResponse) ((StreamControlResponse) obj).getResult();
    }
}
