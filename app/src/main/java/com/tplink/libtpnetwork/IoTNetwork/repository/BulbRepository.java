package com.tplink.libtpnetwork.IoTNetwork.repository;

import android.text.TextUtils;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.cloud.bean.thing.common.ThingModel;
import com.tplink.iot.cloud.bean.thing.common.ThingRuleLightEffect;
import com.tplink.iot.cloud.bean.thing.common.ThingShadow;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleListResult;
import com.tplink.iot.cloud.bean.thing.result.ThingRuleUpdateResult;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.BrightnessPresetsBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.params.BulbDeviceInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbDeviceRunningInfoResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.AutoLightBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.EditPresetRule;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightEffectEnableBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.LightStateBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.colorbulb.OnOffGraduallyBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.RulePageParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.LightEffectRuleResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.thingmodel.ThingModelDefine;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.exception.IoTException;
import io.reactivex.e0.c;
import io.reactivex.q;
import io.reactivex.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class BulbRepository extends AbstractThingRepository {
    private String F;
    private MutableLiveData<BrightnessPresetsBean> C = new MutableLiveData<>();
    private MutableLiveData<List<LightStateBean>> D = new MutableLiveData<>();
    private MutableLiveData<OnOffGraduallyBean> E = new MutableLiveData<>();
    private MutableLiveData<List<ThingRuleLightEffect>> G = new MutableLiveData<>();
    private Map<String, ThingRuleLightEffect> H = new LinkedHashMap();

    /* loaded from: classes3.dex */
    class a implements io.reactivex.g0.g<Throwable> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ OnOffGraduallyBean f12872c;

        a(OnOffGraduallyBean onOffGraduallyBean) {
            this.f12872c = onOffGraduallyBean;
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            BulbRepository.this.E.postValue(new OnOffGraduallyBean(!this.f12872c.isEnable()));
        }
    }

    /* loaded from: classes3.dex */
    class b implements io.reactivex.g0.a {
        final /* synthetic */ OnOffGraduallyBean a;

        b(OnOffGraduallyBean onOffGraduallyBean) {
            this.a = onOffGraduallyBean;
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            BulbRepository.this.E.postValue(this.a);
        }
    }

    /* loaded from: classes3.dex */
    class c implements Function<LocalIoTBaseDevice, IoTBulbDevice> {
        c() {
        }

        /* renamed from: a */
        public IoTBulbDevice apply(LocalIoTBaseDevice localIoTBaseDevice) {
            if (localIoTBaseDevice instanceof IoTBulbDevice) {
                return (IoTBulbDevice) localIoTBaseDevice;
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class d implements io.reactivex.g0.g<Throwable> {
        d() {
        }

        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            LocalIoTBaseDevice value = BulbRepository.this.n.getValue();
            if (value instanceof IoTBulbDevice) {
                ((IoTBulbDevice) value).setAutoMode(BulbRepository.this.F);
            }
        }
    }

    /* loaded from: classes3.dex */
    class e implements io.reactivex.g0.j<Throwable, io.reactivex.e> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AutoLightBean f12876c;

        e(AutoLightBean autoLightBean) {
            this.f12876c = autoLightBean;
        }

        /* renamed from: a */
        public io.reactivex.e apply(Throwable th) throws Exception {
            if (BulbRepository.this.F0(th)) {
                return BulbRepository.this.J4(new BulbDeviceInfoParams(this.f12876c));
            }
            return io.reactivex.a.m(th);
        }
    }

    /* loaded from: classes3.dex */
    class f implements io.reactivex.g0.g<AutoLightBean> {
        f() {
        }

        /* renamed from: a */
        public void accept(AutoLightBean autoLightBean) throws Exception {
            LocalIoTBaseDevice value = BulbRepository.this.n.getValue();
            if (value instanceof IoTBulbDevice) {
                ((IoTBulbDevice) value).setAutoMode(autoLightBean.getMode());
            }
        }
    }

    /* loaded from: classes3.dex */
    class g implements io.reactivex.g0.g<BrightnessPresetsBean> {
        g() {
        }

        /* renamed from: a */
        public void accept(BrightnessPresetsBean brightnessPresetsBean) throws Exception {
            BulbRepository.this.C.postValue(brightnessPresetsBean);
        }
    }

    /* loaded from: classes3.dex */
    class h implements io.reactivex.g0.j<com.google.gson.i, BrightnessPresetsBean> {
        h() {
        }

        /* renamed from: a */
        public BrightnessPresetsBean apply(com.google.gson.i iVar) throws Exception {
            return (BrightnessPresetsBean) com.tplink.libtpnetwork.Utils.i.a(iVar, BrightnessPresetsBean.class);
        }
    }

    /* loaded from: classes3.dex */
    class i implements io.reactivex.g0.j<Throwable, t<? extends Boolean>> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ EditPresetRule f12881c;

        i(EditPresetRule editPresetRule) {
            this.f12881c = editPresetRule;
        }

        /* renamed from: a */
        public t<? extends Boolean> apply(Throwable th) throws Exception {
            if (!BulbRepository.this.F0(th)) {
                return q.J(th);
            }
            BrightnessPresetsBean.PresetBean presetBean = new BrightnessPresetsBean.PresetBean();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f12881c.getState());
            presetBean.setStates(arrayList);
            BulbRepository.this.b5(Integer.valueOf(this.f12881c.getIndex()), presetBean).y();
            return q.f0(Boolean.TRUE);
        }
    }

    /* loaded from: classes3.dex */
    class j implements io.reactivex.g0.a {
        j() {
        }

        @Override // io.reactivex.g0.a
        public void run() throws Exception {
            if (BulbRepository.this.C.getValue() != 0) {
                BrightnessPresetsBean brightnessPresetsBean = (BrightnessPresetsBean) BulbRepository.this.C.getValue();
                brightnessPresetsBean.setSet(true);
                BulbRepository.this.C.postValue(brightnessPresetsBean);
            }
        }
    }

    /* loaded from: classes3.dex */
    class k implements io.reactivex.g0.g<OnOffGraduallyBean> {
        k() {
        }

        /* renamed from: a */
        public void accept(OnOffGraduallyBean onOffGraduallyBean) throws Exception {
            BulbRepository.this.E.postValue(onOffGraduallyBean);
        }
    }

    public BulbRepository(ThingContext thingContext) {
        super(thingContext, IoTBulbDevice.class, BulbDeviceRunningInfoResult.class);
        ALIoTDevice ioTDevice = thingContext.getIoTDevice();
        if (ioTDevice == null || !(ioTDevice.getLocalIoTDevice() instanceof IoTBulbDevice)) {
            this.n.postValue(new IoTBulbDevice());
            return;
        }
        this.n.postValue((IoTBulbDevice) ioTDevice.getLocalIoTDevice());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A5 */
    public /* synthetic */ void B5(ThingRuleLightEffect thingRuleLightEffect, ThingRuleUpdateResult thingRuleUpdateResult) throws Exception {
        this.H.put(thingRuleLightEffect.getId(), thingRuleLightEffect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C5 */
    public /* synthetic */ t D5(ThingRuleLightEffect thingRuleLightEffect, Throwable th) throws Exception {
        if (F0(th)) {
            return this.f13137d.n1(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), thingRuleLightEffect.getId(), thingRuleLightEffect);
        }
        return q.J(th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List E5(List list, RulePageParams rulePageParams, ThingRuleListResult thingRuleListResult) throws Exception {
        if (thingRuleListResult != null) {
            int sum = thingRuleListResult.getSum();
            if (sum == 0) {
                return new ArrayList();
            }
            if (list.size() >= sum) {
                return list;
            }
            List ruleList = thingRuleListResult.getRuleList();
            if (ruleList != null && !ruleList.isEmpty()) {
                list.addAll(ruleList);
            }
            if (list.size() >= sum) {
                return list;
            }
            rulePageParams.setStartIndex(list.size());
            throw new CloudException(-2, "retry_get_data");
        }
        throw new IoTException(-1, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean F5(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (-2 == cloudException.getErrCode() && "retry_get_data".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ List G5(List list, RulePageParams rulePageParams, LightEffectRuleResult lightEffectRuleResult) throws Exception {
        if (lightEffectRuleResult != null) {
            int sum = lightEffectRuleResult.getSum();
            if (sum == 0) {
                return new ArrayList();
            }
            if (list.size() >= sum) {
                return list;
            }
            List<ThingRuleLightEffect> ruleList = lightEffectRuleResult.getRuleList();
            if (ruleList != null && !ruleList.isEmpty()) {
                list.addAll(ruleList);
            }
            if (list.size() >= sum) {
                return list;
            }
            rulePageParams.setStartIndex(list.size());
            throw new CloudException(-2, "retry_get_data");
        }
        throw new IoTException(-1, "");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean H5(Throwable th) throws Exception {
        if (th instanceof CloudException) {
            CloudException cloudException = (CloudException) th;
            if (-2 == cloudException.getErrCode() && "retry_get_data".equals(cloudException.getMsg())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I5 */
    public /* synthetic */ List J5(BrightnessPresetsBean brightnessPresetsBean) {
        List<LightStateBean> b2 = com.tplink.libtpnetwork.Utils.c.b(brightnessPresetsBean);
        this.D.postValue(b2);
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K5 */
    public /* synthetic */ t L5(Throwable th) throws Exception {
        if (F0(th)) {
            return k5(new RulePageParams(0));
        }
        return q.J(th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M5 */
    public /* synthetic */ void N5(List list) throws Exception {
        this.H.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ThingRuleLightEffect thingRuleLightEffect = (ThingRuleLightEffect) it.next();
            if (!TextUtils.isEmpty(thingRuleLightEffect.getId())) {
                this.H.put(thingRuleLightEffect.getId(), thingRuleLightEffect);
            }
        }
        this.G.postValue(new ArrayList(this.H.values()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O5 */
    public /* synthetic */ t P5(RulePageParams rulePageParams, RulePageParams rulePageParams2) throws Exception {
        return this.f13137d.Z(((ThingContext) this.a).getThingUrl(), ((ThingContext) this.a).getThingName(), rulePageParams.getStartIndex());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q5 */
    public /* synthetic */ void R5(BulbDeviceInfoParams bulbDeviceInfoParams, io.reactivex.e0.c cVar) throws Exception {
        if (this.n.getValue() instanceof IoTBulbDevice) {
            IoTBulbDevice ioTBulbDevice = (IoTBulbDevice) this.n.getValue();
            this.i = ioTBulbDevice.getDeviceInfoParams();
            ioTBulbDevice.updateDeviceInfoParam(bulbDeviceInfoParams);
            ioTBulbDevice.setDynamicLightEffectEnable(false);
            h5();
            this.n.postValue(ioTBulbDevice);
            this.f13334b.L3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: S5 */
    public /* synthetic */ io.reactivex.e T5(LightEffectEnableBean lightEffectEnableBean, Throwable th) throws Exception {
        if (!F0(th)) {
            return io.reactivex.a.m(th);
        }
        if (lightEffectEnableBean.isEnable()) {
            d6();
        }
        return K4(new BulbDeviceInfoParams(lightEffectEnableBean), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U5 */
    public /* synthetic */ void V5(Throwable th) throws Exception {
        E4(th);
    }

    private void d6() {
        ThingShadow thingShadow;
        Map<String, Object> desired;
        ThingModel thingModel = ((ThingContext) this.a).getThingModel();
        if (thingModel != null && thingModel.getThingProperty("on") != null && (thingShadow = ((ThingContext) this.a).getThingShadow()) != null && thingShadow.getState() != null && thingShadow.getState().getDesired() != null && (desired = thingShadow.getState().getDesired()) != null) {
            desired.put("on", Boolean.TRUE);
        }
    }

    private void h5() {
        ThingShadow thingShadow;
        Map<String, Object> desired;
        ThingModel thingModel = ((ThingContext) this.a).getThingModel();
        if (thingModel != null && thingModel.getThingProperty(ThingModelDefine.Property.PROPERTY_DYNAMIC_LIGHT_EFFECT_ENABLE) != null && (thingShadow = ((ThingContext) this.a).getThingShadow()) != null && thingShadow.getState() != null && thingShadow.getState().getDesired() != null && (desired = thingShadow.getState().getDesired()) != null) {
            desired.put(ThingModelDefine.Property.PROPERTY_DYNAMIC_LIGHT_EFFECT_ENABLE, Boolean.FALSE);
        }
    }

    private q<List<ThingRuleLightEffect>> k5(final RulePageParams rulePageParams) {
        final ArrayList arrayList = new ArrayList();
        return v5(rulePageParams).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.c5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BulbRepository.E5(arrayList, rulePageParams, (ThingRuleListResult) obj);
            }
        }).w0(v4.f13509c);
    }

    private q<LightEffectRuleResult> u5(RulePageParams rulePageParams) {
        return y0("get_dynamic_light_effect_rules", rulePageParams, LightEffectRuleResult.class);
    }

    private q<ThingRuleListResult<ThingRuleLightEffect>> v5(final RulePageParams rulePageParams) {
        return q.f0(rulePageParams).N(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.f5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BulbRepository.this.P5(rulePageParams, (RulePageParams) obj);
            }
        });
    }

    public io.reactivex.a W5(AutoLightBean autoLightBean) {
        LocalIoTBaseDevice value = this.n.getValue();
        if (value instanceof IoTBulbDevice) {
            IoTBulbDevice ioTBulbDevice = (IoTBulbDevice) value;
            this.F = ioTBulbDevice.getAutoMode();
            ioTBulbDevice.setAutoMode(autoLightBean.getMode());
        }
        return y0("set_auto_light_info", autoLightBean, Boolean.class).Z().u(new e(autoLightBean)).j(new d());
    }

    public io.reactivex.a X5(int i2) {
        return J4(new BulbDeviceInfoParams(Integer.valueOf(i2)));
    }

    public io.reactivex.a Y5(List<Integer> list) {
        BrightnessPresetsBean.PresetBean presetBean = new BrightnessPresetsBean.PresetBean();
        presetBean.setBrightness(list);
        return c5(presetBean);
    }

    public io.reactivex.a Z5(DefaultStatesBean defaultStatesBean) {
        return G4(new BulbDeviceInfoParams(defaultStatesBean));
    }

    public io.reactivex.a a6(final LightEffectEnableBean lightEffectEnableBean) {
        if (this.n.getValue() instanceof IoTBulbDevice) {
            IoTBulbDevice ioTBulbDevice = (IoTBulbDevice) this.n.getValue();
            this.i = ioTBulbDevice.getDeviceInfoParams();
            if (lightEffectEnableBean.isEnable()) {
                ioTBulbDevice.setDeviceOn(true);
            }
            ioTBulbDevice.setDynamicLightEffectEnable(lightEffectEnableBean.isEnable());
            ioTBulbDevice.setDynamicLightEffectId(lightEffectEnableBean.getId());
            this.n.postValue(ioTBulbDevice);
            this.f13334b.L3();
        }
        return y0("set_dynamic_light_effect_rule_enable", lightEffectEnableBean, Boolean.class).Z().u(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.y4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BulbRepository.this.T5(lightEffectEnableBean, (Throwable) obj);
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.a5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BulbRepository.this.V5((Throwable) obj);
            }
        });
    }

    public io.reactivex.a b6(LightStateBean lightStateBean) {
        return J4(new BulbDeviceInfoParams(lightStateBean));
    }

    public q<Boolean> c6(OnOffGraduallyBean onOffGraduallyBean) {
        return P4(onOffGraduallyBean).z(new b(onOffGraduallyBean)).C(new a(onOffGraduallyBean));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.AbstractThingRepository, com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository, com.tplink.libtpnetwork.IoTNetwork.repository.kb.b, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public void e() {
        this.f13333c.l();
        super.e();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.ThingBaseRepository, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public q<Boolean> h() {
        D4().L0(io.reactivex.l0.a.c()).q0(Boolean.FALSE).F0();
        return super.h();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.repository.kb.b, com.tplink.libtpnetwork.IoTNetwork.repository.kb.c
    public io.reactivex.a i(boolean z) {
        T t;
        LightStateBean lightState;
        final BulbDeviceInfoParams bulbDeviceInfoParams = new BulbDeviceInfoParams(Boolean.valueOf(z));
        if (z && (t = this.a) != 0 && ((ThingContext) t).getIoTDevice() != null && (((ThingContext) this.a).getIoTDevice().getLocalIoTDevice() instanceof IoTBulbDevice)) {
            IoTBulbDevice ioTBulbDevice = (IoTBulbDevice) ((ThingContext) this.a).getIoTDevice().getLocalIoTDevice();
            if (ioTBulbDevice.getDefaultStates() != null && ioTBulbDevice.getDefaultStates().getBrightness() != null && TextUtils.equals(ioTBulbDevice.getDefaultStates().getBrightness().getType(), DefaultStatesBean.TYPE_CUSTOM)) {
                bulbDeviceInfoParams.setBrightness(Integer.valueOf(ioTBulbDevice.getDefaultStates().getBrightness().getValue()));
            } else if (!(ioTBulbDevice.getDefaultStates() == null || !TextUtils.equals(ioTBulbDevice.getDefaultStates().getType(), DefaultStatesBean.TYPE_CUSTOM) || (lightState = ioTBulbDevice.getDefaultStates().getLightState()) == null)) {
                bulbDeviceInfoParams.setBrightness(Integer.valueOf(lightState.getBrightness()));
                bulbDeviceInfoParams.setColorTemp(Integer.valueOf(lightState.getColorTemp()));
                bulbDeviceInfoParams.setHue(Integer.valueOf(lightState.getHue()));
                bulbDeviceInfoParams.setSaturation(Integer.valueOf(lightState.getSaturation()));
            }
        }
        return K4(bulbDeviceInfoParams, false).l(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.z4
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BulbRepository.this.R5(bulbDeviceInfoParams, (c) obj);
            }
        }).j(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.fb
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BulbRepository.this.E4((Throwable) obj);
            }
        });
    }

    public q<ThingRuleUpdateResult> i5(final ThingRuleLightEffect thingRuleLightEffect) {
        return y0("edit_dynamic_light_effect_rule", thingRuleLightEffect, ThingRuleUpdateResult.class).o0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.e5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BulbRepository.this.D5(thingRuleLightEffect, (Throwable) obj);
            }
        }).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.h5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BulbRepository.this.B5(thingRuleLightEffect, (ThingRuleUpdateResult) obj);
            }
        });
    }

    public io.reactivex.a j5(EditPresetRule editPresetRule) {
        BrightnessPresetsBean value = this.C.getValue();
        boolean z = value != null && value.isSet();
        List<LightStateBean> value2 = this.D.getValue();
        if (value2 != null && editPresetRule.getIndex() < value2.size()) {
            value2.set(editPresetRule.getIndex(), editPresetRule.getState());
        }
        if (value == null) {
            value = new BrightnessPresetsBean();
        }
        BrightnessPresetsBean.PresetBean presetBean = new BrightnessPresetsBean.PresetBean();
        presetBean.setStates(value2);
        value.setPresets(presetBean);
        this.C.postValue(value);
        if (!z || value2 == null || editPresetRule.getIndex() >= value2.size()) {
            BrightnessPresetsBean.PresetBean presetBean2 = new BrightnessPresetsBean.PresetBean();
            presetBean2.setStates(value2);
            c5(presetBean2).i(new j()).y();
        } else {
            y0("edit_preset_rules", editPresetRule, Boolean.class).o0(new i(editPresetRule)).F0();
        }
        return io.reactivex.a.e();
    }

    public q<List<ThingRuleLightEffect>> l5(final RulePageParams rulePageParams) {
        final ArrayList arrayList = new ArrayList();
        return u5(rulePageParams).g0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.d5
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BulbRepository.G5(arrayList, rulePageParams, (LightEffectRuleResult) obj);
            }
        }).w0(b5.f13169c);
    }

    public q<AutoLightBean> m5() {
        return y0("get_auto_light_info", null, AutoLightBean.class).E(new f());
    }

    public String n5() {
        if (this.n.getValue() instanceof IoTBulbDevice) {
            return ((IoTBulbDevice) this.n.getValue()).getAutoMode();
        }
        return null;
    }

    public LiveData<List<Integer>> o5() {
        return Transformations.map(z5(), a.a);
    }

    public q<BrightnessPresetsBean> p5() {
        return A1().g0(new h()).E(new g());
    }

    public LiveData<List<LightStateBean>> q5() {
        return Transformations.map(z5(), new Function() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.w4
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return BulbRepository.this.J5((BrightnessPresetsBean) obj);
            }
        });
    }

    public LiveData<IoTBulbDevice> r5() {
        return Transformations.map(super.j1(), new c());
    }

    public ThingRuleLightEffect s5(String str) {
        return this.H.get(str);
    }

    public q<List<ThingRuleLightEffect>> t5() {
        return l5(new RulePageParams(0)).o0(new io.reactivex.g0.j() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.x4
            @Override // io.reactivex.g0.j
            public final Object apply(Object obj) {
                return BulbRepository.this.L5((Throwable) obj);
            }
        }).E(new io.reactivex.g0.g() { // from class: com.tplink.libtpnetwork.IoTNetwork.repository.g5
            @Override // io.reactivex.g0.g
            public final void accept(Object obj) {
                BulbRepository.this.N5((List) obj);
            }
        });
    }

    public LiveData<List<ThingRuleLightEffect>> w5() {
        return this.G;
    }

    public q<OnOffGraduallyBean> x5() {
        return z1().E(new k());
    }

    public LiveData<OnOffGraduallyBean> y5() {
        return this.E;
    }

    public LiveData<BrightnessPresetsBean> z5() {
        return this.C;
    }
}
