package com.zwolsman.himpapi.services

import com.zwolsman.himpapi.domain.PlantMetric
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import org.influxdb.dto.Point
import org.influxdb.dto.Query
import org.springframework.data.influxdb.InfluxDBTemplate
import org.springframework.stereotype.Service

@FlowPreview
@ExperimentalCoroutinesApi
@Service
class PlantMetricService(private val template: InfluxDBTemplate<Point>) {

    suspend fun save(metric: PlantMetric) : Point {
        val point = metric.toPoint(plant = "1")
        template.write(point)
        return point
    }

    suspend fun read() {
        template.query(Query(""))
    }

}