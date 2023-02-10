package io.api.customers.services;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Object;
import java.util.List;
import java.util.Random;

import static io.api.customers.services.GetRequests.response;
import static io.restassured.RestAssured.given;

public class PostRequests {
    Random random = new Random();
    RandomStringUtils ranStr = new RandomStringUtils();
    HashMap<String, Object> bodyMap = new HashMap();
    List<HashMap<String, String>> addressLst = new ArrayList<>();
    HashMap<String, String> addressMap = new HashMap<>();
    public void generateBodyMap(){
        bodyMap.put("firstname", ranStr.randomAlphabetic(10).toUpperCase());
        bodyMap.put("lastname",ranStr.randomAlphabetic(5).toUpperCase());
        bodyMap.put("profession",ranStr.randomAlphabetic(8).toUpperCase());

        addressMap.put("houseno", (String.valueOf(random.nextInt(3))));
        addressMap.put("street",ranStr.randomAlphabetic(6).toUpperCase());
        addressMap.put("city",ranStr.randomAlphabetic(7).toUpperCase());
        addressMap.put("country", ranStr.randomAlphabetic(9).toUpperCase());

        addressLst.add(addressMap);
        bodyMap.put("address",addressLst);
        System.out.println(bodyMap);
    }

    public Response postCustomerRequest(String endPoint){
        response = given()
            .header("Content-Type","application/json")
            .body(bodyMap)
        .when()
            .post(endPoint)
        .then()
            .extract().response();
        System.out.println(response.getBody().asString());
        return response;
    }


}
