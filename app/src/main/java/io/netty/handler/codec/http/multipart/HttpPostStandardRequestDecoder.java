package io.netty.handler.codec.http.multipart;

import com.tplink.libtpcommonstream.stream.control.common.StreamControlType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class HttpPostStandardRequestDecoder implements InterfaceHttpPostRequestDecoder {
    private final List<InterfaceHttpData> bodyListHttpData;
    private int bodyListHttpDataRank;
    private final Map<String, List<InterfaceHttpData>> bodyMapHttpData;
    private final Charset charset;
    private Attribute currentAttribute;
    private HttpPostRequestDecoder.MultiPartStatus currentStatus;
    private boolean destroyed;
    private int discardThreshold;
    private final HttpDataFactory factory;
    private boolean isLastChunk;
    private final HttpRequest request;
    private ByteBuf undecodedChunk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus;

        static {
            int[] iArr = new int[HttpPostRequestDecoder.MultiPartStatus.values().length];
            $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus = iArr;
            try {
                iArr[HttpPostRequestDecoder.MultiPartStatus.DISPOSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[HttpPostRequestDecoder.MultiPartStatus.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class UrlDecoder implements ByteProcessor {
        private byte hiByte;
        private int nextEscapedIdx;
        private final ByteBuf output;

        UrlDecoder(ByteBuf byteBuf) {
            this.output = byteBuf;
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b2) {
            int i = this.nextEscapedIdx;
            if (i != 0) {
                if (i == 1) {
                    this.hiByte = b2;
                    this.nextEscapedIdx = i + 1;
                } else {
                    int decodeHexNibble = StringUtil.decodeHexNibble((char) this.hiByte);
                    int decodeHexNibble2 = StringUtil.decodeHexNibble((char) b2);
                    if (decodeHexNibble == -1 || decodeHexNibble2 == -1) {
                        this.nextEscapedIdx++;
                        return false;
                    }
                    this.output.writeByte((decodeHexNibble << 4) + decodeHexNibble2);
                    this.nextEscapedIdx = 0;
                }
            } else if (b2 == 37) {
                this.nextEscapedIdx = 1;
            } else if (b2 == 43) {
                this.output.writeByte(32);
            } else {
                this.output.writeByte(b2);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class UrlEncodedDetector implements ByteProcessor {
        private UrlEncodedDetector() {
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b2) throws Exception {
            return (b2 == 37 || b2 == 43) ? false : true;
        }

        /* synthetic */ UrlEncodedDetector(AnonymousClass1 r1) {
            this();
        }
    }

    public HttpPostStandardRequestDecoder(HttpRequest httpRequest) {
        this(new DefaultHttpDataFactory(16384L), httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    private void checkDestroyed() {
        if (this.destroyed) {
            throw new IllegalStateException(HttpPostStandardRequestDecoder.class.getSimpleName() + " was destroyed already");
        }
    }

    private static String decodeAttribute(String str, Charset charset) {
        try {
            return QueryStringDecoder.decodeComponent(str, charset);
        } catch (IllegalArgumentException e2) {
            throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad string: '" + str + '\'', e2);
        }
    }

    private void parseBody() {
        HttpPostRequestDecoder.MultiPartStatus multiPartStatus = this.currentStatus;
        if (multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE && multiPartStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE) {
            parseBodyAttributes();
        } else if (this.isLastChunk) {
            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
        }
    }

    private void parseBodyAttributes() {
        int i;
        HttpPostRequestDecoder.ErrorDataDecoderException e2;
        IOException e3;
        IllegalArgumentException e4;
        boolean z;
        Attribute attribute;
        Attribute attribute2;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null) {
            if (!byteBuf.hasArray()) {
                parseBodyAttributesStandard();
                return;
            }
            HttpPostBodyUtil.SeekAheadOptimize seekAheadOptimize = new HttpPostBodyUtil.SeekAheadOptimize(this.undecodedChunk);
            int readerIndex = this.undecodedChunk.readerIndex();
            if (this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED) {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
            }
            loop0: while (true) {
                i = readerIndex;
                while (true) {
                    try {
                        int i2 = seekAheadOptimize.pos;
                        z = true;
                        if (i2 >= seekAheadOptimize.limit) {
                            break loop0;
                        }
                        byte[] bArr = seekAheadOptimize.bytes;
                        seekAheadOptimize.pos = i2 + 1;
                        char c2 = (char) (bArr[i2] & 255);
                        readerIndex++;
                        int i3 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http$multipart$HttpPostRequestDecoder$MultiPartStatus[this.currentStatus.ordinal()];
                        if (i3 != 1) {
                            if (i3 != 2) {
                                seekAheadOptimize.setReadPosition(0);
                                break loop0;
                            } else if (c2 == '&') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, (readerIndex - 1) - i));
                                break;
                            } else if (c2 == '\r') {
                                int i4 = seekAheadOptimize.pos;
                                int i5 = seekAheadOptimize.limit;
                                if (i4 < i5) {
                                    byte[] bArr2 = seekAheadOptimize.bytes;
                                    seekAheadOptimize.pos = i4 + 1;
                                    readerIndex++;
                                    if (((char) (bArr2[i4] & 255)) == '\n') {
                                        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                        seekAheadOptimize.setReadPosition(0);
                                        setFinalBuffer(this.undecodedChunk.retainedSlice(i, (readerIndex - 2) - i));
                                    } else {
                                        seekAheadOptimize.setReadPosition(0);
                                        throw new HttpPostRequestDecoder.ErrorDataDecoderException("Bad end of line");
                                    }
                                } else if (i5 > 0) {
                                    readerIndex--;
                                }
                            } else if (c2 == '\n') {
                                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.PREEPILOGUE;
                                seekAheadOptimize.setReadPosition(0);
                                setFinalBuffer(this.undecodedChunk.retainedSlice(i, (readerIndex - 1) - i));
                                break loop0;
                            }
                        } else if (c2 == '=') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.FIELD;
                            this.currentAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i, (readerIndex - 1) - i, this.charset), this.charset));
                            break;
                        } else if (c2 == '&') {
                            this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.DISPOSITION;
                            Attribute createAttribute = this.factory.createAttribute(this.request, decodeAttribute(this.undecodedChunk.toString(i, (readerIndex - 1) - i, this.charset), this.charset));
                            this.currentAttribute = createAttribute;
                            createAttribute.setValue("");
                            addHttpData(this.currentAttribute);
                            this.currentAttribute = null;
                            break;
                        }
                    } catch (HttpPostRequestDecoder.ErrorDataDecoderException e5) {
                        e2 = e5;
                    } catch (IOException e6) {
                        e3 = e6;
                    } catch (IllegalArgumentException e7) {
                        e4 = e7;
                    }
                }
            }
            i = readerIndex;
            z = false;
            if (!this.isLastChunk || (attribute2 = this.currentAttribute) == null) {
                if (z && (attribute = this.currentAttribute) != null && this.currentStatus == HttpPostRequestDecoder.MultiPartStatus.FIELD) {
                    attribute.addContent(this.undecodedChunk.retainedSlice(i, readerIndex - i), false);
                }
                this.undecodedChunk.readerIndex(i);
            }
            if (readerIndex > i) {
                setFinalBuffer(this.undecodedChunk.retainedSlice(i, readerIndex - i));
            } else if (!attribute2.isCompleted()) {
                setFinalBuffer(Unpooled.EMPTY_BUFFER);
            }
            try {
                this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
            } catch (HttpPostRequestDecoder.ErrorDataDecoderException e8) {
                e2 = e8;
                i = readerIndex;
                this.undecodedChunk.readerIndex(i);
                throw e2;
            } catch (IOException e9) {
                e3 = e9;
                i = readerIndex;
                this.undecodedChunk.readerIndex(i);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e3);
            } catch (IllegalArgumentException e10) {
                e4 = e10;
                i = readerIndex;
                this.undecodedChunk.readerIndex(i);
                throw new HttpPostRequestDecoder.ErrorDataDecoderException(e4);
            }
            i = readerIndex;
            this.undecodedChunk.readerIndex(i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ee, code lost:
        if (r9.isLastChunk == false) goto L_0x0112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f0, code lost:
        r1 = r9.currentAttribute;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f2, code lost:
        if (r1 == null) goto L_0x0112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f4, code lost:
        if (r0 <= r2) goto L_0x0102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f6, code lost:
        setFinalBuffer(r9.undecodedChunk.retainedSlice(r2, r0 - r2));
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0106, code lost:
        if (r1.isCompleted() != false) goto L_0x010d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0108, code lost:
        setFinalBuffer(io.netty.buffer.Unpooled.EMPTY_BUFFER);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x010d, code lost:
        r9.currentStatus = io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.EPILOGUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0112, code lost:
        if (r3 == false) goto L_0x012a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0114, code lost:
        r1 = r9.currentAttribute;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0116, code lost:
        if (r1 == null) goto L_0x012a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011c, code lost:
        if (r9.currentStatus != io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.MultiPartStatus.FIELD) goto L_0x012a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x011e, code lost:
        r1.addContent(r9.undecodedChunk.retainedSlice(r2, r0 - r2), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012a, code lost:
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012b, code lost:
        r9.undecodedChunk.readerIndex(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0130, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0131, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0135, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0139, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x013e, code lost:
        r9.undecodedChunk.readerIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0148, code lost:
        throw new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.ErrorDataDecoderException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014a, code lost:
        r9.undecodedChunk.readerIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0154, code lost:
        throw new io.netty.handler.codec.http.multipart.HttpPostRequestDecoder.ErrorDataDecoderException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0156, code lost:
        r9.undecodedChunk.readerIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x015b, code lost:
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseBodyAttributesStandard() {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.http.multipart.HttpPostStandardRequestDecoder.parseBodyAttributesStandard():void");
    }

    private void setFinalBuffer(ByteBuf byteBuf) throws IOException {
        this.currentAttribute.addContent(byteBuf, true);
        ByteBuf decodeAttribute = decodeAttribute(this.currentAttribute.getByteBuf(), this.charset);
        if (decodeAttribute != null) {
            this.currentAttribute.setContent(decodeAttribute);
        }
        addHttpData(this.currentAttribute);
        this.currentAttribute = null;
    }

    protected void addHttpData(InterfaceHttpData interfaceHttpData) {
        if (interfaceHttpData != null) {
            List<InterfaceHttpData> list = this.bodyMapHttpData.get(interfaceHttpData.getName());
            if (list == null) {
                list = new ArrayList<>(1);
                this.bodyMapHttpData.put(interfaceHttpData.getName(), list);
            }
            list.add(interfaceHttpData);
            this.bodyListHttpData.add(interfaceHttpData);
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void cleanFiles() {
        checkDestroyed();
        this.factory.cleanRequestHttpData(this.request);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData currentPartialHttpData() {
        return this.currentAttribute;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void destroy() {
        cleanFiles();
        this.destroyed = true;
        ByteBuf byteBuf = this.undecodedChunk;
        if (byteBuf != null && byteBuf.refCnt() > 0) {
            this.undecodedChunk.release();
            this.undecodedChunk = null;
        }
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData getBodyHttpData(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            List<InterfaceHttpData> list = this.bodyMapHttpData.get(str);
            if (list != null) {
                return list.get(0);
            }
            return null;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas() {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyListHttpData;
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public int getDiscardThreshold() {
        return this.discardThreshold;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean hasNext() {
        checkDestroyed();
        if (this.currentStatus != HttpPostRequestDecoder.MultiPartStatus.EPILOGUE || this.bodyListHttpDataRank < this.bodyListHttpData.size()) {
            return !this.bodyListHttpData.isEmpty() && this.bodyListHttpDataRank < this.bodyListHttpData.size();
        }
        throw new HttpPostRequestDecoder.EndOfDataDecoderException();
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public boolean isMultipart() {
        checkDestroyed();
        return false;
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public InterfaceHttpData next() {
        checkDestroyed();
        if (!hasNext()) {
            return null;
        }
        List<InterfaceHttpData> list = this.bodyListHttpData;
        int i = this.bodyListHttpDataRank;
        this.bodyListHttpDataRank = i + 1;
        return list.get(i);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void removeHttpDataFromClean(InterfaceHttpData interfaceHttpData) {
        checkDestroyed();
        this.factory.removeHttpDataFromClean(this.request, interfaceHttpData);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public void setDiscardThreshold(int i) {
        this.discardThreshold = ObjectUtil.checkPositiveOrZero(i, "discardThreshold");
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest) {
        this(httpDataFactory, httpRequest, HttpConstants.DEFAULT_CHARSET);
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public HttpPostStandardRequestDecoder offer(HttpContent httpContent) {
        ByteBuf byteBuf;
        checkDestroyed();
        if (httpContent instanceof LastHttpContent) {
            this.isLastChunk = true;
        }
        ByteBuf content = httpContent.content();
        ByteBuf byteBuf2 = this.undecodedChunk;
        if (byteBuf2 == null) {
            if (this.isLastChunk) {
                byteBuf = content.retainedSlice();
            } else {
                byteBuf = content.alloc().buffer(content.readableBytes()).writeBytes(content);
            }
            this.undecodedChunk = byteBuf;
        } else {
            byteBuf2.writeBytes(content);
        }
        parseBody();
        ByteBuf byteBuf3 = this.undecodedChunk;
        if (byteBuf3 != null && byteBuf3.writerIndex() > this.discardThreshold) {
            this.undecodedChunk.discardReadBytes();
        }
        return this;
    }

    public HttpPostStandardRequestDecoder(HttpDataFactory httpDataFactory, HttpRequest httpRequest, Charset charset) {
        this.bodyListHttpData = new ArrayList();
        this.bodyMapHttpData = new TreeMap(CaseIgnoringComparator.INSTANCE);
        this.currentStatus = HttpPostRequestDecoder.MultiPartStatus.NOTSTARTED;
        this.discardThreshold = 10485760;
        this.request = (HttpRequest) ObjectUtil.checkNotNull(httpRequest, StreamControlType.REQUEST);
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
        this.factory = (HttpDataFactory) ObjectUtil.checkNotNull(httpDataFactory, "factory");
        try {
            if (httpRequest instanceof HttpContent) {
                offer((HttpContent) httpRequest);
            } else {
                parseBody();
            }
        } catch (Throwable th) {
            destroy();
            PlatformDependent.throwException(th);
        }
    }

    private static ByteBuf decodeAttribute(ByteBuf byteBuf, Charset charset) {
        if (byteBuf.forEachByte(new UrlEncodedDetector(null)) == -1) {
            return null;
        }
        ByteBuf buffer = byteBuf.alloc().buffer(byteBuf.readableBytes());
        UrlDecoder urlDecoder = new UrlDecoder(buffer);
        int forEachByte = byteBuf.forEachByte(urlDecoder);
        if (urlDecoder.nextEscapedIdx == 0) {
            return buffer;
        }
        if (forEachByte == -1) {
            forEachByte = byteBuf.readableBytes() - 1;
        }
        int i = forEachByte - (urlDecoder.nextEscapedIdx - 1);
        buffer.release();
        throw new HttpPostRequestDecoder.ErrorDataDecoderException(String.format("Invalid hex byte at index '%d' in string: '%s'", Integer.valueOf(i), byteBuf.toString(charset)));
    }

    @Override // io.netty.handler.codec.http.multipart.InterfaceHttpPostRequestDecoder
    public List<InterfaceHttpData> getBodyHttpDatas(String str) {
        checkDestroyed();
        if (this.isLastChunk) {
            return this.bodyMapHttpData.get(str);
        }
        throw new HttpPostRequestDecoder.NotEnoughDataDecoderException();
    }
}
