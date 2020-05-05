package com.example.overviewpart1

import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast

class HelloService : Service() {

    private lateinit var mServiceLooper: Looper
    private lateinit var mServiceHandler: Handler

    override fun onCreate() {
        // Get the HandlerThread's Looper and use it for our Handler
        mServiceLooper = HandlerThread("ServiceStartArguments").apply {
            start()
        }.looper
        mServiceHandler = ServiceHandler(mServiceLooper)
//        Toast.makeText(this@HelloService, "${isMainThread()}", Toast.LENGTH_LONG).show()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mServiceHandler.sendMessage(mServiceHandler.obtainMessage().apply {
            arg1 = startId
        })
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null  // We don't provide binding, so return null
    }

    inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            Toast.makeText(this@HelloService, "${isMainThread()}", Toast.LENGTH_LONG).show()
        }
    }

    private fun isMainThread(): Boolean = Looper.myLooper() == Looper.getMainLooper()
}




