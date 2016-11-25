package org.sonatype.maven.polyglot.kotlin.model

data class Execution(
        val id: String = "default",
        val phase: String? = null,
        val goals: Sequence<String> = emptySequence(),
        val inherited: Boolean = true,
        val configuration: Config? = null
)
