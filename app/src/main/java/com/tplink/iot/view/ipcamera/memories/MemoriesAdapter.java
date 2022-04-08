package com.tplink.iot.view.ipcamera.memories;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.d.q.b.o;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.tplink.iot.R;
import com.tplink.iot.Utils.o0;
import com.tplink.iot.Utils.r0;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.q;
import com.tplink.libtpmediaother.memory.r;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class MemoriesAdapter extends RecyclerView.Adapter {

    /* renamed from: d  reason: collision with root package name */
    private b f8718d;

    /* renamed from: e  reason: collision with root package name */
    private d f8719e;

    /* renamed from: f  reason: collision with root package name */
    private c f8720f;
    private Context g;
    private boolean h;
    private final int a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final int f8716b = 2;

    /* renamed from: c  reason: collision with root package name */
    private List<q> f8717c = new ArrayList();
    private Set<String> i = new HashSet();

    /* loaded from: classes2.dex */
    class TitleViewHolder extends RecyclerView.ViewHolder {
        @BindView
        TextView mTitleTv;

        public TitleViewHolder(View view) {
            super(view);
            ButterKnife.b(this, view);
        }
    }

    /* loaded from: classes2.dex */
    public class TitleViewHolder_ViewBinding implements Unbinder {

        /* renamed from: b  reason: collision with root package name */
        private TitleViewHolder f8721b;

        @UiThread
        public TitleViewHolder_ViewBinding(TitleViewHolder titleViewHolder, View view) {
            this.f8721b = titleViewHolder;
            titleViewHolder.mTitleTv = (TextView) butterknife.internal.c.d(view, R.id.tv_title, "field 'mTitleTv'", TextView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void a() {
            TitleViewHolder titleViewHolder = this.f8721b;
            if (titleViewHolder != null) {
                this.f8721b = null;
                titleViewHolder.mTitleTv = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    /* loaded from: classes2.dex */
    class a extends GridLayoutManager.SpanSizeLookup {
        a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return ((q) MemoriesAdapter.this.f8717c.get(i)).b() == 1 ? 1 : 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void Z(View view, int i, MemoryBean memoryBean);

        void s(View view, int i, MemoryBean memoryBean);

        void w0(int i, MemoryBean memoryBean);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface c {
        void R(List<MemoryBean> list);

        void v(List<MemoryBean> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface d {
        void onDataChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e extends RecyclerView.ViewHolder {
        ImageView a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f8722b;

        /* renamed from: c  reason: collision with root package name */
        TextView f8723c;

        /* renamed from: d  reason: collision with root package name */
        CheckBox f8724d;

        public e(@NonNull View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.item_photo_cover_iv);
            this.f8722b = (ImageView) view.findViewById(R.id.item_photo_like_iv);
            this.f8723c = (TextView) view.findViewById(R.id.item_photo_video_length_tv);
            this.f8724d = (CheckBox) view.findViewById(R.id.item_photo_selector);
        }
    }

    public MemoriesAdapter(Context context) {
        this.g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ boolean C(int i, e eVar, MemoryBean memoryBean, View view) {
        if (this.f8718d != null && !x()) {
            H(true);
            String valueOf = String.valueOf(i);
            eVar.itemView.setSelected(true);
            eVar.f8724d.setChecked(true);
            this.i.add(valueOf);
            this.f8718d.Z(view, i, memoryBean);
        }
        return true;
    }

    private void F(int i) {
        List<q> list = this.f8717c;
        if (list != null && i >= 0 && i < list.size()) {
            this.f8717c.remove(i);
        }
    }

    private void N(List<MemoryBean> list) {
        if (list != null) {
            Map<String, List<MemoryBean>> t = t(list);
            this.f8717c.clear();
            for (Map.Entry<String, List<MemoryBean>> entry : t.entrySet()) {
                this.f8717c.add(new q(0, entry.getKey()));
                for (MemoryBean memoryBean : entry.getValue()) {
                    this.f8717c.add(new q(1, memoryBean));
                }
            }
        }
    }

    private int O(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    private String r(int i) {
        int i2;
        String str;
        String str2;
        String str3;
        int i3 = i / 60;
        int i4 = i % 60;
        if (i3 >= 60) {
            i2 = i3 / 60;
            i3 %= 60;
        } else {
            i2 = 0;
        }
        if (i2 < 10) {
            str = "0".concat(String.valueOf(i2));
        } else {
            str = String.valueOf(i2);
        }
        if (i3 < 10) {
            str2 = "0".concat(String.valueOf(i3));
        } else {
            str2 = String.valueOf(i3);
        }
        if (i4 < 10) {
            str3 = "0".concat(String.valueOf(i4));
        } else {
            str3 = String.valueOf(i4);
        }
        return String.format(Locale.getDefault(), "%s:%s:%s", str, str2, str3);
    }

    private int s() {
        int i = 0;
        if (getItemCount() == 0) {
            return 0;
        }
        for (q qVar : this.f8717c) {
            if (qVar != null && qVar.b() == 1) {
                i++;
            }
        }
        return i;
    }

    private Map<String, List<MemoryBean>> t(List<MemoryBean> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (list != null && !list.isEmpty()) {
            for (MemoryBean memoryBean : list) {
                long timestamp = memoryBean.getTimestamp();
                String g = o0.g(timestamp);
                Timestamp timestamp2 = new Timestamp(timestamp);
                if (r0.e(timestamp2)) {
                    g = this.g.getString(R.string.today);
                } else if (r0.f(timestamp2)) {
                    g = this.g.getString(R.string.memories_yesterday);
                }
                if (linkedHashMap.containsKey(g)) {
                    ((List) linkedHashMap.get(g)).add(memoryBean);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(memoryBean);
                    linkedHashMap.put(g, arrayList);
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void A(int i, e eVar, MemoryBean memoryBean, View view) {
        if (this.h) {
            String valueOf = String.valueOf(i);
            boolean contains = this.i.contains(valueOf);
            eVar.itemView.setSelected(!contains);
            eVar.f8724d.setChecked(!contains);
            if (contains) {
                this.i.remove(valueOf);
            } else {
                this.i.add(valueOf);
            }
            b bVar = this.f8718d;
            if (bVar != null) {
                bVar.w0(i, memoryBean);
                return;
            }
            return;
        }
        b bVar2 = this.f8718d;
        if (bVar2 != null) {
            bVar2.s(view, i, memoryBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(boolean z) {
        if (this.i.size() > 0) {
            for (String str : this.i) {
                int O = O(str);
                if (O < this.f8717c.size() && getItemViewType(O) == 2) {
                    MemoryBean memoryBean = (MemoryBean) this.f8717c.get(O).a();
                    memoryBean.setMark(z);
                    r.f().G(memoryBean);
                }
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(MemoryBean memoryBean, int i) {
        List<q> list = this.f8717c;
        if (list != null && i < list.size() && getItemViewType(i) == 2) {
            ((MemoryBean) this.f8717c.get(i).a()).setMark(memoryBean.isMark());
            notifyDataSetChanged();
        }
    }

    public void G() {
        for (int i = 0; i < this.f8717c.size(); i++) {
            if (getItemViewType(i) == 2) {
                this.i.add(String.valueOf(i));
            }
        }
        notifyDataSetChanged();
    }

    public void H(boolean z) {
        this.h = z;
        if (!z) {
            this.i.clear();
        }
        notifyDataSetChanged();
    }

    public void I(b bVar) {
        this.f8718d = bVar;
    }

    public void J(List<MemoryBean> list) {
        N(list);
        notifyDataSetChanged();
        d dVar = this.f8719e;
        if (dVar != null) {
            dVar.onDataChanged();
        }
    }

    public void K(c cVar) {
        this.f8720f = cVar;
    }

    public void L(d dVar) {
        this.f8719e = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M() {
        if (this.i.size() <= 0) {
            c cVar = this.f8720f;
            if (cVar != null) {
                cVar.v(new ArrayList());
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.i) {
            int O = O(str);
            if (O < this.f8717c.size() && getItemViewType(O) == 2) {
                arrayList.add((MemoryBean) this.f8717c.get(O).a());
            }
        }
        c cVar2 = this.f8720f;
        if (cVar2 != null) {
            cVar2.v(arrayList);
        }
        this.i.clear();
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<q> list = this.f8717c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.f8717c.get(i).b() == 0 ? 1 : 2;
    }

    public void n() {
        this.i.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        if (this.i.size() > 0) {
            for (String str : this.i) {
                int O = O(str);
                if (O < this.f8717c.size() && getItemViewType(O) == 2) {
                    r.f().E((MemoryBean) this.f8717c.get(O).a());
                }
            }
            this.i.clear();
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        ((GridLayoutManager) recyclerView.getLayoutManager()).setSpanSizeLookup(new a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof TitleViewHolder) {
            ((TitleViewHolder) viewHolder).mTitleTv.setText((String) this.f8717c.get(i).a());
        } else if (viewHolder instanceof e) {
            final MemoryBean memoryBean = (MemoryBean) this.f8717c.get(i).a();
            final e eVar = (e) viewHolder;
            eVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.memories.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemoriesAdapter.this.A(i, eVar, memoryBean, view);
                }
            });
            eVar.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tplink.iot.view.ipcamera.memories.c
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MemoriesAdapter.this.C(i, eVar, memoryBean, view);
                }
            });
            boolean contains = this.i.contains(String.valueOf(i));
            eVar.itemView.setSelected(contains);
            eVar.f8724d.setChecked(contains);
            int i2 = 0;
            eVar.f8724d.setVisibility(this.h ? 0 : 8);
            com.bumptech.glide.c.u(this.g).s(memoryBean.getThumbnailPath()).x0(eVar.a);
            if (memoryBean.getVideoPath() == null) {
                eVar.f8723c.setVisibility(8);
            } else {
                eVar.f8723c.setVisibility(0);
                eVar.f8723c.setText(r(memoryBean.getVideoLength()));
            }
            ImageView imageView = eVar.f8722b;
            if (!org.apache.commons.lang.b.b(Boolean.valueOf(memoryBean.isMark()))) {
                i2 = 8;
            }
            imageView.setVisibility(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        int i2;
        boolean z = false;
        if (i == 1) {
            return new TitleViewHolder(LayoutInflater.from(this.g).inflate(R.layout.item_memory_title, viewGroup, false));
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo, viewGroup, false);
        if (this.g.getResources().getConfiguration().orientation == 1) {
            z = true;
        }
        if (z) {
            i2 = o.c(viewGroup.getContext());
        } else {
            i2 = o.b(viewGroup.getContext());
        }
        inflate.getLayoutParams().height = ((((i2 - (o.a(viewGroup.getContext(), 10.0f) * 2)) - o.a(viewGroup.getContext(), 8.0f)) / 2) * 9) / 16;
        return new e(inflate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i) {
        F(i);
        notifyDataSetChanged();
        d dVar = this.f8719e;
        if (dVar != null) {
            dVar.onDataChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        if (this.i.size() <= 0) {
            c cVar = this.f8720f;
            if (cVar != null) {
                cVar.R(new ArrayList());
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.i) {
            int O = O(str);
            if (O < this.f8717c.size() && getItemViewType(O) == 2) {
                arrayList.add((MemoryBean) this.f8717c.get(O).a());
            }
        }
        c cVar2 = this.f8720f;
        if (cVar2 != null) {
            cVar2.R(arrayList);
        }
        this.i.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u() {
        return this.i.size() > 0;
    }

    public boolean v() {
        int s;
        return this.i.size() > 0 && (s = s()) > 0 && this.i.size() == s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean w() {
        if (this.i.size() <= 0) {
            return false;
        }
        for (String str : this.i) {
            int O = O(str);
            if (O < this.f8717c.size() && getItemViewType(O) == 2 && !((MemoryBean) this.f8717c.get(O).a()).isMark()) {
                return false;
            }
        }
        return true;
    }

    public boolean x() {
        return this.h;
    }

    public int y() {
        return this.i.size();
    }
}
