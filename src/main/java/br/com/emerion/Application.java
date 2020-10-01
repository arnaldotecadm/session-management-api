package br.com.emerion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emerion.model.SessionInfo;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackageClasses = SessionInfo.class)
@RestController
@EnableSwagger2
@EnableSpringDataWebSupport
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@ApiOperation(value = "Ping para resposta do Servidor")
	@GetMapping(path = "/")
	public String retornaPing() {
		return ping();
	}

	@ApiOperation(value = "Ping para resposta do Servidor")
	@GetMapping(path = "/ping")
	public String ping() {
		return "ok";
	}

	@Controller
	class SwaggerWelcome {
		@RequestMapping("/documentacao")
		public String redirectToUi() {
			return "redirect:/swagger-ui.html";
		}
	}
}