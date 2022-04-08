package io.netty.resolver.dns;

import io.netty.resolver.dns.UnixResolverOptions;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class UnixResolverDnsServerAddressStreamProvider implements DnsServerAddressStreamProvider {
    private static final String DOMAIN_ROW_LABEL = "domain";
    private static final String ETC_RESOLVER_DIR = "/etc/resolver";
    private static final String ETC_RESOLV_CONF_FILE = "/etc/resolv.conf";
    private static final String NAMESERVER_ROW_LABEL = "nameserver";
    private static final String OPTIONS_ROTATE_FLAG = "rotate";
    private static final String OPTIONS_ROW_LABEL = "options ";
    private static final String PORT_ROW_LABEL = "port";
    private static final String SEARCH_ROW_LABEL = "search";
    private static final String SORTLIST_ROW_LABEL = "sortlist";
    private final DnsServerAddresses defaultNameServerAddresses;
    private final Map<String, DnsServerAddresses> domainToNameServerStreamMap;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(UnixResolverDnsServerAddressStreamProvider.class);
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final String RES_OPTIONS = System.getenv("RES_OPTIONS");

    public UnixResolverDnsServerAddressStreamProvider(File file, File... fileArr) throws IOException {
        boolean z = true;
        Map<String, DnsServerAddresses> parse = parse((File) ObjectUtil.checkNotNull(file, "etcResolvConf"));
        z = (fileArr == null || fileArr.length == 0) ? false : z;
        Map<String, DnsServerAddresses> parse2 = z ? parse(fileArr) : parse;
        this.domainToNameServerStreamMap = parse2;
        DnsServerAddresses dnsServerAddresses = parse.get(file.getName());
        if (dnsServerAddresses == null) {
            Collection<DnsServerAddresses> values = parse.values();
            if (!values.isEmpty()) {
                this.defaultNameServerAddresses = values.iterator().next();
            } else {
                throw new IllegalArgumentException(file + " didn't provide any name servers");
            }
        } else {
            this.defaultNameServerAddresses = dnsServerAddresses;
        }
        if (z) {
            parse2.putAll(parse);
        }
    }

    private boolean mayOverrideNameServers() {
        return !this.domainToNameServerStreamMap.isEmpty() || this.defaultNameServerAddresses.stream().next() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x013b, code lost:
        throw new java.lang.IllegalArgumentException("error parsing label nameserver in file " + r9 + ". value: " + r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, io.netty.resolver.dns.DnsServerAddresses> parse(java.io.File... r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.parse(java.io.File[]):java.util.Map");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnixResolverOptions parseEtcResolverOptions() throws IOException {
        return parseEtcResolverOptions(new File(ETC_RESOLV_CONF_FILE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> parseEtcResolverSearchDomains() throws IOException {
        return parseEtcResolverSearchDomains(new File(ETC_RESOLV_CONF_FILE));
    }

    private static int parseResIntOption(String str, String str2) {
        return Integer.parseInt(str.substring(str2.length()));
    }

    private static void parseResOptions(String str, UnixResolverOptions.Builder builder) {
        String[] split;
        for (String str2 : WHITESPACE_PATTERN.split(str)) {
            try {
                if (str2.startsWith("ndots:")) {
                    builder.setNdots(parseResIntOption(str2, "ndots:"));
                } else if (str2.startsWith("attempts:")) {
                    builder.setAttempts(parseResIntOption(str2, "attempts:"));
                } else if (str2.startsWith("timeout:")) {
                    builder.setTimeout(parseResIntOption(str2, "timeout:"));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DnsServerAddressStreamProvider parseSilently() {
        try {
            UnixResolverDnsServerAddressStreamProvider unixResolverDnsServerAddressStreamProvider = new UnixResolverDnsServerAddressStreamProvider(ETC_RESOLV_CONF_FILE, ETC_RESOLVER_DIR);
            return unixResolverDnsServerAddressStreamProvider.mayOverrideNameServers() ? unixResolverDnsServerAddressStreamProvider : DefaultDnsServerAddressStreamProvider.INSTANCE;
        } catch (Exception e2) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("failed to parse {} and/or {}", ETC_RESOLV_CONF_FILE, ETC_RESOLVER_DIR, e2);
            }
            return DefaultDnsServerAddressStreamProvider.INSTANCE;
        }
    }

    private static void putIfAbsent(Map<String, DnsServerAddresses> map, String str, List<InetSocketAddress> list, boolean z) {
        DnsServerAddresses dnsServerAddresses;
        if (z) {
            dnsServerAddresses = DnsServerAddresses.rotational(list);
        } else {
            dnsServerAddresses = DnsServerAddresses.sequential(list);
        }
        putIfAbsent(map, str, dnsServerAddresses);
    }

    @Override // io.netty.resolver.dns.DnsServerAddressStreamProvider
    public DnsServerAddressStream nameServerAddressStream(String str) {
        while (true) {
            int indexOf = str.indexOf(46, 1);
            if (indexOf < 0 || indexOf == str.length() - 1) {
                break;
            }
            DnsServerAddresses dnsServerAddresses = this.domainToNameServerStreamMap.get(str);
            if (dnsServerAddresses != null) {
                return dnsServerAddresses.stream();
            }
            str = str.substring(indexOf + 1);
        }
        return this.defaultNameServerAddresses.stream();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001d, code lost:
        parseResOptions(r4.substring(8), r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static io.netty.resolver.dns.UnixResolverOptions parseEtcResolverOptions(java.io.File r4) throws java.io.IOException {
        /*
            io.netty.resolver.dns.UnixResolverOptions$Builder r0 = io.netty.resolver.dns.UnixResolverOptions.newBuilder()
            java.io.FileReader r1 = new java.io.FileReader
            r1.<init>(r4)
            r4 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: all -> 0x0037
            r2.<init>(r1)     // Catch: all -> 0x0037
        L_0x000f:
            java.lang.String r4 = r2.readLine()     // Catch: all -> 0x0035
            if (r4 == 0) goto L_0x0026
            java.lang.String r3 = "options "
            boolean r3 = r4.startsWith(r3)     // Catch: all -> 0x0035
            if (r3 == 0) goto L_0x000f
            r3 = 8
            java.lang.String r4 = r4.substring(r3)     // Catch: all -> 0x0035
            parseResOptions(r4, r0)     // Catch: all -> 0x0035
        L_0x0026:
            r2.close()
            java.lang.String r4 = io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.RES_OPTIONS
            if (r4 == 0) goto L_0x0030
            parseResOptions(r4, r0)
        L_0x0030:
            io.netty.resolver.dns.UnixResolverOptions r4 = r0.build()
            return r4
        L_0x0035:
            r4 = move-exception
            goto L_0x003a
        L_0x0037:
            r0 = move-exception
            r2 = r4
            r4 = r0
        L_0x003a:
            if (r2 != 0) goto L_0x0040
            r1.close()
            goto L_0x0043
        L_0x0040:
            r2.close()
        L_0x0043:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.resolver.dns.UnixResolverDnsServerAddressStreamProvider.parseEtcResolverOptions(java.io.File):io.netty.resolver.dns.UnixResolverOptions");
    }

    static List<String> parseEtcResolverSearchDomains(File file) throws IOException {
        Throwable th;
        BufferedReader bufferedReader;
        int indexOfNonWhiteSpace;
        ArrayList arrayList = new ArrayList();
        FileReader fileReader = new FileReader(file);
        String str = null;
        try {
            bufferedReader = new BufferedReader(fileReader);
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (str == null && readLine.startsWith(DOMAIN_ROW_LABEL)) {
                        int indexOfNonWhiteSpace2 = StringUtil.indexOfNonWhiteSpace(readLine, 6);
                        if (indexOfNonWhiteSpace2 >= 0) {
                            str = readLine.substring(indexOfNonWhiteSpace2);
                        }
                    } else if (readLine.startsWith("search") && (indexOfNonWhiteSpace = StringUtil.indexOfNonWhiteSpace(readLine, 6)) >= 0) {
                        Collections.addAll(arrayList, WHITESPACE_PATTERN.split(readLine.substring(indexOfNonWhiteSpace)));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader == null) {
                        fileReader.close();
                    } else {
                        bufferedReader.close();
                    }
                    throw th;
                }
            }
            bufferedReader.close();
            return (str == null || !arrayList.isEmpty()) ? arrayList : Collections.singletonList(str);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
        }
    }

    private static void putIfAbsent(Map<String, DnsServerAddresses> map, String str, DnsServerAddresses dnsServerAddresses) {
        DnsServerAddresses put = map.put(str, dnsServerAddresses);
        if (put != null) {
            map.put(str, put);
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("Domain name {} already maps to addresses {} so new addresses {} will be discarded", str, put, dnsServerAddresses);
            }
        }
    }

    public UnixResolverDnsServerAddressStreamProvider(String str, String str2) throws IOException {
        this(str == null ? null : new File(str), str2 != null ? new File(str2).listFiles() : null);
    }
}
