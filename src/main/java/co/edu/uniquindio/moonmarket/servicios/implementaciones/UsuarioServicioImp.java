package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.ProductoDTO;
import co.edu.uniquindio.moonmarket.dto.PublicacionProductoDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.moonmarket.entidades.EstadoUsuario;
import co.edu.uniquindio.moonmarket.entidades.Producto;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServicioImp implements UsuarioServicio {


    private final UsuarioRepo usuarioRepo;
    private final PublicacionProductoServicioImp publicacionProductoServicioImp;
    private final PasswordEncoder passwordEncoder;
    private final ProductoServicioImp productoServicioImp;
    @Override
    public String crearUsuario(UsuarioDTO usuarioDTO) throws Exception{

        Optional<Usuario> buscadoCedula = usuarioRepo.findById(usuarioDTO.getCedula());
        Usuario buscadoCorreo = usuarioRepo.buscarUsuario(usuarioDTO.getEmail());

        if(buscadoCedula.isPresent()){
            throw new Exception("La cedula "+usuarioDTO.getCedula()+" ya está en uso");
        }
        if(buscadoCorreo!=null){
            throw new Exception("El correo "+usuarioDTO.getEmail()+" ya está en uso");
        }

        Usuario usuario = convertir(usuarioDTO);
        return usuarioRepo.save( usuario ).getCedula();
    }

    @Override
    public String actualizarUsuario(UsuarioGetDTO usuarioGetDTO) throws Exception{

        Optional<Usuario> usuarioBuscado = usuarioRepo.findById(usuarioGetDTO.getCedula());
        if(!usuarioBuscado.isPresent()){
            throw new Exception("No existe el usuario con cédula: " + usuarioGetDTO.getCedula());
        }else{
            Usuario usuarioModificar = usuarioBuscado.get();
            usuarioModificar.setNombre(usuarioGetDTO.getNombre());
            usuarioModificar.setDireccion(usuarioGetDTO.getDireccion());
            usuarioModificar.setEmail(usuarioGetDTO.getEmail());
            usuarioModificar.setNickName(usuarioGetDTO.getNickName());
            usuarioModificar.setNumTel(usuarioGetDTO.getNumTel());
            return usuarioRepo.save(usuarioModificar).getCedula();
        }

    }

    @Override
    public String eliminiarUsuario(String codigoUsuario) throws Exception{
        validarExiste(codigoUsuario);
        usuarioRepo.deleteById(codigoUsuario);
        return codigoUsuario;
    }

    @Override
    public UsuarioGetDTO obtenerUsuario(String codigoUsuario) throws Exception{
        return convertirGetDTO( obtener(codigoUsuario) );
    }

    @Override
    public List<UsuarioGetDTO> listarUsuarios() throws Exception {

        List<Usuario> usuarios = usuarioRepo.findAll();
        List<UsuarioGetDTO> usuarioGetDTO = new ArrayList<>();
        for (Usuario user: usuarios) {
            usuarioGetDTO.add(convertirGetDTO(user));
        }
        return usuarioGetDTO;
    }

    @Override
    public UsuarioGetDTO usuarioPorCorreo(String correo) throws Exception{
        Usuario usuario = usuarioRepo.buscarUsuario(correo);
        return convertirGetDTO(usuario);
    }

    @Override
    public Usuario obtener(String cedulaUsuario) throws Exception{
        Optional<Usuario> usuario = usuarioRepo.findById(cedulaUsuario);
        if(!usuario.isPresent()){
            throw new Exception("La cedula "+cedulaUsuario+" no está asociado a ningún usuario");
        }
        return usuario.get();
    }
    private void validarExiste(String cedula) throws Exception{
        boolean existe = usuarioRepo.existsById(cedula);
        if(!existe){
            throw new Exception("El código "+cedula+" no está asociado a ningún usuario");
        }
    }

    private UsuarioDTO convertir(Usuario usuario){

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setCedula(usuario.getCedula());
        usuarioDTO.setNumTel(usuario.getNumTel());
        usuarioDTO.setDireccion(usuario.getDireccion());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setNickName(usuario.getNickName());

        return usuarioDTO;
    }

    private UsuarioGetDTO convertirGetDTO(Usuario usuario){

        UsuarioGetDTO usuarioGetDTO = new UsuarioGetDTO();
        usuarioGetDTO.setNumTel(usuario.getNumTel());
        usuarioGetDTO.setDireccion(usuario.getDireccion());
        usuarioGetDTO.setNombre(usuario.getNombre());
        usuarioGetDTO.setEmail(usuario.getEmail());
        usuarioGetDTO.setNickName(usuario.getNickName());
        usuarioGetDTO.setCedula(usuario.getCedula());

        return usuarioGetDTO;
    }


    private Usuario convertir(UsuarioDTO usuarioDTO){

        Usuario usuario = new Usuario();

        usuario.setCedula(usuarioDTO.getCedula());
        usuario.setNumTel(usuarioDTO.getNumTel());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setEmail(usuarioDTO.getEmail());
        if (!usuarioDTO.getContrasena().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,50}$")) {
            throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad.");
        }
        usuario.setContrasena(passwordEncoder.encode(usuarioDTO.getContrasena()));
        usuario.setNickName(usuarioDTO.getNickName());
        usuario.setEstado(EstadoUsuario.ACTIVO);

        return usuario;
    }


    /*public String actualizarUsuarioCompleto(UsuarioDTO usuario) throws Exception{
        
        return usuarioRepo.save(usuario).getCedula();
    }*/


    @Override
    public String cambiarContrasena(String cedula, String nuevaContrasena) throws Exception{
        Optional<Usuario> usuario= usuarioRepo.findById(cedula);

        if(usuario.isPresent()){
            Usuario usuarioObtenido= usuario.get();
            if (!nuevaContrasena.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,50}$")) {
                throw new IllegalArgumentException("La contraseña no cumple con los requisitos de seguridad.");
            }
            usuarioObtenido.setContrasena(passwordEncoder.encode(nuevaContrasena));
            usuarioRepo.save(usuarioObtenido);
        }else{
            throw  new Exception("El usuario con cédula "+cedula+" no se encuentra registrado en la base de datos");
        }
        return cedula;
    }

    @Override
    public List<PublicacionProductoDTO> listarProductosComprados(String cedula){
        List<PublicacionProducto> publicacionProductos = usuarioRepo.listarProductosComprados(cedula);
        List<PublicacionProductoDTO> publicacionProductoDTOS = new ArrayList<>();
        for (PublicacionProducto publicacionProducto: publicacionProductos) {
            publicacionProductoDTOS.add(publicacionProductoServicioImp.convertir(publicacionProducto));
        }
        return publicacionProductoDTOS;
    }
}
