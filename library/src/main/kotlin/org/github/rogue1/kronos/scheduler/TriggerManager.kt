package org.github.rogue1.kronos.scheduler

import org.github.rogue1.kronos.entity.Identifier
import org.github.rogue1.kronos.entity.JobInstance
import org.github.rogue1.kronos.entity.Trigger

abstract class TriggerManager(protected val workspace: Workspace) {

    abstract fun list(jobId: Identifier): List<Trigger>

    abstract fun instances(id: Identifier, limit: Int): List<JobInstance>

    abstract fun delete(id: Identifier): Unit

    abstract fun enable(id: Identifier): Unit

    abstract fun disable(id: Identifier): Unit

}