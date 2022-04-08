package com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb;

import com.google.gson.i;
import com.google.gson.r.a;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.libtpnetwork.cameranetwork.util.JsonUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class LightEffectRuleBean extends ThingRuleLightEffect {
    private transient List<LightStateBean> statusList;

    public LightEffectRuleBean() {
        this.statusList = new ArrayList();
    }

    private static i covertToJsonElement(List<LightStateBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (LightStateBean lightStateBean : list) {
                arrayList.add(Arrays.asList(Integer.valueOf(lightStateBean.getBrightness()), Integer.valueOf(lightStateBean.getHue()), Integer.valueOf(lightStateBean.getSaturation()), Integer.valueOf(lightStateBean.getColorTemp())));
            }
        }
        return (i) com.tplink.libtpnetwork.Utils.i.a(com.tplink.libtpnetwork.Utils.i.i(arrayList), i.class);
    }

    private static List<LightStateBean> transformFromJsonElement(i iVar) {
        List<List> list = (List) JsonUtils.a(com.tplink.libtpnetwork.Utils.i.f(iVar), new a<List<List<Integer>>>() { // from class: com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectRuleBean.1
        }.getType());
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (List list2 : list) {
                if (list2 != null && list2.size() == 4) {
                    arrayList.add(new LightStateBean(list2));
                }
            }
        }
        return arrayList;
    }

    public List<LightStateBean> getStatusList() {
        return this.statusList;
    }

    public void setStatusList(List<LightStateBean> list) {
        this.statusList = list;
        setColorStatusList(covertToJsonElement(list));
    }

    public LightEffectRuleBean(ThingRuleLightEffect thingRuleLightEffect) {
        this.statusList = new ArrayList();
        if (thingRuleLightEffect != null) {
            setId(thingRuleLightEffect.getId());
            setSceneName(thingRuleLightEffect.getSceneName());
            setChangeMode(thingRuleLightEffect.getChangeMode());
            setChangeTime(thingRuleLightEffect.getChangeTime());
            i colorStatusList = thingRuleLightEffect.getColorStatusList();
            if (colorStatusList != null) {
                this.statusList = transformFromJsonElement(colorStatusList);
            }
        }
    }
}
