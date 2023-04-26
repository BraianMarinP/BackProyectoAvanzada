package co.edu.uniquindio.moonmarket;

import co.edu.uniquindio.moonmarket.dto.SesionDTO;
import co.edu.uniquindio.moonmarket.dto.TokenDTO;
import co.edu.uniquindio.moonmarket.servicios.interfaces.SesionServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
public class SesionTest {

    @Autowired
    private SesionServicio sesionServicio;

    @Test
    @Sql("classpath:dataset.sql" )
    public void login() throws Exception{
        SesionDTO sesionDTO= new SesionDTO();
        sesionDTO.setEmail("juanperrita@example50.com");
        sesionDTO.setPassword("Contrasena05");

        TokenDTO tokenGenerado= sesionServicio.login(sesionDTO);
        System.out.println("Token generado");
        System.out.println(tokenGenerado.getToken());

    }
}
