package com.google.thirdparty.publicsuffix;

import io.netty.util.internal.StringUtil;

/* loaded from: classes2.dex */
public enum PublicSuffixType {
    PRIVATE(':', StringUtil.COMMA),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    PublicSuffixType(char c2, char c3) {
        this.innerNodeCode = c2;
        this.leafNodeCode = c3;
    }

    static PublicSuffixType fromCode(char c2) {
        PublicSuffixType[] values;
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c2 || publicSuffixType.getLeafNodeCode() == c2) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c2);
    }

    static PublicSuffixType fromIsPrivate(boolean z) {
        return z ? PRIVATE : REGISTRY;
    }

    char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    char getLeafNodeCode() {
        return this.leafNodeCode;
    }
}
