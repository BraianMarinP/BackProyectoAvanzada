package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.entidades.Usuario;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ProductoFavoritoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoFavoritoServicioImpl implements ProductoFavoritoServicio {

    private final UsuarioServicioImp usuarioServicioImp;
    private final PublicacionProductoServicioImp publicacionProductoServicioImp;
    private final UsuarioRepo usuarioRepo;

    @Override
    public String agregarFavorito(String cedula, int idPublicacion) throws Exception {
        //Usuario usuario = usuarioServicioImp.obtener(cedula);
        return "";
    }

    @Override
    public String eliminarFavorito(String cedula, int idPublicacion) throws Exception {
        Usuario usuario = usuarioServicioImp.obtener(cedula);
        if(usuario.getFavoritos().isEmpty()){
            throw new Exception("El usuario no tiene lista de favoritos para agregar más -ProductoFavoritoServicio-");
        }
        usuario.getFavoritos().remove(publicacionProductoServicioImp.obtenerPublicacionProducto(idPublicacion));

        return usuarioRepo.save(usuario).getCedula();
    }
}
