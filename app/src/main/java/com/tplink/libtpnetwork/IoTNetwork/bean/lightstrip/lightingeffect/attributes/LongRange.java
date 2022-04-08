package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class LongRange extends AbstractRange<Long> {
    private Long from;
    private Long to;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Long from;
        private Long to;

        public LongRange build() {
            return new LongRange(this);
        }

        public Builder from(Long l) {
            this.from = l;
            return this;
        }

        public Builder to(Long l) {
            this.to = l;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public LongRange() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractRange
    public Long getFrom() {
        return this.from;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractRange
    public Long getTo() {
        return this.to;
    }

    public void setFrom(Long l) {
        this.from = l;
    }

    public void setTo(Long l) {
        this.to = l;
    }

    private LongRange(Builder builder) {
        setFrom(builder.from);
        setTo(builder.to);
    }
}
