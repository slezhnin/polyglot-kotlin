package org.sonatype.maven.polyglot.kotlin.model

data class Gav(val groupId: String, val artifactId: String, val version: String)

data class GroupArtifactId(val groupId: String, val artifactId: String) {
    infix fun ver(version: String) = Gav(groupId, artifactId, version)
}

infix fun String.id(artifactId: String): GroupArtifactId = GroupArtifactId(this, artifactId)