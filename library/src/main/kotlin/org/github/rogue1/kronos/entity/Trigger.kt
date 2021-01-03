package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.Scheduler
import org.github.rogue1.kronos.scheduler.TriggerManager
import org.github.rogue1.kronos.utils.Helper
import java.sql.Timestamp

/**
 * trigger config
 */
class Trigger private constructor(private val triggerManager: TriggerManager,
                                  id: Identifier,
                                  val name: String,
                                  val jobName: String,
                                  val active: Boolean,
                                  val cron: String,
                                  val desc: String?,
                                  val parameters: List<Parameter>,
                                  updatedAt: Timestamp) : Entity(id, updatedAt) {

    fun instances(limit: Int): List<JobInstance> {
        return triggerManager.instances(id, limit)
    }

    fun disable(): Trigger {
        triggerManager.disable(id)
        return clone(false)
    }

    fun enable(): Trigger {
        triggerManager.enable(id)
        return clone(true)
    }

    private fun clone(active: Boolean): Trigger {
        return Trigger(triggerManager, id, name, jobName, active, cron, desc, parameters, Helper.now())
    }

    override fun delete(): Unit {
        triggerManager.delete(id)
    }

}