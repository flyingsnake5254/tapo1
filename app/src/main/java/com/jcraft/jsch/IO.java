package com.jcraft.jsch;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

/* loaded from: classes2.dex */
public class IO {
    InputStream in;
    OutputStream out;
    OutputStream out_ext;
    private boolean in_dontclose = false;
    private boolean out_dontclose = false;
    private boolean out_ext_dontclose = false;

    public void close() {
        try {
            InputStream inputStream = this.in;
            if (inputStream != null && !this.in_dontclose) {
                inputStream.close();
            }
            this.in = null;
        } catch (Exception unused) {
        }
        out_close();
        try {
            OutputStream outputStream = this.out_ext;
            if (outputStream != null && !this.out_ext_dontclose) {
                outputStream.close();
            }
            this.out_ext = null;
        } catch (Exception unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getByte() throws IOException {
        return this.in.read();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void out_close() {
        try {
            OutputStream outputStream = this.out;
            if (outputStream != null && !this.out_dontclose) {
                outputStream.close();
            }
            this.out = null;
        } catch (Exception unused) {
        }
    }

    public void put(Packet packet) throws IOException, SocketException {
        OutputStream outputStream = this.out;
        Buffer buffer = packet.buffer;
        outputStream.write(buffer.buffer, 0, buffer.index);
        this.out.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put_ext(byte[] bArr, int i, int i2) throws IOException {
        this.out_ext.write(bArr, i, i2);
        this.out_ext.flush();
    }

    void setExtOutputStream(OutputStream outputStream) {
        this.out_ext = outputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutputStream(OutputStream outputStream) {
        this.out = outputStream;
    }

    void getByte(byte[] bArr) throws IOException {
        getByte(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setExtOutputStream(OutputStream outputStream, boolean z) {
        this.out_ext_dontclose = z;
        setExtOutputStream(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInputStream(InputStream inputStream, boolean z) {
        this.in_dontclose = z;
        setInputStream(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOutputStream(OutputStream outputStream, boolean z) {
        this.out_dontclose = z;
        setOutputStream(outputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getByte(byte[] bArr, int i, int i2) throws IOException {
        do {
            int read = this.in.read(bArr, i, i2);
            if (read >= 0) {
                i += read;
                i2 -= read;
            } else {
                throw new IOException("End of IO Stream Read");
            }
        } while (i2 > 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
        this.out.flush();
    }
}
