package com.enhinck.demo.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("enhinck-demo-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.enhinck.demo.api")).paths(postPaths()).build()
				.globalOperationParameters(parameters());
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/api/*.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Enhinck Demo API")
				.description("spring cloud  API reference for developers").termsOfServiceUrl("http://github.com")
				.contact(new Contact("huenbin", "http://github.com", "huenbin@foxmail.com")).license("Enhinck License")
				.licenseUrl("huenbin@gmail.com").version("1.0").build();
	}

	private List<Parameter> parameters() {
		List<Parameter> pars = new ArrayList<Parameter>();

		ParameterBuilder debugUserIdPar = new ParameterBuilder();
		debugUserIdPar.name("debugUserId").description("方便本地debug用").modelRef(new ModelRef("string"))
				.parameterType("query").defaultValue("1").required(false).build();

		pars.add(debugUserIdPar.build());

		return pars;
	}

}