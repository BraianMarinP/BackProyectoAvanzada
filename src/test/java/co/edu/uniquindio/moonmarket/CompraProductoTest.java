package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.CompraProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.Compra;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CompraProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class CompraProductoTest {

    @Autowired
    private CompraProductoServicio compraProductoServicio;

    @Autowired
    private CompraServicio compraServicio;

    @Autowired
    private PublicacionProductoServicio publicacionProductoServicio;

/*
    @Test
    //@Sql("classpath:dataset.sql" )
    public void registrarCompraProducto(){
        try{
            CompraProductoDTO compraProductoDTO= new CompraProductoDTO();
            compraProductoDTO.setCantidad(100);
            compraProductoDTO.setCompra(compraServicio.obtenerCompra(1));
            compraProductoDTO.setPublicacionProductoCompra(publicacionProductoServicio.obtenerPublicacionProducto(1));

            int codigoCompraProducto= compraProductoServicio.crearCompraProducto(compraProductoDTO);

        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

}
