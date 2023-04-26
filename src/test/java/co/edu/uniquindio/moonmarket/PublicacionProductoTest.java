package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.PublicacionProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.EstadoPublicacion;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import co.edu.uniquindio.moonmarket.servicios.interfaces.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class PublicacionProductoTest {

    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private CategoriaServicios categoriaServicios;
/*
    @Test
    @Sql("classpath:dataset.sql")
    public void crearPublicacion( ) throws  Exception{
        /*PublicacionProductoDTO publicacionProductoDTO= new PublicacionProductoDTO();
        publicacionProductoDTO.setTitulo("Titulo cualquiera jeje");
        publicacionProductoDTO.setProducto(productoServicio.obtenerProducto(2));
        publicacionProductoDTO.setCantidad(100);
        publicacionProductoDTO.setComentarios(new ArrayList<>());
        publicacionProductoDTO.setImagenes(new ArrayList<>());
        publicacionProductoDTO.setPrecio(10000);
        int codigoPublicacion = publicacionProductoServicio.crearPublicacionProducto(publicacionProductoDTO, "2222220",3);
    }

    @Test
    public void obtenerPublicaciones( ) throws  Exception{
        List<PublicacionProducto> publicaciones = publicacionProductoServicio.obtenerPublicacionesUsuario("2222220");
        for (PublicacionProducto publicacion : publicaciones) {
            System.out.println(publicacion.getIdPublicacionProducto());
        }
    }

    @Test
    public void eliminarPublicacionProducto( ) throws  Exception{
        int eliminado = publicacionProductoServicio.eliminarPublicacionProducto(3);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarPublicacion( ) throws  Exception{
        PublicacionProductoDTO publicacionProductoDTO = new PublicacionProductoDTO();

        publicacionProductoDTO.setTitulo("Mira que cambie el titulo");
        publicacionProductoDTO.setCantidad(200);
        publicacionProductoDTO.setPrecio(3333);

        int actualizado = publicacionProductoServicio.actualizarPublicacionProducto(publicacionProductoDTO, 1, 3);
    }

    @Test
    public void alternarEstadoPublicacion( ) throws  Exception{
        publicacionProductoServicio.alternarEstadoPublicacion(EstadoPublicacion.INACTIVO, 2);
        publicacionProductoServicio.alternarEstadoPublicacion(EstadoPublicacion.DENEGADA, 4);
        publicacionProductoServicio.alternarEstadoPublicacion(EstadoPublicacion.DENEGADA, 3);
    }

    @Test
    public void listarPublicacionesEstado() throws Exception{
        List<PublicacionProducto> publicacionProductos = publicacionProductoServicio.listarPublicacionesEstado(EstadoPublicacion.ACTIVO);
        for (PublicacionProducto publicacionProducto : publicacionProductos) {
            System.out.println(publicacionProducto.getIdPublicacionProducto());
        }
    }

    @Test
    public void listarPublicaciones() throws Exception{
        List<PublicacionProducto> publicacionProductos = publicacionProductoServicio.listarPublicaciones();
        for (PublicacionProducto publicacionProducto : publicacionProductos) {
            System.out.println(publicacionProducto.getIdPublicacionProducto());
        }
    }

    @Test
    public void listarPublicacionesCategoria() throws Exception{
        List<PublicacionProducto> publicacionProductos = publicacionProductoServicio.listarPublicacionesCategoria(categoriaServicios.obtenerCategoria(3).getNombre());
        for (PublicacionProducto publicacionProducto : publicacionProductos) {
            System.out.println(publicacionProducto.getIdPublicacionProducto());
        }
    }

    @Test
    public void listarPublicacionesUsuario() throws Exception {
        List<PublicacionProducto> publicacionProductos = publicacionProductoServicio.listarPublicacionesUsuario("2222220");
        for (PublicacionProducto publicacionProducto : publicacionProductos) {
            System.out.println(publicacionProducto.getIdPublicacionProducto());
        }
    }

    @Test
    public void listarPublicacionesFavoritas() throws Exception {
        List<PublicacionProducto> publicacionProductos = publicacionProductoServicio.listarPublicacionesFavoritas("2222220");
        for (PublicacionProducto publicacionProducto : publicacionProductos) {
            System.out.println(publicacionProducto.getIdPublicacionProducto());
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void agregarFavorito(){
        try {
            publicacionProductoServicio.agregarPublicacionAFavoritos("2222221", 4);
            publicacionProductoServicio.agregarPublicacionAFavoritos("2222221", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    //@Sql("classpath:dataset.sql" )
    public void eliminarPublicacionFavorito(){
        try {
            //System.out.println(publicacionProductoServicio.eliminarPublicacionDeFavoritos("2222222", 2));
            System.out.println(publicacionProductoServicio.eliminarPublicacionDeFavoritos("2222221", 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void buscarPublicaciones(){
        try {
            List<PublicacionProducto> publicacionProductos = publicacionProductoServicio.buscarPublicaciones("Mueble");
            for (PublicacionProducto publicacionProducto:
            publicacionProductos) {
                System.out.println(publicacionProducto.getProducto().getNombre());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

}
