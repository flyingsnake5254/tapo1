package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

/* loaded from: classes.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        int b2 = new Requirements(extras.getInt("requirements")).b(this);
        if (b2 == 0) {
            o0.H0(this, new Intent((String) g.e(extras.getString("service_action"))).setPackage((String) g.e(extras.getString("service_package"))));
            return false;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("Requirements not met: ");
        sb.append(b2);
        u.h("PlatformScheduler", sb.toString());
        jobFinished(jobParameters, true);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
