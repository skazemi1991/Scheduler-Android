package com.scheduler.schedule.utils;

import android.app.PendingIntent;
import android.content.Context;


public class Alarms {
    private Context context;
    private PendingIntent pendingIntent;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public PendingIntent getPendingIntent() {
        return pendingIntent;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }
}
