package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.h.z.a;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* compiled from: JobInfoScheduler.java */
@RequiresApi(api = 21)
/* loaded from: classes.dex */
public class p implements u {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final y f1986b;

    /* renamed from: c  reason: collision with root package name */
    private final SchedulerConfig f1987c;

    public p(Context context, y yVar, SchedulerConfig schedulerConfig) {
        this.a = context;
        this.f1986b = yVar;
        this.f1987c = schedulerConfig;
    }

    private boolean d(JobScheduler jobScheduler, int i, int i2) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i3 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i) {
                return i3 >= i2;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.u
    public void a(n nVar, int i) {
        b(nVar, i, false);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.u
    public void b(n nVar, int i, boolean z) {
        ComponentName componentName = new ComponentName(this.a, JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.a.getSystemService("jobscheduler");
        int c2 = c(nVar);
        if (z || !d(jobScheduler, c2, i)) {
            long m = this.f1986b.m(nVar);
            JobInfo.Builder c3 = this.f1987c.c(new JobInfo.Builder(c2, componentName), nVar.d(), m, i);
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i);
            persistableBundle.putString("backendName", nVar.b());
            persistableBundle.putInt("priority", a.a(nVar.d()));
            if (nVar.c() != null) {
                persistableBundle.putString("extras", Base64.encodeToString(nVar.c(), 0));
            }
            c3.setExtras(persistableBundle);
            com.google.android.datatransport.h.v.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", nVar, Integer.valueOf(c2), Long.valueOf(this.f1987c.g(nVar.d(), m, i)), Long.valueOf(m), Integer.valueOf(i));
            jobScheduler.schedule(c3.build());
            return;
        }
        com.google.android.datatransport.h.v.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", nVar);
    }

    @VisibleForTesting
    int c(n nVar) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(nVar.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(a.a(nVar.d())).array());
        if (nVar.c() != null) {
            adler32.update(nVar.c());
        }
        return (int) adler32.getValue();
    }
}
