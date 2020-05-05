package com.example.overviewpart1

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.IBinder

class CustomService : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val notification: Notification = Notification()
        startForeground(123, notification)
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }
}