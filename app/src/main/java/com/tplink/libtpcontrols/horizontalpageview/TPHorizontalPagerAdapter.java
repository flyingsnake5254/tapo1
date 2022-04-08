package com.tplink.libtpcontrols.horizontalpageview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.tplink.libtpcontrols.horizontalpageview.TPHorizontalRecycleAdapter;
import com.tplink.libtpcontrols.s0;
import com.tplink.libtpcontrols.t0;
import com.tplink.libtpcontrols.v0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class TPHorizontalPagerAdapter extends PagerAdapter {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private String f12261b;

    /* renamed from: c  reason: collision with root package name */
    private String f12262c;

    /* renamed from: d  reason: collision with root package name */
    private List<String> f12263d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<String> f12264e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private a f12265f = null;

    /* loaded from: classes3.dex */
    public interface a {
        void a(int i);
    }

    public TPHorizontalPagerAdapter(Context context, String str, String str2) {
        this.a = context;
        this.f12261b = str;
        this.f12262c = str2;
        this.f12263d.add(str);
        this.f12264e.add(this.f12262c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void c(int i, int i2) {
        a aVar = this.f12265f;
        if (aVar != null) {
            aVar.a((i * 8) + i2);
        }
    }

    public int a() {
        return this.f12263d.size();
    }

    public void d(a aVar) {
        this.f12265f = aVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void e(List<String> list) {
        this.f12263d.clear();
        this.f12263d.addAll(list);
        this.f12263d.add(this.f12261b);
        this.f12264e.clear();
        for (String str : list) {
            this.f12264e.add(this.a.getString(v0.space_custom_mipmap_icon));
        }
        this.f12264e.add(this.f12262c);
        notifyDataSetChanged();
    }

    public void f(List<String> list) {
        this.f12263d.clear();
        this.f12263d.addAll(list);
        this.f12264e.clear();
        for (String str : list) {
            this.f12264e.add(this.a.getString(v0.space_custom_mipmap_icon));
        }
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        if (this.f12263d.size() == 0) {
            return 0;
        }
        return ((this.f12263d.size() - 1) / 8) + 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, final int i) {
        List<String> list;
        List<String> list2;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(t0.location_pager_adapter, (ViewGroup) null, false);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(s0.recycle_view);
        recyclerView.setLayoutManager(new TPHorizontalGridLayoutManager(viewGroup.getContext(), 2, 0, false));
        int i2 = (i + 1) * 8;
        if (i2 > this.f12263d.size()) {
            List<String> list3 = this.f12263d;
            int i3 = i * 8;
            list2 = list3.subList(i3, list3.size());
            List<String> list4 = this.f12264e;
            list = list4.subList(i3, list4.size());
        } else {
            int i4 = i * 8;
            list2 = this.f12263d.subList(i4, i2);
            list = this.f12264e.subList(i4, i2);
        }
        TPHorizontalRecycleAdapter tPHorizontalRecycleAdapter = new TPHorizontalRecycleAdapter(this.a, list2, list);
        recyclerView.setAdapter(tPHorizontalRecycleAdapter);
        tPHorizontalRecycleAdapter.q(new TPHorizontalRecycleAdapter.a() { // from class: com.tplink.libtpcontrols.horizontalpageview.b
            @Override // com.tplink.libtpcontrols.horizontalpageview.TPHorizontalRecycleAdapter.a
            public final void a(int i5) {
                TPHorizontalPagerAdapter.this.c(i, i5);
            }
        });
        viewGroup.addView(inflate, -1, -1);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
