package api.service;

import api.requests.RequestBuilder;
import api.responses.ResponseInstance;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiUtils {

    private static RequestSpecification getRequestSpecification(RequestBuilder.Request request) {
        RequestSpecification specification = new RequestSpecBuilder().build();
        String baseURI = request.getBaseURI();
        String basePath = request.getBasePath();
        ContentType contentType = request.getContentType();
        String body = request.getBody();
        Map<String, String> headers = request.getHeaders();
        Map<String, ?> parameters = request.getParameters();

        if(null != baseURI) {
            specification.baseUri(baseURI);
        }
        if(null != basePath) {
            specification.basePath(basePath);
        }
        if(null != contentType) {
            specification.contentType(contentType);
        }
        if(null != body) {
            specification.body(body);
        }
        if(null != headers) {
            specification.headers(headers);
        }
        if(null != parameters) {
            specification.params(parameters);
        }
        return specification;
    }

    public static ResponseInstance executeRequest(RequestBuilder.Request request, Method method) {
        RequestSpecification specification = getRequestSpecification(request);
        return new ResponseInstance(RestAssured.given(specification).request(method));
    }

    public static ResponseInstance executeGetRequest(RequestBuilder.Request request) {
        return executeRequest(request, Method.GET);
    }

    public static ResponseInstance executePostRequest(RequestBuilder.Request request) {
        return executeRequest(request, Method.POST);
    }

    public static ResponseInstance executePutRequest(RequestBuilder.Request request) {
        return executeRequest(request, Method.PUT);
    }

    public static ResponseInstance executeDeleteRequest(RequestBuilder.Request request) {
        return executeRequest(request, Method.DELETE);
    }
}
