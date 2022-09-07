import org.testng.annotations.Test;
import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
    @Test
    public void sumOfSomething() {
        JsonPath js = new JsonPath(payload.yearMultipliedByPopulation());
        int numberOfElementsInJsonArray = js.getInt("data.size()");
        int sumOfPKBPerCapita = 0;
        for (int i = 0; i < numberOfElementsInJsonArray; i++) {
            int pkbTotalAmount = js.getInt("data[" + i + "].PKBTotal");
            int populationForGivenYear = js.getInt("data[" + i + "].Population");

            int pkbPerCapita = pkbTotalAmount/populationForGivenYear;
            System.out.println(pkbPerCapita);

            sumOfPKBPerCapita += pkbPerCapita;

        }
        System.out.println("total sum: " + sumOfPKBPerCapita);
    }
}
