// package com.example.finance_dashboard.config;

// import org.springframework.context.annotation.*;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.config.Customizer;

// import org.springframework.security.core.userdetails.*;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// public class SecurityConfig {

// @Bean
// public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

//     http
//         .csrf(csrf -> csrf.disable())
//         .authorizeHttpRequests(auth -> auth

//             // ✅ allow public endpoints
//             .requestMatchers("/", "/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

//             // 🔐 secured endpoints
//             .requestMatchers("/users/**").hasRole("ADMIN")
//             .requestMatchers("/records/**").hasAnyRole("ADMIN", "ANALYST")
//             .requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "ANALYST", "VIEWER")

//             .anyRequest().authenticated()
//         )
//         .httpBasic(Customizer.withDefaults());

//     return http.build();
// }

//     // ✅ ADD THIS (VERY IMPORTANT)
//     @Bean
//     public UserDetailsService userDetailsService() {
//         return new InMemoryUserDetailsManager(

//             User.withUsername("admin")
//                 .password("{noop}admin123")
//                 .roles("ADMIN")
//                 .build(),

//             User.withUsername("analyst")
//                 .password("{noop}analyst123")
//                 .roles("ANALYST")
//                 .build(),

//             User.withUsername("viewer")
//                 .password("{noop}viewer123")
//                 .roles("VIEWER")
//                 .build()
//         );
//     }
// }


package com.example.finance_dashboard.config;

import com.example.finance_dashboard.security.JwtFilter;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authorizeHttpRequests(auth -> auth

                .requestMatchers("/", "/auth/**", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                .requestMatchers("/users/**").hasRole("ADMIN")
                .requestMatchers("/records/**").hasAnyRole("ADMIN", "ANALYST")
                .requestMatchers("/dashboard/**").hasAnyRole("ADMIN", "ANALYST", "VIEWER")

                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class); // 🔥 IMPORTANT

        return http.build();
    }
}
