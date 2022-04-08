package com.jcraft.jsch;

import com.jcraft.jsch.ConfigRepository;
import com.jcraft.jsch.IdentityRepository;
import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;

/* loaded from: classes2.dex */
public class Session implements Runnable {
    private static final int PACKET_MAX_SIZE = 262144;
    static final int SSH_MSG_CHANNEL_CLOSE = 97;
    static final int SSH_MSG_CHANNEL_DATA = 94;
    static final int SSH_MSG_CHANNEL_EOF = 96;
    static final int SSH_MSG_CHANNEL_EXTENDED_DATA = 95;
    static final int SSH_MSG_CHANNEL_FAILURE = 100;
    static final int SSH_MSG_CHANNEL_OPEN = 90;
    static final int SSH_MSG_CHANNEL_OPEN_CONFIRMATION = 91;
    static final int SSH_MSG_CHANNEL_OPEN_FAILURE = 92;
    static final int SSH_MSG_CHANNEL_REQUEST = 98;
    static final int SSH_MSG_CHANNEL_SUCCESS = 99;
    static final int SSH_MSG_CHANNEL_WINDOW_ADJUST = 93;
    static final int SSH_MSG_DEBUG = 4;
    static final int SSH_MSG_DISCONNECT = 1;
    static final int SSH_MSG_GLOBAL_REQUEST = 80;
    static final int SSH_MSG_IGNORE = 2;
    static final int SSH_MSG_KEXDH_INIT = 30;
    static final int SSH_MSG_KEXDH_REPLY = 31;
    static final int SSH_MSG_KEXINIT = 20;
    static final int SSH_MSG_KEX_DH_GEX_GROUP = 31;
    static final int SSH_MSG_KEX_DH_GEX_INIT = 32;
    static final int SSH_MSG_KEX_DH_GEX_REPLY = 33;
    static final int SSH_MSG_KEX_DH_GEX_REQUEST = 34;
    static final int SSH_MSG_NEWKEYS = 21;
    static final int SSH_MSG_REQUEST_FAILURE = 82;
    static final int SSH_MSG_REQUEST_SUCCESS = 81;
    static final int SSH_MSG_SERVICE_ACCEPT = 6;
    static final int SSH_MSG_SERVICE_REQUEST = 5;
    static final int SSH_MSG_UNIMPLEMENTED = 3;
    static final int buffer_margin = 128;
    private static final byte[] keepalivemsg = Util.str2byte("keepalive@jcraft.com");
    private static final byte[] nomoresessions = Util.str2byte("no-more-sessions@openssh.com");
    static Random random;
    private byte[] Ec2s;
    private byte[] Es2c;
    private byte[] IVc2s;
    private byte[] IVs2c;
    private byte[] I_C;
    private byte[] I_S;
    private byte[] K_S;
    private byte[] MACc2s;
    private byte[] MACs2c;
    private byte[] V_S;
    private Cipher c2scipher;
    private MAC c2smac;
    private Compression deflater;
    String host;
    private Compression inflater;

    /* renamed from: io  reason: collision with root package name */
    private IO f5110io;
    JSch jsch;
    String org_host;
    int port;
    private Cipher s2ccipher;
    private MAC s2cmac;
    private byte[] s2cmac_result1;
    private byte[] s2cmac_result2;
    private byte[] session_id;
    private Socket socket;
    Runnable thread;
    private UserInfo userinfo;
    String username;
    private byte[] V_C = Util.str2byte("SSH-2.0-JSCH-0.1.54");
    private int seqi = 0;
    private int seqo = 0;
    String[] guess = null;
    private int timeout = 0;
    private volatile boolean isConnected = false;
    private boolean isAuthed = false;
    private Thread connectThread = null;
    private Object lock = new Object();
    boolean x11_forwarding = false;
    boolean agent_forwarding = false;
    InputStream in = null;
    OutputStream out = null;
    SocketFactory socket_factory = null;
    private Hashtable config = null;
    private Proxy proxy = null;
    private String hostKeyAlias = null;
    private int serverAliveInterval = 0;
    private int serverAliveCountMax = 1;
    private IdentityRepository identityRepository = null;
    private HostKeyRepository hostkeyRepository = null;
    protected boolean daemon_thread = false;
    private long kex_start_time = 0;
    int max_auth_tries = 6;
    int auth_failures = 0;
    byte[] password = null;
    private volatile boolean in_kex = false;
    private volatile boolean in_prompt = false;
    int[] uncompress_len = new int[1];
    int[] compress_len = new int[1];
    private int s2ccipher_size = 8;
    private int c2scipher_size = 8;
    private GlobalRequestReply grr = new GlobalRequestReply();
    private HostKey hostkey = null;
    Buffer buf = new Buffer();
    Packet packet = new Packet(this.buf);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Forwarding {
        String bind_address;
        String host;
        int hostport;
        int port;

        private Forwarding() {
            this.bind_address = null;
            this.port = -1;
            this.host = null;
            this.hostport = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class GlobalRequestReply {
        private int port;
        private int reply;
        private Thread thread;

        private GlobalRequestReply() {
            this.thread = null;
            this.reply = -1;
            this.port = 0;
        }

        int getPort() {
            return this.port;
        }

        int getReply() {
            return this.reply;
        }

        Thread getThread() {
            return this.thread;
        }

        void setPort(int i) {
            this.port = i;
        }

        void setReply(int i) {
            this.reply = i;
        }

        void setThread(Thread thread) {
            this.thread = thread;
            this.reply = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Session(JSch jSch, String str, String str2, int i) throws JSchException {
        this.host = "127.0.0.1";
        this.org_host = "127.0.0.1";
        this.port = 22;
        this.username = null;
        this.jsch = jSch;
        this.username = str;
        this.host = str2;
        this.org_host = str2;
        this.port = i;
        applyConfig();
        if (this.username == null) {
            try {
                this.username = (String) System.getProperties().get("user.name");
            } catch (SecurityException unused) {
            }
        }
        if (this.username == null) {
            throw new JSchException("username is not given.");
        }
    }

    private int _setPortForwardingR(String str, int i) throws JSchException {
        int port;
        synchronized (this.grr) {
            Buffer buffer = new Buffer(100);
            Packet packet = new Packet(buffer);
            String normalize = ChannelForwardedTCPIP.normalize(str);
            this.grr.setThread(Thread.currentThread());
            this.grr.setPort(i);
            try {
                packet.reset();
                buffer.putByte((byte) 80);
                buffer.putString(Util.str2byte("tcpip-forward"));
                buffer.putByte((byte) 1);
                buffer.putString(Util.str2byte(normalize));
                buffer.putInt(i);
                write(packet);
                int i2 = 0;
                int reply = this.grr.getReply();
                while (i2 < 10 && reply == -1) {
                    try {
                        Thread.sleep(1000L);
                    } catch (Exception unused) {
                    }
                    i2++;
                    reply = this.grr.getReply();
                }
                this.grr.setThread(null);
                if (reply == 1) {
                    port = this.grr.getPort();
                } else {
                    throw new JSchException("remote port forwarding failed for listen port " + i);
                }
            } catch (Exception e2) {
                this.grr.setThread(null);
                throw new JSchException(e2.toString(), e2);
            }
        }
        return port;
    }

    private void _write(Packet packet) throws Exception {
        synchronized (this.lock) {
            encode(packet);
            IO io2 = this.f5110io;
            if (io2 != null) {
                io2.put(packet);
                this.seqo++;
            }
        }
    }

    private void applyConfig() throws JSchException {
        String user;
        ConfigRepository configRepository = this.jsch.getConfigRepository();
        if (configRepository != null) {
            ConfigRepository.Config config = configRepository.getConfig(this.org_host);
            if (this.username == null && (user = config.getUser()) != null) {
                this.username = user;
            }
            String hostname = config.getHostname();
            if (hostname != null) {
                this.host = hostname;
            }
            int port = config.getPort();
            if (port != -1) {
                this.port = port;
            }
            checkConfig(config, "kex");
            checkConfig(config, "server_host_key");
            checkConfig(config, "cipher.c2s");
            checkConfig(config, "cipher.s2c");
            checkConfig(config, "mac.c2s");
            checkConfig(config, "mac.s2c");
            checkConfig(config, "compression.c2s");
            checkConfig(config, "compression.s2c");
            checkConfig(config, "compression_level");
            checkConfig(config, "StrictHostKeyChecking");
            checkConfig(config, "HashKnownHosts");
            checkConfig(config, "PreferredAuthentications");
            checkConfig(config, "MaxAuthTries");
            checkConfig(config, "ClearAllForwardings");
            String value = config.getValue("HostKeyAlias");
            if (value != null) {
                setHostKeyAlias(value);
            }
            String value2 = config.getValue("UserKnownHostsFile");
            if (value2 != null) {
                KnownHosts knownHosts = new KnownHosts(this.jsch);
                knownHosts.setKnownHosts(value2);
                setHostKeyRepository(knownHosts);
            }
            String[] values = config.getValues("IdentityFile");
            if (values != null) {
                Object[] values2 = configRepository.getConfig("").getValues("IdentityFile");
                if (values2 != null) {
                    for (String str : values2) {
                        this.jsch.addIdentity(str);
                    }
                } else {
                    values2 = new String[0];
                }
                if (values.length - values2.length > 0) {
                    IdentityRepository.Wrapper wrapper = new IdentityRepository.Wrapper(this.jsch.getIdentityRepository(), true);
                    for (String str2 : values) {
                        int i = 0;
                        while (true) {
                            if (i >= values2.length) {
                                break;
                            }
                            if (str2.equals(values2[i])) {
                                str2 = null;
                                break;
                            }
                            i++;
                        }
                        if (str2 != null) {
                            wrapper.add(IdentityFile.newInstance(str2, null, this.jsch));
                        }
                    }
                    setIdentityRepository(wrapper);
                }
            }
            String value3 = config.getValue("ServerAliveInterval");
            if (value3 != null) {
                try {
                    setServerAliveInterval(Integer.parseInt(value3));
                } catch (NumberFormatException unused) {
                }
            }
            String value4 = config.getValue("ConnectTimeout");
            if (value4 != null) {
                try {
                    setTimeout(Integer.parseInt(value4));
                } catch (NumberFormatException unused2) {
                }
            }
            String value5 = config.getValue("MaxAuthTries");
            if (value5 != null) {
                setConfig("MaxAuthTries", value5);
            }
            String value6 = config.getValue("ClearAllForwardings");
            if (value6 != null) {
                setConfig("ClearAllForwardings", value6);
            }
        }
    }

    private void applyConfigChannel(ChannelSession channelSession) throws JSchException {
        ConfigRepository configRepository = this.jsch.getConfigRepository();
        if (configRepository != null) {
            ConfigRepository.Config config = configRepository.getConfig(this.org_host);
            String value = config.getValue("ForwardAgent");
            if (value != null) {
                channelSession.setAgentForwarding(value.equals("yes"));
            }
            String value2 = config.getValue("RequestTTY");
            if (value2 != null) {
                channelSession.setPty(value2.equals("yes"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkCipher(String str) {
        try {
            Cipher cipher = (Cipher) Class.forName(str).newInstance();
            cipher.init(0, new byte[cipher.getBlockSize()], new byte[cipher.getIVSize()]);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private String[] checkCiphers(String str) {
        String[] split;
        String[] strArr = null;
        if (!(str == null || str.length() == 0)) {
            if (JSch.getLogger().isEnabled(1)) {
                JSch.getLogger().log(1, "CheckCiphers: " + str);
            }
            String config = getConfig("cipher.c2s");
            String config2 = getConfig("cipher.s2c");
            Vector vector = new Vector();
            for (String str2 : Util.split(str, SSLClient.COMMA)) {
                if (!(config2.indexOf(str2) == -1 && config.indexOf(str2) == -1) && !checkCipher(getConfig(str2))) {
                    vector.addElement(str2);
                }
            }
            if (vector.size() == 0) {
                return null;
            }
            int size = vector.size();
            strArr = new String[size];
            System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
            if (JSch.getLogger().isEnabled(1)) {
                for (int i = 0; i < size; i++) {
                    JSch.getLogger().log(1, strArr[i] + " is not available.");
                }
            }
        }
        return strArr;
    }

    private void checkConfig(ConfigRepository.Config config, String str) {
        String value = config.getValue(str);
        if (value != null) {
            setConfig(str, value);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void checkHost(java.lang.String r12, int r13, com.jcraft.jsch.KeyExchange r14) throws com.jcraft.jsch.JSchException {
        /*
            Method dump skipped, instructions count: 789
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.checkHost(java.lang.String, int, com.jcraft.jsch.KeyExchange):void");
    }

    static boolean checkKex(Session session, String str) {
        try {
            ((KeyExchange) Class.forName(str).newInstance()).init(session, null, null, null, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private String[] checkKexes(String str) {
        String[] strArr = null;
        if (!(str == null || str.length() == 0)) {
            if (JSch.getLogger().isEnabled(1)) {
                Logger logger = JSch.getLogger();
                logger.log(1, "CheckKexes: " + str);
            }
            Vector vector = new Vector();
            String[] split = Util.split(str, SSLClient.COMMA);
            for (int i = 0; i < split.length; i++) {
                if (!checkKex(this, getConfig(split[i]))) {
                    vector.addElement(split[i]);
                }
            }
            if (vector.size() == 0) {
                return null;
            }
            int size = vector.size();
            strArr = new String[size];
            System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
            if (JSch.getLogger().isEnabled(1)) {
                for (int i2 = 0; i2 < size; i2++) {
                    Logger logger2 = JSch.getLogger();
                    logger2.log(1, strArr[i2] + " is not available.");
                }
            }
        }
        return strArr;
    }

    private String[] checkSignatures(String str) {
        String[] strArr = null;
        if (!(str == null || str.length() == 0)) {
            if (JSch.getLogger().isEnabled(1)) {
                Logger logger = JSch.getLogger();
                logger.log(1, "CheckSignatures: " + str);
            }
            Vector vector = new Vector();
            String[] split = Util.split(str, SSLClient.COMMA);
            for (int i = 0; i < split.length; i++) {
                try {
                    ((Signature) Class.forName(JSch.getConfig(split[i])).newInstance()).init();
                } catch (Exception unused) {
                    vector.addElement(split[i]);
                }
            }
            if (vector.size() == 0) {
                return null;
            }
            int size = vector.size();
            strArr = new String[size];
            System.arraycopy(vector.toArray(), 0, strArr, 0, vector.size());
            if (JSch.getLogger().isEnabled(1)) {
                for (int i2 = 0; i2 < size; i2++) {
                    Logger logger2 = JSch.getLogger();
                    logger2.log(1, strArr[i2] + " is not available.");
                }
            }
        }
        return strArr;
    }

    private byte[] expandKey(Buffer buffer, byte[] bArr, byte[] bArr2, byte[] bArr3, HASH hash, int i) throws Exception {
        int blockSize = hash.getBlockSize();
        while (bArr3.length < i) {
            buffer.reset();
            buffer.putMPInt(bArr);
            buffer.putByte(bArr2);
            buffer.putByte(bArr3);
            hash.update(buffer.buffer, 0, buffer.index);
            byte[] bArr4 = new byte[bArr3.length + blockSize];
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            System.arraycopy(hash.digest(), 0, bArr4, bArr3.length, blockSize);
            Util.bzero(bArr3);
            bArr3 = bArr4;
        }
        return bArr3;
    }

    private void initDeflater(String str) throws JSchException {
        if (str.equals("none")) {
            this.deflater = null;
            return;
        }
        String config = getConfig(str);
        if (config == null) {
            return;
        }
        if (str.equals("zlib") || (this.isAuthed && str.equals("zlib@openssh.com"))) {
            try {
                try {
                    this.deflater = (Compression) Class.forName(config).newInstance();
                    int i = 6;
                    try {
                        i = Integer.parseInt(getConfig("compression_level"));
                    } catch (Exception unused) {
                    }
                    this.deflater.init(1, i);
                } catch (NoClassDefFoundError e2) {
                    throw new JSchException(e2.toString(), e2);
                }
            } catch (Exception e3) {
                throw new JSchException(e3.toString(), e3);
            }
        }
    }

    private void initInflater(String str) throws JSchException {
        if (str.equals("none")) {
            this.inflater = null;
            return;
        }
        String config = getConfig(str);
        if (config == null) {
            return;
        }
        if (str.equals("zlib") || (this.isAuthed && str.equals("zlib@openssh.com"))) {
            try {
                Compression compression = (Compression) Class.forName(config).newInstance();
                this.inflater = compression;
                compression.init(0, 0);
            } catch (Exception e2) {
                throw new JSchException(e2.toString(), e2);
            }
        }
    }

    private Forwarding parseForwarding(String str) throws JSchException {
        String[] split = str.split(SSLClient.WHITE_SPACE);
        if (split.length > 1) {
            Vector vector = new Vector();
            for (int i = 0; i < split.length; i++) {
                if (split[i].length() != 0) {
                    vector.addElement(split[i].trim());
                }
            }
            StringBuffer stringBuffer = new StringBuffer();
            int i2 = 0;
            while (i2 < vector.size()) {
                stringBuffer.append((String) vector.elementAt(i2));
                i2++;
                if (i2 < vector.size()) {
                    stringBuffer.append(SSLClient.COLON);
                }
            }
            str = stringBuffer.toString();
        }
        Forwarding forwarding = new Forwarding();
        try {
            if (str.lastIndexOf(SSLClient.COLON) != -1) {
                forwarding.hostport = Integer.parseInt(str.substring(str.lastIndexOf(SSLClient.COLON) + 1));
                String substring = str.substring(0, str.lastIndexOf(SSLClient.COLON));
                if (substring.lastIndexOf(SSLClient.COLON) != -1) {
                    forwarding.host = substring.substring(substring.lastIndexOf(SSLClient.COLON) + 1);
                    String substring2 = substring.substring(0, substring.lastIndexOf(SSLClient.COLON));
                    String str2 = "127.0.0.1";
                    if (substring2.lastIndexOf(SSLClient.COLON) != -1) {
                        forwarding.port = Integer.parseInt(substring2.substring(substring2.lastIndexOf(SSLClient.COLON) + 1));
                        String substring3 = substring2.substring(0, substring2.lastIndexOf(SSLClient.COLON));
                        if (substring3.length() == 0 || substring3.equals(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD)) {
                            substring3 = "0.0.0.0";
                        }
                        if (!substring3.equals("localhost")) {
                            str2 = substring3;
                        }
                        forwarding.bind_address = str2;
                    } else {
                        forwarding.port = Integer.parseInt(substring2);
                        forwarding.bind_address = str2;
                    }
                    return forwarding;
                }
                throw new JSchException("parseForwarding: " + str);
            }
            throw new JSchException("parseForwarding: " + str);
        } catch (NumberFormatException e2) {
            throw new JSchException("parseForwarding: " + e2.toString());
        }
    }

    private KeyExchange receive_kexinit(Buffer buffer) throws Exception {
        int i = buffer.getInt();
        if (i != buffer.getLength()) {
            buffer.getByte();
            this.I_S = new byte[buffer.index - 5];
        } else {
            this.I_S = new byte[(i - 1) - buffer.getByte()];
        }
        byte[] bArr = buffer.buffer;
        int i2 = buffer.s;
        byte[] bArr2 = this.I_S;
        System.arraycopy(bArr, i2, bArr2, 0, bArr2.length);
        if (!this.in_kex) {
            send_kexinit();
        }
        String[] guess = KeyExchange.guess(this.I_S, this.I_C);
        this.guess = guess;
        if (guess == null) {
            throw new JSchException("Algorithm negotiation fail");
        } else if (this.isAuthed || (!guess[2].equals("none") && !this.guess[3].equals("none"))) {
            try {
                KeyExchange keyExchange = (KeyExchange) Class.forName(getConfig(this.guess[0])).newInstance();
                keyExchange.init(this, this.V_S, this.V_C, this.I_S, this.I_C);
                return keyExchange;
            } catch (Exception e2) {
                throw new JSchException(e2.toString(), e2);
            }
        } else {
            throw new JSchException("NONE Cipher should not be chosen before authentification is successed.");
        }
    }

    private void receive_newkeys(Buffer buffer, KeyExchange keyExchange) throws Exception {
        updateKeys(keyExchange);
        this.in_kex = false;
    }

    private void requestPortForwarding() throws JSchException {
        ConfigRepository configRepository;
        if (!getConfig("ClearAllForwardings").equals("yes") && (configRepository = this.jsch.getConfigRepository()) != null) {
            ConfigRepository.Config config = configRepository.getConfig(this.org_host);
            String[] values = config.getValues("LocalForward");
            if (values != null) {
                for (String str : values) {
                    setPortForwardingL(str);
                }
            }
            String[] values2 = config.getValues("RemoteForward");
            if (values2 != null) {
                for (String str2 : values2) {
                    setPortForwardingR(str2);
                }
            }
        }
    }

    private void send_kexinit() throws Exception {
        if (!this.in_kex) {
            String config = getConfig("cipher.c2s");
            String config2 = getConfig("cipher.s2c");
            String[] checkCiphers = checkCiphers(getConfig("CheckCiphers"));
            if (checkCiphers != null && checkCiphers.length > 0) {
                config = Util.diffString(config, checkCiphers);
                config2 = Util.diffString(config2, checkCiphers);
                if (config == null || config2 == null) {
                    throw new JSchException("There are not any available ciphers.");
                }
            }
            String config3 = getConfig("kex");
            String[] checkKexes = checkKexes(getConfig("CheckKexes"));
            if (checkKexes == null || checkKexes.length <= 0 || (config3 = Util.diffString(config3, checkKexes)) != null) {
                String config4 = getConfig("server_host_key");
                String[] checkSignatures = checkSignatures(getConfig("CheckSignatures"));
                if (checkSignatures == null || checkSignatures.length <= 0 || (config4 = Util.diffString(config4, checkSignatures)) != null) {
                    this.in_kex = true;
                    this.kex_start_time = System.currentTimeMillis();
                    Buffer buffer = new Buffer();
                    Packet packet = new Packet(buffer);
                    packet.reset();
                    buffer.putByte(BinaryMemcacheOpcodes.DELETEQ);
                    synchronized (random) {
                        random.fill(buffer.buffer, buffer.index, 16);
                        buffer.skip(16);
                    }
                    buffer.putString(Util.str2byte(config3));
                    buffer.putString(Util.str2byte(config4));
                    buffer.putString(Util.str2byte(config));
                    buffer.putString(Util.str2byte(config2));
                    buffer.putString(Util.str2byte(getConfig("mac.c2s")));
                    buffer.putString(Util.str2byte(getConfig("mac.s2c")));
                    buffer.putString(Util.str2byte(getConfig("compression.c2s")));
                    buffer.putString(Util.str2byte(getConfig("compression.s2c")));
                    buffer.putString(Util.str2byte(getConfig("lang.c2s")));
                    buffer.putString(Util.str2byte(getConfig("lang.s2c")));
                    buffer.putByte((byte) 0);
                    buffer.putInt(0);
                    buffer.setOffSet(5);
                    byte[] bArr = new byte[buffer.getLength()];
                    this.I_C = bArr;
                    buffer.getByte(bArr);
                    write(packet);
                    if (JSch.getLogger().isEnabled(1)) {
                        JSch.getLogger().log(1, "SSH_MSG_KEXINIT sent");
                        return;
                    }
                    return;
                }
                throw new JSchException("There are not any available sig algorithm.");
            }
            throw new JSchException("There are not any available kexes.");
        }
    }

    private void send_newkeys() throws Exception {
        this.packet.reset();
        this.buf.putByte(BinaryMemcacheOpcodes.INCREMENTQ);
        write(this.packet);
        if (JSch.getLogger().isEnabled(1)) {
            JSch.getLogger().log(1, "SSH_MSG_NEWKEYS sent");
        }
    }

    private void start_discard(Buffer buffer, Cipher cipher, MAC mac, int i, int i2) throws JSchException, IOException {
        if (cipher.isCBC()) {
            if (i == 262144 || mac == null) {
                mac = null;
            }
            int i3 = i2 - buffer.index;
            while (i3 > 0) {
                buffer.reset();
                byte[] bArr = buffer.buffer;
                int length = i3 > bArr.length ? bArr.length : i3;
                this.f5110io.getByte(bArr, 0, length);
                if (mac != null) {
                    mac.update(buffer.buffer, 0, length);
                }
                i3 -= length;
            }
            if (mac != null) {
                mac.doFinal(buffer.buffer, 0);
            }
            throw new JSchException("Packet corrupt");
        }
        throw new JSchException("Packet corrupt");
    }

    private void updateKeys(KeyExchange keyExchange) throws Exception {
        byte[] bArr;
        byte[] k = keyExchange.getK();
        byte[] h = keyExchange.getH();
        HASH hash = keyExchange.getHash();
        if (this.session_id == null) {
            byte[] bArr2 = new byte[h.length];
            this.session_id = bArr2;
            System.arraycopy(h, 0, bArr2, 0, h.length);
        }
        this.buf.reset();
        this.buf.putMPInt(k);
        this.buf.putByte(h);
        this.buf.putByte((byte) 65);
        this.buf.putByte(this.session_id);
        Buffer buffer = this.buf;
        hash.update(buffer.buffer, 0, buffer.index);
        this.IVc2s = hash.digest();
        Buffer buffer2 = this.buf;
        int i = buffer2.index;
        int length = (i - this.session_id.length) - 1;
        byte[] bArr3 = buffer2.buffer;
        bArr3[length] = (byte) (bArr3[length] + 1);
        hash.update(bArr3, 0, i);
        this.IVs2c = hash.digest();
        Buffer buffer3 = this.buf;
        byte[] bArr4 = buffer3.buffer;
        bArr4[length] = (byte) (bArr4[length] + 1);
        hash.update(bArr4, 0, buffer3.index);
        this.Ec2s = hash.digest();
        Buffer buffer4 = this.buf;
        byte[] bArr5 = buffer4.buffer;
        bArr5[length] = (byte) (bArr5[length] + 1);
        hash.update(bArr5, 0, buffer4.index);
        this.Es2c = hash.digest();
        Buffer buffer5 = this.buf;
        byte[] bArr6 = buffer5.buffer;
        bArr6[length] = (byte) (bArr6[length] + 1);
        hash.update(bArr6, 0, buffer5.index);
        this.MACc2s = hash.digest();
        Buffer buffer6 = this.buf;
        byte[] bArr7 = buffer6.buffer;
        bArr7[length] = (byte) (bArr7[length] + 1);
        hash.update(bArr7, 0, buffer6.index);
        this.MACs2c = hash.digest();
        try {
            this.s2ccipher = (Cipher) Class.forName(getConfig(this.guess[3])).newInstance();
            while (true) {
                int blockSize = this.s2ccipher.getBlockSize();
                bArr = this.Es2c;
                if (blockSize <= bArr.length) {
                    break;
                }
                this.buf.reset();
                this.buf.putMPInt(k);
                this.buf.putByte(h);
                this.buf.putByte(this.Es2c);
                Buffer buffer7 = this.buf;
                hash.update(buffer7.buffer, 0, buffer7.index);
                byte[] digest = hash.digest();
                byte[] bArr8 = this.Es2c;
                byte[] bArr9 = new byte[bArr8.length + digest.length];
                System.arraycopy(bArr8, 0, bArr9, 0, bArr8.length);
                System.arraycopy(digest, 0, bArr9, this.Es2c.length, digest.length);
                this.Es2c = bArr9;
            }
            this.s2ccipher.init(1, bArr, this.IVs2c);
            this.s2ccipher_size = this.s2ccipher.getIVSize();
            MAC mac = (MAC) Class.forName(getConfig(this.guess[5])).newInstance();
            this.s2cmac = mac;
            byte[] expandKey = expandKey(this.buf, k, h, this.MACs2c, hash, mac.getBlockSize());
            this.MACs2c = expandKey;
            this.s2cmac.init(expandKey);
            this.s2cmac_result1 = new byte[this.s2cmac.getBlockSize()];
            this.s2cmac_result2 = new byte[this.s2cmac.getBlockSize()];
            this.c2scipher = (Cipher) Class.forName(getConfig(this.guess[2])).newInstance();
            while (true) {
                int blockSize2 = this.c2scipher.getBlockSize();
                byte[] bArr10 = this.Ec2s;
                if (blockSize2 > bArr10.length) {
                    this.buf.reset();
                    this.buf.putMPInt(k);
                    this.buf.putByte(h);
                    this.buf.putByte(this.Ec2s);
                    Buffer buffer8 = this.buf;
                    hash.update(buffer8.buffer, 0, buffer8.index);
                    byte[] digest2 = hash.digest();
                    byte[] bArr11 = this.Ec2s;
                    byte[] bArr12 = new byte[bArr11.length + digest2.length];
                    System.arraycopy(bArr11, 0, bArr12, 0, bArr11.length);
                    System.arraycopy(digest2, 0, bArr12, this.Ec2s.length, digest2.length);
                    this.Ec2s = bArr12;
                } else {
                    this.c2scipher.init(0, bArr10, this.IVc2s);
                    this.c2scipher_size = this.c2scipher.getIVSize();
                    MAC mac2 = (MAC) Class.forName(getConfig(this.guess[4])).newInstance();
                    this.c2smac = mac2;
                    byte[] expandKey2 = expandKey(this.buf, k, h, this.MACc2s, hash, mac2.getBlockSize());
                    this.MACc2s = expandKey2;
                    this.c2smac.init(expandKey2);
                    initDeflater(this.guess[6]);
                    initInflater(this.guess[7]);
                    return;
                }
            }
        } catch (Exception e2) {
            if (e2 instanceof JSchException) {
                throw e2;
            }
            throw new JSchException(e2.toString(), e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addChannel(Channel channel) {
        channel.setSession(this);
    }

    public void connect() throws JSchException {
        connect(this.timeout);
    }

    public void delPortForwardingL(int i) throws JSchException {
        delPortForwardingL("127.0.0.1", i);
    }

    public void delPortForwardingR(int i) throws JSchException {
        delPortForwardingR(null, i);
    }

    public void disconnect() {
        if (this.isConnected) {
            if (JSch.getLogger().isEnabled(1)) {
                Logger logger = JSch.getLogger();
                logger.log(1, "Disconnecting from " + this.host + " port " + this.port);
            }
            Channel.disconnect(this);
            this.isConnected = false;
            PortWatcher.delPort(this);
            ChannelForwardedTCPIP.delPort(this);
            ChannelX11.removeFakedCookie(this);
            synchronized (this.lock) {
                if (this.connectThread != null) {
                    Thread.yield();
                    this.connectThread.interrupt();
                    this.connectThread = null;
                }
            }
            this.thread = null;
            try {
                IO io2 = this.f5110io;
                if (io2 != null) {
                    InputStream inputStream = io2.in;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    OutputStream outputStream = this.f5110io.out;
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    OutputStream outputStream2 = this.f5110io.out_ext;
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                }
                Proxy proxy = this.proxy;
                if (proxy == null) {
                    Socket socket = this.socket;
                    if (socket != null) {
                        socket.close();
                    }
                } else {
                    synchronized (proxy) {
                        this.proxy.close();
                    }
                    this.proxy = null;
                }
            } catch (Exception unused) {
            }
            this.f5110io = null;
            this.socket = null;
            this.jsch.removeSession(this);
        }
    }

    public void encode(Packet packet) throws Exception {
        Compression compression = this.deflater;
        if (compression != null) {
            int[] iArr = this.compress_len;
            Buffer buffer = packet.buffer;
            iArr[0] = buffer.index;
            buffer.buffer = compression.compress(buffer.buffer, 5, iArr);
            packet.buffer.index = this.compress_len[0];
        }
        if (this.c2scipher != null) {
            packet.padding(this.c2scipher_size);
            byte b2 = packet.buffer.buffer[4];
            synchronized (random) {
                Random random2 = random;
                Buffer buffer2 = packet.buffer;
                random2.fill(buffer2.buffer, buffer2.index - b2, b2);
            }
        } else {
            packet.padding(8);
        }
        MAC mac = this.c2smac;
        if (mac != null) {
            mac.update(this.seqo);
            MAC mac2 = this.c2smac;
            Buffer buffer3 = packet.buffer;
            mac2.update(buffer3.buffer, 0, buffer3.index);
            MAC mac3 = this.c2smac;
            Buffer buffer4 = packet.buffer;
            mac3.doFinal(buffer4.buffer, buffer4.index);
        }
        Cipher cipher = this.c2scipher;
        if (cipher != null) {
            Buffer buffer5 = packet.buffer;
            byte[] bArr = buffer5.buffer;
            cipher.update(bArr, 0, buffer5.index, bArr, 0);
        }
        MAC mac4 = this.c2smac;
        if (mac4 != null) {
            packet.buffer.skip(mac4.getBlockSize());
        }
    }

    public String getClientVersion() {
        return Util.byte2str(this.V_C);
    }

    public String getConfig(String str) {
        Hashtable hashtable = this.config;
        if (hashtable != null) {
            Object obj = hashtable.get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        String config = JSch.getConfig(str);
        if (config instanceof String) {
            return config;
        }
        return null;
    }

    public String getHost() {
        return this.host;
    }

    public HostKey getHostKey() {
        return this.hostkey;
    }

    public String getHostKeyAlias() {
        return this.hostKeyAlias;
    }

    public HostKeyRepository getHostKeyRepository() {
        HostKeyRepository hostKeyRepository = this.hostkeyRepository;
        return hostKeyRepository == null ? this.jsch.getHostKeyRepository() : hostKeyRepository;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdentityRepository getIdentityRepository() {
        IdentityRepository identityRepository = this.identityRepository;
        return identityRepository == null ? this.jsch.getIdentityRepository() : identityRepository;
    }

    public int getPort() {
        return this.port;
    }

    public String[] getPortForwardingL() throws JSchException {
        return PortWatcher.getPortForwarding(this);
    }

    public String[] getPortForwardingR() throws JSchException {
        return ChannelForwardedTCPIP.getPortForwarding(this);
    }

    public int getServerAliveCountMax() {
        return this.serverAliveCountMax;
    }

    public int getServerAliveInterval() {
        return this.serverAliveInterval;
    }

    public String getServerVersion() {
        return Util.byte2str(this.V_S);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getSessionId() {
        return this.session_id;
    }

    public Channel getStreamForwarder(String str, int i) throws JSchException {
        ChannelDirectTCPIP channelDirectTCPIP = new ChannelDirectTCPIP();
        channelDirectTCPIP.init();
        addChannel(channelDirectTCPIP);
        channelDirectTCPIP.setHost(str);
        channelDirectTCPIP.setPort(i);
        return channelDirectTCPIP;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public UserInfo getUserInfo() {
        return this.userinfo;
    }

    public String getUserName() {
        return this.username;
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void noMoreSessionChannels() throws Exception {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 80);
        buffer.putString(nomoresessions);
        buffer.putByte((byte) 0);
        write(packet);
    }

    public Channel openChannel(String str) throws JSchException {
        if (this.isConnected) {
            try {
                Channel channel = Channel.getChannel(str);
                addChannel(channel);
                channel.init();
                if (channel instanceof ChannelSession) {
                    applyConfigChannel((ChannelSession) channel);
                }
                return channel;
            } catch (Exception unused) {
                return null;
            }
        } else {
            throw new JSchException("session is down");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x01de, code lost:
        r22.rewind();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01e1, code lost:
        return r22;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0123 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01e2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.jcraft.jsch.Buffer read(com.jcraft.jsch.Buffer r22) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 548
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.read(com.jcraft.jsch.Buffer):com.jcraft.jsch.Buffer");
    }

    public void rekey() throws Exception {
        send_kexinit();
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x031f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0057 A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 916
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.run():void");
    }

    public void sendIgnore() throws Exception {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 2);
        write(packet);
    }

    public void sendKeepAliveMsg() throws Exception {
        Buffer buffer = new Buffer();
        Packet packet = new Packet(buffer);
        packet.reset();
        buffer.putByte((byte) 80);
        buffer.putString(keepalivemsg);
        buffer.putByte((byte) 1);
        write(packet);
    }

    public void setClientVersion(String str) {
        this.V_C = Util.str2byte(str);
    }

    public void setConfig(Properties properties) {
        setConfig((Hashtable) properties);
    }

    public void setDaemonThread(boolean z) {
        this.daemon_thread = z;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setHostKeyAlias(String str) {
        this.hostKeyAlias = str;
    }

    public void setHostKeyRepository(HostKeyRepository hostKeyRepository) {
        this.hostkeyRepository = hostKeyRepository;
    }

    public void setIdentityRepository(IdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public void setInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void setPassword(String str) {
        if (str != null) {
            this.password = Util.str2byte(str);
        }
    }

    public void setPort(int i) {
        this.port = i;
    }

    public int setPortForwardingL(int i, String str, int i2) throws JSchException {
        return setPortForwardingL("127.0.0.1", i, str, i2);
    }

    public void setPortForwardingR(int i, String str, int i2) throws JSchException {
        setPortForwardingR(null, i, str, i2, null);
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    public void setServerAliveCountMax(int i) {
        this.serverAliveCountMax = i;
    }

    public void setServerAliveInterval(int i) throws JSchException {
        setTimeout(i);
        this.serverAliveInterval = i;
    }

    public void setSocketFactory(SocketFactory socketFactory) {
        this.socket_factory = socketFactory;
    }

    public void setTimeout(int i) throws JSchException {
        Socket socket = this.socket;
        if (socket != null) {
            try {
                socket.setSoTimeout(i);
                this.timeout = i;
            } catch (Exception e2) {
                throw new JSchException(e2.toString(), e2);
            }
        } else if (i >= 0) {
            this.timeout = i;
        } else {
            throw new JSchException("invalid timeout value");
        }
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userinfo = userInfo;
    }

    void setUserName(String str) {
        this.username = str;
    }

    public void setX11Cookie(String str) {
        ChannelX11.setCookie(str);
    }

    public void setX11Host(String str) {
        ChannelX11.setHost(str);
    }

    public void setX11Port(int i) {
        ChannelX11.setPort(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        if (r14.close != false) goto L_0x00dd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006b, code lost:
        if (r14.isConnected() == false) goto L_0x00dd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006d, code lost:
        r5 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006e, code lost:
        monitor-enter(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006f, code lost:
        r6 = 0;
        r6 = 0;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
        if (r14.rwsize <= 0) goto L_0x00ad;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0076, code lost:
        r3 = r14.rwsize;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007a, code lost:
        if (r3 <= r7) goto L_0x007d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x007c, code lost:
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007f, code lost:
        if (r3 == r7) goto L_0x0098;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0081, code lost:
        r15 = (int) r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0084, code lost:
        if (r12.c2scipher == null) goto L_0x0089;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0086, code lost:
        r5 = r12.c2scipher_size;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
        r5 = 8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
        r9 = r12.c2smac;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008d, code lost:
        if (r9 == null) goto L_0x0093;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008f, code lost:
        r6 = r9.getBlockSize();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
        r6 = r13.shift(r15, r5, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0098, code lost:
        r6 = r13.buffer.getCommand();
        r5 = r14.getRecipient();
        r15 = (int) (r7 - r3);
        r14.rwsize -= r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ad, code lost:
        r2 = false;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00af, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00b0, code lost:
        if (r2 == false) goto L_0x00bb;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00b2, code lost:
        _write(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b5, code lost:
        if (r15 != 0) goto L_0x00b8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b7, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        r13.unshift(r6, r5, r3, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00bb, code lost:
        monitor-enter(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00be, code lost:
        if (r12.in_kex == false) goto L_0x00c3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00c0, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c3, code lost:
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00c8, code lost:
        if (r14.rwsize < r4) goto L_0x00d4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ca, code lost:
        r14.rwsize -= r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00cf, code lost:
        monitor-exit(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00d0, code lost:
        _write(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d3, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00d4, code lost:
        monitor-exit(r14);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(com.jcraft.jsch.Packet r13, com.jcraft.jsch.Channel r14, int r15) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.write(com.jcraft.jsch.Packet, com.jcraft.jsch.Channel, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x029c, code lost:
        r9 = com.jcraft.jsch.Util.split(r11, com.tplink.libtpmediastatistics.SSLClient.COMMA);
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x049a, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x04a5, code lost:
        throw new com.jcraft.jsch.JSchException(r0.toString(), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x04a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x04c4, code lost:
        throw new com.jcraft.jsch.JSchException("MaxAuthTries: " + getConfig("MaxAuthTries"), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04c5, code lost:
        r16.in_kex = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x04e4, code lost:
        throw new com.jcraft.jsch.JSchException("invalid protocol(newkyes): " + ((int) r16.buf.getCommand()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x04e6, code lost:
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x04e8, code lost:
        r16.in_kex = false;
        r16.in_prompt = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x04ec, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x04ed, code lost:
        r2 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x04f0, code lost:
        r16.in_kex = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x0509, code lost:
        throw new com.jcraft.jsch.JSchException("verify: " + r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x050a, code lost:
        r16.in_kex = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0529, code lost:
        throw new com.jcraft.jsch.JSchException("invalid protocol(kex): " + ((int) r16.buf.getCommand()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x052a, code lost:
        r16.in_kex = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0549, code lost:
        throw new com.jcraft.jsch.JSchException("invalid protocol: " + ((int) r16.buf.getCommand()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x0551, code lost:
        throw new com.jcraft.jsch.JSchException("invalid server's version string");
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0564, code lost:
        r16.in_kex = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0568, code lost:
        if (r16.isConnected != false) goto L_0x056a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x056a, code lost:
        r3 = r2.toString();
        r16.packet.reset();
        r16.buf.checkFreeSize(((r3.length() + 13) + 2) + 128);
        r16.buf.putByte((byte) 1);
        r16.buf.putInt(3);
        r16.buf.putString(com.jcraft.jsch.Util.str2byte(r3));
        r16.buf.putString(com.jcraft.jsch.Util.str2byte("en"));
        write(r16.packet);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x05a6, code lost:
        disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x05aa, code lost:
        r16.isConnected = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x05ae, code lost:
        if ((r2 instanceof java.lang.RuntimeException) == false) goto L_0x05b0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x05b2, code lost:
        if ((r2 instanceof com.jcraft.jsch.JSchException) != false) goto L_0x05b4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x05b6, code lost:
        throw ((com.jcraft.jsch.JSchException) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x05cd, code lost:
        throw new com.jcraft.jsch.JSchException("Session.connect: " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x05d0, code lost:
        throw ((java.lang.RuntimeException) r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0166, code lost:
        if (r9 == r10.length) goto L_0x054a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0169, code lost:
        if (r9 < 7) goto L_0x054a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0170, code lost:
        if (r10[4] != 49) goto L_0x0179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0177, code lost:
        if (r10[6] != 57) goto L_0x054a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0179, code lost:
        r11 = new byte[r9];
        r16.V_S = r11;
        java.lang.System.arraycopy(r10, 0, r11, 0, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0188, code lost:
        if (com.jcraft.jsch.JSch.getLogger().isEnabled(1) == false) goto L_0x01c6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x018a, code lost:
        com.jcraft.jsch.JSch.getLogger().log(1, "Remote version string: " + com.jcraft.jsch.Util.byte2str(r16.V_S));
        com.jcraft.jsch.JSch.getLogger().log(1, "Local version string: " + com.jcraft.jsch.Util.byte2str(r16.V_C));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c6, code lost:
        send_kexinit();
        r9 = read(r16.buf);
        r16.buf = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01d7, code lost:
        if (r9.getCommand() != 20) goto L_0x052a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01e1, code lost:
        if (com.jcraft.jsch.JSch.getLogger().isEnabled(1) == false) goto L_0x01ec;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01e3, code lost:
        com.jcraft.jsch.JSch.getLogger().log(1, "SSH_MSG_KEXINIT received");
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01ec, code lost:
        r9 = receive_kexinit(r16.buf);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01f2, code lost:
        r16.buf = read(r16.buf);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0204, code lost:
        if (r9.getState() != r16.buf.getCommand()) goto L_0x050a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0206, code lost:
        r16.kex_start_time = java.lang.System.currentTimeMillis();
        r10 = r9.next(r16.buf);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0212, code lost:
        if (r10 == false) goto L_0x04f0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0218, code lost:
        if (r9.getState() != 0) goto L_0x01f2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x021a, code lost:
        r10 = java.lang.System.currentTimeMillis();
        r16.in_prompt = true;
        checkHost(r16.host, r16.port, r9);
        r16.in_prompt = false;
        r16.kex_start_time += java.lang.System.currentTimeMillis() - r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0233, code lost:
        send_newkeys();
        r10 = read(r16.buf);
        r16.buf = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0244, code lost:
        if (r10.getCommand() != 21) goto L_0x04c5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x024e, code lost:
        if (com.jcraft.jsch.JSch.getLogger().isEnabled(1) == false) goto L_0x0259;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0250, code lost:
        com.jcraft.jsch.JSch.getLogger().log(1, "SSH_MSG_NEWKEYS received");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0259, code lost:
        receive_newkeys(r16.buf, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x025e, code lost:
        r9 = getConfig("MaxAuthTries");
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0264, code lost:
        if (r9 == null) goto L_0x026c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0266, code lost:
        r16.max_auth_tries = java.lang.Integer.parseInt(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x026c, code lost:
        r9 = (com.jcraft.jsch.UserAuth) java.lang.Class.forName(getConfig("userauth.none")).newInstance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x027c, code lost:
        r10 = r9.start(r16);
        r11 = getConfig("PreferredAuthentications");
        r12 = com.jcraft.jsch.Util.split(r11, com.tplink.libtpmediastatistics.SSLClient.COMMA);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x028c, code lost:
        if (r10 != false) goto L_0x029b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x028e, code lost:
        r9 = ((com.jcraft.jsch.UserAuthNone) r9).getMethods();
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0294, code lost:
        if (r9 == null) goto L_0x029c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0296, code lost:
        r11 = r9.toLowerCase();
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x029b, code lost:
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0432 A[Catch: all -> 0x055e, Exception -> 0x0561, TryCatch #15 {all -> 0x055e, blocks: (B:14:0x006c, B:16:0x0070, B:18:0x0074, B:19:0x0089, B:20:0x00a1, B:21:0x00b1, B:25:0x00de, B:27:0x00e2, B:28:0x00e5, B:30:0x00f1, B:31:0x00fa, B:33:0x0116, B:35:0x011d, B:38:0x0126, B:41:0x0133, B:43:0x013d, B:45:0x0141, B:47:0x0147, B:49:0x014b, B:51:0x014e, B:53:0x0154, B:55:0x0158, B:57:0x015e, B:60:0x0165, B:64:0x016b, B:66:0x0172, B:68:0x0179, B:70:0x018a, B:71:0x01c6, B:73:0x01d9, B:75:0x01e3, B:76:0x01ec, B:77:0x01f2, B:79:0x0206, B:81:0x0214, B:83:0x021a, B:84:0x0233, B:86:0x0246, B:88:0x0250, B:89:0x0259, B:90:0x025e, B:92:0x0266, B:93:0x026c, B:94:0x027c, B:96:0x028e, B:98:0x0296, B:100:0x029c, B:104:0x02a8, B:106:0x02ab, B:107:0x02b0, B:109:0x02b3, B:112:0x02bd, B:116:0x02c8, B:118:0x02d2, B:119:0x02d6, B:121:0x02d9, B:123:0x02ef, B:124:0x0301, B:125:0x0320, B:127:0x0337, B:128:0x0357, B:130:0x0361, B:133:0x0381, B:135:0x0387, B:137:0x0391, B:141:0x03b2, B:143:0x03bc, B:147:0x03dc, B:150:0x03df, B:152:0x03e1, B:160:0x0406, B:162:0x040c, B:164:0x0416, B:166:0x0432, B:167:0x0439, B:168:0x043a, B:169:0x0441, B:170:0x0442, B:173:0x0448, B:175:0x044c, B:176:0x0451, B:177:0x0455, B:190:0x0499, B:192:0x049b, B:193:0x04a5, B:195:0x04a7, B:196:0x04c4, B:197:0x04c5, B:198:0x04e4, B:201:0x04e8, B:202:0x04ec, B:205:0x04f0, B:206:0x0509, B:207:0x050a, B:208:0x0529, B:209:0x052a, B:210:0x0549, B:211:0x054a, B:212:0x0551, B:213:0x0552, B:214:0x0559, B:218:0x055d, B:223:0x0564, B:224:0x0566, B:226:0x056a, B:227:0x05a6, B:229:0x05aa, B:231:0x05b0, B:233:0x05b4, B:234:0x05b6, B:235:0x05b7, B:236:0x05cd, B:237:0x05ce, B:238:0x05d0), top: B:265:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:168:0x043a A[Catch: all -> 0x055e, Exception -> 0x0561, TryCatch #15 {all -> 0x055e, blocks: (B:14:0x006c, B:16:0x0070, B:18:0x0074, B:19:0x0089, B:20:0x00a1, B:21:0x00b1, B:25:0x00de, B:27:0x00e2, B:28:0x00e5, B:30:0x00f1, B:31:0x00fa, B:33:0x0116, B:35:0x011d, B:38:0x0126, B:41:0x0133, B:43:0x013d, B:45:0x0141, B:47:0x0147, B:49:0x014b, B:51:0x014e, B:53:0x0154, B:55:0x0158, B:57:0x015e, B:60:0x0165, B:64:0x016b, B:66:0x0172, B:68:0x0179, B:70:0x018a, B:71:0x01c6, B:73:0x01d9, B:75:0x01e3, B:76:0x01ec, B:77:0x01f2, B:79:0x0206, B:81:0x0214, B:83:0x021a, B:84:0x0233, B:86:0x0246, B:88:0x0250, B:89:0x0259, B:90:0x025e, B:92:0x0266, B:93:0x026c, B:94:0x027c, B:96:0x028e, B:98:0x0296, B:100:0x029c, B:104:0x02a8, B:106:0x02ab, B:107:0x02b0, B:109:0x02b3, B:112:0x02bd, B:116:0x02c8, B:118:0x02d2, B:119:0x02d6, B:121:0x02d9, B:123:0x02ef, B:124:0x0301, B:125:0x0320, B:127:0x0337, B:128:0x0357, B:130:0x0361, B:133:0x0381, B:135:0x0387, B:137:0x0391, B:141:0x03b2, B:143:0x03bc, B:147:0x03dc, B:150:0x03df, B:152:0x03e1, B:160:0x0406, B:162:0x040c, B:164:0x0416, B:166:0x0432, B:167:0x0439, B:168:0x043a, B:169:0x0441, B:170:0x0442, B:173:0x0448, B:175:0x044c, B:176:0x0451, B:177:0x0455, B:190:0x0499, B:192:0x049b, B:193:0x04a5, B:195:0x04a7, B:196:0x04c4, B:197:0x04c5, B:198:0x04e4, B:201:0x04e8, B:202:0x04ec, B:205:0x04f0, B:206:0x0509, B:207:0x050a, B:208:0x0529, B:209:0x052a, B:210:0x0549, B:211:0x054a, B:212:0x0551, B:213:0x0552, B:214:0x0559, B:218:0x055d, B:223:0x0564, B:224:0x0566, B:226:0x056a, B:227:0x05a6, B:229:0x05aa, B:231:0x05b0, B:233:0x05b4, B:234:0x05b6, B:235:0x05b7, B:236:0x05cd, B:237:0x05ce, B:238:0x05d0), top: B:265:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0381 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void connect(int r17) throws com.jcraft.jsch.JSchException {
        /*
            Method dump skipped, instructions count: 1505
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jcraft.jsch.Session.connect(int):void");
    }

    public void delPortForwardingL(String str, int i) throws JSchException {
        PortWatcher.delPort(this, str, i);
    }

    public void delPortForwardingR(String str, int i) throws JSchException {
        ChannelForwardedTCPIP.delPort(this, str, i);
    }

    public void setConfig(Hashtable hashtable) {
        synchronized (this.lock) {
            if (this.config == null) {
                this.config = new Hashtable();
            }
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                this.config.put(str, (String) hashtable.get(str));
            }
        }
    }

    public void setPassword(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.password = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public int setPortForwardingL(String str, int i, String str2, int i2) throws JSchException {
        return setPortForwardingL(str, i, str2, i2, null);
    }

    public void setPortForwardingR(String str, int i, String str2, int i2) throws JSchException {
        setPortForwardingR(str, i, str2, i2, null);
    }

    public int setPortForwardingL(String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory) throws JSchException {
        return setPortForwardingL(str, i, str2, i2, serverSocketFactory, 0);
    }

    public void setPortForwardingR(int i, String str, int i2, SocketFactory socketFactory) throws JSchException {
        setPortForwardingR(null, i, str, i2, socketFactory);
    }

    public int setPortForwardingL(String str, int i, String str2, int i2, ServerSocketFactory serverSocketFactory, int i3) throws JSchException {
        PortWatcher addPort = PortWatcher.addPort(this, str, i, str2, i2, serverSocketFactory);
        addPort.setConnectTimeout(i3);
        Thread thread = new Thread(addPort);
        thread.setName("PortWatcher Thread for " + str2);
        boolean z = this.daemon_thread;
        if (z) {
            thread.setDaemon(z);
        }
        thread.start();
        return addPort.lport;
    }

    public void setPortForwardingR(String str, int i, String str2, int i2, SocketFactory socketFactory) throws JSchException {
        ChannelForwardedTCPIP.addPort(this, str, i, _setPortForwardingR(str, i), str2, i2, socketFactory);
    }

    public void setPortForwardingR(int i, String str) throws JSchException {
        setPortForwardingR((String) null, i, str, (Object[]) null);
    }

    public void setPortForwardingR(int i, String str, Object[] objArr) throws JSchException {
        setPortForwardingR((String) null, i, str, objArr);
    }

    public void setPortForwardingR(String str, int i, String str2, Object[] objArr) throws JSchException {
        ChannelForwardedTCPIP.addPort(this, str, i, _setPortForwardingR(str, i), str2, objArr);
    }

    public void setConfig(String str, String str2) {
        synchronized (this.lock) {
            if (this.config == null) {
                this.config = new Hashtable();
            }
            this.config.put(str, str2);
        }
    }

    public int setPortForwardingR(String str) throws JSchException {
        Forwarding parseForwarding = parseForwarding(str);
        int _setPortForwardingR = _setPortForwardingR(parseForwarding.bind_address, parseForwarding.port);
        ChannelForwardedTCPIP.addPort(this, parseForwarding.bind_address, parseForwarding.port, _setPortForwardingR, parseForwarding.host, parseForwarding.hostport, null);
        return _setPortForwardingR;
    }

    public int setPortForwardingL(String str) throws JSchException {
        Forwarding parseForwarding = parseForwarding(str);
        return setPortForwardingL(parseForwarding.bind_address, parseForwarding.port, parseForwarding.host, parseForwarding.hostport);
    }

    public void write(Packet packet) throws Exception {
        long timeout = getTimeout();
        while (this.in_kex) {
            if (timeout <= 0 || System.currentTimeMillis() - this.kex_start_time <= timeout || this.in_prompt) {
                byte command = packet.buffer.getCommand();
                if (command == 20 || command == 21 || command == 30 || command == 31 || command == 31 || command == 32 || command == 33 || command == 34 || command == 1) {
                    break;
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException unused) {
                }
            } else {
                throw new JSchException("timeout in waiting for rekeying process.");
            }
        }
        _write(packet);
    }
}
