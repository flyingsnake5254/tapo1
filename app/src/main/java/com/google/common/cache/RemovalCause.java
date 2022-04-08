package com.google.common.cache;

/* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
/* loaded from: classes2.dex */
public abstract class RemovalCause extends Enum<RemovalCause> {
    private static final /* synthetic */ RemovalCause[] $VALUES;
    public static final RemovalCause COLLECTED;
    public static final RemovalCause EXPIRED;
    public static final RemovalCause EXPLICIT;
    public static final RemovalCause REPLACED;
    public static final RemovalCause SIZE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* loaded from: classes2.dex */
    static class a extends RemovalCause {
        a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.cache.RemovalCause
        boolean wasEvicted() {
            return false;
        }
    }

    static {
        a aVar = new a("EXPLICIT", 0);
        EXPLICIT = aVar;
        RemovalCause bVar = new RemovalCause("REPLACED", 1) { // from class: com.google.common.cache.RemovalCause.b
            @Override // com.google.common.cache.RemovalCause
            boolean wasEvicted() {
                return false;
            }
        };
        REPLACED = bVar;
        RemovalCause cVar = new RemovalCause("COLLECTED", 2) { // from class: com.google.common.cache.RemovalCause.c
            @Override // com.google.common.cache.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        };
        COLLECTED = cVar;
        RemovalCause dVar = new RemovalCause("EXPIRED", 3) { // from class: com.google.common.cache.RemovalCause.d
            @Override // com.google.common.cache.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        };
        EXPIRED = dVar;
        RemovalCause eVar = new RemovalCause("SIZE", 4) { // from class: com.google.common.cache.RemovalCause.e
            @Override // com.google.common.cache.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        };
        SIZE = eVar;
        $VALUES = new RemovalCause[]{aVar, bVar, cVar, dVar, eVar};
    }

    private RemovalCause(String str, int i) {
    }

    public static RemovalCause valueOf(String str) {
        return (RemovalCause) Enum.valueOf(RemovalCause.class, str);
    }

    public static RemovalCause[] values() {
        return (RemovalCause[]) $VALUES.clone();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean wasEvicted();

    /* synthetic */ RemovalCause(String str, int i, a aVar) {
        this(str, i);
    }
}
