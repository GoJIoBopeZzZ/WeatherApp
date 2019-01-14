package com.red.weatherapp.ui.fragments.main

import com.red.weatherapp.base.Mapper
import com.red.weatherapp.model.weather.data.Weather

interface WeatherListView {

	fun showContent(items: List<WeatherPresentModel>)

	fun showLoading()

	fun showError()

}

data class WeatherPresentModel(
	val forecastString: String,
	val icon: String,
	val temperature: String
)

class WeatherToPresentModelMapper: Mapper<Weather, WeatherPresentModel> {

	override fun map(from: Weather): WeatherPresentModel =
		WeatherPresentModel(
			forecastString = from.weatherInfo.country,
			icon = from.weather.getOrNull(0)?.icon.orEmpty(),
			temperature = "${from.weatherMain.minTemp}°C - ${from.weatherMain.maxTemp}°C"
		)

}