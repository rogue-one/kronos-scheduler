package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.ParameterManager
import org.github.rogue1.kronos.scheduler.TriggerManager
import org.github.rogue1.kronos.utils.Helper
import java.sql.Timestamp

/**
 * trigger config
 */
@Suppress("MemberVisibilityCanBePrivate")
class Trigger private constructor(private val triggerManager: TriggerManager,
                                  private val parameterManager: ParameterManager,
                                  id: Identifier,
                                  val name: String,
                                  private val jobId: Identifier,
                                  val active: Boolean,
                                  val cron: String,
                                  val desc: String?,
                                  val parameters: List<Parameter>,
                                  updatedAt: Timestamp) : Entity(id, updatedAt) {

    fun instances(limit: Int): List<JobInstance> {
        return triggerManager.instances(id, limit)
    }

    fun disable(): Trigger {
        triggerManager.disable(id)
        return copy(active=false)
    }

    fun enable(): Trigger {
        triggerManager.enable(id)
        return copy(active=true)
    }

    fun setCron(cron: String): Trigger {
        val tgr = copy(cron=cron)
        triggerManager.update(tgr)
        return tgr
    }

    fun setDesc(desc: String): Trigger {
        val tgr = copy(desc=desc)
        triggerManager.update(tgr)
        return tgr
    }

    private fun copy(name: String = this.name,
                     active: Boolean = this.active,
                     cron: String = this.cron,
                     desc: String? = this.desc,
                     parameters: List<Parameter> = this.parameters): Trigger {
        return Trigger(triggerManager, id, name, jobId, active, cron, desc, parameters, Helper.now())
    }

    override fun delete(): Unit {
        triggerManager.delete(id)
    }

}