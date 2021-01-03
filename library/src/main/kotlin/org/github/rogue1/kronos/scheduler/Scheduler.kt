package org.github.rogue1.kronos.scheduler


abstract class Scheduler(workspace: Workspace,
                         private val factory: SchedulerComponentFactory) {

    protected var workspace: Workspace = workspace
    set(value) {
        field = value
        jobManager = factory.makeJobManager(value)
        jobInstanceManager = factory.makeJobInstanceManager(value)
        triggerManager = factory.makeTriggerManager(value)
    }

    var jobManager: JobManager = factory.makeJobManager(workspace)
    private set

    var jobInstanceManager: JobInstanceManager = factory.makeJobInstanceManager(workspace)
    private set

    var triggerManager: TriggerManager = factory.makeTriggerManager(workspace)
    private set

    var parameterManager: ParameterManager = factory.makeParameterManager(workspace)
    private set

}