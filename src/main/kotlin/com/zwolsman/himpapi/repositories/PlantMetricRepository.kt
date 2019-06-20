package com.zwolsman.himpapi.repositories

import com.zwolsman.himpapi.domain.PlantMetricDocument
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.CoroutineMongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.mongodb.repository.Tailable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@ExperimentalCoroutinesApi
@Repository
interface PlantMetricRepository : ReactiveCrudRepository<PlantMetricDocument, ObjectId> {
    @Tailable
    fun findWithTailableCursorBy() : Flux<PlantMetricDocument>
}