package org.sonatype.maven.polyglot.kotlin.model

data class Profile(
        val id: String = "default",
        val activation: Activation? = null,
        val build: BuildBase? = null,
        val dependencyManagement: DependencyManagement? = null,
        val dependencies: Sequence<Dependency> = emptySequence(),
        val distributionManagement: DistributionManagement? = null,
        val modules: Sequence<String> = emptySequence(),
        val pluginRepositories: Sequence<Repository> = emptySequence(),
        val repositories: Sequence<Repository> = emptySequence()
)
