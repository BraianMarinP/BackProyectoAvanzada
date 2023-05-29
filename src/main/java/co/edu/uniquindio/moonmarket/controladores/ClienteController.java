package co.edu.uniquindio.moonmarket.controladores;

import co.edu.uniquindio.moonmarket.dto.*;
import co.edu.uniquindio.moonmarket.servicios.implementaciones.CategoriaServicioImp;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ComentarioServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.CompraServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.PublicacionProductoServicio;
import co.edu.uniquindio.moonmarket.servicios.interfaces.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/usuarios")
@AllArgsConstructor
public class ClienteController {

    private UsuarioServicio usuarioServicio;
    private PublicacionProductoServicio publicacionProductoServicio;
    private CompraServicio compraServicio;
    private ComentarioServicio comentarioServicio;
    private CategoriaServicioImp categoriaServicioImp;

    @GetMapping
    public List<UsuarioGetDTO> listar() throws Exception {
        return usuarioServicio.listarUsuarios();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> obtener(@PathVariable String codigo) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.obtenerUsuario(codigo) ));
    }

    @GetMapping("/usuarioPorCorreo/{correo}")
    public ResponseEntity<MensajeDTO> usuarioPorCorreo(@PathVariable String correo) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, usuarioServicio.usuarioPorCorreo(correo)));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<MensajeDTO> eliminar(@PathVariable String codigo) throws Exception{
        usuarioServicio.eliminiarUsuario(codigo);
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, "Eliminado correctamente" ) );
    }

    @PutMapping("/actualizar")
    public ResponseEntity<MensajeDTO> actualizar(@RequestBody UsuarioGetDTO usuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                usuarioServicio.actualizarUsuario(usuario) ) );
    }

    @PutMapping("/cambiarCon/{codigo}")
    public ResponseEntity<MensajeDTO> cambiarContrasena(@PathVariable String codigo, @RequestParam String nuevaContrasena ) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                usuarioServicio.cambiarContrasena(codigo,nuevaContrasena) ) );
    }

    @PostMapping("/crearPublicacion/{cedulaUsuario}")
    public ResponseEntity<MensajeDTO> crearPublicacion(@PathVariable String cedulaUsuario, @Valid @RequestBody PublicacionProductoDTO publicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                publicacionProductoServicio.crearPublicacionProducto(publicacion, cedulaUsuario)));
    }

    @GetMapping("/misPublicaciones/obtener/{cedula}")
    public ResponseEntity<MensajeDTO> obtenerMisPublicaciones(@PathVariable String cedula) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.obtenerPublicacionesUsuario(cedula)));
    }

    @DeleteMapping("/misPublicaciones/eliminar/{idPublicacion}")
    public ResponseEntity<MensajeDTO> eliminarMiPublicacion(@PathVariable int idPublicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.eliminarPublicacionProducto(idPublicacion)));
    }

    @PutMapping("/misPublicaciones/modificar/{idPublicacion}/{idProducto}")

    public ResponseEntity<MensajeDTO> actualizarMiPublicacion(@PathVariable int idPublicacion, @PathVariable int idProducto, @Valid @RequestBody PublicacionProductoDTO publicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.actualizarPublicacionProducto(publicacion, idPublicacion, idProducto)));
    }

    /*
     @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<MensajeDTO> actualizar(@PathVariable String codigo, @Valid @RequestBody UsuarioGetDTO usuario) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false,
                usuarioServicio.actualizarUsuario(codigo, usuario) ) );
    }
     */

    @GetMapping("/misCompras/obtener/{cedula}")
    public ResponseEntity<MensajeDTO> obtenerMisCompras(@PathVariable String cedula) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, compraServicio.obtenerComprasUsuario(cedula)));
    }

    @GetMapping("/Publicaciones/buscarPublicaciones/{nombre}")
    public ResponseEntity<MensajeDTO> buscarPublicaciones(@PathVariable String nombre) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.buscarPublicaciones(nombre)));
    }

    @GetMapping("/Publicaciones/listar")
    public ResponseEntity<MensajeDTO> listarPublicaciones() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicaciones()));
    }

    @GetMapping("/Publicaciones/listarCategoria/{categoria}")
    public ResponseEntity<MensajeDTO> listarPublicacionesCategoria(@PathVariable String categoria) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionesCategoria(categoria)));
    }

    @GetMapping("/Publicaciones/detallePublicacion/{idPublicacion}")
    public ResponseEntity<MensajeDTO> detallePublicacion(@PathVariable int idPublicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.detallePublicacion(idPublicacion)));
    }

    @PutMapping("/Publicaciones/agregarFavorito/{cedula}/{idPublicacion}")
    public ResponseEntity<MensajeDTO> agregarPublicacionFavoritos(@PathVariable String cedula, @PathVariable int idPublicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.agregarPublicacionAFavoritos(cedula, idPublicacion)));
    }

    @DeleteMapping("/Publicaciones/eliminarFavorito/{cedula}/{idPublicacion}")
    public ResponseEntity<MensajeDTO> eliminarPublicacionFavoritos(@PathVariable String cedula, @PathVariable int idPublicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.eliminarPublicacionDeFavoritos(cedula, idPublicacion)));
    }

    @GetMapping("/Publicaciones/listarMisFavoritos/{cedula}")
    public ResponseEntity<MensajeDTO> listarMisFavoritos(@PathVariable String cedula) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.listarPublicacionesFavoritas(cedula)));
    }

    @PostMapping("/Publicaciones/crearComentario")
    public ResponseEntity<MensajeDTO> crearComentario(@Valid @RequestBody ComentarioDTO comentarioDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, comentarioServicio.crearComentario(comentarioDTO)));
    }

    @GetMapping("/Publicaciones/listarComentarios/{idPublicacion}")
    public ResponseEntity<MensajeDTO> listarComentario(@PathVariable int idPublicacion) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, comentarioServicio.listarComentarios(idPublicacion)));
    }

    @PostMapping("/Comprar")
    public ResponseEntity<MensajeDTO> comprarProducto(@Valid @RequestBody CompraDTO compraDTO) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, compraServicio.crearCompra(compraDTO)));
    }

    @GetMapping("/listar/ProductosComprados/{cedula}")
    public ResponseEntity<MensajeDTO> listarProductosComprados(@PathVariable String cedula){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, usuarioServicio.listarProductosComprados(cedula)));
    }
    
    @GetMapping("/Categorias/contarProductos")
    public ResponseEntity<MensajeDTO> contarPorductosCategoria(){
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, categoriaServicioImp.cantidadProductosCategoria()));
    }

    //*

    @GetMapping("/buscar/barato/{nombreCategoria}")
    public ResponseEntity<MensajeDTO> buscarPublicacionMasBarataCategoria(@PathVariable String nombreCategoria) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.buscarPublicacionMasBarataCategoria(nombreCategoria)));
    }

    @GetMapping("/buscar/caro/{nombreCategoria}")
    public ResponseEntity<MensajeDTO> buscarPublicacionMasCaraCategoria(@PathVariable String nombreCategoria) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(new MensajeDTO(HttpStatus.OK, false, publicacionProductoServicio.buscarPublicacionMasCaraCategoria(nombreCategoria)));
    }
    //*/
}
