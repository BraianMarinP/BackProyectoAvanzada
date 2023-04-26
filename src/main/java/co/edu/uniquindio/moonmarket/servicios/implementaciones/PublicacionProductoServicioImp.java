package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.PublicacionProductoDTO;
import co.edu.uniquindio.moonmarket.dto.UsuarioDTO;
import co.edu.uniquindio.moonmarket.entidades.*;
import co.edu.uniquindio.moonmarket.repositorios.ImagenRepo;
import co.edu.uniquindio.moonmarket.repositorios.ProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PublicacionProductoServicioImp implements PublicacionProductoServicio {

    private final PublicacionProductoRepo publicacionProductoRepo;
    private final UsuarioRepo usuarioRepo;
    private final ProductoRepo productoRepo;
    private final ImagenRepo imagenRepo;

    @Override
    public int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, String cedulaCreador, int idProducto) throws Exception {
        PublicacionProducto publicacionProducto= new PublicacionProducto();


        publicacionProducto.setTitulo(publicacionProductoDTO.getTitulo());
        publicacionProducto.setCreador(usuarioRepo.findById(cedulaCreador).get());
        publicacionProducto.setEstado(EstadoPublicacion.INACTIVO);
        publicacionProducto.setEliminado(false);
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setFechaLimite(LocalDateTime.now().plusDays(60));

        List<Imagen> imagenes= new ArrayList<>();

        for (String e:publicacionProductoDTO.getIdImagenes()) {
            imagenes.add(imagenRepo.findById(e).get());
        }

        publicacionProducto.setImagenes(imagenes);
        publicacionProducto.setCantidad(publicacionProductoDTO.getCantidad());

        publicacionProducto.setProducto(productoRepo.findById(idProducto).get());

        return publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();
    }

    @Override
    public PublicacionProducto obtenerPublicacionProducto(int idPublicacion) throws Exception{

        Optional<PublicacionProducto> publicacionProducto = publicacionProductoRepo.findById(idPublicacion);
        if(publicacionProducto.isPresent()){
            return publicacionProducto.get();
        }else{
            throw new Exception("No se ha podido encontrar la publicacion con id " + idPublicacion);
        }

    }

    @Override
    public List<PublicacionProducto> obtenerPublicacionesUsuario(String cedulaUsuario) throws Exception {
        return publicacionProductoRepo.obtenerPublicacionesUsuario(cedulaUsuario, false);
    }

    @Override
    public int actualizarPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, int idPublicacion, int idProducto) throws Exception {
        PublicacionProducto publicacionProducto = obtenerPublicacionProducto(idPublicacion);

        publicacionProducto.setTitulo(publicacionProductoDTO.getTitulo());
        publicacionProducto.setProducto(productoRepo.findById(idProducto).get());
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setCantidad(publicacionProductoDTO.getCantidad());

        return publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();

    }

    @Override
    public int eliminarPublicacionProducto(int idPublicacion) throws Exception {
        PublicacionProducto publicacionProducto = obtenerPublicacionProducto(idPublicacion);
        publicacionProducto.setEliminado(true);
        return publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();
    }

    @Override
    public int alternarEstadoPublicacion(EstadoPublicacion estadoPublicacion, int idPublicacion) throws Exception {
        PublicacionProducto publicacionProducto = obtenerPublicacionProducto(idPublicacion);
        publicacionProducto.setEstado(estadoPublicacion);
        return publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();
    }

    @Override
    public List<PublicacionProductoDTO> listarPublicacionesEstado(EstadoPublicacion estadoPublicacion) throws Exception {
        List<PublicacionProductoDTO>publicacionProductoDTO= new ArrayList<>();

        for(PublicacionProducto e:publicacionProductoRepo.listarPublicacionesEstado(estadoPublicacion, false) ){
            publicacionProductoDTO.add(convertir(e));
        }
        return publicacionProductoDTO;
    }

    @Override
    public List<PublicacionProductoDTO> listarPublicaciones() throws Exception {

        List<PublicacionProductoDTO>publicacionProductoDTO= new ArrayList<>();

        for(PublicacionProducto e:publicacionProductoRepo.findAll()){
            publicacionProductoDTO.add(convertir(e));
        }
        return publicacionProductoDTO;
    }

    @Override
    public List<PublicacionProductoDTO> listarPublicacionesCategoria(String nombreCategoria) throws Exception {
        List<PublicacionProductoDTO>publicacionProductoDTO= new ArrayList<>();

        for(PublicacionProducto e: publicacionProductoRepo.listarPublicacionesCategoria(nombreCategoria, false)) {

            publicacionProductoDTO.add(convertir(e));
        }
        return publicacionProductoDTO;
    }

    @Override
    public List<PublicacionProductoDTO> listarPublicacionesUsuario(String cedulaUsuario) throws Exception {
        List<PublicacionProducto> publicaciones = publicacionProductoRepo.listarPublicacionesUsuario(cedulaUsuario, EstadoPublicacion.ACTIVO, false);
        List<PublicacionProductoDTO> publicacionesDTO = new ArrayList<>();
        for (PublicacionProducto pub:
                publicaciones) {
            publicacionesDTO.add(convertir(pub));
        }
        return publicacionesDTO;
    }

    @Override
    public List<PublicacionProductoDTO> listarPublicacionesFavoritas(String cedulaUsuario) throws Exception {
        List<PublicacionProducto> publicaciones = publicacionProductoRepo.listarPublicacionesFavoritas(cedulaUsuario, EstadoPublicacion.ACTIVO, false);
        List<PublicacionProductoDTO> publicacionesDTO = new ArrayList<>();
        for (PublicacionProducto pub:
                publicaciones) {
            publicacionesDTO.add(convertir(pub));
        }
        return publicacionesDTO;
    }


    @Override
    public int agregarPublicacionAFavoritos(String cedulaUsuario, int idPublicacion) throws Exception {
        Optional<PublicacionProducto> publicacionProductoBuscada = publicacionProductoRepo.findById(idPublicacion);
        if(!publicacionProductoBuscada.isPresent()){
            throw new Exception("No existe la publicacion con id " + idPublicacion);
        }
        PublicacionProducto publicacionProducto = publicacionProductoBuscada.get();
        if(!publicacionProducto.getFavoriteros().contains(usuarioRepo.findById(cedulaUsuario).get())){
            publicacionProducto.getFavoriteros().add(usuarioRepo.findById(cedulaUsuario).get());
        }
        publicacionProductoRepo.save(publicacionProducto);
        return idPublicacion;
    }


    @Override
    public int eliminarPublicacionDeFavoritos(String cedulaUsuario, int idPublicacion) throws Exception {
        Optional<PublicacionProducto> publicacionProductoBuscada = publicacionProductoRepo.findById(idPublicacion);
        if(!publicacionProductoBuscada.isPresent()){
            throw new Exception("No existe la publicacion con id " + idPublicacion);
        }
        PublicacionProducto publicacionProducto = publicacionProductoBuscada.get();
        for (Usuario user: publicacionProducto.getFavoriteros()) {
            if(user.getCedula().equalsIgnoreCase(cedulaUsuario)){
                publicacionProducto.getFavoriteros().remove(user);
                break;
            }
        }
        return publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();
    }


    public int descontarUnidadesPublicacion(int idPublicacion, int cantidadRestarUnidades) throws Exception{
        PublicacionProducto publicacionProducto = obtenerPublicacionProducto(idPublicacion);
        publicacionProducto.setCantidad(publicacionProducto.getCantidad()-cantidadRestarUnidades);
        return publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();
    }

    @Override
    public List<PublicacionProductoDTO> buscarPublicaciones(String nombreProducto) throws Exception {
        List<PublicacionProducto> publicaciones = publicacionProductoRepo.buscarPublicaciones(nombreProducto, EstadoPublicacion.ACTIVO, false);
        List<PublicacionProductoDTO> publicacionesDTO = new ArrayList<>();
        for (PublicacionProducto pub:
                publicaciones) {
            publicacionesDTO.add(convertir(pub));
        }
        return publicacionesDTO;
    }


    private PublicacionProductoDTO convertir(PublicacionProducto publicacionProducto){

        PublicacionProductoDTO publicacionProductoDTO= new PublicacionProductoDTO();
        publicacionProductoDTO.setProducto(publicacionProducto.getProducto().getId());
        publicacionProductoDTO.setCantidad(publicacionProducto.getCantidad());
        publicacionProductoDTO.setTitulo(publicacionProducto.getTitulo());
        publicacionProductoDTO.setCreador(publicacionProducto.getCreador().getCedula());

        List<String> imagenes = new ArrayList<>();

        for(Imagen e:publicacionProducto.getImagenes()){
            imagenes.add(e.getId());

        }
        publicacionProductoDTO.setIdImagenes(imagenes);

        return  publicacionProductoDTO;
    }
}
