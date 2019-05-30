package com.laercioag.rxplayground

import android.app.IntentService
import android.content.Intent

class BackgroundIntentService : IntentService(BackgroundIntentService::class.java.simpleName) {

    override fun onHandleIntent(intent: Intent?) {
        val progressSubject = ProgressSubject

        repeat(60000) {
            Thread.sleep(1000)
            progressSubject.post(it.toString())
        }
    }

}