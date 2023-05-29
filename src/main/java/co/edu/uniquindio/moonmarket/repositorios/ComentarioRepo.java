package co.edu.uniquindio.moonmarket.repositorios;

import co.edu.uniquindio.moonmarket.entidades.Comentario;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepo extends JpaRepository<Comentario,Integer> {
    @Query("SELECT c FROM Comentario c WHERE c.publicacion.idPublicacionProducto = :idPublicacion")
    List<Comentario> obtenerComentariosPublicacion(int idPublicacion);


}
