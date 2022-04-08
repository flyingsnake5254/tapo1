package io.netty.resolver.dns;

import io.netty.channel.EventLoop;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import java.util.List;

/* loaded from: classes3.dex */
public final class DefaultDnsCnameCache implements DnsCnameCache {
    private final Cache<String> cache;
    private final int maxTtl;
    private final int minTtl;

    public DefaultDnsCnameCache() {
        this(0, Cache.MAX_SUPPORTED_TTL_SECS);
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void cache(String str, String str2, long j, EventLoop eventLoop) {
        ObjectUtil.checkNotNull(str, "hostname");
        ObjectUtil.checkNotNull(str2, "cname");
        ObjectUtil.checkNotNull(eventLoop, "loop");
        this.cache.cache(str, str2, Math.max(this.minTtl, (int) Math.min(this.maxTtl, j)), eventLoop);
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public void clear() {
        this.cache.clear();
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public String get(String str) {
        List<? extends String> list = this.cache.get((String) ObjectUtil.checkNotNull(str, "hostname"));
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (String) list.get(0);
    }

    public DefaultDnsCnameCache(int i, int i2) {
        this.cache = new Cache<String>() { // from class: io.netty.resolver.dns.DefaultDnsCnameCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            public boolean shouldReplaceAll(String str) {
                return true;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            public boolean equals(String str, String str2) {
                return AsciiString.contentEqualsIgnoreCase(str, str2);
            }
        };
        int i3 = Cache.MAX_SUPPORTED_TTL_SECS;
        this.minTtl = Math.min(i3, ObjectUtil.checkPositiveOrZero(i, "minTtl"));
        this.maxTtl = Math.min(i3, ObjectUtil.checkPositive(i2, "maxTtl"));
        if (i > i2) {
            throw new IllegalArgumentException("minTtl: " + i + ", maxTtl: " + i2 + " (expected: 0 <= minTtl <= maxTtl)");
        }
    }

    @Override // io.netty.resolver.dns.DnsCnameCache
    public boolean clear(String str) {
        return this.cache.clear((String) ObjectUtil.checkNotNull(str, "hostname"));
    }
}
