package io.netty.resolver.dns;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class DnsServerAddressStreamProviders {
    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(DnsServerAddressStreamProviders.class);
    private static final Constructor<? extends DnsServerAddressStreamProvider> STREAM_PROVIDER_CONSTRUCTOR;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class DefaultProviderHolder {
        private static final long REFRESH_INTERVAL = TimeUnit.MINUTES.toNanos(5);
        static final DnsServerAddressStreamProvider DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER = new DnsServerAddressStreamProvider() { // from class: io.netty.resolver.dns.DnsServerAddressStreamProviders.DefaultProviderHolder.1
            private volatile DnsServerAddressStreamProvider currentProvider = provider();
            private final AtomicLong lastRefresh = new AtomicLong(System.nanoTime());

            private DnsServerAddressStreamProvider provider() {
                return PlatformDependent.isWindows() ? DefaultDnsServerAddressStreamProvider.INSTANCE : UnixResolverDnsServerAddressStreamProvider.parseSilently();
            }

            @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
            public DnsServerAddressStream nameServerAddressStream(String str) {
                long j = this.lastRefresh.get();
                DnsServerAddressStreamProvider dnsServerAddressStreamProvider = this.currentProvider;
                if (System.nanoTime() - j > DefaultProviderHolder.REFRESH_INTERVAL && this.lastRefresh.compareAndSet(j, System.nanoTime())) {
                    dnsServerAddressStreamProvider = provider();
                    this.currentProvider = dnsServerAddressStreamProvider;
                }
                return dnsServerAddressStreamProvider.nameServerAddressStream(str);
            }
        };

        private DefaultProviderHolder() {
        }
    }

    static {
        Constructor<? extends DnsServerAddressStreamProvider> constructor = null;
        if (PlatformDependent.isOsx()) {
            try {
                Object doPrivileged = AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: io.netty.resolver.dns.DnsServerAddressStreamProviders.1
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        try {
                            return Class.forName("io.netty.resolver.dns.macos.MacOSDnsServerAddressStreamProvider", true, DnsServerAddressStreamProviders.class.getClassLoader());
                        } catch (Throwable th) {
                            return th;
                        }
                    }
                });
                if (doPrivileged instanceof Class) {
                    Class cls = (Class) doPrivileged;
                    cls.getMethod("ensureAvailability", new Class[0]).invoke(null, new Object[0]);
                    Constructor<? extends DnsServerAddressStreamProvider> constructor2 = cls.getConstructor(new Class[0]);
                    constructor2.newInstance(new Object[0]);
                    constructor = constructor2;
                } else if (!(doPrivileged instanceof ClassNotFoundException)) {
                    throw ((Throwable) doPrivileged);
                }
            } catch (Throwable th) {
                LOGGER.debug("Unable to use MacOSDnsServerAddressStreamProvider, fallback to system defaults", th);
            }
        }
        STREAM_PROVIDER_CONSTRUCTOR = constructor;
    }

    private DnsServerAddressStreamProviders() {
    }

    public static DnsServerAddressStreamProvider platformDefault() {
        Constructor<? extends DnsServerAddressStreamProvider> constructor = STREAM_PROVIDER_CONSTRUCTOR;
        if (constructor != null) {
            try {
                return (DnsServerAddressStreamProvider) constructor.newInstance(new Object[0]);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            }
        }
        return unixDefault();
    }

    public static DnsServerAddressStreamProvider unixDefault() {
        return DefaultProviderHolder.DEFAULT_DNS_SERVER_ADDRESS_STREAM_PROVIDER;
    }
}
