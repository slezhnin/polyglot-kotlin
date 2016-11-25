package org.sonatype.maven.polyglot.kotlin.model

data class Relocation(
        val groupId: String? = null,
        val artifactId: String? = null,
        val version: String? = null,
        val message: String? = null
)
