package com.tplink.iot.adapter.iotbulb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.z0.g;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.List;

/* loaded from: classes2.dex */
public class BulbSettingAvatarAdapter extends RecyclerView.Adapter<b> {
    private List<com.tplink.iot.model.iot.a> a;

    /* renamed from: b  reason: collision with root package name */
    private int f5793b;

    /* renamed from: c  reason: collision with root package name */
    private c f5794c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5795c;

        a(int i) {
            this.f5795c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BulbSettingAvatarAdapter.this.s(this.f5795c);
            BulbSettingAvatarAdapter.this.f5793b = this.f5795c;
            if (BulbSettingAvatarAdapter.this.f5794c != null) {
                BulbSettingAvatarAdapter.this.f5794c.e(this.f5795c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        private ImageView a;

        /* renamed from: b  reason: collision with root package name */
        private ImageView f5797b;

        public b(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_avatar);
            this.f5797b = (ImageView) view.findViewById(R.id.iv_selected_flag);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void e(int i);
    }

    public BulbSettingAvatarAdapter(List<com.tplink.iot.model.iot.a> list) {
        this.a = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(int i) {
        for (int i2 = 0; i2 < getItemCount(); i2++) {
            this.a.get(i2).c(false);
        }
        this.a.get(i).c(true);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tplink.iot.model.iot.a> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public EnumBulbAvatarType p() {
        return this.a.get(this.f5793b).a();
    }

    /* renamed from: q */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        com.tplink.iot.model.iot.a aVar = this.a.get(i);
        bVar.a.setImageResource(g.e(aVar.a()));
        if (aVar.b()) {
            bVar.f5797b.setVisibility(0);
            this.f5793b = i;
        } else {
            bVar.f5797b.setVisibility(8);
        }
        bVar.itemView.setOnClickListener(new a(i));
    }

    @NonNull
    /* renamed from: r */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_setting_avatar, viewGroup, false));
    }

    public void t(c cVar) {
        this.f5794c = cVar;
    }
}
