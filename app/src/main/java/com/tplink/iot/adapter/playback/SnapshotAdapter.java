package com.tplink.iot.adapter.playback;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.playback.SnapshotAdapter;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;
import com.tplink.libmediaapi.vod.VodMediaAPI;
import com.tplink.libtpimagedownloadmedia.loader.g;
import com.tplink.libtpmediastatistics.SSLClient;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class SnapshotAdapter extends RecyclerView.Adapter {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private List<com.tplink.iot.j.c.a> f5854b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<com.tplink.iot.j.c.a> f5855c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private SimpleDateFormat f5856d = new SimpleDateFormat("HH:mm:ss", Locale.US);

    /* renamed from: e  reason: collision with root package name */
    private a f5857e;

    /* renamed from: f  reason: collision with root package name */
    private PlayBackControlViewModel f5858f;

    /* loaded from: classes2.dex */
    public interface a {
        void a(com.tplink.iot.j.c.a aVar);
    }

    /* loaded from: classes2.dex */
    private class b extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5859b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5860c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f5861d;

        /* renamed from: e  reason: collision with root package name */
        View f5862e;

        /* renamed from: f  reason: collision with root package name */
        ConstraintLayout f5863f;

        b(View view) {
            super(view);
            this.f5861d = (ImageView) view.findViewById(R.id.iv_pic);
            this.a = (TextView) view.findViewById(R.id.tv_time_pic);
            this.f5859b = (TextView) view.findViewById(R.id.tv_time);
            this.f5860c = (TextView) view.findViewById(R.id.tv_type);
            this.f5862e = view.findViewById(R.id.v_color_dec);
            this.f5863f = (ConstraintLayout) view.findViewById(R.id.cl_item);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void d(a aVar, com.tplink.iot.j.c.a aVar2, View view) {
            if (aVar != null) {
                aVar.a(aVar2);
            }
        }

        private void e(com.tplink.iot.j.c.a aVar, int i) {
            g gVar = new g(aVar.a(), aVar.f(), TextUtils.isEmpty(aVar.c()) ? String.valueOf(aVar.d()) : aVar.c());
            VodMediaAPI.downloadImageIntoView(gVar, this.f5861d, R.drawable.cloud_terrace_preset_default);
            b.d.w.c.a.d("loadImage:" + i + "--image:" + gVar.c());
        }

        private String f(int i) {
            if (i <= 0) {
                return "00:00";
            }
            int i2 = i / 60;
            if (i2 < 60) {
                return i(i2) + SSLClient.COLON + i(i % 60);
            }
            int i3 = i2 / 60;
            if (i3 > 99) {
                return "99:59:59";
            }
            int i4 = i2 % 60;
            return i(i3) + SSLClient.COLON + i(i4) + SSLClient.COLON + i((i - (i3 * 3600)) - (i4 * 60));
        }

        private void g(com.tplink.iot.j.c.a aVar) {
            Date date = new Date();
            date.setTime(aVar.d() * 1000);
            if (aVar.g()) {
                TextView textView = this.f5859b;
                textView.setText(SnapshotAdapter.this.f5856d.format(date) + SnapshotAdapter.this.a.getString(R.string.camera_playback_daylight_saving_symbol));
            } else {
                this.f5859b.setText(SnapshotAdapter.this.f5856d.format(date));
            }
            this.a.setText(f((int) (aVar.b() - aVar.d())));
        }

        private void h(com.tplink.iot.j.c.a aVar) {
            this.f5862e.setBackgroundResource(R.drawable.level_list_detect_type);
            this.f5862e.getBackground().setLevel(aVar.e());
            switch (aVar.e()) {
                case 2:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.play_back_motion_detection));
                    return;
                case 3:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.setting_video_tampering));
                    return;
                case 4:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.setting_line_crossing));
                    return;
                case 5:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.setting_area_intrusion));
                    return;
                case 6:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.tapo_care_person_detection));
                    return;
                case 7:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.camera_baby_crying));
                    return;
                default:
                    this.f5860c.setText(SnapshotAdapter.this.a.getString(R.string.play_back_motion_detection));
                    return;
            }
        }

        private String i(int i) {
            if (i < 0 || i >= 10) {
                return "" + i;
            }
            return "0" + i;
        }

        public void c(final com.tplink.iot.j.c.a aVar, int i, final a aVar2) {
            e(aVar, i);
            g(aVar);
            h(aVar);
            this.f5863f.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.playback.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SnapshotAdapter.b.d(SnapshotAdapter.a.this, aVar, view);
                }
            });
        }
    }

    public SnapshotAdapter(Activity activity, a aVar, PlayBackControlViewModel playBackControlViewModel) {
        this.a = activity;
        this.f5857e = aVar;
        this.f5858f = playBackControlViewModel;
    }

    private void p(List<com.tplink.iot.j.c.a> list) {
        this.f5854b.clear();
        if (list != null) {
            this.f5854b.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<com.tplink.iot.j.c.a> list = this.f5854b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void o(List<com.tplink.iot.j.c.a> list) {
        this.f5854b.clear();
        this.f5855c.clear();
        if (list != null) {
            this.f5854b.addAll(list);
            this.f5855c.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((b) viewHolder).c(this.f5854b.get(i), i, this.f5857e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.a).inflate(R.layout.item_playback_snapshot_list, viewGroup, false));
    }

    public void q(int i) {
        ArrayList arrayList = new ArrayList();
        for (com.tplink.iot.j.c.a aVar : this.f5855c) {
            if ((i & 1) == 1 && aVar.e() == 2) {
                arrayList.add(aVar);
            }
            if ((i & 2) == 2 && aVar.e() == 6) {
                arrayList.add(aVar);
            }
            if ((i & 4) == 4 && aVar.e() == 7) {
                arrayList.add(aVar);
            }
            if ((i & 8) == 8 && aVar.e() == 5) {
                arrayList.add(aVar);
            }
            if ((i & 16) == 16 && aVar.e() == 4) {
                arrayList.add(aVar);
            }
            if ((i & 32) == 32 && aVar.e() == 3) {
                arrayList.add(aVar);
            }
        }
        p(arrayList);
    }

    public void r(TimeZone timeZone) {
        if (timeZone != null) {
            this.f5856d.setTimeZone(timeZone);
        }
    }
}
