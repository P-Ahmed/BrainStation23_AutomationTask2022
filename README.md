# BrainStation23_AutomationTask2022
This is an Automation Task provided by Brain Station 23 for the purpose of hiring process.

## Technology:
- Tool: selenium Webdriver
- IDE: IntelIJ IDEA
- Build tool: Gradle
- Language: Java
- Test runner: TestNG

## Prerequisite:
1. Need to install jdk 11, gradle and allure
2. Configure Environment variable for jdk 11, gradle and allure
3. Need good internet connectivity
4. Clone this project and unzip it
5. Open the project folder
6. Double click on "build.gradle" and open it through IntellIJ IDEA
7. Let the project build successfully
8. Click on "Terminal" and run the automation scripts

## Run the automation script:
1. Type the command:

```sh
gradle clean test
```
2. Selenium will open the browser and start automation
3. To view report, type this command one after another:
```sh
allure generate allure-results --clean -o allure-report
allure serve allure-results
```
![Snag_273bb034](https://user-images.githubusercontent.com/28926103/154532628-0b173248-1952-4613-b4a6-1a3b22c54b01.png)
![Snag_273be667](https://user-images.githubusercontent.com/28926103/154532678-68702a6b-c6dc-42a7-be4d-0790154eb891.png)
