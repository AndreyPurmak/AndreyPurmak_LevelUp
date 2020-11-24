package API;

import API.EndpointsObject.Posts.PostBodyObject;
import DataProviders.PostsEndpointDataProvider;
import org.testng.annotations.Test;

import static API.Endpoints.EndpointPrefix.IdPOSTS;
import static API.Endpoints.EndpointPrefix.POSTS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostsAPITests extends BaseTest {

    @Test
    public void getSomePostsTest() {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().get(POSTS)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "postPostsDataProvider", dataProviderClass = PostsEndpointDataProvider.class)
    public void postUsersTest(String title, String body, long userId) {
        PostBodyObject post = new PostBodyObject(title, body, userId);
        ResponseObject response = given()
                .spec(requestSpecification).body(post)
                .when().post(POSTS)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(201))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "getPostsDataProvider", dataProviderClass = PostsEndpointDataProvider.class)
    public void getUsersTest(String id) {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().get(IdPOSTS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "putPostsDataProvider", dataProviderClass = PostsEndpointDataProvider.class)
    public void putUsersTest(String title, String body, long userId, long id) {
        PostBodyObject post = new PostBodyObject(title, body, userId);
        ResponseObject response = given()
                .spec(requestSpecification).body(post)
                .when().put(IdPOSTS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(200))
                .body("meta", nullValue())
                .body("data", notNullValue())
                .extract().as(ResponseObject.class);
    }

    @Test(dataProvider = "deletePostsDataProvider", dataProviderClass = PostsEndpointDataProvider.class)
    public void deleteUsersTest(String id) {
        ResponseObject response = given()
                .spec(requestSpecification)
                .when().delete(IdPOSTS, id)
                .then().spec(responseSpecification)
                .statusCode(200)
                .body("code", equalTo(204))
                .body("meta", nullValue())
                .body("data", nullValue())
                .extract().as(ResponseObject.class);
    }
}