package org.sonatype.maven.polyglot.kotlin.model

data class CiManagement(
        val notifiers: Sequence<Notifier> = emptySequence(),
        val system: String? = null,
        val url: String? = null
)
