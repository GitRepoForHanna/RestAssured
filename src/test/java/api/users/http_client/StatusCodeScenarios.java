package api.users.http_client;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

import java.io.IOException;

public class StatusCodeScenarios {

    @Test
    public void testStatusCode() throws IOException {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        HttpResponse response;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        response = client.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(statusCode, 200, "Assert that status code is 200");
    }
}
