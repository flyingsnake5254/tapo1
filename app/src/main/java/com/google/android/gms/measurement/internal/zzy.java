package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzy extends zzke {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzt> zzc;
    private Long zzd;
    private Long zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzkn zzknVar) {
        super(zzknVar);
    }

    private final zzt zzc(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzt zztVar = new zzt(this, this.zza, null);
        this.zzc.put(num, zztVar);
        return zztVar;
    }

    private final boolean zzd(int i, int i2) {
        zzt zztVar = this.zzc.get(Integer.valueOf(i));
        if (zztVar == null) {
            return false;
        }
        return zzt.zzc(zztVar).get(i2);
    }

    @Override // com.google.android.gms.measurement.internal.zzke
    protected final boolean zzaA() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(17:(6:18|425|19|396|20|(21:(7:22|414|23|24|(1:26)(3:27|(1:29)(1:30)|31)|34|(1:440)(1:37))|36|52|434|53|399|54|(2:56|57)(3:58|(6:59|412|60|61|68|(1:441)(1:71))|70)|85|(5:88|(3:90|(10:92|393|93|424|94|(2:(3:96|(1:98)|99)|442)(1:102)|101|111|(6:114|(1:136)(2:118|(8:445|120|(4:123|(2:125|452)(1:453)|126|121)|451|127|(4:130|(2:132|455)(1:456)|133|128)|454|134)(4:447|135|449|448))|137|450|448|112)|443)|138)(1:142)|143|(10:146|(3:150|(4:153|(5:464|155|(1:157)(1:158)|159|468)(1:467)|466|151)|465)|160|(3:164|(4:167|(3:471|171|475)|472|165)|470)|172|(3:174|(6:177|(2:179|(3:181|478|184))(1:182)|183|477|184|175)|476)|185|(3:194|(8:197|(1:199)|200|(1:202)|203|(3:479|205|482)(1:481)|480|195)|462)|206|144)|457)|87|207|(3:210|(4:213|(9:215|(1:217)(1:218)|219|(9:221|408|222|223|420|224|397|225|(4:227|(11:228|430|229|426|230|231|232|(3:234|428|235)(1:236)|237|242|(1:486)(1:245))|244|265)(4:248|249|250|265))(1:271)|272|(4:275|(3:489|277|491)(6:488|278|(2:279|(2:281|(1:283)(2:493|284))(2:494|285))|(1:287)|288|492)|490|273)|487|289|484)(1:485)|290|211)|483)|209|291|(3:294|(6:297|(6:299|436|300|422|301|(3:(9:303|394|304|305|306|(1:308)(1:309)|310|315|(1:498)(1:318))|317|331)(4:319|320|321|331))(1:337)|338|(2:339|(2:341|(3:499|343|497)(8:344|(2:345|(4:347|(3:349|(1:351)(1:352)|353)(1:354)|355|(1:1)(2:359|(1:361)(2:504|362)))(2:502|368))|363|(1:365)(1:366)|367|370|500|371))(0))|372|295)|495)|293|373|(9:376|416|377|378|402|379|(2:381|509)(1:508)|386|374)|506|387)(2:38|39))|399|54|(0)(0)|85|(0)|87|207|(0)|209|291|(0)|293|373|(1:374)|506|387) */
    /* JADX WARN: Can't wrap try/catch for region: R(27:2|(2:3|(2:5|(2:439|7))(2:438|8))|9|(3:11|404|12)|15|(6:18|425|19|396|20|(21:(7:22|414|23|24|(1:26)(3:27|(1:29)(1:30)|31)|34|(1:440)(1:37))|36|52|434|53|399|54|(2:56|57)(3:58|(6:59|412|60|61|68|(1:441)(1:71))|70)|85|(5:88|(3:90|(10:92|393|93|424|94|(2:(3:96|(1:98)|99)|442)(1:102)|101|111|(6:114|(1:136)(2:118|(8:445|120|(4:123|(2:125|452)(1:453)|126|121)|451|127|(4:130|(2:132|455)(1:456)|133|128)|454|134)(4:447|135|449|448))|137|450|448|112)|443)|138)(1:142)|143|(10:146|(3:150|(4:153|(5:464|155|(1:157)(1:158)|159|468)(1:467)|466|151)|465)|160|(3:164|(4:167|(3:471|171|475)|472|165)|470)|172|(3:174|(6:177|(2:179|(3:181|478|184))(1:182)|183|477|184|175)|476)|185|(3:194|(8:197|(1:199)|200|(1:202)|203|(3:479|205|482)(1:481)|480|195)|462)|206|144)|457)|87|207|(3:210|(4:213|(9:215|(1:217)(1:218)|219|(9:221|408|222|223|420|224|397|225|(4:227|(11:228|430|229|426|230|231|232|(3:234|428|235)(1:236)|237|242|(1:486)(1:245))|244|265)(4:248|249|250|265))(1:271)|272|(4:275|(3:489|277|491)(6:488|278|(2:279|(2:281|(1:283)(2:493|284))(2:494|285))|(1:287)|288|492)|490|273)|487|289|484)(1:485)|290|211)|483)|209|291|(3:294|(6:297|(6:299|436|300|422|301|(3:(9:303|394|304|305|306|(1:308)(1:309)|310|315|(1:498)(1:318))|317|331)(4:319|320|321|331))(1:337)|338|(2:339|(2:341|(3:499|343|497)(8:344|(2:345|(4:347|(3:349|(1:351)(1:352)|353)(1:354)|355|(1:1)(2:359|(1:361)(2:504|362)))(2:502|368))|363|(1:365)(1:366)|367|370|500|371))(0))|372|295)|495)|293|373|(9:376|416|377|378|402|379|(2:381|509)(1:508)|386|374)|506|387)(2:38|39))|51|52|434|53|399|54|(0)(0)|85|(0)|87|207|(0)|209|291|(0)|293|373|(1:374)|506|387|(5:(0)|(0)|(0)|(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0302, code lost:
        if (r5 == null) goto L_0x0305;
     */
    /* JADX WARN: Code restructure failed: missing block: B:264:0x0750, code lost:
        if (r11 != null) goto L_0x071a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x090a, code lost:
        if (r13 == null) goto L_0x090d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x0a36, code lost:
        if (r7 != false) goto L_0x0a41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0171, code lost:
        if (r5 == null) goto L_0x017a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0220, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0221, code lost:
        r18 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0226, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0227, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x022a, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x022b, code lost:
        r18 = r6;
        r19 = r7;
        r4 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x081d  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0a67  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b0 A[Catch: SQLiteException -> 0x0220, all -> 0x0af7, TRY_LEAVE, TryCatch #7 {SQLiteException -> 0x0220, blocks: (B:54:0x01aa, B:56:0x01b0, B:58:0x01be, B:59:0x01c3, B:60:0x01cd, B:61:0x01dd, B:63:0x01ec), top: B:399:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01be A[Catch: SQLiteException -> 0x0220, all -> 0x0af7, TRY_ENTER, TryCatch #7 {SQLiteException -> 0x0220, blocks: (B:54:0x01aa, B:56:0x01b0, B:58:0x01be, B:59:0x01c3, B:60:0x01cd, B:61:0x01dd, B:63:0x01ec), top: B:399:0x01aa }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x025e  */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r5v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v45, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47, types: [java.lang.String[]] */
    /* JADX WARN: Unknown variable types count: 2 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.internal.measurement.zzfk> zzb(java.lang.String r66, java.util.List<com.google.android.gms.internal.measurement.zzfo> r67, java.util.List<com.google.android.gms.internal.measurement.zzgh> r68, java.lang.Long r69, java.lang.Long r70) {
        /*
            Method dump skipped, instructions count: 2815
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzb(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
