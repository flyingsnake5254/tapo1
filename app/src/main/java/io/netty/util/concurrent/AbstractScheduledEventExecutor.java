package io.netty.util.concurrent;

import io.netty.util.internal.DefaultPriorityQueue;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PriorityQueue;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public abstract class AbstractScheduledEventExecutor extends AbstractEventExecutor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<ScheduledFutureTask<?>> SCHEDULED_FUTURE_TASK_COMPARATOR = new Comparator<ScheduledFutureTask<?>>() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.1
        public int compare(ScheduledFutureTask<?> scheduledFutureTask, ScheduledFutureTask<?> scheduledFutureTask2) {
            return scheduledFutureTask.compareTo((Delayed) scheduledFutureTask2);
        }
    };
    static final Runnable WAKEUP_TASK = new Runnable() { // from class: io.netty.util.concurrent.AbstractScheduledEventExecutor.2
        @Override // java.lang.Runnable
        public void run() {
        }
    };
    long nextTaskId;
    PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long deadlineToDelayNanos(long j) {
        return ScheduledFutureTask.deadlineToDelayNanos(j);
    }

    protected static long initialNanoTime() {
        return ScheduledFutureTask.initialNanoTime();
    }

    private static boolean isNullOrEmpty(Queue<ScheduledFutureTask<?>> queue) {
        return queue == null || queue.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long nanoTime() {
        return ScheduledFutureTask.nanoTime();
    }

    private void validateScheduled0(long j, TimeUnit timeUnit) {
        validateScheduled(j, timeUnit);
    }

    protected boolean afterScheduledTaskSubmitted(long j) {
        return true;
    }

    protected boolean beforeScheduledTaskSubmitted(long j) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cancelScheduledTasks() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (!isNullOrEmpty(priorityQueue)) {
            for (ScheduledFutureTask scheduledFutureTask : (ScheduledFutureTask[]) priorityQueue.toArray(new ScheduledFutureTask[0])) {
                scheduledFutureTask.cancelWithoutRemove(false);
            }
            priorityQueue.clearIgnoringIndexes();
        }
    }

    protected final boolean hasScheduledTasks() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        return peekScheduledTask != null && peekScheduledTask.deadlineNanos() <= nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long nextScheduledTaskDeadlineNanos() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null) {
            return peekScheduledTask.deadlineNanos();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long nextScheduledTaskNano() {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask != null) {
            return peekScheduledTask.delayNanos();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ScheduledFutureTask<?> peekScheduledTask() {
        PriorityQueue<ScheduledFutureTask<?>> priorityQueue = this.scheduledTaskQueue;
        if (priorityQueue != null) {
            return priorityQueue.peek();
        }
        return null;
    }

    protected final Runnable pollScheduledTask() {
        return pollScheduledTask(nanoTime());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void removeScheduled(ScheduledFutureTask<?> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduledTaskQueue().removeTyped(scheduledFutureTask);
        } else {
            lazyExecute(scheduledFutureTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void scheduleFromEventLoop(ScheduledFutureTask<?> scheduledFutureTask) {
        PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue = scheduledTaskQueue();
        long j = this.nextTaskId + 1;
        this.nextTaskId = j;
        scheduledTaskQueue.add(scheduledFutureTask.setId(j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PriorityQueue<ScheduledFutureTask<?>> scheduledTaskQueue() {
        if (this.scheduledTaskQueue == null) {
            this.scheduledTaskQueue = new DefaultPriorityQueue(SCHEDULED_FUTURE_TASK_COMPARATOR, 11);
        }
        return this.scheduledTaskQueue;
    }

    @Deprecated
    protected void validateScheduled(long j, TimeUnit timeUnit) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractScheduledEventExecutor(EventExecutorGroup eventExecutorGroup) {
        super(eventExecutorGroup);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Runnable pollScheduledTask(long j) {
        ScheduledFutureTask<?> peekScheduledTask = peekScheduledTask();
        if (peekScheduledTask == null || peekScheduledTask.deadlineNanos() - j > 0) {
            return null;
        }
        this.scheduledTaskQueue.remove();
        peekScheduledTask.setConsumed();
        return peekScheduledTask;
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public c<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
        } else if (j2 > 0) {
            validateScheduled0(j, timeUnit);
            validateScheduled0(j2, timeUnit);
            return schedule(new ScheduledFutureTask(this, runnable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j)), timeUnit.toNanos(j2)));
        } else {
            throw new IllegalArgumentException(String.format("period: %d (expected: > 0)", Long.valueOf(j2)));
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public c<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            throw new IllegalArgumentException(String.format("initialDelay: %d (expected: >= 0)", Long.valueOf(j)));
        } else if (j2 > 0) {
            validateScheduled0(j, timeUnit);
            validateScheduled0(j2, timeUnit);
            return schedule(new ScheduledFutureTask(this, runnable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j)), -timeUnit.toNanos(j2)));
        } else {
            throw new IllegalArgumentException(String.format("delay: %d (expected: > 0)", Long.valueOf(j2)));
        }
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public c<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(runnable, "command");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        validateScheduled0(j, timeUnit);
        return schedule(new ScheduledFutureTask(this, runnable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j))));
    }

    @Override // io.netty.util.concurrent.AbstractEventExecutor, io.netty.util.concurrent.EventExecutorGroup, java.util.concurrent.ScheduledExecutorService
    public <V> c<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ObjectUtil.checkNotNull(callable, "callable");
        ObjectUtil.checkNotNull(timeUnit, "unit");
        if (j < 0) {
            j = 0;
        }
        validateScheduled0(j, timeUnit);
        return schedule(new ScheduledFutureTask<>(this, callable, ScheduledFutureTask.deadlineNanos(timeUnit.toNanos(j))));
    }

    private <V> c<V> schedule(ScheduledFutureTask<V> scheduledFutureTask) {
        if (inEventLoop()) {
            scheduleFromEventLoop(scheduledFutureTask);
        } else {
            long deadlineNanos = scheduledFutureTask.deadlineNanos();
            if (beforeScheduledTaskSubmitted(deadlineNanos)) {
                execute(scheduledFutureTask);
            } else {
                lazyExecute(scheduledFutureTask);
                if (afterScheduledTaskSubmitted(deadlineNanos)) {
                    execute(WAKEUP_TASK);
                }
            }
        }
        return scheduledFutureTask;
    }
}
