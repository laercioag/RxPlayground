package com.laercioag.rxplayground

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val progressSubject = ProgressSubject
        progressSubject.subscribe(Consumer { progress ->
            runOnUiThread {
                text.text = progress
            }
            Log.i(MainActivity::class.java.simpleName, progress)
        })
    }
}
