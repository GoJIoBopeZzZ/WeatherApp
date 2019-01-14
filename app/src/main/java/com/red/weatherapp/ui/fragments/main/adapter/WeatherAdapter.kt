package com.red.weatherapp.ui.fragments.main.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.red.weatherapp.R
import com.red.weatherapp.base.view.recycler.DataAdapter
import com.red.weatherapp.ui.fragments.main.WeatherPresentModel
import kotlinx.android.synthetic.main.item_weather.view.*

class WeatherAdapter: DataAdapter<WeatherPresentModel, WeatherAdapter.ViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
		ViewHolder(
			LayoutInflater.from(parent.context)
				.inflate(R.layout.item_weather, parent, false))

	override fun onBindViewHolder(holder: ViewHolder, position: Int) =
		holder.bind(data[position])

	inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

		fun bind(model: WeatherPresentModel) {
			itemView.apply {
				tvForecast.text = model.forecastString
				tvTemperature.text = model.temperature
			}
		}

	}

}