package org.github.rogue1.kronos


abstract class Scheduler(var workspace: String) {

    abstract fun jobManager(): JobManager

    abstract fun jobInstanceManager(): JobInstanceManager

    abstract fun triggerManager(): TriggerManager

}