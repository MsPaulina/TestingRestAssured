package org.example;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
//import org.junit.FixMethodOrder;
//import org.junit.jupiter.api.*;
//import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.testng.annotations.*;


import static io.restassured.RestAssured.given;

public class RestAssuredRequests {
    static ExtentTest test;
    static ExtentReports report;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
//        report = new ExtentReports(System.getProperty("user.dir") + "ExtentReportResults.html");
//        System.out.println(System.getProperty("user.dir") + "ExtentReportResults.html");
//        test = report.startTest("Language School Tests");
    }


    @Test(priority = 1)
    @DisplayName("First request - German Course Post Request")
    public void test1() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                             "description": "Opis kursu jezyka niemieckiego",
                             "name": "Kurs niemieckiego"
                         }""")
                .post("/myapi/addNewCourse")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of First Post COURSE Request received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added first course to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add German COURSE to the database work");
    }

    @Test(priority = 2)
    @DisplayName("Second request - ENGLISH Course Post Request")
    public void test2() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                            "description": "Opis kursu jezyka angielskiego",
                            "name": "Kurs angielskiego"
                        }""")
                .post("/myapi/addNewCourse")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of Second Post COURSE Request received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added second course to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add English COURSE to the database work");
    }

    @Test(priority = 3)
    @DisplayName("Third request - ITALIAN Course Post Request")
    public void test3() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                             "description": "Opis kursu jezyka włoskiego",
                             "name": "Kurs włoskiego"
                         }""")
                .post("/myapi/addNewCourse")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of Third Post COURSE Request received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added third course to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add Italian COURSE to the database work");
    }

    @Test(priority = 4)
    @DisplayName("Fourth request - First German Student Post Request")
    public void test4() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                             "courseId": 1,
                             "studentIDinLanguageSchool": "s1",
                             "studentName": "Hans",
                             "studentSurname": "Niemiec"
                         }""")
                .post("/myapi/addNewStudent")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of First Post Request to add a new student received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added first student to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add specific student to the database work");
    }

    @Test(priority = 5)
    @DisplayName("Fifth request -  Second Italian Student Post Request")
    public void test5() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                             "courseId": 3,
                             "studentIDinLanguageSchool": "s2",
                             "studentName": "Luigi",
                             "studentSurname": "Romano"
                         }""")
                .post("/myapi/addNewStudent")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of Second Post Request to add a new student received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added the student to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add specific student to the database work");
    }

    @Test(priority = 6)
    @DisplayName("Sixth request -  English Student Post Request")
    public void test6() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                              "courseId": 2,
                              "studentIDinLanguageSchool": "s3",
                              "studentName": "Samantha",
                              "studentSurname": "Jones"
                          }""")
                .post("/myapi/addNewStudent")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("TThe status of Third Post Request to add a new student received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added the student to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add specific student to the database work");
    }

    @Test(priority = 7)
    @DisplayName("Seventh request - Fourth English Student Post Request")
    public void test7() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .body("""
                        {
                               "courseId": 2,
                               "studentIDinLanguageSchool": "s4",
                               "studentName": "Carrie",
                               "studentSurname": "Bradshaw"
                           }""")
                .post("/myapi/addNewStudent")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of Fourth Post Request to add a new student received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Added the student to the database");
//        test.getEndedTime();
//        test.setDescription("Test to check if POST method to add specific student to the database work");
    }


    @Test(priority = 8)
    @DisplayName("Eighth request - GET request to retrieve all students in the database")
    public void test8() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/myapi/findAllStudents")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

//        Assertions.assertEquals(200, response.statusCode());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Found all available students");
//        test.getEndedTime();
//        test.setDescription("Test to check if GET method to get all students work");
        System.out.println("Response Body of findAllStudentsInDatabase is: " + response.asString());
        System.out.println("The status received of findAllStudentsInDatabase: " + response.statusLine());
    }

    @Test(priority = 9)
    @DisplayName("Nineth request - GET method to retrieve specific student by their ID")
    public void test9() {
        Response response = given()
                .pathParam("studentIDnumber", 7)
                .when()
                .get("/myapi/getStudentById/{studentIDnumber}")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("Response Body of getStudentById is: " + response.asString());
        System.out.println("The status of GET method to retrieve specific student by their ID received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Found the student");
//        test.getEndedTime();
//        test.setDescription("Test to check if GET method to get specific student work");
    }


    @Test(priority = 10)
    @DisplayName("Tenth request - Put Request to update specific student")
    public void test10() {
        Response response = given()
                .contentType(ContentType.JSON)
                .pathParam("studentIDnumber", 4)
                .when()
                .body("""
                        {
                             "courseId": 3,
                             "studentIDinLanguageSchool": "s3",
                             "studentName": "Hanna",
                             "studentSurname": "Bagietka"
                         }""")
                .put("/myapi/updateStudentByID/{studentIDnumber}")
                .then()
                .assertThat().statusCode(200)
                .extract().response();

        System.out.println("The status of First PUT Request received: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Updated the student");
//        test.getEndedTime();
//        test.setDescription("Test to check if PUT method work");
    }

//
//    @Test
//    @DisplayName("DELETE method to delete specific student")
//    public void testcase6() {
//        Response response = given()
//                .pathParam("studentIDnumber", 1)
//                .contentType(ContentType.JSON)
//                .when()
//                .delete("/myapi/deleteStudentFromDB/{studentIDnumber}")
//                .then()
//                .extract().response();
//
//        System.out.println("Response Body of deleteStudentFromDB is: " + response.asString());
//        System.out.println("The status of DELETE method to retrieve specific student by their ID: " + response.statusLine());
//        test.getStartedTime();
//        test.log(LogStatus.PASS, "Delete the student");
//        test.getEndedTime();
//        test.setDescription("Test to check if DELETE method to get specific student work");
//    }

    @AfterAll
    public static void endTest() {
//        report.endTest(test);
//        report.flush();
    }
}