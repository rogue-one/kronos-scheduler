package org.github.rogue1.kronos

import org.github.rogue1.kronos.settings.JobConfig
import org.github.rogue1.kronos.settings.Workspace

abstract class JobManager(protected val workspace: Workspace) {

    abstract fun create(config: JobConfig): Unit

    abstract fun delete(name: String): Unit

    abstract fun disable(name: String): Unit

    abstract fun enabled(name: String): Unit

    abstract fun list(): List<JobConfig>

    abstract fun trigger(name: String): Unit

}