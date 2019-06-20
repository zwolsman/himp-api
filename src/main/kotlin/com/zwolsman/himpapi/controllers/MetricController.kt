package com.zwolsman.himpapi.controllers

import com.zwolsman.himpapi.domain.PlantMetric
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.delayEach
import org.apache.commons.logging.LogFactory
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@ExperimentalCoroutinesApi
@RestController
@RequestMapping("/api/metric")
class MetricController {

    private val log = LogFactory.getLog(javaClass)

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    suspend fun stream() : Flow<Int> {
        return (0..100).asFlow().delayEach(1000)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun add(@RequestBody metric: PlantMetric) {
        log.info("Received $metric")
        log.info("Creating new metric")
    }

}