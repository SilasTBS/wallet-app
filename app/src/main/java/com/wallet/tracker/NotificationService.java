package com.wallet.tracker;

import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;

public class NotificationService extends NotificationListenerService {

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {

        String packageName = sbn.getPackageName();

        if (
                packageName.contains("wallet")
                || packageName.contains("nubank")
                || packageName.contains("c6bank")
        ) {

            CharSequence title = sbn.getNotification().extras.getCharSequence("android.title");
            CharSequence text = sbn.getNotification().extras.getCharSequence("android.text");

            String content =
                    "APP: " + packageName +
                    "\nTITLE: " + title +
                    "\nTEXT: " + text;

            TransactionStore.add(content);
        }
    }
}