package kotlin.text;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.v.d;
import kotlin.v.g;

/* compiled from: Regex.kt */
/* loaded from: classes4.dex */
public final class k {
    /* JADX INFO: Access modifiers changed from: private */
    public static final i f(Matcher matcher, int i, CharSequence charSequence) {
        if (!matcher.find(i)) {
            return null;
        }
        return new j(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i g(Matcher matcher, CharSequence charSequence) {
        if (!matcher.matches()) {
            return null;
        }
        return new j(matcher, charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d h(MatchResult matchResult) {
        d i;
        i = g.i(matchResult.start(), matchResult.end());
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final d i(MatchResult matchResult, int i) {
        d i2;
        i2 = g.i(matchResult.start(i), matchResult.end(i));
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int j(Iterable<? extends f> iterable) {
        int i = 0;
        for (f fVar : iterable) {
            i |= fVar.getValue();
        }
        return i;
    }
}
