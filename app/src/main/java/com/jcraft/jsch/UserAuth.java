package com.jcraft.jsch;

/* loaded from: classes2.dex */
public abstract class UserAuth {
    protected static final int SSH_MSG_USERAUTH_BANNER = 53;
    protected static final int SSH_MSG_USERAUTH_FAILURE = 51;
    protected static final int SSH_MSG_USERAUTH_INFO_REQUEST = 60;
    protected static final int SSH_MSG_USERAUTH_INFO_RESPONSE = 61;
    protected static final int SSH_MSG_USERAUTH_PK_OK = 60;
    protected static final int SSH_MSG_USERAUTH_REQUEST = 50;
    protected static final int SSH_MSG_USERAUTH_SUCCESS = 52;
    protected Buffer buf;
    protected Packet packet;
    protected UserInfo userinfo;
    protected String username;

    public boolean start(Session session) throws Exception {
        this.userinfo = session.getUserInfo();
        Packet packet = session.packet;
        this.packet = packet;
        this.buf = packet.getBuffer();
        this.username = session.getUserName();
        return true;
    }
}
