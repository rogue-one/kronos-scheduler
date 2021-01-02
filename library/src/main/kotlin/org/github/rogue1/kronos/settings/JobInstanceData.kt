package org.github.rogue1.kronos.settings

/**
 *
 */
data class JobInstanceData(val instance: JobInstance,
                           val stdout: String?,
                           val stderr: String?)