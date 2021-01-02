package org.github.rogue1.kronos.settings

import org.github.rogue1.kronos.utils.InvalidConfigException

/**
 * DB connection configuration
 */
data class DBConnectionConfig(val dbType: DBType,
                              val hostName: String,
                              val userName: String,
                              val password: String,
                              val port: Int?,
                              val schema: String?,
                              val extras: Map<String, String> = mapOf()) {


    class Builder(private val dbType: DBType) {

        private var hostName: String? = null
        private var userName: String? = null
        private var password: String? = null
        private var port: Int? = null
        private var schema: String? = null
        private var extras: MutableMap<String, String> = mutableMapOf()

        /**
         * set host name
         */
        fun withHostName(hostName: String): Builder {
            this.hostName = hostName
            return this
        }

        /**
         * set user name
         */
        fun withUserName(userName: String): Builder {
            this.userName = userName
            return this
        }

        /**
         * set password
         */
        fun withPassword(password: String): Builder {
            this.password = password
            return this
        }

        /**
         * set port
         */
        fun withPort(port: Int): Builder {
            this.port = port
            return this
        }

        /**
         * set schema
         */
        fun withSchema(schema: String): Builder {
            this.schema = schema
            return this
        }

        /**
         * set extras
         */
        fun withExtras(extras: Map<String, String>): Builder {
            this.extras = extras.toMutableMap()
            return this
        }

        /**
         * append a single extra item
         */
        fun withExtra(key: String, value: String): Builder {
            this.extras[key] = value
            return this
        }

        /**
         * build [DBConnectionConfig] object
         */
        fun build(): DBConnectionConfig = when {
            hostName.isNullOrEmpty() -> throw InvalidConfigException("hostname field is required to build DBConnectionConfig")
            userName.isNullOrEmpty() -> throw InvalidConfigException("username field is required to build DBConnectionConfig")
            password.isNullOrEmpty() -> throw InvalidConfigException("password field is required to build DBConnectionConfig")
            else -> DBConnectionConfig(dbType, hostName!!, userName!!, password!!, port, schema, extras.toMap())
        }

    }

}



