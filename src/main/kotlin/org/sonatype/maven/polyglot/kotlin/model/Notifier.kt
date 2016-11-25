package org.sonatype.maven.polyglot.kotlin.model

data class Notifier(
        val address: String? = null,
        val configuration: Map<String, String> = emptyMap(),
        val sendOnError: Boolean = true,
        val sendOnFailure: Boolean = true,
        val sendOnSuccess: Boolean = true,
        val sendOnWarning: Boolean = true,
        val type: String = "mail"
)
