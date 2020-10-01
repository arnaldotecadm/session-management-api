package br.com.emerion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import br.com.emerion.enums.EnumTipoVersao;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConf {

	@Bean
	public Docket exceptionApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.emerion")).paths(PathSelectors.ant("/**")).build()
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Api para controle de Exceções.")
				.description(
						"Controle as exceções ocorridas em seus sistemas em um só lugar, de maneira fácil e rápida.")
				.version("1.0.0")
				.contact(new Contact("Arnaldo Cícero Bezerra", "http://www.linkedin.com/in/arnaldocicero",
						"arnaldo-soft-dev@outlook.com"))
				// .license("Apache License Version 2.0")
				// .licenseUrl("Licença de Software Aberta")
				.build();
	}

	private final TypeResolver typeResolver;

	@Autowired
	public SwaggerConf(TypeResolver typeResolver) {
		this.typeResolver = typeResolver;
	}

	@Autowired
	public void createAdditionalModelDocumentation(Docket docket) {
		docket.additionalModels(typeResolver.resolve(EnumTipoVersao.class));
	}

}
