package in.reqres.reqresinfo;

import in.reqres.constants.EndPoints;
import in.reqres.model.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UsersSteps {
    @Step("Creating User with name : {0}, Job: {1}")
    public ValidatableResponse createUser(String name,
                                          String job) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post(EndPoints.GET_ALL_USERS)
                .then();
    }

    @Step("Getting All Users from Page 2")
    public ValidatableResponse getAllUserFromPageTwo() {
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("page",2)
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then();
    }

    @Step("Getting the User information with ID: {0}")
    public HashMap<String, ?> getProductInfoByName(String userID) {
        HashMap<String, ?> userMap = SerenityRest.given().log().all()
                .when()
                .pathParam("userID", userID)
                .get(EndPoints.GET_USER_BY_ID)
                .then()
                .statusCode(200)
                .extract().path("");

        return userMap;
    }

    @Step("Login User with email : {0}, password: {1}")
    public HashMap<String, ?> loginUser(String email,
                                        String password) {
        UserPojo userPojo = new UserPojo();
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(userPojo)
                .when()
                .post(EndPoints.USER_LOGIN)
                .then()
                .statusCode(200)
                .extract()
                .path("");
    }

    @Step("Update User with name : {0}, Job: {1}")
    public ValidatableResponse updateUserByPatch(String userID,
                                                 String name,
                                                 String job) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("userID", userID)
                .body(userPojo)
                .when()
                .patch(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Update User with name : {0}, Job: {1}")
    public ValidatableResponse updateUserByPut(String userID,
                                               String name,
                                               String job) {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("userID", userID)
                .body(userPojo)
                .when()
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Deleting user with ID {0}")
    public ValidatableResponse deleteProduct(String userID) {
        return SerenityRest.given().log().all()
                .pathParam("userID", userID)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }
    @Step("Getting all data{0}")
    public ValidatableResponse getAllDataInfo() {
        return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_ALL_USERS)
                .then();
    }
}
