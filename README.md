# git-spring-websiteskeleton

[![Build Status](https://travis-ci.org/jadekler/git-java-websiteskeleton.svg?branch=master)](https://travis-ci.org/jadekler/git-java-websiteskeleton)

--

A website skeleton written with JDK1.8, Spring 4.0 (without spring boot), multi-component Gradle, JSPs, JUnit tests,
and FluentLenium+Rest-Assured acceptance tests.

--

## Installation and running

1. [Download and install JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. `git clone https://github.com/jadekler/git-spring-websiteskeleton.git`. I'll assume you cloned this at
`~/workspace/git-spring-websiteskeleton`
1. `cd ~/workspace/git-spring-websiteskeleton`
1. `./gradlew`
1. Download [jetty](http://download.eclipse.org/jetty/stable-9/dist/) (or your server of choice). For this tutorial,
we'll assume you downloaded jetty at `~/workspace/jetty`
1. `cp ~/workspace/git-spring-websiteskeleton/applications/core/build/libs/applications/core.war ~/workspace/jetty/webapps/core.war`
1. `~/workspace/jetty/bin/jetty.sh start`
1. Navigate to `http://localhost:8080/core/`

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

## Additional notes

- Travis CI will only run unit tests. Integration tests require spinning up a server and running the app. This is in the works
- The java chef downloads from oracle (sigh). If your connection is slow or spotty, it may fail on a curl command. Give it
a couple of shots (`vagrant provision` will do it) until the curl successfully completes
