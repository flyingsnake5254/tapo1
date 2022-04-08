package org.apache.commons.lang.exception;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class NestableDelegate implements Serializable {
    private static final transient String MUST_BE_THROWABLE = "The Nestable implementation passed to the NestableDelegate(Nestable) constructor must extend java.lang.Throwable";
    static /* synthetic */ Class class$org$apache$commons$lang$exception$Nestable = null;
    public static boolean matchSubclasses = true;
    private static final long serialVersionUID = 1;
    public static boolean topDown = true;
    public static boolean trimStackFrames = true;
    private Throwable nestable;

    public NestableDelegate(b bVar) {
        this.nestable = null;
        if (bVar instanceof Throwable) {
            this.nestable = (Throwable) bVar;
            return;
        }
        throw new IllegalArgumentException(MUST_BE_THROWABLE);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public String getMessage(int i) {
        Throwable throwable = getThrowable(i);
        Class cls = class$org$apache$commons$lang$exception$Nestable;
        if (cls == null) {
            cls = class$("org.apache.commons.lang.exception.Nestable");
            class$org$apache$commons$lang$exception$Nestable = cls;
        }
        if (cls.isInstance(throwable)) {
            return ((b) throwable).getMessage(0);
        }
        return throwable.getMessage();
    }

    public String[] getMessages() {
        Throwable[] throwables = getThrowables();
        String[] strArr = new String[throwables.length];
        for (int i = 0; i < throwables.length; i++) {
            Class cls = class$org$apache$commons$lang$exception$Nestable;
            if (cls == null) {
                cls = class$("org.apache.commons.lang.exception.Nestable");
                class$org$apache$commons$lang$exception$Nestable = cls;
            }
            strArr[i] = cls.isInstance(throwables[i]) ? ((b) throwables[i]).getMessage(0) : throwables[i].getMessage();
        }
        return strArr;
    }

    protected String[] getStackFrames(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
        if (th instanceof b) {
            ((b) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
        return a.g(stringWriter.getBuffer().toString());
    }

    public Throwable getThrowable(int i) {
        if (i == 0) {
            return this.nestable;
        }
        return getThrowables()[i];
    }

    public int getThrowableCount() {
        return a.h(this.nestable);
    }

    public Throwable[] getThrowables() {
        return a.j(this.nestable);
    }

    public int indexOfThrowable(Class cls, int i) {
        if (cls == null) {
            return -1;
        }
        if (i >= 0) {
            Throwable[] j = a.j(this.nestable);
            if (i < j.length) {
                if (matchSubclasses) {
                    while (i < j.length) {
                        if (cls.isAssignableFrom(j[i].getClass())) {
                            return i;
                        }
                        i++;
                    }
                } else {
                    while (i < j.length) {
                        if (cls.equals(j[i].getClass())) {
                            return i;
                        }
                        i++;
                    }
                }
                return -1;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The start index was out of bounds: ");
            stringBuffer.append(i);
            stringBuffer.append(" >= ");
            stringBuffer.append(j.length);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("The start index was out of bounds: ");
        stringBuffer2.append(i);
        throw new IndexOutOfBoundsException(stringBuffer2.toString());
    }

    public void printStackTrace() {
        printStackTrace(System.err);
    }

    protected void trimStackFrames(List list) {
        for (int size = list.size() - 1; size > 0; size--) {
            String[] strArr = (String[]) list.get(size);
            ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
            a.l(arrayList, new ArrayList(Arrays.asList((String[]) list.get(size - 1))));
            int length = strArr.length - arrayList.size();
            if (length > 0) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\t... ");
                stringBuffer.append(length);
                stringBuffer.append(" more");
                arrayList.add(stringBuffer.toString());
                list.set(size, arrayList.toArray(new String[arrayList.size()]));
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        synchronized (printStream) {
            PrintWriter printWriter = new PrintWriter((OutputStream) printStream, false);
            printStackTrace(printWriter);
            printWriter.flush();
        }
    }

    public String getMessage(String str) {
        Throwable b2 = a.b(this.nestable);
        String message = b2 == null ? null : b2.getMessage();
        if (b2 == null || message == null) {
            return str;
        }
        if (str == null) {
            return message;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(": ");
        stringBuffer.append(message);
        return stringBuffer.toString();
    }

    public void printStackTrace(PrintWriter printWriter) {
        Throwable th = this.nestable;
        if (!a.k()) {
            ArrayList arrayList = new ArrayList();
            while (th != null) {
                arrayList.add(getStackFrames(th));
                th = a.b(th);
            }
            String str = "Caused by: ";
            if (!topDown) {
                str = "Rethrown as: ";
                Collections.reverse(arrayList);
            }
            if (trimStackFrames) {
                trimStackFrames(arrayList);
            }
            synchronized (printWriter) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    for (String str2 : (String[]) it.next()) {
                        printWriter.println(str2);
                    }
                    if (it.hasNext()) {
                        printWriter.print(str);
                    }
                }
            }
        } else if (th instanceof b) {
            ((b) th).printPartialStackTrace(printWriter);
        } else {
            th.printStackTrace(printWriter);
        }
    }
}
