package com.red.weatherapp.ui.activities.main

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.red.weatherapp.R
import com.red.weatherapp.base.AbsActivity
import com.red.weatherapp.extensions.replace
import com.red.weatherapp.ui.fragments.main.WeatherListFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AbsActivity(), MainView {

	/**
	 * Благодаря by inject(), у нас происходит ленивая инициализация компонента.
	 */
	private val presenter: MainPresenter by inject { parametersOf(this) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

	override fun onStart() {
		super.onStart()

		presenter.onCreate()
	}

	override fun showMainContent() {
		WeatherListFragment.newInstance()
			.replace(this, R.id.vgMainContent, WeatherListFragment.TAG, FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
	}

	override fun onStop() {
		presenter.onDestroy()

		super.onStop()
	}

}
