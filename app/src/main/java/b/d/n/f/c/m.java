package b.d.n.f.c;

import android.text.TextUtils;
import b.d.n.j.f;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import com.tplink.libtpinappmessaging.model.e;
import com.tplink.nbu.bean.iam.HitTask;
import com.tplink.nbu.bean.iam.Task;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.t;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: NotificationMessageModule.java */
/* loaded from: classes3.dex */
public class m {
    private static final String a = "m";

    /* renamed from: b  reason: collision with root package name */
    private IAMRepository f579b;

    public m(IAMRepository iAMRepository) {
        this.f579b = iAMRepository;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ t c(Boolean bool) throws Exception {
        return this.f579b.s();
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
                Collections.sort(taskList, a.f562c);
                for (Task task : taskList) {
                    if (!(task == null || task.getTaskId() == null || !task.getTaskId().equals(str) || task.getMaterial() == null || TextUtils.isEmpty(task.getMaterial().getWebPageUrl()))) {
                        e eVar = new e();
                        eVar.h(task.getMaterial().getWebPageUrl());
                        eVar.f(task.getTaskId());
                        eVar.d(task.getBusinessType());
                        eVar.e(hitTask.getPushType());
                        f.c(eVar);
                        this.f579b.L(task.getTaskId());
                        return;
                    }
                }
                continue;
            }
        }
    }

    public void a(final String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f579b.o())) {
            b.d.n.j.e.b(a + "handelNotificationMessage taskId:" + str);
            this.f579b.E().N(new j() { // from class: b.d.n.f.c.b
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return m.this.c((Boolean) obj);
                }
            }).E(new g() { // from class: b.d.n.f.c.c
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    m.this.f(str, (List) obj);
                }
            }).C(l.f578c).F0();
        }
    }
}
