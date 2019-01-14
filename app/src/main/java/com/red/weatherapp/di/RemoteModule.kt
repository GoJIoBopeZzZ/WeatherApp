package com.red.weatherapp.di

import com.red.weatherapp.BuildConfig
import com.red.weatherapp.api.OpenWeatherApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteModule = module {

	single { createOkHttpClient() }

	single<OpenWeatherApi> { apiService(get(), getProperty(BuildConfig.OPEN_WEATHER_API_URL)) }

}

fun createOkHttpClient(): OkHttpClient {
	val timeout = 10L
	val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
		level = HttpLoggingInterceptor.Level.BASIC
	}

	return OkHttpClient.Builder()
		.readTimeout(timeout, TimeUnit.SECONDS)
		.writeTimeout(timeout, TimeUnit.SECONDS)
		.connectTimeout(timeout, TimeUnit.SECONDS)
		.addInterceptor(httpLoggingInterceptor)
		.build()
}

inline fun <reified T> apiService(okHttpClient: OkHttpClient, url: String): T {
	val retrofit = Retrofit.Builder()
		.baseUrl(url)
		.client(okHttpClient)
		.addConverterFactory(GsonConverterFactory.create())
		.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
		.build()

	return retrofit.create(T::class.java)
}