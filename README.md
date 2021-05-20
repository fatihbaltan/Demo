Maven based Java project for testing API framework with RestAssured, Cucumber with Java.

Setup
•	Dependencies added to pom.xml
•	File and folder structure created. Runner, step definitions and utilities package added.
•	"configuration.properties" file contains the base url, login_id and api_key. Any change could be updated here.
•	Configuration reader class is added to read configuration properties
•	"ApiUtils" class  added for reusable static methods.

Framework makes use of RestAssured API for performing webservice operation and Cucumber framework for achieving BDD approach. So reusable steps could be made. Parameterized steps used to achieve reusable for other currencies. 

Another  advantage of using BDD is everyone in the team can understand and participate testing process.

Tests in feature file contains tags (@wip and more can be added like @Smoke, @Regression). CukesRunner class can be used to run the tests. Failed class runner could be added to the runner package to rerun the failed classes after adding necessary settings. Set of test with similar feature tags can be run using the maven command "mvn test verify -Dcucumber.options="--tags @wip" and also can be added  to Jenkins pipeline.

For assertions Junit Assert class is used

Unfortunately I could not run the test cases due to some errors on the environment.


