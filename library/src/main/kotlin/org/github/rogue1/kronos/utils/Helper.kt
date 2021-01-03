package org.github.rogue1.kronos.utils

import java.sql.Timestamp

object Helper {

    /**
     * generate a random UUID
     */
    fun uuid(): String {
        return java.util.UUID.randomUUID()!!.toString()
    }


    fun now(): Timestamp {
        return Timestamp(java.util.Date().time)
    }

}