package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.CategoriaDTO;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CategoriaServicios;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class CategoriaTest {

    @Autowired
    private CategoriaServicios categoriaServicio;

    @Test
     @Sql("classpath:dataset.sql" )
    public void registrarCategoria() {
        try {

            //Se crea la categoría del producto
            CategoriaDTO categoria = new CategoriaDTO();
            categoria.setNombre("Pendeja varias");
            int categoriaId = categoriaServicio.crearCategoria(categoria);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql" )
    public void actualizarCategoria() {
        try {
            String nombreViejo = "Muebles";
            String nombreNuevo = "Muebles_v2";
            int categoriaId = categoriaServicio.actualizarCategoria(nombreViejo, nombreNuevo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    @Sql("classpath:dataset.sql" )
    public void eliminarCategoria() {
        try {
            String nombre = "Cocina";
            //int categoriaId = categoriaServicio.eliminarCategoria(nombre);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}