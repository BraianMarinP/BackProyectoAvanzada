package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.CategoriaDTO;
import co.edu.uniquindio.moonmarket.entidades.Categoria;
import co.edu.uniquindio.moonmarket.repositorios.CategoriaRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CategoriaServicios;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaServicioImp implements CategoriaServicios {

    private final CategoriaRepo categoriaRepo;


    @Override
    public int crearCategoria(CategoriaDTO categoriaDTO) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setProductos(categoriaDTO.getProductos());
        return categoriaRepo.save(categoria).getId();
    }

    @Override
    public int actualizarCategoria(String nombreViejo, String nombreNuevo) throws Exception {
        Categoria categoriaVieja = categoriaRepo.buscarCategoria(nombreViejo);
        if(categoriaVieja != null){
            categoriaVieja.setNombre(nombreNuevo);
            return categoriaRepo.save(categoriaVieja).getId();
        } else{
            throw  new Exception("La categoria con nombre: "+nombreViejo+" no existe.");
        }
    }

    @Override
    public Categoria obtenerCategoria(int idCategoria) throws Exception {
        Optional<Categoria> optionalCategoria = categoriaRepo.findById(idCategoria);
        if(optionalCategoria.isPresent()){
            return optionalCategoria.get();
        }else{
            throw new Exception("La compra producto con id "+idCategoria+" no se encuentra en la base de datos.");
        }
    }
}
