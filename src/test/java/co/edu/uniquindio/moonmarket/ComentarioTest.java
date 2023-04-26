package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.*;
import co.edu.uniquindio.moonmarket.servicios.interfaces.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ComentarioTest {


    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private ImagenServicio imagenServicio;
    @Autowired
    private CategoriaServicios categoriaServicio;
    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private ComentarioServicio comentarioServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void registrarComentario(){
        try {
            ComentarioDTO comentarioDTO= new ComentarioDTO();
            comentarioDTO.setDescripcion("Este es un comentario cualqueira a esta publicacion.");
            comentarioDTO.setPuntuacion(4.6f);
            comentarioDTO.setIdPublicacion(2);
            comentarioDTO.setCedulaUsuario("2222220");
            int codigoComentario= comentarioServicio.crearComentario(comentarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void actualizarComentario(){
        try {
            ComentarioDTO comentarioDTO= new ComentarioDTO();

            comentarioDTO.setId(1);
            comentarioDTO.setPuntuacion(5.0f);
            comentarioDTO.setDescripcion("Comentario bien melito modificado");
            /*
            comentarioDTO.setPublicacionProductoComentario(publicacionProductoServicio.obtenerPublicacionProducto(1));
            comentarioDTO.setDescripcion("Uy socio, esto es lo más chimba que he comprado en mi puta vida; se la sacó y la puso encima de la mesa mi bro.");
            comentarioDTO.setUsuario(usuarioServicio.obtener("2222220"));
            */

            int idComentario=comentarioServicio.actualizarComentario(comentarioDTO);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void eliminarComentario(){

        try {

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
