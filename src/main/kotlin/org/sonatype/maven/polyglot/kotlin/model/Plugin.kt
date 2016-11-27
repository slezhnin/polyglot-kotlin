package org.sonatype.maven.polyglot.kotlin.model

data class Plugin(
        val gav: Gav,
        val extensions: Boolean = false,
        val executions: Sequence<Execution> = emptySequence(),
        val dependencies: Sequence<Dependency> = emptySequence(),
        val inherited: Boolean = true,
        val configuration: Config? = null
)

class PluginBuilder(gav: Gav) {
    private var plugin = Plugin(gav)
    fun getPlugin() = plugin

    fun extensions(value: Boolean) {
        plugin = plugin.copy(extensions = value)
    }

    fun executions(init: ExecutionsBuilder.() -> Unit) {
        val builder = ExecutionsBuilder()
        builder.init()
        plugin = plugin.copy(executions = builder.getExecutions())
    }

    fun dependencies(init: DependenciesBuilder.() -> Unit) {
        val builder = DependenciesBuilder()
        builder.init()
        plugin = plugin.copy(dependencies = builder.getDependencies())
    }

    fun inherited(value: Boolean) {
        plugin = plugin.copy(inherited = value)
    }
}

class PluginsBuilder {
    private val plugins = mutableListOf<Plugin>()
    fun getPlugins() = sequenceOf(*plugins.toTypedArray())

    fun plugin(gav: Gav, init: PluginBuilder.() -> Unit = {}) {
        val builder = PluginBuilder(gav)
        builder.init()
        plugins.add(builder.getPlugin())
    }
}
