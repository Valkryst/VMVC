[![MIT License](https://img.shields.io/badge/license-MIT_License-green.svg)](https://github.com/Valkryst/VMVC/blob/master/LICENSE.md) ![](https://travis-ci.org/Valkryst/VMVC.svg?branch=master) [![codecov](https://codecov.io/gh/Valkryst/VMVC/branch/master/graph/badge.svg)](https://codecov.io/gh/Valkryst/VMVC) [![Release](https://jitpack.io/v/Valkryst/VMVC.svg)](https://jitpack.io/#Valkryst/VMVC)

## Links

* [JavaDoc Documentation](https://valkryst.github.io/VMVC/)


## Jar Files & Maven

The Maven dependency is hosted off of JitPack, so you will need to add JitPack as a repository before you add VMVC as a dependency.

### Maven

JitPack ([Example](https://github.com/Valkryst/VMVC/blob/master/pom.xml)):

    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>

Dependency:

    <dependency>
        <groupId>com.github.Valkryst</groupId>
        <artifactId>VMVC</artifactId>
        <version>0.9.6</version>
    </dependency>

### Jar

Jar files can be found on the [releases](https://github.com/Valkryst/VMVC/releases) page.

## Credits & Inspiration

* Architecture
    * Robert Eckstein's ["Java SE Application Design With MVC"](https://www.oracle.com/technical-resources/articles/javase/application-design-with-mvc.html).
    * Juri Strumpflohner's ["Logical separation with MVC"](https://juristr.com/blog/2008/03/logical-separation-with-mvc/), a follow-up to Eckstein's article.
* [Filthy Rich Clients: Developing Animated and Graphical Effects for Desktop Java™ Applications](https://www.amazon.ca/Filthy-Rich-Clients-Developing-Applications/dp/0132413930/)