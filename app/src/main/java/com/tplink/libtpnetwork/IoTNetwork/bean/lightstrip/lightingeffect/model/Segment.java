package com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.lightingeffect.model;

/* loaded from: classes3.dex */
public class Segment {
    private Integer end;
    private LightingEffectSettings initialState;
    private Integer start;

    /* loaded from: classes3.dex */
    public static final class SegmentBuilder {
        private Integer end;
        private LightingEffectSettings initialState;
        private Integer start;

        public Segment build() {
            Segment segment = new Segment();
            segment.setStart(this.start);
            segment.setEnd(this.end);
            segment.setInitialState(this.initialState);
            return segment;
        }

        public SegmentBuilder end(Integer num) {
            this.end = num;
            return this;
        }

        public SegmentBuilder initialState(LightingEffectSettings lightingEffectSettings) {
            this.initialState = lightingEffectSettings;
            return this;
        }

        public SegmentBuilder start(Integer num) {
            this.start = num;
            return this;
        }

        private SegmentBuilder() {
        }
    }

    public static SegmentBuilder builder() {
        return new SegmentBuilder();
    }

    public Integer getEnd() {
        return this.end;
    }

    public LightingEffectSettings getInitialState() {
        return this.initialState;
    }

    public Integer getStart() {
        return this.start;
    }

    public void setEnd(Integer num) {
        this.end = num;
    }

    public void setInitialState(LightingEffectSettings lightingEffectSettings) {
        this.initialState = lightingEffectSettings;
    }

    public void setStart(Integer num) {
        this.start = num;
    }
}
