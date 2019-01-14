package com.red.weatherapp.ui.fragments.main

import com.red.weatherapp.base.AbsFragment
import com.red.weatherapp.ui.fragments.main.adapter.WeatherAdapter
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class WeatherListFragment: AbsFragment(), WeatherListView {

    companion object {

        const val TAG = "WeatherListFragment"

        fun newInstance() = WeatherListFragment()

    }

    private val weatherAdapter: WeatherAdapter by inject()
    private val presenter: WeatherListPresenter by inject { parametersOf(this) }

    override fun showContent(items: List<WeatherPresentModel>) {
        //TODO: Не забудь реализовать
    }

    override fun showLoading() {
        //TODO: Не забудь реализовать
    }

    override fun showError() {
        //TODO: Не забудь реализовать
    }

}