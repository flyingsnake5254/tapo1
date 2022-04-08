package org.eclipse.paho.client.mqttv3.internal.websocket;

import com.tplink.libtpmediastatistics.SSLClient;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.nio.ByteBuffer;
import java.util.Properties;
import javax.net.ssl.SSLSocketFactory;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule;
import org.eclipse.paho.client.mqttv3.logging.Logger;
import org.eclipse.paho.client.mqttv3.logging.LoggerFactory;

/* loaded from: classes4.dex */
public class WebSocketSecureNetworkModule extends SSLNetworkModule {
    private static final String CLASS_NAME = "org.eclipse.paho.client.mqttv3.internal.websocket.WebSocketSecureNetworkModule";
    private Properties customWebSocketHeaders;
    private String host;
    private Logger log = LoggerFactory.getLogger(LoggerFactory.MQTT_CLIENT_MSG_CAT, CLASS_NAME);
    private ByteArrayOutputStream outputStream = new ExtendedByteArrayOutputStream(this);
    private PipedInputStream pipedInputStream = new PipedInputStream();
    private int port;
    ByteBuffer recievedPayload;
    private String uri;
    private WebSocketReceiver webSocketReceiver;

    public WebSocketSecureNetworkModule(SSLSocketFactory sSLSocketFactory, String str, String str2, int i, String str3, Properties properties) {
        super(sSLSocketFactory, str2, i, str3);
        this.uri = str;
        this.host = str2;
        this.port = i;
        this.customWebSocketHeaders = properties;
        this.log.setResourceName(str3);
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule, org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public InputStream getInputStream() throws IOException {
        return this.pipedInputStream;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule, org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public OutputStream getOutputStream() throws IOException {
        return this.outputStream;
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule, org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule, org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public String getServerURI() {
        return "wss://" + this.host + SSLClient.COLON + this.port;
    }

    InputStream getSocketInputStream() throws IOException {
        return super.getInputStream();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public OutputStream getSocketOutputStream() throws IOException {
        return super.getOutputStream();
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.SSLNetworkModule, org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule, org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public void start() throws IOException, MqttException {
        super.start();
        new WebSocketHandshake(super.getInputStream(), super.getOutputStream(), this.uri, this.host, this.port, this.customWebSocketHeaders).execute();
        WebSocketReceiver webSocketReceiver = new WebSocketReceiver(getSocketInputStream(), this.pipedInputStream);
        this.webSocketReceiver = webSocketReceiver;
        webSocketReceiver.start("WssSocketReceiver");
    }

    @Override // org.eclipse.paho.client.mqttv3.internal.TCPNetworkModule, org.eclipse.paho.client.mqttv3.internal.NetworkModule
    public void stop() throws IOException {
        getSocketOutputStream().write(new WebSocketFrame((byte) 8, true, "1000".getBytes()).encodeFrame());
        getSocketOutputStream().flush();
        WebSocketReceiver webSocketReceiver = this.webSocketReceiver;
        if (webSocketReceiver != null) {
            webSocketReceiver.stop();
        }
        super.stop();
    }
}
