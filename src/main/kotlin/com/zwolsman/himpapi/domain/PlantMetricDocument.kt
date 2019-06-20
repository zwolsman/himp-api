package com.zwolsman.himpapi.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.annotation.Generated

@Document
class PlantMetricDocument(
        val light: Double,
        val moisture: Double,
        val fertility: Double,
        val temperature: Double) {
    @Id
    @Generated
    lateinit var id: ObjectId

    constructor(metric: PlantMetric) : this(metric.light, metric.moisture, metric.fertility, metric.temperature)
}