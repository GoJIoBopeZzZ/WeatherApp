package com.red.weatherapp.base

interface Mapper<F, T> {

    fun map(from: F): T

}