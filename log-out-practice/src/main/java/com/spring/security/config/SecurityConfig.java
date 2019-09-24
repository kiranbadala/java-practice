package com.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	public void configurGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// auth.inMemoryAuthentication().withUser("user").password("{noop}pass").roles("USER");
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception // @formatter:off 
	{
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/user/register/**").permitAll()
		.antMatchers(HttpMethod.GET,"/user/**").hasRole("USER")
		.antMatchers(HttpMethod.DELETE,"/user/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().and().httpBasic()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/doLogout", "GET"))
		.logoutSuccessUrl("/logOut").permitAll();
	} // @formatter: on

	/*@SuppressWarnings("deprecation")
	@Bean
	public UserDetailsService userDetailsServiceBean() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		InMemoryUserDetailsManager userManager = new InMemoryUserDetailsManager();
		User.UserBuilder users = User.withDefaultPasswordEncoder();
		userManager.createUser(users.username("user").password("pass").roles("USER").build());
		userManager.createUser(users.username("kiran").password("reddy").roles("EDITOR").build());
		userManager.createUser(users.username("krishna").password("reddy").roles("EDITOR").build());
		return userManager;

	}
*/
}
