package com.zwolsman.himpapi.controllers

import com.zwolsman.himpapi.domain.PlantMetric
import com.zwolsman.himpapi.repositories.PlantMetricRepository
import com.zwolsman.himpapi.services.PlantMetricService
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.map
import org.apache.commons.logging.LogFactory
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FlowPreview
@ExperimentalCoroutinesApi
@RestController
@RequestMapping("/api/metric")
class MetricController(val service: PlantMetricService, private val repo: PlantMetricRepository, private val template: ReactiveMongoTemplate) {

    private val log = LogFactory.getLog(javaClass)

    @GetMapping(produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    suspend fun stream() = service.tail.map { PlantMetric(it) }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun add(@RequestBody metric: PlantMetric) {
        log.info("Received $metric")
        val doc = service.save(metric)
        log.info("Created new metric (${doc.id})")
    }

}