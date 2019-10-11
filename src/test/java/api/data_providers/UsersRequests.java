package api.data_providers;

import api.requests.RequestBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import utils.HttpProtocolUtils;
import utils.ResourcesUtils;

import static utils.ResourcesUtils.BASE_PATH_PROPERTY;


public class UsersRequests {
    static final String CONFIG_FILE_NAME = "usersRequestConfiguration";

    public UsersRequests() {
    }

    @DataProvider(name = "UsersRequest")
    public static Object[] getUsersRequest() {
        String baseUri = ResourcesUtils.getPropertyValue(CONFIG_FILE_NAME, ResourcesUtils.BASE_URI_PROPERTY);
        baseUri = HttpProtocolUtils.getHttpSecureURI(baseUri);
        String pathPropertyName = ResourcesUtils.getPropertyNameWithPrefix(BASE_PATH_PROPERTY, "users");
        String basePath = ResourcesUtils.getPropertyValue(CONFIG_FILE_NAME, pathPropertyName);

        return new RequestBuilder.Request[] {
                new RequestBuilder().withBaseURI(baseUri)
                .withBasePath(basePath)
                .withContentType(ContentType.JSON)
                .build()
        };
    }

    @DataProvider(name = "UsersRequest_HeaderTest")
    public static Object[][] getUserRequestAndHeadersData() {
        String baseUri = ResourcesUtils.getPropertyValue(CONFIG_FILE_NAME, ResourcesUtils.BASE_URI_PROPERTY);
        baseUri = HttpProtocolUtils.getHttpSecureURI(baseUri);
        String pathPropertyName = ResourcesUtils.getPropertyNameWithPrefix(BASE_PATH_PROPERTY, "users");
        String basePath = ResourcesUtils.getPropertyValue(CONFIG_FILE_NAME, pathPropertyName);

        return new Object[][] {
                {
                    new RequestBuilder().withBaseURI(baseUri)
                                .withBasePath(basePath)
                                .withContentType(ContentType.JSON)
                                .build(),
                        ResourcesUtils.getPropertyValue(CONFIG_FILE_NAME, "contentType"),
                        ResourcesUtils.getPropertyValue(CONFIG_FILE_NAME, "contentTypeValue")
                }
        };
    }
}
