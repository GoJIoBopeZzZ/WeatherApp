package com.red.weatherapp.extensions

fun Int?.orDefault(): Int = this ?: -1

fun Long?.orDefault(): Long = this ?: -1L

fun Float?.orDefault(): Float = this ?: -1F

fun Boolean?.orFalse(): Boolean = this ?: false