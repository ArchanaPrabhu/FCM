package com.raywenderlich.android.drinkit

import android.app.Application
import android.content.Context
import android.os.Debug
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DrinkItApplication : Application() {
    private var measure: Int = 0

    override fun onCreate() {
        super.onCreate()
        Log.d("DrinkItApplication",
            (System.currentTimeMillis()
                .toInt() - measure).toString() + " " + Thread.currentThread().name
        )
        val dateFormat = SimpleDateFormat("dd_MM_yyyy_hh_mm_ss", Locale.getDefault())
        val logDate: String = dateFormat.format(Date())
        // Applies the date and time to the name of the trace log.
        Debug.startMethodTracing(
            "sample-$logDate"
        )
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        measure = System.currentTimeMillis().toInt()
    }
}