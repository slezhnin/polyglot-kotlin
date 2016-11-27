package org.sonatype.maven.polyglot.kotlin.model

data class Gav(val groupId: String, val artifactId: String, val version: String)

data class GroupArtifactId(val groupId: String, val artifactId: String) {
    operator fun mod(version: String) = Gav(groupId, artifactId, version)
}

operator fun String.mod(artifactId: String): GroupArtifactId = GroupArtifactId(this, artifactId)
