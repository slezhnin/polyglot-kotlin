package org.sonatype.maven.polyglot.kotlin.model

import java.io.File

data class Model(
        val gav: Gav,
        val build: Build? = null,
        val ciManagement: CiManagement? = null,
        val contributors: Sequence<Contributor> = emptySequence(),
        val dependencyManagement: DependencyManagement? = null,
        val dependencies: Sequence<Dependency> = emptySequence(),
        val description: String? = null,
        val developers: Sequence<Developer> = emptySequence(),
        val distributionManagement: DistributionManagement? = null,
        val inceptionYear: String? = null,
        val issueManagement: IssueManagement? = null,
        val licenses: Sequence<License> = emptySequence(),
        val mailingLists: Sequence<MailingList> = emptySequence(),
        val modelEncoding: String = "UTF-8",
        val modelVersion: String? = null,
        val modules: Sequence<String> = emptySequence(),
        val name: String? = null,
        val organization: Organization? = null,
        val packaging: String = "jar",
        val parent: Parent? = null,
        val pluginRepositories: Sequence<Repository> = emptySequence(),
        val pomFile: File? = null,
        val prerequisites: Prerequisites? = null,
        val profiles: Sequence<Profile> = emptySequence(),
        val properties: Map<String, String> = emptyMap(),
        val repositories: Sequence<Repository> = emptySequence(),
        val scm: Scm? = null,
        val url: String? = null
)

class MapBuilder {
    private val map = mutableMapOf<String, String>()
    fun getMap() = mapOf(*map.toList().toTypedArray())

    operator fun String.modAssign(v: String) {
        map[this] = v
    }

    infix fun String.of(v: String) {
        map[this] = v
    }
}

class ModelBuilder(gav: Gav) {
    private var model = Model(gav)
    fun getModel() = model

    fun build(init: BuildBuilder.() -> Unit) {
        val builder = BuildBuilder()
        builder.init()
        model = model.copy(build = builder.getBuild())
    }

    fun modelVersion(value: String) {
        model = model.copy(modelVersion = value)
    }

    fun name(value: String) {
        model = model.copy(name = value)
    }

    fun dependencies(init: DependenciesBuilder.() -> Unit) {
        val builder = DependenciesBuilder()
        builder.init()
        model = model.copy(dependencies = builder.getDependencies())
    }

    fun properties(init: MapBuilder.() -> Unit) {
        val builder = MapBuilder()
        builder.init()
        model = model.copy(properties = builder.getMap())
    }
}

fun pom(gav: Gav, init: ModelBuilder.() -> Unit): Model {
    val modelBuilder = ModelBuilder(gav)
    modelBuilder.init()
    return modelBuilder.getModel()
}
