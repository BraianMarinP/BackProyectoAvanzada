package co.edu.uniquindio.moonmarket.controladores;

import co.edu.uniquindio.moonmarket.dto.MensajeDTO;
import co.edu.uniquindio.moonmarket.servicios.implementaciones.CategoriaServicioImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import java.util.List;

@RestController
@RequestMapping("api/categorias")
@AllArgsConstructor

public class CategoriaController {

    private CategoriaServicioImp categoriaServicioImp;

    @GetMapping("/listar")
    public ResponseEntity<MensajeDTO> obtener() throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body( new MensajeDTO(HttpStatus.OK, false, categoriaServicioImp.listarCategorias()));
    }
}
