package io.github.tuguzt.sql.backend.spring.controller

import io.github.tuguzt.sql.backend.spring.service.EntityService
import io.github.tuguzt.sql.domain.model.Identifiable

sealed interface EntityController<T : Identifiable<I>, I : Any> {
    val service: EntityService<T, I>

    suspend fun getAll(): Set<T> = service.getAll()

    suspend fun insert(entity: T): T = service.insert(entity)

    suspend fun update(entity: T): Unit = service.update(entity)

    suspend fun delete(entity: T): Unit = service.delete(entity)

    suspend fun findById(id: I): T? = service.findById(id)

    suspend fun deleteById(id: I): Unit = service.deleteById(id)
}
