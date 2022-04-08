package com.google.android.exoplayer2.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.e1;
import com.google.android.exoplayer2.h1;
import com.google.android.exoplayer2.j2;
import com.google.android.exoplayer2.l1;
import com.google.android.exoplayer2.m1;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.t1;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.u1;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.exoplayer2.ui.y0;
import com.google.android.exoplayer2.util.f0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.v1;
import com.google.android.exoplayer2.video.v;
import com.google.android.exoplayer2.video.z;
import com.google.android.exoplayer2.w0;
import com.google.android.exoplayer2.w1;
import com.google.android.exoplayer2.x0;
import io.netty.handler.traffic.AbstractTrafficShapingHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class StyledPlayerControlView extends FrameLayout {
    private long A4;
    private v0 B4;
    private Resources C4;
    private RecyclerView D4;
    private h E4;
    private e F4;
    private PopupWindow G4;
    @Nullable
    private final View H3;
    private boolean H4;
    @Nullable
    private final TextView I3;
    private int I4;
    @Nullable
    private final TextView J3;
    @Nullable
    private DefaultTrackSelector J4;
    @Nullable
    private final y0 K3;
    private l K4;
    private final StringBuilder L3;
    private l L4;
    private final Formatter M3;
    private z0 M4;
    private final j2.b N3;
    @Nullable
    private ImageView N4;
    private final j2.c O3;
    @Nullable
    private ImageView O4;
    private final Runnable P3;
    @Nullable
    private ImageView P4;
    private final Drawable Q3;
    @Nullable
    private View Q4;
    private final Drawable R3;
    @Nullable
    private View R4;
    private final Drawable S3;
    @Nullable
    private View S4;
    private final String T3;
    private final String U3;
    private final String V3;
    private final Drawable W3;
    private final Drawable X3;
    private final float Y3;
    private final float Z3;
    private final String a4;
    private final String b4;

    /* renamed from: c  reason: collision with root package name */
    private final c f3688c;
    private final Drawable c4;

    /* renamed from: d  reason: collision with root package name */
    private final CopyOnWriteArrayList<m> f3689d;
    private final Drawable d4;
    private final String e4;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final View f3690f;
    private final String f4;
    private final Drawable g4;
    private final Drawable h4;
    private final String i4;
    private final String j4;
    @Nullable
    private u1 k4;
    private x0 l4;
    @Nullable
    private f m4;
    @Nullable
    private d n4;
    private boolean o4;
    @Nullable
    private final TextView p0;
    @Nullable
    private final TextView p1;
    @Nullable
    private final ImageView p2;
    @Nullable
    private final ImageView p3;
    private boolean p4;
    @Nullable
    private final View q;
    private boolean q4;
    private boolean r4;
    private boolean s4;
    private int t4;
    private int u4;
    private int v4;
    private long[] w4;
    @Nullable
    private final View x;
    private boolean[] x4;
    @Nullable
    private final View y;
    private long[] y4;
    @Nullable
    private final View z;
    private boolean[] z4;

    /* loaded from: classes.dex */
    private final class b extends l {
        private b() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: u */
        public /* synthetic */ void v(View view) {
            if (StyledPlayerControlView.this.J4 != null) {
                DefaultTrackSelector.d f2 = StyledPlayerControlView.this.J4.s().f();
                for (int i = 0; i < this.a.size(); i++) {
                    f2 = f2.P(this.a.get(i).intValue());
                }
                ((DefaultTrackSelector) com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.this.J4)).K(f2);
            }
            StyledPlayerControlView.this.E4.o(1, StyledPlayerControlView.this.getResources().getString(r0.exo_track_selection_auto));
            StyledPlayerControlView.this.G4.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void n(List<Integer> list, List<k> list2, i.a aVar) {
            boolean z;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z = false;
                    break;
                }
                int intValue = list.get(i2).intValue();
                TrackGroupArray e2 = aVar.e(intValue);
                if (StyledPlayerControlView.this.J4 != null && StyledPlayerControlView.this.J4.s().m(intValue, e2)) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!list2.isEmpty()) {
                if (z) {
                    while (true) {
                        if (i >= list2.size()) {
                            break;
                        }
                        k kVar = list2.get(i);
                        if (kVar.f3707e) {
                            StyledPlayerControlView.this.E4.o(1, kVar.f3706d);
                            break;
                        }
                        i++;
                    }
                } else {
                    StyledPlayerControlView.this.E4.o(1, StyledPlayerControlView.this.getResources().getString(r0.exo_track_selection_auto));
                }
            } else {
                StyledPlayerControlView.this.E4.o(1, StyledPlayerControlView.this.getResources().getString(r0.exo_track_selection_none));
            }
            this.a = list;
            this.f3708b = list2;
            this.f3709c = aVar;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void r(i iVar) {
            boolean z;
            iVar.a.setText(r0.exo_track_selection_auto);
            DefaultTrackSelector.Parameters s = ((DefaultTrackSelector) com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.this.J4)).s();
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.a.size()) {
                    z = false;
                    break;
                }
                int intValue = this.a.get(i2).intValue();
                if (s.m(intValue, ((i.a) com.google.android.exoplayer2.util.g.e(this.f3709c)).e(intValue))) {
                    z = true;
                    break;
                }
                i2++;
            }
            View view = iVar.f3702b;
            if (z) {
                i = 4;
            }
            view.setVisibility(i);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StyledPlayerControlView.b.this.v(view2);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void t(String str) {
            StyledPlayerControlView.this.E4.o(1, str);
        }
    }

    /* loaded from: classes.dex */
    private final class c implements u1.e, y0.a, View.OnClickListener, PopupWindow.OnDismissListener {
        private c() {
        }

        @Override // com.google.android.exoplayer2.text.k
        public /* synthetic */ void B(List list) {
            w1.b(this, list);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void G(TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.k kVar) {
            w1.x(this, trackGroupArray, kVar);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void I(int i, int i2) {
            w1.v(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void J(PlaybackException playbackException) {
            w1.p(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void K(int i) {
            v1.l(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void M(boolean z) {
            w1.f(this, z);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void O() {
            v1.o(this);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void P(PlaybackException playbackException) {
            w1.o(this, playbackException);
        }

        @Override // com.google.android.exoplayer2.audio.r
        public /* synthetic */ void R(float f2) {
            w1.z(this, f2);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public void S(u1 u1Var, u1.d dVar) {
            if (dVar.b(5, 6)) {
                StyledPlayerControlView.this.A0();
            }
            if (dVar.b(5, 6, 8)) {
                StyledPlayerControlView.this.C0();
            }
            if (dVar.a(9)) {
                StyledPlayerControlView.this.D0();
            }
            if (dVar.a(10)) {
                StyledPlayerControlView.this.G0();
            }
            if (dVar.b(9, 10, 12, 0, 17, 18)) {
                StyledPlayerControlView.this.z0();
            }
            if (dVar.b(12, 0)) {
                StyledPlayerControlView.this.H0();
            }
            if (dVar.a(13)) {
                StyledPlayerControlView.this.B0();
            }
            if (dVar.a(2)) {
                StyledPlayerControlView.this.I0();
            }
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void U(boolean z, int i) {
            v1.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void W(int i, int i2, int i3, float f2) {
            v.a(this, i, i2, i3, f2);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void Y(l1 l1Var, int i) {
            w1.h(this, l1Var, i);
        }

        @Override // com.google.android.exoplayer2.audio.r, com.google.android.exoplayer2.audio.t
        public /* synthetic */ void a(boolean z) {
            w1.u(this, z);
        }

        @Override // com.google.android.exoplayer2.ui.y0.a
        public void b(y0 y0Var, long j) {
            if (StyledPlayerControlView.this.J3 != null) {
                StyledPlayerControlView.this.J3.setText(o0.Z(StyledPlayerControlView.this.L3, StyledPlayerControlView.this.M3, j));
            }
        }

        @Override // com.google.android.exoplayer2.video.w, com.google.android.exoplayer2.video.y
        public /* synthetic */ void c(z zVar) {
            w1.y(this, zVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void d(t1 t1Var) {
            w1.l(this, t1Var);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void d0(boolean z, int i) {
            w1.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void e(u1.f fVar, u1.f fVar2, int i) {
            w1.q(this, fVar, fVar2, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void f(int i) {
            w1.n(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void g(boolean z) {
            v1.d(this, z);
        }

        @Override // com.google.android.exoplayer2.ui.y0.a
        public void h(y0 y0Var, long j, boolean z) {
            StyledPlayerControlView.this.s4 = false;
            if (!z && StyledPlayerControlView.this.k4 != null) {
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                styledPlayerControlView.r0(styledPlayerControlView.k4, j);
            }
            StyledPlayerControlView.this.B4.W();
        }

        @Override // com.google.android.exoplayer2.ui.y0.a
        public void i(y0 y0Var, long j) {
            StyledPlayerControlView.this.s4 = true;
            if (StyledPlayerControlView.this.J3 != null) {
                StyledPlayerControlView.this.J3.setText(o0.Z(StyledPlayerControlView.this.L3, StyledPlayerControlView.this.M3, j));
            }
            StyledPlayerControlView.this.B4.V();
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void j(List list) {
            v1.q(this, list);
        }

        @Override // com.google.android.exoplayer2.n2.c
        public /* synthetic */ void k0(com.google.android.exoplayer2.n2.b bVar) {
            w1.c(this, bVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void m0(boolean z) {
            w1.g(this, z);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void n(u1.b bVar) {
            w1.a(this, bVar);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void o(j2 j2Var, int i) {
            w1.w(this, j2Var, i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            u1 u1Var = StyledPlayerControlView.this.k4;
            if (u1Var != null) {
                StyledPlayerControlView.this.B4.W();
                if (StyledPlayerControlView.this.q == view) {
                    StyledPlayerControlView.this.l4.j(u1Var);
                } else if (StyledPlayerControlView.this.f3690f == view) {
                    StyledPlayerControlView.this.l4.i(u1Var);
                } else if (StyledPlayerControlView.this.y == view) {
                    if (u1Var.getPlaybackState() != 4) {
                        StyledPlayerControlView.this.l4.f(u1Var);
                    }
                } else if (StyledPlayerControlView.this.z == view) {
                    StyledPlayerControlView.this.l4.b(u1Var);
                } else if (StyledPlayerControlView.this.x == view) {
                    StyledPlayerControlView.this.W(u1Var);
                } else if (StyledPlayerControlView.this.p2 == view) {
                    StyledPlayerControlView.this.l4.e(u1Var, f0.a(u1Var.getRepeatMode(), StyledPlayerControlView.this.v4));
                } else if (StyledPlayerControlView.this.p3 == view) {
                    StyledPlayerControlView.this.l4.d(u1Var, !u1Var.Q());
                } else if (StyledPlayerControlView.this.Q4 == view) {
                    StyledPlayerControlView.this.B4.V();
                    StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                    styledPlayerControlView.X(styledPlayerControlView.E4);
                } else if (StyledPlayerControlView.this.R4 == view) {
                    StyledPlayerControlView.this.B4.V();
                    StyledPlayerControlView styledPlayerControlView2 = StyledPlayerControlView.this;
                    styledPlayerControlView2.X(styledPlayerControlView2.F4);
                } else if (StyledPlayerControlView.this.S4 == view) {
                    StyledPlayerControlView.this.B4.V();
                    StyledPlayerControlView styledPlayerControlView3 = StyledPlayerControlView.this;
                    styledPlayerControlView3.X(styledPlayerControlView3.L4);
                } else if (StyledPlayerControlView.this.N4 == view) {
                    StyledPlayerControlView.this.B4.V();
                    StyledPlayerControlView styledPlayerControlView4 = StyledPlayerControlView.this;
                    styledPlayerControlView4.X(styledPlayerControlView4.K4);
                }
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (StyledPlayerControlView.this.H4) {
                StyledPlayerControlView.this.B4.W();
            }
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void onRepeatModeChanged(int i) {
            w1.s(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void q(int i) {
            w1.m(this, i);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void s(m1 m1Var) {
            w1.i(this, m1Var);
        }

        @Override // com.google.android.exoplayer2.u1.c
        public /* synthetic */ void v(boolean z) {
            w1.t(this, z);
        }

        @Override // com.google.android.exoplayer2.metadata.e
        public /* synthetic */ void w(Metadata metadata) {
            w1.j(this, metadata);
        }

        @Override // com.google.android.exoplayer2.n2.c
        public /* synthetic */ void x(int i, boolean z) {
            w1.d(this, i, z);
        }

        @Override // com.google.android.exoplayer2.video.w
        public /* synthetic */ void z() {
            w1.r(this);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e extends RecyclerView.Adapter<i> {
        private final String[] a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f3693b;

        /* renamed from: c  reason: collision with root package name */
        private int f3694c;

        public e(String[] strArr, int[] iArr) {
            this.a = strArr;
            this.f3693b = iArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: n */
        public /* synthetic */ void o(int i, View view) {
            if (i != this.f3694c) {
                StyledPlayerControlView.this.setPlaybackSpeed(this.f3693b[i] / 100.0f);
            }
            StyledPlayerControlView.this.G4.dismiss();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.length;
        }

        public String m() {
            return this.a[this.f3694c];
        }

        /* renamed from: p */
        public void onBindViewHolder(i iVar, final int i) {
            String[] strArr = this.a;
            if (i < strArr.length) {
                iVar.a.setText(strArr[i]);
            }
            iVar.f3702b.setVisibility(i == this.f3694c ? 0 : 4);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    StyledPlayerControlView.e.this.o(i, view);
                }
            });
        }

        /* renamed from: q */
        public i onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(p0.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public void r(float f2) {
            int round = Math.round(f2 * 100.0f);
            int i = 0;
            int i2 = 0;
            int i3 = Integer.MAX_VALUE;
            while (true) {
                int[] iArr = this.f3693b;
                if (i < iArr.length) {
                    int abs = Math.abs(round - iArr[i]);
                    if (abs < i3) {
                        i2 = i;
                        i3 = abs;
                    }
                    i++;
                } else {
                    this.f3694c = i2;
                    return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(long j, long j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class g extends RecyclerView.ViewHolder {
        private final TextView a;

        /* renamed from: b  reason: collision with root package name */
        private final TextView f3696b;

        /* renamed from: c  reason: collision with root package name */
        private final ImageView f3697c;

        public g(View view) {
            super(view);
            if (o0.a < 26) {
                view.setFocusable(true);
            }
            this.a = (TextView) view.findViewById(n0.exo_main_text);
            this.f3696b = (TextView) view.findViewById(n0.exo_sub_text);
            this.f3697c = (ImageView) view.findViewById(n0.exo_icon);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StyledPlayerControlView.g.this.g(view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: f */
        public /* synthetic */ void g(View view) {
            StyledPlayerControlView.this.n0(getAdapterPosition());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h extends RecyclerView.Adapter<g> {
        private final String[] a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f3699b;

        /* renamed from: c  reason: collision with root package name */
        private final Drawable[] f3700c;

        public h(String[] strArr, Drawable[] drawableArr) {
            this.a = strArr;
            this.f3699b = new String[strArr.length];
            this.f3700c = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* renamed from: m */
        public void onBindViewHolder(g gVar, int i) {
            gVar.a.setText(this.a[i]);
            if (this.f3699b[i] == null) {
                gVar.f3696b.setVisibility(8);
            } else {
                gVar.f3696b.setText(this.f3699b[i]);
            }
            if (this.f3700c[i] == null) {
                gVar.f3697c.setVisibility(8);
            } else {
                gVar.f3697c.setImageDrawable(this.f3700c[i]);
            }
        }

        /* renamed from: n */
        public g onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new g(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(p0.exo_styled_settings_list_item, viewGroup, false));
        }

        public void o(int i, String str) {
            this.f3699b[i] = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i extends RecyclerView.ViewHolder {
        public final TextView a;

        /* renamed from: b  reason: collision with root package name */
        public final View f3702b;

        public i(View view) {
            super(view);
            if (o0.a < 26) {
                view.setFocusable(true);
            }
            this.a = (TextView) view.findViewById(n0.exo_text);
            this.f3702b = view.findViewById(n0.exo_check);
        }
    }

    /* loaded from: classes.dex */
    private final class j extends l {
        private j() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: u */
        public /* synthetic */ void v(View view) {
            if (StyledPlayerControlView.this.J4 != null) {
                DefaultTrackSelector.d f2 = StyledPlayerControlView.this.J4.s().f();
                for (int i = 0; i < this.a.size(); i++) {
                    int intValue = this.a.get(i).intValue();
                    f2 = f2.P(intValue).T(intValue, true);
                }
                ((DefaultTrackSelector) com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.this.J4)).K(f2);
                StyledPlayerControlView.this.G4.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void n(List<Integer> list, List<k> list2, i.a aVar) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list2.size()) {
                    break;
                } else if (list2.get(i).f3707e) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (StyledPlayerControlView.this.N4 != null) {
                ImageView imageView = StyledPlayerControlView.this.N4;
                StyledPlayerControlView styledPlayerControlView = StyledPlayerControlView.this;
                imageView.setImageDrawable(z ? styledPlayerControlView.c4 : styledPlayerControlView.d4);
                StyledPlayerControlView.this.N4.setContentDescription(z ? StyledPlayerControlView.this.e4 : StyledPlayerControlView.this.f4);
            }
            this.a = list;
            this.f3708b = list2;
            this.f3709c = aVar;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        /* renamed from: q */
        public void onBindViewHolder(i iVar, int i) {
            super.onBindViewHolder(iVar, i);
            if (i > 0) {
                iVar.f3702b.setVisibility(this.f3708b.get(i + (-1)).f3707e ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void r(i iVar) {
            boolean z;
            iVar.a.setText(r0.exo_track_selection_none);
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= this.f3708b.size()) {
                    z = true;
                    break;
                } else if (this.f3708b.get(i2).f3707e) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            View view = iVar.f3702b;
            if (!z) {
                i = 4;
            }
            view.setVisibility(i);
            iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    StyledPlayerControlView.j.this.v(view2);
                }
            });
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.l
        public void t(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class k {
        public final int a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3704b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3705c;

        /* renamed from: d  reason: collision with root package name */
        public final String f3706d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f3707e;

        public k(int i, int i2, int i3, String str, boolean z) {
            this.a = i;
            this.f3704b = i2;
            this.f3705c = i3;
            this.f3706d = str;
            this.f3707e = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class l extends RecyclerView.Adapter<i> {
        protected List<Integer> a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        protected List<k> f3708b = new ArrayList();
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        protected i.a f3709c = null;

        public l() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: o */
        public /* synthetic */ void p(k kVar, View view) {
            if (!(this.f3709c == null || StyledPlayerControlView.this.J4 == null)) {
                DefaultTrackSelector.d f2 = StyledPlayerControlView.this.J4.s().f();
                for (int i = 0; i < this.a.size(); i++) {
                    int intValue = this.a.get(i).intValue();
                    if (intValue == kVar.a) {
                        f2 = f2.U(intValue, ((i.a) com.google.android.exoplayer2.util.g.e(this.f3709c)).e(intValue), new DefaultTrackSelector.SelectionOverride(kVar.f3704b, kVar.f3705c)).T(intValue, false);
                    } else {
                        f2 = f2.P(intValue).T(intValue, true);
                    }
                }
                ((DefaultTrackSelector) com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.this.J4)).K(f2);
                t(kVar.f3706d);
                StyledPlayerControlView.this.G4.dismiss();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.f3708b.isEmpty()) {
                return 0;
            }
            return this.f3708b.size() + 1;
        }

        public void m() {
            this.f3708b = Collections.emptyList();
            this.f3709c = null;
        }

        public abstract void n(List<Integer> list, List<k> list2, i.a aVar);

        /* renamed from: q */
        public void onBindViewHolder(i iVar, int i) {
            if (StyledPlayerControlView.this.J4 != null && this.f3709c != null) {
                if (i == 0) {
                    r(iVar);
                    return;
                }
                boolean z = true;
                final k kVar = this.f3708b.get(i - 1);
                int i2 = 0;
                if (!((DefaultTrackSelector) com.google.android.exoplayer2.util.g.e(StyledPlayerControlView.this.J4)).s().m(kVar.a, this.f3709c.e(kVar.a)) || !kVar.f3707e) {
                    z = false;
                }
                iVar.a.setText(kVar.f3706d);
                View view = iVar.f3702b;
                if (!z) {
                    i2 = 4;
                }
                view.setVisibility(i2);
                iVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        StyledPlayerControlView.l.this.p(kVar, view2);
                    }
                });
            }
        }

        public abstract void r(i iVar);

        /* renamed from: s */
        public i onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(StyledPlayerControlView.this.getContext()).inflate(p0.exo_styled_sub_settings_list_item, viewGroup, false));
        }

        public abstract void t(String str);
    }

    /* loaded from: classes.dex */
    public interface m {
        void b(int i);
    }

    static {
        h1.a("goog.exo.ui");
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        if (g0() && this.p4 && this.x != null) {
            if (s0()) {
                ((ImageView) this.x).setImageDrawable(this.C4.getDrawable(l0.exo_styled_controls_pause));
                this.x.setContentDescription(this.C4.getString(r0.exo_controls_pause_description));
                return;
            }
            ((ImageView) this.x).setImageDrawable(this.C4.getDrawable(l0.exo_styled_controls_play));
            this.x.setContentDescription(this.C4.getString(r0.exo_controls_play_description));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        u1 u1Var = this.k4;
        if (u1Var != null) {
            this.F4.r(u1Var.c().f3437c);
            this.E4.o(0, this.F4.m());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        long j2;
        if (g0() && this.p4) {
            u1 u1Var = this.k4;
            long j3 = 0;
            if (u1Var != null) {
                j3 = this.A4 + u1Var.M();
                j2 = this.A4 + u1Var.R();
            } else {
                j2 = 0;
            }
            TextView textView = this.J3;
            if (textView != null && !this.s4) {
                textView.setText(o0.Z(this.L3, this.M3, j3));
            }
            y0 y0Var = this.K3;
            if (y0Var != null) {
                y0Var.setPosition(j3);
                this.K3.setBufferedPosition(j2);
            }
            f fVar = this.m4;
            if (fVar != null) {
                fVar.a(j3, j2);
            }
            removeCallbacks(this.P3);
            int playbackState = u1Var == null ? 1 : u1Var.getPlaybackState();
            long j4 = 1000;
            if (u1Var != null && u1Var.O()) {
                y0 y0Var2 = this.K3;
                long min = Math.min(y0Var2 != null ? y0Var2.getPreferredUpdateDelay() : 1000L, 1000 - (j3 % 1000));
                float f2 = u1Var.c().f3437c;
                if (f2 > 0.0f) {
                    j4 = ((float) min) / f2;
                }
                postDelayed(this.P3, o0.q(j4, this.u4, 1000L));
            } else if (playbackState != 4 && playbackState != 1) {
                postDelayed(this.P3, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        ImageView imageView;
        if (g0() && this.p4 && (imageView = this.p2) != null) {
            if (this.v4 == 0) {
                v0(false, imageView);
                return;
            }
            u1 u1Var = this.k4;
            if (u1Var == null) {
                v0(false, imageView);
                this.p2.setImageDrawable(this.Q3);
                this.p2.setContentDescription(this.T3);
                return;
            }
            v0(true, imageView);
            int repeatMode = u1Var.getRepeatMode();
            if (repeatMode == 0) {
                this.p2.setImageDrawable(this.Q3);
                this.p2.setContentDescription(this.T3);
            } else if (repeatMode == 1) {
                this.p2.setImageDrawable(this.R3);
                this.p2.setContentDescription(this.U3);
            } else if (repeatMode == 2) {
                this.p2.setImageDrawable(this.S3);
                this.p2.setContentDescription(this.V3);
            }
        }
    }

    private void E0() {
        u1 u1Var;
        x0 x0Var = this.l4;
        int n = (int) (((!(x0Var instanceof com.google.android.exoplayer2.y0) || (u1Var = this.k4) == null) ? 5000L : ((com.google.android.exoplayer2.y0) x0Var).n(u1Var)) / 1000);
        TextView textView = this.p1;
        if (textView != null) {
            textView.setText(String.valueOf(n));
        }
        View view = this.z;
        if (view != null) {
            view.setContentDescription(this.C4.getQuantityString(q0.exo_controls_rewind_by_amount_description, n, Integer.valueOf(n)));
        }
    }

    private void F0() {
        this.D4.measure(0, 0);
        this.G4.setWidth(Math.min(this.D4.getMeasuredWidth(), getWidth() - (this.I4 * 2)));
        this.G4.setHeight(Math.min(getHeight() - (this.I4 * 2), this.D4.getMeasuredHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        ImageView imageView;
        String str;
        if (g0() && this.p4 && (imageView = this.p3) != null) {
            u1 u1Var = this.k4;
            if (!this.B4.n(imageView)) {
                v0(false, this.p3);
            } else if (u1Var == null) {
                v0(false, this.p3);
                this.p3.setImageDrawable(this.X3);
                this.p3.setContentDescription(this.b4);
            } else {
                v0(true, this.p3);
                this.p3.setImageDrawable(u1Var.Q() ? this.W3 : this.X3);
                ImageView imageView2 = this.p3;
                if (u1Var.Q()) {
                    str = this.a4;
                } else {
                    str = this.b4;
                }
                imageView2.setContentDescription(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        int i2;
        j2.c cVar;
        u1 u1Var = this.k4;
        if (u1Var != null) {
            boolean z = true;
            this.r4 = this.q4 && S(u1Var.w(), this.O3);
            long j2 = 0;
            this.A4 = 0L;
            j2 w = u1Var.w();
            if (!w.q()) {
                int m2 = u1Var.m();
                boolean z2 = this.r4;
                int i3 = z2 ? 0 : m2;
                int p = z2 ? w.p() - 1 : m2;
                long j3 = 0;
                i2 = 0;
                while (true) {
                    if (i3 > p) {
                        break;
                    }
                    if (i3 == m2) {
                        this.A4 = w0.e(j3);
                    }
                    w.n(i3, this.O3);
                    j2.c cVar2 = this.O3;
                    if (cVar2.r == -9223372036854775807L) {
                        com.google.android.exoplayer2.util.g.g(this.r4 ^ z);
                        break;
                    }
                    int i4 = cVar2.s;
                    while (true) {
                        cVar = this.O3;
                        if (i4 <= cVar.t) {
                            w.f(i4, this.N3);
                            int c2 = this.N3.c();
                            for (int n = this.N3.n(); n < c2; n++) {
                                long f2 = this.N3.f(n);
                                if (f2 == Long.MIN_VALUE) {
                                    long j4 = this.N3.f2331e;
                                    if (j4 != -9223372036854775807L) {
                                        f2 = j4;
                                    }
                                }
                                long m3 = f2 + this.N3.m();
                                if (m3 >= 0) {
                                    long[] jArr = this.w4;
                                    if (i2 == jArr.length) {
                                        int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                        this.w4 = Arrays.copyOf(jArr, length);
                                        this.x4 = Arrays.copyOf(this.x4, length);
                                    }
                                    this.w4[i2] = w0.e(j3 + m3);
                                    this.x4[i2] = this.N3.o(n);
                                    i2++;
                                }
                            }
                            i4++;
                        }
                    }
                    j3 += cVar.r;
                    i3++;
                    z = true;
                }
                j2 = j3;
            } else {
                i2 = 0;
            }
            long e2 = w0.e(j2);
            TextView textView = this.I3;
            if (textView != null) {
                textView.setText(o0.Z(this.L3, this.M3, e2));
            }
            y0 y0Var = this.K3;
            if (y0Var != null) {
                y0Var.setDuration(e2);
                int length2 = this.y4.length;
                int i5 = i2 + length2;
                long[] jArr2 = this.w4;
                if (i5 > jArr2.length) {
                    this.w4 = Arrays.copyOf(jArr2, i5);
                    this.x4 = Arrays.copyOf(this.x4, i5);
                }
                System.arraycopy(this.y4, 0, this.w4, i2, length2);
                System.arraycopy(this.z4, 0, this.x4, i2, length2);
                this.K3.b(this.w4, this.x4, i5);
            }
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        c0();
        v0(this.K4.getItemCount() > 0, this.N4);
    }

    private static boolean S(j2 j2Var, j2.c cVar) {
        if (j2Var.p() > 100) {
            return false;
        }
        int p = j2Var.p();
        for (int i2 = 0; i2 < p; i2++) {
            if (j2Var.n(i2, cVar).r == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private void U(u1 u1Var) {
        this.l4.l(u1Var, false);
    }

    private void V(u1 u1Var) {
        int playbackState = u1Var.getPlaybackState();
        if (playbackState == 1) {
            this.l4.h(u1Var);
        } else if (playbackState == 4) {
            q0(u1Var, u1Var.m(), -9223372036854775807L);
        }
        this.l4.l(u1Var, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W(u1 u1Var) {
        int playbackState = u1Var.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !u1Var.E()) {
            V(u1Var);
        } else {
            U(u1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(RecyclerView.Adapter<?> adapter) {
        this.D4.setAdapter(adapter);
        F0();
        this.H4 = false;
        this.G4.dismiss();
        this.H4 = true;
        this.G4.showAsDropDown(this, (getWidth() - this.G4.getWidth()) - this.I4, (-this.G4.getHeight()) - this.I4);
    }

    private void Y(i.a aVar, int i2, List<k> list) {
        TrackGroupArray e2 = aVar.e(i2);
        com.google.android.exoplayer2.trackselection.j a2 = ((u1) com.google.android.exoplayer2.util.g.e(this.k4)).A().a(i2);
        for (int i3 = 0; i3 < e2.f3161d; i3++) {
            TrackGroup a3 = e2.a(i3);
            for (int i4 = 0; i4 < a3.f3157c; i4++) {
                Format a4 = a3.a(i4);
                if (aVar.f(i2, i3, i4) == 4) {
                    list.add(new k(i2, i3, i4, this.M4.a(a4), (a2 == null || a2.p(a4) == -1) ? false : true));
                }
            }
        }
    }

    private static int Z(TypedArray typedArray, int i2) {
        return typedArray.getInt(t0.StyledPlayerControlView_repeat_toggle_modes, i2);
    }

    private void c0() {
        DefaultTrackSelector defaultTrackSelector;
        i.a g2;
        this.K4.m();
        this.L4.m();
        if (!(this.k4 == null || (defaultTrackSelector = this.J4) == null || (g2 = defaultTrackSelector.g()) == null)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i2 = 0; i2 < g2.c(); i2++) {
                if (g2.d(i2) == 3 && this.B4.n(this.N4)) {
                    Y(g2, i2, arrayList);
                    arrayList3.add(Integer.valueOf(i2));
                } else if (g2.d(i2) == 1) {
                    Y(g2, i2, arrayList2);
                    arrayList4.add(Integer.valueOf(i2));
                }
            }
            this.K4.n(arrayList3, arrayList, g2);
            this.L4.n(arrayList4, arrayList2, g2);
        }
    }

    private static void d0(View view, View.OnClickListener onClickListener) {
        if (view != null) {
            view.setVisibility(8);
            view.setOnClickListener(onClickListener);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean f0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(View view) {
        if (this.n4 != null) {
            boolean z = !this.o4;
            this.o4 = z;
            x0(this.O4, z);
            x0(this.P4, this.o4);
            d dVar = this.n4;
            if (dVar != null) {
                dVar.a(this.o4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.G4.isShowing()) {
            F0();
            this.G4.update(view, (getWidth() - this.G4.getWidth()) - this.I4, (-this.G4.getHeight()) - this.I4, -1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i2) {
        if (i2 == 0) {
            X(this.F4);
        } else if (i2 == 1) {
            X(this.L4);
        } else {
            this.G4.dismiss();
        }
    }

    private boolean q0(u1 u1Var, int i2, long j2) {
        return this.l4.c(u1Var, i2, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(u1 u1Var, long j2) {
        int i2;
        j2 w = u1Var.w();
        if (this.r4 && !w.q()) {
            int p = w.p();
            i2 = 0;
            while (true) {
                long d2 = w.n(i2, this.O3).d();
                if (j2 < d2) {
                    break;
                } else if (i2 == p - 1) {
                    j2 = d2;
                    break;
                } else {
                    j2 -= d2;
                    i2++;
                }
            }
        } else {
            i2 = u1Var.m();
        }
        q0(u1Var, i2, j2);
        C0();
    }

    private boolean s0() {
        u1 u1Var = this.k4;
        return (u1Var == null || u1Var.getPlaybackState() == 4 || this.k4.getPlaybackState() == 1 || !this.k4.E()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        u1 u1Var = this.k4;
        if (u1Var != null) {
            this.l4.a(u1Var, u1Var.c().b(f2));
        }
    }

    private void v0(boolean z, @Nullable View view) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? this.Y3 : this.Z3);
        }
    }

    private void w0() {
        u1 u1Var;
        x0 x0Var = this.l4;
        int m2 = (int) (((!(x0Var instanceof com.google.android.exoplayer2.y0) || (u1Var = this.k4) == null) ? AbstractTrafficShapingHandler.DEFAULT_MAX_TIME : ((com.google.android.exoplayer2.y0) x0Var).m(u1Var)) / 1000);
        TextView textView = this.p0;
        if (textView != null) {
            textView.setText(String.valueOf(m2));
        }
        View view = this.y;
        if (view != null) {
            view.setContentDescription(this.C4.getQuantityString(q0.exo_controls_fastforward_by_amount_description, m2, Integer.valueOf(m2)));
        }
    }

    private void x0(@Nullable ImageView imageView, boolean z) {
        if (imageView != null) {
            if (z) {
                imageView.setImageDrawable(this.g4);
                imageView.setContentDescription(this.i4);
                return;
            }
            imageView.setImageDrawable(this.h4);
            imageView.setContentDescription(this.j4);
        }
    }

    private static void y0(@Nullable View view, boolean z) {
        if (view != null) {
            if (z) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        boolean z;
        boolean z2;
        boolean z3;
        if (g0() && this.p4) {
            u1 u1Var = this.k4;
            boolean z4 = false;
            if (u1Var != null) {
                boolean s = u1Var.s(4);
                z2 = u1Var.s(6);
                z4 = u1Var.s(10) && this.l4.g();
                if (u1Var.s(11) && this.l4.k()) {
                    z4 = true;
                }
                z3 = u1Var.s(8);
                z = s;
            } else {
                z4 = false;
                z3 = false;
                z2 = false;
                z = false;
            }
            if (z4) {
                E0();
            }
            if (z4) {
                w0();
            }
            v0(z2, this.f3690f);
            v0(z4, this.z);
            v0(z4, this.y);
            v0(z3, this.q);
            y0 y0Var = this.K3;
            if (y0Var != null) {
                y0Var.setEnabled(z);
            }
        }
    }

    public void R(m mVar) {
        com.google.android.exoplayer2.util.g.e(mVar);
        this.f3689d.add(mVar);
    }

    public boolean T(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        u1 u1Var = this.k4;
        if (u1Var == null || !f0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (u1Var.getPlaybackState() == 4) {
                return true;
            }
            this.l4.f(u1Var);
            return true;
        } else if (keyCode == 89) {
            this.l4.b(u1Var);
            return true;
        } else if (keyEvent.getRepeatCount() != 0) {
            return true;
        } else {
            if (keyCode == 79 || keyCode == 85) {
                W(u1Var);
                return true;
            } else if (keyCode == 87) {
                this.l4.j(u1Var);
                return true;
            } else if (keyCode == 88) {
                this.l4.i(u1Var);
                return true;
            } else if (keyCode == 126) {
                V(u1Var);
                return true;
            } else if (keyCode != 127) {
                return true;
            } else {
                U(u1Var);
                return true;
            }
        }
    }

    public void a0() {
        this.B4.p();
    }

    public void b0() {
        this.B4.s();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return T(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean e0() {
        return this.B4.v();
    }

    public boolean g0() {
        return getVisibility() == 0;
    }

    @Nullable
    public u1 getPlayer() {
        return this.k4;
    }

    public int getRepeatToggleModes() {
        return this.v4;
    }

    public boolean getShowShuffleButton() {
        return this.B4.n(this.p3);
    }

    public boolean getShowSubtitleButton() {
        return this.B4.n(this.N4);
    }

    public int getShowTimeoutMs() {
        return this.t4;
    }

    public boolean getShowVrButton() {
        return this.B4.n(this.H3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k0() {
        Iterator<m> it = this.f3689d.iterator();
        while (it.hasNext()) {
            it.next().b(getVisibility());
        }
    }

    public void o0(m mVar) {
        this.f3689d.remove(mVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.B4.O();
        this.p4 = true;
        if (e0()) {
            this.B4.W();
        }
        u0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.B4.P();
        this.p4 = false;
        removeCallbacks(this.P3);
        this.B4.V();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.B4.Q(z, i2, i3, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p0() {
        View view = this.x;
        if (view != null) {
            view.requestFocus();
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.B4.X(z);
    }

    @Deprecated
    public void setControlDispatcher(x0 x0Var) {
        if (this.l4 != x0Var) {
            this.l4 = x0Var;
            z0();
        }
    }

    public void setOnFullScreenModeChangedListener(@Nullable d dVar) {
        this.n4 = dVar;
        boolean z = true;
        y0(this.O4, dVar != null);
        ImageView imageView = this.P4;
        if (dVar == null) {
            z = false;
        }
        y0(imageView, z);
    }

    public void setPlayer(@Nullable u1 u1Var) {
        boolean z = true;
        com.google.android.exoplayer2.util.g.g(Looper.myLooper() == Looper.getMainLooper());
        if (!(u1Var == null || u1Var.x() == Looper.getMainLooper())) {
            z = false;
        }
        com.google.android.exoplayer2.util.g.a(z);
        u1 u1Var2 = this.k4;
        if (u1Var2 != u1Var) {
            if (u1Var2 != null) {
                u1Var2.i(this.f3688c);
            }
            this.k4 = u1Var;
            if (u1Var != null) {
                u1Var.N(this.f3688c);
            }
            if (u1Var instanceof e1) {
                com.google.android.exoplayer2.trackselection.m a2 = ((e1) u1Var).a();
                if (a2 instanceof DefaultTrackSelector) {
                    this.J4 = (DefaultTrackSelector) a2;
                }
            } else {
                this.J4 = null;
            }
            u0();
        }
    }

    public void setProgressUpdateListener(@Nullable f fVar) {
        this.m4 = fVar;
    }

    public void setRepeatToggleModes(int i2) {
        this.v4 = i2;
        u1 u1Var = this.k4;
        boolean z = false;
        if (u1Var != null) {
            int repeatMode = u1Var.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.l4.e(this.k4, 0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.l4.e(this.k4, 1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.l4.e(this.k4, 2);
            }
        }
        v0 v0Var = this.B4;
        ImageView imageView = this.p2;
        if (i2 != 0) {
            z = true;
        }
        v0Var.Y(imageView, z);
        D0();
    }

    public void setShowFastForwardButton(boolean z) {
        this.B4.Y(this.y, z);
        z0();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.q4 = z;
        H0();
    }

    public void setShowNextButton(boolean z) {
        this.B4.Y(this.q, z);
        z0();
    }

    public void setShowPreviousButton(boolean z) {
        this.B4.Y(this.f3690f, z);
        z0();
    }

    public void setShowRewindButton(boolean z) {
        this.B4.Y(this.z, z);
        z0();
    }

    public void setShowShuffleButton(boolean z) {
        this.B4.Y(this.p3, z);
        G0();
    }

    public void setShowSubtitleButton(boolean z) {
        this.B4.Y(this.N4, z);
    }

    public void setShowTimeoutMs(int i2) {
        this.t4 = i2;
        if (e0()) {
            this.B4.W();
        }
    }

    public void setShowVrButton(boolean z) {
        this.B4.Y(this.H3, z);
    }

    public void setTimeBarMinUpdateInterval(int i2) {
        this.u4 = o0.p(i2, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.H3;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            v0(onClickListener != null, this.H3);
        }
    }

    public void t0() {
        this.B4.b0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u0() {
        A0();
        z0();
        D0();
        G0();
        I0();
        B0();
        H0();
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.exoplayer2.ui.StyledPlayerControlView$a, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Unknown variable types count: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StyledPlayerControlView(android.content.Context r24, @androidx.annotation.Nullable android.util.AttributeSet r25, int r26, @androidx.annotation.Nullable android.util.AttributeSet r27) {
        /*
            Method dump skipped, instructions count: 1104
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.StyledPlayerControlView.<init>(android.content.Context, android.util.AttributeSet, int, android.util.AttributeSet):void");
    }
}
