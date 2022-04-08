package com.tplink.libtpnetwork.cameranetwork.model;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Model {
    public static final <T> List<T> extractFromMapList(List<? extends Map<String, ? extends T>> list) {
        return Model__ModelAdapterKt.extractFromMapList(list);
    }

    public static final <T> List<T> extractMapList(List<? extends Map<String, ? extends T>> list) {
        return Model__ModelAdapterKt.extractMapList(list);
    }

    public static final AESEncryptKey getAESEncryptKeyFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getAESEncryptKeyFromWrapper(wrappers);
    }

    public static final DiagnoseStatus getDiagnoseStateFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getDiagnoseStateFromWrapper(wrappers);
    }

    public static final MarkPositionConfirmInfo getMarkPositionConfirmInfoFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getMarkPositionConfirmInfoFromWrapper(wrappers);
    }

    public static final NetworkInfo getNetworkInfoFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getNetworkInfoFromWrapper(wrappers);
    }

    public static final P2PSharePwd getP2PSharePasswordFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getP2PSharePasswordFromWrapper(wrappers);
    }

    public static final ResetSupportInfo getResetSupportInfoFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getResetSupportInfoFromWrapper(wrappers);
    }

    public static final SdCardFormatProgress getSdCardFormatProgressFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getSdCardFormatProgressFromWrapper(wrappers);
    }

    public static final StartUpdateFirmwareInfo getStartFirmUpdateInfoFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getStartFirmUpdateInfoFromWrapper(wrappers);
    }

    public static final VodUserId getVodUserIdFromWrapper(Wrappers wrappers) {
        return Model__ModelAdapterKt.getVodUserIdFromWrapper(wrappers);
    }

    public static final Account passwordDigest(Account account) {
        return Model__ModelKt.passwordDigest(account);
    }

    public static final <R> Response<R> safeCast(Response<? extends Object> response, Method method) {
        return Model__BaseKt.safeCast(response, method);
    }

    public static final List<ComponentBean> toComponentList(Wrappers wrappers) {
        return Model__ModelAdapterKt.toComponentList(wrappers);
    }

    public static final List<OsdElement> toOsdList(Wrappers wrappers) {
        return Model__ModelAdapterKt.toOsdList(wrappers);
    }

    public static final List<Wifi> toWifiList(Wrappers wrappers) {
        return Model__ModelAdapterKt.toWifiList(wrappers);
    }

    public static final <R> R typeCast(Wrappers wrappers, Module module, Section section) {
        return (R) Model__ModelAdapterKt.typeCast(wrappers, module, section);
    }

    public static final Response<List<Object>> unwrap(Response<Wrappers> response) {
        return Model__ModelAdapterKt.unwrap(response);
    }

    public static final <T> Wrapper<Map<String, List<T>>> wrapper(List<? extends T> list, Module module, Section section, String str) {
        return Model__ModelAdapterKt.wrapper(list, module, section, str);
    }

    public static final <T> List<Map<String, T>> wrapperToMapList(List<? extends T> list, String str) {
        return Model__ModelAdapterKt.wrapperToMapList(list, str);
    }

    public static final <R> R typeCast(Wrappers wrappers, Class<R> cls) {
        return (R) Model__ModelAdapterKt.typeCast(wrappers, cls);
    }

    public static final <R> Response<R> unwrap(Response<Wrappers> response, Class<R> cls) {
        return Model__ModelAdapterKt.unwrap(response, cls);
    }
}
