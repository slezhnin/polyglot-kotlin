package org.sonatype.maven.polyglot.kotlin.model

data class Execution(
        val id: String = "default",
        val phase: String? = null,
        val goals: Sequence<String> = emptySequence(),
        val inherited: Boolean = true,
        val configuration: Config? = null
)

class StringSequenceBuilder {
    private val stringList = mutableListOf<String>()
    fun getStringSequence() = sequenceOf(*stringList.toTypedArray())

    operator fun String.unaryPlus() {
        stringList.add(this)
    }
}

class ExecutionBuilder {
    private var execution = Execution()
    fun getExecution() = execution

    fun id(value: String) {
        execution = execution.copy(id = value)
    }

    fun phase(value: String) {
        execution = execution.copy(phase = value)
    }

    fun goals(init: StringSequenceBuilder.() -> Unit) {
        val builder = StringSequenceBuilder()
        builder.init()
        execution = execution.copy(goals = builder.getStringSequence())
    }

    fun inherited(value: Boolean) {
        execution = execution.copy(inherited = value)
    }
}

class ExecutionsBuilder {
    private val executions = mutableListOf<Execution>()
    fun getExecutions() = sequenceOf(*executions.toTypedArray())

    fun execution(init: ExecutionBuilder.() -> Unit) {
        val builder = ExecutionBuilder()
        builder.init()
        executions.add(builder.getExecution())
    }
}
