package api.requests;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private Request request;

    public RequestBuilder() {
        this.request = new Request();
    }

    public class Request {

        private String baseURI;
        private String basePath;
        private ContentType contentType;
        private String body;
        private Map<String,?> parameters = new HashMap<>();
        private Map<String,String> headers = new HashMap<>();

        private Request() {
        }

        @Override
        public String toString() {
            return "Request{" +
                    "baseURI='" + baseURI + '\'' +
                    ", basePath='" + basePath + '\'' +
                    ", contentType=" + contentType +
                    ", body='" + body + '\'' +
                    ", parameters=" + parameters +
                    ", headers=" + headers +
                    '}';
        }

        public void setBaseURI(String baseURI) {
            this.baseURI = baseURI;
        }

        public void setBasePath(String basePath) {
            this.basePath = basePath;
        }

        public void setContentType(ContentType contentType) {
            this.contentType = contentType;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public void setParameters(Map<String, ?> parameters) {
            this.parameters = parameters;
        }

        public void setHeaders(Map<String, String> headers) {
            this.headers = headers;
        }

        public String getBaseURI() {
            return baseURI;
        }

        public String getBasePath() {
            return basePath;
        }

        public ContentType getContentType() {
            return contentType;
        }

        public String getBody() {
            return body;
        }

        public Map<String, ?> getParameters() {
            return parameters;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }
    }

    public RequestBuilder withBaseURI(String baseURI) {
        request.setBaseURI(baseURI);
        return this;
    }

    public RequestBuilder withBasePath(String basePath) {
        request.setBasePath(basePath);
        return this;
    }

    public RequestBuilder withContentType(ContentType contentType) {
        request.setContentType(contentType);
        return this;
    }

    public RequestBuilder withBody(String body) {
        request.setBody(body);
        return this;
    }

    public RequestBuilder withParameters(Map<String, ?> parameters) {
        request.setParameters(parameters);
        return this;
    }

    public RequestBuilder withHeaders(Map<String, String> headers) {
        request.setHeaders(headers);
        return this;
    }

    public Request build() {
        return request;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request=" + request +
                '}';
    }
}
