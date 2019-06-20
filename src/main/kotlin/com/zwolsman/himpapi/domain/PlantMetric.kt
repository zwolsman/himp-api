package com.zwolsman.himpapi.domain

data class PlantMetric(
        val light: Double,
        val moisture: Double,
        val fertility: Double,
        val temperature: Double) {
    constructor(document: PlantMetricDocument) : this(document.light, document.moisture, document.fertility, document.temperature)
}