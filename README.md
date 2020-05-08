Intbird Maven Publish
========
my csdn blog:[ https://blog.csdn.net/intbird ]( https://blog.csdn.net/intbird/article/details/105969242 ).

This repo is for publish aar lib for  [intbird repo](http://intbird.world:8081/nexus/content/repositories/releases/).
after you publish ,every one can who can implementation you lib ,used like this  `$group:$artifact:$version`
#### As agreed 

in this project $group = 'intbird.soft.gradle'
```
 aar:    $group = 'intbird.soft.lib'   
 plugin: $group = 'intbird.soft.gradle'
```

in this project $artifact = 'publish-maven'
```
$artifact = your lib project name or your publish config.artifact.  
```

in this project version = [version](CHANGELOG.md)

v1.0.0 =  v$first(big change).$second(add function).$three(bug fix)
```
$version = version
```

#### How to use it ? 

--------
#### 1 add maven url in root project `build.gradle` file
```
buildscript {
    ext {
        publish_version = '1.0.0'
    }
    repositories {
        maven { url "http://intbird.world:8081/nexus/content/repositories/public/" }
    }
    ...
}
```



#### 2 add classpath in root project `build.gradle` file ,
$lastVersion = 1.0.0 [click here to see more info](CHANGELOG.md)  

```
dependencies {
    classpath "intbird.soft.gradle:publish-maven:1.0.0"
}
```


#### 3 add plugin in your lib project(you want to publish) `build.gradle` file
```
apply plugin: 'publish-maven'
```

#### 4 add plugin config in your lib project(you want to publish) `build.gradle` file
```
android {
   ...
}

publishConfig {
    groupId = 'intbird.soft.lib'
    artifactId = '$your-lib-name' // use '-' connect
    version = "1.0.0-SNAPSHOT"
        
    // if you want publish to your own repository, mdf the flow config
    repoSnapshot = "http://intbird.world:8081/nexus/content/repositories/snapshots/"
    repoRelease = "http://intbird.world:8081/nexus/content/repositories/releases/"
    repoName = "repo_user"
    repoPassword = "repo_password"
}
```

#### 5 use gradle sync ,then you can see `publish* tasks in you sidebar gradle`
open you lib project in terminal and execute gradle task 'publishReleasePublicationToMavenRepository'
```
./gradlew publishReleasePublicationToMavenRepository

```

Release
--------
see [change log](CHANGELOG.md) has release history.

```
dependencies {
    classpath "intbird.soft.gradle:publish-maven:$lastVersion"
}
```