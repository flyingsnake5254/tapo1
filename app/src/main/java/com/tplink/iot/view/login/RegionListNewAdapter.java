package com.tplink.iot.view.login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.databinding.ItemRegionListContentBinding;
import com.tplink.iot.databinding.ItemRegionListTitleBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class RegionListNewAdapter extends RecyclerView.Adapter {

    /* renamed from: c  reason: collision with root package name */
    private Context f9487c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f9488d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f9489e;

    /* renamed from: f  reason: collision with root package name */
    private int[] f9490f;
    private c g;
    private List<com.tplink.iot.j.b.a> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<b> f9486b = new ArrayList();
    private int h = -1;

    /* loaded from: classes2.dex */
    class a implements Comparator<com.tplink.iot.j.b.a> {
        a() {
        }

        /* renamed from: a */
        public int compare(com.tplink.iot.j.b.a aVar, com.tplink.iot.j.b.a aVar2) {
            return com.tplink.iot.j.b.a.e(aVar.b()).toUpperCase().compareTo(com.tplink.iot.j.b.a.e(aVar2.b()).toUpperCase());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {
        public boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f9492b = 0;

        /* renamed from: c  reason: collision with root package name */
        public String f9493c = "";

        public b() {
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(String str, String str2);
    }

    /* loaded from: classes2.dex */
    static class d extends RecyclerView.ViewHolder {
        public d(View view) {
            super(view);
        }
    }

    /* loaded from: classes2.dex */
    static class e extends RecyclerView.ViewHolder {
        public e(View view) {
            super(view);
        }
    }

    public RegionListNewAdapter(Context context, c cVar) {
        String[] strArr = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z"};
        this.f9488d = strArr;
        this.f9489e = new int[strArr.length];
        this.f9487c = context;
        this.g = cVar;
    }

    private void m() {
        this.f9486b.clear();
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.a.size(); i3++) {
            if (z) {
                String o = o(i3);
                b bVar = new b();
                bVar.a = true;
                bVar.f9493c = o;
                this.f9486b.add(bVar);
                while (true) {
                    String[] strArr = this.f9488d;
                    if (i >= strArr.length || strArr[i].equalsIgnoreCase(o)) {
                        break;
                    }
                    this.f9489e[i] = i2;
                    i++;
                }
                if (i < this.f9488d.length) {
                    this.f9489e[i] = i2;
                    i++;
                }
                i2++;
                z = false;
            }
            b bVar2 = new b();
            bVar2.a = false;
            bVar2.f9492b = i3;
            if (i3 != this.a.size() - 1 && !o(i3).equalsIgnoreCase(o(i3 + 1))) {
                z = true;
            }
            if (this.a.get(i3).c()) {
                this.h = i2;
            }
            this.f9486b.add(bVar2);
            this.f9490f[i3] = i2;
            i2++;
        }
        while (i < this.f9488d.length) {
            this.f9489e[i] = this.f9486b.size() - 1;
            i++;
        }
    }

    private void n() {
        this.f9486b.clear();
        int i = 0;
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            b bVar = new b();
            bVar.a = false;
            bVar.f9492b = i2;
            if (this.a.get(i2).c()) {
                this.h = i;
            }
            this.f9486b.add(bVar);
            i++;
        }
    }

    private String o(int i) {
        String b2;
        return (i >= this.a.size() || (b2 = this.a.get(i).b()) == null || b2.length() == 0) ? "" : com.tplink.iot.j.b.a.e(b2.substring(0, 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<b> list = this.f9486b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.f9486b.get(i).a) {
            return 1;
        }
        return super.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof e) {
            ItemRegionListContentBinding itemRegionListContentBinding = (ItemRegionListContentBinding) DataBindingUtil.getBinding(viewHolder.itemView);
            com.tplink.iot.j.b.a aVar = this.a.get(this.f9486b.get(i).f9492b);
            itemRegionListContentBinding.i(new com.tplink.iot.viewmodel.login.a(aVar.b(), aVar.a(), aVar.c()));
            itemRegionListContentBinding.h(this.g);
            itemRegionListContentBinding.executePendingBindings();
        } else if (viewHolder instanceof d) {
            ItemRegionListTitleBinding itemRegionListTitleBinding = (ItemRegionListTitleBinding) DataBindingUtil.getBinding(viewHolder.itemView);
            itemRegionListTitleBinding.h(new com.tplink.iot.viewmodel.login.a(this.f9486b.get(i).f9493c, null, false));
            itemRegionListTitleBinding.executePendingBindings();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 1) {
            return new d(((ItemRegionListTitleBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_region_list_title, viewGroup, false)).getRoot());
        }
        return new e(((ItemRegionListContentBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), R.layout.item_region_list_content, viewGroup, false)).getRoot());
    }

    public int p() {
        return this.h;
    }

    public int q(String str) {
        int i = 0;
        while (true) {
            String[] strArr = this.f9488d;
            if (i >= strArr.length) {
                return -1;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                return this.f9489e[i];
            }
            i++;
        }
    }

    public void r(List<com.tplink.iot.j.b.a> list, boolean z) {
        this.a.clear();
        this.a.addAll(list);
        this.f9490f = new int[list.size()];
        Collections.sort(this.a, new a());
        if (z) {
            m();
        } else {
            n();
        }
        notifyDataSetChanged();
    }

    public void s(String str) {
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).d(false);
            if (this.a.get(i).b().equalsIgnoreCase(str)) {
                this.a.get(i).d(true);
                this.h = this.f9490f[i];
            }
        }
        notifyDataSetChanged();
    }
}
