package org.sonatype.maven.polyglot.kotlin.model

data class Scm(
        val connection: String? = null,
        val developerConnection: String? = null,
        val tag: String = "HEAD",
        val url: String? = null
)
