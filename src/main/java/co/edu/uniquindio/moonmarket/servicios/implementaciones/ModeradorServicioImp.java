package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.ModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ModeradorGetDTO;
import co.edu.uniquindio.moonmarket.entidades.Moderador;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import co.edu.uniquindio.moonmarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ModeradorServicio;
import lombok.AllArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModeradorServicioImp implements ModeradorServicio {

    private final ModeradorRepo moderadorRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public String actualizarModerador(String cedula, ModeradorGetDTO moderadorDTO) throws Exception {


        Optional<Moderador> moderadorBuscado = moderadorRepo.findById(cedula);

        if (moderadorBuscado.isPresent()) {
            Moderador moderadorActualizar = moderadorBuscado.get();
            moderadorActualizar.setNombre(moderadorDTO.getNombre());
            moderadorActualizar.setEmail(moderadorDTO.getEmail());
            moderadorActualizar.setDireccion(moderadorDTO.getDireccion());
            moderadorActualizar.setNumTel(moderadorDTO.getNumTel());
            moderadorActualizar.setImagen(moderadorDTO.getImagen());
/*
            if (!moderadorDTO.getContrasena().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,50}$")) {
                throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad.");
            }

            moderadorActualizar.setContrasena(passwordEncoder.encode(moderadorDTO.getContrasena()));
*/
            return moderadorRepo.save(moderadorActualizar).getCedula();
        } else {
            throw new Exception("El moderador con cédula " + moderadorDTO.getCedula() + " no existe.");
        }

    }

    @Override
    public ModeradorDTO buscarModerador(String cedulaModerador) throws Exception{
        Optional<Moderador> moderadorBuscado = moderadorRepo.findById(cedulaModerador);
        if(moderadorBuscado.isPresent()){
            Moderador moderadorEncontrado = moderadorBuscado.get();
            return convertirADTO(moderadorEncontrado);
        }else{
            throw new Exception("El moderador con cédula: "+cedulaModerador+"no existe.");
        }
    }

    @Override
    public String cambiarContrasena(String cedula, String nuevaContrasena) throws Exception {
        Optional<Moderador> moderador= moderadorRepo.findById(cedula);

        if(moderador.isPresent()){
            Moderador moderadorObtenido= moderador.get();
            if (!nuevaContrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,50}$")) {
                throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad.");
            }
            moderadorObtenido.setContrasena(passwordEncoder.encode(nuevaContrasena));
            moderadorRepo.save(moderadorObtenido);
        }else{
            throw  new Exception("El usuario con cédula "+cedula+" no se encuentra registrado en la base de datos");
        }
        return cedula;

    }

    private ModeradorDTO convertirADTO(Moderador moderador){
        ModeradorDTO moderadorDTO = new ModeradorDTO();
        moderadorDTO.setContrasena(moderador.getContrasena());
        if(moderador.getImagen() != null){
            moderadorDTO.setIdImagen(moderador.getImagen().getUrl());
        }else {
            moderadorDTO.setIdImagen(null);
        }

        moderadorDTO.setEmail(moderador.getEmail());
        moderadorDTO.setNombre(moderador.getNombre());
        moderadorDTO.setDireccion(moderador.getDireccion());
        moderadorDTO.setCedula(moderador.getCedula());
        moderadorDTO.setNumTel(moderador.getNumTel());
        return moderadorDTO;
    }

}
