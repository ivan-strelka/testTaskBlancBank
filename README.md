# Kotlin API testing automation framework

### Simple API test to https://test-api-market.herokuapp.com/swagger-ui/index.html#

An example of tests that can be implemented to test a REST API service that exposes a CRUD interface.

##### This project build with stack: `Kotlin + Rest-Assured + Junit5 + Hamcrest + Allure `

### Endpoints

Method `GET /public/v2/users` get an array of objects. We check the total number of users, the total number of pages,
limits.

Method `POST /public/v2/users` create a new user. After creating a new user, the system confirms that the input data and
output data match and sends the created object.

Method `GET /public/v2/users/:id`: get data of a specific user by id

Method `PUT|PATCH /public/v2/users/:id`: method to change user data. After the user edits the data, the system will
confirm that the input data and the output data are the same.

Method `DELETE /public/v2/users/:id` method deletes a user. We check the response code and response message after
deleting the data.

## Running the tests

1. Clone this repo `git clone git@github.com:ivan-strelka/kotlinApiTests.git`
2. Run command in terminal for change directory `cd kotlinApiTests`
3. Run command in terminal to run tests `gradle clean test --stacktrace --info`
4. Run command in terminal to download allure report `gradle downloadAllure`
5. Run command in terminal to create allure report for a last test run `gradle allureServe`
6. Enjoy test run results

### Some examples test run results in allure report:

![Allure](files/Screenshot_3.png)
![Allure](files/Screenshot_4.png)
![Allure](files/Screenshot_5.png)

