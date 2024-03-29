package okio;

import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public final class Pipe {
    @Nullable
    private Sink foldedSink;
    final long maxBufferSize;
    boolean sinkClosed;
    boolean sourceClosed;
    final Buffer buffer = new Buffer();
    private final Sink sink = new PipeSink();
    private final Source source = new PipeSource();

    /* loaded from: classes4.dex */
    final class PipeSink implements Sink {
        final PushableTimeout timeout = new PushableTimeout();

        PipeSink() {
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (!pipe.sinkClosed) {
                    if (pipe.foldedSink != null) {
                        sink = Pipe.this.foldedSink;
                    } else {
                        Pipe pipe2 = Pipe.this;
                        if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                            throw new IOException("source is closed");
                        }
                        Pipe pipe3 = Pipe.this;
                        pipe3.sinkClosed = true;
                        pipe3.buffer.notifyAll();
                        sink = null;
                    }
                    if (sink != null) {
                        this.timeout.push(sink.timeout());
                        try {
                            sink.close();
                        } finally {
                            this.timeout.pop();
                        }
                    }
                }
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                if (pipe.sinkClosed) {
                    throw new IllegalStateException("closed");
                } else if (pipe.foldedSink != null) {
                    sink = Pipe.this.foldedSink;
                } else {
                    Pipe pipe2 = Pipe.this;
                    if (pipe2.sourceClosed && pipe2.buffer.size() > 0) {
                        throw new IOException("source is closed");
                    }
                    sink = null;
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.flush();
                } finally {
                    this.timeout.pop();
                }
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            Sink sink;
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sinkClosed) {
                    while (true) {
                        if (j <= 0) {
                            sink = null;
                            break;
                        } else if (Pipe.this.foldedSink != null) {
                            sink = Pipe.this.foldedSink;
                            break;
                        } else {
                            Pipe pipe = Pipe.this;
                            if (!pipe.sourceClosed) {
                                long size = pipe.maxBufferSize - pipe.buffer.size();
                                if (size == 0) {
                                    this.timeout.waitUntilNotified(Pipe.this.buffer);
                                } else {
                                    long min = Math.min(size, j);
                                    Pipe.this.buffer.write(buffer, min);
                                    j -= min;
                                    Pipe.this.buffer.notifyAll();
                                }
                            } else {
                                throw new IOException("source is closed");
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
            if (sink != null) {
                this.timeout.push(sink.timeout());
                try {
                    sink.write(buffer, j);
                } finally {
                    this.timeout.pop();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    final class PipeSource implements Source {
        final Timeout timeout = new Timeout();

        PipeSource() {
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Pipe.this.buffer) {
                Pipe pipe = Pipe.this;
                pipe.sourceClosed = true;
                pipe.buffer.notifyAll();
            }
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.buffer) {
                if (!Pipe.this.sourceClosed) {
                    while (Pipe.this.buffer.size() == 0) {
                        Pipe pipe = Pipe.this;
                        if (pipe.sinkClosed) {
                            return -1L;
                        }
                        this.timeout.waitUntilNotified(pipe.buffer);
                    }
                    long read = Pipe.this.buffer.read(buffer, j);
                    Pipe.this.buffer.notifyAll();
                    return read;
                }
                throw new IllegalStateException("closed");
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public Pipe(long j) {
        if (j >= 1) {
            this.maxBufferSize = j;
            return;
        }
        throw new IllegalArgumentException("maxBufferSize < 1: " + j);
    }

    public void fold(Sink sink) throws IOException {
        boolean z;
        Buffer buffer;
        while (true) {
            synchronized (this.buffer) {
                if (this.foldedSink != null) {
                    throw new IllegalStateException("sink already folded");
                } else if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                } else {
                    z = this.sinkClosed;
                    buffer = new Buffer();
                    Buffer buffer2 = this.buffer;
                    buffer.write(buffer2, buffer2.size);
                    this.buffer.notifyAll();
                }
            }
            try {
                sink.write(buffer, buffer.size);
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    this.buffer.notifyAll();
                    throw th;
                }
            }
        }
    }

    public final Sink sink() {
        return this.sink;
    }

    public final Source source() {
        return this.source;
    }
}
