package com.tplink.iot.widget;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import java.util.List;

/* loaded from: classes3.dex */
public class ListContentLongDialog extends AlertDialog {
    private int H3;
    private e I3;
    private d J3;

    /* renamed from: c  reason: collision with root package name */
    private TextView f11568c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f11569d;

    /* renamed from: f  reason: collision with root package name */
    private TextView f11570f;
    private CharSequence p0;
    private int p1;
    private CharSequence p2;
    private int p3;
    private TextView q;
    private List<String> x = null;
    private CharSequence y;
    private CharSequence z;

    /* loaded from: classes3.dex */
    public static class Builder extends AlertDialog.Builder {
        private ListContentLongDialog a;

        public Builder(@NonNull Context context) {
            super(context);
            this.a = null;
            this.a = new ListContentLongDialog(context);
        }

        /* renamed from: a */
        public ListContentLongDialog create() {
            return this.a;
        }

        public Builder b(CharSequence charSequence) {
            return c(charSequence, 0);
        }

        public Builder c(CharSequence charSequence, int i) {
            this.a.p2 = charSequence;
            if (i > 0) {
                this.a.p3 = i;
            }
            return this;
        }

        public Builder d(List<?> list) {
            try {
                this.a.x = list;
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                b.d.w.c.a.c(getClass().getSimpleName(), "data list must be a string vector");
            }
            return this;
        }

        public Builder e(@Nullable CharSequence charSequence) {
            this.a.z = charSequence;
            return this;
        }

        public Builder f(e eVar) {
            this.a.I3 = eVar;
            return this;
        }

        public Builder g(@Nullable CharSequence charSequence) {
            this.a.p0 = charSequence;
            return this;
        }

        /* renamed from: h */
        public Builder setTitle(@Nullable CharSequence charSequence) {
            this.a.y = charSequence;
            return this;
        }
    }

    /* loaded from: classes3.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ListContentLongDialog.this.dismiss();
            if (ListContentLongDialog.this.I3 != null) {
                ListContentLongDialog.this.I3.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ListContentLongDialog.this.dismiss();
            if (ListContentLongDialog.this.J3 != null) {
                ListContentLongDialog.this.J3.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    private class c extends RecyclerView.Adapter {

        /* loaded from: classes3.dex */
        class a extends RecyclerView.ViewHolder {
            public DialogPointTextView a;

            public a(View view) {
                super(view);
                this.a = (DialogPointTextView) view.findViewById(R.id.item_text);
            }
        }

        private c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (ListContentLongDialog.this.x == null) {
                return 0;
            }
            return ListContentLongDialog.this.x.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            a aVar = (a) viewHolder;
            if (i >= 0 && i < ListContentLongDialog.this.x.size()) {
                aVar.a.setContent((String) ListContentLongDialog.this.x.get(i));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new a(LayoutInflater.from(ListContentLongDialog.this.getContext()).inflate(R.layout.layout_list_content_item, viewGroup, false));
        }

        /* synthetic */ c(ListContentLongDialog listContentLongDialog, a aVar) {
            this();
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void dismiss();
    }

    /* loaded from: classes3.dex */
    public interface e {
        void dismiss();
    }

    protected ListContentLongDialog(@NonNull Context context) {
        super(context, R.style.TPDialog);
        l(context);
    }

    public static int k(Context context, float f2) {
        return Math.round(TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics()));
    }

    private void l(Context context) {
        this.p1 = -1;
        this.p3 = -1;
        this.H3 = k(context, 184.0f);
    }

    private void m(ListContentLongDialog listContentLongDialog) {
        if (!TextUtils.isEmpty(this.y)) {
            listContentLongDialog.f11568c.setVisibility(0);
            listContentLongDialog.f11568c.setText(this.y);
            int i = this.p1;
            if (i > 0) {
                listContentLongDialog.f11568c.setTextColor(i);
            }
        } else {
            listContentLongDialog.f11568c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.p2)) {
            listContentLongDialog.f11569d.setVisibility(0);
            listContentLongDialog.f11569d.setText(this.p2);
            int i2 = this.p3;
            if (i2 > 0) {
                listContentLongDialog.f11569d.setTextColor(i2);
            }
        } else {
            listContentLongDialog.f11569d.setVisibility(8);
        }
        listContentLongDialog.q.setText(this.z);
        listContentLongDialog.f11570f.setText(this.p0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AlertDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_content_list_long_dialog);
        this.f11568c = (TextView) findViewById(R.id.title);
        this.f11569d = (TextView) findViewById(R.id.content);
        this.q = (TextView) findViewById(R.id.cancel);
        this.f11570f = (TextView) findViewById(R.id.ok);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        c cVar = new c(this, null);
        recyclerView.setAdapter(cVar);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        this.f11570f.setOnClickListener(new a());
        this.q.setOnClickListener(new b());
        int i = 0;
        for (int i2 = 0; i2 < cVar.getItemCount(); i2++) {
            i += k(getContext(), 40.0f);
        }
        if (i > this.H3) {
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            layoutParams.height = this.H3;
            recyclerView.setLayoutParams(layoutParams);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        m(this);
    }
}
