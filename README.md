# git-spring-websiteskeleton

[![Build Status](https://travis-ci.org/jadekler/git-spring-websiteskeleton.svg)](https://travis-ci.org/jadekler/git-spring-websiteskeleton)

NOTE: This is a work in progress. To be added:

- Jackson & JSON example endpoints
- Some java patterns (builders, dao separation)
- JSTL

--

A website skeleton written with JDK1.8, Spring 4.0 (without spring boot), multi-component Gradle, JSPs, JUnit tests,
and rspec integration tests.

--

## Installation and running

1. `git clone https://github.com/jadekler/git-spring-websiteskeleton.git`. I'll assume you cloned this at
`~/workspace/git-spring-websiteskeleton`
1. `cd ~/workspace/git-spring-websiteskeleton`
1. `gradle`
1. Download [jetty](http://download.eclipse.org/jetty/stable-9/dist/) (or your server of choice). For this tutorial,
we'll assume you downloaded jetty at `~/workspace/jetty`
1. `cp ~/workspace/git-spring-websiteskeleton/applications/core/build/libs/applications/core.war ~/workspace/jetty/webapps/core.war`
1. `~/workspace/jetty/bin/jetty.sh start`
1. Navigate to `http://localhost:8080/core/`

## Running tests

1. Unit tests: `gradle` (which will clean, test, build) or simply `gradle :test` (which will just run tests
1. Integration tests:
    1. Install ruby 2.1.2 (see [guide here](https://www.ruby-lang.org/en/documentation/installation/))
    1. Install bundler (see [guide here](http://bundler.io/))
    1. Install gems: `cd integration_tests && bundle install`
    1. *Make sure the app is already running* (see instructions above on running). Integration tests are hardcoded to
    `http://localhost:8080/core` - change the relevant `.rb` files if it lives elsewhere
    1. Run tests: `cd integration_tests && rspec`

## Setting up CI (with jenkins, vagrant, chef)

1. Install chef-dk
1. Install vagrant
1. `vagrant plugin install vagrant-berkshelf`
1. `vagrant plugin install vagrant-omnibus`
1. `vagrant plugin install vagrant-vbguest` (possibly optional - install this if you see `Failed to mount folders in Linux guest.`)

## Additional notes

- Travis CI will only run unit tests. Integration tests require spinning up a server and running the app. This may
be a future addition to the repo
- The java chef downloads from oracle (sigh). If your connection is slow or spotty, it may fail on a curl command. Give it
a couple of shots (`vagrant provision` will do it) until the curl successfully completes