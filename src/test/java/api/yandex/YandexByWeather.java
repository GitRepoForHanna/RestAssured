package api.yandex;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Test;
import utils.HttpProtocolUtils;

public class YandexByWeather {

    @Test
    public void testGetRequest() {
        RestAssured.baseURI = HttpProtocolUtils.getHttpSecureURI("yandex.by");

        Response response = RestAssured.given()
                .get("/pogoda/minsk/details?via=ms#16")
                .then()
                .assertThat()
                .statusCode(HttpStatus.OK.value())
                .and()
                .extract().response();

        Document document = Jsoup.parseBodyFragment(response.getBody().print());
        Element body = document.body();
        Element forecastBlockHeader = body.getElementById("forecast-day16");
        String classForecastBlock = forecastBlockHeader.className();
        Element forecastBlockBody = body.select(String.format(".%s-info", classForecastBlock)).first();
        Element dayPart = forecastBlockBody.select(".weather-table__body>tr").get(1);
        Element tempBlock = dayPart.select("div.weather-table__temp").first();
        String temperature = tempBlock.text();
        System.out.println("Temp -> " + temperature);
    }
}
