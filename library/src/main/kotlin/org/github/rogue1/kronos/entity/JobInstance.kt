package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.Scheduler
import java.sql.Timestamp

class JobInstance private constructor(
        scheduler: Scheduler,
        id: Identifier,
        val jobId: Identifier,
        val hostName: String,
        val procId: Int,
        val triggeredBy: Identifier?,
        val startTimestamp: Timestamp,
        val endTimestamp: Timestamp,
        val exitCode: Int?,
        val state: JobInstanceState,
        isDeleted: Boolean): Entity(id, scheduler, isDeleted) {

    val logData: JobInstanceLogData? by lazy { scheduler.jobInstanceManager.fetchData(id)  }

    fun markSucceeded(): Unit {
        scheduler.jobInstanceManager[id] = JobInstanceState.SUCCEEDED
    }

    fun markFailed(): Unit {
        scheduler.jobInstanceManager[id] = JobInstanceState.FAILED
    }

    fun markCompleted(): Unit {
        scheduler.jobInstanceManager[id] = JobInstanceState.COMPLETED
    }

    fun rerun(): Unit {
        scheduler.jobInstanceManager.rerun(id)
    }

}