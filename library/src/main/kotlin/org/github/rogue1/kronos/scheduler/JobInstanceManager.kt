package org.github.rogue1.kronos.scheduler

import org.github.rogue1.kronos.entity.Identifier
import org.github.rogue1.kronos.entity.JobInstance
import org.github.rogue1.kronos.entity.JobInstanceLogData
import org.github.rogue1.kronos.entity.JobInstanceState

abstract class JobInstanceManager(protected val workspace: Workspace) {

    abstract fun list(jobId: Identifier, limit: Int): List<JobInstance>

    abstract operator fun get(id: Identifier): JobInstanceLogData

    abstract operator fun set(id: Identifier, state: JobInstanceState): Unit

    abstract fun rerun(id: Identifier): Unit

    abstract fun fetchData(id: Identifier): JobInstanceLogData

}