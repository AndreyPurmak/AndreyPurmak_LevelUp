package API;

import API.EndpointsObject.Comments.CommentsBodyObject;
import DataProviders.CommentsEndpointDataProvider;
import org.testng.annotations.Test;

import static API.Endpoints.EndpointPrefix.COMMENTS;
import static API.Endpoints.EndpointPrefix.IdCOMMENTS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class CommentsAPITests extends BaseTest {

    @Test
    public void getSomePostsTest() {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().get(COMMENTS)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "postCommentsDataProvider", dataProviderClass = CommentsEndpointDataProvider.class)
    public void postUsersTest(String name, String email, String body, long postId) {
        CommentsBodyObject post = new CommentsBodyObject(name, email, body, postId);
        ResponseObject response = given()
                .spec(requestSpecification).body(post)
                .when().post(COMMENTS)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(201))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "getCommentsDataProvider", dataProviderClass = CommentsEndpointDataProvider.class)
    public void getUsersTest(String id) {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().get(IdCOMMENTS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "putCommentsDataProvider", dataProviderClass = CommentsEndpointDataProvider.class)
    public void putUsersTest(String name, String email, String body, long postId, long id) {
        CommentsBodyObject post = new CommentsBodyObject(name, email, body, postId);
        ResponseObject response = given()
                .spec(requestSpecification).body(post)
                .when().put(IdCOMMENTS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "deleteCommentsDataProvider", dataProviderClass = CommentsEndpointDataProvider.class)
    public void deleteUsersTest(String id) {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().delete(IdCOMMENTS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(204))
                .body("meta", nullValue())
                .body("data", nullValue())
                .extract().as(ResponseObject.class);
    }
}