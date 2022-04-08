package com.tplink.libtpnetwork.libwss.bean.result;

/* compiled from: AppToAppLinkStatusResult.kt */
/* loaded from: classes3.dex */
public final class AppToAppLinkStatusResult {
    private AppToAppLinking appToAppLinking;
    private String authorizationUrl;
    private boolean linkStatus;

    /* compiled from: AppToAppLinkStatusResult.kt */
    /* loaded from: classes3.dex */
    public static final class AppToAppLinking {

        /* renamed from: android  reason: collision with root package name */
        private Platform f15065android;
        private Platform ios;

        /* compiled from: AppToAppLinkStatusResult.kt */
        /* loaded from: classes3.dex */
        public static final class Platform {
            private String appToAppLinkingUrl;

            public final String getAppToAppLinkingUrl() {
                return this.appToAppLinkingUrl;
            }

            public final void setAppToAppLinkingUrl(String str) {
                this.appToAppLinkingUrl = str;
            }
        }

        public final Platform getAndroid() {
            return this.f15065android;
        }

        public final Platform getIos() {
            return this.ios;
        }

        public final void setAndroid(Platform platform) {
            this.f15065android = platform;
        }

        public final void setIos(Platform platform) {
            this.ios = platform;
        }
    }

    public final AppToAppLinking getAppToAppLinking() {
        return this.appToAppLinking;
    }

    public final String getAuthorizationUrl() {
        return this.authorizationUrl;
    }

    public final boolean getLinkStatus() {
        return this.linkStatus;
    }

    public final void setAppToAppLinking(AppToAppLinking appToAppLinking) {
        this.appToAppLinking = appToAppLinking;
    }

    public final void setAuthorizationUrl(String str) {
        this.authorizationUrl = str;
    }

    public final void setLinkStatus(boolean z) {
        this.linkStatus = z;
    }

    public String toString() {
        return "AppToAppLinkStatusResult( linkStatus=" + this.linkStatus + ", authorizationUrl=" + this.authorizationUrl + ", appToAppLinking=" + this.appToAppLinking + " )";
    }
}
