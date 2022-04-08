package com.tplink.libtpmediastatistics.utils;

/* loaded from: classes3.dex */
public class StatisticsRemoteServerInfoUtils {
    public static final String STAT_HOST = "analytics.tplinkcloud.com";
    public static final String STAT_HOST_BETA = "analytics-beta.tplinkcloud.com";

    public static String getStatServerName(String str) {
        return (str == null || !str.endsWith("beta.tplinkcloud.com")) ? STAT_HOST : STAT_HOST_BETA;
    }
}
