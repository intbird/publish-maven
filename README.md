Publish to maven plugin
========

This is a gradle plugin, publish aar lib to maven repo.

1. website: [https://intbird.net/](https://intbird.net/)

2. maven:   [https://intbird.net/maven/](https://intbird.net/maven/)

3. coding:  [https://blog.csdn.net/intbird ](https://blog.csdn.net/intbird/article/details/105969242)


#### How to use it ? 


#### 1.add maven url in root project `build.gradle` file
```
buildscript {
    repositories {
        maven { url "https://intbird.net/maven/" }
    }
}
```



#### 2.add classpath in root project `build.gradle` file , 

```
dependencies {
    classpath "net.intbird.soft.gradle:publish-maven:$lastVersion"
}
```


#### 3.add plugin in your lib project which you want to publish `build.gradle` file
```
apply plugin: 'publish-maven'
```

#### 4.add plugin config in your lib project(you want to publish) `build.gradle` file
```
android {
   ...
}

publishConfig {
    groupId = '$package-name'
    artifactId = '$lib-name'
    version = "$version"
        
    // if you want publish to your own repository, mdf the flow config
    repoSnapshot = "https://intbird.net/maven/snapshots/"
    repoRelease = "https://intbird.net/maven/releases/"
    repoName = "repo_user"
    repoPassword = "repo_password"
}
```

#### 5.after sync,see `publish* tasks in you sidebar gradle`
![https://github.com/intbird/publish-maven/blob/master/pubshing.png](https://github.com/intbird/publish-maven/blob/master/pubshing.png)


```
./gradlew publishReleasePublicationToMavenRepository

```


Release
--------
see [change log](CHANGELOG.md) has release history.

```
dependencies {
    classpath "net.intbird.soft.gradle:publish-maven:$lastVersion"
}
```




# source apis:

mvnrepository:  
https://mvnrepository.com/artifact/org.gradle.api.plugins

## android
https://developer.android.com/reference/tools/gradle-api/7.3/com/android/build/api/dsl/LibraryPublishing
https://developer.android.com/reference/tools/gradle-api/7.1/com/android/build/api/dsl/PublishingOptions#summary
```
android {
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }

        multipleVariants {
            withSourcesJar()
            withJavadocJar()
            allVariants()
        }
    }
}
```


## java

https://docs.gradle.org/6.0/userguide/publishing_maven.html#publishing_maven:complete_example

https://docs.gradle.org/6.0/dsl/org.gradle.api.publish.maven.MavenPublication.html#org.gradle.api.publish.maven.MavenPublication:from(org.gradle.api.component.SoftwareComponent)


```
plugins {
    id 'java-library'
}

publishing {
        publications {
            release(MavenPublication) {
                // Applies the component for the release build variant.
                from components.release

                artifact java.withJavadocJar()
                artifact java.withSourcesJar()
            }
        }
}


DefaultJavaPluginExtension javaLibraryPlugin = project.extensions.getByType(DefaultJavaPluginExtension)
publication.artifact(javaLibraryPlugin.withJavadocJar())
publication.artifact(javaLibraryPlugin.withSourcesJar())
                    
```

