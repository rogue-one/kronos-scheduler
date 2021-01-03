package org.github.rogue1.kronos

import org.github.rogue1.kronos.settings.TriggerConfig
import org.github.rogue1.kronos.settings.Workspace

abstract class TriggerManager(protected val workspace: Workspace) {

    abstract fun list(): List<TriggerConfig>

    abstract fun list(jobName: String): List<TriggerConfig>

    abstract fun create(config: TriggerConfig): Unit

    abstract fun delete(name: String): Unit

    abstract fun enabled(name: String): Unit

    abstract fun disable(name: String): Unit

}