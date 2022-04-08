package b.d.i.a.b.c;

import com.tplink.libtpcommonstream.stream.control.common.StreamControlResponse;
import com.tplink.libtpcommonstream.stream.control.response.Response;
import io.reactivex.g0.j;

/* compiled from: lambda */
/* loaded from: classes3.dex */
public final /* synthetic */ class m implements j {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ m f487c = new m();

    private /* synthetic */ m() {
    }

    @Override // io.reactivex.g0.j
    public final Object apply(Object obj) {
        return (Response) ((StreamControlResponse) obj).getResult();
    }
}
