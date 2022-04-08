package com.tplink.iot.Utils.z0;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.R;
import com.tplink.iot.cloud.bean.group.common.GroupInfo;
import com.tplink.iot.view.group.detail.GroupDetailColorBulbActivity;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.bean.group.GroupBean;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.FamilyManagerRepository;
import com.tplink.libtpnetwork.enumerate.EnumBulbAvatarType;
import java.util.List;

/* compiled from: GroupUtils.java */
/* loaded from: classes2.dex */
public class o {
    public static String a(GroupInfo groupInfo) {
        return groupInfo == null ? "" : c(groupInfo.getFamilyId(), groupInfo.getRoomId());
    }

    public static String b(GroupBean groupBean) {
        return groupBean == null ? "" : c(groupBean.getFamilyId(), groupBean.getRoomId());
    }

    private static String c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String f0 = ((FamilyManagerRepository) b.a(a.f(), FamilyManagerRepository.class)).f0(str, str2);
        return TextUtils.isEmpty(f0) ? "" : f0;
    }

    public static String d(Context context, String str) {
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getString(R.string.group);
    }

    public static void e(Activity activity, GroupInfo groupInfo) {
        List<String> thingNames = groupInfo.getThingNames();
        if (thingNames != null && !thingNames.isEmpty()) {
            GroupDetailColorBulbActivity.z1(activity, groupInfo.getId());
        }
    }

    public static boolean f(GroupInfo groupInfo) {
        List<String> thingNames;
        if (groupInfo == null || (thingNames = groupInfo.getThingNames()) == null || thingNames.isEmpty()) {
            return false;
        }
        TPIoTClientManager tPIoTClientManager = (TPIoTClientManager) b.a(a.f(), TPIoTClientManager.class);
        for (String str : thingNames) {
            BaseALIoTDevice Z1 = tPIoTClientManager.Z1(b.d.w.h.a.g(str));
            if (Z1 instanceof ALIoTDevice) {
                ALIoTDevice aLIoTDevice = (ALIoTDevice) Z1;
                if (aLIoTDevice.isBulb() && !aLIoTDevice.isSupportColorAndColorTemp()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void g(GroupInfo groupInfo, ImageView imageView) {
        i(groupInfo, imageView);
    }

    public static void h(GroupBean groupBean, ImageView imageView) {
        if (groupBean == null) {
            i(null, imageView);
        } else {
            i(groupBean.getGroupInfo(), imageView);
        }
    }

    private static void i(GroupInfo groupInfo, ImageView imageView) {
        imageView.setImageResource(g.c(groupInfo != null ? EnumBulbAvatarType.fromString(groupInfo.getAvatarUrl()) : null));
    }

    public static void j(GroupInfo groupInfo, ImageView imageView) {
        k(groupInfo, imageView);
    }

    private static void k(GroupInfo groupInfo, ImageView imageView) {
        imageView.setImageResource(g.d(groupInfo != null ? EnumBulbAvatarType.fromString(groupInfo.getAvatarUrl()) : null));
    }
}
