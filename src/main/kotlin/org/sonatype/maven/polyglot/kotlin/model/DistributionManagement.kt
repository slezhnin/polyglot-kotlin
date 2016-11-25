package org.sonatype.maven.polyglot.kotlin.model

data class DistributionManagement(
        val repository: DeploymentRepository? = null,
        val snapshotRepository: DeploymentRepository? = null,
        val site: Site? = null,
        val downloadUrl: String? = null,
        val relocation: Relocation? = null,
        val status: String? = null
)
