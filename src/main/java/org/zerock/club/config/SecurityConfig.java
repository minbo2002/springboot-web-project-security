package org.zerock.club.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Log4j2
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();  // PasswordEncoder 인터페이스의 구현체 클래스인 BCryptPasswordEncoder
    }

    // 인증 (Authentication)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자 계정 user1
        auth.inMemoryAuthentication().withUser("user1")
                .password("$2a$10$qJW2A1PtUXhFSaVqDhTINu4Z5eXErJzr/hHZqQ4HZ1A56tkm3y7e6")
                // 1111 패스워드 인코딩 결과

                .roles("USER");
                // 권한 설정
    }

    // 인가 (Authorization)
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/sample/all").permitAll()
                // URL주소 "/sample/all" 에서 로그인 하지않아도 접근가능

                .antMatchers("/sample/member").hasRole("USER");
                // USER 라는 권한 있어야 접근가능

        http.formLogin();  // 인증 or 인가에 문제시 로그인화면으로 이동
        http.csrf().disable();  // CSRF 토큰을 발행하지않도록 설정 (REST 방식으로 이용할 수 있는 보안 설정을 다루기 위해)
        http.logout();
    }

}
