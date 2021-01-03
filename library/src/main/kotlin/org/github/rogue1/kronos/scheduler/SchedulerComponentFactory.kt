package org.github.rogue1.kronos.scheduler

interface SchedulerComponentFactory {

    fun makeJobManager(workspace: Workspace): JobManager

    fun makeJobInstanceManager(workspace: Workspace): JobInstanceManager

    fun makeTriggerManager(workspace: Workspace): TriggerManager

    fun makeParameterManager(workspace: Workspace): ParameterManager

}