package org.sonatype.maven.polyglot.kotlin.model

data class Dependency(
        val gav: Gav,
        val type: String = "jar",
        val classifier: String? = null,
        val scope: String? = null,
        val systemPath: String? = null,
        val exclusions: Sequence<GroupArtifactId> = emptySequence(),
        val optional: Boolean = false
    ) {
    infix fun type(value: String): Dependency = copy(type = value)
    infix fun classifier(value: String): Dependency = copy(classifier = value)
    infix fun scope(value: String): Dependency = copy(scope = value)
    infix fun optional(value: Boolean): Dependency = copy(optional = value)
}