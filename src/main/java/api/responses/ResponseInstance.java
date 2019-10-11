package api.responses;

import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.util.List;

public class ResponseInstance {

    private Response response;

    public ResponseInstance(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getContentType() {
        return response.getContentType();
    }

    public String getHeader(String header) {
        return response.getHeader(header);
    }

    public List<Header> getHeader() {
        return response.getHeaders().asList();
    }

    public String getSessionId() {
        return response.getSessionId();
    }

    public String getStatusLine() {
        return response.getStatusLine();
    }

    public ResponseBody getResponseBody() {
        return response.getBody();
    }

    public <T> T getBodyContent(TypeRef<T> typeRef) {
        return getResponseBody().as(typeRef);
    }


}
