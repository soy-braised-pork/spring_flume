package com.zlx.flume;

import java.util.Arrays;
import java.util.List;
import com.zlx.flume.apirest.model.FlumSendRequest;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;


public class FlumControllerTest {

    private static final String BASE_API_PATH = "/v1/flume";
    private static final String CLEAR_API_PATH = BASE_API_PATH + "/clear";
    private static final String SEND_API_PATH = BASE_API_PATH + "/send";
    private static final String REIEVE_API_PATH = BASE_API_PATH + "/retrieve";

    private static final String APPLICATION_JSON_VALUE="application/json";

    @SuppressWarnings("unchecked")
    @Test
    public void testSend1() throws InterruptedException{

        List<String> expected= Arrays.asList("A","B","C");
        FlumSendRequest request=new FlumSendRequest();
        request.setHost("localhost");
        request.setPort(4141);
        request.setMessage(expected);

        Response response1=RestAssured.given()
                .contentType(APPLICATION_JSON_VALUE)
                .request(Method.POST,SEND_API_PATH);
    }


}
