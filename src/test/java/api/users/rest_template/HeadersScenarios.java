package api.users.rest_template;

import business_objects.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

public class HeadersScenarios {

    @Test
    public void testHeaders() {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity entity = restTemplate.getForEntity(URL, User[].class);
        HttpHeaders headers = entity.getHeaders();
        String contentTypeValue = headers.getContentType().toString();
        Assert.assertEquals(contentTypeValue, "application/json;charset=utf-8");
    }
}
