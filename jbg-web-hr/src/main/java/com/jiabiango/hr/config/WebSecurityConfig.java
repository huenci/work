package com.jiabiango.hr.config;

import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.ForwardAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.jiabiango.hr.config.security.AuthenticationConfigAttribute;
import com.jiabiango.hr.config.security.CaptchaAuthenticationFilter;
import com.jiabiango.hr.config.security.CustomAccessDecisionManager;
import com.jiabiango.hr.config.security.CustomAccessDeniedHandler;
import com.jiabiango.hr.config.security.CustomAuthenticationSuccessHandler;
import com.jiabiango.hr.config.security.CustomAuthenticationVoter;
import com.jiabiango.hr.config.security.CustomUserDetailServcie;
import com.jiabiango.hr.config.security.ResourceSecurityMetadataSource;
import com.jiabiango.hr.service.ResourceService;

@Configuration
@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/admin/login")
            .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))
                .logoutSuccessUrl("/admin/logout/success")
                .and().headers().frameOptions().disable()
                .and().csrf().disable();
        
        CaptchaAuthenticationFilter captchaAuthenticationFilter = new CaptchaAuthenticationFilter();
        captchaAuthenticationFilter.setFilterProcessesUrl("/admin/login");
        captchaAuthenticationFilter.setAuthenticationManager(authenticationManager());
        captchaAuthenticationFilter.setAuthenticationSuccessHandler(new CustomAuthenticationSuccessHandler("/admin/"));
        captchaAuthenticationFilter.setAuthenticationFailureHandler(new ForwardAuthenticationFailureHandler("/admin/login/failure"));
        http.addFilterAt(captchaAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        
        FilterSecurityInterceptor filterSecurityInterceptor = new CustomFilterSecurityInterceptor(securityMetadataSource(), new CustomAccessDecisionManager(), authenticationManager());
        http.addFilter(filterSecurityInterceptor);
        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler("/admin/access/denied"));
    }
    
    @Bean
    public FilterInvocationSecurityMetadataSource securityMetadataSource() {
    	ResourceSecurityMetadataSource rsms = new ResourceSecurityMetadataSource();
    	rsms.setResourceService(getApplicationContext().getBean(ResourceService.class));
    	//不需要认证的url
    	ConfigAttribute allow = new AuthenticationConfigAttribute(CustomAuthenticationVoter.ALLOW);
    	rsms.addFullResource("/admin/login", allow);
    	rsms.addFullResource("/admin/login/failure", allow);
    	rsms.addFullResource("/admin/logout", allow);
    	rsms.addFullResource("/adminv/logout/success", allow);
    	rsms.addFullResource("/admin/access/denied", allow);
    	
    	//需要认证的url
    	ConfigAttribute authenticated = new AuthenticationConfigAttribute(CustomAuthenticationVoter.AUTHENTICATED);
    	rsms.addPatternResource("/admin/**", authenticated);
    	return rsms;
    }
    
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserDetailServcie userDetailService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailService);
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }
    
    public static class CustomFilterSecurityInterceptor extends FilterSecurityInterceptor {
        public CustomFilterSecurityInterceptor(FilterInvocationSecurityMetadataSource securityMetadataSource, AccessDecisionManager accessDecisionManager, AuthenticationManager authenticationManager){
            this.setSecurityMetadataSource(securityMetadataSource);
            this.setAccessDecisionManager(accessDecisionManager);
            this.setAuthenticationManager(authenticationManager);
        }
    }
}
