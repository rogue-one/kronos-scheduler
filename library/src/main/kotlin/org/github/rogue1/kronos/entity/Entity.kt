package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.utils.Helper
import java.sql.Timestamp

abstract class Entity(val id: Identifier,
                      val createdAt: Timestamp = Helper.now(),
                      val updatedAt: Timestamp = Helper.now()) {

    abstract fun delete(): Unit

}