package api.users.http_client;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

import java.io.IOException;
import java.util.Arrays;

public class HeaderScenarios {

    @Test
    public void testHeader() throws IOException {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = client.execute(httpGet);
        Header[] headers = response.getAllHeaders();
        String contentTypeValue = Arrays.stream(headers)
                .filter(h -> h.getName().equals("Content-Type"))
                .findAny()
        .get().getValue();
        System.out.println("Content Type -> " + contentTypeValue);
        Assert.assertEquals(contentTypeValue, "application/json; charset=utf-8");
    }
}
