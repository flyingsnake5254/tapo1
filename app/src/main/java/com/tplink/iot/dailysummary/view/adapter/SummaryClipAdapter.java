package com.tplink.iot.dailysummary.view.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.q0;
import com.tplink.iot.dailysummary.model.SummaryClipItem;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClip;
import com.tplink.iot.dailysummary.network.bean.common.SummaryClipVideo;
import com.tplink.iot.dailysummary.network.bean.common.SummaryImage;
import com.tplink.iot.dailysummary.view.SummaryClipListActivity;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryClipTitleViewHolder;
import com.tplink.iot.dailysummary.view.viewhodlder.SummaryClipVideoViewHolder;
import com.tplink.iot.databinding.ItemSummaryClipTitleBinding;
import com.tplink.iot.databinding.ItemSummaryClipVideoBinding;
import com.tplink.iot.e.a.c;
import com.tplink.libtpmediastatistics.SSLClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.j;
import kotlin.text.w;

/* compiled from: SummaryClipAdapter.kt */
/* loaded from: classes2.dex */
public final class SummaryClipAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final Context f6344b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<SummaryClipItem> f6345c;

    /* renamed from: d  reason: collision with root package name */
    private int f6346d = -1;

    /* compiled from: SummaryClipAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: SummaryClipAdapter.kt */
    /* loaded from: classes2.dex */
    static final class b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SummaryClipVideoViewHolder f6347c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ SummaryClipAdapter f6348d;

        b(SummaryClipVideoViewHolder summaryClipVideoViewHolder, SummaryClipAdapter summaryClipAdapter) {
            this.f6347c = summaryClipVideoViewHolder;
            this.f6348d = summaryClipAdapter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.f6348d.o(this.f6347c.getBindingAdapterPosition());
        }
    }

    public SummaryClipAdapter(Context context, int i) {
        j.e(context, "context");
        this.f6344b = context;
        p(i);
    }

    public static final /* synthetic */ ArrayList n(SummaryClipAdapter summaryClipAdapter) {
        ArrayList<SummaryClipItem> arrayList = summaryClipAdapter.f6345c;
        if (arrayList == null) {
            j.t("mSummaryClipAdapterList");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(int i) {
        int i2 = this.f6346d;
        if (i != i2) {
            if (i2 >= 0) {
                ArrayList<SummaryClipItem> arrayList = this.f6345c;
                if (arrayList == null) {
                    j.t("mSummaryClipAdapterList");
                }
                arrayList.get(this.f6346d).setChoosed(false);
                notifyItemChanged(this.f6346d);
            }
            this.f6346d = i;
            ArrayList<SummaryClipItem> arrayList2 = this.f6345c;
            if (arrayList2 == null) {
                j.t("mSummaryClipAdapterList");
            }
            SummaryClipItem summaryClipItem = arrayList2.get(i);
            j.d(summaryClipItem, "mSummaryClipAdapterList[newIndex]");
            SummaryClipItem summaryClipItem2 = summaryClipItem;
            summaryClipItem2.setChoosed(true);
            notifyItemChanged(i);
            SummaryClipVideo video = summaryClipItem2.getVideo();
            if (video != null && !TextUtils.isEmpty(video.getUri()) && !TextUtils.isEmpty(video.getM3u8())) {
                Context context = this.f6344b;
                Objects.requireNonNull(context, "null cannot be cast to non-null type com.tplink.iot.dailysummary.view.SummaryClipListActivity");
                ((SummaryClipListActivity) context).B1(video);
            }
        }
    }

    private final void p(int i) {
        this.f6345c = new ArrayList<>();
        List<SummaryClip> h = c.k.h();
        if (h != null) {
            int i2 = -1;
            int size = h.size() - 1;
            if (size >= 0) {
                int i3 = 0;
                while (true) {
                    SummaryClip summaryClip = h.get(i3);
                    if (!TextUtils.isEmpty(summaryClip.getUuid()) && !TextUtils.isEmpty(summaryClip.getEventLocalTime()) && summaryClip.getVideo() != null && summaryClip.getVideo().size() != 0 && summaryClip.getImage() != null && summaryClip.getImage().size() != 0) {
                        String eventLocalTime = summaryClip.getEventLocalTime();
                        j.d(eventLocalTime, "clip.eventLocalTime");
                        int q = q(eventLocalTime);
                        if (i2 != q) {
                            ArrayList<SummaryClipItem> arrayList = this.f6345c;
                            if (arrayList == null) {
                                j.t("mSummaryClipAdapterList");
                            }
                            String a2 = q0.a(q);
                            j.d(a2, "TimeUtils.generateDisplayHour(hour)");
                            arrayList.add(new SummaryClipItem(null, null, 0L, null, null, false, 1, a2, 63, null));
                            i2 = q;
                        }
                        SummaryImage summaryImage = summaryClip.getImage().get(0);
                        SummaryClipVideo summaryClipVideo = summaryClip.getVideo().get(0);
                        if (summaryImage != null && summaryClipVideo != null) {
                            String uuid = summaryClip.getUuid();
                            j.d(uuid, "clip.uuid");
                            String eventLocalTime2 = summaryClip.getEventLocalTime();
                            j.d(eventLocalTime2, "clip.eventLocalTime");
                            Long splitPoint = summaryClip.getSplitPoint();
                            j.d(splitPoint, "clip.splitPoint");
                            SummaryClipItem summaryClipItem = new SummaryClipItem(uuid, eventLocalTime2, splitPoint.longValue(), summaryClipVideo, summaryImage, false, 0, null, 224, null);
                            ArrayList<SummaryClipItem> arrayList2 = this.f6345c;
                            if (arrayList2 == null) {
                                j.t("mSummaryClipAdapterList");
                            }
                            arrayList2.add(summaryClipItem);
                            if (i3 == i) {
                                ArrayList<SummaryClipItem> arrayList3 = this.f6345c;
                                if (arrayList3 == null) {
                                    j.t("mSummaryClipAdapterList");
                                }
                                o(arrayList3.indexOf(summaryClipItem));
                            }
                        }
                    }
                    if (i3 != size) {
                        i3++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private final int q(String str) {
        List f0;
        List f02;
        f0 = w.f0(str, new String[]{SSLClient.WHITE_SPACE}, false, 0, 6, null);
        Object[] array = f0.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr = (String[]) array;
        if (strArr.length != 2) {
            return -1;
        }
        f02 = w.f0(strArr[1], new String[]{SSLClient.COLON}, false, 0, 6, null);
        Object[] array2 = f02.toArray(new String[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        String[] strArr2 = (String[]) array2;
        if (strArr2.length == 3) {
            return Integer.parseInt(strArr2[0]);
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        ArrayList<SummaryClipItem> arrayList = this.f6345c;
        if (arrayList == null) {
            j.t("mSummaryClipAdapterList");
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        ArrayList<SummaryClipItem> arrayList = this.f6345c;
        if (arrayList == null) {
            j.t("mSummaryClipAdapterList");
        }
        return arrayList.get(i).getType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        j.e(recyclerView, "recyclerView");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        if (gridLayoutManager != null) {
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.tplink.iot.dailysummary.view.adapter.SummaryClipAdapter$onAttachedToRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    return ((SummaryClipItem) SummaryClipAdapter.n(SummaryClipAdapter.this).get(i)).getType() == 2 ? 1 : 2;
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        j.e(holder, "holder");
        ArrayList<SummaryClipItem> arrayList = this.f6345c;
        if (arrayList == null) {
            j.t("mSummaryClipAdapterList");
        }
        if (arrayList.size() != 0) {
            if (holder instanceof SummaryClipTitleViewHolder) {
                SummaryClipTitleViewHolder summaryClipTitleViewHolder = (SummaryClipTitleViewHolder) holder;
                ArrayList<SummaryClipItem> arrayList2 = this.f6345c;
                if (arrayList2 == null) {
                    j.t("mSummaryClipAdapterList");
                }
                summaryClipTitleViewHolder.c(arrayList2.get(i).getDisplayHour());
                return;
            }
            SummaryClipVideoViewHolder summaryClipVideoViewHolder = (SummaryClipVideoViewHolder) holder;
            ArrayList<SummaryClipItem> arrayList3 = this.f6345c;
            if (arrayList3 == null) {
                j.t("mSummaryClipAdapterList");
            }
            SummaryClipItem summaryClipItem = arrayList3.get(i);
            j.d(summaryClipItem, "mSummaryClipAdapterList[position]");
            summaryClipVideoViewHolder.c(summaryClipItem);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        j.e(parent, "parent");
        if (i != 1) {
            ItemSummaryClipVideoBinding binding = (ItemSummaryClipVideoBinding) DataBindingUtil.inflate(LayoutInflater.from(this.f6344b), R.layout.item_summary_clip_video, parent, false);
            j.d(binding, "binding");
            SummaryClipVideoViewHolder summaryClipVideoViewHolder = new SummaryClipVideoViewHolder(binding);
            summaryClipVideoViewHolder.itemView.setOnClickListener(new b(summaryClipVideoViewHolder, this));
            return summaryClipVideoViewHolder;
        }
        ItemSummaryClipTitleBinding binding2 = (ItemSummaryClipTitleBinding) DataBindingUtil.inflate(LayoutInflater.from(this.f6344b), R.layout.item_summary_clip_title, parent, false);
        j.d(binding2, "binding");
        return new SummaryClipTitleViewHolder(binding2);
    }

    public final int r() {
        return this.f6346d;
    }
}
