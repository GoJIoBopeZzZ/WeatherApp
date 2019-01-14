package com.red.weatherapp.ui.activities.main

import com.red.weatherapp.base.Presenter

class MainPresenter(view: MainView): Presenter<MainView>(view) {

    override fun onCreate() {
        view?.showMainContent()
    }

    override fun onDestroy() {
        detachView()
    }

}