# git-spring-websiteskeleton

NOTE: This is a work in progress. To be added: junit tests, some form of integration tests, jackson+json endpoints,
some java patterns (builders, dao separation, private function separate, etc), gradle cleanup, jstl.

--

A website skeleton written with JDK1.8, Spring 4.0 (without spring boot), multi-component Gradle, and JSPs.

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
1. Navigate to `http://localhost:8080/core/foo`

## Running tests

1. Unit tests: `gradle` (which will clean, test, build) or simply `gradle :test` (which will just run tests
1. Integration tests:
    1. Install ruby 2.1.2 (see [guide here](https://www.ruby-lang.org/en/documentation/installation/))
    1. Install bundler (see [guide here](http://bundler.io/))
    1. Install gems: `cd integration_tests && bundle install`
    1. Run tests: `cd integration_tests && rspec`