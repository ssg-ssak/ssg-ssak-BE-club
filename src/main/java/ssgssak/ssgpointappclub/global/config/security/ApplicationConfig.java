package ssgssak.ssgpointappclub.global.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    /**
     * Security 동작에 필요한 인증 관리자, 패스워드 인코더를 설정 및 등록한다
     */

    // 인증 관리자 : 인증을 관리하는데 필요한 authenticationManager를 생성한다.
    // authenticationConfiguration에서 현재 컨텍스트에 등록된 인증관리자를 가져와서 return한다
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // 패스워드 인코더 : 패스워드를 해싱한다
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
