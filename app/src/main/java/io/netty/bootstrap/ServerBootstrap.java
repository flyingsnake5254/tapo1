package io.netty.bootstrap;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.a;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ServerBootstrap extends AbstractBootstrap<ServerBootstrap, a> {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ServerBootstrap.class);
    private final Map<AttributeKey<?>, Object> childAttrs;
    private volatile EventLoopGroup childGroup;
    private volatile ChannelHandler childHandler;
    private final Map<ChannelOption<?>, Object> childOptions;
    private final ServerBootstrapConfig config;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class ServerBootstrapAcceptor extends ChannelInboundHandlerAdapter {
        private final Map.Entry<AttributeKey<?>, Object>[] childAttrs;
        private final EventLoopGroup childGroup;
        private final ChannelHandler childHandler;
        private final Map.Entry<ChannelOption<?>, Object>[] childOptions;
        private final Runnable enableAutoReadTask;

        ServerBootstrapAcceptor(final Channel channel, EventLoopGroup eventLoopGroup, ChannelHandler channelHandler, Map.Entry<ChannelOption<?>, Object>[] entryArr, Map.Entry<AttributeKey<?>, Object>[] entryArr2) {
            this.childGroup = eventLoopGroup;
            this.childHandler = channelHandler;
            this.childOptions = entryArr;
            this.childAttrs = entryArr2;
            this.enableAutoReadTask = new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.1
                @Override // java.lang.Runnable
                public void run() {
                    channel.config().setAutoRead(true);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void forceClose(Channel channel, Throwable th) {
            channel.unsafe().closeForcibly();
            ServerBootstrap.logger.warn("Failed to register an accepted channel: {}", channel, th);
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
        public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
            final Channel channel = (Channel) obj;
            channel.pipeline().addLast(this.childHandler);
            AbstractBootstrap.setChannelOptions(channel, this.childOptions, ServerBootstrap.logger);
            AbstractBootstrap.setAttributes(channel, this.childAttrs);
            try {
                this.childGroup.register(channel).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.bootstrap.ServerBootstrap.ServerBootstrapAcceptor.2
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (!channelFuture.isSuccess()) {
                            ServerBootstrapAcceptor.forceClose(channel, channelFuture.cause());
                        }
                    }
                });
            } catch (Throwable th) {
                forceClose(channel, th);
            }
        }

        @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
        public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) throws Exception {
            ChannelConfig config = channelHandlerContext.channel().config();
            if (config.isAutoRead()) {
                config.setAutoRead(false);
                channelHandlerContext.channel().eventLoop().schedule(this.enableAutoReadTask, 1L, TimeUnit.SECONDS);
            }
            channelHandlerContext.fireExceptionCaught(th);
        }
    }

    public ServerBootstrap() {
        this.childOptions = new LinkedHashMap();
        this.childAttrs = new ConcurrentHashMap();
        this.config = new ServerBootstrapConfig(this);
    }

    public <T> ServerBootstrap childAttr(AttributeKey<T> attributeKey, T t) {
        ObjectUtil.checkNotNull(attributeKey, "childKey");
        if (t == null) {
            this.childAttrs.remove(attributeKey);
        } else {
            this.childAttrs.put(attributeKey, t);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<AttributeKey<?>, Object> childAttrs() {
        return AbstractBootstrap.copiedMap(this.childAttrs);
    }

    @Deprecated
    public EventLoopGroup childGroup() {
        return this.childGroup;
    }

    public ServerBootstrap childHandler(ChannelHandler channelHandler) {
        this.childHandler = (ChannelHandler) ObjectUtil.checkNotNull(channelHandler, "childHandler");
        return this;
    }

    public <T> ServerBootstrap childOption(ChannelOption<T> channelOption, T t) {
        ObjectUtil.checkNotNull(channelOption, "childOption");
        synchronized (this.childOptions) {
            if (t == null) {
                this.childOptions.remove(channelOption);
            } else {
                this.childOptions.put(channelOption, t);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<ChannelOption<?>, Object> childOptions() {
        Map<ChannelOption<?>, Object> copiedMap;
        synchronized (this.childOptions) {
            copiedMap = AbstractBootstrap.copiedMap(this.childOptions);
        }
        return copiedMap;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    void init(Channel channel) {
        final Map.Entry[] entryArr;
        AbstractBootstrap.setChannelOptions(channel, newOptionsArray(), logger);
        Set<Map.Entry<AttributeKey<?>, Object>> entrySet = attrs0().entrySet();
        Map.Entry<AttributeKey<?>, Object>[] entryArr2 = AbstractBootstrap.EMPTY_ATTRIBUTE_ARRAY;
        AbstractBootstrap.setAttributes(channel, (Map.Entry[]) entrySet.toArray(entryArr2));
        ChannelPipeline pipeline = channel.pipeline();
        final EventLoopGroup eventLoopGroup = this.childGroup;
        final ChannelHandler channelHandler = this.childHandler;
        synchronized (this.childOptions) {
            entryArr = (Map.Entry[]) this.childOptions.entrySet().toArray(AbstractBootstrap.EMPTY_OPTION_ARRAY);
        }
        final Map.Entry[] entryArr3 = (Map.Entry[]) this.childAttrs.entrySet().toArray(entryArr2);
        pipeline.addLast(new ChannelInitializer<Channel>() { // from class: io.netty.bootstrap.ServerBootstrap.1
            @Override // io.netty.channel.ChannelInitializer
            public void initChannel(final Channel channel2) {
                final ChannelPipeline pipeline2 = channel2.pipeline();
                ChannelHandler handler = ServerBootstrap.this.config.handler();
                if (handler != null) {
                    pipeline2.addLast(handler);
                }
                channel2.eventLoop().execute(new Runnable() { // from class: io.netty.bootstrap.ServerBootstrap.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChannelPipeline channelPipeline = pipeline2;
                        Channel channel3 = channel2;
                        AnonymousClass1 r2 = AnonymousClass1.this;
                        channelPipeline.addLast(new ServerBootstrapAcceptor(channel3, eventLoopGroup, channelHandler, entryArr, entryArr3));
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ChannelHandler childHandler() {
        return this.childHandler;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public final AbstractBootstrapConfig<ServerBootstrap, a> config() {
        return this.config;
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap group(EventLoopGroup eventLoopGroup) {
        return group(eventLoopGroup, eventLoopGroup);
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap validate() {
        super.validate();
        if (this.childHandler != null) {
            if (this.childGroup == null) {
                logger.warn("childGroup is not set. Using parentGroup instead.");
                this.childGroup = this.config.group();
            }
            return this;
        }
        throw new IllegalStateException("childHandler not set");
    }

    @Override // io.netty.bootstrap.AbstractBootstrap
    public ServerBootstrap clone() {
        return new ServerBootstrap(this);
    }

    public ServerBootstrap group(EventLoopGroup eventLoopGroup, EventLoopGroup eventLoopGroup2) {
        super.group(eventLoopGroup);
        if (this.childGroup == null) {
            this.childGroup = (EventLoopGroup) ObjectUtil.checkNotNull(eventLoopGroup2, "childGroup");
            return this;
        }
        throw new IllegalStateException("childGroup set already");
    }

    private ServerBootstrap(ServerBootstrap serverBootstrap) {
        super(serverBootstrap);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.childOptions = linkedHashMap;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.childAttrs = concurrentHashMap;
        this.config = new ServerBootstrapConfig(this);
        this.childGroup = serverBootstrap.childGroup;
        this.childHandler = serverBootstrap.childHandler;
        synchronized (serverBootstrap.childOptions) {
            linkedHashMap.putAll(serverBootstrap.childOptions);
        }
        concurrentHashMap.putAll(serverBootstrap.childAttrs);
    }
}
