package com.tplink.iot.adapter.playback;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class RecordTypeAdapter extends RecyclerView.Adapter {
    private List<Integer> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f5850b;

    /* loaded from: classes2.dex */
    private class a extends RecyclerView.ViewHolder {
        View a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f5851b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5852c;

        a(View view) {
            super(view);
            this.a = view.findViewById(R.id.bg);
            this.f5851b = (ImageView) view.findViewById(R.id.iv_record_type);
            this.f5852c = (TextView) view.findViewById(R.id.tv_record_type);
        }

        private void d(int i) {
            this.a.setBackgroundResource(R.drawable.level_list_video_type);
            this.a.getBackground().setLevel(i);
            int i2 = R.string.playback_type_timing;
            int i3 = R.drawable.ic_playback_continuous_recording;
            int i4 = R.color.white;
            switch (i) {
                case 1:
                    i4 = R.color.color_333333;
                    break;
                case 2:
                    i3 = R.drawable.ic_playback_motion_detection;
                    i2 = R.string.play_back_motion_detection;
                    break;
                case 3:
                    i3 = R.drawable.ic_playback_tampering;
                    i2 = R.string.setting_video_tampering;
                    break;
                case 4:
                    i3 = R.drawable.ic_playback_line_crossing;
                    i2 = R.string.setting_line_crossing;
                    break;
                case 5:
                    i3 = R.drawable.ic_playback_area_intrusion;
                    i2 = R.string.setting_area_intrusion;
                    break;
                case 6:
                    i3 = R.drawable.ic_playback_person_detection;
                    i2 = R.string.tapo_care_person_detection;
                    break;
                case 7:
                    i3 = R.drawable.ic_playback_baby_crying;
                    i2 = R.string.camera_baby_crying;
                    break;
            }
            this.f5851b.setImageResource(i3);
            this.f5852c.setText(RecordTypeAdapter.this.f5850b.getString(i2));
            this.f5852c.setTextColor(RecordTypeAdapter.this.f5850b.getResources().getColor(i4));
        }

        public void c(Integer num) {
            d(num.intValue());
        }
    }

    public RecordTypeAdapter(Context context) {
        this.f5850b = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.size();
    }

    public void n(List<Integer> list) {
        this.a.clear();
        if (!s.b(list)) {
            this.a.addAll(list);
        }
        Collections.sort(this.a);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((a) viewHolder).c(this.a.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.f5850b).inflate(R.layout.item_playback_record_type, viewGroup, false));
    }
}
