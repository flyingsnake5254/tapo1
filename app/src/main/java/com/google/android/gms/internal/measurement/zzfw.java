package com.google.android.gms.internal.measurement;

import io.netty.util.internal.shaded.org.jctools.util.Pow2;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@19.0.0 */
/* loaded from: classes.dex */
public final class zzfw extends zzkd<zzfw, zzfv> implements zzlj {
    public static final /* synthetic */ int zza = 0;
    private static final zzfw zzaa;
    private long zzB;
    private int zzC;
    private boolean zzF;
    private int zzI;
    private int zzJ;
    private int zzK;
    private long zzM;
    private long zzN;
    private int zzQ;
    private zzgb zzS;
    private long zzU;
    private long zzV;
    private int zzY;
    private boolean zzZ;
    private int zze;
    private int zzf;
    private int zzg;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private int zzs;
    private long zzw;
    private long zzx;
    private boolean zzz;
    private zzkk<zzfo> zzh = zzkd.zzbE();
    private zzkk<zzgh> zzi = zzkd.zzbE();
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzt = "";
    private String zzu = "";
    private String zzv = "";
    private String zzy = "";
    private String zzA = "";
    private String zzD = "";
    private String zzE = "";
    private zzkk<zzfk> zzG = zzkd.zzbE();
    private String zzH = "";
    private String zzL = "";
    private String zzO = "";
    private String zzP = "";
    private String zzR = "";
    private zzki zzT = zzkd.zzbB();
    private String zzW = "";
    private String zzX = "";

    static {
        zzfw zzfwVar = new zzfw();
        zzaa = zzfwVar;
        zzkd.zzby(zzfw.class, zzfwVar);
    }

    private zzfw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaA(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 32;
        zzfwVar.zzn = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaB(zzfw zzfwVar) {
        zzfwVar.zze &= -33;
        zzfwVar.zzn = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaC(zzfw zzfwVar, String str) {
        zzfwVar.zze |= 64;
        zzfwVar.zzo = "android";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaD(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 128;
        zzfwVar.zzp = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaE(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 256;
        zzfwVar.zzq = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaF(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 512;
        zzfwVar.zzr = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaG(zzfw zzfwVar, int i) {
        zzfwVar.zze |= 1024;
        zzfwVar.zzs = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaH(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 2048;
        zzfwVar.zzt = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaI(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 4096;
        zzfwVar.zzu = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaJ(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 8192;
        zzfwVar.zzv = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaK(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 16384;
        zzfwVar.zzw = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaL(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 32768;
        zzfwVar.zzx = 42004L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaM(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 65536;
        zzfwVar.zzy = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaN(zzfw zzfwVar) {
        zzfwVar.zze &= -65537;
        zzfwVar.zzy = zzaa.zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaO(zzfw zzfwVar, boolean z) {
        zzfwVar.zze |= 131072;
        zzfwVar.zzz = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaP(zzfw zzfwVar) {
        zzfwVar.zze &= -131073;
        zzfwVar.zzz = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaQ(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 262144;
        zzfwVar.zzA = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaR(zzfw zzfwVar) {
        zzfwVar.zze &= -262145;
        zzfwVar.zzA = zzaa.zzA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaS(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 524288;
        zzfwVar.zzB = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaT(zzfw zzfwVar, int i) {
        zzfwVar.zze |= 1048576;
        zzfwVar.zzC = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaU(zzfw zzfwVar, String str) {
        zzfwVar.zze |= 2097152;
        zzfwVar.zzD = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaV(zzfw zzfwVar) {
        zzfwVar.zze &= -2097153;
        zzfwVar.zzD = zzaa.zzD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaW(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 4194304;
        zzfwVar.zzE = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaX(zzfw zzfwVar, boolean z) {
        zzfwVar.zze |= 8388608;
        zzfwVar.zzF = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaY(zzfw zzfwVar, Iterable iterable) {
        zzkk<zzfk> zzkkVar = zzfwVar.zzG;
        if (!zzkkVar.zza()) {
            zzfwVar.zzG = zzkd.zzbF(zzkkVar);
        }
        zzio.zzbs(iterable, zzfwVar.zzG);
    }

    public static zzfv zzaj() {
        return zzaa.zzbt();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzal(zzfw zzfwVar, int i) {
        zzfwVar.zze |= 1;
        zzfwVar.zzg = 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzam(zzfw zzfwVar, int i, zzfo zzfoVar) {
        zzfoVar.getClass();
        zzfwVar.zzbI();
        zzfwVar.zzh.set(i, zzfoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzan(zzfw zzfwVar, zzfo zzfoVar) {
        zzfoVar.getClass();
        zzfwVar.zzbI();
        zzfwVar.zzh.add(zzfoVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzao(zzfw zzfwVar, Iterable iterable) {
        zzfwVar.zzbI();
        zzio.zzbs(iterable, zzfwVar.zzh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaq(zzfw zzfwVar, int i) {
        zzfwVar.zzbI();
        zzfwVar.zzh.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzar(zzfw zzfwVar, int i, zzgh zzghVar) {
        zzghVar.getClass();
        zzfwVar.zzbJ();
        zzfwVar.zzi.set(i, zzghVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzas(zzfw zzfwVar, zzgh zzghVar) {
        zzghVar.getClass();
        zzfwVar.zzbJ();
        zzfwVar.zzi.add(zzghVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzat(zzfw zzfwVar, Iterable iterable) {
        zzfwVar.zzbJ();
        zzio.zzbs(iterable, zzfwVar.zzi);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzau(zzfw zzfwVar, int i) {
        zzfwVar.zzbJ();
        zzfwVar.zzi.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzav(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 2;
        zzfwVar.zzj = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaw(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 4;
        zzfwVar.zzk = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzax(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 8;
        zzfwVar.zzl = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzay(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 16;
        zzfwVar.zzm = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzaz(zzfw zzfwVar) {
        zzfwVar.zze &= -17;
        zzfwVar.zzm = 0L;
    }

    private final void zzbI() {
        zzkk<zzfo> zzkkVar = this.zzh;
        if (!zzkkVar.zza()) {
            this.zzh = zzkd.zzbF(zzkkVar);
        }
    }

    private final void zzbJ() {
        zzkk<zzgh> zzkkVar = this.zzi;
        if (!zzkkVar.zza()) {
            this.zzi = zzkd.zzbF(zzkkVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzba(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zze |= 16777216;
        zzfwVar.zzH = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbb(zzfw zzfwVar, int i) {
        zzfwVar.zze |= 33554432;
        zzfwVar.zzI = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbc(zzfw zzfwVar) {
        zzfwVar.zze &= -268435457;
        zzfwVar.zzL = zzaa.zzL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbd(zzfw zzfwVar, long j) {
        zzfwVar.zze |= 536870912;
        zzfwVar.zzM = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbe(zzfw zzfwVar, long j) {
        zzfwVar.zze |= Pow2.MAX_POW2;
        zzfwVar.zzN = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbf(zzfw zzfwVar) {
        zzfwVar.zze &= Integer.MAX_VALUE;
        zzfwVar.zzO = zzaa.zzO;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbg(zzfw zzfwVar, int i) {
        zzfwVar.zzf |= 2;
        zzfwVar.zzQ = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbh(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zzf |= 4;
        zzfwVar.zzR = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbi(zzfw zzfwVar, zzgb zzgbVar) {
        zzgbVar.getClass();
        zzfwVar.zzS = zzgbVar;
        zzfwVar.zzf |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbj(zzfw zzfwVar, Iterable iterable) {
        zzki zzkiVar = zzfwVar.zzT;
        if (!zzkiVar.zza()) {
            int size = zzkiVar.size();
            zzfwVar.zzT = zzkiVar.zzf(size == 0 ? 10 : size + size);
        }
        zzio.zzbs(iterable, zzfwVar.zzT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbk(zzfw zzfwVar, long j) {
        zzfwVar.zzf |= 16;
        zzfwVar.zzU = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbl(zzfw zzfwVar, long j) {
        zzfwVar.zzf |= 32;
        zzfwVar.zzV = j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbm(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zzf |= 64;
        zzfwVar.zzW = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzbn(zzfw zzfwVar, String str) {
        str.getClass();
        zzfwVar.zzf |= 128;
        zzfwVar.zzX = str;
    }

    public final String zzA() {
        return this.zzu;
    }

    public final String zzB() {
        return this.zzv;
    }

    public final boolean zzC() {
        return (this.zze & 16384) != 0;
    }

    public final long zzD() {
        return this.zzw;
    }

    public final boolean zzE() {
        return (this.zze & 32768) != 0;
    }

    public final long zzF() {
        return this.zzx;
    }

    public final String zzG() {
        return this.zzy;
    }

    public final boolean zzH() {
        return (this.zze & 131072) != 0;
    }

    public final boolean zzI() {
        return this.zzz;
    }

    public final String zzJ() {
        return this.zzA;
    }

    public final boolean zzK() {
        return (this.zze & 524288) != 0;
    }

    public final long zzL() {
        return this.zzB;
    }

    public final boolean zzM() {
        return (this.zze & 1048576) != 0;
    }

    public final int zzN() {
        return this.zzC;
    }

    public final String zzO() {
        return this.zzD;
    }

    public final String zzP() {
        return this.zzE;
    }

    public final boolean zzQ() {
        return (this.zze & 8388608) != 0;
    }

    public final boolean zzR() {
        return this.zzF;
    }

    public final List<zzfk> zzS() {
        return this.zzG;
    }

    public final String zzT() {
        return this.zzH;
    }

    public final boolean zzU() {
        return (this.zze & 33554432) != 0;
    }

    public final int zzV() {
        return this.zzI;
    }

    public final boolean zzW() {
        return (this.zze & 536870912) != 0;
    }

    public final long zzX() {
        return this.zzM;
    }

    public final boolean zzY() {
        return (this.zze & Pow2.MAX_POW2) != 0;
    }

    public final long zzZ() {
        return this.zzN;
    }

    public final boolean zza() {
        return (this.zze & 1) != 0;
    }

    public final String zzaa() {
        return this.zzO;
    }

    public final boolean zzab() {
        return (this.zzf & 2) != 0;
    }

    public final int zzac() {
        return this.zzQ;
    }

    public final String zzad() {
        return this.zzR;
    }

    public final boolean zzae() {
        return (this.zzf & 16) != 0;
    }

    public final long zzaf() {
        return this.zzU;
    }

    public final String zzag() {
        return this.zzW;
    }

    public final boolean zzah() {
        return (this.zzf & 128) != 0;
    }

    public final String zzai() {
        return this.zzX;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final List<zzfo> zzc() {
        return this.zzh;
    }

    public final int zzd() {
        return this.zzh.size();
    }

    public final zzfo zze(int i) {
        return this.zzh.get(i);
    }

    public final List<zzgh> zzf() {
        return this.zzi;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final zzgh zzh(int i) {
        return this.zzi.get(i);
    }

    public final boolean zzi() {
        return (this.zze & 2) != 0;
    }

    public final long zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        return (this.zze & 4) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.zzkd
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzkd.zzbz(zzaa, "\u0001.\u0000\u0002\u00017.\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5ဌ(7ဇ)", new Object[]{"zze", "zzf", "zzg", "zzh", zzfo.class, "zzi", zzgh.class, "zzj", "zzk", "zzl", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzE", "zzm", "zzF", "zzG", zzfk.class, "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", "zzY", zzfi.zzb(), "zzZ"});
        }
        if (i2 == 3) {
            return new zzfw();
        }
        if (i2 == 4) {
            return new zzfv(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzaa;
    }

    public final long zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        return (this.zze & 8) != 0;
    }

    public final long zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        return (this.zze & 16) != 0;
    }

    public final long zzq() {
        return this.zzm;
    }

    public final boolean zzr() {
        return (this.zze & 32) != 0;
    }

    public final long zzs() {
        return this.zzn;
    }

    public final String zzt() {
        return this.zzo;
    }

    public final String zzu() {
        return this.zzp;
    }

    public final String zzv() {
        return this.zzq;
    }

    public final String zzw() {
        return this.zzr;
    }

    public final boolean zzx() {
        return (this.zze & 1024) != 0;
    }

    public final int zzy() {
        return this.zzs;
    }

    public final String zzz() {
        return this.zzt;
    }
}
