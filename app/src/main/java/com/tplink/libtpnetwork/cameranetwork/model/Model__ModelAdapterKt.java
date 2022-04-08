package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.i;
import com.google.gson.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import kotlin.collections.d0;
import kotlin.collections.l;
import kotlin.collections.o;
import kotlin.jvm.internal.j;
import kotlin.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModelAdapter.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class Model__ModelAdapterKt {
    public static final <T> List<T> extractFromMapList(List<? extends Map<String, ? extends T>> extractFromMapList) {
        int l;
        j.e(extractFromMapList, "$this$extractFromMapList");
        l = o.l(extractFromMapList, 10);
        ArrayList arrayList = new ArrayList(l);
        Iterator<T> it = extractFromMapList.iterator();
        while (it.hasNext()) {
            arrayList.add(l.w(((Map) it.next()).values()));
        }
        return arrayList;
    }

    public static final <T> List<T> extractMapList(List<? extends Map<String, ? extends T>> list) {
        if (list != null) {
            return Model.extractFromMapList(list);
        }
        return null;
    }

    public static final AESEncryptKey getAESEncryptKeyFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                return (AESEncryptKey) TypeDispatcher.INSTANCE.fromJson((i) wrapper.getData(), AESEncryptKey.class);
            }
        }
        return null;
    }

    public static final DiagnoseStatus getDiagnoseStateFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                return (DiagnoseStatus) TypeDispatcher.INSTANCE.fromJson((i) wrapper.getData(), DiagnoseStatus.class);
            }
        }
        return null;
    }

    public static final MarkPositionConfirmInfo getMarkPositionConfirmInfoFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                TypeDispatcher typeDispatcher = TypeDispatcher.INSTANCE;
                Object data = wrapper.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.google.gson.JsonElement");
                return (MarkPositionConfirmInfo) typeDispatcher.fromJson((i) data, MarkPositionConfirmInfo.class);
            }
        }
        return null;
    }

    public static final NetworkInfo getNetworkInfoFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                TypeDispatcher typeDispatcher = TypeDispatcher.INSTANCE;
                Object data = wrapper.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.google.gson.JsonElement");
                return (NetworkInfo) typeDispatcher.fromJson((i) data, NetworkInfo.class);
            }
        }
        return null;
    }

    public static final P2PSharePwd getP2PSharePasswordFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                return (P2PSharePwd) TypeDispatcher.INSTANCE.fromJson((i) wrapper.getData(), P2PSharePwd.class);
            }
        }
        return null;
    }

    public static final ResetSupportInfo getResetSupportInfoFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                TypeDispatcher typeDispatcher = TypeDispatcher.INSTANCE;
                Object data = wrapper.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.google.gson.JsonElement");
                return (ResetSupportInfo) typeDispatcher.fromJson((i) data, ResetSupportInfo.class);
            }
        }
        return null;
    }

    public static final SdCardFormatProgress getSdCardFormatProgressFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof k) {
                TypeDispatcher typeDispatcher = TypeDispatcher.INSTANCE;
                Object data = wrapper.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.google.gson.JsonElement");
                return (SdCardFormatProgress) typeDispatcher.fromJson((i) data, SdCardFormatProgress.class);
            }
        }
        return null;
    }

    public static final StartUpdateFirmwareInfo getStartFirmUpdateInfoFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                TypeDispatcher typeDispatcher = TypeDispatcher.INSTANCE;
                Object data = wrapper.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.google.gson.JsonElement");
                return (StartUpdateFirmwareInfo) typeDispatcher.fromJson((i) data, StartUpdateFirmwareInfo.class);
            }
        }
        return null;
    }

    public static final VodUserId getVodUserIdFromWrapper(Wrappers wrappers) {
        j.e(wrappers, "wrappers");
        for (Wrapper<?> wrapper : wrappers.getWrapperList()) {
            if (wrapper.getData() instanceof i) {
                TypeDispatcher typeDispatcher = TypeDispatcher.INSTANCE;
                Object data = wrapper.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type com.google.gson.JsonElement");
                return (VodUserId) typeDispatcher.fromJson((i) data, VodUserId.class);
            }
        }
        return null;
    }

    public static final List<ComponentBean> toComponentList(Wrappers toComponentList) {
        j.e(toComponentList, "$this$toComponentList");
        ArrayList arrayList = new ArrayList();
        CameraComponent cameraComponent = (CameraComponent) Model.typeCast(toComponentList, Module.APP_COMPONENT, Section.APP_COMPONENT_LIST);
        if (cameraComponent != null) {
            arrayList.addAll(cameraComponent.getComponentList());
        }
        return arrayList;
    }

    public static final List<OsdElement> toOsdList(Wrappers toOsdList) {
        int l;
        j.e(toOsdList, "$this$toOsdList");
        ArrayList arrayList = new ArrayList();
        List<Map> list = (List) Model.typeCast(toOsdList, Module.OSD, Section.OSD_LABEL_INFO);
        if (list != null) {
            l = o.l(list, 10);
            ArrayList arrayList2 = new ArrayList(l);
            for (Map map : list) {
                arrayList2.add((OsdElement) l.w(map.values()));
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public static final List<Wifi> toWifiList(Wrappers toWifiList) {
        j.e(toWifiList, "$this$toWifiList");
        ArrayList arrayList = new ArrayList();
        WifiList wifiList = (WifiList) Model.typeCast(toWifiList, Module.ON_BOARDING, Section.SCAN);
        if (wifiList != null) {
            arrayList.addAll(wifiList.getWifiList());
        }
        return arrayList;
    }

    public static final <R> R typeCast(Wrappers typeCast, Class<R> clz) {
        j.e(typeCast, "$this$typeCast");
        j.e(clz, "clz");
        for (Wrapper<?> wrapper : typeCast.getWrapperList()) {
            if (j.a(TypeDispatcher.INSTANCE.getRawType(wrapper.getModule(), wrapper.getSection()), clz)) {
                R r = (R) wrapper.getData();
                if (!(r instanceof Object)) {
                    return null;
                }
                return r;
            }
        }
        return null;
    }

    public static final <R> Response<R> unwrap(Response<Wrappers> unwrap, Class<R> clz) {
        j.e(unwrap, "$this$unwrap");
        j.e(clz, "clz");
        return unwrap.repack(Model.typeCast(unwrap.getResult(), clz));
    }

    public static final <T> Wrapper<Map<String, List<T>>> wrapper(List<? extends T> wrapper, Module module, Section section, String key) {
        Map b2;
        j.e(wrapper, "$this$wrapper");
        j.e(module, "module");
        j.e(section, "section");
        j.e(key, "key");
        b2 = d0.b(n.a(key, wrapper));
        return new Wrapper<>(module, section, b2);
    }

    public static final <T> List<Map<String, T>> wrapperToMapList(List<? extends T> wrapperToMapList, String keyPrefix) {
        int l;
        Map b2;
        j.e(wrapperToMapList, "$this$wrapperToMapList");
        j.e(keyPrefix, "keyPrefix");
        l = o.l(wrapperToMapList, 10);
        ArrayList arrayList = new ArrayList(l);
        for (T t : wrapperToMapList) {
            b2 = d0.b(new Pair(keyPrefix + wrapperToMapList.indexOf(t) + 1, t));
            arrayList.add(b2);
        }
        return arrayList;
    }

    public static final Response<List<Object>> unwrap(Response<Wrappers> unwrap) {
        int l;
        j.e(unwrap, "$this$unwrap");
        List<Wrapper<?>> wrapperList = unwrap.getResult().getWrapperList();
        l = o.l(wrapperList, 10);
        ArrayList arrayList = new ArrayList(l);
        Iterator<T> it = wrapperList.iterator();
        while (it.hasNext()) {
            arrayList.add(((Wrapper) it.next()).getData());
        }
        return unwrap.repack(arrayList);
    }

    public static final <R> R typeCast(Wrappers typeCast, Module module, Section section) {
        j.e(typeCast, "$this$typeCast");
        j.e(module, "module");
        j.e(section, "section");
        for (Wrapper<?> wrapper : typeCast.getWrapperList()) {
            if (j.a(wrapper.getModule(), module.getValue()) && j.a(wrapper.getSection(), section.getValue())) {
                R r = (R) wrapper.getData();
                if (!(r instanceof Object)) {
                    return null;
                }
                return r;
            }
        }
        return null;
    }
}
