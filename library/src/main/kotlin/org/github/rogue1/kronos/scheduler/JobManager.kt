package org.github.rogue1.kronos.scheduler

import org.github.rogue1.kronos.entity.Identifier
import org.github.rogue1.kronos.entity.Job
import org.github.rogue1.kronos.entity.JobInstance

abstract class JobManager(protected val workspace: Workspace) {

    abstract fun delete(id: Identifier): Unit

    abstract fun disable(id: Identifier): Unit

    abstract fun enable(id: Identifier): Unit

    abstract fun update(job: Job): Unit

    abstract fun launch(id: Identifier): JobInstance

}