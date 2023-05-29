package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.PersonaDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioGetDTO;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@SpringBootTest

public class UsuarioTest {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void crearUsuarioTest() {

        try {
            UsuarioDTO usuarioDTO =new UsuarioDTO();
            usuarioDTO.setCedula("1234568");
            usuarioDTO.setNumTel("1234567890");
            usuarioDTO.setDireccion("Calle 123");
            usuarioDTO.setNombre("Juan");
            usuarioDTO.setEmail("juanperrita@example50.com");
            usuarioDTO.setContrasena("Contrasena05");
            usuarioDTO.setNickName("jperezSUPERRA");
            usuarioServicio.crearUsuario(usuarioDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void actualizarUsuarioTest() {
        /*try {
            UsuarioGetDTO usuarioGetDTO = UsuarioGetDTO.builder().base(PersonaDTO.BaseBuilder().cedula("1234568")
                    .numTel("1234567887")
                    .direccion("Calle 123")
                    .nombre("Juan")
                    .email("juanperrita@example50.com")
                    .contrasena("contrasena05").build()).nickName("jperezSUPERRA").build();
            usuarioServicio.actualizarUsuario(usuarioGetDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    @Test
    public void eliminarUsuarioTest() throws Exception {
            String cedulaUsuario = usuarioServicio.eliminiarUsuario("1234568");
    }

    @Test
    public void obtenerUsuarioTest() throws Exception {
        try {/*
            //Para obtener el usuario primero se debe crear
            UsuarioDTO usuarioDTO = UsuarioDTO.builder().base(PersonaDTO.BaseBuilder().cedula("1111111")
                    .numTel("1234567888")
                    .direccion("Calle 123")
                    .nombre("Juan")
                    .email("juanperrita@example5000.com")
                    .contrasena("contrasena05").build()).nickName("jperezSUPERRA900").build();

            String codigoNuevo = usuarioServicio.crearUsuario(usuarioDTO);

            //Se llama el servicio para obtener el usuario completo dado su código
            UsuarioGetDTO usuarioGetDTO = usuarioServicio.obtenerUsuario(codigoNuevo);

            //Comprobamos que la dirección que está en la base de datos coincide con la que esperamos
            Assertions.assertEquals("Calle 123", usuarioGetDTO.getDireccion());
*/
        } catch (DataIntegrityViolationException e) {

            String mensaje = "El nombre de usuario ya está en uso. Por favor, elija otro nombre de usuario.";
            System.err.println(mensaje);
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void listarUsuarios() throws  Exception{
       // List<UsuarioGetDTO> usuario= usuarioServicio.listarUsuarios();

    }

    @Test
    public void cambiarContrasena() throws  Exception{

        String cedulaUsuario= usuarioServicio.cambiarContrasena("2222220","Contrasenita05");
    }

}