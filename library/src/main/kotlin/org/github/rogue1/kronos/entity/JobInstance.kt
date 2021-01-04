package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.JobInstanceManager
import org.github.rogue1.kronos.scheduler.ParameterManager
import org.github.rogue1.kronos.utils.Helper
import java.sql.Timestamp

@Suppress("MemberVisibilityCanBePrivate")
class JobInstance private constructor(
        private val jobInstanceManager: JobInstanceManager,
        id: Identifier,
        val jobId: Identifier,
        val hostName: String,
        val procId: Int,
        val triggeredBy: Identifier?,
        val startTimestamp: Timestamp,
        val endTimestamp: Timestamp?,
        val exitCode: Int?,
        val state: JobInstanceState,
        updatedAt: Timestamp): Entity(id, updatedAt=updatedAt) {

    val logData: JobInstanceLogData? by lazy { jobInstanceManager.fetchData(id) }

    fun markSucceeded(): JobInstance {
        jobInstanceManager[id] = JobInstanceState.SUCCEEDED
        return copy(state=JobInstanceState.SUCCEEDED)
    }

    fun markFailed(): JobInstance {
        jobInstanceManager[id] = JobInstanceState.FAILED
        return copy(state=JobInstanceState.FAILED)
    }

    fun markCompleted(): JobInstance {
        jobInstanceManager[id] = JobInstanceState.COMPLETED
        return copy(state=JobInstanceState.COMPLETED)
    }

    fun rerun(): JobInstance {
        return jobInstanceManager.rerun(id)
    }

    override fun delete(): Unit {
        jobInstanceManager.delete(id)
    }

    private fun copy(procId: Int = this.procId,
                     triggeredBy: Identifier? = this.triggeredBy,
                     startTimestamp: Timestamp = this.startTimestamp,
                     endTimestamp: Timestamp? = this.endTimestamp,
                     exitCode: Int? = this.exitCode,
                     state: JobInstanceState = this.state): JobInstance {
        return JobInstance(jobInstanceManager, id, jobId, hostName, procId, triggeredBy, startTimestamp, endTimestamp,
                exitCode, state, Helper.now())
    }

}