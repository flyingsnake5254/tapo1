package androidx.navigation;

import androidx.navigation.NavDeepLink;
import kotlin.jvm.internal.j;

/* compiled from: NavDeepLinkDslBuilder.kt */
@NavDeepLinkDsl
/* loaded from: classes.dex */
public final class NavDeepLinkDslBuilder {
    private String action;
    private final NavDeepLink.Builder builder = new NavDeepLink.Builder();
    private String mimeType;
    private String uriPattern;

    public final NavDeepLink build$navigation_common_ktx_release() {
        NavDeepLink.Builder builder = this.builder;
        String str = this.uriPattern;
        if ((str == null && this.action == null && this.mimeType == null) ? false : true) {
            if (str != null) {
                builder.setUriPattern(str);
            }
            String str2 = this.action;
            if (str2 != null) {
                builder.setAction(str2);
            }
            String str3 = this.mimeType;
            if (str3 != null) {
                builder.setMimeType(str3);
            }
            NavDeepLink build = builder.build();
            j.b(build, "builder.apply {\n        …eType(it) }\n    }.build()");
            return build;
        }
        throw new IllegalStateException("The NavDeepLink must have an uri, action, and/or mimeType.".toString());
    }

    public final String getAction() {
        return this.action;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final String getUriPattern() {
        return this.uriPattern;
    }

    public final void setAction(String str) {
        if (str != null) {
            if (str.length() == 0) {
                throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
            }
        }
        this.action = str;
    }

    public final void setMimeType(String str) {
        this.mimeType = str;
    }

    public final void setUriPattern(String str) {
        this.uriPattern = str;
    }
}
