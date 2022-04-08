package b.d.n.f.c;

import android.text.TextUtils;
import b.d.n.j.b;
import b.d.n.j.f;
import b.d.n.j.h;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import com.tplink.libtpinappmessaging.model.IAMException;
import com.tplink.libtpinappmessaging.model.a;
import com.tplink.libtpinappmessaging.model.d;
import com.tplink.nbu.bean.iam.HitTask;
import com.tplink.nbu.bean.iam.Task;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: SplashMessageModule.java */
/* loaded from: classes3.dex */
public class n {
    private static volatile boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private IAMRepository f580b;

    /* renamed from: c  reason: collision with root package name */
    private h f581c = new h();

    public n(IAMRepository iAMRepository) {
        this.f580b = iAMRepository;
    }

    private void a(a aVar) {
        HitTask hitTask;
        List<Task> taskList;
        if (!(aVar == null || !aVar.c() || a || (hitTask = this.f580b.t().get(0)) == null || (taskList = hitTask.getTaskList()) == null || taskList.isEmpty())) {
            for (Task task : taskList) {
                if (aVar.b().equals(task.getMaterialId()) && task.isShow() && !TextUtils.isEmpty(aVar.a()) && b.b(aVar.a())) {
                    d dVar = new d();
                    dVar.i(aVar.a());
                    dVar.j(task.getMaterial().getWebPageUrl());
                    dVar.f(task.getTaskId());
                    dVar.d(task.getBusinessType());
                    dVar.e(hitTask.getPushType());
                    for (b.d.n.i.b bVar : this.f580b.r()) {
                        if (bVar.a(dVar)) {
                            break;
                        }
                    }
                    a = true;
                    this.f581c.cancel();
                    f.e(dVar);
                    this.f580b.L(task.getTaskId());
                    return;
                }
            }
        }
    }

    private void c(final boolean z) {
        if (!TextUtils.isEmpty(this.f580b.o())) {
            if (!z) {
                this.f581c.start();
            }
            this.f580b.F().N(new j() { // from class: b.d.n.f.c.d
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return n.this.g(z, (Boolean) obj);
                }
            }).N(new j() { // from class: b.d.n.f.c.i
                @Override // io.reactivex.g0.j
                public final Object apply(Object obj) {
                    return n.this.i((Task) obj);
                }
            }).E(new g() { // from class: b.d.n.f.c.h
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    n.this.k(z, (a) obj);
                }
            }).C(new g() { // from class: b.d.n.f.c.g
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    n.this.m(z, (Throwable) obj);
                }
            }).L0(io.reactivex.l0.a.b(b.d.n.h.a.a())).F0();
        } else if (!z) {
            f.d(new IAMException(-3, "cached AccountId empty!"));
        }
    }

    private void d(List<Task> list, Map<String, String> map, String str, List<String> list2) {
        if (!list.isEmpty()) {
            Collections.sort(list, e.f568c);
            for (Task task : list) {
                if (task.isShow()) {
                    String materialId = task.getMaterialId();
                    String str2 = map.get(materialId);
                    String webPageUrl = task.getMaterial() != null ? task.getMaterial().getWebPageUrl() : "";
                    if (!b.b(str2)) {
                        list2.add(materialId);
                    } else if (!TextUtils.isEmpty(str2)) {
                        d dVar = new d();
                        dVar.i(str2);
                        dVar.j(webPageUrl);
                        dVar.f(task.getTaskId());
                        dVar.d(task.getBusinessType());
                        dVar.e(str);
                        for (b.d.n.i.b bVar : this.f580b.r()) {
                            if (bVar.a(dVar)) {
                                break;
                            }
                        }
                        a = true;
                        this.f581c.cancel();
                        f.e(dVar);
                        this.f580b.L(task.getTaskId());
                        return;
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int e(Task task, Task task2) {
        return task.getPriority() - task2.getPriority();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ t g(boolean z, Boolean bool) throws Exception {
        if (bool.booleanValue()) {
            Map<String, String> q = this.f580b.q();
            List<HitTask> t = this.f580b.t();
            if (!t.isEmpty()) {
                HitTask hitTask = t.get(0);
                List<Task> taskList = hitTask.getTaskList();
                if (taskList != null) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList<Task> arrayList3 = new ArrayList();
                    for (Task task : taskList) {
                        if (q.containsKey(task.getMaterialId())) {
                            arrayList.add(task);
                        } else {
                            arrayList3.add(task);
                        }
                    }
                    for (String str : q.keySet()) {
                        Iterator<Task> it = taskList.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (it.next().getMaterialId().equals(str)) {
                                    break;
                                }
                            } else {
                                arrayList2.add(str);
                                break;
                            }
                        }
                    }
                    if (!z) {
                        d(arrayList, q, hitTask.getPushType(), arrayList2);
                    }
                    if (!arrayList2.isEmpty()) {
                        this.f580b.m(arrayList2);
                    }
                    Collections.sort(arrayList3, f.f569c);
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    for (Task task2 : arrayList3) {
                        if (task2.isShow()) {
                            arrayList4.add(task2);
                        } else {
                            arrayList5.add(task2);
                        }
                    }
                    if (!z && arrayList4.isEmpty() && !a) {
                        this.f581c.cancel();
                        a = true;
                        f.d(new IAMException(-1, "need download res task list empty!"));
                    }
                    arrayList4.addAll(arrayList5);
                    return q.Y(arrayList4);
                }
            } else {
                this.f580b.l();
            }
        }
        return q.J(new IAMException(-1, "have no active task"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public /* synthetic */ t i(Task task) throws Exception {
        if (TextUtils.isEmpty(task.getMaterialId()) || task.getMaterial() == null || TextUtils.isEmpty(task.getMaterial().getImageUrl())) {
            return q.J(new IAMException(-1, "task param error"));
        }
        return this.f580b.n(task.getMaterialId(), task.getMaterial().getImageUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public /* synthetic */ void k(boolean z, a aVar) throws Exception {
        if (!z) {
            a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m(boolean z, Throwable th) throws Exception {
        if (!z) {
            this.f581c.cancel();
            f.d(new IAMException(-1, th.getMessage()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int n(Task task, Task task2) {
        return task.getPriority() - task2.getPriority();
    }

    public void b() {
        c(false);
    }

    public void o() {
        c(true);
    }
}
