package com.example.demo
import org.springframework.data.repository.CrudRepository

interface WeatherRepository : CrudRepository<Weather, Long> {
    fun findByCity(city: String): List<Weather>
    fun findByCityOrderByDateDesc(city: String): List<Weather>
}
