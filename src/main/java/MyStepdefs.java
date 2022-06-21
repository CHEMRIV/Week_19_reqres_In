import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import in.reqres.reqresinfo.UsersSteps;
import in.reqres.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class MyStepdefs {
    static ValidatableResponse response;
    static String name = "Automation" + TestUtils.getRandomValue();
    static String job = "Tester" + TestUtils.getRandomValue();
    static String email = "eve.holt@reqres.in";
    static String password = "cityslicka";
    static String userID;
    static String token;
    @Steps
    UsersSteps usersSteps;

    @When("^User sends a GET request to list endpoint$")
    public void userSendsAGETRequestToListEndpoint() {
        response=usersSteps.getAllDataInfo();

    }

    @Then("^User should get back a valid status code 200$")
    public void userShouldGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^User sends a POST request to create reqres application endpoint$")
    public void userSendsAPOSTRequestToCreateReqresApplicationEndpoint() {
        response = usersSteps.createUser(name, job);
        userID = response.log().all().extract().path("id");
        System.out.println(userID);
    }

    @Then("^User must get back a validable status code 201$")
    public void userMustGetBackAValidableStatusCode() {
        response.log().all().statusCode(201);
    }

    @When("^User sends a GET request to get id endpoint$")
    public void userSendsAGETRequestToGetIdEndpoint() {
        HashMap<String, ?> userMap = usersSteps.getProductInfoByName(userID);
        //Assert.assertThat(userMap, hasValue(name));
        System.out.println(userID);

    }

    @Then("^User successfully added id in reqres application and status code is 200$")
    public void userSuccessfullyAddedIdInReqresApplicationAndStatusCodeIs() {
        response.statusCode(200);
    }

    @When("^User sends a PUT request to update id endpoint$")
    public void userSendsAPUTRequestToUpdateIdEndpoint() {
        name = name + "_updatedbyPut";
         response = usersSteps.updateUserByPut(userID, name, job);
        response.log().all().statusCode(200);
    }

    @Then("^User should update single data in reqres application successfully with status code 200$")
    public void userShouldUpdateSingleDataInReqresApplicationSuccessfullyWithStatusCode() {
        response.statusCode(200);
    }


    @When("^User sends a PATCH request to update id endpoint$")
    public void userSendsAPATCHRequestToUpdateIdEndpoint() {
        name = name + "_updatedbyPatch";
        response = usersSteps.updateUserByPatch(userID, name, job);

    }
    @Then("^User should partial update single data in reqres application successfully with status code 201$")
    public void userShouldPartialUpdateSingleDataInReqresApplicationSuccessfullyWithStatusCode() {
        response.statusCode(201);
    }
}
