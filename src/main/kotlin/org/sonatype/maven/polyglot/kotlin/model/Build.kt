package org.sonatype.maven.polyglot.kotlin.model

data class Build(
        val sourceDirectory: String? = null,
        val scriptSourceDirectory: String? = null,
        val testSourceDirectory: String? = null,
        val outputDirectory: String? = null,
        val testOutputDirectory: String? = null,
        val extensions: Sequence<Extension> = emptySequence(),
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
