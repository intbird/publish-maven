package intbird.soft.gradle

class PublishConfig {
    Boolean snapshot = true

    String groupId = ""
    String artifactId = ""
    String version = ""

    String pomName = ""
    String pomDescription = ""
    String pomUrl = ""

    String repoSnapshot = "http://intbird.world:8081/nexus/content/repositories/snapshots/"
    String repoRelease = "http://intbird.world:8081/nexus/content/repositories/releases/"
    String repoName = "repo_user"
    String repoPassword = "repo_password"
}
