package com.example.demo

import org.springframework.stereotype.Service

@Service
class WeatherService(private val repository: WeatherRepository) {
    fun reportWeather(weather: Weather) {
        repository.save(weather)
    }

    fun getLastNByCity(
        city: String,
        lastN: Number,
    ): List<Weather> {
        return repository.findByCityOrderByDateDesc(city).take(lastN.toInt())
    }

    fun getCurrentWeatherByCity(city: String): Weather {
        return repository.findByCityOrderByDateDesc(city).first()
    }
}
