package com.example.demo

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import java.util.Date

@Entity
class Weather(
    var temperature: Int,
    var unit: String,
    var city: String,
    var date: Date,
    @Id @GeneratedValue var id: Long? = null
)
