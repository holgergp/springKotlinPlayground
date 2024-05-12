package com.example.demo

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.Date

@ExtendWith(MockKExtension::class)
class WeatherServiceTest {
    @MockK
    private lateinit var weatherRepository: WeatherRepository

    @Test
    fun getLastNByCity() {
        every { weatherRepository.save<Weather>(any()) } returnsArgument 0

        every { weatherRepository.findByCityOrderByDateDesc("Duesseldorf") } returns
            listOf(
                Weather(
                    20,
                    "C",
                    "Berlin",
                    Date(),
                ),
            )

        val weatherService = WeatherService(weatherRepository)
        val weather = Weather(20, "C", "Duesseldorf", Date())

        weatherService.reportWeather(weather)
        val lastN = weatherService.getLastNByCity("Duesseldorf", 1)
        assert(lastN.size == 1)
    }

    @Test
    fun getCurrentWeatherByCity() {
        every { weatherRepository.save<Weather>(any()) } returnsArgument 0

        every { weatherRepository.findByCityOrderByDateDesc("Duesseldorf") } returns
            listOf(
                Weather(
                    20,
                    "C",
                    "Berlin",
                    Date(),
                ),
            )

        val weatherService = WeatherService(weatherRepository)
        val weather = Weather(20, "C", "Duesseldorf", Date())
        weatherService.reportWeather(weather)
        val currentWeather = weatherService.getCurrentWeatherByCity("Duesseldorf")
        assert(currentWeather.temperature == 20)
    }
}
