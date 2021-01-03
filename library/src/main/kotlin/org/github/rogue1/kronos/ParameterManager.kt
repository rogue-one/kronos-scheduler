package org.github.rogue1.kronos

import org.github.rogue1.kronos.settings.Parameter
import org.github.rogue1.kronos.settings.Workspace

abstract class ParameterManager(workspace: Workspace) {

    abstract fun list(): List<Parameter>

    abstract fun create(param: Parameter): Unit

}