package api.users.rest_assured;

import api.BaseTest;
import api.data_providers.UsersRequests;
import api.requests.RequestBuilder;
import api.responses.ResponseInstance;
import api.service.ApiUtils;
import business_objects.User;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;

import org.hamcrest.MatcherAssert;
import org.springframework.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;

public class ResponseBodyScenarios extends BaseTest {

    @Test(dataProvider = "UsersRequest", dataProviderClass = UsersRequests.class)
    public void testBodySize(RequestBuilder.Request request) {
        int expectedUsersCount = 10;
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        List<User> usersList = responseInstance.getResponseBody().peek().as(new TypeRef<List<User>>() {});
        Assert.assertEquals(usersList.size(), expectedUsersCount);
    }

    @Test
    public void testBodySize() {
        int expectedUsersCount = 10;
        RestAssured.baseURI = HttpProtocolUtils.getHttpSecureURI("jsonplaceholder.typicode.com");
        Response response = RestAssured.when()
                .get("/users")
                .then()
                .assertThat()
//                .log()
//                .ifError()
                .statusCode(200)
                .extract().response();

        List<User> usersList = response.as(new TypeRef<List<User>>() {});
        Assert.assertEquals(usersList.size(), expectedUsersCount);

        RestAssured.when()
                .get("/users")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .path("get(1).name")
                .equals("Ervin Howell");

        }

    @Test
    public void testUserName() {
        RestAssured.baseURI = HttpProtocolUtils.getHttpSecureURI("jsonplaceholder.typicode.com");

        RestAssured.when()
                .get("/users")
                .then()
                .statusCode(HttpStatus.OK.value())
                .extract()
                .path("get(1).name")
                .equals("Ervin Howell");

        RestAssured.when()
                .get("/users")
                .then()
                .extract()
                .path(String.format("get(%d).name",9))
                .equals("Clementina DuBuque");
    }

    @Test(dataProvider = "UsersRequest", dataProviderClass = UsersRequests.class)
    public void testContent(RequestBuilder.Request request) {
        String website = "conrad.com";
        String expectedName = "Glenna Reichert";
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        List<User> usersList = responseInstance.getBodyContent(new TypeRef<List<User>>() {});
        usersList.stream()
                .filter(user -> user.getWebsite().equals(website))
                .findAny()
                .map(User::getName)
                .equals(expectedName);
    }

    @Test(dataProvider = "UsersRequest", dataProviderClass = UsersRequests.class)
    public void testBodySizeGSon(RequestBuilder.Request request) {
        int expectedUsersCount = 10;
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        User[] users = new Gson().fromJson(responseInstance.getResponseBody().prettyPrint(), User[].class);
        Assert.assertEquals(users.length, expectedUsersCount);
    }
}
