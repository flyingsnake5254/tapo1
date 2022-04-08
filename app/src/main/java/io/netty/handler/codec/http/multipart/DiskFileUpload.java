package io.netty.handler.codec.http.multipart;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelException;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.util.internal.ObjectUtil;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public class DiskFileUpload extends AbstractDiskHttpData implements FileUpload {
    public static String baseDirectory = null;
    public static boolean deleteOnExitTemporaryFile = true;
    public static final String postfix = ".tmp";
    public static final String prefix = "FUp_";
    private final String baseDir;
    private String contentTransferEncoding;
    private String contentType;
    private final boolean deleteOnExit;
    private String filename;

    public DiskFileUpload(String str, String str2, String str3, String str4, Charset charset, long j, String str5, boolean z) {
        super(str, charset, j);
        setFilename(str2);
        setContentType(str3);
        setContentTransferEncoding(str4);
        this.baseDir = str5 == null ? baseDirectory : str5;
        this.deleteOnExit = z;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected boolean deleteOnExit() {
        return this.deleteOnExit;
    }

    public boolean equals(Object obj) {
        return (obj instanceof FileUpload) && FileUploadUtil.equals(this, (FileUpload) obj);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getBaseDirectory() {
        return this.baseDir;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getContentTransferEncoding() {
        return this.contentTransferEncoding;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getContentType() {
        return this.contentType;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getDiskFilename() {
        return "upload";
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public String getFilename() {
        return this.filename;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpData
    public InterfaceHttpData.HttpDataType getHttpDataType() {
        return InterfaceHttpData.HttpDataType.FileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getPostfix() {
        return postfix;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData
    protected String getPrefix() {
        return prefix;
    }

    public int hashCode() {
        return FileUploadUtil.hashCode(this);
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setContentTransferEncoding(String str) {
        this.contentTransferEncoding = str;
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setContentType(String str) {
        this.contentType = (String) ObjectUtil.checkNotNull(str, "contentType");
    }

    @Override // io.netty.handler.codec.http.multipart.FileUpload
    public void setFilename(String str) {
        this.filename = (String) ObjectUtil.checkNotNull(str, "filename");
    }

    public String toString() {
        File file;
        try {
            file = getFile();
        } catch (IOException unused) {
            file = null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) HttpHeaderNames.CONTENT_DISPOSITION);
        sb.append(": ");
        sb.append((Object) HttpHeaderValues.FORM_DATA);
        sb.append("; ");
        sb.append((Object) HttpHeaderValues.NAME);
        sb.append("=\"");
        sb.append(getName());
        sb.append("\"; ");
        sb.append((Object) HttpHeaderValues.FILENAME);
        sb.append("=\"");
        sb.append(this.filename);
        sb.append("\"\r\n");
        sb.append((Object) HttpHeaderNames.CONTENT_TYPE);
        sb.append(": ");
        sb.append(this.contentType);
        Charset charset = getCharset();
        String str = SSLClient.NEW_LINE;
        if (charset != null) {
            str = "; " + ((Object) HttpHeaderValues.CHARSET) + '=' + getCharset().name() + str;
        }
        sb.append(str);
        sb.append((Object) HttpHeaderNames.CONTENT_LENGTH);
        sb.append(": ");
        sb.append(length());
        sb.append("\r\nCompleted: ");
        sb.append(isCompleted());
        sb.append("\r\nIsInMemory: ");
        sb.append(isInMemory());
        sb.append("\r\nRealFile: ");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(" DefaultDeleteAfter: ");
        sb.append(deleteOnExitTemporaryFile);
        return sb.toString();
    }

    public int compareTo(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData instanceof FileUpload) {
            return compareTo((FileUpload) interfaceHttpData);
        }
        throw new ClassCastException("Cannot compare " + getHttpDataType() + " with " + interfaceHttpData.getHttpDataType());
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload copy() {
        ByteBuf content = content();
        return replace(content != null ? content.copy() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload duplicate() {
        ByteBuf content = content();
        return replace(content != null ? content.duplicate() : null);
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload replace(ByteBuf byteBuf) {
        DiskFileUpload diskFileUpload = new DiskFileUpload(getName(), getFilename(), getContentType(), getContentTransferEncoding(), getCharset(), this.size, this.baseDir, this.deleteOnExit);
        if (byteBuf != null) {
            try {
                diskFileUpload.setContent(byteBuf);
            } catch (IOException e2) {
                throw new ChannelException(e2);
            }
        }
        return diskFileUpload;
    }

    @Override // io.netty.handler.codec.http.multipart.HttpData, io.netty.buffer.ByteBufHolder
    public FileUpload retainedDuplicate() {
        ByteBuf content = content();
        if (content == null) {
            return replace((ByteBuf) null);
        }
        ByteBuf retainedDuplicate = content.retainedDuplicate();
        try {
            return replace(retainedDuplicate);
        } catch (Throwable th) {
            retainedDuplicate.release();
            throw th;
        }
    }

    public int compareTo(FileUpload fileUpload) {
        return FileUploadUtil.compareTo(this, fileUpload);
    }

    public DiskFileUpload(String str, String str2, String str3, String str4, Charset charset, long j) {
        this(str, str2, str3, str4, charset, j, baseDirectory, deleteOnExitTemporaryFile);
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload retain(int i) {
        super.retain(i);
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload touch() {
        super.touch();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.AbstractReferenceCounted, io.netty.util.ReferenceCounted
    public FileUpload retain() {
        super.retain();
        return this;
    }

    @Override // io.netty.handler.codec.http.multipart.AbstractDiskHttpData, io.netty.handler.codec.http.multipart.AbstractHttpData, io.netty.util.ReferenceCounted
    public FileUpload touch(Object obj) {
        super.touch(obj);
        return this;
    }
}
