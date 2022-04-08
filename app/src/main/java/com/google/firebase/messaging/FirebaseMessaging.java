package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.f;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
/* loaded from: classes2.dex */
public class FirebaseMessaging {
    @NonNull
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    @SuppressLint({"StaticFieldLeak"})
    private static Store store;
    @GuardedBy("FirebaseMessaging.class")
    @VisibleForTesting
    static ScheduledExecutorService syncExecutor;
    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    static f transportFactory;
    private final AutoInit autoInit;
    private final Context context;
    private final Executor fileIoExecutor;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi fis;
    private final GmsRpc gmsRpc;
    @Nullable
    private final FirebaseInstanceIdInternal iid;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final Metadata metadata;
    private final RequestDeduplicator requestDeduplicator;
    @GuardedBy("this")
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final Task<TopicsSubscriber> topicsSubscriberTask;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    /* loaded from: classes2.dex */
    public class AutoInit {
        @Nullable
        @GuardedBy("this")
        private Boolean autoInitEnabled;
        @Nullable
        @GuardedBy("this")
        private EventHandler<DataCollectionDefaultChange> dataCollectionDefaultChangeEventHandler;
        @GuardedBy("this")
        private boolean initialized;
        private final Subscriber subscriber;

        AutoInit(Subscriber subscriber) {
            this.subscriber = subscriber;
        }

        @Nullable
        private Boolean readEnabled() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseMessaging.this.firebaseApp.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void initialize() {
            if (!this.initialized) {
                Boolean readEnabled = readEnabled();
                this.autoInitEnabled = readEnabled;
                if (readEnabled == null) {
                    EventHandler<DataCollectionDefaultChange> firebaseMessaging$AutoInit$$Lambda$0 = new EventHandler(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$AutoInit$$Lambda$0
                        private final FirebaseMessaging.AutoInit arg$1;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.arg$1 = this;
                        }

                        @Override // com.google.firebase.events.EventHandler
                        public void handle(Event event) {
                            this.arg$1.lambda$initialize$0$FirebaseMessaging$AutoInit(event);
                        }
                    };
                    this.dataCollectionDefaultChangeEventHandler = firebaseMessaging$AutoInit$$Lambda$0;
                    this.subscriber.subscribe(DataCollectionDefaultChange.class, firebaseMessaging$AutoInit$$Lambda$0);
                }
                this.initialized = true;
            }
        }

        synchronized boolean isEnabled() {
            boolean z;
            initialize();
            Boolean bool = this.autoInitEnabled;
            if (bool != null) {
                z = bool.booleanValue();
            } else {
                z = FirebaseMessaging.this.firebaseApp.isDataCollectionDefaultEnabled();
            }
            return z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final /* synthetic */ void lambda$initialize$0$FirebaseMessaging$AutoInit(Event event) {
            if (isEnabled()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        synchronized void setEnabled(boolean z) {
            initialize();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.dataCollectionDefaultChangeEventHandler;
            if (eventHandler != null) {
                this.subscriber.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.dataCollectionDefaultChangeEventHandler = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.firebaseApp.getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            edit.putBoolean("auto_init", z);
            edit.apply();
            if (z) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
            this.autoInitEnabled = Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable f fVar, Subscriber subscriber) {
        this(firebaseApp, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, fVar, subscriber, new Metadata(firebaseApp.getApplicationContext()));
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging instance;
        synchronized (FirebaseMessaging.class) {
            instance = getInstance(FirebaseApp.getInstance());
        }
        return instance;
    }

    private String getSubtype() {
        return FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName()) ? "" : this.firebaseApp.getPersistenceKey();
    }

    @Nullable
    public static f getTransportFactory() {
        return transportFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeOnTokenRefresh */
    public void bridge$lambda$0$FirebaseMessaging(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.firebaseApp.getName())) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String valueOf = String.valueOf(this.firebaseApp.getName());
                Log.d(Constants.TAG, valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.context).process(intent);
        }
    }

    private synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSyncIfNecessary() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String blockingGetToken() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e2) {
                throw new IOException(e2);
            }
        } else {
            Store.Token tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
            if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
                return tokenWithoutTriggeringSync.token;
            }
            final String defaultSenderId = Metadata.getDefaultSenderId(this.firebaseApp);
            try {
                String str = (String) Tasks.await(this.fis.getId().continueWithTask(FcmExecutors.newNetworkIOExecutor(), new Continuation(this, defaultSenderId) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$8
                    private final FirebaseMessaging arg$1;
                    private final String arg$2;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.arg$1 = this;
                        this.arg$2 = defaultSenderId;
                    }

                    @Override // com.google.android.gms.tasks.Continuation
                    public Object then(Task task) {
                        return this.arg$1.lambda$blockingGetToken$9$FirebaseMessaging(this.arg$2, task);
                    }
                }));
                store.saveToken(getSubtype(), defaultSenderId, str, this.metadata.getAppVersionCode());
                if (tokenWithoutTriggeringSync == null || !str.equals(tokenWithoutTriggeringSync.token)) {
                    bridge$lambda$0$FirebaseMessaging(str);
                }
                return str;
            } catch (InterruptedException | ExecutionException e3) {
                throw new IOException(e3);
            }
        }
    }

    @NonNull
    public Task<Void> deleteToken() {
        if (this.iid != null) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.fileIoExecutor.execute(new Runnable(this, taskCompletionSource) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$4
                private final FirebaseMessaging arg$1;
                private final TaskCompletionSource arg$2;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = taskCompletionSource;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.arg$1.lambda$deleteToken$3$FirebaseMessaging(this.arg$2);
                }
            });
            return taskCompletionSource.getTask();
        } else if (getTokenWithoutTriggeringSync() == null) {
            return Tasks.forResult(null);
        } else {
            final ExecutorService newNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            return this.fis.getId().continueWithTask(newNetworkIOExecutor, new Continuation(this, newNetworkIOExecutor) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$5
                private final FirebaseMessaging arg$1;
                private final ExecutorService arg$2;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                    this.arg$2 = newNetworkIOExecutor;
                }

                @Override // com.google.android.gms.tasks.Continuation
                public Object then(Task task) {
                    return this.arg$1.lambda$deleteToken$5$FirebaseMessaging(this.arg$2, task);
                }
            });
        }
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.deliveryMetricsExportToBigQueryEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueueTaskWithDelaySeconds(Runnable runnable, long j) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            syncExecutor.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getApplicationContext() {
        return this.context;
    }

    @NonNull
    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.iid;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.fileIoExecutor.execute(new Runnable(this, taskCompletionSource) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$3
            private final FirebaseMessaging arg$1;
            private final TaskCompletionSource arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = taskCompletionSource;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.arg$1.lambda$getToken$2$FirebaseMessaging(this.arg$2);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Nullable
    @VisibleForTesting
    Store.Token getTokenWithoutTriggeringSync() {
        return store.getToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean isGmsCorePresent() {
        return this.metadata.isGmscorePresent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$blockingGetToken$8$FirebaseMessaging(Task task) {
        return this.gmsRpc.getToken((String) task.getResult());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$blockingGetToken$9$FirebaseMessaging(String str, final Task task) throws Exception {
        return this.requestDeduplicator.getOrStartGetTokenRequest(str, new RequestDeduplicator.GetTokenRequest(this, task) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$9
            private final FirebaseMessaging arg$1;
            private final Task arg$2;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
                this.arg$2 = task;
            }

            @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
            public Task start() {
                return this.arg$1.lambda$blockingGetToken$8$FirebaseMessaging(this.arg$2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$deleteToken$3$FirebaseMessaging(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.deleteToken(Metadata.getDefaultSenderId(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Void lambda$deleteToken$4$FirebaseMessaging(Task task) throws Exception {
        store.deleteToken(getSubtype(), Metadata.getDefaultSenderId(this.firebaseApp));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task lambda$deleteToken$5$FirebaseMessaging(ExecutorService executorService, Task task) throws Exception {
        return this.gmsRpc.deleteToken((String) task.getResult()).continueWith(executorService, new Continuation(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$10
            private final FirebaseMessaging arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                this.arg$1.lambda$deleteToken$4$FirebaseMessaging(task2);
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$getToken$2$FirebaseMessaging(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e2) {
            taskCompletionSource.setException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$0$FirebaseMessaging() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void lambda$new$1$FirebaseMessaging(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.startTopicsSyncIfNecessary();
        }
    }

    public void send(@NonNull RemoteMessage remoteMessage) {
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            intent.putExtra("app", PendingIntent.getBroadcast(this.context, 0, intent2, Build.VERSION.SDK_INT >= 23 ? 67108864 : 0));
            intent.setPackage("com.google.android.gms");
            remoteMessage.populateSendMessageIntent(intent);
            this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z) {
        this.autoInit.setEnabled(z);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z) {
        MessagingAnalytics.setDeliveryMetricsExportToBigQuery(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void setSyncScheduledOrRunning(boolean z) {
        this.syncScheduledOrRunning = z;
    }

    @NonNull
    public Task<Void> subscribeToTopic(@NonNull final String str) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation(str) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$6
            private final String arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task then(Object obj) {
                Task subscribeToTopic;
                subscribeToTopic = ((TopicsSubscriber) obj).subscribeToTopic(this.arg$1);
                return subscribeToTopic;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void syncWithDelaySecondsInternal(long j) {
        enqueueTaskWithDelaySeconds(new SyncTask(this, Math.min(Math.max(30L, j + j), MAX_DELAY_SEC)), j);
        this.syncScheduledOrRunning = true;
    }

    @VisibleForTesting
    boolean tokenNeedsRefresh(@Nullable Store.Token token) {
        return token == null || token.needsRefresh(this.metadata.getAppVersionCode());
    }

    @NonNull
    public Task<Void> unsubscribeFromTopic(@NonNull final String str) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation(str) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$7
            private final String arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            public Task then(Object obj) {
                Task unsubscribeFromTopic;
                unsubscribeFromTopic = ((TopicsSubscriber) obj).unsubscribeFromTopic(this.arg$1);
                return unsubscribeFromTopic;
            }
        });
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable f fVar, Subscriber subscriber, Metadata metadata) {
        this(firebaseApp, firebaseInstanceIdInternal, firebaseInstallationsApi, fVar, subscriber, metadata, new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi), FcmExecutors.newTaskExecutor(), FcmExecutors.newInitExecutor());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable f fVar, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor executor, Executor executor2) {
        this.syncScheduledOrRunning = false;
        transportFactory = fVar;
        this.firebaseApp = firebaseApp;
        this.iid = firebaseInstanceIdInternal;
        this.fis = firebaseInstallationsApi;
        this.autoInit = new AutoInit(subscriber);
        Context applicationContext = firebaseApp.getApplicationContext();
        this.context = applicationContext;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.lifecycleCallbacks = fcmLifecycleCallbacks;
        this.metadata = metadata;
        this.taskExecutor = executor;
        this.gmsRpc = gmsRpc;
        this.requestDeduplicator = new RequestDeduplicator(executor);
        this.fileIoExecutor = executor2;
        Context applicationContext2 = firebaseApp.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            String valueOf = String.valueOf(applicationContext2);
            StringBuilder sb = new StringBuilder(valueOf.length() + 125);
            sb.append("Context ");
            sb.append(valueOf);
            sb.append(" was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
            Log.w(Constants.TAG, sb.toString());
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new FirebaseInstanceIdInternal.NewTokenListener(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$0
                private final FirebaseMessaging arg$1;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.arg$1 = this;
                }

                @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
                public void onNewToken(String str) {
                    this.arg$1.bridge$lambda$0$FirebaseMessaging(str);
                }
            });
        }
        synchronized (FirebaseMessaging.class) {
            if (store == null) {
                store = new Store(applicationContext);
            }
        }
        executor2.execute(new Runnable(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$1
            private final FirebaseMessaging arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.arg$1.lambda$new$0$FirebaseMessaging();
            }
        });
        Task<TopicsSubscriber> createInstance = TopicsSubscriber.createInstance(this, firebaseInstallationsApi, metadata, gmsRpc, applicationContext, FcmExecutors.newTopicsSyncExecutor());
        this.topicsSubscriberTask = createInstance;
        createInstance.addOnSuccessListener(FcmExecutors.newTopicsSyncTriggerExecutor(), new OnSuccessListener(this) { // from class: com.google.firebase.messaging.FirebaseMessaging$$Lambda$2
            private final FirebaseMessaging arg$1;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.arg$1 = this;
            }

            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Object obj) {
                this.arg$1.lambda$new$1$FirebaseMessaging((TopicsSubscriber) obj);
            }
        });
    }
}
