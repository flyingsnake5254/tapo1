package io.netty.channel.group;

import io.netty.channel.Channel;
import io.netty.channel.a;

/* loaded from: classes3.dex */
public final class ChannelMatchers {
    private static final ChannelMatcher ALL_MATCHER = new ChannelMatcher() { // from class: io.netty.channel.group.ChannelMatchers.1
        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return true;
        }
    };
    private static final ChannelMatcher SERVER_CHANNEL_MATCHER = isInstanceOf(a.class);
    private static final ChannelMatcher NON_SERVER_CHANNEL_MATCHER = isNotInstanceOf(a.class);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ClassMatcher implements ChannelMatcher {
        private final Class<? extends Channel> clazz;

        ClassMatcher(Class<? extends Channel> cls) {
            this.clazz = cls;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return this.clazz.isInstance(channel);
        }
    }

    /* loaded from: classes3.dex */
    private static final class CompositeMatcher implements ChannelMatcher {
        private final ChannelMatcher[] matchers;

        CompositeMatcher(ChannelMatcher... channelMatcherArr) {
            this.matchers = channelMatcherArr;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            for (ChannelMatcher channelMatcher : this.matchers) {
                if (!channelMatcher.matches(channel)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class InstanceMatcher implements ChannelMatcher {
        private final Channel channel;

        InstanceMatcher(Channel channel) {
            this.channel = channel;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return this.channel == channel;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class InvertMatcher implements ChannelMatcher {
        private final ChannelMatcher matcher;

        InvertMatcher(ChannelMatcher channelMatcher) {
            this.matcher = channelMatcher;
        }

        @Override // io.netty.channel.group.ChannelMatcher
        public boolean matches(Channel channel) {
            return !this.matcher.matches(channel);
        }
    }

    private ChannelMatchers() {
    }

    public static ChannelMatcher all() {
        return ALL_MATCHER;
    }

    public static ChannelMatcher compose(ChannelMatcher... channelMatcherArr) {
        if (channelMatcherArr.length < 1) {
            throw new IllegalArgumentException("matchers must at least contain one element");
        } else if (channelMatcherArr.length == 1) {
            return channelMatcherArr[0];
        } else {
            return new CompositeMatcher(channelMatcherArr);
        }
    }

    public static ChannelMatcher invert(ChannelMatcher channelMatcher) {
        return new InvertMatcher(channelMatcher);
    }

    public static ChannelMatcher is(Channel channel) {
        return new InstanceMatcher(channel);
    }

    public static ChannelMatcher isInstanceOf(Class<? extends Channel> cls) {
        return new ClassMatcher(cls);
    }

    public static ChannelMatcher isNonServerChannel() {
        return NON_SERVER_CHANNEL_MATCHER;
    }

    public static ChannelMatcher isNot(Channel channel) {
        return invert(is(channel));
    }

    public static ChannelMatcher isNotInstanceOf(Class<? extends Channel> cls) {
        return invert(isInstanceOf(cls));
    }

    public static ChannelMatcher isServerChannel() {
        return SERVER_CHANNEL_MATCHER;
    }
}
