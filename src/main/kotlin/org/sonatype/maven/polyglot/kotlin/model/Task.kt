package org.sonatype.maven.polyglot.kotlin.model

import org.sonatype.maven.polyglot.execute.ExecuteContext

data class Task(val id: String, val phase: String, val profileId: String? = null, val block: (ExecuteContext) -> Unit)
