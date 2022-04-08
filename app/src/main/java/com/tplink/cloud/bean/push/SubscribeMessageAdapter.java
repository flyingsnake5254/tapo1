package com.tplink.cloud.bean.push;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.a;
import com.google.gson.stream.b;
import com.tplink.cloud.bean.push.params.SubscribeItemParams;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class SubscribeMessageAdapter extends TypeAdapter<List<SubscribeItemParams>> {
    private static final String SUBSCRIBE_MESSAGE_SEPARATOR = ":";

    @Override // com.google.gson.TypeAdapter
    public List<SubscribeItemParams> read(a aVar) throws IOException {
        HashMap hashMap = new HashMap();
        aVar.a();
        while (aVar.s()) {
            String E = aVar.E();
            if (E.contains(":")) {
                String[] split = E.split(":");
                SubscribeItemParams subscribeItemParams = (SubscribeItemParams) hashMap.get(split[0]);
                if (subscribeItemParams == null) {
                    subscribeItemParams = new SubscribeItemParams();
                    subscribeItemParams.setDeviceId(split[0]);
                    hashMap.put(split[0], subscribeItemParams);
                }
                subscribeItemParams.addMessageType(split[1]);
            }
        }
        aVar.E();
        aVar.j();
        return new ArrayList(hashMap.values());
    }

    public void write(b bVar, List<SubscribeItemParams> list) throws IOException {
        bVar.e();
        for (SubscribeItemParams subscribeItemParams : list) {
            Iterator<String> it = subscribeItemParams.getMessageTypeList().iterator();
            while (it.hasNext()) {
                bVar.J(subscribeItemParams.getDeviceId() + ":" + it.next());
            }
        }
        bVar.j();
    }
}
