package wifak.bank.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.userdetails.UserDetailsService;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

public class WifakServeurBankApplication {

	public static void main(String[] args) {
		//SpringApplication.run(WifakServeurBankApplication.class, args);
		ConfigurableApplicationContext ctx =SpringApplication.run(WifakServeurBankApplication.class, args);
		UserDetailsService us=ctx.getBean(UserDetailsService.class);
		us.loadUserByUsername("myriam");
	}

}
