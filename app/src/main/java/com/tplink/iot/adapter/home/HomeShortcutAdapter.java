package com.tplink.iot.adapter.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.request.g;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.smart.common.SmartInfo;
import com.tplink.iot.model.home.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.RunShortCutResultBean;
import com.tplink.libtpnetwork.IoTNetwork.repository.SmartRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class HomeShortcutAdapter extends RecyclerView.Adapter {
    private Activity a;

    /* renamed from: c  reason: collision with root package name */
    private c f5707c;

    /* renamed from: d  reason: collision with root package name */
    private Animation f5708d;

    /* renamed from: b  reason: collision with root package name */
    private List<i> f5706b = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private boolean f5709e = false;

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f5710c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f5711d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ SmartInfo f5712f;

        a(i iVar, int i, SmartInfo smartInfo) {
            this.f5710c = iVar;
            this.f5711d = i;
            this.f5712f = smartInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (HomeShortcutAdapter.this.f5707c != null && this.f5710c.c() && this.f5710c.a() == 0 && !HomeShortcutAdapter.this.f5709e) {
                this.f5710c.e(1);
                HomeShortcutAdapter.this.notifyItemChanged(this.f5711d);
                HomeShortcutAdapter.this.f5707c.a(view, this.f5711d, this.f5712f.getId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f5713c;

        b(i iVar) {
            this.f5713c = iVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5713c.e(0);
            HomeShortcutAdapter.this.notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(View view, int i, String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class d extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f5715b;

        /* renamed from: c  reason: collision with root package name */
        View f5716c;

        /* renamed from: d  reason: collision with root package name */
        View f5717d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f5718e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f5719f;

        d(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_name);
            this.f5715b = (ImageView) view.findViewById(R.id.img_icon);
            this.f5716c = view.findViewById(R.id.view_loading);
            this.f5717d = view.findViewById(R.id.view_disable);
            this.f5718e = (ImageView) view.findViewById(R.id.iv_shortcut_loading);
            this.f5719f = (ImageView) view.findViewById(R.id.iv_shortcut_result);
        }
    }

    public HomeShortcutAdapter(Activity activity) {
        this.a = activity;
        this.f5708d = AnimationUtils.loadAnimation(activity, R.anim.anim_common_roate);
    }

    private void r(d dVar) {
        dVar.f5716c.setVisibility(8);
        dVar.f5719f.setVisibility(8);
        dVar.f5718e.setVisibility(8);
        dVar.f5718e.clearAnimation();
    }

    private void s(d dVar, i iVar) {
        dVar.f5716c.setVisibility(0);
        dVar.f5718e.setVisibility(8);
        dVar.f5718e.clearAnimation();
        dVar.f5719f.setVisibility(0);
        dVar.f5719f.postDelayed(new b(iVar), 1000L);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<i> list = this.f5706b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<i> o() {
        return this.f5706b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        d dVar = (d) viewHolder;
        i iVar = this.f5706b.get(i);
        SmartInfo b2 = iVar.b();
        String avatarUrl = b2.getAvatarUrl();
        ArrayList arrayList = new ArrayList(Arrays.asList(SmartRepository.i));
        if (!arrayList.contains(avatarUrl)) {
            avatarUrl = (String) arrayList.get(0);
        }
        com.bumptech.glide.c.t(this.a).s("file:///android_asset/smart_icons/" + avatarUrl + ".png").a(new g().f(j.f1461d)).x0(dVar.f5715b);
        dVar.a.setText(b2.getName());
        if (iVar.c()) {
            dVar.f5717d.setVisibility(8);
            int a2 = iVar.a();
            if (a2 == 0) {
                r(dVar);
            } else if (a2 == 1) {
                dVar.f5716c.setVisibility(0);
                dVar.f5718e.setVisibility(0);
                dVar.f5718e.startAnimation(this.f5708d);
                dVar.f5719f.setVisibility(8);
            } else if (a2 == 2) {
                s(dVar, iVar);
            }
            r(dVar);
        } else {
            dVar.f5717d.setVisibility(0);
            iVar.e(0);
            r(dVar);
        }
        dVar.itemView.setOnClickListener(new a(iVar, i, b2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new d(LayoutInflater.from(this.a).inflate(R.layout.layout_home_shortcut_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(@NonNull RecyclerView.ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
    }

    public void p(boolean z) {
        this.f5709e = z;
    }

    public void q(c cVar) {
        this.f5707c = cVar;
    }

    public void t(List<i> list) {
        this.f5706b.clear();
        if (list != null && !list.isEmpty()) {
            this.f5706b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void u(RunShortCutResultBean runShortCutResultBean) {
        for (int i = 0; i < this.f5706b.size(); i++) {
            i iVar = this.f5706b.get(i);
            if (iVar.b() != null && iVar.b().getId() != null && iVar.b().getId().equals(runShortCutResultBean.getSmartId()) && iVar.a() == 1) {
                if (runShortCutResultBean.isSuccess()) {
                    iVar.e(2);
                } else {
                    iVar.e(0);
                }
                notifyItemChanged(i);
            }
        }
    }
}
