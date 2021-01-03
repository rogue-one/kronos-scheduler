package org.github.rogue1.kronos.utils

import org.github.rogue1.kronos.entity.*
import java.lang.RuntimeException

sealed class AppException(override val message: String): RuntimeException(message)

class InvalidConfigException(message: String): AppException(message)

class EntityDeletedException(entity: Entity): AppException(message(entity)) {
    companion object {
        private fun message(entity: Entity): String {
            fun makeMsg(type: String, id: String): String = "$type of id $id has been deleted"
            return when(entity) {
                is Job -> makeMsg("Job", entity.id.value)
                is JobInstance -> makeMsg("JobInstance", entity.id.value)
                is Parameter -> makeMsg("Parameter", entity.id.value)
                is Trigger -> makeMsg("Trigger", entity.id.value)
                else -> makeMsg("Entity", entity.id.value)
            }
        }
    }
}