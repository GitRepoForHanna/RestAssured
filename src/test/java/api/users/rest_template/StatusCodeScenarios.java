package api.users.rest_template;

import business_objects.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

public class StatusCodeScenarios {

    @Test
    public void testStatusCode() {
        int expectedStatusCode = 200;
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity entity = restTemplate.getForEntity(URL, User[].class);
        int statusCode = entity.getStatusCodeValue();
        Assert.assertEquals(statusCode, expectedStatusCode);
    }
}
