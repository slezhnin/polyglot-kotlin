package org.sonatype.maven.polyglot.kotlin.model

data class Activation(
        val activeByDefault: Boolean = false,
        val jdk: String? = null,
        val os: ActivationOS? = null,
        val property: ActivationProperty? = null,
        val file: ActivationFile? = null
)
