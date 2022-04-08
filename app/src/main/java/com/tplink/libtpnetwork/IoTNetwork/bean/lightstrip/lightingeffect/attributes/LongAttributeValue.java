package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class LongAttributeValue extends AbstractNumberAttributeValue<Long> {
    private Long absolute;
    private LongAttributeLimits limits;
    private LongRange range;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Long absolute;
        private LongAttributeLimits limits;
        private LongRange range;

        public Builder absolute(Long l) {
            this.absolute = l;
            return this;
        }

        public LongAttributeValue build() {
            return new LongAttributeValue(this);
        }

        public Builder limits(LongAttributeLimits longAttributeLimits) {
            this.limits = longAttributeLimits;
            return this;
        }

        public Builder range(LongRange longRange) {
            this.range = longRange;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public void setLimits(AbstractNumberAttributeLimits<Long> abstractNumberAttributeLimits) {
        this.limits = (LongAttributeLimits) abstractNumberAttributeLimits;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public void setRange(AbstractRange<Long> abstractRange) {
        this.range = (LongRange) abstractRange;
    }

    public LongAttributeValue() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public Long getAbsolute() {
        return this.absolute;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public AbstractNumberAttributeLimits<Long> getLimits() {
        return this.limits;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public AbstractRange<Long> getRange() {
        return this.range;
    }

    public void setAbsolute(Long l) {
        this.absolute = l;
    }

    public void setLimits(LongAttributeLimits longAttributeLimits) {
        this.limits = longAttributeLimits;
    }

    public void setRange(LongRange longRange) {
        this.range = longRange;
    }

    private LongAttributeValue(Builder builder) {
        setAbsolute(builder.absolute);
        setRange(builder.range);
        setLimits(builder.limits);
    }
}
