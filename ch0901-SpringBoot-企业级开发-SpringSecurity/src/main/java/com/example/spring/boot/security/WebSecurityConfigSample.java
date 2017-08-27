//package com.example.spring.boot.security;
//
//import com.example.spring.boot.security.service.CustomUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class WebSecurityConfigSample extends WebSecurityConfigurerAdapter {//1
//
////    @Autowired
////    private DataSource dataSource;
//
//    @Bean
//    UserDetailsService customUserService() { //2
//        return new CustomUserService();
//    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////
////        auth.inMemoryAuthentication()
////                .withUser("wjc").password("123456").roles("ROLE_ADMIN")
////                .and()
////                .withUser("wisely").password("123456").roles("ROLE_USER");
////    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
////    }
//
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication().dataSource(dataSource);
////    }
//
//
//    //    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication().dataSource(dataSource)
////                .usersByUsernameQuery("select username,password,true "
////                        + "from t_users " + "where username = ?")
////        .authoritiesByUsernameQuery("select username,authority "
////                + "from t_authorities " + "where username = ?");
////    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserService());
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
////    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
////    }
//
//    //    @Override
////    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests()
////                .antMatchers("/admin/**").hasRole("ROLE_ADMIN")
////                .antMatchers("/user/**").hasAnyRole("ROLE_ADMIN", "ROLE_USER")
////                .anyRequest().authenticated();
////    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/index")
//                .failureUrl("/login?error")
//                .permitAll()
//                .and()
//                .rememberMe()
//                .tokenValiditySeconds(1000)
//                .key("key")
//                .and()
//                .logout()
//                .logoutUrl("/custom-logout")
//                .logoutSuccessUrl("/logout-success")
//                .permitAll();
//    }
//}
