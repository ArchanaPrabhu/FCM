package com.raywenderlich.android.drinkit

import android.app.Application
import android.content.Context
import android.util.Log

class DrinkItApplication : Application() {
    private var measure : Int = 0
    override fun onCreate() {
        super.onCreate()
        Log.d("DrinkItApplication", (System.currentTimeMillis().toInt() - measure).toString())
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        measure = System.currentTimeMillis().toInt()
    }
}