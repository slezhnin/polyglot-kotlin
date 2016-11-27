package org.sonatype.maven.polyglot.kotlin.model

data class Extension(val gav: Gav)

class ExtensionsBuilder {
    private val extensions = mutableListOf<Extension>()
    fun getExtensions() = sequenceOf(*extensions.toTypedArray())

    operator fun Gav.unaryPlus() {
        extensions.add(Extension(this))
    }

    fun extension(gav: Gav) {
        extensions.add(Extension(gav))
    }
}
