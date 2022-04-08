package b.d.n.f.c;

import android.text.TextUtils;
import b.d.n.i.b;
import b.d.n.j.f;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import com.tplink.libtpinappmessaging.model.e;
import com.tplink.nbu.bean.iam.HitTask;
import com.tplink.nbu.bean.iam.Task;
import io.reactivex.g0.g;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: WebMessageModule.java */
/* loaded from: classes3.dex */
public class o {
    private IAMRepository a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Integer> f582b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private int f583c = 1;

    public o(IAMRepository iAMRepository) {
        this.a = iAMRepository;
    }

    private boolean a() {
        return !TextUtils.isEmpty(this.a.o());
    }

    private boolean b(String str) {
        return this.f582b.get(str) == null || this.f582b.get(str).intValue() < this.f583c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int d(Task task, Task task2) {
        return task.getPriority() - task2.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(String str, List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HitTask hitTask = (HitTask) it.next();
            List<Task> taskList = hitTask.getTaskList();
            if (taskList != null && !taskList.isEmpty()) {
                Collections.sort(taskList, k.f577c);
                for (Task task : taskList) {
                    if (task != null && task.getPageList() != null && task.getPageList().contains(str) && task.isShow()) {
                        if (task.getMaterial() != null) {
                            e eVar = new e();
                            eVar.h(task.getMaterial().getWebPageUrl());
                            eVar.f(task.getTaskId());
                            eVar.d(task.getBusinessType());
                            eVar.e(hitTask.getPushType());
                            for (b bVar : this.a.r()) {
                                if (bVar.a(eVar)) {
                                    break;
                                }
                            }
                            f.c(eVar);
                            this.a.L(task.getTaskId());
                            if (this.f582b.get(str) == null) {
                                this.f582b.put(str, 1);
                                return;
                            }
                            this.f582b.put(str, Integer.valueOf(this.f582b.get(str).intValue() + 1));
                            return;
                        }
                        return;
                    }
                }
                continue;
            }
        }
    }

    public void c(final String str) {
        if (a() && b(str)) {
            this.a.s().E(new g() { // from class: b.d.n.f.c.j
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    o.this.f(str, (List) obj);
                }
            }).C(l.f578c).F0();
        }
    }

    public void g() {
        if (a()) {
            this.a.E().C(l.f578c).F0();
        }
    }
}
