package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.Scheduler

class Job private constructor(
        scheduler: Scheduler,
        id: Identifier,
        val name: String,
        val cmd: String,
        val cwd: String?,
        val isEnabled: String,
        val envVars: Map<String, String>,
        val timeout: Long,
        isDeleted: Boolean): Entity(id, scheduler, isDeleted) {

    fun enable(): Unit {
        scheduler.jobManager.enable(id)
    }

    fun disable(): Unit {
        scheduler.jobManager.disable(id)
    }

    fun delete(): Unit {
        scheduler.jobManager.delete(id)
    }

    fun launch(): Unit {
        scheduler.jobManager.launch(id)
    }

    fun instances(limit: Int): List<JobInstance> {
        return scheduler.jobInstanceManager.list(id, limit)
    }

    fun triggers(): List<Trigger> {
        return scheduler.triggerManager.list(id)
    }


}