package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes;

/* loaded from: classes3.dex */
public class IntegerAttributeValue extends AbstractNumberAttributeValue<Integer> {
    private Integer absolute;
    private IntegerAttributeLimits limits;
    private IntegerRange range;

    /* loaded from: classes3.dex */
    public static final class Builder {
        private Integer absolute;
        private IntegerAttributeLimits limits;
        private IntegerRange range;

        public Builder absolute(Integer num) {
            this.absolute = num;
            return this;
        }

        public IntegerAttributeValue build() {
            return new IntegerAttributeValue(this);
        }

        public Builder limits(IntegerAttributeLimits integerAttributeLimits) {
            this.limits = integerAttributeLimits;
            return this;
        }

        public Builder range(IntegerRange integerRange) {
            this.range = integerRange;
            return this;
        }

        private Builder() {
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public void setLimits(AbstractNumberAttributeLimits<Integer> abstractNumberAttributeLimits) {
        this.limits = (IntegerAttributeLimits) abstractNumberAttributeLimits;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public void setRange(AbstractRange<Integer> abstractRange) {
        this.range = (IntegerRange) abstractRange;
    }

    public IntegerAttributeValue() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public Integer getAbsolute() {
        return this.absolute;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public AbstractNumberAttributeLimits<Integer> getLimits() {
        return this.limits;
    }

    @Override // com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.attributes.AbstractNumberAttributeValue
    public AbstractRange<Integer> getRange() {
        return this.range;
    }

    public void setAbsolute(Integer num) {
        this.absolute = num;
    }

    public void setLimits(IntegerAttributeLimits integerAttributeLimits) {
        this.limits = integerAttributeLimits;
    }

    public void setRange(IntegerRange integerRange) {
        this.range = integerRange;
    }

    private IntegerAttributeValue(Builder builder) {
        setAbsolute(builder.absolute);
        setRange(builder.range);
        setLimits(builder.limits);
    }
}
