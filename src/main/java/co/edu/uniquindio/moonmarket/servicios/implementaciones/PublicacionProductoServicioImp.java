package co.edu.uniquindio.moonmarket.servicios.implementaciones;

import co.edu.uniquindio.moonmarket.dto.*;
import co.edu.uniquindio.moonmarket.entidades.*;
import co.edu.uniquindio.moonmarket.repositorios.ImagenRepo;
import co.edu.uniquindio.moonmarket.repositorios.ProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.PublicacionProductoRepo;
import co.edu.uniquindio.moonmarket.repositorios.UsuarioRepo;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CategoriaServicios;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable_;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
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
    private final CategoriaServicioImp categoriaServicioImp;
    private final ProductoServicioImp productoServicioImp;

    @Override
    public int crearPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, String cedulaCreador) throws Exception {

        Producto producto= new Producto();
        producto.setCategorias(new ArrayList<>());
        producto.setNombre(publicacionProductoDTO.getProducto().getNombre());
        producto.setDescripcion(publicacionProductoDTO.getProducto().getDescripcion());
        for (CategoriaDTO categoriaDTO: publicacionProductoDTO.getProducto().getCategorias()) {
            producto.getCategorias().add(categoriaServicioImp.convertir(categoriaDTO));
        }
        int idProducto = productoRepo.save(producto).getId();

        PublicacionProducto publicacionProducto= new PublicacionProducto();
        publicacionProducto.setTitulo(publicacionProductoDTO.getTitulo());
        publicacionProducto.setCreador(usuarioRepo.findById(cedulaCreador).get());
        publicacionProducto.setEstado(EstadoPublicacion.INACTIVO);
        publicacionProducto.setEliminado(false);
        publicacionProducto.setPrecio(publicacionProductoDTO.getPrecio());
        publicacionProducto.setFechaLimite(LocalDateTime.now().plusDays(60));

        List<Imagen> imagenes= new ArrayList<>();

        /*for (String e: publicacionProductoDTO.getIdImagenes()) {
            imagenes.add(imagenRepo.findById(e).get());
        }*/

        publicacionProducto.setImagenes(imagenes);
        publicacionProducto.setCantidad(publicacionProductoDTO.getCantidad());
        publicacionProducto.setProducto(productoRepo.findById(idProducto).get());
        int idPublicacion = publicacionProductoRepo.save(publicacionProducto).getIdPublicacionProducto();
        PublicacionProducto publicaicon = obtenerPublicacionProducto(idPublicacion);

        for (String e: publicacionProductoDTO.getIdImagenes()) {
            Imagen imagen = imagenRepo.findById(e).get();
            imagen.setPublicacion(publicaicon);
            imagenRepo.save(imagen);
        }

        return idPublicacion;
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
    public List<PublicacionProductoDTO> obtenerPublicacionesUsuario(String cedulaUsuario) throws Exception {

        Usuario usuario= usuarioRepo.findById(cedulaUsuario).get();
        List<PublicacionProducto> publicacionProductos = publicacionProductoRepo.obtenerPublicacionesUsuario(cedulaUsuario,false);
        List<PublicacionProductoDTO> publicacionProductosDTO = new ArrayList<>();
        for (PublicacionProducto publicacion: publicacionProductos) {
            publicacionProductosDTO.add(convertir(publicacion));
        }
        return publicacionProductosDTO;
    }

    @Override
    public int actualizarPublicacionProducto(PublicacionProductoDTO publicacionProductoDTO, int idPublicacion, int idProducto) throws Exception {
        PublicacionProducto publicacionProducto = obtenerPublicacionProducto(idPublicacion);

        //Asignamos las imagenes
        for (String e: publicacionProductoDTO.getIdImagenes()) {
            Imagen imagen = imagenRepo.findById(e).get();
            imagen.setPublicacion(publicacionProducto);
            imagenRepo.save(imagen);
        }

        //publicacionProducto.setImagenes(imagenes);
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


    public PublicacionProductoDTO convertir(PublicacionProducto publicacionProducto){
        PublicacionProductoDTO publicacionProductoDTO= new PublicacionProductoDTO();
        ProductoDTO productoDTO = productoServicioImp.convertirProductoDTO(publicacionProducto.getProducto());
        publicacionProductoDTO.setIdPublicacion(publicacionProducto.getIdPublicacionProducto());
        publicacionProductoDTO.setProducto(productoDTO);
        publicacionProductoDTO.setCantidad(publicacionProducto.getCantidad());
        publicacionProductoDTO.setTitulo(publicacionProducto.getTitulo());
        publicacionProductoDTO.setCreador(publicacionProducto.getCreador().getCedula());
        publicacionProductoDTO.setPrecio(publicacionProducto.getPrecio());

        List<String> imagenes = new ArrayList<>();

        for(Imagen e:publicacionProducto.getImagenes()){
            imagenes.add(e.getUrl());

        }
        publicacionProductoDTO.setIdImagenes(imagenes);

        return  publicacionProductoDTO;
    }

    @Override
    public PublicacionProductoDTO buscarPublicacionMasBarataCategoria(String nombreCategoria) throws Exception {
        List<PublicacionProducto> publicacionProducto = publicacionProductoRepo.buscarPublicacionMasBarataCategoria(nombreCategoria, false);
        if(publicacionProducto.size() == 0){
            throw new Exception("No hay productos en esa categoria");
        }
        return convertir(publicacionProducto.get(0));

    }

    @Override
    public PublicacionProductoDTO detallePublicacion(int idPublicacion) throws Exception {
        PublicacionProducto publicacionProducto = obtenerPublicacionProducto(idPublicacion);
        PublicacionProductoDTO publicacionProductoDTO = convertir(publicacionProducto);
        return publicacionProductoDTO;
    }

    @Override
    public PublicacionProductoDTO buscarPublicacionMasCaraCategoria(String nombreCategoria) throws Exception {
        List<PublicacionProducto> publicacionProducto = publicacionProductoRepo.buscarPublicacionMasCaraCategoria(nombreCategoria,false);
        if(publicacionProducto.size() == 0){
            throw new Exception("No hay productos en esa categoria");
        }
        return convertir(publicacionProducto.get(0));
    }


}
