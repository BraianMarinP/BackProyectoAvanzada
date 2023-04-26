package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.ModeradorDTO;
import co.edu.uniquindio.moonmarket.dto.ModeradorGetDTO;
import co.edu.uniquindio.moonmarket.dto.PersonaDTO;
import co.edu.uniquindio.moonmarket.servicios.interfaces.ModeradorServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class ModeradorTest {
    @Autowired
    private ModeradorServicio moderadorServicio;

    //@Sql("classpath:dataset.sql" )
    @Test
    public void actualizarModeradorTest() {

        /*
        try {
            ModeradorGetDTO moderadorDTO = ModeradorGetDTO.builder().base(PersonaDTO.BaseBuilder().cedula("1234589")
                    .numTel("1234567890")
                    .direccion("Calle 129")
                    .nombre("Juan")
                    .email("juanperrita@example50.com")
                    .build()).build();

            moderadorServicio.actualizarModerador("1234589",moderadorDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Sql("classpath:dataset.sql" )
    @Test
    public void obtenerModeradorTest(){

        try{
            String idBuscada= "1234589";
            String cedula = moderadorServicio.buscarModerador(idBuscada).getCedula();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void cambiarContrasena() throws  Exception{

        String cedulaModerador= moderadorServicio.cambiarContrasena("1234569","Contrasenita05");
    }
*/

    }
}