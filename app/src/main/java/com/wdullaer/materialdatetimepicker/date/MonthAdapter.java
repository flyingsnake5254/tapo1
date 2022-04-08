package com.wdullaer.materialdatetimepicker.date;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.AbsListView;
import androidx.recyclerview.widget.RecyclerView;
import com.wdullaer.materialdatetimepicker.date.MonthView;
import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class MonthAdapter extends RecyclerView.Adapter<b> implements MonthView.a {
    protected final a a;

    /* renamed from: b  reason: collision with root package name */
    private a f15288b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {
        public b(MonthView monthView) {
            super(monthView);
        }

        private boolean d(a aVar, int i, int i2) {
            return aVar.f15289b == i && aVar.f15290c == i2;
        }

        void c(int i, a aVar, a aVar2) {
            int i2 = (aVar.p().get(2) + i) % 12;
            int o = ((i + aVar.p().get(2)) / 12) + aVar.o();
            ((MonthView) this.itemView).q(d(aVar2, o, i2) ? aVar2.f15291d : -1, o, i2, aVar.j());
            this.itemView.invalidate();
        }
    }

    public MonthAdapter(a aVar) {
        this.a = aVar;
        n();
        r(aVar.i());
        setHasStableIds(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        Calendar e2 = this.a.e();
        Calendar p = this.a.p();
        return (((e2.get(1) * 12) + e2.get(2)) - ((p.get(1) * 12) + p.get(2))) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // com.wdullaer.materialdatetimepicker.date.MonthView.a
    public void k(MonthView monthView, a aVar) {
        if (aVar != null) {
            q(aVar);
        }
    }

    public abstract MonthView m(Context context);

    protected void n() {
        this.f15288b = new a(System.currentTimeMillis(), this.a.m());
    }

    /* renamed from: o */
    public void onBindViewHolder(b bVar, int i) {
        bVar.c(i, this.a, this.f15288b);
    }

    /* renamed from: p */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        MonthView m = m(viewGroup.getContext());
        m.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        m.setClickable(true);
        m.setOnDayClickListener(this);
        return new b(m);
    }

    protected void q(a aVar) {
        this.a.a();
        this.a.l(aVar.f15289b, aVar.f15290c, aVar.f15291d);
        r(aVar);
    }

    public void r(a aVar) {
        this.f15288b = aVar;
        notifyDataSetChanged();
    }

    /* loaded from: classes3.dex */
    public static class a {
        private Calendar a;

        /* renamed from: b  reason: collision with root package name */
        int f15289b;

        /* renamed from: c  reason: collision with root package name */
        int f15290c;

        /* renamed from: d  reason: collision with root package name */
        int f15291d;

        /* renamed from: e  reason: collision with root package name */
        TimeZone f15292e;

        public a(TimeZone timeZone) {
            this.f15292e = timeZone;
            c(System.currentTimeMillis());
        }

        private void c(long j) {
            if (this.a == null) {
                this.a = Calendar.getInstance(this.f15292e);
            }
            this.a.setTimeInMillis(j);
            this.f15290c = this.a.get(2);
            this.f15289b = this.a.get(1);
            this.f15291d = this.a.get(5);
        }

        public void a(a aVar) {
            this.f15289b = aVar.f15289b;
            this.f15290c = aVar.f15290c;
            this.f15291d = aVar.f15291d;
        }

        public void b(int i, int i2, int i3) {
            this.f15289b = i;
            this.f15290c = i2;
            this.f15291d = i3;
        }

        public a(long j, TimeZone timeZone) {
            this.f15292e = timeZone;
            c(j);
        }

        public a(int i, int i2, int i3, TimeZone timeZone) {
            this.f15292e = timeZone;
            b(i, i2, i3);
        }
    }
}
