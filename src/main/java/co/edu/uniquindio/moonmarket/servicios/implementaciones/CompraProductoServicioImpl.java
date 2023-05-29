package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.CompraProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.CompraProducto;
import co.edu.uniquindio.moonmarket.repositorios.CompraProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.CompraRepo;
import co.edu.uniquindio.moonmarket.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CompraProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompraProductoServicioImpl implements CompraProductoServicio {

    private final CompraProductoRepo compraProductoRepo;
    private final CompraRepo compraRepo;
    private final PublicacionProductoRepo publicacionProductoRepo;

    @Override
    public int crearCompraProducto(CompraProductoDTO compraProductoDTO) throws Exception {
        CompraProducto nuevoDetalle = new CompraProducto();
        //nuevoDetalle.setCompra(compraRepo.findById(compraProductoDTO.getIdCompra()).get());
        nuevoDetalle.setPublicacion(publicacionProductoRepo.findById(compraProductoDTO.getIdPublicacion()).get());
        nuevoDetalle.setCantidad(compraProductoDTO.getCantidad());
        return compraProductoRepo.save(nuevoDetalle).getIdCompraProducto();
    }

    @Override
    public CompraProducto obtenerCompraProducto(int idCompraProducto) throws Exception {
        Optional<CompraProducto> compraProductoEncontrada= compraProductoRepo.findById(idCompraProducto);
        if(compraProductoEncontrada.isPresent()){
            return compraProductoEncontrada.get();
        }else{
            throw new Exception("La compra producto con id "+idCompraProducto+" no se encuentra en la base de datos.");
        }

    }
}
