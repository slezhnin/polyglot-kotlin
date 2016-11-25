package org.sonatype.maven.polyglot.kotlin.model

data class Contributor(
        val email: String? = null,
        val name: String? = null,
        val organization: String? = null,
        val organizationUrl: String? = null,
        val roles: Sequence<String> = emptySequence(),
        val timezone: String? = null,
        val url: String? = null
)
