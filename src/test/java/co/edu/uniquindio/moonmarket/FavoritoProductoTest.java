package co.edu.uniquindio.moonmarket;


import co.edu.uniquindio.moonmarket.servicios.implementaciones.ProductoFavoritoServicioImpl;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class FavoritoProductoTest {

    /*
    @Autowired
    private ProductoFavoritoServicioImpl favoritoProductoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

    @Test
   // @Sql("classpath:dataset.sql" )
    public void agregarAFavoritos(){
        try {
            FavoritoProductoDTO favoritoProductoDTO = new FavoritoProductoDTO();
            favoritoProductoDTO.setUsuario(usuarioServicio.obtener("2222220"));
            favoritoProductoDTO.setPublicacionProductoFavorito(publicacionProductoServicio.obtenerPublicacionProducto(2));
            favoritoProductoServicio.agregarFavorito(favoritoProductoDTO);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
*/
}
