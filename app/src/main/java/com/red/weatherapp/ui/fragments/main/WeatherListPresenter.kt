package com.red.weatherapp.ui.fragments.main

import com.red.weatherapp.base.Presenter

/**
 * Created by _red_ on 10/01/2019
 */
class WeatherListPresenter(view: WeatherListView): Presenter<WeatherListView>(view) {

    override fun onCreate() {
        //TODO: Не забудь реализовать
    }

    override fun onDestroy() {
        detachView()
    }

}