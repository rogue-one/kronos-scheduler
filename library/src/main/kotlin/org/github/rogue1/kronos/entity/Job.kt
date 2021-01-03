package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.JobInstanceManager
import org.github.rogue1.kronos.scheduler.JobManager
import org.github.rogue1.kronos.scheduler.TriggerManager
import org.github.rogue1.kronos.utils.Helper
import java.io.File
import java.sql.Timestamp

@Suppress("MemberVisibilityCanBePrivate")
class Job private constructor(
        private val jobManager: JobManager,
        private val jobInstanceManager: JobInstanceManager,
        private val triggerManager: TriggerManager,
        id: Identifier,
        val name: String,
        val command: String,
        val workingDir: File?,
        val isEnabled: Boolean,
        val envVars: Map<String, String>,
        val timeout: Long,
        updatedAt: Timestamp): Entity(id, updatedAt=updatedAt) {

    fun enable(): Job {
        jobManager.enable(id)
        return copy(isEnabled=true)
    }

    fun disable(): Job {
        jobManager.disable(id)
        return copy(isEnabled=false)
    }

    fun setName(name: String): Job {
        val job = copy(name=name)
        jobManager.update(job)
        return job
    }

    fun setCommand(cmd: String): Job {
        val job = copy(command=cmd)
        jobManager.update(job)
        return job
    }

    fun setWorkingDir(dir: File): Job {
        val job = copy(workingDir=dir)
        jobManager.update(job)
        return job
    }

    fun setTimeout(timeout: Long): Job {
        val job = copy(timeout=timeout)
        jobManager.update(job)
        return job
    }

    fun setEnvironVars(envVars: Map<String, String>): Job {
        val job = copy(envVars=envVars)
        jobManager.update(job)
        return job
    }

    override fun delete(): Unit {
        jobManager.delete(id)
    }

    fun launch(): JobInstance {
        return jobManager.launch(id)
    }

    fun instances(limit: Int): List<JobInstance> {
        return jobInstanceManager.list(id, limit)
    }

    fun triggers(): List<Trigger> {
        return triggerManager.list(id)
    }

    fun update(name: String = this.name,
               command: String = this.command,
               workingDir: File? = this.workingDir,
               envVars: Map<String, String> = this.envVars,
               timeout: Long = this.timeout): Job {
        val job =  copy(name=name, command=command, workingDir=workingDir, envVars=envVars, timeout=timeout)
        jobManager.update(job)
        return job
    }

    private fun copy(name: String = this.name,
                     command: String = this.command,
                     workingDir: File? = this.workingDir,
                     isEnabled: Boolean = this.isEnabled,
                     envVars: Map<String, String> = this.envVars,
                     timeout: Long = this.timeout): Job {
        return Job(jobManager, jobInstanceManager, triggerManager, id, name, command, workingDir, isEnabled, envVars,
                timeout, Helper.now())
    }




}