package org.sonatype.maven.polyglot.kotlin.model

data class MailingList(
        val name: String? = null,
        val subscribe: String? = null,
        val unsubscribe: String? = null,
        val post: String? = null,
        val archive: String? = null,
        val otherArchives: Sequence<String> = emptySequence()
)
