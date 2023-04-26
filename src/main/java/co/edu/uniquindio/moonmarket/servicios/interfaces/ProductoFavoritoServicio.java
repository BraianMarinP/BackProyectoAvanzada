package co.edu.uniquindio.moonmarket.servicios.interfaces;

public interface ProductoFavoritoServicio {

    String agregarFavorito(String cedula, int idPublicacion) throws Exception;

    String eliminarFavorito(String cedula, int idPublicacion) throws Exception;
}
