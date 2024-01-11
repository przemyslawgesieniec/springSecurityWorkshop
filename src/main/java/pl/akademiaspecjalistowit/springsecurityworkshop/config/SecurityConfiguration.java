package pl.akademiaspecjalistowit.springsecurityworkshop.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import pl.akademiaspecjalistowit.springsecurityworkshop.user.CustomOAuth2UserService;

@AllArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                (authorize) -> authorize
                    .requestMatchers(HttpMethod.GET, "/books").hasAuthority("USER")
                    .requestMatchers("/books/**").hasAuthority("LIBRARIAN")
                    .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults())
            .oauth2Login(oauth2 -> oauth2
                .userInfoEndpoint(infoEndpoint ->
                    infoEndpoint.userService(customOAuth2UserService)));

        return http.build();
    }

}