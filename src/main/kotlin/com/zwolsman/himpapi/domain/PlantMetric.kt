package com.zwolsman.himpapi.domain

import org.influxdb.dto.Point
import java.util.concurrent.TimeUnit

data class PlantMetric(
        val light: Double,
        val moisture: Double,
        val fertility: Double,
        val temperature: Double) {

    fun toPoint(plant: String? = null): Point = Point.measurement("plant").apply {
        time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
        tag("plant", plant ?: "unknown")
        addField("light", light)
        addField("moisture", moisture)
        addField("fertility", fertility)
        addField("temperature", temperature)
    }.build()
}