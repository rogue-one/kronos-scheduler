package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.Scheduler

abstract class Entity(val id: Identifier,
                      protected val scheduler: Scheduler,
                      val isDeleted: Boolean)