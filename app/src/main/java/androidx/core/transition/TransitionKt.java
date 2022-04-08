package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.p;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition addListener, l<? super Transition, p> onEnd, l<? super Transition, p> onStart, l<? super Transition, p> onCancel, l<? super Transition, p> onResume, l<? super Transition, p> onPause) {
        j.f(addListener, "$this$addListener");
        j.f(onEnd, "onEnd");
        j.f(onStart, "onStart");
        j.f(onCancel, "onCancel");
        j.f(onResume, "onResume");
        j.f(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition addListener, l onEnd, l onStart, l onCancel, l onResume, l onPause, int i, Object obj) {
        if ((i & 1) != 0) {
            onEnd = TransitionKt$addListener$1.INSTANCE;
        }
        if ((i & 2) != 0) {
            onStart = TransitionKt$addListener$2.INSTANCE;
        }
        if ((i & 4) != 0) {
            onCancel = TransitionKt$addListener$3.INSTANCE;
        }
        if ((i & 8) != 0) {
            onResume = TransitionKt$addListener$4.INSTANCE;
        }
        if ((i & 16) != 0) {
            onPause = TransitionKt$addListener$5.INSTANCE;
        }
        j.f(addListener, "$this$addListener");
        j.f(onEnd, "onEnd");
        j.f(onStart, "onStart");
        j.f(onCancel, "onCancel");
        j.f(onResume, "onResume");
        j.f(onPause, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(onEnd, onResume, onPause, onCancel, onStart);
        addListener.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition doOnCancel, final l<? super Transition, p> action) {
        j.f(doOnCancel, "$this$doOnCancel");
        j.f(action, "action");
        Transition.TransitionListener transitionKt$doOnCancel$$inlined$addListener$1 = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                j.f(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                j.f(transition, "transition");
            }
        };
        doOnCancel.addListener(transitionKt$doOnCancel$$inlined$addListener$1);
        return transitionKt$doOnCancel$$inlined$addListener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition doOnEnd, final l<? super Transition, p> action) {
        j.f(doOnEnd, "$this$doOnEnd");
        j.f(action, "action");
        Transition.TransitionListener transitionKt$doOnEnd$$inlined$addListener$1 = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                j.f(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                j.f(transition, "transition");
            }
        };
        doOnEnd.addListener(transitionKt$doOnEnd$$inlined$addListener$1);
        return transitionKt$doOnEnd$$inlined$addListener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition doOnPause, final l<? super Transition, p> action) {
        j.f(doOnPause, "$this$doOnPause");
        j.f(action, "action");
        Transition.TransitionListener transitionKt$doOnPause$$inlined$addListener$1 = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                j.f(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                j.f(transition, "transition");
            }
        };
        doOnPause.addListener(transitionKt$doOnPause$$inlined$addListener$1);
        return transitionKt$doOnPause$$inlined$addListener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition doOnResume, final l<? super Transition, p> action) {
        j.f(doOnResume, "$this$doOnResume");
        j.f(action, "action");
        Transition.TransitionListener transitionKt$doOnResume$$inlined$addListener$1 = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                j.f(transition, "transition");
                l.this.invoke(transition);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                j.f(transition, "transition");
            }
        };
        doOnResume.addListener(transitionKt$doOnResume$$inlined$addListener$1);
        return transitionKt$doOnResume$$inlined$addListener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition doOnStart, final l<? super Transition, p> action) {
        j.f(doOnStart, "$this$doOnStart");
        j.f(action, "action");
        Transition.TransitionListener transitionKt$doOnStart$$inlined$addListener$1 = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition) {
                j.f(transition, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition) {
                j.f(transition, "transition");
                l.this.invoke(transition);
            }
        };
        doOnStart.addListener(transitionKt$doOnStart$$inlined$addListener$1);
        return transitionKt$doOnStart$$inlined$addListener$1;
    }
}
