package co.edu.uniquindio.moonmarket.repositorios;

import co.edu.uniquindio.moonmarket.entidades.EstadoPublicacion;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionProductoRepo extends JpaRepository<PublicacionProducto,Integer> {
    @Query("SELECT p FROM PublicacionProducto p WHERE p.creador.cedula = :cedula AND p.eliminado =:eliminado")
    List<PublicacionProducto> obtenerPublicacionesUsuario(String cedula, boolean eliminado);
    @Query("SELECT p FROM PublicacionProducto p WHERE p.estado = :estado AND p.eliminado =:eliminado")
    List<PublicacionProducto> listarPublicacionesEstado(EstadoPublicacion estado, boolean eliminado);
    @Query("SELECT DISTINCT p FROM PublicacionProducto p JOIN p.producto pr JOIN pr.categorias c WHERE c.nombre = :nombreCategoria AND p.eliminado =:eliminado")
    List<PublicacionProducto> listarPublicacionesCategoria(String nombreCategoria, boolean eliminado);
    @Query("SELECT p FROM PublicacionProducto p WHERE p.creador.cedula =:cedulaUsuario AND p.estado = :activo AND p.eliminado =:eliminado")
    List<PublicacionProducto> listarPublicacionesUsuario(String cedulaUsuario, EstadoPublicacion activo, boolean eliminado);
    @Query("SELECT p FROM PublicacionProducto p JOIN p.favoriteros pf WHERE p.estado =:activo AND p.eliminado = :eliminado AND pf.cedula =:cedulaUsuario")
    List<PublicacionProducto> listarPublicacionesFavoritas(String cedulaUsuario, EstadoPublicacion activo, boolean eliminado);
    @Query("SELECT p FROM PublicacionProducto p JOIN p.producto pP WHERE p.estado =:activo AND p.eliminado = :eliminado AND pP.nombre =:nombreProducto")
    List<PublicacionProducto> buscarPublicaciones(String nombreProducto, EstadoPublicacion activo, boolean eliminado);
    //@Query("delete from PublicacionProducto p where p.idPublicacionProducto =:idPublicacion AND join")
    //voideliminarFavoritos(String cedulaUsuario, int idPublicacion);
}
