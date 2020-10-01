# git-spring-websiteskeleton
# git-java-websiteskeleton

[![Build Status](https://travis-ci.org/jadekler/git-java-websiteskeleton.svg?branch=master)](https://travis-ci.org/jadekler/git-java-websiteskeleton)

--

A website skeleton written with JDK1.8, Spring 4.2 (spring-boot and spring-framework), multi-component Gradle, thymeleaf,
JUnit tests, and FluentLenium+Rest-Assured acceptance tests.

--

## Installation and running

1. `brew install node`
1. [Download and install JDK8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
1. `git clone https://github.com/jadekler/git-spring-websiteskeleton.git`. I'll assume you cloned this at
`~/workspace/git-spring-websiteskeleton`
1. `cd ~/workspace/git-spring-websiteskeleton`
1. `./gradlew bootRun`
1. Navigate to `http://localhost:8080`

NOTE: The `applications/core` master component is where all components with `components` get compiled into one final
application - note the project compiles happening at `applications/core/build.gradle`.

## Running tests

`./gradlew clean test`

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

- The java chef downloads from oracle (sigh). If your connection is slow or spotty, it may fail on a curl command. Give it
a couple of shots (`vagrant provision` will do it) until the curl successfully completes
