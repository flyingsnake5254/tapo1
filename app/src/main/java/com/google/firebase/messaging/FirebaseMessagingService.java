package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.firebase.messaging.Constants;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
/* loaded from: classes2.dex */
public class FirebaseMessagingService extends EnhancedIntentService {
    @NonNull
    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds = new ArrayDeque(10);

    private boolean alreadyReceivedMessage(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Queue<String> queue = recentlyReceivedMessageIds;
        if (!queue.contains(str)) {
            if (queue.size() >= 10) {
                queue.remove();
            }
            queue.add(str);
            return false;
        } else if (!Log.isLoggable(Constants.TAG, 3)) {
            return true;
        } else {
            String valueOf = String.valueOf(str);
            Log.d(Constants.TAG, valueOf.length() != 0 ? "Received duplicate message: ".concat(valueOf) : new String("Received duplicate message: "));
            return true;
        }
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        if (NotificationParams.isNotification(extras)) {
            NotificationParams notificationParams = new NotificationParams(extras);
            ExecutorService newNetworkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            try {
                if (!new DisplayNotification(this, notificationParams, newNetworkIOExecutor).handleNotification()) {
                    newNetworkIOExecutor.shutdown();
                    if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                        MessagingAnalytics.logNotificationForeground(intent);
                    }
                } else {
                    return;
                }
            } finally {
                newNetworkIOExecutor.shutdown();
            }
        }
        onMessageReceived(new RemoteMessage(extras));
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MSGID);
        return stringExtra == null ? intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER) : stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra(Constants.MessagePayloadKeys.MSGID))) {
            passMessageIntentToSdk(intent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void passMessageIntentToSdk(Intent intent) {
        char c2;
        String stringExtra = intent.getStringExtra(Constants.MessagePayloadKeys.MESSAGE_TYPE);
        if (stringExtra == null) {
            stringExtra = Constants.MessageTypes.MESSAGE;
        }
        switch (stringExtra.hashCode()) {
            case -2062414158:
                if (stringExtra.equals(Constants.MessageTypes.DELETED)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 102161:
                if (stringExtra.equals(Constants.MessageTypes.MESSAGE)) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 814694033:
                if (stringExtra.equals(Constants.MessageTypes.SEND_ERROR)) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 814800675:
                if (stringExtra.equals(Constants.MessageTypes.SEND_EVENT)) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            MessagingAnalytics.logNotificationReceived(intent);
            dispatchMessage(intent);
        } else if (c2 == 1) {
            onDeletedMessages();
        } else if (c2 == 2) {
            onMessageSent(intent.getStringExtra(Constants.MessagePayloadKeys.MSGID));
        } else if (c2 != 3) {
            Log.w(Constants.TAG, stringExtra.length() != 0 ? "Received message with unknown type: ".concat(stringExtra) : new String("Received message with unknown type: "));
        } else {
            onSendError(getMessageId(intent), new SendException(intent.getStringExtra(Constants.IPC_BUNDLE_KEY_SEND_ERROR)));
        }
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    @NonNull
    protected Intent getStartCommandIntent(@NonNull Intent intent) {
        return ServiceStarter.getInstance().getMessagingEvent();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(@NonNull Intent intent) {
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action) || ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(action)) {
            handleMessageIntent(intent);
        } else if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
            onNewToken(intent.getStringExtra("token"));
        } else {
            String valueOf = String.valueOf(intent.getAction());
            Log.d(Constants.TAG, valueOf.length() != 0 ? "Unknown intent action: ".concat(valueOf) : new String("Unknown intent action: "));
        }
    }

    @WorkerThread
    public void onDeletedMessages() {
    }

    @WorkerThread
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
    }

    @WorkerThread
    public void onMessageSent(@NonNull String str) {
    }

    @WorkerThread
    public void onNewToken(@NonNull String str) {
    }

    @WorkerThread
    public void onSendError(@NonNull String str, @NonNull Exception exc) {
    }
}
