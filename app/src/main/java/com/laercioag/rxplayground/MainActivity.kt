package com.laercioag.rxplayground

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.functions.Consumer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secondActivityBtn.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val progressSubject = ProgressSubject
        progressSubject.subscribe(Consumer { progress ->
            runOnUiThread {
                text.text = progress
            }
            Log.i(MainActivity::class.java.simpleName, progress)
        })

        val intent = Intent(this, BackgroundIntentService::class.java)
        startService(intent)
    }

}
