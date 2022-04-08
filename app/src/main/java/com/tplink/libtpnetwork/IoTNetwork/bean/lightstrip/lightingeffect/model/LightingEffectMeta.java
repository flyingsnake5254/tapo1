package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

import java.util.List;

/* loaded from: classes3.dex */
public class LightingEffectMeta {
    private String alias;
    private String imageUrl;
    private List<String> tags;

    /* loaded from: classes3.dex */
    public static final class LightingEffectMetaBuilder {
        private String alias;
        private String imageUrl;
        private List<String> tags;

        public LightingEffectMetaBuilder alias(String str) {
            this.alias = str;
            return this;
        }

        public LightingEffectMeta build() {
            LightingEffectMeta lightingEffectMeta = new LightingEffectMeta();
            lightingEffectMeta.setAlias(this.alias);
            lightingEffectMeta.setTags(this.tags);
            lightingEffectMeta.setImageUrl(this.imageUrl);
            return lightingEffectMeta;
        }

        public LightingEffectMetaBuilder imageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public LightingEffectMetaBuilder tags(List<String> list) {
            this.tags = list;
            return this;
        }

        private LightingEffectMetaBuilder() {
        }
    }

    public static LightingEffectMetaBuilder builder() {
        return new LightingEffectMetaBuilder();
    }

    public String getAlias() {
        return this.alias;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void merge() {
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }
}
