package com.tplink.iot.view.ipcamera.setting;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.q.b.p.b;
import com.bumptech.glide.request.g;
import com.tplink.iot.R;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
public class LocationSettingAdapter extends RecyclerView.Adapter<a> {
    private int[] a;

    /* renamed from: c  reason: collision with root package name */
    private boolean[] f9104c;

    /* renamed from: e  reason: collision with root package name */
    private b f9106e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f9107f;
    private boolean g;
    private boolean i;

    /* renamed from: b  reason: collision with root package name */
    private int[] f9103b = {R.mipmap.baby, R.mipmap.tree, R.mipmap.bathroom, R.mipmap.bed, R.mipmap.cat_tree, R.mipmap.coat_room, R.mipmap.dining_room, R.mipmap.dog_house, R.mipmap.entrance, R.mipmap.fireplace, R.mipmap.garage, R.mipmap.gym, R.mipmap.iot_house_36, R.mipmap.kitchen, R.mipmap.living_room, R.mipmap.office, R.mipmap.outdoor, R.mipmap.safe, R.mipmap.shop, R.mipmap.study, R.mipmap.swimming_pool, R.mipmap.warehouse, R.mipmap.window};

    /* renamed from: d  reason: collision with root package name */
    private List<b.c> f9105d = new ArrayList();
    private int h = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.ViewHolder implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        private View f9108c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f9109d;

        /* renamed from: f  reason: collision with root package name */
        private ImageView f9110f;
        private ImageView q;

        a(View view) {
            super(view);
            this.f9108c = view.findViewById(R.id.item_set_location_layout);
            this.f9109d = (TextView) view.findViewById(R.id.item_set_location_tv);
            this.f9110f = (ImageView) view.findViewById(R.id.item_set_location_iv);
            ImageView imageView = (ImageView) view.findViewById(R.id.item_delete_location_iv);
            this.q = imageView;
            imageView.setOnClickListener(this);
            this.f9108c.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            int adapterPosition = getAdapterPosition();
            if (id == R.id.item_set_location_layout) {
                LocationSettingAdapter.this.x(adapterPosition);
            }
            if (LocationSettingAdapter.this.f9106e != null) {
                LocationSettingAdapter.this.f9106e.a(view, adapterPosition);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, int i);
    }

    /* loaded from: classes2.dex */
    public class c implements com.bumptech.glide.load.c {

        /* renamed from: b  reason: collision with root package name */
        private final String f9111b;

        public c(String str) {
            Objects.requireNonNull(str, "Signature cannot be null!");
            this.f9111b = str;
        }

        @Override // com.bumptech.glide.load.c
        public void b(MessageDigest messageDigest) {
            try {
                messageDigest.update(this.f9111b.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.bumptech.glide.load.c
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f9111b.equals(((c) obj).f9111b);
        }

        @Override // com.bumptech.glide.load.c
        public int hashCode() {
            return this.f9111b.hashCode();
        }

        public String toString() {
            return "StringSignature{signature='" + this.f9111b + "'}";
        }
    }

    public LocationSettingAdapter(Activity activity, boolean z) {
        int[] iArr = {R.string.onBoarding_set_location_baby_room, R.string.onBoarding_set_location_balcony, R.string.onBoarding_set_location_bathroom, R.string.onBoarding_set_location_bedroom, R.string.onBoarding_set_location_cat_tree, R.string.onBoarding_set_location_coat_room, R.string.onBoarding_set_location_dining_room, R.string.onBoarding_set_location_dog_house, R.string.onBoarding_set_location_entrance, R.string.onBoarding_set_location_fireplace, R.string.onBoarding_set_location_garage, R.string.onBoarding_set_location_gym, R.string.onBoarding_set_location_home, R.string.onBoarding_set_location_kitchen, R.string.onBoarding_set_location_living_room, R.string.onBoarding_set_location_office, R.string.onBoarding_set_location_outdoor, R.string.onBoarding_set_location_safe, R.string.onBoarding_set_location_shop, R.string.onBoarding_set_location_study, R.string.onBoarding_set_location_swimming_pool, R.string.onBoarding_set_location_warehouse, R.string.onBoarding_set_location_window};
        this.a = iArr;
        this.f9104c = new boolean[iArr.length];
        this.i = false;
        this.f9107f = activity;
        this.i = z;
        q();
    }

    private void q() {
        int i = 0;
        while (true) {
            boolean[] zArr = this.f9104c;
            if (i < zArr.length) {
                zArr[i] = false;
                i++;
            } else {
                notifyDataSetChanged();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.length + this.f9105d.size();
    }

    public String n(int i) {
        if (s(i)) {
            return this.f9105d.get(i).b().replace(".png", "");
        }
        return z4.b(this.f9107f, i - this.f9105d.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o(int i) {
        return s(i) ? this.f9105d.get(i).c() : "";
    }

    public int p() {
        int i = 0;
        while (true) {
            boolean[] zArr = this.f9104c;
            if (i >= zArr.length) {
                return -1;
            }
            if (zArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean r(int i) {
        if (i >= getItemCount() || i < 0 || s(i)) {
            return false;
        }
        return this.f9103b[i - this.f9105d.size()] == R.mipmap.baby;
    }

    public boolean s(int i) {
        return i < this.f9105d.size();
    }

    /* renamed from: t */
    public void onBindViewHolder(a aVar, int i) {
        int i2 = 0;
        if (i < this.f9105d.size()) {
            b.c cVar = this.f9105d.get(i);
            g gVar = new g();
            gVar.f0(new com.tplink.iot.Utils.y0.c()).c0(new c(String.valueOf(cVar.d())));
            com.bumptech.glide.c.t(this.f9107f).s(cVar.c()).a(gVar).x0(aVar.f9110f);
            aVar.f9110f.setSelected(this.f9104c[i]);
            aVar.f9109d.setText(cVar.b().replace(".png", ""));
            aVar.q.setVisibility(this.g ? 0 : 8);
        } else {
            int size = i - this.f9105d.size();
            aVar.f9110f.setImageResource(this.f9103b[size]);
            aVar.f9110f.setSelected(this.f9104c[i]);
            aVar.f9109d.setText(this.a[size]);
            aVar.q.setVisibility(8);
            if (this.h == i) {
                aVar.f9110f.setBackground(this.f9107f.getResources().getDrawable(R.drawable.location_icon_background));
            } else {
                aVar.f9110f.setBackgroundColor(this.f9107f.getResources().getColor(R.color.white));
            }
        }
        TextView textView = aVar.f9109d;
        if (this.i) {
            i2 = 8;
        }
        textView.setVisibility(i2);
    }

    /* renamed from: u */
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_set_location, viewGroup, false));
    }

    public void v(b bVar) {
        this.f9106e = bVar;
    }

    public void w(boolean z, String str) {
        if (z) {
            z4.e(this.f9107f);
            int i = 0;
            while (true) {
                int[] iArr = this.a;
                if (i < iArr.length) {
                    if (str.equals(this.f9107f.getString(iArr[i]))) {
                        b.d.w.c.a.e("LocationSettingAdapter", "selected location index is: " + i);
                        x(i);
                    }
                    i++;
                } else {
                    z4.d(this.f9107f);
                    return;
                }
            }
        }
    }

    public void x(int i) {
        boolean[] zArr;
        int i2 = 0;
        while (true) {
            zArr = this.f9104c;
            if (i2 >= zArr.length) {
                i2 = 0;
                break;
            } else if (zArr[i2]) {
                break;
            } else {
                i2++;
            }
        }
        zArr[i2] = false;
        zArr[i] = true;
        this.h = i;
        notifyItemChanged(i2);
        notifyItemChanged(i);
    }
}
