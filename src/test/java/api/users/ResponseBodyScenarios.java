package api.users;

import api.BaseTest;
import api.data_providers.UsersRequests;
import api.requests.RequestBuilder;
import api.responses.ResponseInstance;
import api.service.ApiUtils;
import business_objects.User;
import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ResponseBodyScenarios extends BaseTest {

    @Test(dataProvider = "UsersRequest", dataProviderClass = UsersRequests.class)
    public void testBodySize(RequestBuilder.Request request) {
        int expectedUsersCount = 10;
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        List<User> usersList = responseInstance.getResponseBody().peek().as(new TypeRef<List<User>>() {});
        Assert.assertEquals(usersList.size(), expectedUsersCount);
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
}
