package com.tplink.libtpmediastatistics;

import b.d.d.f.a;
import b.d.d.m.g;
import b.d.d.m.h;
import b.d.p.d;
import com.google.android.gms.common.internal.ImagesContract;
import com.tplink.libmediakit.jniinterface.RemoteConnection;
import com.tplink.libtpmediastatistics.bean.StatisticsCameraDevice;
import com.tplink.libtpmediastatistics.utils.StatisticsRemoteServerInfoUtils;
import io.reactivex.q;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class StatisticsManager {
    private static final String TAG = "StatisticsManager";
    private static StatisticsManager instance;
    private Map<String, OnceConnectionVO> onceConnectionVOMap = new ConcurrentHashMap();
    private Map<String, ConnectionInfoVO> connectionInfoVOMap = new ConcurrentHashMap();
    private ExecutorService executorService = Executors.newSingleThreadExecutor();

    private StatisticsManager() {
    }

    public static StatisticsManager getInstance() {
        if (instance == null) {
            synchronized (StatisticsManager.class) {
                if (instance == null) {
                    instance = new StatisticsManager();
                }
            }
        }
        return instance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestFeedback(StatisticsCameraDevice statisticsCameraDevice) {
        if (statisticsCameraDevice != null && !statisticsCameraDevice.isLocalOnly()) {
            FeedbackUploadManager.getInstance().initSSLClient(StatisticsRemoteServerInfoUtils.getStatServerName(a.h()), 443, "TP-Link_Tapo_Android Android " + b.d.d.m.a.a(), b.d.d.a.a.c());
            String deviceIdMD5 = statisticsCameraDevice.getDeviceIdMD5();
            BasicVO basicVO = new BasicVO();
            basicVO.setAppID(h.a());
            basicVO.setClientType("Android " + b.d.d.m.a.a());
            basicVO.setDevID(statisticsCameraDevice.getDeviceId());
            if (statisticsCameraDevice.getModel() != null) {
                basicVO.setDevModel(statisticsCameraDevice.getModel());
            }
            basicVO.setNetworkType(g.a());
            basicVO.setFirmwareVersion(statisticsCameraDevice.getSoftwareVersion());
            StatisticsStreamType statisticsStreamType = StatisticsStreamType.MIXED;
            ConnectionInfoVO remove = this.connectionInfoVOMap.remove(getConnectionInfoCacheKey(deviceIdMD5, statisticsStreamType));
            if (remove != null) {
                basicVO.setStreamType(statisticsStreamType.toString());
                remove.setConnectionBasicVO(basicVO.clone());
                FeedbackPayload feedbackPayload = new FeedbackPayload();
                feedbackPayload.setVersion("0.1");
                feedbackPayload.setType("appSession");
                feedbackPayload.addData("basic", remove.getConnectionBasicVO());
                feedbackPayload.addData("relay", remove.getRelayConnectionVO());
                ConnectionVO p2pConnectionVO = remove.getP2pConnectionVO();
                p2pConnectionVO.setNatTypeApp(Integer.valueOf(RemoteConnection.d().f()));
                p2pConnectionVO.setNatTypeDev(Integer.valueOf(RemoteConnection.d().g(statisticsCameraDevice.getDeviceId())));
                feedbackPayload.addData("p2p", p2pConnectionVO);
                FeedbackUploadManager.getInstance().offerFeedbackPayload(MediaJsonUtils.toJSON(feedbackPayload));
                d.e("NNNNNNNNNNN", MediaJsonUtils.toJSON(feedbackPayload));
            }
            StatisticsStreamType statisticsStreamType2 = StatisticsStreamType.SD_VOD;
            ConnectionInfoVO remove2 = this.connectionInfoVOMap.remove(getConnectionInfoCacheKey(deviceIdMD5, statisticsStreamType2));
            if (remove2 != null) {
                d.a(TAG, "sdVODConnectionInfoVO:" + remove2.toString());
                basicVO.setStreamType(statisticsStreamType2.toString());
                remove2.setConnectionBasicVO(basicVO.clone());
                FeedbackPayload feedbackPayload2 = new FeedbackPayload();
                feedbackPayload2.setVersion("0.1");
                feedbackPayload2.setType("appSession");
                feedbackPayload2.addData("basic", remove2.getConnectionBasicVO());
                feedbackPayload2.addData("relay", remove2.getRelayConnectionVO());
                ConnectionVO p2pConnectionVO2 = remove2.getP2pConnectionVO();
                p2pConnectionVO2.setNatTypeApp(Integer.valueOf(RemoteConnection.d().f()));
                p2pConnectionVO2.setNatTypeDev(Integer.valueOf(RemoteConnection.d().g(statisticsCameraDevice.getDeviceId())));
                feedbackPayload2.addData("p2p", p2pConnectionVO2);
                FeedbackUploadManager.getInstance().offerFeedbackPayload(MediaJsonUtils.toJSON(feedbackPayload2));
                d.e("NNNNNNNNNNN", MediaJsonUtils.toJSON(feedbackPayload2));
            }
            StatisticsStreamType statisticsStreamType3 = StatisticsStreamType.DOUBLE_TALK;
            ConnectionInfoVO remove3 = this.connectionInfoVOMap.remove(getConnectionInfoCacheKey(deviceIdMD5, statisticsStreamType3));
            if (remove3 != null) {
                d.a(TAG, "doubleTalkConnectionInfoVO:" + remove3.toString());
                basicVO.setStreamType(statisticsStreamType3.toString());
                remove3.setConnectionBasicVO(basicVO.clone());
                FeedbackPayload feedbackPayload3 = new FeedbackPayload();
                feedbackPayload3.setVersion("0.1");
                feedbackPayload3.setType("appSession");
                feedbackPayload3.addData("basic", remove3.getConnectionBasicVO());
                feedbackPayload3.addData("relay", remove3.getRelayConnectionVO());
                ConnectionVO p2pConnectionVO3 = remove3.getP2pConnectionVO();
                p2pConnectionVO3.setNatTypeApp(Integer.valueOf(RemoteConnection.d().f()));
                p2pConnectionVO3.setNatTypeDev(Integer.valueOf(RemoteConnection.d().g(statisticsCameraDevice.getDeviceId())));
                feedbackPayload3.addData("p2p", p2pConnectionVO3);
                feedbackPayload3.addData(ImagesContract.LOCAL, remove3.getLocalConnectionVO());
                FeedbackUploadManager.getInstance().offerFeedbackPayload(MediaJsonUtils.toJSON(feedbackPayload3));
                d.e("NNNNNNNNNNN", MediaJsonUtils.toJSON(feedbackPayload3));
            }
        }
    }

    public OnceConnectionVO getAndRemoveOnceConnectionVO(String str) {
        return this.onceConnectionVOMap.remove(str);
    }

    public String getConnectionInfoCacheKey(String str, StatisticsStreamType statisticsStreamType) {
        return str + "_" + statisticsStreamType.value();
    }

    public ConnectionInfoVO getConnectionInfoVO(String str) {
        return this.connectionInfoVOMap.get(str);
    }

    public String getOnceConnectionCacheKey(String str, StatisticsStreamType statisticsStreamType, int i) {
        return str + "_" + statisticsStreamType.value() + "_" + i;
    }

    public OnceConnectionVO getOnceConnectionVO(String str) {
        return this.onceConnectionVOMap.get(str);
    }

    public void insertConnectionInfoVO(String str, ConnectionInfoVO connectionInfoVO) {
        this.connectionInfoVOMap.put(str, connectionInfoVO);
    }

    public void insertOnceConnectionVO(String str, OnceConnectionVO onceConnectionVO) {
        this.onceConnectionVOMap.put(str, onceConnectionVO);
    }

    public void removeConnectionInfoVO(String str) {
        this.connectionInfoVOMap.remove(str);
    }

    public void removeOnceConnectionVO(String str) {
        this.onceConnectionVOMap.remove(str);
    }

    public void sendFeedback(StatisticsCameraDevice statisticsCameraDevice) {
        if (statisticsCameraDevice != null) {
            q.f0(statisticsCameraDevice).L0(io.reactivex.l0.a.b(this.executorService)).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpmediastatistics.d
                @Override // io.reactivex.g0.g
                public final void accept(Object obj) {
                    StatisticsManager.this.requestFeedback((StatisticsCameraDevice) obj);
                }
            }).F0();
        }
    }
}
