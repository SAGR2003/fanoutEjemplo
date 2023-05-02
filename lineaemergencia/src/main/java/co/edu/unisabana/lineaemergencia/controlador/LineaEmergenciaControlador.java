package co.edu.unisabana.lineaemergencia.controlador;

import co.edu.unisabana.lineaemergencia.servicio.PublicaEmergenciaServicio;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
@NoArgsConstructor
public class LineaEmergenciaControlador {
    private PublicaEmergenciaServicio emergenciaServicio;

    public LineaEmergenciaControlador(PublicaEmergenciaServicio emergenciaServicio) {
        this.emergenciaServicio = emergenciaServicio;
    }

    @GetMapping("/notifica-direccion/{direccion}")
    public void notificarDireccion(@PathVariable String direccion) {
        emergenciaServicio.crearMensajeEmergencia(direccion);
    }
}
