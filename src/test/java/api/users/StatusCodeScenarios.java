package api.users;

import api.BaseTest;
import api.data_providers.UsersRequests;
import api.requests.RequestBuilder;
import api.responses.ResponseInstance;
import api.service.ApiUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StatusCodeScenarios extends BaseTest {

    @Test(dataProvider = "UsersRequest", dataProviderClass = UsersRequests.class)
    public void testStatusCode(RequestBuilder.Request request) {
        ResponseInstance responseInstance = ApiUtils.executeGetRequest(request);
        Assert.assertEquals(responseInstance.getStatusCode(), STATUS_CODE_200);
    }

}
