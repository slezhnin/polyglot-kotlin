package org.sonatype.maven.polyglot.kotlin.model

import org.junit.Test

class ModelTest {
    @Test
    fun printModel() {
        println("Hello" id "World" ver "1.0.0")
        println(
                Model(
                        "testkt" id "testkt" ver "1.0-SNAPSHOT",
                        modelVersion = "4.0.0",
                        name = "testkt",
                        dependencies = sequenceOf(
                                Dependency("org.jetbrains.kotlin" id "kotlin-stdlib" ver "\${kotlin.version}"),
                                Dependency("org.jetbrains.kotlin" id "kotlin-test-junit" ver "\${kotlin.version}", scope = "test"),
                                Dependency("junit" id "junit" ver "\${junit.version}", scope = "test"),
                                Dependency("io.takari.polyglot" id "polyglot-common" ver "0.1.19"),
                                // Library for POM model import and validation
                                Dependency("io.takari.polyglot" id "polyglot-scala" ver "0.1.19", scope = "provided", optional = true)
                        ),
                        properties = mapOf(
                                "project.build.sourceEncoding" to "UTF-8",
                                "kotlin.version" to "1.0.5-2",
                                "junit.version" to "4.12"
                        ),
                        build = Build(
                                sourceDirectory = "src/main/kotlin",
                                testSourceDirectory = "src/test/kotlin",
                                plugins = sequenceOf(
                                        Plugin(
                                                "org.jetbrains.kotlin" id "kotlin-maven-plugin" ver "\${kotlin.version}",
                                                executions = sequenceOf(
                                                        Execution(
                                                                id = "compile",
                                                                phase = "compile",
                                                                goals = sequenceOf(
                                                                        "compile"
                                                                )
                                                        ),
                                                        Execution(
                                                                id = "test-compile",
                                                                phase = "test-compile",
                                                                goals = sequenceOf(
                                                                        "test-compile"
                                                                )
                                                        )
                                                )
                                        )
                                ),
                                extensions = sequenceOf(
                                        Extension("io.takari.polyglot" id "polyglot-scala" ver "0.1.19")
                                )
                        )
                )
        )
    }
}