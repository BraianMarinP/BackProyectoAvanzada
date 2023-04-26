package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.CompraDTO;
import co.edu.uniquindio.moonmarket.entidades.Compra;
import co.edu.uniquindio.moonmarket.entidades.CompraProducto;
import co.edu.uniquindio.moonmarket.entidades.MedioPago;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import co.edu.uniquindio.moonmarket.servicios.interfaces.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class CompraTest {

    @Autowired
    private CompraServicio compraServicio;
    @Autowired
    private CompraProductoServicio compraProductoServicio;
    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

/*
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCompra() {
        try {
            //Simulamos un hashmap con las publicaciones que haya seleccionado el usuario
            HashMap<Integer, Integer> publicacionUnidades = new HashMap<>();
            publicacionUnidades.put(2, 5);
            publicacionUnidades.put(3, 1);
            publicacionUnidades.put(4, 4);
            //Creamos el DTO
            CompraDTO compraDTO = new CompraDTO();
            compraDTO.setUsuario(usuarioServicio.obtener("2222220"));
            compraDTO.setMedioPago(MedioPago.PAYPAL);
            int codigoCompra = compraServicio.crearCompra(compraDTO, publicacionUnidades);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerComprasUsuario() {
        try {
            //Simulamos un hashmap con las publicaciones que haya seleccionado el usuario
            List<Compra> compras = compraServicio.obtenerComprasUsuario("2222220");
            for (Compra compra: compras) {
                System.out.println(compra.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}

