package com.tplink.iot.view.ipcamera.preview;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.MediatorLiveData;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.adapter.databinding.DataBindingListAdapter;
import com.tplink.iot.adapter.databinding.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.cameranetwork.bean.ALCameraDevice;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.r;
import kotlin.jvm.internal.j;

/* compiled from: CameraPreviewSortActivity.kt */
/* loaded from: classes2.dex */
public final class CameraPreviewSortActivity extends BaseActivity {
    public static final a p0 = new a(null);
    private static final String y = "CameraSort";
    private static final String z = "Order";
    private final ArrayList<String> H3 = new ArrayList<>();
    private final ArrayList<String> I3 = new ArrayList<>();
    private final ArrayList<String> J3 = new ArrayList<>();
    private final f K3 = new c();
    private final ItemTouchHelper L3 = new ItemTouchHelper(new ItemTouchHelper.Callback() { // from class: com.tplink.iot.view.ipcamera.preview.CameraPreviewSortActivity.1
        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            j.e(recyclerView, "recyclerView");
            j.e(viewHolder, "viewHolder");
            return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            j.e(recyclerView, "recyclerView");
            j.e(viewHolder, "viewHolder");
            j.e(target, "target");
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            ArrayList[] arrayListArr = {CameraPreviewSortActivity.this.H3, CameraPreviewSortActivity.this.I3, CameraPreviewSortActivity.this.J3};
            for (int i = 0; i < 3; i++) {
                ArrayList arrayList = arrayListArr[i];
                Object obj = arrayList.get(adapterPosition);
                j.d(obj, "array[fromPosition]");
                arrayList.remove(adapterPosition);
                arrayList.add(adapterPosition2, (String) obj);
            }
            CameraPreviewSortActivity.f1(CameraPreviewSortActivity.this).s();
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
            j.e(viewHolder, "viewHolder");
        }
    });
    private HashMap M3;
    private TPIoTClientManager p1;
    private b.d.w.g.a p2;
    private DataBindingListAdapter p3;

    /* compiled from: CameraPreviewSortActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public final String a() {
            return CameraPreviewSortActivity.y;
        }

        public final String b() {
            return CameraPreviewSortActivity.z;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class b<T> implements Comparator<T> {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f9054d;

        public b(ArrayList arrayList) {
            this.f9054d = arrayList;
        }

        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            ALCameraDevice device = (ALCameraDevice) t;
            ArrayList arrayList = this.f9054d;
            j.d(device, "device");
            int indexOf = arrayList.indexOf(device.getDeviceIdMD5());
            if (indexOf == -1) {
                indexOf = this.f9054d.size();
            }
            Integer valueOf = Integer.valueOf(indexOf);
            ALCameraDevice device2 = (ALCameraDevice) t2;
            ArrayList arrayList2 = this.f9054d;
            j.d(device2, "device");
            int indexOf2 = arrayList2.indexOf(device2.getDeviceIdMD5());
            if (indexOf2 == -1) {
                indexOf2 = this.f9054d.size();
            }
            a = kotlin.q.b.a(valueOf, Integer.valueOf(indexOf2));
            return a;
        }
    }

    /* compiled from: CameraPreviewSortActivity.kt */
    /* loaded from: classes2.dex */
    static final class c implements f {
        c() {
        }

        @Override // com.tplink.iot.adapter.databinding.f
        public final boolean a(View view, MotionEvent event, RecyclerView.ViewHolder viewHolder) {
            j.d(event, "event");
            if (event.getAction() != 0) {
                return false;
            }
            CameraPreviewSortActivity.this.L3.startDrag(viewHolder);
            return false;
        }
    }

    public CameraPreviewSortActivity() {
        b.d.b.f.a a2 = b.d.b.f.b.a(b.d.s.a.a.f(), TPIoTClientManager.class);
        j.d(a2, "CloudRepositoryProviders…lientManager::class.java)");
        this.p1 = (TPIoTClientManager) a2;
    }

    public static final /* synthetic */ DataBindingListAdapter f1(CameraPreviewSortActivity cameraPreviewSortActivity) {
        DataBindingListAdapter dataBindingListAdapter = cameraPreviewSortActivity.p3;
        if (dataBindingListAdapter == null) {
            j.t("adapter");
        }
        return dataBindingListAdapter;
    }

    private final void m1() {
        ArrayList arrayList;
        String str;
        b.d.w.g.a aVar = new b.d.w.g.a(this, y);
        this.p2 = aVar;
        String string = aVar.f(z, "");
        j.d(string, "string");
        if (string.length() == 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = (ArrayList) JsonUtils.a(string, ArrayList.class);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
        }
        MediatorLiveData<List<ALCameraDevice>> M1 = this.p1.M1();
        j.d(M1, "tpCameraClientManager.cameraDeviceListData");
        List<ALCameraDevice> it = M1.getValue();
        if (it != null) {
            j.d(it, "it");
            if (it.size() > 1) {
                r.o(it, new b(arrayList));
            }
            for (ALCameraDevice cameraDevice : it) {
                ArrayList<String> arrayList2 = this.J3;
                j.d(cameraDevice, "cameraDevice");
                arrayList2.add(cameraDevice.getDeviceIdMD5());
                this.H3.add(cameraDevice.getDeviceAlias());
                ArrayList<String> arrayList3 = this.I3;
                CameraAvatarInfo cameraAvatarInfo = cameraDevice.getCameraAvatarInfo();
                if (cameraAvatarInfo == null || (str = cameraAvatarInfo.getAvatarName()) == null) {
                    str = "";
                }
                arrayList3.add(str);
            }
        }
        this.p3 = new DataBindingListAdapter(R.layout.item_camera_preview_sort, new int[]{com.tplink.iot.adapter.databinding.a.f5443b, com.tplink.iot.adapter.databinding.a.f5445d, com.tplink.iot.adapter.databinding.a.f5446e, com.tplink.iot.adapter.databinding.a.g}, new int[]{com.tplink.iot.adapter.databinding.a.f5443b}, this.J3, this.H3, this.I3, this.K3);
    }

    private final void n1() {
        setContentView(R.layout.activity_camera_preview_sort);
        a1(R.mipmap.close);
        int i = com.tplink.iot.a.recyclerView;
        RecyclerView recyclerView = (RecyclerView) e1(i);
        j.d(recyclerView, "recyclerView");
        DataBindingListAdapter dataBindingListAdapter = this.p3;
        if (dataBindingListAdapter == null) {
            j.t("adapter");
        }
        recyclerView.setAdapter(dataBindingListAdapter);
        this.L3.attachToRecyclerView((RecyclerView) e1(i));
    }

    public View e1(int i) {
        if (this.M3 == null) {
            this.M3 = new HashMap();
        }
        View view = (View) this.M3.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.M3.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.iot.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m1();
        n1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.common_done, menu);
        return true;
    }

    @Override // com.tplink.iot.base.BaseActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        j.e(item, "item");
        if (item.getItemId() == R.id.common_done) {
            String g = JsonUtils.g(this.J3);
            b.d.w.g.a aVar = this.p2;
            if (aVar == null) {
                j.t("sp");
            }
            String str = z;
            aVar.k(str, g);
            setResult(-1, new Intent().putExtra(str, this.J3));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
