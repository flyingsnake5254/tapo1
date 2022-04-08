package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
/* loaded from: classes.dex */
public final class zzgd implements zzix {
    private int tag;
    private int zzsl;
    private final zzfy zzte;
    private int zztf = 0;

    private zzgd(zzfy zzfyVar) {
        zzfy zzfyVar2 = (zzfy) zzgy.zza(zzfyVar, "input");
        this.zzte = zzfyVar2;
        zzfyVar2.zzsx = this;
    }

    public static zzgd zza(zzfy zzfyVar) {
        zzgd zzgdVar = zzfyVar.zzsx;
        return zzgdVar != null ? zzgdVar : new zzgd(zzfyVar);
    }

    private final void zzak(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzgs();
        }
    }

    private static void zzal(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzhh.zzgt();
        }
    }

    private static void zzam(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzan(int i) throws IOException {
        if (this.zzte.zzfa() != i) {
            throw zzhh.zzgn();
        }
    }

    private final <T> T zzd(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int i = this.zzsl;
        this.zzsl = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zziwVar.newInstance();
            zziwVar.zza(newInstance, this, zzgiVar);
            zziwVar.zzh(newInstance);
            if (this.tag == this.zzsl) {
                return newInstance;
            }
            throw zzhh.zzgt();
        } finally {
            this.zzsl = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int getTag() {
        return this.tag;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final double readDouble() throws IOException {
        zzak(1);
        return this.zzte.readDouble();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final float readFloat() throws IOException {
        zzak(5);
        return this.zzte.readFloat();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String readString() throws IOException {
        zzak(2);
        return this.zzte.readString();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzb(Class<T> cls, zzgi zzgiVar) throws IOException {
        zzak(3);
        return (T) zzd(zzis.zzhp().zzf(cls), zzgiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzc(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        zzak(3);
        return (T) zzd(zziwVar, zzgiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdv() throws IOException {
        int i = this.zztf;
        if (i != 0) {
            this.tag = i;
            this.zztf = 0;
        } else {
            this.tag = this.zzte.zzey();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzsl) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzdw() throws IOException {
        int i;
        if (this.zzte.zzdu() || (i = this.tag) == this.zzsl) {
            return false;
        }
        return this.zzte.zzas(i);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdx() throws IOException {
        zzak(0);
        return this.zzte.zzdx();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdy() throws IOException {
        zzak(0);
        return this.zzte.zzdy();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdz() throws IOException {
        zzak(0);
        return this.zzte.zzdz();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zze(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzdz());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzdz());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzdz()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzdz()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzea() throws IOException {
        zzak(1);
        return this.zzte.zzea();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeb() throws IOException {
        zzak(5);
        return this.zzte.zzeb();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzec() throws IOException {
        zzak(0);
        return this.zzte.zzec();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String zzed() throws IOException {
        zzak(2);
        return this.zzte.zzed();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final zzfm zzee() throws IOException {
        zzak(2);
        return this.zzte.zzee();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzef() throws IOException {
        zzak(0);
        return this.zzte.zzef();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeg() throws IOException {
        zzak(0);
        return this.zzte.zzeg();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeh() throws IOException {
        zzak(5);
        return this.zzte.zzeh();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzei() throws IOException {
        zzak(1);
        return this.zzte.zzei();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzej() throws IOException {
        zzak(0);
        return this.zzte.zzej();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzek() throws IOException {
        zzak(0);
        return this.zzte.zzek();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzf(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhvVar.zzac(this.zzte.zzea());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzef = this.zzte.zzef();
                zzal(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzhvVar.zzac(this.zzte.zzea());
                } while (this.zzte.zzfa() < zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzte.zzea()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzal(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Long.valueOf(this.zzte.zzea()));
                } while (this.zzte.zzfa() < zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzg(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzef = this.zzte.zzef();
                zzam(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgzVar.zzbm(this.zzte.zzeb());
                } while (this.zzte.zzfa() < zzfa);
            } else if (i == 5) {
                do {
                    zzgzVar.zzbm(this.zzte.zzeb());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzam(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Integer.valueOf(this.zzte.zzeb()));
                } while (this.zzte.zzfa() < zzfa2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzeb()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzh(List<Boolean> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzfk) {
            zzfk zzfkVar = (zzfk) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfkVar.addBoolean(this.zzte.zzec());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzfkVar.addBoolean(this.zzte.zzec());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzte.zzec()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Boolean.valueOf(this.zzte.zzec()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzj(List<zzfm> list) throws IOException {
        int zzey;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzee());
                if (!this.zzte.zzdu()) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == this.tag);
            this.zztf = zzey;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzef());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzef());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzef()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzef()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzl(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzeg());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzeg());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzeg()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzeg()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzm(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzef = this.zzte.zzef();
                zzam(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgzVar.zzbm(this.zzte.zzeh());
                } while (this.zzte.zzfa() < zzfa);
            } else if (i == 5) {
                do {
                    zzgzVar.zzbm(this.zzte.zzeh());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzam(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Integer.valueOf(this.zzte.zzeh()));
                } while (this.zzte.zzfa() < zzfa2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzeh()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzn(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzhvVar.zzac(this.zzte.zzei());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzef = this.zzte.zzef();
                zzal(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzhvVar.zzac(this.zzte.zzei());
                } while (this.zzte.zzfa() < zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzte.zzei()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzal(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Long.valueOf(this.zzte.zzei()));
                } while (this.zzte.zzfa() < zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgz) {
            zzgz zzgzVar = (zzgz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgzVar.zzbm(this.zzte.zzej());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzgzVar.zzbm(this.zzte.zzej());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzte.zzej()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Integer.valueOf(this.zzte.zzej()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzp(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhvVar.zzac(this.zzte.zzek());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhvVar.zzac(this.zzte.zzek());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzte.zzek()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Long.valueOf(this.zzte.zzek()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    private final <T> T zzb(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        zzfy zzfyVar;
        int zzef = this.zzte.zzef();
        zzfy zzfyVar2 = this.zzte;
        if (zzfyVar2.zzsu < zzfyVar2.zzsv) {
            int zzat = zzfyVar2.zzat(zzef);
            T newInstance = zziwVar.newInstance();
            this.zzte.zzsu++;
            zziwVar.zza(newInstance, this, zzgiVar);
            zziwVar.zzh(newInstance);
            this.zzte.zzar(0);
            zzfyVar.zzsu--;
            this.zzte.zzau(zzat);
            return newInstance;
        }
        throw new zzhh("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(Class<T> cls, zzgi zzgiVar) throws IOException {
        zzak(2);
        return (T) zzb(zzis.zzhp().zzf(cls), zzgiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzc(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhvVar.zzac(this.zzte.zzdx());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhvVar.zzac(this.zzte.zzdx());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzte.zzdx()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Long.valueOf(this.zzte.zzdx()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        zzak(2);
        return (T) zzb(zziwVar, zzgiVar);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zza(List<Double> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgg) {
            zzgg zzggVar = (zzgg) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzggVar.zzc(this.zzte.readDouble());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzef = this.zzte.zzef();
                zzal(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzggVar.zzc(this.zzte.readDouble());
                } while (this.zzte.zzfa() < zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzte.readDouble()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzal(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Double.valueOf(this.zzte.readDouble()));
                } while (this.zzte.zzfa() < zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzd(List<Long> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzhv) {
            zzhv zzhvVar = (zzhv) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzhvVar.zzac(this.zzte.zzdy());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else if (i == 2) {
                int zzfa = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    zzhvVar.zzac(this.zzte.zzdy());
                } while (this.zzte.zzfa() < zzfa);
                zzan(zzfa);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzte.zzdy()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else if (i2 == 2) {
                int zzfa2 = this.zzte.zzfa() + this.zzte.zzef();
                do {
                    list.add(Long.valueOf(this.zzte.zzdy()));
                } while (this.zzte.zzfa() < zzfa2);
                zzan(zzfa2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(List<Float> list) throws IOException {
        int zzey;
        int zzey2;
        if (list instanceof zzgt) {
            zzgt zzgtVar = (zzgt) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzef = this.zzte.zzef();
                zzam(zzef);
                int zzfa = this.zzte.zzfa() + zzef;
                do {
                    zzgtVar.zzu(this.zzte.readFloat());
                } while (this.zzte.zzfa() < zzfa);
            } else if (i == 5) {
                do {
                    zzgtVar.zzu(this.zzte.readFloat());
                    if (!this.zzte.zzdu()) {
                        zzey2 = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey2 == this.tag);
                this.zztf = zzey2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzef2 = this.zzte.zzef();
                zzam(zzef2);
                int zzfa2 = this.zzte.zzfa() + zzef2;
                do {
                    list.add(Float.valueOf(this.zzte.readFloat()));
                } while (this.zzte.zzfa() < zzfa2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzte.readFloat()));
                    if (!this.zzte.zzdu()) {
                        zzey = this.zzte.zzey();
                    } else {
                        return;
                    }
                } while (zzey == this.tag);
                this.zztf = zzey;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzey;
        int zzey2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        } else if (!(list instanceof zzho) || z) {
            do {
                list.add(z ? zzed() : readString());
                if (!this.zzte.zzdu()) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == this.tag);
            this.zztf = zzey;
        } else {
            zzho zzhoVar = (zzho) list;
            do {
                zzhoVar.zzc(zzee());
                if (!this.zzte.zzdu()) {
                    zzey2 = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey2 == this.tag);
            this.zztf = zzey2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zzb(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int zzey;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zziwVar, zzgiVar));
                if (!this.zzte.zzdu() && this.zztf == 0) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == i);
            this.zztf = zzey;
            return;
        }
        throw zzhh.zzgs();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zza(List<T> list, zziw<T> zziwVar, zzgi zzgiVar) throws IOException {
        int zzey;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzb(zziwVar, zzgiVar));
                if (!this.zzte.zzdu() && this.zztf == 0) {
                    zzey = this.zzte.zzey();
                } else {
                    return;
                }
            } while (zzey == i);
            this.zztf = zzey;
            return;
        }
        throw zzhh.zzgs();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0063, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.vision.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.zzhy<K, V> r9, com.google.android.gms.internal.vision.zzgi r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzak(r0)
            com.google.android.gms.internal.vision.zzfy r1 = r7.zzte
            int r1 = r1.zzef()
            com.google.android.gms.internal.vision.zzfy r2 = r7.zzte
            int r1 = r2.zzat(r1)
            K r2 = r9.zzzc
            V r3 = r9.zzgl
        L_0x0014:
            int r4 = r7.zzdv()     // Catch: all -> 0x0064
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.vision.zzfy r5 = r7.zzte     // Catch: all -> 0x0064
            boolean r5 = r5.zzdu()     // Catch: all -> 0x0064
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzdw()     // Catch: zzhg -> 0x004e, all -> 0x0064
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.vision.zzhh r4 = new com.google.android.gms.internal.vision.zzhh     // Catch: zzhg -> 0x004e, all -> 0x0064
            r4.<init>(r6)     // Catch: zzhg -> 0x004e, all -> 0x0064
            throw r4     // Catch: zzhg -> 0x004e, all -> 0x0064
        L_0x0039:
            com.google.android.gms.internal.vision.zzkf r4 = r9.zzzd     // Catch: zzhg -> 0x004e, all -> 0x0064
            V r5 = r9.zzgl     // Catch: zzhg -> 0x004e, all -> 0x0064
            java.lang.Class r5 = r5.getClass()     // Catch: zzhg -> 0x004e, all -> 0x0064
            java.lang.Object r3 = r7.zza(r4, r5, r10)     // Catch: zzhg -> 0x004e, all -> 0x0064
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.vision.zzkf r4 = r9.zzzb     // Catch: zzhg -> 0x004e, all -> 0x0064
            r5 = 0
            java.lang.Object r2 = r7.zza(r4, r5, r5)     // Catch: zzhg -> 0x004e, all -> 0x0064
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzdw()     // Catch: all -> 0x0064
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.vision.zzhh r8 = new com.google.android.gms.internal.vision.zzhh     // Catch: all -> 0x0064
            r8.<init>(r6)     // Catch: all -> 0x0064
            throw r8     // Catch: all -> 0x0064
        L_0x005b:
            r8.put(r2, r3)     // Catch: all -> 0x0064
            com.google.android.gms.internal.vision.zzfy r8 = r7.zzte
            r8.zzau(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.vision.zzfy r9 = r7.zzte
            r9.zzau(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzgd.zza(java.util.Map, com.google.android.gms.internal.vision.zzhy, com.google.android.gms.internal.vision.zzgi):void");
    }

    private final Object zza(zzkf zzkfVar, Class<?> cls, zzgi zzgiVar) throws IOException {
        switch (zzgc.zzsg[zzkfVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzec());
            case 2:
                return zzee();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzeg());
            case 5:
                return Integer.valueOf(zzeb());
            case 6:
                return Long.valueOf(zzea());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdz());
            case 9:
                return Long.valueOf(zzdy());
            case 10:
                return zza(cls, zzgiVar);
            case 11:
                return Integer.valueOf(zzeh());
            case 12:
                return Long.valueOf(zzei());
            case 13:
                return Integer.valueOf(zzej());
            case 14:
                return Long.valueOf(zzek());
            case 15:
                return zzed();
            case 16:
                return Integer.valueOf(zzef());
            case 17:
                return Long.valueOf(zzdx());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
