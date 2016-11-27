package org.sonatype.maven.polyglot.kotlin.model

import org.junit.Test

class ModelTest {
    @Test
    fun printModel() {
        println("Hello" % "World" % "1.0.0")
        println(
                pom("testkt" % "testkt" % "1.0-SNAPSHOT") {
                    modelVersion("4.0.0")
                    name("testkt")
                    dependencies {
                        +("org.jetbrains.kotlin" % "kotlin-stdlib" % "\${kotlin.version}")
                        +dependency("org.jetbrains.kotlin" % "kotlin-test-junit" % "\${kotlin.version}") {
                            scope("test")
                        }
                        +dependency("junit" % "junit" % "\${junit.version}") { scope("test") }
                        +dependency("io.takari.polyglot" % "polyglot-common" % "0.1.19")
                        // Library for POM model import and validation
                        +dependency("io.takari.polyglot" % "polyglot-scala" % "0.1.19") {
                            scope("provided")
                            exclusions {
                                -("TestGroup1" % "TestArtifact1")
                                exclusion("TestGroup2" % "TestArtifact2")
                            }
                            optional(true)
                        }
                    }
                    properties {
                        "project.build.sourceEncoding" of "UTF-8"
                        "kotlin.version" of "1.0.5-2"
                        "junit.version" %= "4.12"
                    }
                    build {
                        sourceDirectory("src/main/kotlin")
                        testSourceDirectory("src/test/kotlin")
                        plugins {
                            plugin("org.jetbrains.kotlin" % "kotlin-maven-plugin" % "\${kotlin.version}") {
                                executions {
                                    execution {
                                        id("compile")
                                        phase("compile")
                                        goals {
                                            +"compile"
                                        }
                                    }
                                    execution {
                                        id("test-compile")
                                        phase("test-compile")
                                        goals {
                                            +"test-compile"
                                        }
                                    }
                                }
                            }
                        }
                        extensions {
                            +("io.takari.polyglot" % "polyglot-scala" % "0.1.19")
                        }
                    }
                }
        )
    }
}