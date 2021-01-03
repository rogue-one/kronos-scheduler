package org.github.rogue1.kronos.entity

import org.github.rogue1.kronos.scheduler.Scheduler


class Parameter(id: Identifier,
                scheduler: Scheduler,
                val key: String,
                val value: String,
                isDeleted: Boolean): Entity(id, scheduler, isDeleted)