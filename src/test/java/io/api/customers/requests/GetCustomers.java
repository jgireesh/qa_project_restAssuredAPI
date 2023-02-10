package io.api.customers.requests;

import org.junit.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetCustomers {

    private String baseURI = "http://localhost:3000/";
    private String basePath="customers";
    @Test
    public void getApiRequest(){
        given()
                .contentType("application/json")
                .when().get(baseURI+basePath).then().statusCode(200)
                .body("firstname",equalTo("james")).log().all().extract().response();
    }

    @Test
    public void postApiRequest(){
        HashMap<Object, Object> bodymap = new HashMap<>();
        bodymap.put("id",6);
        bodymap.put("title","java");
        bodymap.put("author","john");
        bodymap.put("city","MK");

        given().body(bodymap).contentType("application/json")
                .when().post("http://localhost:3000/posts")
                .then().statusCode(201);

        System.out.println("check now post worked as expected");

        given().when().get("http://localhost:3000/posts/6").then().statusCode(200)
                .body("author",equalTo("john"))
                .body("id",equalTo(6))
                .body("title",equalTo("java"));
    }
}
