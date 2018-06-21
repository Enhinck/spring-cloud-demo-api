package com.enhinck.demo.config;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.enhinck.demo.jwt.JwtTokenUtil;
import com.enhinck.demo.jwt.JwtUser;
import com.enhinck.demo.jwt.JwtUserFactory;
import com.enhinck.demo.model.Authority;
import com.enhinck.demo.model.AuthorityName;
import com.enhinck.demo.model.User;
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

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("enhinck-demo-api").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.enhinck.demo.api")).paths(postPaths()).build()
				.globalOperationParameters(parameters());
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/*.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Enhinck Demo API")
				.description("spring cloud  API reference for developers").termsOfServiceUrl("http://github.com")
				.contact(new Contact("huenbin", "http://github.com", "huenbin@foxmail.com")).license("Enhinck License")
				.licenseUrl("huenbin@gmail.com").version("1.0").build();
	}

	private List<Parameter> parameters() {
		List<Parameter> pars = new ArrayList<Parameter>();
		User user = new User();
		user.setUsername("admin");
		user.setId(1L);
		user.setPassword("admin");
		user.setEnabled(true);
		List<Authority> authorities = new ArrayList<>();
		Authority authoritie = new Authority();
		authoritie.setName(AuthorityName.ROLE_ADMIN);
		authoritie.setId(1L);
		authorities.add(authoritie);
		user.setAuthorities(authorities);
		JwtUser jwtUser =JwtUserFactory.create(user);
		String token = jwtTokenUtil.debugToken(jwtUser);
		
		String authorization = "Bearer " + token;
		ParameterBuilder debugUserAthorization = new ParameterBuilder();
		debugUserAthorization.name(HttpHeaders.AUTHORIZATION).description("用户请求头").modelRef(new ModelRef("string"))
				.parameterType("header").defaultValue(authorization).required(true).build();

		pars.add(debugUserAthorization.build());
		return pars;
	}

}