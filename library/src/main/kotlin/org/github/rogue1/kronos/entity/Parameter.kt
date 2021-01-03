package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.ParameterManager
import java.sql.Timestamp


class Parameter private constructor(
        private val parameterManager: ParameterManager,
        id: Identifier,
        val key: String,
        val value: String,
        updatedAt: Timestamp) : Entity(id) {

    override fun delete() {
        parameterManager.delete(id)
    }

}