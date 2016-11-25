package org.sonatype.maven.polyglot.kotlin.model

data class Repository(
        val releases: RepositoryPolicy? = null,
        val snapshots: RepositoryPolicy? = null,
        val id: String? = null,
        val name: String? = null,
        val url: String? = null,
        val layout: String = "default"
)
