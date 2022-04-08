package b.d.n.i;

import com.tplink.nbu.bean.iam.Event;
import com.tplink.nbu.bean.iam.MaterialsResult;
import com.tplink.nbu.bean.iam.ShowedTaskResult;
import io.reactivex.q;

/* compiled from: IAMCloud.java */
/* loaded from: classes3.dex */
public interface d {
    void a(String str);

    void b(String str, String str2, a aVar);

    q<ShowedTaskResult> c(String str);

    void clear();

    q<MaterialsResult> d(String str);

    void e(Event event);
}
