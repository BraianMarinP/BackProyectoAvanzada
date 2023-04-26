package co.edu.uniquindio.moonmarket.seguridad.servicios;

import co.edu.uniquindio.moonmarket.entidades.Moderador;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import co.edu.uniquindio.moonmarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.seguridad.modelo.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepo usuarioRepo;
    @Autowired
    private ModeradorRepo moderadorRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.buscarUsuario(email);
        if(usuario==null){
            Moderador moderador = moderadorRepo.buscarModerador(email);
            if(moderador ==null)
                throw new UsernameNotFoundException("El usuario no existe");
            return UserDetailsImpl.build(moderador);
        }else{
            return UserDetailsImpl.build(usuario);
        }
    }
}