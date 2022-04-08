package com.tplink.iot.adapter.firmware;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.R;
import com.tplink.iot.Utils.x0.m;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.model.firmware.EnumIoTSeriesState;
import com.tplink.iot.model.firmware.FirmwareUpdateManager;
import com.tplink.iot.model.firmware.IotSeriesBean;
import com.tplink.iot.model.firmware.s;
import com.tplink.iot.model.firmware.t;
import com.tplink.iot.view.firmware.FirmwareSlideDetailActivity;
import com.tplink.iot.widget.ProgressBarButton;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class FirmwareMainAdapter extends RecyclerView.Adapter<b> {
    private List<IotSeriesBean> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f5609b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EnumIoTSeriesState.values().length];
            a = iArr;
            try {
                iArr[EnumIoTSeriesState.DOWNLOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EnumIoTSeriesState.INSTALLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EnumIoTSeriesState.SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[EnumIoTSeriesState.IDLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        ImageView a;

        /* renamed from: b  reason: collision with root package name */
        ProgressBarButton f5610b;

        /* renamed from: c  reason: collision with root package name */
        TextView f5611c;

        /* renamed from: d  reason: collision with root package name */
        TextView f5612d;

        /* renamed from: e  reason: collision with root package name */
        TextView f5613e;

        /* renamed from: f  reason: collision with root package name */
        TextView f5614f;
        TextView g;
        TextView h;
        TextView i;

        public b(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iot_series_avatar);
            this.f5611c = (TextView) view.findViewById(R.id.tv_iot_series_name);
            this.f5610b = (ProgressBarButton) view.findViewById(R.id.btn_update);
            this.f5612d = (TextView) view.findViewById(R.id.tv_new_version);
            this.f5613e = (TextView) view.findViewById(R.id.tv_iot_series_update_instr);
            this.f5614f = (TextView) view.findViewById(R.id.tv_iot_series_update_failed_tip);
            this.g = (TextView) view.findViewById(R.id.tv_update_battery_disallow_tip);
            this.h = (TextView) view.findViewById(R.id.tv_wait_transfer_tip);
            this.i = (TextView) view.findViewById(R.id.tv_update_transfer_failed_tip);
            this.f5610b.e();
        }
    }

    public FirmwareMainAdapter(Context context, List<IotSeriesBean> list) {
        this.f5609b = context;
        if (list != null && list.size() > 0) {
            this.a.addAll(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void n(IotSeriesBean iotSeriesBean, View view) {
        Intent intent = new Intent(this.f5609b, FirmwareSlideDetailActivity.class);
        intent.putExtra("series_key", iotSeriesBean.getId());
        this.f5609b.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void o(IotSeriesBean iotSeriesBean, int i, int i2, View view) {
        EnumIoTSeriesState currentState = iotSeriesBean.getCurrentState();
        EnumIoTSeriesState enumIoTSeriesState = EnumIoTSeriesState.IDLE;
        if (currentState == enumIoTSeriesState || (iotSeriesBean.getCurrentState() == EnumIoTSeriesState.SUCCESS && i < i2)) {
            ((FirmwareUpdateManager) b.d.b.f.b.a(b.d.s.a.a.f(), FirmwareUpdateManager.class)).m0(iotSeriesBean.getId(), iotSeriesBean.getCurrentState() != enumIoTSeriesState, true);
            m.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<IotSeriesBean> list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i;
    }

    /* renamed from: p */
    public void onBindViewHolder(@NonNull b bVar, int i) {
        String str;
        String str2;
        final IotSeriesBean iotSeriesBean = this.a.get(i);
        bVar.a.setImageResource(l.f(iotSeriesBean.getCountrySpecs(), iotSeriesBean.getModel(), s.b(iotSeriesBean)));
        bVar.f5611c.setText(iotSeriesBean.getModel());
        bVar.f5612d.setText(iotSeriesBean.getNewVersion());
        final int size = iotSeriesBean.getIoTDeviceStateList().size();
        final int successCount = iotSeriesBean.getSuccessCount();
        int i2 = size - successCount;
        String a2 = s.a(this.f5609b, iotSeriesBean, true);
        String a3 = s.a(this.f5609b, iotSeriesBean, false);
        EnumIoTSeriesState currentState = iotSeriesBean.getCurrentState();
        EnumIoTSeriesState enumIoTSeriesState = EnumIoTSeriesState.SUCCESS;
        if (currentState != enumIoTSeriesState) {
            bVar.f5613e.setTextColor(ContextCompat.getColor(this.f5609b, R.color.common_iot_dark_black));
            TextView textView = bVar.f5613e;
            if (size == 1) {
                str2 = String.format(this.f5609b.getString(R.string.firmware_series_update_text_format_2), a2);
            } else {
                str2 = String.format(this.f5609b.getString(R.string.firmware_series_update_text_format), Integer.valueOf(size), a3);
            }
            textView.setText(str2);
        } else {
            TextView textView2 = bVar.f5613e;
            String string = this.f5609b.getString(R.string.firmware_series_update_text_format);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(i2);
            if (i2 > 1) {
                a2 = a3;
            }
            objArr[1] = a2;
            textView2.setText(String.format(string, objArr));
        }
        if (iotSeriesBean.getCurrentState() != enumIoTSeriesState || i2 <= 0) {
            bVar.f5614f.setVisibility(8);
            bVar.g.setVisibility(8);
            bVar.i.setVisibility(8);
        } else {
            ArrayList<t> downloadFailedList = iotSeriesBean.getDownloadFailedList();
            int size2 = downloadFailedList.size();
            int size3 = iotSeriesBean.getBatteryDisallowList().size();
            int size4 = iotSeriesBean.getTransferFailedList().size();
            if (size2 > 0) {
                bVar.f5614f.setVisibility(0);
                if (successCount == 0 && size3 == 0 && size4 == 0) {
                    bVar.f5614f.setText(R.string.firmware_update_failed);
                } else {
                    String c2 = l.c(this.f5609b, downloadFailedList.get(0).d());
                    TextView textView3 = bVar.f5614f;
                    if (size2 == 1) {
                        str = this.f5609b.getString(R.string.update_part_failed_for1, c2);
                    } else {
                        str = this.f5609b.getString(R.string.update_part_failed, String.valueOf(i2), a3);
                    }
                    textView3.setText(str);
                }
            } else {
                bVar.f5614f.setVisibility(8);
            }
            if (size3 > 0) {
                bVar.g.setVisibility(0);
                bVar.g.setText(this.f5609b.getString(R.string.update_part_battery_disallow, Integer.valueOf(size3)));
            } else {
                bVar.g.setVisibility(8);
            }
            if (size4 > 0) {
                bVar.i.setVisibility(0);
                bVar.i.setText(this.f5609b.getString(R.string.update_part_update_failure, Integer.valueOf(size4)));
            } else {
                bVar.i.setVisibility(8);
            }
        }
        if (iotSeriesBean.getCurrentState() != enumIoTSeriesState || successCount <= 0 || iotSeriesBean.isInstallFollowDownloaded()) {
            bVar.h.setVisibility(8);
        } else {
            bVar.h.setText(this.f5609b.getString(R.string.update_part_downloaded_but_not_transferred, Integer.valueOf(successCount)));
            bVar.h.setVisibility(0);
        }
        int i3 = a.a[iotSeriesBean.getCurrentState().ordinal()];
        if (i3 == 1) {
            ProgressBarButton progressBarButton = bVar.f5610b;
            int progress = iotSeriesBean.getProgress();
            progressBarButton.f(progress, iotSeriesBean.getProgress() + "%");
        } else if (i3 == 2) {
            bVar.f5610b.d(2, this.f5609b.getString(R.string.fw_installing));
        } else if (i3 != 3) {
            bVar.f5610b.d(0, this.f5609b.getString(R.string.update));
        } else if (i2 > 0) {
            bVar.f5610b.d(0, this.f5609b.getString(R.string.update_again));
        } else if (iotSeriesBean.isInstallFollowDownloaded()) {
            bVar.f5610b.d(3, this.f5609b.getString(R.string.up_to_date));
        } else {
            bVar.f5610b.d(4, this.f5609b.getString(R.string.common_waiting));
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.firmware.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareMainAdapter.this.n(iotSeriesBean, view);
            }
        });
        bVar.f5610b.setOnClickListener(new View.OnClickListener() { // from class: com.tplink.iot.adapter.firmware.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FirmwareMainAdapter.o(IotSeriesBean.this, successCount, size, view);
            }
        });
    }

    @NonNull
    /* renamed from: q */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_firmware_slide_update, viewGroup, false));
    }

    public void r(List<IotSeriesBean> list) {
        this.a.clear();
        if (list != null && list.size() > 0) {
            this.a.addAll(list);
        }
        notifyDataSetChanged();
    }
}
