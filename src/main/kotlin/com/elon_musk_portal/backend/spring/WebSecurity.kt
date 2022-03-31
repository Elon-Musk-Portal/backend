package com.elon_musk_portal.backend.spring

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebSecurity : WebSecurityConfigurerAdapter(), WebMvcConfigurer {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().antMatchers("/**").permitAll()
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedOrigins("http://localhost:443")
            .allowedOrigins("http://localhost")
            .allowedOrigins("https://programistich.com:3000")
            .allowedOrigins("https://programistich.com:443")
            .allowedOrigins("https://programistich.com")
            .allowedMethods("*");
    }
}
