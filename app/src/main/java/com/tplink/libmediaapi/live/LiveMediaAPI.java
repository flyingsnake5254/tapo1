package com.tplink.libmediaapi.live;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableLong;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback;
import com.tplink.libmediaapi.common.apicallback.OnConnectionTypeChangeListener;
import com.tplink.libmediaapi.common.apicallback.StreamDisplayCommonCallback;
import com.tplink.libmediaapi.common.apicallback.StreamNotificationCallback;
import com.tplink.libmediaapi.live.repo.LiveMediaRepository;
import com.tplink.libmediaapi.live.repo.TalkMediaRepository;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpmediamanager.ConnectionTypeManager;
import com.tplink.libtpmediamanager.RelayTimerManager;
import com.tplink.libtpmediamanager.f;
import com.tplink.libtpmediamanager.g.d;
import com.tplink.libtpstreamclientmanager.m;
import java.util.List;

/* loaded from: classes3.dex */
public class LiveMediaAPI {
    public static void addDoubleTalkStreamCallback(String str, DoubleTalkStreamCallback doubleTalkStreamCallback) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).addDoubleTalkStreamCallback(str, doubleTalkStreamCallback);
        }
    }

    public static void addSteamDisplayCommonCallback(String str, StreamDisplayCommonCallback streamDisplayCommonCallback) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).addSteamDisplayCommonCallback(streamDisplayCommonCallback);
        }
    }

    public static void allDisplayScreenshotPreview() {
        f.j().g();
    }

    public static void bindCallingVariable(@Nullable ObservableBoolean observableBoolean) {
        RelayTimerManager.INSTANCE.bindCallingVariable(observableBoolean);
    }

    public static void bindRecordingVariable(@Nullable ObservableBoolean observableBoolean) {
        RelayTimerManager.INSTANCE.bindRecordingVariable(observableBoolean);
    }

    public static void changePreviewResolutions(String str, BitStreamType bitStreamType, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).changePreviewResolutions(str, bitStreamType, str2);
        }
    }

    public static void clearCommonCallback(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).clearCommonCallback();
        }
    }

    public static void destroyAllDisplay() {
        for (String str : f.j().i()) {
            clearCommonCallback(str);
        }
    }

    public static void destroyAllDisplayAndStream() {
        destroyAllDisplay();
        m.V().O();
    }

    public static void destroyAllDoubleTalkClient() {
        com.tplink.libtpmediamanager.d.h().e();
    }

    public static void destroyDoubleTalkClient(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).destroyDoubleTalkClient(str);
        }
    }

    public static void disableRelayTimer() {
        RelayTimerManager.INSTANCE.disableRelayTimer();
    }

    public static void enableRelayTimer() {
        RelayTimerManager.INSTANCE.enableRelayTimer();
    }

    public static ObservableBoolean getCallingObservable() {
        return RelayTimerManager.INSTANCE.getCallingObservable();
    }

    public static int getConnectType(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).getConnectType();
    }

    public static int getConnectionType(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).getConnectionType(str);
    }

    public static int getMultiDeviceTimeoutSeconds() {
        RelayTimerManager relayTimerManager = RelayTimerManager.INSTANCE;
        return 120;
    }

    public static List<String> getPlayingDevices() {
        return f.j().k();
    }

    public static ObservableLong getRecordDuration(String str) {
        return TextUtils.isEmpty(str) ? new ObservableLong() : ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).getRecordDuration();
    }

    public static ObservableBoolean getRecordingObservable() {
        return RelayTimerManager.INSTANCE.getRecordingObservable();
    }

    public static int getSingleDeviceTimeoutSeconds() {
        RelayTimerManager relayTimerManager = RelayTimerManager.INSTANCE;
        return 300;
    }

    public static boolean isPlayingProperly(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).isPlayingProperly();
    }

    public static boolean isRecording(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).isRecording();
    }

    public static ObservableBoolean isRecordingObservable(String str) {
        return TextUtils.isEmpty(str) ? new ObservableBoolean() : ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).isRecordingObservable();
    }

    public static void keepDoubleTalk(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).keepDoubleTalk(str);
        }
    }

    public static boolean lockLiveStreamAudio() {
        return f.j().n();
    }

    public static void muteAudio(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).muteAudio(str, z);
        }
    }

    public static void muteRecordAudio(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).muteRecordAudio(z);
        }
    }

    public static void muteVolume(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).muteVolume(str, z);
        }
    }

    public static void onDetectPipePause() {
        b.d.o.a.f.m().o();
    }

    public static void onDetectPipeResume() {
        b.d.o.a.f.m().p();
    }

    public static void onNetworkChanged() {
        b.d.o.a.f.m().u();
        b.d.a0.a.f.c().h();
        b.d.o.a.f.m().n();
        b.d.o.a.f.m().r();
        b.d.a0.a.f.c().d();
    }

    public static void openDoubleTalkClient(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).openDoubleTalkClient(str, str2);
        }
    }

    public static void pause(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).pause();
        }
    }

    public static void pauseSendAudio(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).pauseSendAudio();
        }
    }

    public static void previewCapture(String str, MutableLiveData<b.d.d.m.f<String>> mutableLiveData) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).previewCapture(mutableLiveData);
        }
    }

    public static void previewScreenShot(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).previewScreenShot();
        }
    }

    public static void releaseStream(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).releaseStream(str);
        }
    }

    public static void removeSteamDisplayCommonCallback(String str, StreamDisplayCommonCallback streamDisplayCommonCallback) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).removeSteamDisplayCommonCallback(streamDisplayCommonCallback);
        }
    }

    public static void resetPipeErrorStatus() {
        b.d.o.a.f.m().u();
        b.d.a0.a.f.c().h();
    }

    public static void resume(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).resume();
        }
    }

    public static void setConnectionTypeListener(final OnConnectionTypeChangeListener onConnectionTypeChangeListener) {
        if (onConnectionTypeChangeListener != null) {
            ConnectionTypeManager.INSTANCE.setListener(new ConnectionTypeManager.a() { // from class: com.tplink.libmediaapi.live.a
                @Override // com.tplink.libtpmediamanager.ConnectionTypeManager.a
                public final void onChange(String str, int i) {
                    OnConnectionTypeChangeListener.this.onChange(str, i);
                }
            });
        } else {
            ConnectionTypeManager.INSTANCE.setListener(null);
        }
    }

    public static void setConnectionTypeListenerEnable(boolean z) {
        ConnectionTypeManager.INSTANCE.setEnabled(z);
    }

    public static void setMaxVolume(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).setMaxVolume(i);
        }
    }

    public static void setPlayInPreviewPage(boolean z) {
        RelayTimerManager.INSTANCE.setPlayInPreviewPage(z);
    }

    public static void setStreamControlNotificationCallback(String str, StreamNotificationCallback streamNotificationCallback) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).setStreamControlNotificationCallback(str, streamNotificationCallback);
        }
    }

    public static void setVolume(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).setVolume(i);
        }
    }

    public static void snapshot(String str, MutableLiveData<b.d.d.m.f<Pair<Bitmap, String>>> mutableLiveData) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).snapshot(mutableLiveData);
        }
    }

    public static void startHoldToTalk(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).startHoldToTalk();
        }
    }

    public static void startLiveStreamDisplay(String str, Context context, BitStreamType bitStreamType) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).startLiveStreamDisplay(str, context, bitStreamType);
        }
    }

    public static void startRecord(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).startRecord();
        }
    }

    public static void startSendAudio(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((TalkMediaRepository) d.b(str, TalkMediaRepository.class)).startSendAudio();
        }
    }

    public static void stopDisplay(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).stopDisplay(str);
        }
    }

    public static void stopHoldToTalk(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).stopHoldToTalk();
        }
    }

    public static void stopKeepDoubleTalk(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).stopKeepDoubleTalk(str);
        }
    }

    public static void stopNetworkStatics(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).stopNetworkStatics();
        }
    }

    public static void stopRecord(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).stopRecord();
        }
    }

    public static boolean unlockLiveStreamAudio() {
        return f.j().u();
    }

    public static void updateAudioVolume(String str, float f2, float f3) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).updateAudioVolume(f2, f3);
        }
    }

    public static void addSteamDisplayCommonCallback(String str, int i, StreamDisplayCommonCallback streamDisplayCommonCallback) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).addSteamDisplayCommonCallback(i, streamDisplayCommonCallback);
        }
    }

    public static void snapshot(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((LiveMediaRepository) d.b(str, LiveMediaRepository.class)).snapshot();
        }
    }
}
