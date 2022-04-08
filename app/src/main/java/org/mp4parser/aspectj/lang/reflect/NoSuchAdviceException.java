package org.mp4parser.aspectj.lang.reflect;

/* loaded from: classes4.dex */
public class NoSuchAdviceException extends Exception {
    private static final long serialVersionUID = 3256444698657634352L;
    private String name;

    public NoSuchAdviceException(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
