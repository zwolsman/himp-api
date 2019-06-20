package com.zwolsman.himpapi.services

import com.zwolsman.himpapi.domain.PlantMetric
import com.zwolsman.himpapi.domain.PlantMetricDocument
import com.zwolsman.himpapi.repositories.PlantMetricRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.flow.asFlow
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Service

@FlowPreview
@ExperimentalCoroutinesApi
@Service
class PlantMetricService(private val repo: PlantMetricRepository, private val template: ReactiveMongoTemplate) {

    val tail: Flow<PlantMetricDocument>
        get() = repo.findWithTailableCursorBy().asFlow()

    suspend fun save(metric: PlantMetric) : PlantMetricDocument {
        val document = PlantMetricDocument(metric)
        return repo.save(document).awaitFirst()
    }

    suspend fun something() {

    }
}