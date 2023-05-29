package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.ImagenDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenProductoDTO;
import co.edu.uniquindio.moonmarket.dto.ImagenUsuarioDTO;
import co.edu.uniquindio.moonmarket.entidades.Imagen;
import co.edu.uniquindio.moonmarket.repositorios.ImagenRepo;
import co.edu.uniquindio.moonmarket.repositorios.ModeradorRepo;
import co.edu.uniquindio.moonmarket.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CloudinaryServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ImagenServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
@AllArgsConstructor
public class ImagenServicioImp implements ImagenServicio {

    private final ImagenRepo imagenRepo;
    private final UsuarioRepo usuarioRepo;
    private final ModeradorRepo moderadorRepo;
    private final PublicacionProductoRepo publicacionProductoRepo;

    @Autowired
    private CloudinaryServicio cloudinaryServicio;
    @Override
    public Map<String, String> crearImagenUsuario(File imagenSubir, String cedulaUsuario) throws Exception {
        Imagen imagen = new Imagen();

        Map<String,String> respuesta =  cloudinaryServicio.subirImagen(imagenSubir,"MoonMarket");
        String public_id = (String) respuesta.get("public_id");
        String format = (String) respuesta.get("format");
        String url = String.format("https://res.cloudinary.com/dljinqrho/image/upload/%s.%s", public_id, format);
        imagen.setUrl(url);
        imagen.setUsuario(usuarioRepo.findById(cedulaUsuario).get());
        imagenRepo.save(imagen);

        return respuesta;


    }

    @Override
    public Map<String, String> crearImagenModerador(File imagenSubir, String cedulaModerador) throws Exception {
        Imagen imagen= new Imagen();

        Map<String,String> respuesta =  cloudinaryServicio.subirImagen(imagenSubir,"MoonMarket");

        String public_id = (String) respuesta.get("public_id");
        String format = (String) respuesta.get("format");

        String url = String.format("https://res.cloudinary.com/dljinqrho/image/upload/%s.%s", public_id, format);
        imagen.setUrl(url);
        imagen.setModerador(moderadorRepo.findById(cedulaModerador).get());
        imagenRepo.save(imagen);
        return respuesta;
    }

    @Override
    public String crearImagenProducto(File imagenSubir, int idPublicacion) throws Exception {
        Imagen imagen= new Imagen();
        Map<String,String> respuesta =  cloudinaryServicio.subirImagen(imagenSubir,"MoonMarket");
        String public_id = (String) respuesta.get("public_id");
        String format = (String) respuesta.get("format");
        String url = String.format("https://res.cloudinary.com/dljinqrho/image/upload/%s.%s", public_id, format);
        imagen.setUrl(url);
        //imagen.setPublicacion(publicacionProductoRepo.findById(idPublicacion).get());
        imagenRepo.save(imagen);
        return url;
    }

    @Override
    public String eliminarImagen(String idIimagen) throws Exception {
        validarExiste(idIimagen);
       // cloudinaryServicio.eliminarImagen(imagen);
        imagenRepo.deleteById(idIimagen);
        return idIimagen;
    }

    private void validarExiste(String id) throws Exception{
        boolean existe = imagenRepo.existsById(id);
        if( !existe ){
            throw new Exception("El código "+id+" no está asociado a ninguna imagen");
        }

    }
}
