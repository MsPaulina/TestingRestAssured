import files.payload;
import io.restassured.path.json.JsonPath;

public class JsonParseDummyResponse {

    public static void main(String[] args) {
        //mocked response
        JsonPath js = new JsonPath(payload.yearMultipliedByPopulation());
        int numberOfYears = js.getInt("data.size()"); //size() used for arrays only, output expected is 8 as there are 8 items in array
        System.out.println("How many years were used in the database: " + numberOfYears);
    }

}
