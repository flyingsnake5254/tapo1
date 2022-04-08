package io.netty.handler.codec.http;

import com.tplink.libtpmediastatistics.SSLClient;
import io.netty.handler.codec.DateFormatter;
import io.netty.handler.codec.http.cookie.CookieHeaderNames;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Deprecated
/* loaded from: classes3.dex */
public final class CookieDecoder {
    private static final String COMMENT = "Comment";
    private static final String COMMENTURL = "CommentURL";
    private static final String DISCARD = "Discard";
    private static final String PORT = "Port";
    private static final String VERSION = "Version";
    private final InternalLogger logger = InternalLoggerFactory.getInstance(CookieDecoder.class);
    private final boolean strict;
    private static final CookieDecoder STRICT = new CookieDecoder(true);
    private static final CookieDecoder LAX = new CookieDecoder(false);

    private CookieDecoder(boolean z) {
        this.strict = z;
    }

    public static Set<Cookie> decode(String str) {
        return decode(str, true);
    }

    private Set<Cookie> doDecode(String str) {
        int i;
        int i2;
        ArrayList arrayList = new ArrayList(8);
        ArrayList arrayList2 = new ArrayList(8);
        extractKeyValuePairs(str, arrayList, arrayList2);
        if (arrayList.isEmpty()) {
            return Collections.emptySet();
        }
        if (((String) arrayList.get(0)).equalsIgnoreCase(VERSION)) {
            try {
                i = Integer.parseInt((String) arrayList2.get(0));
            } catch (NumberFormatException unused) {
                i = 0;
            }
            i2 = 1;
        } else {
            i = 0;
            i2 = 0;
        }
        if (arrayList.size() <= i2) {
            return Collections.emptySet();
        }
        TreeSet treeSet = new TreeSet();
        while (i2 < arrayList.size()) {
            String str2 = (String) arrayList.get(i2);
            String str3 = (String) arrayList2.get(i2);
            if (str3 == null) {
                str3 = "";
            }
            DefaultCookie initCookie = initCookie(str2, str3);
            if (initCookie == null) {
                break;
            }
            long j = Long.MIN_VALUE;
            ArrayList arrayList3 = new ArrayList(2);
            int i3 = i2 + 1;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            while (true) {
                if (i3 >= arrayList.size()) {
                    arrayList = arrayList;
                    arrayList2 = arrayList2;
                    break;
                }
                String str8 = (String) arrayList.get(i3);
                arrayList = arrayList;
                String str9 = (String) arrayList2.get(i3);
                arrayList2 = arrayList2;
                if (!DISCARD.equalsIgnoreCase(str8)) {
                    if (!CookieHeaderNames.SECURE.equalsIgnoreCase(str8)) {
                        if (!CookieHeaderNames.HTTPONLY.equalsIgnoreCase(str8)) {
                            if (!COMMENT.equalsIgnoreCase(str8)) {
                                if (!COMMENTURL.equalsIgnoreCase(str8)) {
                                    if (!CookieHeaderNames.DOMAIN.equalsIgnoreCase(str8)) {
                                        if (!CookieHeaderNames.PATH.equalsIgnoreCase(str8)) {
                                            if (!"Expires".equalsIgnoreCase(str8)) {
                                                if (!CookieHeaderNames.MAX_AGE.equalsIgnoreCase(str8)) {
                                                    if (!VERSION.equalsIgnoreCase(str8)) {
                                                        if (!PORT.equalsIgnoreCase(str8)) {
                                                            break;
                                                        }
                                                        String[] split = str9.split(SSLClient.COMMA);
                                                        int length = split.length;
                                                        int i4 = 0;
                                                        while (i4 < length) {
                                                            try {
                                                                arrayList3.add(Integer.valueOf(split[i4]));
                                                            } catch (NumberFormatException unused2) {
                                                            }
                                                            i4++;
                                                            split = split;
                                                        }
                                                    } else {
                                                        i = Integer.parseInt(str9);
                                                    }
                                                } else {
                                                    j = Integer.parseInt(str9);
                                                }
                                            } else {
                                                Date parseHttpDate = DateFormatter.parseHttpDate(str9);
                                                if (parseHttpDate != null) {
                                                    long time = parseHttpDate.getTime() - System.currentTimeMillis();
                                                    j = (time / 1000) + (time % 1000 != 0 ? 1 : 0);
                                                }
                                            }
                                        } else {
                                            str6 = str9;
                                        }
                                    } else {
                                        str5 = str9;
                                    }
                                } else {
                                    str7 = str9;
                                }
                            } else {
                                str4 = str9;
                            }
                        } else {
                            z2 = true;
                        }
                    } else {
                        z = true;
                    }
                } else {
                    z3 = true;
                }
                i3++;
                i2++;
                arrayList2 = arrayList2;
                arrayList = arrayList;
            }
            initCookie.setVersion(i);
            initCookie.setMaxAge(j);
            initCookie.setPath(str6);
            initCookie.setDomain(str5);
            initCookie.setSecure(z);
            initCookie.setHttpOnly(z2);
            if (i > 0) {
                initCookie.setComment(str4);
            }
            if (i > 1) {
                initCookie.setCommentUrl(str7);
                initCookie.setPorts(arrayList3);
                initCookie.setDiscard(z3);
            }
            treeSet.add(initCookie);
            i2++;
            treeSet = treeSet;
        }
        return treeSet;
    }

    private static void extractKeyValuePairs(String str, List<String> list, List<String> list2) {
        String str2;
        int length = str.length();
        int i = 0;
        while (i != length) {
            char charAt = str.charAt(i);
            if (!(charAt == ' ' || charAt == ',' || charAt == ';')) {
                switch (charAt) {
                    case '\t':
                    case '\n':
                    case 11:
                    case '\f':
                    case '\r':
                        break;
                    default:
                        while (i != length) {
                            if (str.charAt(i) == '$') {
                                i++;
                            } else {
                                String str3 = null;
                                if (i == length) {
                                    str2 = null;
                                } else {
                                    i = i;
                                    while (true) {
                                        char charAt2 = str.charAt(i);
                                        if (charAt2 == ';') {
                                            str3 = str.substring(i, i);
                                        } else if (charAt2 != '=') {
                                            i++;
                                            if (i == length) {
                                                str3 = str.substring(i);
                                            }
                                        } else {
                                            String substring = str.substring(i, i);
                                            i++;
                                            if (i == length) {
                                                str2 = "";
                                            } else {
                                                char charAt3 = str.charAt(i);
                                                if (charAt3 == '\"' || charAt3 == '\'') {
                                                    StringBuilder sb = new StringBuilder(str.length() - i);
                                                    i++;
                                                    while (true) {
                                                        boolean z = false;
                                                        while (i != length) {
                                                            if (z) {
                                                                i++;
                                                                char charAt4 = str.charAt(i);
                                                                if (charAt4 == '\"' || charAt4 == '\'' || charAt4 == '\\') {
                                                                    sb.setCharAt(sb.length() - 1, charAt4);
                                                                } else {
                                                                    sb.append(charAt4);
                                                                }
                                                            } else {
                                                                int i2 = i + 1;
                                                                char charAt5 = str.charAt(i);
                                                                if (charAt5 == charAt3) {
                                                                    str2 = sb.toString();
                                                                    str3 = substring;
                                                                    i = i2;
                                                                } else {
                                                                    sb.append(charAt5);
                                                                    if (charAt5 == '\\') {
                                                                        i = i2;
                                                                        z = true;
                                                                    } else {
                                                                        i = i2;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        str2 = sb.toString();
                                                    }
                                                } else {
                                                    i = str.indexOf(59, i);
                                                    if (i > 0) {
                                                        str2 = str.substring(i, i);
                                                    } else {
                                                        str2 = str.substring(i);
                                                        i = length;
                                                    }
                                                    str3 = substring;
                                                }
                                            }
                                            str3 = substring;
                                        }
                                    }
                                    str2 = null;
                                }
                                list.add(str3);
                                list2.add(str2);
                                continue;
                            }
                        }
                        return;
                }
            }
            i++;
        }
    }

    private DefaultCookie initCookie(String str, String str2) {
        int firstInvalidCookieValueOctet;
        int firstInvalidCookieNameOctet;
        if (str == null || str.length() == 0) {
            this.logger.debug("Skipping cookie with null name");
            return null;
        } else if (str2 == null) {
            this.logger.debug("Skipping cookie with null value");
            return null;
        } else {
            CharSequence unwrapValue = CookieUtil.unwrapValue(str2);
            if (unwrapValue == null) {
                this.logger.debug("Skipping cookie because starting quotes are not properly balanced in '{}'", unwrapValue);
                return null;
            } else if (!this.strict || (firstInvalidCookieNameOctet = CookieUtil.firstInvalidCookieNameOctet(str)) < 0) {
                boolean z = unwrapValue.length() != str2.length();
                if (!this.strict || (firstInvalidCookieValueOctet = CookieUtil.firstInvalidCookieValueOctet(unwrapValue)) < 0) {
                    DefaultCookie defaultCookie = new DefaultCookie(str, unwrapValue.toString());
                    defaultCookie.setWrap(z);
                    return defaultCookie;
                }
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because value '{}' contains invalid char '{}'", unwrapValue, Character.valueOf(unwrapValue.charAt(firstInvalidCookieValueOctet)));
                }
                return null;
            } else {
                if (this.logger.isDebugEnabled()) {
                    this.logger.debug("Skipping cookie because name '{}' contains invalid char '{}'", str, Character.valueOf(str.charAt(firstInvalidCookieNameOctet)));
                }
                return null;
            }
        }
    }

    public static Set<Cookie> decode(String str, boolean z) {
        return (z ? STRICT : LAX).doDecode(str);
    }
}
