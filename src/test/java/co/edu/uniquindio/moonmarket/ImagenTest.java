package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.ImagenModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenProductoDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenUsuarioDTO;
import co.edu.uniquindio.moonmarket.servicios.interfaces.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ImagenTest {

    @Autowired
    private ImagenServicio imagenServicio;

    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

    @Autowired
    private ModeradorServicio moderadorServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Test
    @Sql("classpath:dataset.sql" )
    public void crearImagenPublicacion(){
        try{
            ImagenProductoDTO imagenPublicacion = new ImagenProductoDTO();

            imagenPublicacion.setUrl("/home/brahian/Desktop/imagen.jpg");

            //imagenPublicacion.setPublicacionProductoImagen(publicacionProductoServicio.obtenerPublicacionProducto(1));
            String imagenProducto = imagenServicio.crearImagenProducto(imagenPublicacion);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void crearImagenModerador(){
        try{
            ImagenModeradorDTO imagenModeradorDTO = new ImagenModeradorDTO();
            imagenModeradorDTO.setUrl("/home/brahian/Desktop/images.jpeg");
            //imagenModeradorDTO.setModerador(moderadorServicio.buscarModerador("1234589"));
            String imagenModerador = imagenServicio.crearImagenModerador(imagenModeradorDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    // @Sql("classpath:dataset.sql" )
    public void crearImagenUsuario(){
        try{
            ImagenUsuarioDTO imagenUsuarioDTO = new ImagenUsuarioDTO();
            imagenUsuarioDTO.setUrl("/home/brahian/Desktop/im.jpg");
            //imagenUsuarioDTO.setUsuarioImagen(usuarioServicio.obtener("2222220"));
            String imagenUsuario = imagenServicio.crearImagenUsuario(imagenUsuarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void eliminarImagen(){
        try{
            imagenServicio.eliminarImagen("uniquindio/MoonMarket/qpdpiz97zpio7i0imdih");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void cambiarContrasena() throws  Exception{

        String cedulaModerador= moderadorServicio.cambiarContrasena("2222220","Contrasenita05");
    }
}
