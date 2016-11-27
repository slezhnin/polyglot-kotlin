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

class BuildBuilder {
    private var build = Build()
    fun getBuild() = build

    fun sourceDirectory(value: String) {
        build = build.copy(sourceDirectory = value)
    }

    fun scriptSourceDirectory(value: String) {
        build = build.copy(scriptSourceDirectory = value)
    }

    fun testSourceDirectory(value: String) {
        build = build.copy(testSourceDirectory = value)
    }

    fun outputDirectory(value: String) {
        build = build.copy(outputDirectory = value)
    }

    fun testOutputDirectory(value: String) {
        build = build.copy(testOutputDirectory = value)
    }

    fun extensions(init: ExtensionsBuilder.() -> Unit) {
        val builder = ExtensionsBuilder()
        builder.init()
        build = build.copy(extensions = builder.getExtensions())
    }

    fun plugins(init: PluginsBuilder.() -> Unit) {
        val builder = PluginsBuilder()
        builder.init()
        build = build.copy(plugins = builder.getPlugins())
    }
}
