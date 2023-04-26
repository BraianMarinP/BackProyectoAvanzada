package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.CategoriaDTO;
import co.edu.uniquindio.moonmarket.dto.ProductoDTO;
import co.edu.uniquindio.moonmarket.entidades.Categoria;
import co.edu.uniquindio.moonmarket.entidades.Producto;
import co.edu.uniquindio.moonmarket.repositorios.CategoriaRepo;
import co.edu.uniquindio.moonmarket.repositorios.ProductoRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServicioImp implements ProductoServicio {
    private final ProductoRepo productoRepo;
    private final UsuarioServicio usuarioServicio;
    private final CategoriaRepo categoriaRepo;

    @Override
    public int crearProducto(ProductoDTO productoDTO) throws Exception {

        Producto producto = new Producto();
        producto.setNombre( productoDTO.getNombre() );
        producto.setId(productoDTO.getId());
        producto.setDescripcion( productoDTO.getDescripcion() );
        producto.setPublicaciones(null);
        return productoRepo.save( producto ).getId();
    }

    @Override
    public int modificarProducto(ProductoDTO productoDTO) throws Exception {

        Optional<Producto> productoEncontrado = productoRepo.findById(productoDTO.getId());
        if(productoEncontrado.isPresent()){
            Producto productoModificar = productoEncontrado.get();
            productoModificar.setNombre(productoDTO.getNombre());
            productoModificar.setDescripcion(productoDTO.getDescripcion());
            productoModificar.getCategorias().clear();
            List<Categoria> categorias = new ArrayList<>();

            for (CategoriaDTO cat:
                 productoDTO.getCategorias()) {
                categorias.add(categoriaRepo.buscarCategoria(cat.getNombre()));
            }
            productoModificar.setCategorias(categorias);
            return productoRepo.save(productoModificar).getId();
        }else{
            throw new Exception("El producto con id " + productoDTO.getId() + " no se ha podido modificar. (Puede no existir)");
        }
    }

    @Override
    public int eliminarProducto(ProductoDTO productoDTO) throws Exception {

        return 0;
    }

    @Override
    public Producto obtenerProducto(int idProducto) throws Exception {
        Optional<Producto> producto = productoRepo.findById(idProducto);
        if(!producto.isPresent()){
            throw new Exception("No existe el producto con la id  " + idProducto);
        }
        return producto.get();
    }


}
