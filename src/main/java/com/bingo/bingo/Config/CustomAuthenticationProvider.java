package com.bingo.bingo.Config;

import com.bingo.bingo.Servicios.AuthenticationService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private AuthenticationService authService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException{
        String cedtra = authentication.getName();
        String passwordIngresada = authentication.getCredentials().toString();

        String passwordDeLaBD = authService.getDecrypterPassword(cedtra);

        if (passwordDeLaBD == null) {
            throw new BadCredentialsException("Usuario no encontrado o clave invalida");
        }

        if (passwordIngresada.equals(passwordDeLaBD.trim())) {
            // Si las contraseñas coinciden, el login es exitoso.
            // Creamos un objeto de autenticación exitoso y se lo devolvemos a Spring Security.
            return new UsernamePasswordAuthenticationToken(cedtra, passwordIngresada, new ArrayList<>());
        } else {
            // Si no coinciden, lanzamos una excepción para indicar que el login falló.
            throw new BadCredentialsException("Cédula o contraseña incorrectas.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
