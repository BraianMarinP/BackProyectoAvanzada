package co.edu.uniquindio.moonmarket.repositorios;

import co.edu.uniquindio.moonmarket.entidades.Producto;
import co.edu.uniquindio.moonmarket.entidades.PublicacionProducto;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {

    @Query("select u from Usuario u where u.email = :correo")
    Usuario buscarUsuario(String correo);

    @Query("select distinct cp.publicacion from CompraProducto cp where cp.compra.usuario.cedula = :cedula")
    List<PublicacionProducto> listarProductosComprados(String cedula);



}
