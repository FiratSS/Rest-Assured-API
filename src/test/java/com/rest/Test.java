package com.rest;

import util.ConfigLoader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Test {

    @org.testng.annotations.Test
    public void test() {
        given().
                baseUri("https://api.postman.com").
<<<<<<< HEAD
                header("x-api-key", APIKEY).
=======
                header("x-api-key", ConfigLoader.getProperty("api.key")).
>>>>>>> 0c43664 (Base Pojo updates and Removing API Key)

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
