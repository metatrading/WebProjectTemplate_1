package sample;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import web.ExampleControler;

/**
 * Thymeleafまでの検証。
 * 

 *
 */
@WebMvcTest(controllers = ExampleControler.class)
@ContextConfiguration(classes = ExampleControler.class)
public class MockMvcTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private MockMvc mockMvc;

	@BeforeMethod
	public void setup() {
	}

	@Test
	public void test01() throws Exception {
		mockMvc.perform(get("http://localhost:8080/list/")).andDo(print()).andExpect(status().isOk());
	}
}
