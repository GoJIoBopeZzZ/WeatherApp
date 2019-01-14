package com.red.weatherapp.model.weather.mapper

import com.red.weatherapp.api.response.*
import com.red.weatherapp.base.Mapper
import com.red.weatherapp.extensions.orDefault
import com.red.weatherapp.model.weather.data.*

/**
 * Created by _red_ on 11/01/2019
 */
class WeatherFromJsonMapper(
	private val coordsMapper: Mapper<WeatherCoordJson?, WeatherCoord> = WeatherCoordFromJsonMapper(),
	private val itemsMapper: Mapper<WeatherItemJson?, WeatherItem> = WeatherItemFromJsonMapper(),
	private val mainMapper: Mapper<WeatherMainJson?, WeatherMain> = WeatherMainFromJsonMapper(),
	private val windMapper: Mapper<WeatherWindJson?, WeatherWind> = WeatherWindFromJsonMapper(),
	private val cloudsMapper: Mapper<WeatherCloudsJson?, WeatherClouds> = WeatherCloudsFromJsonMapper(),
	private val infoMapper: Mapper<WeatherInfoJson?, WeatherInfo> = WeatherInfoFromJsonMapper()
): Mapper<WeatherJson, Weather> {

	override fun map(from: WeatherJson): Weather =
		Weather(
			id = from.id.orDefault(),
			name = from.name.orEmpty(),
			code = from.code.orDefault(),
			base = from.base.orEmpty(),
			visibility = from.visibility.orDefault(),
			dt = from.dt.orDefault(),
			weatherCoord = coordsMapper.map(from.weatherCoord),
			weather = from.weather?.map(itemsMapper::map) ?: emptyList(),
			weatherMain = mainMapper.map(from.weatherMain),
			weatherWind = windMapper.map(from.weatherWind),
			weatherClouds = cloudsMapper.map(from.weatherClouds),
			weatherInfo = infoMapper.map(from.weatherInfo)
		)

}

class WeatherCoordFromJsonMapper: Mapper<WeatherCoordJson?, WeatherCoord> {

	override fun map(from: WeatherCoordJson?): WeatherCoord =
		WeatherCoord(
			lon = from?.lon.orDefault(),
			lat = from?.lat.orDefault()
		)

}

class WeatherItemFromJsonMapper: Mapper<WeatherItemJson?, WeatherItem> {

	override fun map(from: WeatherItemJson?): WeatherItem =
		WeatherItem(
			id = from?.id.orDefault(),
			main = from?.main.orEmpty(),
			description = from?.description.orEmpty(),
			icon = from?.icon.orEmpty()
		)

}

class WeatherMainFromJsonMapper: Mapper<WeatherMainJson?, WeatherMain> {

	override fun map(from: WeatherMainJson?): WeatherMain =
		WeatherMain(
			temp = from?.temp.orDefault(),
			pressure = from?.pressure.orDefault(),
			humidity = from?.humidity.orDefault(),
			minTemp = from?.minTemp.orDefault(),
			maxTemp = from?.maxTemp.orDefault()
		)

}

class WeatherWindFromJsonMapper: Mapper<WeatherWindJson?, WeatherWind> {

	override fun map(from: WeatherWindJson?): WeatherWind =
		WeatherWind(
			speed = from?.speed.orDefault(),
			deg = from?.deg.orDefault()
		)

}

class WeatherCloudsFromJsonMapper: Mapper<WeatherCloudsJson?, WeatherClouds> {

	override fun map(from: WeatherCloudsJson?): WeatherClouds =
		WeatherClouds(
			all = from?.all.orDefault()
		)

}

class WeatherInfoFromJsonMapper: Mapper<WeatherInfoJson?, WeatherInfo> {

	override fun map(from: WeatherInfoJson?): WeatherInfo =
		WeatherInfo(
			id = from?.id.orDefault(),
			type = from?.type.orDefault(),
			message = from?.message.orDefault(),
			country = from?.country.orEmpty(),
			sunrise = from?.sunrise.orDefault(),
			sunset = from?.sunset.orDefault()
		)

}