package com.devapi.currencycloud.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static String generateToken(){
        //method for creating authorization token
        Response response = given()
                .header("Content-Type:", "multipart/form-data")
                .formParam("login_id", ConfigurationReader.get("login_id"))
                .and().formParam("api_key",ConfigurationReader.get("api_key") )
                .when().post(ConfigurationReader.get("uri") + "/v2/authenticate/api");

        String token = response.path("auth_token");
        System.out.println(token);
        return token;
    }
}
