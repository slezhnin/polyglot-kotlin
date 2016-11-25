package org.sonatype.maven.polyglot.kotlin.model

data class DependencyManagement(val dependencies: Sequence<Dependency> = emptySequence())
