package com.rest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Test {

    @org.testng.annotations.Test
    public void test() {
        given().
                baseUri("https://api.postman.com").
                header("x-api-key", "REMOVED").

        when().
                get("/workspaces").
        then().
                log().all()
                .assertThat()
                .statusCode(200)
                .body("workspaces[0].name", equalTo("My Workspace"),
                        "workspaces.name", hasItems("My Workspace", "My Workspace2"),
                        "workspaces.size", equalTo(2),
                        "workspaces.name", hasItem("My Workspace2"));
    }
}
