package org.github.rogue1.kronos.scheduler

import org.github.rogue1.kronos.entity.Identifier
import org.github.rogue1.kronos.entity.Job

abstract class JobManager(protected val workspace: Workspace) {

    abstract fun delete(id: Identifier): Unit

    abstract fun disable(id: Identifier): Unit

    abstract fun enable(id: Identifier): Unit

    abstract fun list(): List<Job>

    abstract fun launch(id: Identifier): Unit

    abstract fun getByName(name: String): Job?

}