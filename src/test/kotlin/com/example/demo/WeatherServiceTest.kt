package com.example.demo

import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import org.junit.jupiter.api.Test
import java.util.Date

class WeatherServiceTest {
    @Test
    fun getLastNByCity() {

        val weatherRepository: WeatherRepository = mockk()
        justRun { weatherRepository.save(any()) }
        every { weatherRepository.findByCityOrderByDateDesc("Duesseldorf") } returns listOf(Weather(20, "C", "Berlin", Date()))

        val weatherService = WeatherService(weatherRepository)
        val weather = Weather(20, "C", "Duesseldorf", Date())

        //weatherService.reportWeather(weather)
        val lastN = weatherService.getLastNByCity("Duesseldorf", 1)
        assert(lastN.size == 1)
    }

    @Test
    fun getCurrentWeatherByCity() {
        val weatherRepository: WeatherRepository = mockk()
        justRun { weatherRepository.save(any()) }

        every { weatherRepository.findByCityOrderByDateDesc("Duesseldorf") } returns listOf(Weather(20, "C", "Berlin", Date()))

        val weatherService = WeatherService(weatherRepository)
        val weather = Weather(20, "C", "Duesseldorf", Date())
        // weatherService.reportWeather(weather)
        val currentWeather = weatherService.getCurrentWeatherByCity("Duesseldorf")
        assert(currentWeather.temperature == 20)
    }
}
