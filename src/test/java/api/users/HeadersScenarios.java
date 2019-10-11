package api.users;

import api.BaseTest;
import api.data_providers.UsersRequests;
import api.requests.RequestBuilder;
import api.responses.ResponseInstance;
import api.service.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeadersScenarios extends BaseTest {

    @Test(dataProvider = "UsersRequest_HeaderTest", dataProviderClass = UsersRequests.class)
    public void testHeader(RequestBuilder.Request request, String headerName, String headerValue) {
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        String contentTypeHeader = responseInstance.getHeader(headerName);
        Assert.assertEquals(contentTypeHeader, headerValue, "");
    }
}
