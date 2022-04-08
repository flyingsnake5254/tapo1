package com.tplink.iot.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.tplink.iot.R;
import java.util.List;

/* compiled from: TPPopupMenu.java */
/* loaded from: classes2.dex */
public class l0 extends PopupWindow {
    private Activity a;

    /* renamed from: b  reason: collision with root package name */
    private View f5339b;

    /* renamed from: c  reason: collision with root package name */
    private ListView f5340c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f5341d;

    /* renamed from: e  reason: collision with root package name */
    private int f5342e;

    /* renamed from: f  reason: collision with root package name */
    private d f5343f;
    private int g = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPPopupMenu.java */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (l0.this.f5343f != null) {
                l0.this.f5343f.a(view, 0);
            }
            l0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TPPopupMenu.java */
    /* loaded from: classes2.dex */
    public class b implements AdapterView.OnItemClickListener {
        b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            l0.this.dismiss();
            if (l0.this.f5343f != null) {
                l0.this.f5343f.a(view, (int) j);
            }
            l0.this.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TPPopupMenu.java */
    /* loaded from: classes2.dex */
    public class c extends BaseAdapter {

        /* renamed from: c  reason: collision with root package name */
        private List<String> f5346c;

        /* renamed from: d  reason: collision with root package name */
        private Context f5347d;

        /* compiled from: TPPopupMenu.java */
        /* loaded from: classes2.dex */
        protected class a {
            TextView a;

            protected a() {
            }
        }

        public c(List<String> list, Context context) {
            this.f5346c = list;
            this.f5347d = context;
        }

        /* renamed from: a */
        public String getItem(int i) {
            return this.f5346c.get(i);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> list = this.f5346c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = LayoutInflater.from(this.f5347d).inflate(R.layout.pop_menu_item_layout, (ViewGroup) null);
                aVar = new a();
                aVar.a = (TextView) view.findViewById(R.id.title);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            String str = this.f5346c.get(i);
            if (!TextUtils.isEmpty(str)) {
                aVar.a.setText(str);
            }
            return view;
        }
    }

    /* compiled from: TPPopupMenu.java */
    /* loaded from: classes2.dex */
    public interface d {
        void a(View view, int i);
    }

    public l0(Activity activity, List<String> list) {
        super(activity);
        this.a = activity;
        d(activity, list);
        h(activity);
    }

    private int[] b(View view, View view2) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int height = view.getHeight();
        int i = this.a.getResources().getDisplayMetrics().heightPixels;
        int i2 = this.a.getResources().getDisplayMetrics().widthPixels;
        view2.measure(0, 0);
        int measuredHeight = view2.getMeasuredHeight();
        int measuredWidth = view2.getMeasuredWidth();
        int height2 = (i - iArr2[1]) - view.getHeight();
        boolean z = (i - iArr2[1]) - height < measuredHeight;
        if ((i2 - iArr2[0]) - view.getWidth() <= iArr2[0]) {
            iArr[0] = (i2 - measuredWidth) - ((i2 - iArr2[0]) - view.getWidth());
        } else {
            iArr[0] = iArr2[0];
        }
        if (z) {
            iArr[1] = (iArr2[1] - measuredHeight) - height2;
        } else {
            iArr[1] = iArr2[1] + height;
        }
        return iArr;
    }

    private void d(Activity activity, List<String> list) {
        LayoutInflater layoutInflater = (LayoutInflater) activity.getSystemService("layout_inflater");
        if (list != null && list.size() == 1) {
            View inflate = layoutInflater.inflate(R.layout.pop_menu_item_layout, (ViewGroup) null);
            this.f5339b = inflate;
            TextView textView = (TextView) inflate.findViewById(R.id.title);
            this.f5341d = textView;
            textView.setText(list.get(0));
            this.g = 1;
            this.f5341d.measure(0, 0);
            this.f5342e = this.f5341d.getMeasuredWidth();
        } else if (list != null && list.size() > 1) {
            View inflate2 = layoutInflater.inflate(R.layout.pop_view_layout, (ViewGroup) null);
            this.f5339b = inflate2;
            ListView listView = (ListView) inflate2.findViewById(R.id.popview_list);
            this.f5340c = listView;
            listView.setAdapter((ListAdapter) new c(list, activity));
            this.g = 2;
            this.f5342e = e(activity, list);
        }
    }

    private int e(Context context, List<String> list) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_menu_item, (ViewGroup) null);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextView textView = (TextView) inflate.findViewById(R.id.title);
        int i = 0;
        if (textView != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                textView.setText(list.get(i3));
                inflate.measure(0, 0);
                if (i2 < inflate.getMeasuredWidth()) {
                    i2 = inflate.getMeasuredWidth();
                }
            }
            i = i2;
        }
        return i < c(context, 176.0f) ? c(context, 176.0f) : i;
    }

    private void h(Activity activity) {
        if (this.g != 0) {
            setContentView(this.f5339b);
            setWidth(this.f5342e);
            setHeight(-2);
            setFocusable(true);
            setTouchable(true);
            setOutsideTouchable(true);
            Drawable drawable = activity.getResources().getDrawable(R.drawable.popup_menu_normal_bg);
            if (Build.VERSION.SDK_INT >= 21) {
                setBackgroundDrawable(new ColorDrawable(-1));
                setElevation(c(activity, 3.0f));
            } else {
                setBackgroundDrawable(drawable);
            }
            setAnimationStyle(R.style.popupAnim);
            int i = this.g;
            if (i == 1) {
                this.f5341d.setOnClickListener(new a());
            } else if (i == 2) {
                this.f5340c.setOnItemClickListener(new b());
            }
        }
    }

    public int c(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void f(d dVar) {
        this.f5343f = dVar;
    }

    public void g(int i) {
        TextView textView = this.f5341d;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void i(View view) {
        if (this.a != null && view != null && this.f5339b != null) {
            view.getLocationInWindow(new int[]{0, 0});
            b.d.w.f.a.a(this.a, 176.0f);
            view.getWidth();
            int[] b2 = b(view, this.f5339b);
            showAtLocation(view, BadgeDrawable.TOP_START, b2[0], b2[1]);
        }
    }
}
