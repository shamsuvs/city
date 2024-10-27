package com.smashplus.cityxplor;


		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.boot.builder.SpringApplicationBuilder;
		import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
		import org.springframework.cache.annotation.EnableCaching;
		import org.springframework.context.MessageSource;
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/** Simple class to start up the application.
 *
 * @SpringBootApplication adds:
 *  @Configuration
 *  @EnableAutoConfiguration
 *  @ComponentScan
 */
@SpringBootApplication(scanBasePackages = { "com.smashplus"} )
@EnableCaching
public class CityxplorApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CityxplorApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CityxplorApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource result = new ReloadableResourceBundleMessageSource();
		/* add an array of properties files package names */
		String[] basenames = { "classpath:/properties/locale/message"
		};
		result.setBasenames(basenames);
		return result;
	}

}
