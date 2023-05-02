package co.edu.unisabana.paramedicos.servicio;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ParamedicosServicio {
    @RabbitListener(queues = "filaEmergencias")
    public void alertaEmergencia(String emergencia) {
        System.out.println("Atención a todas las unidades! Llamado de emergencia del sistema 911" + emergencia + "Necesitamos asistencia de inmediato en el área");
        asignarBrigada();
    }

    private void asignarBrigada() {
        System.out.println("La brigada " + (int) ((Math.random() * 9) + 1) + " está en camino");
    }
}