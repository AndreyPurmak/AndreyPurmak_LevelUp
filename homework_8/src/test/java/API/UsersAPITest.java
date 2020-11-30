package API;

import API.EndpointsObject.Users.PeopleBodyObject;
import DataProviders.UsersEndpointDataProvider;
import org.testng.annotations.Test;

import static API.Endpoints.EndpointPrefix.IdUSERS;
import static API.Endpoints.EndpointPrefix.USERS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UsersAPITest extends BaseTest {

    @Test
    public void getSomeUsersTest() {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().get(USERS)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "postUsersDataProvider", dataProviderClass = UsersEndpointDataProvider.class)
    public void postUsersTest(String name, String email, String gender, String status) {
        PeopleBodyObject user = new PeopleBodyObject(name, email, gender, status);
        ResponseObject response = given()
                .spec(requestSpecification).body(user)
                .when().post(USERS)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(201))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "getUserDataProvider", dataProviderClass = UsersEndpointDataProvider.class)
    public void getUsersTest(String id) {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().get(IdUSERS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "putUserDataProvider", dataProviderClass = UsersEndpointDataProvider.class)
    public void putUsersTest(String name, String email, String gender, String status, String id) {
        PeopleBodyObject user = new PeopleBodyObject(name, email, gender, status);
        ResponseObject response = given()
                .spec(requestSpecification).body(user)
                .when().put(IdUSERS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "deleteUserDataProvider", dataProviderClass = UsersEndpointDataProvider.class)
    public void deleteUsersTest(String id) {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().delete(IdUSERS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(204))
                .body("meta", nullValue())
                .body("data", nullValue())
                .extract().as(ResponseObject.class);
    }
}