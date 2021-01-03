package org.github.rogue1.kronos

import org.github.rogue1.kronos.settings.*

abstract class JobInstanceManager(protected val workspace: Workspace) {

    abstract fun list(jobName: String): List<JobInstance>

    abstract operator fun get(id: InstanceId): JobInstanceData

    abstract operator fun set(id: InstanceId, state: JobInstanceState): Unit

}