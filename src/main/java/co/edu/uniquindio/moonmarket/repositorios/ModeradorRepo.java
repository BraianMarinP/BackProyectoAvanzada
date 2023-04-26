package co.edu.uniquindio.moonmarket.repositorios;

import co.edu.uniquindio.moonmarket.entidades.Moderador;
import co.edu.uniquindio.moonmarket.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeradorRepo extends JpaRepository<Moderador,String> {
    @Query("select m from Moderador m where m.email = :correo")
    Moderador buscarModerador(String correo);
}
