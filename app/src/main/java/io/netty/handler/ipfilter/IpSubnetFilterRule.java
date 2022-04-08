package io.netty.handler.ipfilter;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.SocketUtils;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/* loaded from: classes3.dex */
public final class IpSubnetFilterRule implements IpFilterRule {
    private final IpFilterRule filterRule;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Ip4SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int networkAddress;
        private final IpFilterRuleType ruleType;
        private final int subnetMask;

        private static int ipToInt(Inet4Address inet4Address) {
            byte[] address = inet4Address.getAddress();
            return (address[3] & 255) | ((address[0] & 255) << 24) | ((address[1] & 255) << 16) | ((address[2] & 255) << 8);
        }

        private static int prefixToSubnetMask(int i) {
            return (int) ((-1) & ((-1) << (32 - i)));
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            return (address instanceof Inet4Address) && (ipToInt((Inet4Address) address) & this.subnetMask) == this.networkAddress;
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip4SubnetFilterRule(Inet4Address inet4Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i < 0 || i > 32) {
                throw new IllegalArgumentException(String.format("IPv4 requires the subnet prefix to be in range of [0,32]. The prefix was: %d", Integer.valueOf(i)));
            }
            int prefixToSubnetMask = prefixToSubnetMask(i);
            this.subnetMask = prefixToSubnetMask;
            this.networkAddress = ipToInt(inet4Address) & prefixToSubnetMask;
            this.ruleType = ipFilterRuleType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Ip6SubnetFilterRule implements IpFilterRule {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1);
        private final BigInteger networkAddress;
        private final IpFilterRuleType ruleType;
        private final BigInteger subnetMask;

        private static BigInteger ipToInt(Inet6Address inet6Address) {
            return new BigInteger(inet6Address.getAddress());
        }

        private static BigInteger prefixToSubnetMask(int i) {
            return MINUS_ONE.shiftLeft(128 - i);
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public boolean matches(InetSocketAddress inetSocketAddress) {
            InetAddress address = inetSocketAddress.getAddress();
            if (address instanceof Inet6Address) {
                return ipToInt((Inet6Address) address).and(this.subnetMask).equals(this.networkAddress);
            }
            return false;
        }

        @Override // io.netty.handler.ipfilter.IpFilterRule
        public IpFilterRuleType ruleType() {
            return this.ruleType;
        }

        private Ip6SubnetFilterRule(Inet6Address inet6Address, int i, IpFilterRuleType ipFilterRuleType) {
            if (i < 0 || i > 128) {
                throw new IllegalArgumentException(String.format("IPv6 requires the subnet prefix to be in range of [0,128]. The prefix was: %d", Integer.valueOf(i)));
            }
            BigInteger prefixToSubnetMask = prefixToSubnetMask(i);
            this.subnetMask = prefixToSubnetMask;
            this.networkAddress = ipToInt(inet6Address).and(prefixToSubnetMask);
            this.ruleType = ipFilterRuleType;
        }
    }

    public IpSubnetFilterRule(String str, int i, IpFilterRuleType ipFilterRuleType) {
        try {
            this.filterRule = selectFilterRule(SocketUtils.addressByName(str), i, ipFilterRuleType);
        } catch (UnknownHostException e2) {
            throw new IllegalArgumentException("ipAddress", e2);
        }
    }

    private static IpFilterRule selectFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        ObjectUtil.checkNotNull(inetAddress, "ipAddress");
        ObjectUtil.checkNotNull(ipFilterRuleType, "ruleType");
        if (inetAddress instanceof Inet4Address) {
            return new Ip4SubnetFilterRule((Inet4Address) inetAddress, i, ipFilterRuleType);
        }
        if (inetAddress instanceof Inet6Address) {
            return new Ip6SubnetFilterRule((Inet6Address) inetAddress, i, ipFilterRuleType);
        }
        throw new IllegalArgumentException("Only IPv4 and IPv6 addresses are supported");
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public boolean matches(InetSocketAddress inetSocketAddress) {
        return this.filterRule.matches(inetSocketAddress);
    }

    @Override // io.netty.handler.ipfilter.IpFilterRule
    public IpFilterRuleType ruleType() {
        return this.filterRule.ruleType();
    }

    public IpSubnetFilterRule(InetAddress inetAddress, int i, IpFilterRuleType ipFilterRuleType) {
        this.filterRule = selectFilterRule(inetAddress, i, ipFilterRuleType);
    }
}
