import files.payload;
import io.restassured.path.json.JsonPath;

public class JsonParseDummyResponse {

    public static void main(String[] args) {
        //mocked response
        JsonPath js = new JsonPath(payload.yearMultipliedByPopulation());
        int numberOfElementsInJsonArray = js.getInt("data.size()"); //size() used for arrays only, output expected is 8 as there are 8 items in array
        System.out.println("How many years were used in the database: " + numberOfElementsInJsonArray);

        System.out.println("current min Year " + findMinYearInJson(js, numberOfElementsInJsonArray));
    }

    private static int findMinYearInJson(JsonPath js, int numberOfYears) {
        int currentMinYear = js.getInt("data[0].Year");   //Parent.Child in Json
        for (int i = 0; i < numberOfYears; i++) {
            int nextYearValue = js.getInt("data[" + ++i + "].Year");
            if (currentMinYear > nextYearValue) {
                currentMinYear = nextYearValue;
            } else continue;
        }
        return currentMinYear;
    }
}