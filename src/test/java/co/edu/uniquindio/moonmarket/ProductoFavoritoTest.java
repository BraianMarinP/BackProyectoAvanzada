package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.servicios.interfaces.ProductoFavoritoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ProductoFavoritoTest {

    @Autowired
    private ProductoFavoritoServicio productoFavoritoServicio;

    @Test
    // @Sql("classpath:dataset.sql" )
    public void eliminarFavorito() throws Exception {
        productoFavoritoServicio.eliminarFavorito("2222221", 4);
    }

}