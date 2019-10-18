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

public class HeadersScenarios extends BaseTest {

    @Test(dataProvider = "UsersRequest_HeaderTest", dataProviderClass = UsersRequests.class)
    public void testHeader(RequestBuilder.Request request, String headerName, String headerValue) {
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        String contentTypeHeader = responseInstance.getHeader(headerName);
        Assert.assertEquals(contentTypeHeader, headerValue, "Assert Content Type Header");
    }

    @Test
    public void testHeader() {
        String headerName = "Content-Type";
        String expectedHeaderValue = "application/json; charset=utf-8";
        RestAssured.baseURI = HttpProtocolUtils.getHttpSecureURI("jsonplaceholder.typicode.com");
        Response response = RestAssured.given()
                .get("/users")
                .andReturn();
        String contentTypeValue = response.getHeader(headerName);
        Assert.assertEquals(contentTypeValue, expectedHeaderValue, "Assert Content Type Header");

        RestAssured.given()
                .get("/users")
                .andReturn()
                .getHeader(headerName)
                .equals(expectedHeaderValue);
    }
}
