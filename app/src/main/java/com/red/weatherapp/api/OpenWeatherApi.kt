package com.red.weatherapp.api

import com.red.weatherapp.api.response.WeatherJson
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by _red_ on 11/01/2019
 */
interface OpenWeatherApi {

	@GET("weather")
	fun getWeather(
		@Query("lat") lat: Float,
		@Query("lon") lon: Float,
		@Query("APPID") id: String,
		@Query("units") units: String
	): Single<WeatherJson>

}