package com.example.overviewpart1

import android.content.Context

class CustomManager private constructor(private val mContext: Context) {

    companion object {
        private var sInstance: CustomManager? = null
        fun getInstance(context: Context): CustomManager? {
            if (sInstance == null) {
                sInstance = CustomManager(context.applicationContext)
            }
            return sInstance
        }
    }

}