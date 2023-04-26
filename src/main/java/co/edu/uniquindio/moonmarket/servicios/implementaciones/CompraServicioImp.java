package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.CompraDTO;
import co.edu.uniquindio.moonmarket.dto.CompraProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.Compra;
import co.edu.uniquindio.moonmarket.entidades.CompraProducto;
import co.edu.uniquindio.moonmarket.repositorios.CompraRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CompraProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class CompraServicioImp implements CompraServicio {

    private final CompraRepo compraRepo;
    private final PublicacionProductoServicioImp publicacionProductoServicioImp;
    private final CompraProductoServicio compraProductoServicio;

    private final UsuarioServicio usuarioServicio;

    @Override
    public int crearCompra(CompraDTO compraDTO, HashMap<Integer, Integer> publicacionUnidades) throws Exception {

        //Creamos una nueva compra
        Compra compra = new Compra();
        compra.setFecha(LocalDate.now());
        compra.setMedioPago(compraDTO.getMedioPago());
        compra.setUsuario( usuarioServicio.obtener(compraDTO.getCodigoUsuario()) );
        compra.setValorTotal(calcularTotal(publicacionUnidades));
        /*
        Guardamos la compra para luego asociarla a la lista de productos (CompraProducto)
        ya que primero se necesita una compra y una publicacion para poder crear un registro de CompraProducto
         */
        int idCompra = compraRepo.save(compra).getId();
        /*
        Ahora es cuando asociamos las CompraProducto con compra por cada producto (publicacion)
        que se compró
         */
        for (Map.Entry<Integer, Integer> entry : publicacionUnidades.entrySet()) {
            Integer idPublicacion = entry.getKey();
            Integer unidades = entry.getValue();
            CompraProductoDTO compraProductoDTO = new CompraProductoDTO();
            compraProductoDTO.setIdPublicacion(idPublicacion);
            compraProductoDTO.setCantidad(unidades);
            compraProductoServicio.crearCompraProducto(compraProductoDTO);
        }
        descontarUnidadesPublicacion(publicacionUnidades);
        return idCompra;
    }

    private float calcularTotal(HashMap<Integer, Integer> publicacionUnidades) throws Exception {
        float total = 0;
        for (Map.Entry<Integer, Integer> entry : publicacionUnidades.entrySet()) {
            Integer idPublicacion = entry.getKey();
            Integer unidades = entry.getValue();
            total += unidades * publicacionProductoServicioImp.obtenerPublicacionProducto(idPublicacion).getPrecio();
        }
        return total;
    }

    private void descontarUnidadesPublicacion(HashMap<Integer, Integer> publicacionUnidades) throws Exception {
        for (Map.Entry<Integer, Integer> entry : publicacionUnidades.entrySet()) {
            Integer idPublicacion = entry.getKey();
            Integer unidades = entry.getValue();
            publicacionProductoServicioImp.descontarUnidadesPublicacion(idPublicacion, unidades);
        }
    }

    private float calcularValorTotal(List<CompraProducto> compraProductoList) {
        float valorTotal = 0;
        for (int i = 0; i < compraProductoList.size(); i++) {
            valorTotal += compraProductoList.get(i).getCantidad() * compraProductoList.get(i).getPublicacion().getPrecio();
        }
        return valorTotal;
    }

    @Override
    public CompraDTO obtenerCompra(int idCompra) throws Exception {
        Optional<Compra> compraEncontrada = compraRepo.findById(idCompra);
        if (compraEncontrada.isPresent()) {
            return convertir ( compraEncontrada.get() );
        } else {
            throw new Exception("La compra con id " + idCompra + " no se encuentra en la base de datos.");
        }
    }

    @Override
    public List<CompraDTO> obtenerComprasUsuario(String cedulaUsuario) throws Exception {
        List<Compra> compras = compraRepo.obtenerComprasUsuario(cedulaUsuario);
        List<CompraDTO> comprasDTO = new ArrayList<>();
        for (Compra com:
             compras) {
        comprasDTO.add(convertir(com));
        }
        return comprasDTO;
    }

    private CompraDTO convertir(Compra compra){

        List<CompraProductoDTO> lista = new ArrayList<>();

        for(CompraProducto cp : compra.getProductos()){
            lista.add( new CompraProductoDTO(cp.getCantidad(), cp.getPublicacion().getIdPublicacionProducto(), cp.getCompra().getId()));
        }

        return new CompraDTO(
                compra.getValorTotal(),
                compra.getMedioPago(),
                lista,
                compra.getUsuario().getCedula()
        );

    }

    /*
    private void descontarUnidadesPublicacion(Compra compra) throws Exception {

        for (CompraProducto compraProducto : compra.getProductos()) {
            int unidadesDescontar = compraProducto.getCantidad();
            int idPublicacionProducto = compraProducto.getPublicacion().getIdPublicacionProducto();
            publicacionProductoServicioImp.descontarUnidadesPublicacion(idPublicacionProducto, unidadesDescontar);
        }
    }*/
}
