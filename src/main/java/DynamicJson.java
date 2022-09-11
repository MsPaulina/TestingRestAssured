import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {
//POST METHOD
    @Test(dataProvider = "CountryData") //connection to data Provider
    public void addCountry() {
        RestAssured.baseURI = "https://datausa.io/api/data";
        //post method
        String responsePostMethod = given()
                .header("Content-Type", "application/json")
                .body(payload.AddCountryPostPayloadMethod("001PL","Poland"))
                .when()
                .post("Dataset/AddCountry.php")
                .then()
                .assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethods.rawToJson(responsePostMethod);
        //Result apart from 200 is message with the id of the operation, we are extracting that ID

        System.out.println((String) js.get("OperationID"));
    }

    @DataProvider(name = "CountryData")
    public Object[][] getData(){
        return new Object[][]{{"0100AUS", "Australia"},{"02022HUNG","Hungary"}};
    }

}
