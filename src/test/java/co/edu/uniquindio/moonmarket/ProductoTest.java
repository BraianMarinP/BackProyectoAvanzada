package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.*;
import co.edu.uniquindio.moonmarket.entidades.*;
import co.edu.uniquindio.moonmarket.repositorios.CategoriaRepo;
import co.edu.uniquindio.moonmarket.repositorios.ImagenRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest

public class ProductoTest {

    @Autowired
    private ProductoServicio productoServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private CategoriaServicios categoriaServicio;

    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

    @Autowired
    private ImagenServicio imagenServicio;

    @Test
    //@Sql("classpath:dataset.sql" )
    public void registrarProducto()throws Exception {
        //List<Categoria> listaCategoria = new ArrayList<>();
        //listaCategoria.add(categoriaServicio.obtenerCategoria(1));
        //ProductoDTO productoDTO = new ProductoDTO(0,"Computador Asus 1", "Es el mejor computador portatil que el dinero pueda comprar", listaCategoria, new ArrayList<>());
        //Se llama el servicio para crear el producto
        //int codigoProducto = productoServicio.crearProducto(productoDTO);

    }

    @Test
    public void listarProductos(){

    }
}
