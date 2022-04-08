package kotlin.text;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.Lambda;

/* compiled from: Regex.kt */
/* loaded from: classes4.dex */
public final class Regex$fromInt$$inlined$apply$lambda$1 extends Lambda implements l<T, Boolean> {
    final /* synthetic */ int $value$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Regex$fromInt$$inlined$apply$lambda$1(int i) {
        super(1);
        this.$value$inlined = i;
    }

    @Override // kotlin.jvm.b.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke((Enum) obj));
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    public final boolean invoke(Enum r3) {
        f fVar = (f) r3;
        return (this.$value$inlined & fVar.getMask()) == fVar.getValue();
    }
}
