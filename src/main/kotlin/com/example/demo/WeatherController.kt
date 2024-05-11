package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/weather")
class WeatherController(private val service: WeatherService) {
    @GetMapping("/hello")
    fun hello(): String {
        return "Hello, World!"
    }

    @GetMapping("/currentByCity/{city}")
    fun currentByCity(
        @PathVariable city: String,
    ): Weather {
        return service.getCurrentWeatherByCity(city)
    }

    @GetMapping("/lastNByCity/{city}/{lastN}")
    fun lastNByCity(
        @PathVariable city: String,
        @PathVariable lastN: Number,
    ): List<Weather> {
        return service.getLastNByCity(city, lastN)
    }

    @PostMapping("/report")
    fun report(
        @RequestBody request: WeatherReport,
    ) {
        service.reportWeather(
            Weather(
                temperature = request.temperature,
                unit = request.unit,
                city = request.city,
                date = request.date,
            )
        )
    }
}
