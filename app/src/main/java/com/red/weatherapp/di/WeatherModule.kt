package com.red.weatherapp.di

import com.red.weatherapp.ui.fragments.main.adapter.WeatherAdapter
import org.koin.dsl.module.module

val weatherModule = module {

	/**
	 * Фабрика для WeatherFragment. Предоставление зависимости как фабричный компонент,
	 * т.е. создает каждый раз новый экземпляр адаптера.
	 */
	factory { WeatherAdapter() }

}