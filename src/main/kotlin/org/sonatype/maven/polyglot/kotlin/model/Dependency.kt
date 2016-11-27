package org.sonatype.maven.polyglot.kotlin.model

data class Dependency(
        val gav: Gav,
        val type: String = "jar",
        val classifier: String? = null,
        val scope: String? = null,
        val systemPath: String? = null,
        val exclusions: Sequence<GroupArtifactId> = emptySequence(),
        val optional: Boolean = false
)

class ExclusionsBuilder {
    val exclusions = mutableListOf<GroupArtifactId>()
    fun getExclusions() = sequenceOf(*exclusions.toTypedArray())

    operator fun GroupArtifactId.unaryMinus() {
        exclusions.add(this)
    }

    fun exclusion(gaId: GroupArtifactId) {
        exclusions.add(gaId)
    }
}

class DependencyBuilder(gav: Gav) {
    private var dependency = Dependency(gav)
    fun getDependency() = dependency

    fun type(value: String) {
        dependency = dependency.copy(type = value)
    }

    fun classifier(value: String) {
        dependency = dependency.copy(classifier = value)
    }

    fun scope(value: String) {
        dependency = dependency.copy(scope = value)
    }

    fun systemPath(value: String) {
        dependency = dependency.copy(systemPath = value)
    }

    fun exclusions(init: ExclusionsBuilder.() -> Unit) {
        val builder = ExclusionsBuilder()
        builder.init()
        dependency = dependency.copy(exclusions = builder.getExclusions())
    }

    fun optional(value: Boolean) {
        dependency = dependency.copy(optional = value)
    }
}

fun dependency(gav: Gav, init: DependencyBuilder.() -> Unit = {}): Dependency {
    val builder = DependencyBuilder(gav)
    builder.init()
    return builder.getDependency()
}

class DependenciesBuilder {
    private val dependencies = mutableListOf<Dependency>()
    fun getDependencies() = sequenceOf(*dependencies.toTypedArray())

    operator fun Gav.unaryPlus() {
        dependencies.add(Dependency(this))
    }

    operator fun Dependency.unaryPlus() {
        dependencies.add(this)
    }
}
