package co.edu.uniquindio.moonmarket.servicios.interfaces;

import co.edu.uniquindio.moonmarket.dto.ImagenDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public interface CloudinaryServicio {
    Map subirImagen(File file, String carpeta) throws Exception;
    Map eliminarImagen(ImagenDTO imagen) throws Exception;
    File convertir(MultipartFile imagen) throws IOException;
}
