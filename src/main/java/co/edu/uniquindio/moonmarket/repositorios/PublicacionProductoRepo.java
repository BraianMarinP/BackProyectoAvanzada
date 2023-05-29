package co.edu.uniquindio.moonmarket.repositorios;

import co.edu.uniquindio.moonmarket.entidades.Categoria;
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

    //@Query("SELECT pp FROM PublicacionProducto pp JOIN pp.producto pro JOIN pro.categorias c WHERE c.nombre = :nombreCategoria AND pp.eliminado = :eliminado AND pp.precio = (SELECT MIN(precio) FROM PublicacionProducto WHERE producto = pro)")
    //PublicacionProducto buscarPublicacionMasBarataCategoria(String nombreCategoria, boolean eliminado);
    //@Query("SELECT MIN(pp.precio) FROM PublicacionProducto pp JOIN pp.producto.categorias c WHERE pp.eliminado =: eliminado AND c.nombre =: nombreCategoria")
    //PublicacionProducto buscarPublicacionMasBarataCategoria(String nombreCategoria, boolean eliminado);

    //@Query("SELECT MAX(pp.precio) FROM PublicacionProducto pp JOIN pp.producto.categorias c WHERE pp.eliminado =: eliminado AND c.nombre =: nombreCategoria")
    //PublicacionProducto buscarPublicacionMasCaraCategoria(String nombreCategoria, boolean eliminado);

    //@Query("SELECT p FROM PublicacionProducto p JOIN p.producto pr JOIN pr.categorias c WHERE c.nombre = :nombreCategoria AND p.eliminado = :eliminado AND p.precio = (SELECT MAX(precio) FROM PublicacionProducto WHERE producto = pr)")
    //PublicacionProducto buscarPublicacionMasCaraCategoria(String nombreCategoria, boolean eliminado);

    //@Query("SELECT p from PublicacionProducto p where  MIN(p.precio)  IN(SELECT DISTINCT p FROM PublicacionProducto p JOIN p.producto pr JOIN pr.categorias c WHERE c.nombre = :nombreCategoria AND p.eliminado =:eliminado)")
    //PublicacionProducto buscarPublicacionMasBarataCategoria(String nombreCategoria, boolean eliminado);

    //@Query("SELECT p from PublicacionProducto p where MAX(p.precio)  IN(SELECT DISTINCT p FROM PublicacionProducto p JOIN p.producto pr JOIN pr.categorias c WHERE c.nombre = :nombreCategoria AND p.eliminado =:eliminado)")
    //PublicacionProducto buscarPublicacionMasCaraCategoria(String nombreCategoria, boolean eliminado,int idCategoria);

    //@Query("delete from PublicacionProducto p where p.idPublicacionProducto =:idPublicacion AND join")
    //voideliminarFavoritos(String cedulaUsuario, int idPublicacion);

    @Query("SELECT pp FROM PublicacionProducto pp JOIN pp.producto pr JOIN pr.categorias c WHERE c.nombre = :nombreCategoria AND pp.eliminado = :eliminado AND pp.precio = (SELECT MIN(pp2.precio) FROM PublicacionProducto pp2 join pp2.producto pr3 join pr3.categorias c2 WHERE c2.nombre = :nombreCategoria AND pp2.eliminado = :eliminado )")
    List<PublicacionProducto> buscarPublicacionMasBarataCategoria(String nombreCategoria, boolean eliminado);


    @Query("SELECT pp FROM PublicacionProducto pp JOIN pp.producto pr JOIN pr.categorias c WHERE c.nombre = :nombreCategoria AND pp.eliminado = :eliminado AND pp.precio = (SELECT MAX(pp2.precio) FROM PublicacionProducto pp2 join pp2.producto pr3 join pr3.categorias c2 WHERE c2.nombre = :nombreCategoria AND pp2.eliminado = :eliminado)")
    List<PublicacionProducto> buscarPublicacionMasCaraCategoria(String nombreCategoria, boolean eliminado);





}
