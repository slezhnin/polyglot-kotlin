package org.sonatype.maven.polyglot.kotlin.model

data class Plugin(
        val gav: Gav,
        val extensions: Boolean = false,
        val executions: Sequence<Execution> = emptySequence(),
        val dependencies: Sequence<Dependency> = emptySequence(),
        val inherited: Boolean = true,
        val configuration: Config? = null
)
