package org.sonatype.maven.polyglot.kotlin.model

data class PluginManagement(val plugins: Sequence<Plugin> = emptySequence())
