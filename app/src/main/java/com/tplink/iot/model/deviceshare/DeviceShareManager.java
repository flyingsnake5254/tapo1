package com.tplink.iot.model.deviceshare;

import android.text.TextUtils;
import b.d.b.f.a;
import com.tplink.cloud.bean.share.result.ShareBlacklistItemResult;
import com.tplink.cloud.context.b;
import com.tplink.libtpnetwork.TPCloudNetwork.bean.ShareBlacklistCacheBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceShareManager extends a {

    /* renamed from: c  reason: collision with root package name */
    private List<TCDeviceUserInfoBean> f8075c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<ShareBlacklistCacheBean> f8076d = new ArrayList();

    public DeviceShareManager(b bVar) {
        super(bVar);
        f();
        g();
    }

    private void f() {
        List<TCDeviceUserInfoBean> list;
        try {
            list = b.d.w.d.a.c(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "device_share_user_record_list", "device_share_user_record_list", TCDeviceUserInfoBean.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        this.f8075c.clear();
        if (!(list == null || list.isEmpty())) {
            for (TCDeviceUserInfoBean tCDeviceUserInfoBean : list) {
                if (tCDeviceUserInfoBean != null && !TextUtils.isEmpty(tCDeviceUserInfoBean.getCloudUserName())) {
                    this.f8075c.add(tCDeviceUserInfoBean);
                }
            }
        }
    }

    private void g() {
        List list;
        try {
            list = b.d.w.d.a.c(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), "device_share_blacklist_record_list", "device_share_blacklist_record_list", ShareBlacklistCacheBean.class);
        } catch (Exception unused) {
            list = new ArrayList();
        }
        this.f8076d.clear();
        if (list != null && !list.isEmpty()) {
            this.f8076d.addAll(list);
        }
    }

    public List<TCDeviceUserInfoBean> d() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10 && i < this.f8075c.size(); i++) {
            TCDeviceUserInfoBean tCDeviceUserInfoBean = this.f8075c.get(i);
            if (tCDeviceUserInfoBean != null && !TextUtils.isEmpty(tCDeviceUserInfoBean.getCloudUserName())) {
                arrayList.add(tCDeviceUserInfoBean);
            }
        }
        return arrayList;
    }

    public List<ShareBlacklistCacheBean> e() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 10 && i < this.f8076d.size(); i++) {
            arrayList.add(this.f8076d.get(i));
        }
        return arrayList;
    }

    public void h(TCDeviceUserInfoBean tCDeviceUserInfoBean) {
        if (!(tCDeviceUserInfoBean == null || TextUtils.isEmpty(tCDeviceUserInfoBean.getCloudUserName()))) {
            Iterator<TCDeviceUserInfoBean> it = this.f8075c.iterator();
            while (it.hasNext()) {
                TCDeviceUserInfoBean next = it.next();
                if (TextUtils.equals(next.getCloudUserName(), tCDeviceUserInfoBean.getCloudUserName())) {
                    if (TextUtils.isEmpty(tCDeviceUserInfoBean.getAvatarUrl())) {
                        tCDeviceUserInfoBean.setAvatarUrl(next.getAvatarUrl());
                        tCDeviceUserInfoBean.setNickname(next.getNickname());
                    }
                    it.remove();
                }
            }
            this.f8075c.add(0, tCDeviceUserInfoBean);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10 && i < this.f8075c.size(); i++) {
                arrayList.add(this.f8075c.get(i));
            }
            b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), arrayList, "device_share_user_record_list", "device_share_user_record_list");
        }
    }

    public void i(List<ShareBlacklistCacheBean> list) {
        if (!(list == null || list.isEmpty())) {
            this.f8076d.clear();
            this.f8076d.addAll(list);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 10 && i < this.f8076d.size(); i++) {
                arrayList.add(this.f8076d.get(i));
            }
            b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), arrayList, "device_share_blacklist_record_list", "device_share_blacklist_record_list");
        }
    }

    public void j(List<ShareBlacklistItemResult> list) {
        if (!(list == null || list.isEmpty() || this.f8076d.isEmpty())) {
            boolean z = false;
            for (ShareBlacklistCacheBean shareBlacklistCacheBean : this.f8076d) {
                Iterator<ShareBlacklistItemResult> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        ShareBlacklistItemResult next = it.next();
                        if (TextUtils.isEmpty(shareBlacklistCacheBean.getAvatarUrl()) && TextUtils.equals(shareBlacklistCacheBean.getEmail(), next.getEmail())) {
                            shareBlacklistCacheBean.setAvatarUrl(next.getAvatarUrl());
                            shareBlacklistCacheBean.setNickname(next.getNickname());
                            z = true;
                            break;
                        }
                    }
                }
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 10 && i < this.f8076d.size(); i++) {
                    arrayList.add(this.f8076d.get(i));
                }
                b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), arrayList, "device_share_blacklist_record_list", "device_share_blacklist_record_list");
            }
        }
    }

    public void k(List<TCDeviceUserInfoBean> list) {
        if (!(list == null || list.isEmpty() || this.f8075c.isEmpty())) {
            boolean z = false;
            for (int i = 0; i < this.f8075c.size(); i++) {
                TCDeviceUserInfoBean tCDeviceUserInfoBean = this.f8075c.get(i);
                if (TextUtils.isEmpty(tCDeviceUserInfoBean.getAvatarUrl())) {
                    Iterator<TCDeviceUserInfoBean> it = list.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            TCDeviceUserInfoBean next = it.next();
                            if (TextUtils.equals(tCDeviceUserInfoBean.getCloudUserName(), next.getCloudUserName())) {
                                tCDeviceUserInfoBean.setAvatarUrl(next.getAvatarUrl());
                                tCDeviceUserInfoBean.setNickname(next.getNickname());
                                z = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < 10 && i2 < this.f8075c.size(); i2++) {
                    arrayList.add(this.f8075c.get(i2));
                }
                b.d.w.d.a.l(b.d.w.h.a.g(this.f100b.c().getCloudUserName()), arrayList, "device_share_user_record_list", "device_share_user_record_list");
            }
        }
    }
}
