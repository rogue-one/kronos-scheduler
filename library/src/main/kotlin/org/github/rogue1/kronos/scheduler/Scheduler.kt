package org.github.rogue1.kronos.scheduler

import org.github.rogue1.kronos.entity.Job
import org.github.rogue1.kronos.entity.Trigger


abstract class Scheduler(workspace: Workspace,
                         private val factory: SchedulerComponentFactory) {

    init {
        setManagers(workspace)
    }

    var workspace: Workspace = workspace
    set(value) {
        field = value
        setManagers(value)
    }

    private fun setManagers(workspace: Workspace) {
        jobManager = factory.makeJobManager(workspace)
        jobInstanceManager = factory.makeJobInstanceManager(workspace)
        triggerManager = factory.makeTriggerManager(workspace)
    }

    private var jobManager: JobManager = factory.makeJobManager(workspace)

    private var jobInstanceManager: JobInstanceManager = factory.makeJobInstanceManager(workspace)

    private var triggerManager: TriggerManager = factory.makeTriggerManager(workspace)

    private var parameterManager: ParameterManager = factory.makeParameterManager(workspace)

    abstract fun jobs(): List<Job>

    abstract fun getJobByName(name: String): Job?

    abstract fun triggers(): List<Trigger>

    abstract fun createTrigger(config: Trigger): Unit

}