package org.github.rogue1.kronos.settings

import java.sql.Timestamp

data class JobInstance(val id: InstanceId,
                       val jobId: String,
                       val hostName: String,
                       val procId: Int,
                       val startTimestamp: Timestamp,
                       var endTimestamp: Timestamp,
                       var exitCode: Int?,
                       var state: JobInstanceState)