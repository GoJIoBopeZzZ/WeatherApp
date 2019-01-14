package com.red.weatherapp.base

import java.lang.ref.WeakReference

abstract class Presenter<V>(view: V) {

    private var viewRef: WeakReference<V?> = WeakReference(view)

    val view: V?
        get() = viewRef.get()

    fun attachView(view: V) {
        viewRef = WeakReference(view)
    }

    fun detachView() {
        viewRef = WeakReference(null)
    }

    protected fun view(): V? = viewRef.get()

    abstract fun onCreate()

    abstract fun onDestroy()

}