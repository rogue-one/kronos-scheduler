package org.github.rogue1.kronos.settings

data class JobConfig(val name: String,
                     val cmd: String,
                     val cwd: String?,
                     val isEnabled: String,
                     val envVars: Map<String, String>,
                     val timeout: Long)