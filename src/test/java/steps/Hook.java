package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseUtil;

/**
 * Created by Karthik on 31/01/2019.
 */

public class Hook extends BaseUtil {

	private BaseUtil base;

	public Hook(BaseUtil base) {
		this.base = base;
	}

	@Before
	public void InitializeTest(Scenario scenario) {

		scenarioDef = BaseUtil.features.createNode(scenario.getName());

		System.out.println("Opening the browser : Firefox");

		/*
		 * System.setProperty("webdriver.firefox.marionette",
		 * "D:\\Libs\\geckodriver.exe"); base.Driver = new FirefoxDriver();
		 */

		// Chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Libs\\chromedriver.exe");
		base.Driver = new ChromeDriver();
	}

	@After
	public void TearDownTest(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take screenshot logic goes here
			System.out.println(scenario.getName());
		}
		System.out.println("Closing the browser : MOCK");
	}

}
