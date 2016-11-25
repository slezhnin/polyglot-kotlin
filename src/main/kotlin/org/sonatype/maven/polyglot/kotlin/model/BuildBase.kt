package org.sonatype.maven.polyglot.kotlin.model

data class BuildBase(
        val defaultGoal: String? = null,
        val resources: Sequence<Resource> = emptySequence(),
        val testResources: Sequence<Resource> = emptySequence(),
        val directory: String? = null,
        val finalName: String? = null,
        val filters: Sequence<String> = emptySequence(),
        val pluginManagement: PluginManagement? = null,
        val plugins: Sequence<Plugin> = emptySequence(),
        val tasks: Sequence<Task> = emptySequence()
)
