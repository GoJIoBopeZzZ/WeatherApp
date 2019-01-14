package com.red.weatherapp.api.response

import com.google.gson.annotations.SerializedName

/**
 * Created by _red_ on 11/01/2019
 */
data class WeatherJson(
	val id: Long? = null,
	val name: String? = null,
	@SerializedName(value = "cod") val code: Int? = null,
	val weatherCoord: WeatherCoordJson? = null,
	val weather: List<WeatherItemJson>? = null,
	val base: String? = null,
	val weatherMain: WeatherMainJson? = null,
	val visibility: Int? = null,
	val weatherWind: WeatherWindJson? = null,
	val weatherClouds: WeatherCloudsJson? = null,
	val dt: Long? = null,
	val weatherInfo: WeatherInfoJson? = null
)

data class WeatherCoordJson(
	val lon: Float? = null,
	val lat: Float? = null
)

data class WeatherItemJson(
	val id: Long? = null,
	val main: String? = null,
	val description: String? = null,
	val icon: String? = null
)

data class WeatherMainJson(
	val temp: Float? = null,
	val pressure: Int? = null,
	val humidity: Int? = null,
	@SerializedName(value = "temp_min") val minTemp: Int? = null,
	@SerializedName(value = "temp_max") val maxTemp: Int? = null
)

data class WeatherWindJson(
	val speed: Int? = null,
	val deg: Int? = null
)

data class WeatherCloudsJson(
	val all: Int? = null
)

data class WeatherInfoJson(
	val id: Long? = null,
	val type: Int? = null,
	val message: Float? = null,
	val country: String? = null,
	val sunrise: Long? = null,
	val sunset: Long? = null
)