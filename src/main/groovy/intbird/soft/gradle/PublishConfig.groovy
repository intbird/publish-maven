package intbird.soft.gradle

class PublishConfig {
    Boolean snapshot = true

    String groupId = ""
    String artifactId = ""
    String version = ""

    String pomName = ""
    String pomDescription = ""
    String pomUrl = ""

    String repoSnapshot = "https://intbird.ml/maven/snapshots/"
    String repoRelease = "https://intbird.ml/maven/releases/"
    String repoName = "repo_user"
    String repoPassword = "repo_password"
}
