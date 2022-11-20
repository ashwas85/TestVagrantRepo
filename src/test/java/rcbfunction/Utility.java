package rcbfunction;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Utility extends ReadProperty {
	static ExtentReports report;
	static ExtentTest test;

	@BeforeClass
	public static void startTest() {

		report = new ExtentReports(System.getProperty("user.dir") + "/reports/ExtentReportResults.html");
		test = report.startTest("ExtentReport");
	}

	@AfterClass
	public static void endTest() {

		report.endTest(test);
		report.flush();
	}

	public void assertsEquals(int a, int b) {
		SoftAssert softassert = new SoftAssert();

		softassert.assertEquals(a, b);
		softassert.assertAll();

	}

	public void assertTrue(int a, int b) {
		SoftAssert softassert = new SoftAssert();

		softassert.assertTrue(a >b);
		softassert.assertAll();

	}

	public static List<HashMap<String, String>> getJasonData() throws IOException {
		String jsonData = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "/src/test/java/rcbteam/data/rcbteamdetails.json"),
				StandardCharsets.UTF_8);
		// System.out.println(jsonData);
		ObjectMapper map = new ObjectMapper();
		// map.configure(DeserializationFeature.);
		System.out.println(map.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true));
		List<HashMap<String, String>> data = map.readValue(jsonData,
				new TypeReference<List<HashMap<String, String>>>() {

				});

		return data;

	}

	public static JSONArray parseJasonData() throws FileNotFoundException, IOException, ParseException {
		String jsonString = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "/src/test/java/rcbteam/data/rcbteamdetails.json"),
				StandardCharsets.UTF_8);
		JSONObject obj = new JSONObject(jsonString);

		JSONArray arr = obj.getJSONArray("player");

		return arr;
	}

}