package com.duckduckgo.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import leakcanary.LeakCanary
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LeakCanary.config = LeakCanary.config.copy(retainedVisibleThreshold = 1)

        setContentView(R.layout.activity_main)

        thread {
            Thread.sleep(10_000)
            Log.i(MainActivity::class.java.simpleName, "Oops, kept " + this@MainActivity)
        }
    }
}