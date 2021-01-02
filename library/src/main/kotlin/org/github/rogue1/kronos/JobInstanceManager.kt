package org.github.rogue1.kronos

import org.github.rogue1.kronos.settings.InstanceId
import org.github.rogue1.kronos.settings.JobInstance
import org.github.rogue1.kronos.settings.JobInstanceData
import org.github.rogue1.kronos.settings.JobInstanceState

abstract class JobInstanceManager(protected val workspace: String) {

    abstract fun list(jobName: String): List<JobInstance>

    abstract operator fun get(id: InstanceId): JobInstanceData

    abstract operator fun set(id: InstanceId, state: JobInstanceState): Unit

}