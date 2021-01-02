package org.github.rogue1.kronos.utils

import java.lang.RuntimeException

sealed class AppException(override val message: String): RuntimeException(message)

class InvalidConfigException(message: String): AppException(message)