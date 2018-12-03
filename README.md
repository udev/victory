[![](https://jitpack.io/v/udev/victory.svg)](https://jitpack.io/#udev/victory)

# Victory!

Victory! is a light-weight [semantic versioning](https://semver.org) comparison library written in Java.

# Features

  - partial and missing version string support
  - (EXPERIMENTAL) unicode support "一.二.三"
  - (HIGLY EXPERIMENTAL) emoji support "🐶.💩.🤮"

##### You can also:
  - request new features!

# Why Use Semantic Versioning? [(source)](https://semver.org/#why-use-semantic-versioning)
> This is not a new or revolutionary idea. In fact, you probably do something close to this already. The problem is that “close” isn’t good enough. Without compliance to some sort of formal specification, version numbers are essentially useless for dependency management. By giving a name and clear definition to the above ideas, it becomes easy to communicate your intentions to the users of your software. Once these intentions are clear, flexible (but not too flexible) dependency specifications can finally be made.
>
> A simple example will demonstrate how Semantic Versioning can make dependency hell a thing of the past. Consider a library called “Firetruck.” It requires a Semantically Versioned package named “Ladder.” At the time that Firetruck is created, Ladder is at version 3.1.0. Since Firetruck uses some functionality that was first introduced in 3.1.0, you can safely specify the Ladder dependency as greater than or equal to 3.1.0 but less than 4.0.0. Now, when Ladder version 3.1.1 and 3.2.0 become available, you can release them to your package management system and know that they will be compatible with existing dependent software.
>
> As a responsible developer you will, of course, want to verify that any package upgrades function as advertised. The real world is a messy place; there’s nothing we can do about that but be vigilant. What you can do is let Semantic Versioning provide you with a sane way to release and upgrade packages without having to roll new versions of dependent packages, saving you time and hassle.
>
> If all of this sounds desirable, all you need to do to start using Semantic Versioning is to declare that you are doing so and then follow the rules. Link to this website from your README so others know the rules and can benefit from them.

### Tech

Victory! is built using the following tools:

* [Intellij IDEA]   - ENJOY PRODUCTIVE JAVA
* [JUnit5]          - The new major version of the programmer-friendly testing framework for Java
* [jitpack]         - Easy to use package repository for Git
* [dillinger]       - an online cloud-enabled, HTML5, buzzword-filled Markdown editor. ()Thank you for the excellent markdown example!)

### Installation

Add [jitpack] to your gradle project:
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```
Include Victory!
```groovy
dependencies {
    implementation 'com.github.udev:victory:0.1.0'
}
```

### Development

Feel free to create issues and submit pull requests as you see fit! Victory! is community supported!

### Todos

 - Write MORE Tests
 - Publish artifacts
 - Make nightly builds

License
----

MIT


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [Intellij IDEA]: <https://www.jetbrains.com/idea/>
   [JUnit5]: <https://junit.org/junit5/>
   [jitpack]: <https://jitpack.io>    
   [dillinger]: <https://github.com/joemccann/dillinger>
