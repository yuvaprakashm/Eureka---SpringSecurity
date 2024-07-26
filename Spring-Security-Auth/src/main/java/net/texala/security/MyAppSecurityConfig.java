package net.texala.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .withDefaultSchema()
            .withUser("yuva")
            .password(encoder.encode("yuva"))
            .roles("USER")
            .and()
            .withUser("admin")
            .password(encoder.encode("admin"))
            .roles("ADMIN")
	        .and()
	        .withUser("superadmin")
	        .password(encoder.encode("superadmin"))
	        .roles("SUPERADMIN");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin").hasAnyRole("ADMIN", "SUPERADMIN")  // admin and superadmin can access /admin
            .antMatchers("/user").hasAnyRole("USER", "SUPERADMIN", "ADMIN")    // user, admin and superadmin can access /user
            .antMatchers("/superadmin").hasRole("SUPERADMIN")          // only superadmin can access /superadmin
            .antMatchers("/").permitAll()
            .antMatchers("/h2-console/**").permitAll()
            .and().formLogin();

        // Disable CSRF and frame options for H2 console
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }

}
