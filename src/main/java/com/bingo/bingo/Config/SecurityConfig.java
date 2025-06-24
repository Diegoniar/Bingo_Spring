package com.bingo.bingo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(customAuthenticationProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(authz -> authz
                        // 1. Lista de URLs PÚBLICAS (no requieren login)
                        .antMatchers(
                                "/",                         // La página de inicio
                                "/formulario/nuevo",       // El formulario de inscripción
                                "/formulario/guardar",     // La acción de guardar el formulario
                                "/inscripcion-exitosa",    // La página de éxito
                                "/api/afiliados/**",       // La API para buscar afiliados
                                "/css/**", "/js/**"        // Recursos estáticos como CSS o JavaScript
                        ).permitAll() // Permite el acceso a todas las URLs anteriores sin login

                        // 2. URLs de ADMINISTRACIÓN (requieren login)
                        .antMatchers("/admin/**").authenticated() // Cualquier URL que empiece con /admin/ requiere estar logueado

                        // 3. (Opcional, pero recomendado) Cualquier otra URL no definida también requiere login
                        .anyRequest().authenticated()
                )
                // La configuración del formulario de login y logout no cambia
                .formLogin(form -> form
                        .loginPage("/login") // La página de login es pública
                        .permitAll()
                        .defaultSuccessUrl("/admin/bingos/nuevo", true) // A dónde ir después de un login exitoso
                )
                .logout(logout -> logout
                        .permitAll()
                );

        return http.build();
    }
}
