package com.tplink.iot.view.ipcamera.memories;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.ipcamera.memories.MemoriesFragment;

/* loaded from: classes2.dex */
public class MemoriesActivity extends BaseActivity implements MemoriesFragment.c {
    private FragmentManager p0;
    private Toolbar y;
    private MenuItem z;

    private void e1() {
        this.p0 = getSupportFragmentManager();
    }

    private void f1() {
        setContentView(R.layout.activity_memories);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.y = toolbar;
        toolbar.setContentInsetStartWithNavigation(0);
        this.y.setTitle(R.string.memories_title);
        setSupportActionBar(this.y);
        this.y.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.view.ipcamera.memories.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MemoriesActivity.this.i1(view);
            }
        });
    }

    private boolean g1() {
        MemoriesFragment memoriesFragment = (MemoriesFragment) this.p0.findFragmentByTag("Main.MemoriesFragment");
        if (memoriesFragment != null) {
            return memoriesFragment.T0();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1 */
    public /* synthetic */ void i1(View view) {
        onBackPressed();
    }

    private void j1() {
        MemoriesFragment memoriesFragment = (MemoriesFragment) this.p0.findFragmentByTag("Main.MemoriesFragment");
        if (memoriesFragment != null) {
            memoriesFragment.N0();
        }
    }

    private void k1() {
        MemoriesFragment memoriesFragment = (MemoriesFragment) this.p0.findFragmentByTag("Main.MemoriesFragment");
        if (memoriesFragment != null) {
            memoriesFragment.O0();
        }
        q.e();
    }

    private void l1() {
        FragmentTransaction beginTransaction = this.p0.beginTransaction();
        MemoriesFragment memoriesFragment = new MemoriesFragment();
        beginTransaction.add(R.id.main_fragment_container, memoriesFragment, "Main.MemoriesFragment");
        beginTransaction.commitAllowingStateLoss();
        Bundle bundle = new Bundle();
        bundle.putString("device_id_md5", getIntent().getStringExtra("device_id_md5"));
        memoriesFragment.setArguments(bundle);
        memoriesFragment.c1(this);
        memoriesFragment.W0();
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesFragment.c
    public void T() {
        this.y.setTitle(R.string.memories_title);
        this.y.setNavigationIcon(R.mipmap.back);
        MenuItem menuItem = this.z;
        if (menuItem != null) {
            menuItem.setIcon(R.mipmap.memory_edit);
        }
    }

    @Override // com.tplink.iot.view.ipcamera.memories.MemoriesFragment.c
    public void k(int i) {
        if (i <= 1) {
            Toolbar toolbar = this.y;
            toolbar.setTitle(getString(R.string.memory_filter_select, new Object[]{"" + i}));
        } else {
            Toolbar toolbar2 = this.y;
            toolbar2.setTitle(getString(R.string.memory_filter_selects, new Object[]{"" + i}));
        }
        this.y.setNavigationIcon(R.mipmap.close);
        MenuItem menuItem = this.z;
        if (menuItem != null) {
            menuItem.setIcon(g1() ? R.mipmap.memory_edit_selected : R.mipmap.memory_edit_unselected);
        }
    }

    @Override // com.tplink.iot.base.BaseActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MemoriesFragment memoriesFragment = (MemoriesFragment) this.p0.findFragmentByTag("Main.MemoriesFragment");
        if (memoriesFragment == null || !memoriesFragment.S0()) {
            super.onBackPressed();
        } else {
            memoriesFragment.K0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        e1();
        f1();
        l1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_memory_filter, menu);
        this.z = menu.findItem(R.id.memories_edit);
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (R.id.memories_filter == itemId) {
            k1();
            return false;
        }
        if (R.id.memories_edit == itemId) {
            j1();
        } else if (16908332 == itemId) {
            onBackPressed();
            return false;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
