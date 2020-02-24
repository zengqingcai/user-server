package com.user.base.config;

import com.user.base.config.shiro.MyDisableUrlSessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig  extends  WebSecurityConfigurerAdapter   {

	@Bean
	public MyDisableUrlSessionFilter myDisableUrlSessionFilter(){
		return new MyDisableUrlSessionFilter();
	}

	@Override	    
	protected void configure(HttpSecurity http) throws Exception {	        
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);	        
		http.csrf().disable(); //关闭csrf	        
		//注意：为了可以使用 http:
		//${user}:${password}@${host}:${port}/eureka/ 
		//这种方式登录,所以必须是httpBasic,如果是form方式,不能使用url格式登录	        
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); //开启认证	            				  } }


		//http.addFilterBefore(myDisableUrlSessionFilter(),UsernamePasswordAuthenticationFilter.class);
		http.headers().frameOptions().disable();
	}



}
