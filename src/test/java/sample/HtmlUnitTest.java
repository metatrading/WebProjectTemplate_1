package sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.CollectingAlertHandler;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import web.ExampleControler;

/**
 * Thymeleaf & Javascriptまでの検証。
 * 

 *
 */
@SpringBootTest(classes = ExampleControler.class)
public class HtmlUnitTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private WebApplicationContext context;
	private WebClient webClient;

	@BeforeMethod
	public void setup() {
		webClient = MockMvcWebClientBuilder.webAppContextSetup(context).build();
	}

	@Test
	public void test01() throws Exception {
		
		List<String> alertList = new ArrayList<>();
		webClient.setAlertHandler(new CollectingAlertHandler(alertList));
		
		HtmlPage page = webClient.getPage("http://localhost:8080/list/");
		logger.info(page.getBody().asText());
		logger.info(page.getFirstByXPath("//p[1]/text()"));
		
		final List<String> expectedAlerts = Collections.singletonList("Hello world!!");
	    Assert.assertEquals(expectedAlerts, alertList);
	}
}
