package org.sonatype.maven.polyglot.kotlin.model

data class RepositoryPolicy(
        val enabled: Boolean,
        val updatePolicy: String = "daily",
        val checksumPolicy: String = "warn"
)
