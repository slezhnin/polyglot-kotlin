package org.sonatype.maven.polyglot.kotlin.model

data class Parent(
        val gav: Gav? = null,
        val relativePath: String = "../pom.xml"
)
