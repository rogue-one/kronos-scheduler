package org.github.rogue1.kronos.scheduler

import org.github.rogue1.kronos.entity.Identifier
import org.github.rogue1.kronos.entity.Parameter
import org.github.rogue1.kronos.scheduler.Workspace

abstract class ParameterManager(workspace: Workspace) {

    abstract fun list(): List<Parameter>

    abstract fun create(param: Parameter): Unit

    abstract fun delete(id: Identifier): Unit

}