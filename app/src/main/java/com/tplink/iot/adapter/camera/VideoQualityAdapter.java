package com.tplink.iot.adapter.camera;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.camera.VideoQualityAdapter;
import com.tplink.libtpnetwork.cameranetwork.model.ResolutionType;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class VideoQualityAdapter extends RecyclerView.Adapter {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private List<ResolutionType> f5406b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ResolutionType f5407c = ResolutionType.HD_720P;

    /* renamed from: d  reason: collision with root package name */
    private a f5408d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(ResolutionType resolutionType);
    }

    /* loaded from: classes2.dex */
    private class b extends RecyclerView.ViewHolder {
        TextView a;

        /* renamed from: b  reason: collision with root package name */
        TextView f5409b;

        /* renamed from: c  reason: collision with root package name */
        CheckBox f5410c;

        /* renamed from: d  reason: collision with root package name */
        View f5411d;

        b(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.tv_title);
            this.f5409b = (TextView) view.findViewById(R.id.tv_subtitle);
            this.f5410c = (CheckBox) view.findViewById(R.id.cb);
            this.f5411d = view;
        }

        private String c(ResolutionType resolutionType) {
            String string = VideoQualityAdapter.this.a.getString(R.string.video_quality_720p);
            ResolutionType resolutionType2 = ResolutionType.HD_4M;
            if (resolutionType == resolutionType2) {
                return resolutionType2.toString();
            }
            ResolutionType resolutionType3 = ResolutionType.HD_3M;
            if (resolutionType == resolutionType3) {
                return resolutionType3.toString();
            }
            if (resolutionType == ResolutionType.HD_1080P) {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_full_hd);
            }
            if (resolutionType == ResolutionType.HD_720P) {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_hd);
            }
            return resolutionType == ResolutionType.VGA_360P ? "" : string;
        }

        private String d(ResolutionType resolutionType) {
            String str = VideoQualityAdapter.this.a.getString(R.string.video_quality_720p) + "(" + VideoQualityAdapter.this.a.getString(R.string.video_quality_720p_tag) + ")";
            if (resolutionType == ResolutionType.HD_4M) {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_4mp);
            }
            if (resolutionType == ResolutionType.HD_3M) {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_3mp);
            }
            if (resolutionType == ResolutionType.HD_1080P) {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_1080p);
            }
            if (resolutionType == ResolutionType.HD_720P) {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_720p) + "(" + VideoQualityAdapter.this.a.getString(R.string.video_quality_720p_tag) + ")";
            } else if (resolutionType != ResolutionType.VGA_360P) {
                return str;
            } else {
                return VideoQualityAdapter.this.a.getString(R.string.video_quality_360p) + "(" + VideoQualityAdapter.this.a.getString(R.string.video_quality_360p_tag) + ")";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g(ResolutionType resolutionType, View view) {
            VideoQualityAdapter.this.f5407c = resolutionType;
            if (VideoQualityAdapter.this.f5408d != null) {
                VideoQualityAdapter.this.f5408d.a(resolutionType);
            }
            VideoQualityAdapter.this.notifyDataSetChanged();
        }

        public void e(final ResolutionType resolutionType) {
            this.f5410c.setChecked(VideoQualityAdapter.this.f5407c == resolutionType);
            this.a.setText(d(resolutionType));
            this.f5409b.setText(c(resolutionType));
            this.f5411d.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.camera.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoQualityAdapter.b.this.g(resolutionType, view);
                }
            });
        }
    }

    public VideoQualityAdapter(Activity activity, a aVar) {
        this.a = activity;
        this.f5408d = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ResolutionType> list = this.f5406b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((b) viewHolder).e(this.f5406b.get(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.a).inflate(R.layout.item_video_quality, viewGroup, false));
    }

    public ResolutionType q() {
        return this.f5407c;
    }

    public void r(ResolutionType resolutionType) {
        this.f5407c = resolutionType;
        if (!this.f5406b.isEmpty()) {
            notifyDataSetChanged();
        }
    }

    public void s(List<ResolutionType> list) {
        this.f5406b.clear();
        this.f5406b.addAll(list);
        notifyDataSetChanged();
    }
}
