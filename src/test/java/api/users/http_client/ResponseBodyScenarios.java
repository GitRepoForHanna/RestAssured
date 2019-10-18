package api.users.http_client;

import business_objects.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ResponseBodyScenarios {

    @Test
    public void testResponseBodyJackson() throws IOException {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
//        List<User> users = objectMapper.readValue(entity.getContent(), new TypeReference<List<User>>() {});
//        Assert.assertEquals(users.size(), 10);
        User[] users = objectMapper.readValue(entity.getContent(), User[].class);
        Assert.assertEquals(users.length, 10);
    }

    @Test
    public void testUserJackson() throws IOException {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<User> users = objectMapper.readValue(entity.getContent(), new TypeReference<List<User>>() {});
        User user = users.stream()
                     .filter(userItem -> userItem.getId() == 6)
                     .findAny()
                     .get();
        Assert.assertEquals(user.getCompany().getName(), "Considine-Lockman");
    }

    @Test
    public void testResponseBodyGson() throws IOException {
        String baseUrl = ResourcesUtils.getPropertyValue("usersRequestConfiguration", ResourcesUtils.BASE_URI_PROPERTY);
        String URL = HttpProtocolUtils.getHttpURI(baseUrl).concat("/users");
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL);
        HttpResponse response = client.execute(httpGet);
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        User[] users = gson.fromJson(br,User[].class);
        Assert.assertEquals(users.length, 10);
//        Type type = new TypeToken<List<User>>(){}.getType();
//        List<User> usersList = gson.fromJson(br, type);
//        Assert.assertEquals(usersList.size(), 10);
    }
}
