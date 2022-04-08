package com.tplink.iot.adapter.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class RoomNavigationAdapter extends RecyclerView.Adapter<ItemViewHolder> implements k {
    private int a = 0;

    /* renamed from: b  reason: collision with root package name */
    private List<com.tplink.iot.model.home.a> f5735b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private Activity f5736c;

    /* renamed from: d  reason: collision with root package name */
    private c f5737d;

    /* loaded from: classes2.dex */
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5738b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f5739c;

        public ItemViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_room_name);
            this.f5738b = (TextView) view.findViewById(R.id.tv_room_numbers);
            this.f5739c = (ImageView) view.findViewById(R.id.right_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5741c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.tplink.iot.model.home.a f5742d;

        a(int i, com.tplink.iot.model.home.a aVar) {
            this.f5741c = i;
            this.f5742d = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (RoomNavigationAdapter.this.a == 0 && RoomNavigationAdapter.this.f5737d != null) {
                RoomNavigationAdapter.this.f5737d.O0(this.f5741c, this.f5742d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements View.OnTouchListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ItemViewHolder f5744c;

        b(ItemViewHolder itemViewHolder) {
            this.f5744c = itemViewHolder;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || RoomNavigationAdapter.this.a != 1 || RoomNavigationAdapter.this.f5737d == null) {
                return false;
            }
            RoomNavigationAdapter.this.f5737d.f0(this.f5744c);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void O0(int i, com.tplink.iot.model.home.a aVar);

        void f0(ItemViewHolder itemViewHolder);
    }

    public RoomNavigationAdapter(Activity activity) {
        this.f5736c = activity;
    }

    private static String o(Context context, int i) {
        if (i <= 0) {
            return context.getResources().getString(R.string.no_device);
        }
        if (i == 1) {
            Resources resources = context.getResources();
            return resources.getString(R.string.smart_device, i + "");
        }
        Resources resources2 = context.getResources();
        return resources2.getString(R.string.smart_devices, i + "");
    }

    @Override // com.tplink.iot.adapter.home.k
    public boolean e() {
        return this.a == 1;
    }

    @Override // com.tplink.iot.adapter.home.k
    public void f(int i, int i2) {
        List<com.tplink.iot.model.home.a> list = this.f5735b;
        if (list != null && list.size() > 1 && i != i2 && i >= 0 && i < this.f5735b.size() && i2 >= 0 && i2 < this.f5735b.size()) {
            Collections.swap(this.f5735b, i, i2);
            notifyItemMoved(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tplink.iot.model.home.a> list = this.f5735b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<String> p() {
        ArrayList arrayList = new ArrayList();
        for (com.tplink.iot.model.home.a aVar : this.f5735b) {
            arrayList.add(aVar.c());
        }
        return arrayList;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: q */
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        com.tplink.iot.model.home.a aVar = this.f5735b.get(i);
        itemViewHolder.a.setText(aVar.a());
        itemViewHolder.f5738b.setText(o(this.f5736c, aVar.b()));
        if (this.a == 0) {
            itemViewHolder.f5739c.setImageResource(R.mipmap.gray_arrow_right);
        } else {
            itemViewHolder.f5739c.setImageResource(R.mipmap.ic_sort_edit);
        }
        itemViewHolder.itemView.setOnClickListener(new a(i, aVar));
        itemViewHolder.f5739c.setOnTouchListener(new b(itemViewHolder));
    }

    @NonNull
    /* renamed from: r */
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home_room_navigation_layout, viewGroup, false));
    }

    public void s(List<com.tplink.iot.model.home.a> list) {
        this.f5735b.clear();
        if (list != null && !list.isEmpty()) {
            this.f5735b.addAll(list);
        }
        notifyDataSetChanged();
    }

    public void t(int i) {
        this.a = i;
        notifyDataSetChanged();
    }

    public void u(c cVar) {
        this.f5737d = cVar;
    }
}
