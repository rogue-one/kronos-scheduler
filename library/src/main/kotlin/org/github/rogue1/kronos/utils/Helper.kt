package org.github.rogue1.kronos.utils

object Helper {

    /**
     * generate a random UUID
     */
    fun uuid(): String {
        return java.util.UUID.randomUUID()!!.toString()
    }

}