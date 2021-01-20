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
