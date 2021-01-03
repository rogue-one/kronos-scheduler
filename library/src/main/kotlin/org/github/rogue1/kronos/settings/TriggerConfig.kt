package org.github.rogue1.kronos.settings

/**
 * trigger config
 */
data class TriggerConfig(val name: String,
                         val jobName: String,
                         val cron: String,
                         val desc: String?,
                         val parameters: List<Parameter>)