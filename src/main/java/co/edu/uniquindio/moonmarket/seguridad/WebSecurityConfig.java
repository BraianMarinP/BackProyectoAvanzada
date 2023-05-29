package co.edu.uniquindio.moonmarket.seguridad;


import co.edu.uniquindio.moonmarket.seguridad.config.JwtAuthenticationEntryPoint;
import co.edu.uniquindio.moonmarket.seguridad.config.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final JwtAuthenticationEntryPoint jwtEntryPoint;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable();
        http.cors();

        http.authorizeHttpRequests()
                .requestMatchers("/api/auth/**").permitAll()
                .requestMatchers("/api/usuarios/Publicaciones/listar").permitAll()
                .requestMatchers("/api/usuarios/Publicaciones/detallePublicacion/**").permitAll()
                .requestMatchers("/api/usuarios/Publicaciones/listarCategoria/**").permitAll()
                .requestMatchers("/api/categorias/**").permitAll()
                .requestMatchers("/api/usuarios/usuarioPorCorreo/**").permitAll()
                .requestMatchers("/api/imagenes/**").permitAll()
                .requestMatchers("/api/usuarios/Publicaciones/listarComentarios/**").permitAll()

                .anyRequest().authenticated();
        http.exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
        //http.authorizeHttpRequests().anyRequest().permitAll();
        //return http.build();
    }
}