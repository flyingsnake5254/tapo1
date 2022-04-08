package com.tplink.libtpmediastatistics;

/* loaded from: classes3.dex */
public class ConnectionInfoVO {
    private BasicVO connectionBasicVO;
    private ConnectionVO localConnectionVO;
    private ConnectionVO p2pConnectionVO;
    private ConnectionVO relayConnectionVO;

    public BasicVO getConnectionBasicVO() {
        return this.connectionBasicVO;
    }

    public ConnectionVO getLocalConnectionVO() {
        if (this.localConnectionVO == null) {
            this.localConnectionVO = new ConnectionVO();
        }
        return this.localConnectionVO;
    }

    public ConnectionVO getP2pConnectionVO() {
        if (this.p2pConnectionVO == null) {
            this.p2pConnectionVO = new ConnectionVO();
        }
        return this.p2pConnectionVO;
    }

    public ConnectionVO getRelayConnectionVO() {
        if (this.relayConnectionVO == null) {
            this.relayConnectionVO = new ConnectionVO();
        }
        return this.relayConnectionVO;
    }

    public void setConnectionBasicVO(BasicVO basicVO) {
        this.connectionBasicVO = basicVO;
    }

    public void setLocalConnectionVO(ConnectionVO connectionVO) {
        this.localConnectionVO = connectionVO;
    }

    public void setP2pConnectionVO(ConnectionVO connectionVO) {
        this.p2pConnectionVO = connectionVO;
    }

    public void setRelayConnectionVO(ConnectionVO connectionVO) {
        this.relayConnectionVO = connectionVO;
    }

    public String toString() {
        return "ConnectionInfoVO{connectionBasicVO=" + this.connectionBasicVO + ", p2pConnectionVO=" + this.p2pConnectionVO + ", relayConnectionVO=" + this.relayConnectionVO + ", localConnectionVO=" + this.localConnectionVO + '}';
    }
}
