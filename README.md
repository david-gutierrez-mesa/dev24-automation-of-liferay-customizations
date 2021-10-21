# Liferay Test Automation
## Description
This git project is a selenium example for test automation of Liferay instances.

## How to run automation?

### Run with default browser (Chrome) against localhost:8080
We just need to run "cucumber" task with Gradle in the root project folder:

```
./gradlew :cleanTest :test
```

Or execute test runner java file RunTests.java from your ID.

### Run against not local instances
By default, tests are executed against localhost with http protocol and using port 8080.

If you want to run against another instance you have access to can use the flag -Durl=protocol://url:port/. You must specify the three of them: protocol + url + port.

For example, to run against 192.168.40.58 with protocol http and port 7300, just use:

```
./gradlew :cleanTest :test -Durl=http://192.168.40.58:7300/
```

### Run with other browsers
Default browser is Chrome. To run in another browser, we need to have it installed in our OS and use -Dbrowser=browserName flag.

For example, to run with FireFox, just use:

```
./gradlew :cleanTest :test -Dbrowser=firefox
```

### Run for continuous integration environments
IF we want to ru our tests in a continuous integration environment we can add the  flag -Dci=true. This will run browsers headless. If we don't set it, or we set any other value than true, test are executed in normal mode. 

Use example:

```
./gradlew :cleanTest :test -Dci=true
```

## Test results
After test execution, a basic HTML report is automatically generated in ./target/ folder.

## How to test this code as it is now?
1) Install docker https://docs.docker.com/get-docker/
2) Increase your Memory in docker to at least 6.00 GB (settings-> Resources -> Advanced -> Memory) 
3) Run 
> docker run --name my-local-liferay-test --rm -p 9080:8080 dgutimesa/my-test:v4
4) Run test in a console
> ./gradlew :cleanTest :test -Durl=http://localhost:9080/

## Contact
If you have any further question, just email me to david.gutierrez@liferay.com