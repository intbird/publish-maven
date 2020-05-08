package intbird.soft.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.component.SoftwareComponent
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPom
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin

class PublishMaven implements Plugin<Project> {

    def publishConfig = "publishConfig"

    @Override
    void apply(Project project) {
        def publishingConfig = project.extensions.create(publishConfig, PublishConfig)

        project.plugins.apply MavenPublishPlugin
        PublishingExtension publishing = project.extensions.getByType(PublishingExtension)

        project.afterEvaluate {
            for (SoftwareComponent components : project.components) {
                publishing.publications({ publications ->
                    publications.create(components.name, MavenPublication.class, { MavenPublication publication ->
                        publication.groupId = publishingConfig.groupId
                        publication.artifactId = publishingConfig.artifactId
                        publication.version = publishingConfig.version
                        publication.from(components)
                        publication.pom {
                            mavenPom -> configPom(mavenPom, publishingConfig)
                        }
                    })
                })
            }

            publishing.repositories { artifactRepositories ->
                artifactRepositories.maven { mavenArtifactRepository ->
                    mavenArtifactRepository.url = publishingConfig.snapshot ? publishingConfig.repoSnapshot : publishingConfig.repoRelease
                    mavenArtifactRepository.credentials {
                        credentials ->
                            credentials.username = publishingConfig.repoName
                            credentials.password = publishingConfig.repoPassword
                    }
                }
            }
        }
    }

    static void configPom(MavenPom mavenPom, PublishConfig config) {
        mavenPom.name = config.pomName
        mavenPom.description = config.pomDescription
        mavenPom.url = config.pomUrl
    }
}