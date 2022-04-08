package com.tplink.iot.view.home.nextevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.home.NextEventListAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingNextEvent;
import com.tplink.iot.viewmodel.home.nextevent.NextEventViewModel;
import java.util.List;

/* loaded from: classes2.dex */
public class NextEventListActivity extends BaseActivity {
    private String p0 = null;
    private NextEventListAdapter y;
    private NextEventViewModel z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Observer<List<ThingNextEvent>> {
        a() {
        }

        /* renamed from: a */
        public void onChanged(@Nullable List<ThingNextEvent> list) {
            NextEventListActivity.this.y.p(list);
        }
    }

    private void f1() {
        if (getIntent() != null) {
            this.p0 = getIntent().getStringExtra("family_id");
            b.d.w.c.a.e("family_id", this.p0 + "");
        }
    }

    public static void g1(Context context, String str) {
        Intent intent = new Intent(context, NextEventListActivity.class);
        intent.putExtra("family_id", str);
        context.startActivity(intent);
    }

    private void h1() {
        this.z.m().observe(this, new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_next_event_list);
        this.z = (NextEventViewModel) ViewModelProviders.of(this).get(NextEventViewModel.class);
        b1(R.string.plug_next_event);
        f1();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        NextEventListAdapter nextEventListAdapter = new NextEventListAdapter(this);
        this.y = nextEventListAdapter;
        recyclerView.setAdapter(nextEventListAdapter);
        h1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.z.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.z.l(this.p0);
    }
}
