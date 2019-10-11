package utils;

public class HttpProtocolUtils {

    private static String httpPattern = "http://%s";
    private static String httpSecurePattern = "https://%s";

    public static String getHttpURI(String baseURI) {
        return String.format(httpPattern, baseURI);
    }

    public static String getHttpSecureURI(String baseURI) {
        return String.format(httpSecurePattern, baseURI);
    }
}
