package org.example.msasbuser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 게이트웨이에서 모드 걸러낸 요청만 진입 -> 모든 요청 통과
 */

// MVC 서비스로 변경
@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 공격에 대한 보호 설정 -> 비활성 처리
                .csrf(AbstractHttpConfigurer::disable)
                // 인증 없이 접근 가능한 페이지 (회원가입, 로그인, 기타 서비스별 별도 페이지들 가능)
                .authorizeHttpRequests(authorizeRequests ->
                                authorizeRequests.anyRequest().permitAll()
                        // 모든 요청은 무조건 통과 permitAll() 처리 예정
                )
                // 로그인 화면 비활성
                .formLogin(AbstractHttpConfigurer::disable);
        return http.build();
    }

}