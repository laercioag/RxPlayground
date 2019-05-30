package com.laercioag.rxplayground

import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.BehaviorSubject

object ProgressSubject {

    private val subject: BehaviorSubject<String> = BehaviorSubject.create()

    fun post(progress: String) = subject.onNext(progress)

    fun subscribe(action: Consumer<String>): Disposable = subject.subscribe(action)

}