package com.example.demo

import java.util.Date

data class WeatherRequest(val city: String, val date: Date, val preferredUnit: String?)
