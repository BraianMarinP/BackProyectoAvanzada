package co.edu.uniquindio.moonmarket.repositorios;

import co.edu.uniquindio.moonmarket.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepo extends JpaRepository<Categoria,Integer> {


    @Query("select c from Categoria c where c.nombre = :nombre")
    Categoria buscarCategoria(String nombre);


    @Query("select c.nombre, count(p) from Categoria c join c.productos p group by c.nombre")
    List<Object[]> cantidadProductosCategoria();

}
