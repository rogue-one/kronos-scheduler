package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.Scheduler

/**
 * trigger config
 */
class Trigger private constructor(scheduler: Scheduler,
                                  id: Identifier,
                                  val name: String,
                                  val jobName: String,
                                  val active: Boolean,
                                  val cron: String,
                                  val desc: String?,
                                  val parameters: List<Parameter>,
                                  isDeleted: Boolean) : Entity(id, scheduler, isDeleted) {

    fun instances(limit: Int): List<JobInstance> {
        return scheduler.triggerManager.instances(id, limit)
    }

    fun disable(): Trigger {
        scheduler.triggerManager.disable(id)
        return clone(false)
    }

    fun enable(): Trigger {
        scheduler.triggerManager.enable(id)
        return clone(true)
    }

    private fun clone(active: Boolean): Trigger {
        return Trigger(scheduler, id, name, jobName, active, cron, desc, parameters, isDeleted)
    }

}