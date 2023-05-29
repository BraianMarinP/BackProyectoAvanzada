package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.SesionDTO;
import co.edu.uniquindio.moonmarket.dto.TokenDTO;
import co.edu.uniquindio.moonmarket.seguridad.modelo.UserDetailsImpl;
import co.edu.uniquindio.moonmarket.seguridad.servicios.JwtService;
import co.edu.uniquindio.moonmarket.seguridad.servicios.UserDetailsServiceImpl;
import co.edu.uniquindio.moonmarket.servicios.interfaces.SesionServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class SesionServicioImpl implements SesionServicio {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private  final UserDetailsServiceImpl userDetailsService;
    @Override
    public TokenDTO login(SesionDTO sesionDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        sesionDTO.getEmail(),
                        sesionDTO.getPassword())

        );
        UserDetails user = (UserDetailsImpl) authentication.getPrincipal();
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return new TokenDTO(jwtToken, refreshToken);
    }

    @Override
    public TokenDTO refreshToken(TokenDTO tokenDTO) throws Exception{
        String email = jwtService.extractUsername(tokenDTO.getRefreshToken());
        UserDetailsImpl user = (UserDetailsImpl) userDetailsService.loadUserByUsername(email);
        if (jwtService.isTokenValid(tokenDTO.getRefreshToken(), user)) {
            String token = jwtService.generateToken(user);
            return new TokenDTO( token, tokenDTO.getRefreshToken() );
        }
        throw new Exception("Error construyendo el token");
    }
}
