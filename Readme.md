# Cross Platform Framework

* This framework can be used for API Automation as well for Web Automation
* Core of this framework is cucumber BDD and spring boot
* Supported browsers (chrome,edge,firefox)
* Supported parallel execution

### System Requirements
* JDK 8
* Maven

##### Prerequisites for running automation suites
* Web application server is up and running
* if application server is not running go to project folder spring-petclinic and run "mvnw spring-boot:run"
* Unzip shared automation solution
* Import project as maven project to intellij/eclipse

### Usage

Runs the tests with given application file
 mvn clean test -Dcucumber.filter.tags=@TagName -Dweb.browser=edge

    1-@TagName could be anything added to feature file
    2-All test cases and corresponding scenarios are added to feature file
    3-feature folder path - src/test/resources/features

### To Run Web Automation test locally, run below shared command through CLI

#### To Run on Chrome browser
    mvn clean test -Dcucumber.filter.tags=@WebAutomation

#### To Run on Edge browser
    mvn clean test -Dcucumber.filter.tags=@WebAutomation-Dweb.browser=edge

#### To Run on Firefox browser
    mvn clean test -Dcucumber.filter.tags=@WebAutomation-Dweb.browser=firefox