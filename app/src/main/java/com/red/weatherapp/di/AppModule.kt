package com.red.weatherapp.di

import com.red.weatherapp.ui.activities.main.MainPresenter
import com.red.weatherapp.ui.activities.main.MainView
import org.koin.dsl.module.module

val appModule = module {

    /**
     * Фабрика для MainPresenter. Предоставление зависимости как фабричный компонент,
     * т.е. создает каждый раз новый экземпляр.
     */
    factory { (view: MainView) -> MainPresenter(view) }

}

val weatherApp = listOf(appModule, weatherModule, remoteModule)