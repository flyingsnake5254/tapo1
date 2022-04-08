package com.tplink.iot.adapter.about;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.charts.Chart;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import com.tplink.iot.R;
import com.tplink.iot.view.about.LicenseItemActivity;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class LicenseListAdapter extends RecyclerView.Adapter<b> {
    private LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Integer> f5403b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f5404c;

        a(String str) {
            this.f5404c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent intent = new Intent(LicenseListAdapter.this.a.getContext(), LicenseItemActivity.class);
            intent.putExtra("toolbar_title", this.f5404c);
            intent.putExtra(FirebaseAnalytics.Param.CONTENT, (Serializable) LicenseListAdapter.this.f5403b.get(this.f5404c));
            LicenseListAdapter.this.a.getContext().startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.ViewHolder {
        TextView a;

        b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.license_item_title);
        }
    }

    public LicenseListAdapter(Context context) {
        this.a = LayoutInflater.from(context);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f5403b = linkedHashMap;
        linkedHashMap.put("BottomBar", Integer.valueOf((int) R.string.about_license_bottom_bar));
        this.f5403b.put("CircularReveal", Integer.valueOf((int) R.string.about_license_circularreveal));
        this.f5403b.put("DiscreteScrollView", Integer.valueOf((int) R.string.about_license_discrete_scroll_view));
        this.f5403b.put("EventBus", Integer.valueOf((int) R.string.about_license_eventbus));
        this.f5403b.put("EasyPermissions", Integer.valueOf((int) R.string.about_license_easy_permissions));
        Map<String, Integer> map = this.f5403b;
        Integer valueOf = Integer.valueOf((int) R.string.about_license_gcm);
        map.put(Constants.MessageTypes.MESSAGE, valueOf);
        this.f5403b.put("greenDAO", Integer.valueOf((int) R.string.about_license_greendao));
        this.f5403b.put("Gson", valueOf);
        this.f5403b.put("Logger", Integer.valueOf((int) R.string.about_license_logger));
        this.f5403b.put("lottie-android", Integer.valueOf((int) R.string.about_license_lottie));
        this.f5403b.put("MagicIndicator", Integer.valueOf((int) R.string.about_license_magic_indicator));
        this.f5403b.put("Material DateTime Picker", Integer.valueOf((int) R.string.about_license_material_datetime_picker));
        this.f5403b.put("Mosby", Integer.valueOf((int) R.string.about_license_mosby));
        this.f5403b.put("MySnackBar", Integer.valueOf((int) R.string.about_license_mysnackbar));
        this.f5403b.put("NativeStackBlur", Integer.valueOf((int) R.string.about_license_nativestackblur));
        this.f5403b.put("OkHttp", Integer.valueOf((int) R.string.about_license_ok_http));
        this.f5403b.put("RippleBackground", Integer.valueOf((int) R.string.about_license_ripplebackground));
        this.f5403b.put("RippleEffect", Integer.valueOf((int) R.string.about_license_rippleeffect));
        this.f5403b.put("RoundedImageView", Integer.valueOf((int) R.string.about_license_rounded_image_view));
        this.f5403b.put("WheelPicker", Integer.valueOf((int) R.string.about_license_wheel_picker));
        this.f5403b.put("RxJava", Integer.valueOf((int) R.string.about_license_rxjava));
        this.f5403b.put("RxAndroid", Integer.valueOf((int) R.string.about_license_rxandroid));
        this.f5403b.put("ReactiveNetwork", Integer.valueOf((int) R.string.about_license_reactive_network));
        this.f5403b.put("Retrofit", Integer.valueOf((int) R.string.about_license_retrofit));
        this.f5403b.put("ButterKnife", Integer.valueOf((int) R.string.about_license_butterknife));
        this.f5403b.put("PhotoView", Integer.valueOf((int) R.string.about_license_photoview));
        this.f5403b.put(Chart.LOG_TAG, Integer.valueOf((int) R.string.about_license_mpandroidchart));
        this.f5403b.put("SmartRefreshLayout", Integer.valueOf((int) R.string.about_license_smartrefreshlayout));
        this.f5403b.put("Okio", Integer.valueOf((int) R.string.about_license_okio));
        this.f5403b.put("ScrollLayout", Integer.valueOf((int) R.string.about_license_scrolllayout));
        this.f5403b.put("Netty", Integer.valueOf((int) R.string.about_license_netty));
        this.f5403b.put("Mqtt", Integer.valueOf((int) R.string.about_license_mqtt));
        this.f5403b.put("JavaHamcrest", Integer.valueOf((int) R.string.about_license_javahamcrest));
        this.f5403b.put("JUnit 4", Integer.valueOf((int) R.string.about_license_junit));
        this.f5403b.put("Mockito", Integer.valueOf((int) R.string.about_license_mockito));
        this.f5403b.put("Android-skin-support", Integer.valueOf((int) R.string.about_license_skinsupport));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f5403b.size();
    }

    /* renamed from: o */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        String str = (String) this.f5403b.keySet().toArray()[i];
        bVar.a.setText(str);
        bVar.itemView.setOnClickListener(new a(str));
    }

    @NonNull
    /* renamed from: p */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(this.a.inflate(R.layout.layout_license_item, viewGroup, false));
    }
}
