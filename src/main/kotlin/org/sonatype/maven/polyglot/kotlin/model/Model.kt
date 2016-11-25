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
