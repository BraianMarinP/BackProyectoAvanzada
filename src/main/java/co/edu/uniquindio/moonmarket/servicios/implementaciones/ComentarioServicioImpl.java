package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.ComentarioDTO;
import co.edu.uniquindio.moonmarket.dto.CompraDTO;
import co.edu.uniquindio.moonmarket.dto.CompraProductoDTO;
import co.edu.uniquindio.moonmarket.dto.EmailDTO;
import co.edu.uniquindio.moonmarket.entidades.Comentario;
import co.edu.uniquindio.moonmarket.entidades.Compra;
import co.edu.uniquindio.moonmarket.entidades.CompraProducto;
import co.edu.uniquindio.moonmarket.repositorios.ComentarioRepo;
import co.edu.uniquindio.moonmarket.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.EmailServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ComentarioServicioImpl implements ComentarioServicio {

    private final ComentarioRepo comentarioRepo;
    private final PublicacionProductoRepo publicacionProductoRepo;
    private final UsuarioRepo usuarioRepo;


    @Autowired
    private EmailServicio emailServicio;


    @Override
    public List<ComentarioDTO> listarComentarios(int idPublicacion){
        List<ComentarioDTO> comentariosDTO = new ArrayList<>();
        List<Comentario> comentarios = comentarioRepo.obtenerComentariosPublicacion(idPublicacion);
        for (Comentario c: comentarios) {
            comentariosDTO.add(convertirDTO(c));
        }
        return comentariosDTO;
    }



    private ComentarioDTO convertirDTO(Comentario comentario){
        ComentarioDTO comentarioDTO = new ComentarioDTO();
        comentarioDTO.setId(comentario.getId());
        comentarioDTO.setPuntuacion(comentario.getPuntuacion());
        comentarioDTO.setDescripcion(comentario.getDescripcion());
        comentarioDTO.setCedulaUsuario(comentario.getUsuario().getNombre());
        comentarioDTO.setIdPublicacion(comentario.getPublicacion().getIdPublicacionProducto());
        return  comentarioDTO;
    }



    @Override
    public int crearComentario(ComentarioDTO comentarioDTO) throws Exception {
        Comentario comentario= new Comentario();
        comentario.setDescripcion(comentarioDTO.getDescripcion());
        comentario.setFecha(LocalDate.now());
        comentario.setPuntuacion(comentarioDTO.getPuntuacion());
        comentario.setPublicacion(publicacionProductoRepo.findById(comentarioDTO.getIdPublicacion()).get());
        comentario.setUsuario(usuarioRepo.findById(comentarioDTO.getCedulaUsuario()).get());
        return comentarioRepo.save(comentario).getId();
    }

    @Override
    public int actualizarComentario(ComentarioDTO comentarioDTO) throws Exception {
        Optional<Comentario> optionalComentario = comentarioRepo.findById(comentarioDTO.getId());
        if(optionalComentario.isPresent()){
            Comentario comentario = optionalComentario.get();
            comentario.setDescripcion(comentarioDTO.getDescripcion());
            comentario.setFecha(LocalDate.now());
            comentario.setPuntuacion(comentarioDTO.getPuntuacion());
            comentario.setPublicacion(publicacionProductoRepo.findById(comentarioDTO.getIdPublicacion()).get());
            comentario.setUsuario(usuarioRepo.findById(comentarioDTO.getCedulaUsuario()).get());
            int codigoComentario=comentarioRepo.save(comentario).getId();
            emailServicio.enviarEmail(new EmailDTO("Comentario en la publicación con id "+comentario.getPublicacion().getIdPublicacionProducto()+" del producto "+comentario.getPublicacion().getProducto().getNombre(),
                    comentarioDTO.getDescripcion(),
                    usuarioRepo.findById(comentarioDTO.getCedulaUsuario()).get().getEmail()));
            return codigoComentario;
        }else{
            throw new Exception("No se ha podido actualizar el comentario");
        }

    }

    @Override
    public int eliminarComentario(ComentarioDTO comentarioDTO) throws Exception{

        Optional<Comentario> optionalComentario = comentarioRepo.findById(comentarioDTO.getId());
        if(optionalComentario.isPresent()){
            comentarioRepo.deleteById(comentarioDTO.getId());
            return comentarioDTO.getId();
        }else{
            throw new Exception("No se ha podido eliminar el comentario");
        }
    }

    private ComentarioDTO convertir(Comentario comentario){

        return null;

    }

}
