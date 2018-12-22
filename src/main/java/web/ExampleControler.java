package web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
public class ExampleControler {
	
	private Logger logger = LoggerFactory.getLogger(ExampleControler.class);
	
	@GetMapping("/")
	@PostMapping("/")
	public String home(Model model) {
		model.addAttribute("welcome", "Hello Thymeleaf!!");
		return "list";
	}

	@GetMapping("/list/")
	@PostMapping("/list/")
	public String list(Model model) {
		logger.info("list start.");
		model.addAttribute("welcome", "Hello Thymeleaf!!");
		return "list";
	}
}