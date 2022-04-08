package io.netty.handler.codec.http;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.firebase.messaging.ServiceStarter;
import io.netty.util.AsciiString;

/* loaded from: classes3.dex */
public enum HttpStatusClass {
    INFORMATIONAL(100, ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, "Informational"),
    SUCCESS(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION, 300, "Success"),
    REDIRECTION(300, 400, "Redirection"),
    CLIENT_ERROR(400, ServiceStarter.ERROR_UNKNOWN, "Client Error"),
    SERVER_ERROR(ServiceStarter.ERROR_UNKNOWN, 600, "Server Error"),
    UNKNOWN(0, 0, "Unknown Status") { // from class: io.netty.handler.codec.http.HttpStatusClass.1
        @Override // io.netty.handler.codec.http.HttpStatusClass
        public boolean contains(int i) {
            return i < 100 || i >= 600;
        }
    };
    
    private final AsciiString defaultReasonPhrase;
    private final int max;
    private final int min;

    private static int digit(char c2) {
        return c2 - '0';
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public boolean contains(int i) {
        return i >= this.min && i < this.max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AsciiString defaultReasonPhrase() {
        return this.defaultReasonPhrase;
    }

    HttpStatusClass(int i, int i2, String str) {
        this.min = i;
        this.max = i2;
        this.defaultReasonPhrase = AsciiString.cached(str);
    }

    public static HttpStatusClass valueOf(int i) {
        HttpStatusClass httpStatusClass = INFORMATIONAL;
        if (httpStatusClass.contains(i)) {
            return httpStatusClass;
        }
        HttpStatusClass httpStatusClass2 = SUCCESS;
        if (httpStatusClass2.contains(i)) {
            return httpStatusClass2;
        }
        HttpStatusClass httpStatusClass3 = REDIRECTION;
        if (httpStatusClass3.contains(i)) {
            return httpStatusClass3;
        }
        HttpStatusClass httpStatusClass4 = CLIENT_ERROR;
        if (httpStatusClass4.contains(i)) {
            return httpStatusClass4;
        }
        HttpStatusClass httpStatusClass5 = SERVER_ERROR;
        return httpStatusClass5.contains(i) ? httpStatusClass5 : UNKNOWN;
    }

    public static HttpStatusClass valueOf(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() != 3) {
            return UNKNOWN;
        }
        char charAt = charSequence.charAt(0);
        return (!isDigit(charAt) || !isDigit(charSequence.charAt(1)) || !isDigit(charSequence.charAt(2))) ? UNKNOWN : valueOf(digit(charAt) * 100);
    }
}
