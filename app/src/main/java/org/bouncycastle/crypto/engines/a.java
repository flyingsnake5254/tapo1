package org.bouncycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheRequest;
import io.netty.handler.codec.memcache.binary.DefaultBinaryMemcacheResponse;
import java.lang.reflect.Array;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.c;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.util.f;

/* loaded from: classes4.dex */
public class a implements c {
    private static final byte[] a = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, -91, -27, -15, 113, -40, 49, BinaryMemcacheOpcodes.INCREMENTQ, 4, -57, BinaryMemcacheOpcodes.GATK, -61, BinaryMemcacheOpcodes.FLUSHQ, -106, 5, -102, 7, BinaryMemcacheOpcodes.ADDQ, DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE, -30, -21, 39, -78, 117, 9, -125, HttpConstants.COMMA, BinaryMemcacheOpcodes.PREPENDQ, 27, 110, 90, -96, 82, HttpConstants.SEMICOLON, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, -68, -74, -38, BinaryMemcacheOpcodes.SASL_AUTH, BinaryMemcacheOpcodes.STAT, -1, -13, -46, -51, 12, BinaryMemcacheOpcodes.REPLACEQ, -20, 95, -105, 68, BinaryMemcacheOpcodes.QUITQ, -60, -89, 126, HttpConstants.EQUALS, 100, 93, BinaryMemcacheOpcodes.APPENDQ, 115, 96, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, 79, -36, 34, 42, -112, -120, 70, -18, -72, BinaryMemcacheOpcodes.DELETEQ, -34, 94, 11, -37, -32, 50, HttpConstants.COLON, 10, 73, 6, BinaryMemcacheOpcodes.GATKQ, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, BinaryMemcacheOpcodes.TOUCH, -90, -76, -58, -24, -35, 116, 31, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, BinaryMemcacheOpcodes.GAT, -98, -31, -8, -104, BinaryMemcacheOpcodes.SETQ, 105, -39, -114, -108, -101, BinaryMemcacheOpcodes.GATQ, -121, -23, -50, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, 45, BinaryMemcacheOpcodes.PREPEND, -80, 84, -69, BinaryMemcacheOpcodes.DECREMENTQ};

    /* renamed from: b  reason: collision with root package name */
    private static final byte[] f17067b = {82, 9, 106, -43, 48, 54, -91, 56, -65, 64, -93, -98, DefaultBinaryMemcacheResponse.RESPONSE_MAGIC_BYTE, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, -90, -62, BinaryMemcacheOpcodes.GATK, HttpConstants.EQUALS, -18, 76, -107, 11, 66, -6, -61, 78, 8, 46, -95, 102, 40, -39, BinaryMemcacheOpcodes.GATKQ, -78, 118, 91, -94, 73, 109, -117, -47, 37, 114, -8, -10, 100, -122, 104, -104, BinaryMemcacheOpcodes.DECREMENTQ, -44, -92, 92, -52, 93, 101, -74, -110, 108, 112, 72, 80, -3, -19, -71, -38, 94, BinaryMemcacheOpcodes.INCREMENTQ, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, -68, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, HttpConstants.COMMA, BinaryMemcacheOpcodes.GATQ, -113, -54, 63, BinaryMemcacheOpcodes.PREPEND, 2, -63, -81, -67, 3, 1, BinaryMemcacheOpcodes.REPLACEQ, -118, 107, HttpConstants.COLON, -111, BinaryMemcacheOpcodes.SETQ, 65, 79, 103, -36, -22, -105, -14, -49, -50, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, BinaryMemcacheOpcodes.TOUCH, 117, -33, 110, 71, -15, BinaryMemcacheOpcodes.PREPENDQ, 113, BinaryMemcacheOpcodes.GAT, 41, -59, -119, 111, -73, 98, 14, -86, BinaryMemcacheOpcodes.FLUSHQ, -66, 27, -4, 86, 62, 75, -58, -46, 121, 32, -102, -37, -64, -2, 120, -51, 90, -12, 31, -35, -88, 51, -120, 7, -57, 49, -79, BinaryMemcacheOpcodes.ADDQ, BinaryMemcacheOpcodes.STAT, 89, 39, DefaultBinaryMemcacheRequest.REQUEST_MAGIC_BYTE, -20, 95, 96, 81, Byte.MAX_VALUE, -87, BinaryMemcacheOpcodes.APPENDQ, -75, 74, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, HttpConstants.SEMICOLON, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, BinaryMemcacheOpcodes.QUITQ, 43, 4, 126, -70, 119, -42, 38, -31, 105, BinaryMemcacheOpcodes.DELETEQ, 99, 85, BinaryMemcacheOpcodes.SASL_AUTH, 12, 125};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f17068c = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, 197, 145};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f17069d = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f17070e = {1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};

    /* renamed from: f  reason: collision with root package name */
    private int f17071f;
    private int[][] g = null;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l;
    private byte[] m;

    private static int c(int i) {
        return (((i & (-2139062144)) >>> 7) * 27) ^ ((2139062143 & i) << 1);
    }

    private static int e(int i) {
        int i2 = i & (-1061109568);
        int i3 = i2 ^ (i2 >>> 1);
        return (i3 >>> 5) ^ (((1061109567 & i) << 2) ^ (i3 >>> 2));
    }

    private void f(int[][] iArr) {
        int i = this.h;
        int i2 = this.f17071f;
        char c2 = 0;
        int i3 = i ^ iArr[i2][0];
        int i4 = 1;
        int i5 = this.i ^ iArr[i2][1];
        int i6 = this.j ^ iArr[i2][2];
        int i7 = i2 - 1;
        int i8 = iArr[i2][3] ^ this.k;
        while (i7 > i4) {
            int[] iArr2 = f17070e;
            int k = (((iArr2[i3 & 255] ^ k(iArr2[(i8 >> 8) & 255], 24)) ^ k(iArr2[(i6 >> 16) & 255], 16)) ^ k(iArr2[(i5 >> 24) & 255], 8)) ^ iArr[i7][c2];
            int k2 = (((k(iArr2[(i3 >> 8) & 255], 24) ^ iArr2[i5 & 255]) ^ k(iArr2[(i8 >> 16) & 255], 16)) ^ k(iArr2[(i6 >> 24) & 255], 8)) ^ iArr[i7][i4];
            int k3 = (((k(iArr2[(i5 >> 8) & 255], 24) ^ iArr2[i6 & 255]) ^ k(iArr2[(i3 >> 16) & 255], 16)) ^ k(iArr2[(i8 >> 24) & 255], 8)) ^ iArr[i7][2];
            int k4 = k(iArr2[(i3 >> 24) & 255], 8) ^ ((iArr2[i8 & 255] ^ k(iArr2[(i6 >> 8) & 255], 24)) ^ k(iArr2[(i5 >> 16) & 255], 16));
            int i9 = i7 - 1;
            int i10 = k4 ^ iArr[i7][3];
            i3 = (((iArr2[k & 255] ^ k(iArr2[(i10 >> 8) & 255], 24)) ^ k(iArr2[(k3 >> 16) & 255], 16)) ^ k(iArr2[(k2 >> 24) & 255], 8)) ^ iArr[i9][0];
            i5 = (((iArr2[k2 & 255] ^ k(iArr2[(k >> 8) & 255], 24)) ^ k(iArr2[(i10 >> 16) & 255], 16)) ^ k(iArr2[(k3 >> 24) & 255], 8)) ^ iArr[i9][1];
            i6 = (((iArr2[k3 & 255] ^ k(iArr2[(k2 >> 8) & 255], 24)) ^ k(iArr2[(k >> 16) & 255], 16)) ^ k(iArr2[(i10 >> 24) & 255], 8)) ^ iArr[i9][2];
            i7 = i9 - 1;
            i8 = iArr[i9][3] ^ (((iArr2[i10 & 255] ^ k(iArr2[(k3 >> 8) & 255], 24)) ^ k(iArr2[(k2 >> 16) & 255], 16)) ^ k(iArr2[(k >> 24) & 255], 8));
            i4 = 1;
            c2 = 0;
        }
        int[] iArr3 = f17070e;
        int k5 = (((iArr3[i3 & 255] ^ k(iArr3[(i8 >> 8) & 255], 24)) ^ k(iArr3[(i6 >> 16) & 255], 16)) ^ k(iArr3[(i5 >> 24) & 255], 8)) ^ iArr[i7][0];
        int k6 = (((iArr3[i5 & 255] ^ k(iArr3[(i3 >> 8) & 255], 24)) ^ k(iArr3[(i8 >> 16) & 255], 16)) ^ k(iArr3[(i6 >> 24) & 255], 8)) ^ iArr[i7][1];
        int k7 = (((iArr3[i6 & 255] ^ k(iArr3[(i5 >> 8) & 255], 24)) ^ k(iArr3[(i3 >> 16) & 255], 16)) ^ k(iArr3[(i8 >> 24) & 255], 8)) ^ iArr[i7][2];
        int k8 = (k(iArr3[(i3 >> 24) & 255], 8) ^ ((iArr3[i8 & 255] ^ k(iArr3[(i6 >> 8) & 255], 24)) ^ k(iArr3[(i5 >> 16) & 255], 16))) ^ iArr[i7][3];
        byte[] bArr = f17067b;
        byte[] bArr2 = this.m;
        this.h = ((((bArr[k5 & 255] & 255) ^ ((bArr2[(k8 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(k7 >> 16) & 255] & 255) << 16)) ^ (bArr[(k6 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[0][0];
        this.i = ((((bArr2[k6 & 255] & 255) ^ ((bArr2[(k5 >> 8) & 255] & 255) << 8)) ^ ((bArr[(k8 >> 16) & 255] & 255) << 16)) ^ (bArr2[(k7 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[0][1];
        this.j = ((((bArr2[k7 & 255] & 255) ^ ((bArr[(k6 >> 8) & 255] & 255) << 8)) ^ ((bArr[(k5 >> 16) & 255] & 255) << 16)) ^ (bArr2[(k8 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[0][2];
        this.k = ((((bArr[k8 & 255] & 255) ^ ((bArr2[(k7 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(k6 >> 16) & 255] & 255) << 16)) ^ (bArr2[(k5 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[0][3];
    }

    private void g(int[][] iArr) {
        char c2 = 0;
        int i = this.h ^ iArr[0][0];
        int i2 = 1;
        int i3 = this.i ^ iArr[0][1];
        int i4 = this.j ^ iArr[0][2];
        int i5 = this.k ^ iArr[0][3];
        int i6 = 1;
        while (i6 < this.f17071f - i2) {
            int[] iArr2 = f17069d;
            int k = (((iArr2[i & 255] ^ k(iArr2[(i3 >> 8) & 255], 24)) ^ k(iArr2[(i4 >> 16) & 255], 16)) ^ k(iArr2[(i5 >> 24) & 255], 8)) ^ iArr[i6][c2];
            int k2 = (((k(iArr2[(i4 >> 8) & 255], 24) ^ iArr2[i3 & 255]) ^ k(iArr2[(i5 >> 16) & 255], 16)) ^ k(iArr2[(i >> 24) & 255], 8)) ^ iArr[i6][i2];
            int k3 = (((k(iArr2[(i5 >> 8) & 255], 24) ^ iArr2[i4 & 255]) ^ k(iArr2[(i >> 16) & 255], 16)) ^ k(iArr2[(i3 >> 24) & 255], 8)) ^ iArr[i6][2];
            int k4 = ((k(iArr2[(i >> 8) & 255], 24) ^ iArr2[i5 & 255]) ^ k(iArr2[(i3 >> 16) & 255], 16)) ^ k(iArr2[(i4 >> 24) & 255], 8);
            int i7 = i6 + 1;
            int i8 = k4 ^ iArr[i6][3];
            i = (((iArr2[k & 255] ^ k(iArr2[(k2 >> 8) & 255], 24)) ^ k(iArr2[(k3 >> 16) & 255], 16)) ^ k(iArr2[(i8 >> 24) & 255], 8)) ^ iArr[i7][0];
            i3 = (((iArr2[k2 & 255] ^ k(iArr2[(k3 >> 8) & 255], 24)) ^ k(iArr2[(i8 >> 16) & 255], 16)) ^ k(iArr2[(k >> 24) & 255], 8)) ^ iArr[i7][1];
            i4 = (((iArr2[k3 & 255] ^ k(iArr2[(i8 >> 8) & 255], 24)) ^ k(iArr2[(k >> 16) & 255], 16)) ^ k(iArr2[(k2 >> 24) & 255], 8)) ^ iArr[i7][2];
            i6 = i7 + 1;
            i5 = (((iArr2[i8 & 255] ^ k(iArr2[(k >> 8) & 255], 24)) ^ k(iArr2[(k2 >> 16) & 255], 16)) ^ k(iArr2[(k3 >> 24) & 255], 8)) ^ iArr[i7][3];
            i2 = 1;
            c2 = 0;
        }
        int[] iArr3 = f17069d;
        int k5 = (((iArr3[i & 255] ^ k(iArr3[(i3 >> 8) & 255], 24)) ^ k(iArr3[(i4 >> 16) & 255], 16)) ^ k(iArr3[(i5 >> 24) & 255], 8)) ^ iArr[i6][0];
        int k6 = (((iArr3[i3 & 255] ^ k(iArr3[(i4 >> 8) & 255], 24)) ^ k(iArr3[(i5 >> 16) & 255], 16)) ^ k(iArr3[(i >> 24) & 255], 8)) ^ iArr[i6][1];
        int k7 = (((iArr3[i4 & 255] ^ k(iArr3[(i5 >> 8) & 255], 24)) ^ k(iArr3[(i >> 16) & 255], 16)) ^ k(iArr3[(i3 >> 24) & 255], 8)) ^ iArr[i6][2];
        int k8 = ((k(iArr3[(i >> 8) & 255], 24) ^ iArr3[i5 & 255]) ^ k(iArr3[(i3 >> 16) & 255], 16)) ^ k(iArr3[(i4 >> 24) & 255], 8);
        int i9 = i6 + 1;
        int i10 = k8 ^ iArr[i6][3];
        byte[] bArr = a;
        int i11 = (bArr[k5 & 255] & 255) ^ ((bArr[(k6 >> 8) & 255] & 255) << 8);
        byte[] bArr2 = this.m;
        this.h = ((i11 ^ ((bArr2[(k7 >> 16) & 255] & 255) << 16)) ^ (bArr2[(i10 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[i9][0];
        this.i = ((((bArr2[k6 & 255] & 255) ^ ((bArr[(k7 >> 8) & 255] & 255) << 8)) ^ ((bArr[(i10 >> 16) & 255] & 255) << 16)) ^ (bArr2[(k5 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[i9][1];
        this.j = ((((bArr2[k7 & 255] & 255) ^ ((bArr[(i10 >> 8) & 255] & 255) << 8)) ^ ((bArr[(k5 >> 16) & 255] & 255) << 16)) ^ (bArr[(k6 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[i9][2];
        this.k = ((((bArr2[i10 & 255] & 255) ^ ((bArr2[(k5 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(k6 >> 16) & 255] & 255) << 16)) ^ (bArr[(k7 >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ)) ^ iArr[i9][3];
    }

    private int[][] h(byte[] bArr, boolean z) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i = length >>> 2;
        int i2 = i + 6;
        this.f17071f = i2;
        int[][] iArr = (int[][]) Array.newInstance(int.class, i2 + 1, 4);
        if (i == 4) {
            int g = f.g(bArr, 0);
            iArr[0][0] = g;
            int g2 = f.g(bArr, 4);
            iArr[0][1] = g2;
            int g3 = f.g(bArr, 8);
            iArr[0][2] = g3;
            int g4 = f.g(bArr, 12);
            iArr[0][3] = g4;
            for (int i3 = 1; i3 <= 10; i3++) {
                g ^= l(k(g4, 8)) ^ f17068c[i3 - 1];
                iArr[i3][0] = g;
                g2 ^= g;
                iArr[i3][1] = g2;
                g3 ^= g2;
                iArr[i3][2] = g3;
                g4 ^= g3;
                iArr[i3][3] = g4;
            }
        } else if (i == 6) {
            int g5 = f.g(bArr, 0);
            iArr[0][0] = g5;
            int g6 = f.g(bArr, 4);
            iArr[0][1] = g6;
            int g7 = f.g(bArr, 8);
            iArr[0][2] = g7;
            int g8 = f.g(bArr, 12);
            iArr[0][3] = g8;
            int g9 = f.g(bArr, 16);
            iArr[1][0] = g9;
            int g10 = f.g(bArr, 20);
            iArr[1][1] = g10;
            int l = g5 ^ (l(k(g10, 8)) ^ 1);
            iArr[1][2] = l;
            int i4 = g6 ^ l;
            iArr[1][3] = i4;
            int i5 = g7 ^ i4;
            iArr[2][0] = i5;
            int i6 = g8 ^ i5;
            iArr[2][1] = i6;
            int i7 = g9 ^ i6;
            iArr[2][2] = i7;
            int i8 = g10 ^ i7;
            iArr[2][3] = i8;
            int i9 = 2;
            for (int i10 = 3; i10 < 12; i10 += 3) {
                int l2 = l(k(i8, 8)) ^ i9;
                int i11 = i9 << 1;
                int i12 = l ^ l2;
                iArr[i10][0] = i12;
                int i13 = i4 ^ i12;
                iArr[i10][1] = i13;
                int i14 = i5 ^ i13;
                iArr[i10][2] = i14;
                int i15 = i6 ^ i14;
                iArr[i10][3] = i15;
                int i16 = i7 ^ i15;
                int i17 = i10 + 1;
                iArr[i17][0] = i16;
                int i18 = i8 ^ i16;
                iArr[i17][1] = i18;
                int l3 = l(k(i18, 8)) ^ i11;
                i9 = i11 << 1;
                l = i12 ^ l3;
                iArr[i17][2] = l;
                i4 = i13 ^ l;
                iArr[i17][3] = i4;
                i5 = i14 ^ i4;
                int i19 = i10 + 2;
                iArr[i19][0] = i5;
                i6 = i15 ^ i5;
                iArr[i19][1] = i6;
                i7 = i16 ^ i6;
                iArr[i19][2] = i7;
                i8 = i18 ^ i7;
                iArr[i19][3] = i8;
            }
            int l4 = (l(k(i8, 8)) ^ i9) ^ l;
            iArr[12][0] = l4;
            int i20 = l4 ^ i4;
            iArr[12][1] = i20;
            int i21 = i20 ^ i5;
            iArr[12][2] = i21;
            iArr[12][3] = i21 ^ i6;
        } else if (i == 8) {
            int g11 = f.g(bArr, 0);
            iArr[0][0] = g11;
            int g12 = f.g(bArr, 4);
            iArr[0][1] = g12;
            int g13 = f.g(bArr, 8);
            iArr[0][2] = g13;
            int g14 = f.g(bArr, 12);
            iArr[0][3] = g14;
            int g15 = f.g(bArr, 16);
            iArr[1][0] = g15;
            int g16 = f.g(bArr, 20);
            iArr[1][1] = g16;
            int g17 = f.g(bArr, 24);
            iArr[1][2] = g17;
            int g18 = f.g(bArr, 28);
            iArr[1][3] = g18;
            int i22 = 1;
            for (int i23 = 2; i23 < 14; i23 += 2) {
                int l5 = l(k(g18, 8)) ^ i22;
                i22 <<= 1;
                g11 ^= l5;
                iArr[i23][0] = g11;
                g12 ^= g11;
                iArr[i23][1] = g12;
                g13 ^= g12;
                iArr[i23][2] = g13;
                g14 ^= g13;
                iArr[i23][3] = g14;
                g15 ^= l(g14);
                int i24 = i23 + 1;
                iArr[i24][0] = g15;
                g16 ^= g15;
                iArr[i24][1] = g16;
                g17 ^= g16;
                iArr[i24][2] = g17;
                g18 ^= g17;
                iArr[i24][3] = g18;
            }
            int l6 = (l(k(g18, 8)) ^ i22) ^ g11;
            iArr[14][0] = l6;
            int i25 = l6 ^ g12;
            iArr[14][1] = i25;
            int i26 = i25 ^ g13;
            iArr[14][2] = i26;
            iArr[14][3] = i26 ^ g14;
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z) {
            for (int i27 = 1; i27 < this.f17071f; i27++) {
                for (int i28 = 0; i28 < 4; i28++) {
                    iArr[i27][i28] = i(iArr[i27][i28]);
                }
            }
        }
        return iArr;
    }

    private static int i(int i) {
        int k = k(i, 8) ^ i;
        int c2 = i ^ c(k);
        int e2 = k ^ e(c2);
        return c2 ^ (e2 ^ k(e2, 16));
    }

    private void j(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.h;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.i;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.j;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.k;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    private static int k(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private static int l(int i) {
        byte[] bArr = a;
        return (bArr[(i >> 24) & 255] << BinaryMemcacheOpcodes.FLUSHQ) | (bArr[i & 255] & 255) | ((bArr[(i >> 8) & 255] & 255) << 8) | ((bArr[(i >> 16) & 255] & 255) << 16);
    }

    private void m(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.h = i3;
        int i4 = i2 + 1;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        this.h = i5;
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.h = i7;
        int i8 = i6 + 1;
        this.h = i7 | (bArr[i6] << BinaryMemcacheOpcodes.FLUSHQ);
        int i9 = i8 + 1;
        int i10 = bArr[i8] & 255;
        this.i = i10;
        int i11 = i9 + 1;
        int i12 = ((bArr[i9] & 255) << 8) | i10;
        this.i = i12;
        int i13 = i11 + 1;
        int i14 = i12 | ((bArr[i11] & 255) << 16);
        this.i = i14;
        int i15 = i13 + 1;
        this.i = i14 | (bArr[i13] << BinaryMemcacheOpcodes.FLUSHQ);
        int i16 = i15 + 1;
        int i17 = bArr[i15] & 255;
        this.j = i17;
        int i18 = i16 + 1;
        int i19 = ((bArr[i16] & 255) << 8) | i17;
        this.j = i19;
        int i20 = i18 + 1;
        int i21 = i19 | ((bArr[i18] & 255) << 16);
        this.j = i21;
        int i22 = i20 + 1;
        this.j = i21 | (bArr[i20] << BinaryMemcacheOpcodes.FLUSHQ);
        int i23 = i22 + 1;
        int i24 = bArr[i22] & 255;
        this.k = i24;
        int i25 = i23 + 1;
        int i26 = ((bArr[i23] & 255) << 8) | i24;
        this.k = i26;
        int i27 = i26 | ((bArr[i25] & 255) << 16);
        this.k = i27;
        this.k = (bArr[i25 + 1] << BinaryMemcacheOpcodes.FLUSHQ) | i27;
    }

    @Override // org.bouncycastle.crypto.c
    public void a(boolean z, e eVar) {
        if (eVar instanceof a0) {
            this.g = h(((a0) eVar).a(), z);
            this.l = z;
            if (z) {
                this.m = org.bouncycastle.util.a.g(a);
            } else {
                this.m = org.bouncycastle.util.a.g(f17067b);
            }
        } else {
            throw new IllegalArgumentException("invalid parameter passed to AES init - " + eVar.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.c
    public String b() {
        return "AES";
    }

    @Override // org.bouncycastle.crypto.c
    public int d(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.g == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            boolean z = this.l;
            m(bArr, i);
            int[][] iArr = this.g;
            if (z) {
                g(iArr);
            } else {
                f(iArr);
            }
            j(bArr2, i2);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    @Override // org.bouncycastle.crypto.c
    public int getBlockSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.c
    public void reset() {
    }
}
