package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.CategoriaDTO;
import co.edu.uniquindio.moonmarket.entidades.Categoria;
import co.edu.uniquindio.moonmarket.repositorios.CategoriaRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CategoriaServicios;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoriaServicioImp implements CategoriaServicios {

    private final CategoriaRepo categoriaRepo;



    @Override
    public List<CategoriaDTO> listarCategorias (){
        List<Categoria> categorias = categoriaRepo.findAll();
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();
        for (Categoria c: categorias) {
           categoriasDTO.add(convertirCategoriaDTO(c));
        }
        return categoriasDTO;
    }


    @Override
    public int crearCategoria(CategoriaDTO categoriaDTO) throws Exception {
        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        //categoria.setProductos(categoriaDTO.getProductos());
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

    public Categoria convertir(CategoriaDTO categoriaDTO){
        return categoriaRepo.buscarCategoria(categoriaDTO.getNombre());
    }

    public CategoriaDTO convertirCategoriaDTO(Categoria categoria){
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setNombre(categoria.getNombre());
        return categoriaDTO;
    }

    public List<Object[]> cantidadProductosCategoria(){
        return categoriaRepo.cantidadProductosCategoria();
    }
}
