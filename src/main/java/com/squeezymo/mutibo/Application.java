package com.squeezymo.mutibo;

import java.io.File;
//import org.magnum.mobilecloud.video.auth.OAuth2SecurityConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.squeezymo.mutibo.repository.*;

@EnableAutoConfiguration
@EnableWebMvc
@EnableJpaRepositories(basePackageClasses = {QuestionSetRepo.class})
@Configuration
@ComponentScan
//@Import(OAuth2SecurityConfiguration.class)
public class Application extends RepositoryRestMvcConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
