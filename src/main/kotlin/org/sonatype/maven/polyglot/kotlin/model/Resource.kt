package org.sonatype.maven.polyglot.kotlin.model

data class Resource(
        val targetPath: String? = null,
        val filtering: Boolean = false,
        val directory: String? = null,
        val includes: Sequence<String> = emptySequence(),
        val excludes: Sequence<String> = emptySequence()
)
