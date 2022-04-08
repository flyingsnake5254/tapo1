package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.converter;

import org.eclipse.paho.client.mqttv3.MqttTopic;

/* loaded from: classes3.dex */
public final class Converters {
    public static final LocaleConverter localeConverter = new LocaleConverter();
    public static final StringConverter stringConverter = new StringConverter();
    public static final BooleanConverter booleanConverter = new BooleanConverter();
    public static final IntegerConverter integerConverter = new IntegerConverter();
    public static final LongConverter longConverter = new LongConverter();
    public static final StringReplaceConverter urlConverter = new StringReplaceConverter("\\/", MqttTopic.TOPIC_LEVEL_SEPARATOR);
}
