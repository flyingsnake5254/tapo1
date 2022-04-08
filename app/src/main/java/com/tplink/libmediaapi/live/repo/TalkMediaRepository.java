package com.tplink.libmediaapi.live.repo;

import b.d.u.m;
import b.d.v.b.c;
import com.tplink.libmediaapi.common.apicallback.DoubleTalkStreamCallback;
import com.tplink.libtpappcommonmedia.bean.TPMediaDeviceContext;
import com.tplink.libtpmediamanager.d;
import com.tplink.libtpmediamanager.talk.TalkMediaBaseRepository;

/* loaded from: classes3.dex */
public class TalkMediaRepository extends TalkMediaBaseRepository {
    private DoubleTalkStreamCallback doubleTalkStreamCallback;
    private final c doubleTalkStreamCallbackInner = new c() { // from class: com.tplink.libmediaapi.live.repo.TalkMediaRepository.1
        @Override // b.d.v.b.c
        public void onDoubleTalkClose(String str) {
            if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
                TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkClose(str);
            }
        }

        @Override // b.d.v.b.c
        public void onDoubleTalkCreateFailure(String str, int i) {
            if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
                TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkCreateFailure(str, i);
            }
        }

        @Override // b.d.v.b.c
        public void onDoubleTalkCreateSuccess(String str) {
            if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
                TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkCreateSuccess(str);
            }
        }

        @Override // b.d.v.b.c
        public void onDoubleTalkSendDataFailure(String str, int i, Exception exc) {
            if (TalkMediaRepository.this.doubleTalkStreamCallback != null) {
                TalkMediaRepository.this.doubleTalkStreamCallback.onDoubleTalkSendDataFailure(str, i, exc);
            }
        }
    };

    public TalkMediaRepository(TPMediaDeviceContext tPMediaDeviceContext) {
        super(tPMediaDeviceContext);
    }

    private m getClient() {
        return d.h().g(this.deviceContext.getDeviceIdMd5());
    }

    public void addDoubleTalkStreamCallback(String str, DoubleTalkStreamCallback doubleTalkStreamCallback) {
        this.doubleTalkStreamCallback = doubleTalkStreamCallback;
        d.h().d(str, this.doubleTalkStreamCallbackInner);
    }

    public void destroyAllDoubleTalkClient() {
        d.h().e();
    }

    public void destroyDoubleTalkClient(String str) {
        d.h().f(str);
    }

    @Override // com.tplink.libtpmediamanager.g.b
    public void loadCacheData() {
    }

    public void muteRecordAudio(boolean z) {
        m client = getClient();
        if (client != null) {
            client.e(z);
        }
    }

    @Override // com.tplink.libtpmediamanager.g.b
    public void onCleared() {
    }

    public void openDoubleTalkClient(String str, String str2) {
        d.h().j(str, str2);
    }

    public void pauseSendAudio() {
        m client = getClient();
        if (client != null) {
            client.d();
        }
    }

    public void setMaxVolume(int i) {
        m client = getClient();
        if (client != null) {
            client.g(i);
        }
    }

    public void setVolume(int i) {
        m client = getClient();
        if (client != null) {
            client.i(i);
        }
    }

    public void startSendAudio() {
        m client = getClient();
        if (client != null) {
            client.j();
        }
    }
}
