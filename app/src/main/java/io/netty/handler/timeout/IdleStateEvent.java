package io.netty.handler.timeout;

import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

/* loaded from: classes3.dex */
public class IdleStateEvent {
    public static final IdleStateEvent ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_WRITER_IDLE_STATE_EVENT;
    public static final IdleStateEvent READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent WRITER_IDLE_STATE_EVENT;
    private final boolean first;
    private final IdleState state;

    /* loaded from: classes3.dex */
    private static final class DefaultIdleStateEvent extends IdleStateEvent {
        private final String representation;

        DefaultIdleStateEvent(IdleState idleState, boolean z) {
            super(idleState, z);
            StringBuilder sb = new StringBuilder();
            sb.append("IdleStateEvent(");
            sb.append(idleState);
            sb.append(z ? ", first" : "");
            sb.append(')');
            this.representation = sb.toString();
        }

        @Override // io.netty.handler.timeout.IdleStateEvent
        public String toString() {
            return this.representation;
        }
    }

    static {
        IdleState idleState = IdleState.READER_IDLE;
        FIRST_READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState, true);
        READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState, false);
        IdleState idleState2 = IdleState.WRITER_IDLE;
        FIRST_WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState2, true);
        WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState2, false);
        IdleState idleState3 = IdleState.ALL_IDLE;
        FIRST_ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState3, true);
        ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(idleState3, false);
    }

    protected IdleStateEvent(IdleState idleState, boolean z) {
        this.state = (IdleState) ObjectUtil.checkNotNull(idleState, DefaultStatesBean.KEY_STATE);
        this.first = z;
    }

    public boolean isFirst() {
        return this.first;
    }

    public IdleState state() {
        return this.state;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        sb.append(this.state);
        sb.append(this.first ? ", first" : "");
        sb.append(')');
        return sb.toString();
    }
}
