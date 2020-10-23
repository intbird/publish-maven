package net.intbird.soft.gradle

class PublishConfig {
    Boolean snapshot = true

    String groupId = ""
    String artifactId = ""
    String version = ""

    String pomName = ""
    String pomDescription = ""
    String pomUrl = ""

    String repoSnapshot = "https://intbird.net/maven/snapshots/"
    String repoRelease = "https://intbird.net/maven/releases/"
    String repoName = "repo_user"
    String repoPassword = "repo_password"
}
