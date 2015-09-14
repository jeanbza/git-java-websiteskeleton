# git-spring-websiteskeleton

[![Build Status](https://travis-ci.org/jadekler/git-java-websiteskeleton.svg?branch=master)](https://travis-ci.org/jadekler/git-java-websiteskeleton)

--

A website skeleton written with JDK1.8, Spring 4.0 (without spring boot), multi-component Gradle, JSPs, JUnit tests,
and FluentLenium+Rest-Assured acceptance tests running in a headless browser (no browser spun up to run acceptance tests).

--

# Table of Contents

- [Installation and running](#installation-and-running)
- [Deploying your app to a jetty / tomcat server](#deploying-your-app-to-a-jetty--tomcat-server)
- [Running tests](#running-tests)
- [Setting up Jenkins CI (with vagrant, virtualbox, chef)](#setting-up-jenkins-ci-with-vagrant-virtualbox-chef)
- [Code Examples](#code-examples)
    - [Loading properties from a .yml file](#loading-properties-from-a-yml-file)
    - [Browser testing using a headless browser](#browser-testing-using-a-headless-browser)
    - [Acceptance testing REST API](#acceptance-testing-rest-api)
    - [Acceptance tests using a mocked server](#acceptance-tests-using-a-mocked-server)
    - [Running app with embedded tomcat server at different log levels](#running-app-with-embedded-tomcat-server-at-different-log-levels)
- [Additional notes](#additional-notes)

## Installation and running

1. [Download and install JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. `git clone https://github.com/jadekler/git-spring-websiteskeleton.git`. I'll assume you cloned this at
`~/workspace/git-spring-websiteskeleton`
1. `cd ~/workspace/git-spring-websiteskeleton`
1. `./gradlew tomcatRunWar`
1. Navigate to `http://localhost:8080`

## Deploying your app to a jetty / tomcat server

1. `./gradlew clean assemble`
1. Copy / reference `applications/core/build/libs/applications/core.war`, NOT `build/libs/websiteskeleton-1.0.war`

NOTE: The `applications/core` master component is where all components with `components` get compiled into one final
application - note the project compiles happening at `applications/core/build.gradle`.

## Running tests

1. [Install PhantomJS](http://phantomjs.org/download.html) (for headless browser testing)
    1. Download the [phantomjs binary](https://github.com/eugene1g/phantomjs/releases/tag/2.0.0-bin)
    1. `cp -r ~/Downloads/phantomjs ~/dev/` (or wherever you prefer)
    1. `echo "export PATH:$PATH:~/dev/phantomjs" >> ~/.bash_profile"`
    1. Ensure `which phantomjs` works

    OR

    1. Download the [phantomjs binary](https://github.com/eugene1g/phantomjs/releases/tag/2.0.0-bin)
    1. Alter `components/users/src/test/java/acceptance/fluentlenium/UsersTest.java` and directly point to your binary with
     `capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/path/to/phantomjs");`
1. Unit tests: either `./gradlew` (clean compile test), or specifically `./gradlew unitTest`
1. Acceptance tests: `./gradlew acceptanceTest -Dspring.profiles.active=test`
    - Note: you may need to install Firefox for Selenium to run
1. All the tests: `./gradlew clean assemble unitTest acceptanceTest -Dspring.profiles.active=test`

## Setting up Jenkins CI (with vagrant, virtualbox, chef)

1. [Install chef-dk](https://downloads.chef.io/chef-dk/)
1. [Install vagrant](http://www.vagrantup.com/downloads.html)
1. [Install virtualbox](https://www.virtualbox.org/wiki/Downloads)
    - Note: if you get an error about `vboxsf`, [download Virtualbox 4.3.20 here](https://www.virtualbox.org/wiki/Download_Old_Builds_4_3)
1. `vagrant plugin install vagrant-berkshelf`
1. `vagrant plugin install vagrant-omnibus`
1. `vagrant plugin install vagrant-vbguest` (possibly optional - install this if you see `Failed to mount folders in Linux guest.`)
1. `cd ~/workspace/git-spring-websiteskeleton/jenkins_ci && vagrant up --provision`

## Code Examples

##### Loading properties from a .yml file

See:

- `applications/core/src/main/java/com/websiteskeleton/core/YamlConfiguration.java`
- `applications/core/src/main/resources/application.yml`
- `applications/core/src/main/resources/application-test.yml`

##### Browser testing using a headless browser

See: `components/users/src/test/java/acceptance/restassured/UsersTest`

##### Acceptance testing REST API

See: `components/products/src/test/java/acceptance/restassured/ProductsTest`

##### Acceptance tests using a mocked server

See: `components/products/src/test/java/acceptance/restassured/ProductsTest`

##### Running app with embedded tomcat server at different log levels

See: `applications/src/main/java/resources/example-logback.xml` (rename to `logback.xml` and you're set)

## Additional notes

- The java chef downloads from oracle (sigh). If your connection is slow or spotty, it may fail on a curl command. Give it
a couple of shots (`vagrant provision` will do it) until the curl successfully completes
