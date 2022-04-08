package com.tplink.iot.adapter.deviceshare;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tplink.iot.R;
import com.tplink.iot.Utils.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: DeviceShareAutoCompleteAdapter.java */
/* loaded from: classes2.dex */
public class a extends BaseAdapter implements Filterable {

    /* renamed from: c  reason: collision with root package name */
    private b f5522c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, RecordUserBean> f5523d;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f5524f;
    private List<RecordUserBean> q = new ArrayList();
    private String x;
    private Context y;

    /* compiled from: DeviceShareAutoCompleteAdapter.java */
    /* loaded from: classes2.dex */
    private class b extends Filter {
        private b() {
        }

        @Override // android.widget.Filter
        protected Filter.FilterResults performFiltering(CharSequence charSequence) {
            Filter.FilterResults filterResults = new Filter.FilterResults();
            if (charSequence == null || charSequence.length() == 0) {
                a.this.x = "";
                filterResults.values = new ArrayList();
                filterResults.count = 0;
            } else {
                a.this.x = charSequence.toString();
                String charSequence2 = charSequence.toString();
                ArrayList arrayList = new ArrayList();
                int indexOf = charSequence2.indexOf("@");
                if (indexOf == -1) {
                    for (Map.Entry entry : a.this.f5523d.entrySet()) {
                        if (((String) entry.getKey()).contains(charSequence2)) {
                            arrayList.add(entry.getValue());
                        }
                    }
                } else if (indexOf != 0) {
                    int size = a.this.f5524f.size();
                    for (int i = 0; i < size; i++) {
                        String str = (String) a.this.f5524f.get(i);
                        if (str != null) {
                            String substring = charSequence2.substring(0, indexOf);
                            String substring2 = charSequence2.substring(indexOf);
                            if (!str.equals(substring2) && str.startsWith(substring2)) {
                                arrayList.add(new RecordUserBean(substring + str));
                            }
                        }
                    }
                }
                filterResults.values = arrayList;
                filterResults.count = arrayList.size();
            }
            return filterResults;
        }

        @Override // android.widget.Filter
        protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
            a.this.q = (List) filterResults.values;
            if (filterResults.count > 0) {
                a.this.notifyDataSetChanged();
            } else {
                a.this.notifyDataSetInvalidated();
            }
        }
    }

    /* compiled from: DeviceShareAutoCompleteAdapter.java */
    /* loaded from: classes2.dex */
    static class c {
        public TextView a;

        c() {
        }
    }

    public a(Context context, List<RecordUserBean> list, List<String> list2) {
        this.f5524f = new ArrayList();
        this.f5523d = f(list);
        if (list2 != null) {
            this.f5524f = new ArrayList(list2);
        }
        this.y = context;
    }

    private String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("@");
        return indexOf == -1 ? str : indexOf == 0 ? "" : str.substring(0, indexOf);
    }

    private HashMap<String, RecordUserBean> f(List<RecordUserBean> list) {
        HashMap<String, RecordUserBean> hashMap = new HashMap<>();
        for (RecordUserBean recordUserBean : list) {
            String e2 = e(recordUserBean.getCloudUserName());
            if (!TextUtils.isEmpty(e2)) {
                hashMap.put(e2, recordUserBean);
            }
        }
        return hashMap;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<RecordUserBean> list = this.q;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f5522c == null) {
            this.f5522c = new b();
        }
        return this.f5522c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.q.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        c cVar;
        if (view == null) {
            cVar = new c();
            view2 = LayoutInflater.from(this.y).inflate(R.layout.layout_device_share_complete_adapter, (ViewGroup) null);
            cVar.a = (TextView) view2.findViewById(R.id.text1);
            view2.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
            view2 = view;
        }
        if (TextUtils.isEmpty(this.x)) {
            cVar.a.setText(this.q.get(i).getCloudUserName());
        } else {
            d0.a(cVar.a, this.q.get(i).getCloudUserName(), this.x, ContextCompat.getColor(this.y, R.color.common_iot_main_blue));
        }
        return view2;
    }
}
