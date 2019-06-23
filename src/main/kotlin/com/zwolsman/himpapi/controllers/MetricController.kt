package com.zwolsman.himpapi.controllers

import com.zwolsman.himpapi.domain.PlantMetric
import com.zwolsman.himpapi.services.PlantMetricService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.emptyFlow
import org.apache.commons.logging.LogFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FlowPreview
@ExperimentalCoroutinesApi
@RestController
@RequestMapping("/api/metric")
class MetricController(val service: PlantMetricService) {

    private val log = LogFactory.getLog(javaClass)

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    suspend fun stream() = emptyFlow<PlantMetric>()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun add(@RequestBody metric: PlantMetric) {
        val point = service.save(metric)
        log.info("Created new metric ($point)")
    }

}