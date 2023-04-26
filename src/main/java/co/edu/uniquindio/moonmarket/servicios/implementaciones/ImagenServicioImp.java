package co.edu.uniquindio.moonmarket.servicios.implementaciones;

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
    public String crearImagenUsuario(ImagenUsuarioDTO imagenUsuarioDTO) throws Exception {
        Imagen imagen= new Imagen();

        Map<String,String> respuesta =  cloudinaryServicio.subirImagen(new File(imagenUsuarioDTO.getUrl()),"MoonMarket");
        String public_id = (String) respuesta.get("public_id");
        String format = (String) respuesta.get("format");
        String url = String.format("https://res.cloudinary.com/dljinqrho/image/upload/%s.%s", public_id, format);
        imagen.setId(public_id);
        imagen.setUrl(url);
        imagen.setUsuario(usuarioRepo.findById(imagenUsuarioDTO.getCedulaUsuario()).get());
        return imagenRepo.save(imagen).getId();


    }

    @Override
    public String crearImagenModerador(ImagenModeradorDTO imagenModeradorDTO) throws Exception {
        Imagen imagen= new Imagen();

        Map<String,String> respuesta =  cloudinaryServicio.subirImagen(new File(imagenModeradorDTO.getUrl()),"MoonMarket");

        String public_id = (String) respuesta.get("public_id");
        String format = (String) respuesta.get("format");

        String url = String.format("https://res.cloudinary.com/dljinqrho/image/upload/%s.%s", public_id, format);

        imagen.setId(public_id);
        imagen.setUrl(url);
        imagen.setModerador(moderadorRepo.findById(imagenModeradorDTO.getCedulaModerador()).get());
        return imagenRepo.save(imagen).getId();
    }

    @Override
    public String crearImagenProducto(ImagenProductoDTO imagenProductoDTO) throws Exception {
        Imagen imagen= new Imagen();

        Map<String,String> respuesta =  cloudinaryServicio.subirImagen(new File(imagenProductoDTO.getUrl()),"MoonMarket");
        String public_id = (String) respuesta.get("public_id");
        String format = (String) respuesta.get("format");
        String url = String.format("https://res.cloudinary.com/dljinqrho/image/upload/%s.%s", public_id, format);
        imagen.setId(public_id);
        imagen.setUrl(url);
        imagen.setPublicacion(publicacionProductoRepo.findById(imagenProductoDTO.getIdPublicacion()).get());
        return imagenRepo.save(imagen).getId();
    }

    @Override
    public String eliminarImagen(String id) throws Exception {
        validarExiste(id);
        cloudinaryServicio.eliminarImagen(id);
        imagenRepo.deleteById(id);
        return id;
    }

    private void validarExiste(String id) throws Exception{
        boolean existe = imagenRepo.existsById(id);
        if( !existe ){
            throw new Exception("El código "+id+" no está asociado a ninguna imagen");
        }

    }
}
