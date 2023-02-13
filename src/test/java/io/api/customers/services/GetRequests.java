package io.api.customers.services;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Optional;

import static io.restassured.RestAssured.given;

public class GetRequests {
    public static Response response;

    /**
     * @param endPoint
     * @return Response body of Get request
     * @author Gireesh
     */
    public Response getRequest(String endPoint){
        response = given().contentType("application/json")
                .when()
                .get(endPoint)
                .then().extract().response();
        System.out.println(response.getBody().asString());
        return response;
    }


    /**
     * Asserts status code is expected
     * @param statusCode
     * @author Gireesh
     */
    public void verifyStatusCode(Integer statusCode){
        Assert.assertTrue(statusCode==response.statusCode());
    }

    public void verifyResponseBodyHas(String fieldName, String value){
        Assert.assertTrue(response.jsonPath().get(fieldName).toString().contains(value));
    }
}
