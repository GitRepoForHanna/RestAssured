package api.users.rest_assured;

import api.BaseTest;
import api.data_providers.UsersRequests;
import api.requests.RequestBuilder;
import api.responses.ResponseInstance;
import api.service.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;

public class StatusCodeScenarios extends BaseTest {

    @Test(dataProvider = "UsersRequest", dataProviderClass = UsersRequests.class)
    public void testStatusCode(RequestBuilder.Request request) {
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        Assert.assertEquals(responseInstance.getStatusCode(), STATUS_CODE_200);
    }

    @Test
    public void testStatusCode() {
        RestAssured.baseURI = HttpProtocolUtils.getHttpSecureURI("jsonplaceholder.typicode.com");
        Response response = RestAssured.when()
                            .get("/users")
                            .andReturn();
        Assert.assertEquals(response.getStatusCode(), STATUS_CODE_200);
    }

}
