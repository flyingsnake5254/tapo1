package com.tplink.iot.musicphonerhythm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class MusicRhythmModeSetRvAdapter extends RecyclerView.Adapter<ViewHolder> {
    private LayoutInflater a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f8209b;

    /* renamed from: c  reason: collision with root package name */
    private int f8210c;

    /* renamed from: d  reason: collision with root package name */
    private b f8211d;

    /* loaded from: classes2.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f8212b;

        public ViewHolder(View view) {
            super(view);
            this.a = (TextView) view.findViewById(R.id.music_rhythm_tv_choose_name);
            this.f8212b = (ImageView) view.findViewById(R.id.music_rhythm_iv_choose_icon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ViewHolder f8213c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ View f8214d;

        a(ViewHolder viewHolder, View view) {
            this.f8213c = viewHolder;
            this.f8214d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MusicRhythmModeSetRvAdapter.this.f8210c = this.f8213c.getAdapterPosition();
            MusicRhythmModeSetRvAdapter.this.notifyDataSetChanged();
            if (MusicRhythmModeSetRvAdapter.this.f8211d != null) {
                b bVar = MusicRhythmModeSetRvAdapter.this.f8211d;
                View view2 = this.f8214d;
                bVar.a(view2, ((Integer) view2.getTag()).intValue());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, int i);
    }

    public MusicRhythmModeSetRvAdapter(Context context, ArrayList<String> arrayList, int i, b bVar) {
        this.f8210c = -1;
        this.a = LayoutInflater.from(context);
        this.f8209b = arrayList;
        this.f8210c = i;
        this.f8211d = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f8209b.size();
    }

    /* renamed from: o */
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.a.setText(this.f8209b.get(i));
        if (viewHolder.getAdapterPosition() == this.f8210c) {
            viewHolder.f8212b.setVisibility(0);
        } else {
            viewHolder.f8212b.setVisibility(8);
        }
        viewHolder.itemView.setTag(Integer.valueOf(i));
    }

    /* renamed from: p */
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = this.a.inflate(R.layout.music_rhythm_rv_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        inflate.setOnClickListener(new a(viewHolder, inflate));
        return viewHolder;
    }
}
