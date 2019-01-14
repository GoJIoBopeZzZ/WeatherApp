package com.red.weatherapp.model.weather.data

data class Weather(
	val id: Long,
	val name: String,
	val code: Int,
	val weatherCoord: WeatherCoord,
	val weather: List<WeatherItem>,
	val base: String,
	val weatherMain: WeatherMain,
	val visibility: Int,
	val weatherWind: WeatherWind,
	val weatherClouds: WeatherClouds,
	val dt: Long,
	val weatherInfo: WeatherInfo
)

data class WeatherCoord(
	val lon: Float,
	val lat: Float
)

data class WeatherItem(
	val id: Long,
	val main: String,
	val description: String,
	val icon: String
)

data class WeatherMain(
	val temp: Float,
	val pressure: Int,
	val humidity: Int,
	val minTemp: Int,
	val maxTemp: Int
)

data class WeatherWind(
	val speed: Int,
	val deg: Int
)

data class WeatherClouds(
	val all: Int
)

data class WeatherInfo(
	val id: Long,
	val type: Int,
	val message: Float,
	val country: String,
	val sunrise: Long,
	val sunset: Long
)