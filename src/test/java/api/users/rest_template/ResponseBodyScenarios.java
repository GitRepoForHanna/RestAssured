package api.users.rest_template;

import business_objects.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

public class ResponseBodyScenarios {

    @Test
    public void testResponseBody() {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity entity = restTemplate.getForEntity(URL, User[].class);
        User[] users = (User[]) entity.getBody();
        Assert.assertEquals(users.length, 10);
    }
}
